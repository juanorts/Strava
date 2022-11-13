package es.deusto.ingenieria.sd.strava.server.services;

import java.util.Date;

import es.deusto.ingenieria.sd.strava.server.data.domain.Profile;
import es.deusto.ingenieria.sd.strava.server.data.domain.ProfileType;

public class RegisterAppService {
	private static RegisterAppService instance;

	private RegisterAppService() {
	}

	public static RegisterAppService getInstance() {
		if (instance == null) {
			instance = new RegisterAppService();
		}

		return instance;
	}
	
	public boolean register(String email, String password, String name, Date birthDate, float weight, int height,
			int maxBpm, int restBpm, String profileType) {
		switch (profileType) {
		case "STRAVA":
			Profile profile = new Profile(email, password, name, birthDate, weight, height, maxBpm, restBpm, ProfileType.STRAVA);
			if (!StravaLoginAppService.getInstance().getStravaProfileMap().containsKey(email)) {
				StravaLoginAppService.getInstance().addProfile(email, profile);
				return true;
			} else {
				return false;
			}

		case "FACEBOOK":
			Profile profile1 = new Profile(email, password, name, birthDate, weight, height, maxBpm, restBpm, ProfileType.FACEBOOK);
			profile1.setPassword(null);
			if (!FacebookLoginAppService.getInstance().getFacebookProfileMap().containsKey(email)) {
				FacebookLoginAppService.getInstance().addProfile(email, profile1);
				return true;
			} else {
				return false;
			}
		case "GOOGLE":
			Profile profile11 = new Profile(email, password, name, birthDate, weight, height, maxBpm, restBpm, ProfileType.GOOGLE);
			profile11.setPassword(null);
			if (!GoogleLoginAppService.getInstance().getGoogleProfileMap().containsKey(email)) {
				GoogleLoginAppService.getInstance().addProfile(email, profile11); 
				return true;
			} else {
				return false;
			}

		default:
			break;
		}
		return false;
	}
}
