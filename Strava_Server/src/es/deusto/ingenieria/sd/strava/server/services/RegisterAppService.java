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
			int maxBpm, int restBpm, ProfileType profileType) {
		Profile profile = new Profile(email, password, name, birthDate, weight, height, maxBpm, restBpm, profileType);
		switch (profileType) {
		case STRAVA:
			if (!StravaLoginAppService.getInstance().getStravaProfileMap().containsKey(email)) {
				StravaLoginAppService.getInstance().addProfile(email, profile);
				return true;
			} else {
				return false;
			}

		case FACEBOOK:
			profile.setPassword(null);
			if (!FacebookLoginAppService.getInstance().getFacebookProfileMap().containsKey(email)) {
				FacebookLoginAppService.getInstance().addProfile(email, profile);
				return true;
			} else {
				return false;
			}
		case GOOGLE:
			profile.setPassword(null);
			if (!GoogleLoginAppService.getInstance().getGoogleProfileMap().containsKey(email)) {
				GoogleLoginAppService.getInstance().addProfile(email, profile); 
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
