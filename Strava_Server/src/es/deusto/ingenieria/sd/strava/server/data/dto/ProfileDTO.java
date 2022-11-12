package es.deusto.ingenieria.sd.strava.server.data.dto;

import java.io.Serializable;
import java.util.Date;

import es.deusto.ingenieria.sd.strava.server.data.domain.ProfileType;

//This class implements DTO pattern
public class ProfileDTO implements Serializable {	
	//This attribute is needed to implement the "Serializable" interface.
	private static final long serialVersionUID = 1L;	
	private String email;
	private String password;
	private String name;
	private Date birthDate;
	private float weight;
	private int height;
	private int maxBPM;
	private int restBPM;
	private ProfileType profileType;
	
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
	
}
