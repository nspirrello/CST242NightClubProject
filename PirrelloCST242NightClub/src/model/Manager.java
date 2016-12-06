package model;

public class Manager extends Login{
	private Nightclub nightClub;
	private String name;
	private String phoneNumber;
	public Manager(Nightclub nightClub, String name, String phoneNumber) {
		super();
		this.nightClub = nightClub;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	public Nightclub getNightClub() {
		return nightClub;
	}
	public void setNightClub(Nightclub nightClub) {
		
		this.nightClub = nightClub;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
