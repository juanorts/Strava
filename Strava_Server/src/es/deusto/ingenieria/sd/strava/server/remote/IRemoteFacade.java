package es.deusto.ingenieria.sd.strava.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.security.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import es.deusto.ingenieria.sd.strava.server.data.domain.ProfileType;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sport;
import es.deusto.ingenieria.sd.strava.server.data.dto.ChallengeDTO;

public interface IRemoteFacade extends Remote{

	public boolean register(String email, String password, String name, float weight, int height, int maxBpm,
			int restBpm, ProfileType profileType) throws RemoteException;

	public Timestamp login(String email, String password, ProfileType profileType) throws RemoteException;

	public void logout(Timestamp token) throws RemoteException;

	public boolean createChallenge(String name, Sport sport, LocalDate startDate, LocalDate endDate, int duration,
			LocalDateTime startTime, Timestamp token) throws RemoteException;

	public boolean createTrainingSession(String title, Sport sport, float distance, LocalDate startDate, int duration,
			LocalDateTime startTime, Timestamp token) throws RemoteException;

	public List<TrainingSessionDTO> getSportTrainingSessions(Sport sport, Timestamp token) throws RemoteException;

	public List<ChallengeDTO> getActiveChallenges(Timestamp token) throws RemoteException;

	public boolean acceptChallenge(String name, Timestamp token) throws RemoteException;
}
