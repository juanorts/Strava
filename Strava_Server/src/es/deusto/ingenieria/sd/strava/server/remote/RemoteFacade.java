package es.deusto.ingenieria.sd.strava.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.deusto.ingenieria.sd.strava.server.data.domain.Challenge;
import es.deusto.ingenieria.sd.strava.server.data.domain.Profile;
import es.deusto.ingenieria.sd.strava.server.data.domain.TrainingSession;
import es.deusto.ingenieria.sd.strava.server.data.dto.ChallengeAssembler;
import es.deusto.ingenieria.sd.strava.server.data.dto.ChallengeDTO;
import es.deusto.ingenieria.sd.strava.server.data.dto.TrainingSessionAssembler;
import es.deusto.ingenieria.sd.strava.server.data.dto.TrainingSessionDTO;
import es.deusto.ingenieria.sd.strava.server.services.StravaAccountService;
import es.deusto.ingenieria.sd.strava.server.services.StravaAppService;

public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {
	private static final long serialVersionUID = 1L;

	// Data structure for manage Server State
	public Map<Long, Profile> serverState = new HashMap<>();

	public RemoteFacade() throws RemoteException {
		super();
	}

	@Override
	public boolean register(String email, String password, String name, Date birthDate, float weight, int height,
			int maxBpm, int restBpm, String profileType) throws RemoteException {
		System.out.println(" * RemoteFacade register(): " + email);

		if (StravaAccountService.getInstance().register(email, password, name, birthDate, weight, height, maxBpm, restBpm, profileType)) {
			return true;
		} else {
			throw new RemoteException("Register fails, user is already registered!");
		}
	}

	@Override
	public long login(String email, String password, String profileType) throws RemoteException {
		System.out.println(" * RemoteFacade login(): " + email + " / " + password);
		Profile profile = new Profile();
		
		profile = StravaAccountService.getInstance().login(email, password, profileType);
		
		if (profile != null) {
			// If user is not logged in
			if (!this.serverState.values().contains(profile)) {
				long token = Calendar.getInstance().getTimeInMillis();
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
	public synchronized void logout(long token) throws RemoteException {
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
			String sport, long token) throws RemoteException {
		System.out.println(" * RemoteFacade createChallenge(): " + token);
		if (this.serverState.containsKey(token)) {
			return StravaAppService.getInstance().createChallenge(name, startDate, endDate, targetDistance, targetTime,
					sport, this.serverState.get(token));
		} else {
			throw new RemoteException("User is not not logged in!");
		}
	}

	@Override
	public boolean createTrainingSession(String title, String sport, float distance, Date startDate, int duration,
			LocalTime startTime, long token) throws RemoteException {
		System.out.println(" * RemoteFacade createTrainingSession(): " + token);
		if (this.serverState.containsKey(token)) {
			return StravaAppService.getInstance().createTrainingSession(title, sport, distance, startDate, duration,
					startTime, this.serverState.get(token));
		} else {
			throw new RemoteException("User is not not logged in!");
		}
	}

	@Override
	public List<TrainingSessionDTO> getSportTrainingSessions(String sport, long token) throws RemoteException {
		System.out.println(" * RemoteFacade getSportTrainingSessions(): " + token);
		if (this.serverState.containsKey(token)) {
			List<TrainingSession> trainingSessions = StravaAppService.getInstance().getSportTrainingSessions(sport);
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
	public List<ChallengeDTO> getActiveChallenges(long token) throws RemoteException {
		System.out.println(" * RemoteFacade getActiveChallenges(): " + token);
		if (this.serverState.containsKey(token)) {
			List<Challenge> active = StravaAppService.getInstance().getActiveChallenges();
			if (!active.isEmpty()) {
				return ChallengeAssembler.getInstance().challengeToDTO(active);
			} else {
				throw new RemoteException("There are no active challenges");
			}
		} else {
			throw new RemoteException("User is not not logged in!");
		}
	}

	@Override
	public boolean acceptChallenge(String name, long token) throws RemoteException {
		System.out.println(" * RemoteFacade acceptChallenge(): " + token);
		if (this.serverState.containsKey(token)) {
			Profile p = serverState.get(token);
			List<Challenge> active = StravaAppService.getInstance().getActiveChallenges();
			for (Challenge c : active) {
				if (c.getName().equals(name)) {
					StravaAppService.getInstance().acceptChallenge(p, c);
					return true;
				}
			}
			throw new RemoteException("There are no active challenges with the specified name");
		} else {
			throw new RemoteException("User is not not logged in!");
		}
	}

}
