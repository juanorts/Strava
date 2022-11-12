package es.deusto.ingenieria.sd.strava.server.data.domain;

//Optional
public class Progress {

	private float status;
	private float currentDistance;
	private int currentTime;
	private Profile profile;
	private Challenge challenge;
	
	public Progress() {
		super();
	}
	
	public Progress(float currentDistance, int currentTime, Profile profile, Challenge challenge, boolean distance) {
		this.status = calculateStatus(distance);
		this.setCurrentDistance(currentDistance);
		this.setCurrentTime(currentTime);
		this.setProfile(profile);
		this.setChallenge(challenge);
	}

	public float getStatus() {
		return status;
	}

	public void setStatus(float status) {
		this.status = status;
	}

	public float getCurrentDistance() {
		return currentDistance;
	}

	public void setCurrentDistance(float currentDistance) {
		this.currentDistance = currentDistance;
	}

	public int getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(int currentTime) {
		this.currentTime = currentTime;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Challenge getChallenge() {
		return challenge;
	}

	public void setChallenge(Challenge challenge) {
		this.challenge = challenge;
	}
	
	public float calculateStatus(boolean distance) {
		
		int currentDistance = 0;
		int currentTime = 0;
		
		for(TrainingSession ts : this.getProfile().getCreatedTrainingSessions()) {
			int result = ts.getStartTime().compareTo(this.getChallenge().getStartDate());
			if(result >= 0 && distance) {
				currentDistance += ts.getDistance();
				
			} else if(result >= 0 && !distance) {
				currentTime += ts.getDuration();
			}
		}
		
		if(distance) {
			return currentDistance / this.getChallenge().getTargetDistance() * 100;
		} else {
			return currentTime / this.getChallenge().getTargetTime() * 100;
		}
		
	}
	
}
