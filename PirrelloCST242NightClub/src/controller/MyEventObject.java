package controller;

import java.util.EventObject;

import model.User;
import view.UserPane;

public class MyEventObject extends EventObject{
	private String username;
	private String password;
	private String name;
	private String email;

	
	
	public MyEventObject(Object source) {
		super(source);
	}
	public MyEventObject(Object source, String username, String password, String name, String email){
		super(source);
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	private UserPane pane;
	public MyEventObject(Object source, String username, UserPane pane){
		super(source);
		this.username = username;
		this.pane = pane;
	}
	public UserPane getPane() {
		return pane;
	}
	
	

}
