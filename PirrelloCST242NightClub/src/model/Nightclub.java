package model;

import java.util.Observable;

public class Nightclub extends Observable{
	private String clubName;
	private Address clubAddress;
	private int numOfTables;
	private int ticketPrice;
	private Staff[] staff;
	private Advertisment ad;
	public Nightclub(String clubName, Address clubAddress, int numOfTables, int ticketPrice, Staff[] staff) {
		super();
		this.clubName = clubName;
		this.clubAddress = clubAddress;
		this.numOfTables = numOfTables;
		this.ticketPrice = ticketPrice;
		this.staff = staff;
	}
	public String getClubName() {
		return clubName;
	}
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	public Address getClubAddress() {
		return clubAddress;
	}
	public void setClubAddress(Address clubAddress) {
		this.clubAddress = clubAddress;
	}
	public int getNumOfTables() {
		return numOfTables;
	}
	public void setNumOfTables(int numOfTables) {
		this.numOfTables = numOfTables;
	}
	public int getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public Staff[] getStaff() {
		return staff;
	}
	public void setStaff(Staff[] staff) {
		this.staff = staff;
	}
	public Advertisment getAd() {
		return ad;
	}
	public void setAd(Advertisment ad) {
		this.ad = ad;
		notifyObservers();
	}
	
}
