package model;

public class Advertisment {
	private String clubName;
	private String message;
	
	public Advertisment(String clubName, String message) {
		super();
		this.clubName = clubName;
		this.message = message;
	}
	public String getClubName() {
		return clubName;
	}
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
