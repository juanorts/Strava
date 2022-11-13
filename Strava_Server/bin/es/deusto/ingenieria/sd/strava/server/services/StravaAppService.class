package es.deusto.ingenieria.sd.strava.server.services;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import es.deusto.ingenieria.sd.strava.server.data.domain.Challenge;
import es.deusto.ingenieria.sd.strava.server.data.domain.Profile;
import es.deusto.ingenieria.sd.strava.server.data.domain.ProfileType;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sport;
import es.deusto.ingenieria.sd.strava.server.data.domain.TrainingSession;
import es.deusto.ingenieria.sd.strava.server.data.dto.ChallengeDTO;
import es.deusto.ingenieria.sd.strava.server.data.dto.TrainingSessionAssembler;
import es.deusto.ingenieria.sd.strava.server.data.dto.TrainingSessionDTO;
import es.deusto.ingenieria.sd.strava.server.services.FacebookLoginAppService;
import es.deusto.ingenieria.sd.strava.server.services.GoogleLoginAppService;
import es.deusto.ingenieria.sd.strava.server.services.StravaLoginAppService;

public class StravaAppService {
	private static StravaAppService instance;

	private StravaAppService() {
	}

	public static StravaAppService getInstance() {
		if (instance == null) {
			instance = new StravaAppService();
		}

		return instance;
	}
	public static List<Challenge> getActiveChallenges(){
		List<Challenge> Active = new ArrayList<Challenge>();
		for (String email : FacebookLoginAppService.FacebookProfileMap.keySet()) {
		    Profile p = FacebookLoginAppService.FacebookProfileMap.get(email);
		    List<Challenge> SetUp = new ArrayList<Challenge>();
		    SetUp = p.getSetUpChallenges();
		    for(Challenge c : SetUp) {
		    	if(c.isActive()) {
		    		Active.add(c);
		    	}
		    	}
		    }
		for (String email : GoogleLoginAppService.GoogleProfileMap.keySet()) {
		    Profile p = GoogleLoginAppService.GoogleProfileMap.get(email);
		    List<Challenge> SetUp = new ArrayList<Challenge>();
		    SetUp = p.getSetUpChallenges();
		    for(Challenge c : SetUp) {
		    	if(c.isActive()) {
		    		Active.add(c);
		    	}
		    	}
		    }
		for (String email : Profile.profilesMap.keySet()) {
		    Profile p = Profile.profilesMap.get(email);
		    List<Challenge> SetUp = new ArrayList<Challenge>();
		    SetUp = p.getSetUpChallenges();
		    for(Challenge c : SetUp) {
		    	if(c.isActive()) {
		    		Active.add(c);
		    	}
		    	}
		    }
		return Active;
	}
	
	public static void acceptChallenge(Profile p, Challenge c) {
		p.addChallenge(c);
		}
}
