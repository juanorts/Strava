package es.deusto.ingenieria.sd.strava.server.data.domain;

import java.util.Date;

public class Challenge {

	private String name;
	private Date startDate;
	private Date endDate;
	private float targetDistance;
	private int targetTime;
	private Sport sport;
	// public static ArrayList<Challenge> challengeArray = new ArrayList<>();

	public Challenge() {
		super();
	}

	public Challenge(String name, Date startDate, Date endDate, float targetDistance, int targetTime, Sport sport) {
		super();
		this.setName(name);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.setTargetDistance(targetDistance);
		this.setTargetTime(targetTime);
		this.setSport(sport);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public float getTargetDistance() {
		return targetDistance;
	}

	public void setTargetDistance(float targetDistance) {
		this.targetDistance = targetDistance;
	}

	public int getTargetTime() {
		return targetTime;
	}

	public void setTargetTime(int targetTime) {
		this.targetTime = targetTime;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public boolean isActive() {
		long millis = System.currentTimeMillis();
		Date currentDate = new java.util.Date(millis);
		int result = currentDate.compareTo(endDate);

		if (result > 0) {
			return false;
		} else {
			return true;
		}

	}

}
