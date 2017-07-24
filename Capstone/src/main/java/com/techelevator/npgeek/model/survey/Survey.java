package com.techelevator.npgeek.model.survey;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Survey{
	private int surveyId;
	private int votes;
	private String parkName;
	
	@NotEmpty(message="*Select State*")
	private String state;
	
	public String getState(){
		return state;
	}
	public void setState(String state){
		this.state = state;
	}
	
	@NotEmpty(message="*Please select park*")
	private String parkCode;
	
	public String getParkCode(){
		return parkCode;
	}
	public void setParkCode(String parkCode){
		this.parkCode = parkCode;
	}
	@NotBlank(message="*Email is required*")
	@Email(message="*Email must be a valid email address*")
	private String emailAddress;
	
	public String getEmailAddress(){
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress){
		this.emailAddress = emailAddress;
	}
	@NotBlank(message="Required")
	private String activityLevel;
	
	public String getActivityLevel(){
		return activityLevel;
	}
	public void setActivityLevel(String activityLevel){
		this.activityLevel = activityLevel;
	}
	
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}
	
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
}