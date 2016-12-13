package model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class User extends Login implements Observer{
	private String email;
	private String name;
	private ArrayList<Nightclub> following;
	private Nightclub o;
	private UserInvoice userI;
	public User(String email, String name, String username, String password) {
		super(username,password);
		this.email = email;
		this.name = name;
		following = new ArrayList<Nightclub>();
		userI = new UserInvoice();
		following.add(new Nightclub("Spirits1",new Address("89","Birch St","11787","NY"),15,45));
		following.add(new Nightclub("Spirits2",new Address("89","Birch St","11787","NY"),15,45));
		following.add(new Nightclub("Spirits3",new Address("89","Birch St","11787","NY"),15,45));
	}
	public User(String email, String name, String username, String password, Nightclub o) {
		super(username,password);
		this.o = o;
		this.email = email;
		this.name = name;
		o.addObserver(this);
		following.add(o);
	}
	public void setToNotify(Nightclub nc){
		nc.addObserver(this);
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
	
	public ArrayList<Nightclub> getFollowing() {
		return following;
	}
	public void unfollow(Nightclub o){
		if(following.contains(o)){
			following.remove(o);
			o.deleteObserver(this);
		}
	}
	public void buyTicket(String clubName, int price, String purchaser){
		userI.add(new Ticket(clubName,price,purchaser));
	}
	
	public UserInvoice getUserI() {
		return userI;
	}
	@Override
	public void update(Observable o, Object arg) {
		//make a notification pop up for the advertisement
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", name=" + name + ", login=" + super.toString() + "]";
	}
	
	
}
