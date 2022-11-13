package es.deusto.ingenieria.sd.strava.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import es.deusto.ingenieria.sd.strava.server.data.dto.ChallengeDTO;
import es.deusto.ingenieria.sd.strava.server.data.dto.TrainingSessionDTO;

public interface IRemoteFacade extends Remote{

	public boolean register(String email, String password, String name, Date birthDate, float weight, int height, int maxBpm,
			int restBpm, String profileType) throws RemoteException;

	public long login(String email, String password, String profileType) throws RemoteException;

	public void logout(long token) throws RemoteException;

	public boolean createChallenge(String name, Date startDate, Date endDate, float targetDistance, int targetTime, String sport, long token) throws RemoteException;

	public boolean createTrainingSession(String title, String sport, float distance, Date startDate, int duration,
			LocalTime startTime, long token) throws RemoteException;

	public List<TrainingSessionDTO> getSportTrainingSessions(String sport, long token) throws RemoteException;

	public List<ChallengeDTO> getActiveChallenges(long token) throws RemoteException;

	public boolean acceptChallenge(String name, long token) throws RemoteException;
	
}
