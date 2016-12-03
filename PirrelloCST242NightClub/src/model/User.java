package model;

import java.util.Observable;
import java.util.Observer;

public class User extends Login implements Observer{
	private String email;
	private String name;
	private Observable o;
	
	public User(String email, String name, String username, String password, Observable o) {
		super(username,password);
		this.o = o;
		this.email = email;
		this.name = name;
		o.addObserver(this);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		//make a notification pop up for the advertisement
	}
	
}
