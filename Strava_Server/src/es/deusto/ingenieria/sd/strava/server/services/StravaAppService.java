package es.deusto.ingenieria.sd.strava.server.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import es.deusto.ingenieria.sd.strava.server.data.domain.Challenge;
import es.deusto.ingenieria.sd.strava.server.data.domain.Profile;
import es.deusto.ingenieria.sd.strava.server.data.domain.ProfileType;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sport;
import es.deusto.ingenieria.sd.strava.server.data.domain.TrainingSession;

public class StravaAppService {
	private static StravaAppService instance;

	private StravaAppService() {
		this.initializeData();
	}
	
	private void initializeData() {
		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
		try {
			Date d1 = (Date) format.parse("11-11-2002");
			Date d2 = (Date) format.parse("10-10-2008");
			Date d3 = (Date) format.parse("09-10-2001");
			
			Date d4 = (Date) format.parse("08-09-1999");
			Date d5 = (Date) format.parse("07-03-1987");
			Date d6 = (Date) format.parse("06-06-1965");
			
			Date d7 = (Date) format.parse("05-01-1999");
			Date d8 = (Date) format.parse("04-07-2007");
			Date d9 = (Date) format.parse("03-08-1945");
			
			Date cc1 = (Date) format.parse("01-01-2022");
			Date cc2 = (Date) format.parse("01-02-2022");
			Date cc3 = (Date) format.parse("01-03-2022");
			
			Date cc4 = (Date) format.parse("01-05-2022");
			Date cc5 = (Date) format.parse("01-06-2022");
			Date cc6 = (Date) format.parse("01-07-2022");
			
			Date cc7 = (Date) format.parse("01-08-2022");
			Date cc8 = (Date) format.parse("01-09-2022");
			Date cc9 = (Date) format.parse("01-10-2022");
			
			
			
			Profile p1 = new Profile("pepe@mail.es", "pepe1234", "Pepe", d1, 80.6f, 179, 190, 80, ProfileType.FACEBOOK);
			Profile p2 = new Profile("jose@mail.es", "jose1234", "Jose", d2, 90.6f, 180, 188, 60, ProfileType.FACEBOOK);
			Profile p3 = new Profile("juan@mail.es", "juan1234", "Juan", d3, 100.6f, 169, 181, 70, ProfileType.FACEBOOK);
			
			Profile p4 = new Profile("mikel@mail.es", "mikel1234", "Mikel", d4, 55.6f, 188, 170, 76, ProfileType.GOOGLE);
			Profile p5 = new Profile("alvaro@mail.es", "alvaro1234", "Alvaro", d5, 95.6f, 177, 160, 100, ProfileType.GOOGLE);
			Profile p6 = new Profile("andoni@mail.es", "andoni1234", "Andoni", d6, 74.6f, 198, 175, 89, ProfileType.GOOGLE);
			
			Profile p7 = new Profile("marcelo@mail.es", "marcelo1234", "Marcelo", d7, 86.6f, 201, 183, 78, ProfileType.STRAVA);
			Profile p8 = new Profile("luis@mail.es", "luis1234", "Luis", d8, 81.6f, 179, 180, 88, ProfileType.STRAVA);
			Profile p9 = new Profile("ibai@mail.es", "ibai1234", "Ibai", d9, 67.6f, 172, 173, 59, ProfileType.STRAVA);
			
			Challenge c1 = new Challenge("Running 50Km",cc1,cc2,50,300,Sport.RUNNING);
			Challenge c2 = new Challenge("Running 100Km",cc2,cc3,100,500,Sport.RUNNING);
			Challenge c3 = new Challenge("Running 150KM",cc3,cc4,150,800,Sport.RUNNING);
			
			Challenge c4 = new Challenge("Cycling 100KM",cc4,cc5,100,150,Sport.CYCLING);
			Challenge c5 = new Challenge("Cycling 150KM",cc5,cc6,150,250,Sport.CYCLING);
			Challenge c6 = new Challenge("Cycling 200KM",cc6,cc7,200,400,Sport.CYCLING);
			
			Challenge c7 = new Challenge("Running and Cycling 250",cc7,cc8,250,600,Sport.BOTH);
			Challenge c8 = new Challenge("Running and Cycling 150",cc8,cc9,150,400,Sport.BOTH);
			Challenge c9 = new Challenge("Running and Cycling 350",cc7,cc9,350,800,Sport.BOTH);
			
			LocalTime tt1 = LocalTime.NOON;
			LocalTime tt2 = LocalTime.now();
			LocalTime tt3 = LocalTime.of(10, 40);
			
			TrainingSession t1 = new TrainingSession("Day1",Sport.BOTH,20.0f,60,cc1,tt1);
			TrainingSession t2 = new TrainingSession("Day1",Sport.BOTH,30.0f,90,cc2,tt2);
			TrainingSession t3 = new TrainingSession("Day1",Sport.BOTH,40.0f,90,cc1,tt3);
			TrainingSession t4 = new TrainingSession("Day1",Sport.CYCLING,20.0f,45,cc2,tt1);
			TrainingSession t5 = new TrainingSession("Day1",Sport.CYCLING,35.0f,45,cc1,tt2);
			TrainingSession t6 = new TrainingSession("Day1",Sport.CYCLING,69.0f,90,cc2,tt3);
			TrainingSession t7 = new TrainingSession("Day1",Sport.RUNNING,15.0f,40,cc2,tt1);
			TrainingSession t8 = new TrainingSession("Day1",Sport.RUNNING,15.0f,50,cc3,tt2);
			TrainingSession t9 = new TrainingSession("Day1",Sport.RUNNING,30.0f,120,cc4,tt3);
			
			p1.addChallenge(c1);
			p2.addChallenge(c2);
			p3.addChallenge(c3);
			p4.addChallenge(c4);
			p5.addChallenge(c5);
			p6.addChallenge(c6);
			p7.addChallenge(c7);
			p8.addChallenge(c8);
			p9.addChallenge(c9);
			
			p1.addTrainingSession(t1);
			p2.addTrainingSession(t2);
			p3.addTrainingSession(t3);
			p4.addTrainingSession(t4);
			p5.addTrainingSession(t5);
			p6.addTrainingSession(t6);
			p7.addTrainingSession(t7);
			p8.addTrainingSession(t8);
			p9.addTrainingSession(t9);
			
			FacebookLoginAppService.getInstance().addProfile(p1.getEmail(), p1);
			FacebookLoginAppService.getInstance().addProfile(p2.getEmail(), p2);
			FacebookLoginAppService.getInstance().addProfile(p3.getEmail(), p3);
			
			GoogleLoginAppService.getInstance().addProfile(p4.getEmail(), p4);
			GoogleLoginAppService.getInstance().addProfile(p5.getEmail(), p5);
			GoogleLoginAppService.getInstance().addProfile(p6.getEmail(), p6);
			
			StravaLoginAppService.getInstance().addProfile(p7.getEmail(), p7);
			StravaLoginAppService.getInstance().addProfile(p8.getEmail(), p8);
			StravaLoginAppService.getInstance().addProfile(p9.getEmail(), p9);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static StravaAppService getInstance() {
		if (instance == null) {
			instance = new StravaAppService();
		}

		return instance;
	}

	public boolean createChallenge(String name, Date startDate, Date endDate, float targetDistance, int targetTime,
			Sport sport, Profile profile) {

		Challenge challenge = new Challenge(name, startDate, endDate, targetDistance, targetTime, sport);
		profile.addChallenge(challenge);
		return true;
	}

	public boolean createTrainingSession(String title, Sport sport, float distance, Date startDate, int duration,
			LocalTime startTime, Profile profile) {

		TrainingSession trainingSession = new TrainingSession(title, sport, distance, duration, startDate, startTime);
		profile.addTrainingSession(trainingSession);
		return true;
	}

	public List<TrainingSession> getSportTrainingSessions(Sport sport) {
		List<TrainingSession> trainingSessions = new ArrayList<>();
		for (Profile profile : StravaAppService.getInstance().retrieveProfiles()) {
			if (!profile.getCreatedTrainingSessions().isEmpty()) {
				for (TrainingSession trainingSession : profile.getCreatedTrainingSessions()) {
					if (trainingSession.getSport().equals(sport)) {
						trainingSessions.add(trainingSession);
					}
				}
			}
		}
		return trainingSessions;
	}

	public List<Challenge> getActiveChallenges() {
		List<Challenge> Active = new ArrayList<Challenge>();

		for (Profile profile : StravaAppService.getInstance().retrieveProfiles()) {
			for (Challenge c : profile.getSetUpChallenges()) {
				if (c.isActive()) {
					Active.add(c);
				}
			}
		}
		return Active;
	}

	public void acceptChallenge(Profile p, Challenge c) {
		p.addChallenge(c);
	}

	// Auxiliary method to gather all the profiles in the AppServices, due to no DAO
	public List<Profile> retrieveProfiles() {
		List<Profile> profileList = new ArrayList<>();
		for (Profile profile : StravaLoginAppService.getInstance().getStravaProfileMap().values()) {
			profileList.add(profile);
		}
		for (Profile profile : FacebookLoginAppService.getInstance().getFacebookProfileMap().values()) {
			profileList.add(profile);
		}
		for (Profile profile : GoogleLoginAppService.getInstance().getGoogleProfileMap().values()) {
			profileList.add(profile);
		}

		return profileList;
	}
}
