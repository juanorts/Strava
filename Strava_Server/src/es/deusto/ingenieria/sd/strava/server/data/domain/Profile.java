package es.deusto.ingenieria.sd.strava.server.data.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Profile {

	private String email;
	private String password;
	private String name;
	private Date birthDate;
	private float weight;
	private int height;
	private int maxBPM;
	private int restBPM;
	private ProfileType profileType;
	private List<Challenge> setUpChallenges;
	private List<Challenge> acceptedChallenges;
	private List<TrainingSession> createdTrainingSessions;
	
	public Profile() {
		super();
	}
	
	public Profile(String email, String password, String name, Date birthDate, float weight, int height, int maxBPM, int restBPM, ProfileType profileType) {
		this.setEmail(email);
		this.setPassword(password);
		this.setName(name);
		this.setBirthDate(birthDate);
		this.setWeight(weight);
		this.setHeight(height);
		this.setMaxBPM(maxBPM);
		this.setRestBPM(restBPM);
		this.setProfileType(profileType);
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getMaxBPM() {
		return maxBPM;
	}
	public void setMaxBPM(int maxBPM) {
		this.maxBPM = maxBPM;
	}
	public int getRestBPM() {
		return restBPM;
	}
	public void setRestBPM(int restBPM) {
		this.restBPM = restBPM;
	}
	public ProfileType getProfileType() {
		return profileType;
	}
	public void setProfileType(ProfileType profileType) {
		this.profileType = profileType;
	}
	
	public List<Challenge> getSetUpChallenges() {
		return setUpChallenges;
	}

	public void setSetUpChallenges(List<Challenge> setUpChallenges) {
		this.setUpChallenges = setUpChallenges;
	}

	public List<TrainingSession> getCreatedTrainingSessions() {
		return createdTrainingSessions;
	}

	public void setCreatedTrainingSessions(List<TrainingSession> createdTrainingSessions) {
		this.createdTrainingSessions = createdTrainingSessions;
	}

	public void setAcceptedChallenges(List<Challenge> acceptedChallenges) {
		this.acceptedChallenges = acceptedChallenges;
	}

	@Override
	public String toString() {
		return "Profile [email=" + email + ", password=" + password + ", name=" + name + ", birthDate=" + birthDate
				+ ", weight=" + weight + ", height=" + height + ", maxBPM=" + maxBPM + ", restBPM=" + restBPM
				+ ", profileType=" + profileType + "]";
	}
	
	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}
	
	public List<Challenge> getAcceptedChallenges() {
		return this.acceptedChallenges;
	}
	
	public void acceptChallenge(Challenge c) {
		this.acceptedChallenges.add(c);
	}
	
	public void addTrainingSession(TrainingSession ts) {
		this.createdTrainingSessions.add(ts);
	}
	
	public void addChallenge(Challenge c) {
		this.setUpChallenges.add(c);
	}
}
