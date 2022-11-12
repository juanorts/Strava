package es.deusto.ingenieria.sd.strava.server.data.dto;

import es.deusto.ingenieria.sd.strava.server.data.domain.Profile;

//This class is part of the DTO pattern. It also implements Singleton Pattern.
public class ProfileAssembler {
	private static ProfileAssembler instance;

	private ProfileAssembler() { }
	
	public static ProfileAssembler getInstance() {
		if (instance == null) {
			instance = new ProfileAssembler();
		}

		return instance;
	}

	public ProfileDTO profileToDTO(Profile profile) {
		ProfileDTO dto = new ProfileDTO();
		
		dto.setEmail(profile.getEmail());
		dto.setPassword(profile.getPassword());
		dto.setName(profile.getName());
		dto.setBirthDate(profile.getBirthDate());
		dto.setWeight(profile.getWeight());
		dto.setHeight(profile.getHeight());
		dto.setMaxBPM(profile.getMaxBPM());
		dto.setRestBPM(profile.getRestBPM());
		dto.setProfileType(profile.getProfileType());
		
		return dto;
	}
}