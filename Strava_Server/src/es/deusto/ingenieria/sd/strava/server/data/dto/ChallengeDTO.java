package es.deusto.ingenieria.sd.strava.server.data.dto;

import java.io.Serializable;
import java.util.Date;


//This class implements DTO pattern
public class ChallengeDTO implements Serializable {	
	//This attribute is needed to implement the "Serializable" interface.
	private static final long serialVersionUID = 1L;
	private String name;
	private Date startDate;
	private Date endDate;
	private float targetDistance;
	private int targetTime;
	private String sport;
	
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
	public String getSport() {
		return sport;
	}
	public void setSport(String sport) {
		this.sport = sport;
	}
	
}