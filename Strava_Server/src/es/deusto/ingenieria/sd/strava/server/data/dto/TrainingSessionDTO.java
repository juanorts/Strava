package es.deusto.ingenieria.sd.strava.server.data.dto;

import java.io.Serializable;
import java.time.LocalTime;

import es.deusto.ingenieria.sd.strava.server.data.domain.Sport;

//This class implements DTO pattern
public class TrainingSessionDTO implements Serializable {	
	//This attribute is needed to implement the "Serializable" interface.
	private static final long serialVersionUID = 1L;	
	
	private String title;
	private Sport sport;
	private float distance;
	private int duration;
	private LocalTime startTime;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Sport getSport() {
		return sport;
	}
	public void setSport(Sport sport) {
		this.sport = sport;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	
}