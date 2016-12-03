package model;

public class Staff {
	private String jobTitle;
	private String name;
	private String payRate;
	private String phoneNumber;
	public Staff(String jobTitle, String name, String payRate, String phoneNumber) {
		super();
		this.jobTitle = jobTitle;
		this.name = name;
		this.payRate = payRate;
		this.phoneNumber = phoneNumber;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPayRate() {
		return payRate;
	}
	public void setPayRate(String payRate) {
		this.payRate = payRate;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
