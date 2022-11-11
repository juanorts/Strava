package es.deusto.ingenieria.sd.strava.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.deusto.ingenieria.sd.strava.server.data.domain.Profile;
import es.deusto.ingenieria.sd.strava.server.data.domain.ProfileType;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sport;
import es.deusto.ingenieria.sd.strava.server.data.dto.ChallengeDTO;

public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {
	private static final long serialVersionUID = 1L;

	// Data structure for manage Server State
	public Map<Long, Profile> serverState = new HashMap<>();

	public RemoteFacade() throws RemoteException {
		super();
	}

	@Override
	public boolean register(String email, String password, String name, float weight, int height, int maxBpm,
			int restBpm, ProfileType profileType) {
		switch (profileType) {
		case STRAVA:

		case FACEBOOK:

		case GOOGLE:

		default:
			break;
		}
		return false;
	}

	@Override
	public Timestamp login(String email, String password, ProfileType profileType) {
		// TODO Auto-generated method stub
		switch (profileType) {
		case STRAVA:

		case FACEBOOK:

		case GOOGLE:

		default:
			break;
		}
		return null;
	}

	@Override
	public void logout(Timestamp token) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean createChallenge(String name, Sport sport, LocalDate startDate, LocalDate endDate, int duration,
			LocalDateTime startTime, Timestamp token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createTrainingSession(String title, Sport sport, float distance, LocalDate startDate, int duration,
			LocalDateTime startTime, Timestamp token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TrainingSessionDTO> getSportTrainingSessions(Sport sport, Timestamp token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChallengeDTO> getActiveChallenges(Timestamp token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean acceptChallenge(String name, Timestamp token) {
		// TODO Auto-generated method stub
		return false;
	}

}
