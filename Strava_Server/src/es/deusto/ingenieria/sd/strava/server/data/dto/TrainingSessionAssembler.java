package es.deusto.ingenieria.sd.strava.server.data.dto;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.strava.server.data.domain.TrainingSession;

//This class is part of the DTO pattern. It also implements Singleton Pattern.
public class TrainingSessionAssembler {
	private static TrainingSessionAssembler instance;

	private TrainingSessionAssembler() { }
	
	public static TrainingSessionAssembler getInstance() {
		if (instance == null) {
			instance = new TrainingSessionAssembler();
		}

		return instance;
	}

	public TrainingSessionDTO trainingSessionToDTO(TrainingSession ts) {
		TrainingSessionDTO dto = new TrainingSessionDTO();
		
		dto.setTitle(ts.getTitle());
		dto.setSport(ts.getSport());
		dto.setDistance(ts.getDistance());
		dto.setDuration(ts.getDuration());
		dto.setStartTime(ts.getStartTime());
		
		return dto;
	}
	
	public List<TrainingSessionDTO> trainingSessionToDTO(List <TrainingSession> lts){
		List<TrainingSessionDTO> dtos = new ArrayList<TrainingSessionDTO>();
		
		for(TrainingSession ts : lts) {
			TrainingSessionDTO dto = trainingSessionToDTO(ts);
			dtos.add(dto);
		}
		
		return dtos;	
		
	}
	
}