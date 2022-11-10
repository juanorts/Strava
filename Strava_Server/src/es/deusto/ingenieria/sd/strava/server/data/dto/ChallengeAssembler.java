package es.deusto.ingenieria.sd.strava.server.data.dto;

import es.deusto.ingenieria.sd.strava.server.data.domain.Challenge;

//This class is part of the DTO pattern. It also implements Singleton Pattern.
public class ChallengeAssembler {
	private static ChallengeAssembler instance;

	private ChallengeAssembler() { }
	
	public static ChallengeAssembler getInstance() {
		if (instance == null) {
			instance = new ChallengeAssembler();
		}

		return instance;
	}

	public ChallengeDTO challengeToDTO(Challenge challenge) {
		ChallengeDTO dto = new ChallengeDTO();
		
		dto.setName(challenge.getName());
		dto.setStartDate(challenge.getStartDate());
		dto.setEndDate(challenge.getEndDate());
		dto.setTargetDistance(challenge.getTargetDistance());
		dto.setTargetTime(challenge.getTargetTime());
		dto.setSport(challenge.getSport());
		
		return dto;
	}
}