package es.deusto.ingenieria.sd.strava.server.test;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;


import es.deusto.ingenieria.sd.strava.server.data.dto.ChallengeDTO;
import es.deusto.ingenieria.sd.strava.server.data.dto.TrainingSessionDTO;
import es.deusto.ingenieria.sd.strava.server.remote.RemoteFacade;
import es.deusto.ingenieria.sd.strava.server.services.StravaLoginAppService;

public class LocalTest {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		RemoteFacade facade = null;
		List<TrainingSessionDTO> sportTrainingSessions = null;
		List<ChallengeDTO> activeChallenges = null;
		
		try {
			facade = new RemoteFacade();
			System.out.println((StravaLoginAppService.getInstance() == null));
			// Test Register
			System.out.println("User was registered in test succesfully: " + facade.register("ruben@hotmail.es", "ruta76", "Ruben", new Date(2000, 8, 2), 80, 185, 200, 50, "STRAVA"));
			// Test Login
			long token = facade.login("ruben@hotmail.es", "ruta76", "STRAVA");
			System.out.println("Test user with mail ruben@hotmail.es login with token : " + token);
			// Test Logout
			facade.logout(token);
			System.out.println("Test user with mail ruben@hotmail.es logout");
			// Test Login Facebook/Google
			token = facade.login("alvaro@mail.es", "alvaro1234", "GOOGLE");
			System.out.println("Test user with mail alvaro@mail.es login with token : " + token);
			// Test Create Challenge
			System.out.println("Test user with mail alvaro@mail.es created a challenge succesfully : " + facade.createChallenge("Run4Ever", new Date(2000, 8, 2), new Date(2000, 9, 2), 0, 60, "BOTH", token));
			// Test Create TSession
			System.out.println("Test user with mail alvaro@mail.es created a Training Session succesfully : " + facade.createTrainingSession("FirstSession", "RUNNING", 0, new Date(2000, 8, 2), 60, LocalTime.now(), token));
			// Test getSportTrainingSessions
			sportTrainingSessions = facade.getSportTrainingSessions("RUNNING", token);
			System.out.println("Test user with mail alvaro@mail.es received the training sessions of the specified sport : ");
			for (TrainingSessionDTO session : sportTrainingSessions) {
				System.out.println("----------------------------");
				System.out.println(session.getTitle());
				System.out.println("----------------------------");
			}
			// Test getActiveChallenges
			activeChallenges = facade.getActiveChallenges(token);
			System.out.println("Test user with mail alvaro@mail.es received the active challenges : ");
			for (ChallengeDTO chal : activeChallenges) {
				System.out.println("----------------------------");
				System.out.println(chal.getName());
				System.out.println("----------------------------");
			}
			// Test acceptChallenge
			System.out.println("Test user with mail alvaro@mail.es accepted a challenge succesfully : " + facade.acceptChallenge("Cycling 100KM", token));
		} catch (Exception e){
			System.out.println("\t# Error: " + e.getMessage());
		}
		System.exit(0);
	}
}
/*
 * 
 * public boolean register(String email, String password, String name, Date birthDate, float weight, int height, int maxBpm,
			int restBpm, ProfileType profileType) throws RemoteException;

	public long login(String email, String password, ProfileType profileType) throws RemoteException;

	public void logout(long token) throws RemoteException;

	public boolean createChallenge(String name, Date startDate, Date endDate, float targetDistance, int targetTime, Sport sport, long token) throws RemoteException;

	public boolean createTrainingSession(String title, Sport sport, float distance, Date startDate, int duration,
			LocalTime startTime, long token) throws RemoteException;

	public List<TrainingSessionDTO> getSportTrainingSessions(Sport sport, long token) throws RemoteException;

	public List<ChallengeDTO> getActiveChallenges(long token) throws RemoteException;

	public boolean acceptChallenge(String name, long token) throws RemoteException;
 * 
 */