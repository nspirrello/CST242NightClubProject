package model;

public class Address {
	private String addNum;
	private String addName;
	private String zipCode;
	private String state;
	public Address(String addNum, String addName, String zipCode, String state) {
		super();
		this.addNum = addNum;
		this.addName = addName;
		this.zipCode = zipCode;
		this.state = state;
	}
	public String getAddNum() {
		return addNum;
	}
	public void setAddNum(String addNum) {
		this.addNum = addNum;
	}
	public String getAddName() {
		return addName;
	}
	public void setAddName(String addName) {
		this.addName = addName;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return addNum + " " + addName + " " + zipCode + " " + state;
	}
	
}
