package es.deusto.ingenieria.sd.strava.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import es.deusto.ingenieria.sd.strava.server.data.domain.ProfileType;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sport;
import es.deusto.ingenieria.sd.strava.server.data.dto.ChallengeDTO;
import es.deusto.ingenieria.sd.strava.server.data.dto.TrainingSessionDTO;

public interface IRemoteFacade extends Remote{

	public boolean register(String email, String password, String name, Date birthDate, float weight, int height, int maxBpm,
			int restBpm, ProfileType profileType) throws RemoteException;

	public Timestamp login(String email, String password, ProfileType profileType) throws RemoteException;

	public void logout(Timestamp token) throws RemoteException;

	public boolean createChallenge(String name, Date startDate, Date endDate, float targetDistance, int targetTime, Sport sport, Timestamp token) throws RemoteException;

	public boolean createTrainingSession(String title, Sport sport, float distance, Date startDate, int duration,
			Time startTime, Timestamp token) throws RemoteException;

	public List<TrainingSessionDTO> getSportTrainingSessions(Sport sport, Timestamp token) throws RemoteException;

	public List<ChallengeDTO> getActiveChallenges(Timestamp token) throws RemoteException;

	public boolean acceptChallenge(String name, Timestamp token) throws RemoteException;
}
