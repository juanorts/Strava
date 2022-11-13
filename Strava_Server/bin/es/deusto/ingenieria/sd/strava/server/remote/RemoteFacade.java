package es.deusto.ingenieria.sd.strava.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.deusto.ingenieria.sd.strava.server.data.domain.Challenge;
import es.deusto.ingenieria.sd.strava.server.data.domain.Profile;
import es.deusto.ingenieria.sd.strava.server.data.domain.ProfileType;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sport;
import es.deusto.ingenieria.sd.strava.server.data.domain.TrainingSession;
import es.deusto.ingenieria.sd.strava.server.data.dto.ChallengeAssembler;
import es.deusto.ingenieria.sd.strava.server.data.dto.ChallengeDTO;
import es.deusto.ingenieria.sd.strava.server.data.dto.TrainingSessionAssembler;
import es.deusto.ingenieria.sd.strava.server.data.dto.TrainingSessionDTO;
import es.deusto.ingenieria.sd.strava.server.services.FacebookLoginAppService;
import es.deusto.ingenieria.sd.strava.server.services.GoogleLoginAppService;
import es.deusto.ingenieria.sd.strava.server.services.StravaLoginAppService;
import es.deusto.ingenieria.sd.strava.server.services.StravaAppService;


public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {
	private static final long serialVersionUID = 1L;

	// Data structure for manage Server State
	public Map<Timestamp, Profile> serverState = new HashMap<>();

	public RemoteFacade() throws RemoteException {
		super();
	}

	@Override
	public boolean register(String email, String password, String name, Date birthDate, float weight, int height,
			int maxBpm, int restBpm, ProfileType profileType) throws RemoteException {
		System.out.println(" * RemoteFacade register(): " + email);
		Profile profile = new Profile(email, password, name, birthDate, weight, height, maxBpm, restBpm, profileType);
		switch (profileType) {
		case STRAVA:
			if (!Profile.profilesMap.containsKey(email)) {
				Profile.profilesMap.put(email, profile);
				return true;
			} else {
				throw new RemoteException("User is already registered!");
			}

		case FACEBOOK:
			profile.setPassword(null);
			if (!FacebookLoginAppService.FacebookProfileMap.containsKey(email)) {
				FacebookLoginAppService.FacebookProfileMap.put(email, profile);
				return true;
			} else {
				throw new RemoteException("User is already registered!");
			}
		case GOOGLE:
			profile.setPassword(null);
			if (!GoogleLoginAppService.GoogleProfileMap.containsKey(email)) {
				GoogleLoginAppService.GoogleProfileMap.put(email, profile);
				return true;
			} else {
				throw new RemoteException("User is already registered!");
			}

		default:
			break;
		}
		return false;
	}

	@Override
	public Timestamp login(String email, String password, ProfileType profileType) throws RemoteException {
		System.out.println(" * RemoteFacade login(): " + email + " / " + password);
		Profile profile = new Profile();
		switch (profileType) {
		case STRAVA:
			profile = StravaLoginAppService.getInstance().login(email, password);

		case FACEBOOK:
			profile = FacebookLoginAppService.getInstance().login(email, password);

		case GOOGLE:
			profile = GoogleLoginAppService.getInstance().login(email, password);

		default:
			break;
		}
		if (profile != null) {
			// If user is not logged in
			if (!this.serverState.values().contains(profile)) {
				Timestamp token = new Timestamp(Calendar.getInstance().getTimeInMillis());
				this.serverState.put(token, profile);
				return (token);
			} else {
				throw new RemoteException("User is already logged in!");
			}
		} else {
			throw new RemoteException("Login fails!");
		}
	}

	@Override
	public synchronized void logout(Timestamp token) throws RemoteException {
		System.out.println(" * RemoteFacade logout(): " + token);

		if (this.serverState.containsKey(token)) {
			// Logout means remove the User from Server State
			this.serverState.remove(token);
		} else {
			throw new RemoteException("User is not not logged in!");
		}

	}

	@Override
	public boolean createChallenge(String name, Date startDate, Date endDate, float targetDistance, int targetTime,
			Sport sport, Timestamp token) throws RemoteException {
		System.out.println(" * RemoteFacade createChallenge(): " + token);
		if (this.serverState.containsKey(token)) {
			Challenge challenge = new Challenge(name, startDate, endDate, targetDistance, targetTime, sport);
			Profile profile = this.serverState.get(token);
			List<Challenge> setUpChallenges = profile.getSetUpChallenges();
			setUpChallenges.add(challenge);
			profile.setSetUpChallenges(setUpChallenges);
			return true;
		} else {
			throw new RemoteException("User is not not logged in!");
		}
	}

	@Override
	public boolean createTrainingSession(String title, Sport sport, float distance, Date startDate, int duration,
			Time startTime, Timestamp token) throws RemoteException {
		System.out.println(" * RemoteFacade createTrainingSession(): " + token);
		if (this.serverState.containsKey(token)) {
			TrainingSession trainingSession = new TrainingSession(title, sport, distance, duration, startDate,
					startTime);
			Profile profile = this.serverState.get(token);
			List<TrainingSession> createdTrainingSessions = profile.getCreatedTrainingSessions();
			createdTrainingSessions.add(trainingSession);
			profile.setCreatedTrainingSessions(createdTrainingSessions);
			return true;
		} else {
			throw new RemoteException("User is not not logged in!");
		}
	}

	@Override
	public List<TrainingSessionDTO> getSportTrainingSessions(Sport sport, Timestamp token) throws RemoteException {
		System.out.println(" * RemoteFacade getSportTrainingSessions(): " + token);
		if (this.serverState.containsKey(token)) {
			List<TrainingSession> trainingSessions = new ArrayList<>();
			for (Profile profile : this.serverState.values()) {
				if (!profile.getCreatedTrainingSessions().isEmpty()) {
					for (TrainingSession trainingSession : profile.getCreatedTrainingSessions()) {
						if (trainingSession.getSport().equals(sport)) {
							trainingSessions.add(trainingSession);
						}
					}
				}
			}
			if (trainingSessions.isEmpty()) {
				throw new RemoteException("There are no sessions of the specified sport!");
			} else {
				return TrainingSessionAssembler.getInstance().trainingSessionToDTO(trainingSessions);
			}
		} else {
			throw new RemoteException("User is not not logged in!");
		}
	}

	@Override
	public List<ChallengeDTO> getActiveChallenges(Timestamp token) {
		List<Challenge> Active = StravaAppService.getActiveChallenges();
		return ChallengeAssembler.getInstance().challengeToDTO(Active);
	}

	@Override
	public boolean acceptChallenge(String name, Timestamp token) {
		Profile p = serverState.get(token);
		List<Challenge> Active = StravaAppService.getActiveChallenges();
		for(Challenge c : Active) {
			if(c.getName().equals(name)){
				StravaAppService.acceptChallenge(p, c);
				return true;
			}
		}
		return false;
	}

}
