package es.deusto.ingenieria.sd.strava.server.data.domain;

import java.util.Date;

public class TrainingSession {

	private String title;
	private Sport sport;
	private float distance;
	private Date startDate;
	private int duration;
	private Date startTime;
	
	public TrainingSession() {
		super();
	}
	
	public TrainingSession(String title, Sport sport, float distance, Date startDate, int duration, Date startTime) {
		this.setTitle(title);
		this.setSport(sport);
		this.setDistance(distance);
		this.setStartDate(startDate);
		this.setDuration(duration);
		this.setStartTime(startTime);
	}

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Override
	public String toString() {
		return "TrainingSession [title=" + title + ", sport=" + sport + ", distance=" + distance + ", startDate="
				+ startDate + ", duration=" + duration + ", startTime=" + startTime + "]";
	}
	
}
