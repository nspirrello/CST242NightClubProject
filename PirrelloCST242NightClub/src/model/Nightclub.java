package model;

import java.util.ArrayList;
import java.util.Observable;

public class Nightclub extends Observable{
	private String clubName;
	private Address clubAddress;
	private int numOfTables;
	private int ticketPrice;
	private ArrayList<Staff> staff = new ArrayList<Staff>();
	private Advertisment ad;
	public Nightclub(String clubName, Address address, int numOfTables, int ticketPrice) {
		this.clubName = clubName;
		this.clubAddress = address;
		this.numOfTables = numOfTables;
		this.ticketPrice = ticketPrice;
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
	public String getStNum(){
		return clubAddress.getAddNum();
	}
	public String getStName(){
		return clubAddress.getAddName();
	}
	public String getZip(){
		return clubAddress.getZipCode();
	}
	public String getState(){
		return clubAddress.getState();
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
	public ArrayList<Staff> getStaff() {
		return staff;
	}
	public void setStaff(ArrayList<Staff> staff) {
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
