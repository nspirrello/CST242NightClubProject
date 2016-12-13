package controller;

import java.util.EventObject;

import javafx.scene.control.TextArea;
import model.Nightclub;
import view.ClubNodes;
import view.UserPane;

public class MyEventObject extends EventObject{
	private String username;
	private String password;
	private String name;
	private String email;
	private String oldName;
	private UserPane pane;
	private String nightclub;
	private ClubNodes clubNode;
	private Nightclub nc;
	private String phone;
	
	public MyEventObject(Object source) {
		super(source);
	}
	public MyEventObject(Object source, String nc, ClubNodes clubNode){
		super(source);
		this.nightclub = nc;
		this.clubNode = clubNode;
	}
	public MyEventObject(String nightclub ,Object source, String username){
		super(source);
		this.nightclub = nightclub;
		this.username = username;
	}
	public MyEventObject(Object source, String username, String password, String name, String email){
		super(source);
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	public MyEventObject(Object source, String username, UserPane pane){
		super(source);
		this.username = username;
		this.pane = pane;
	}
	public MyEventObject(String username, String password, Object source){
		super(source);
		this.username = username;
		this.password = password;
	}
	public MyEventObject(Object source, String username){
		super(source);
		this.username = username;
	}
	public MyEventObject(Object source, String username, String nightclub){
		super(source);
		this.username = username;
		this.nightclub = nightclub;
	}
	public MyEventObject(Object source, String username, String password, String name, String email, String oldName, UserPane pane){
		super(source);
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.oldName = oldName;
		this.pane = pane;
	}
	public MyEventObject(Object source,UserPane uP, String username){
		super(source);
		this.pane = uP;
		this.username = username;
	}
	public MyEventObject(Object source,UserPane uP, String username, String nightclub){
		super(source);
		this.pane = uP;
		this.username = username;
		this.nightclub = nightclub;
	}
	public MyEventObject(Object source, String name, String phone, String username, String password, Nightclub nc) {
		super(source);
		this.name = name;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.nc = nc;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Nightclub getNc() {
		return nc;
	}
	public UserPane getPane() {
		return pane;
	}
	public String getOldName() {
		return oldName;
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
	public String getNightclub() {
		return nightclub;
	}
	public ClubNodes getClubNode() {
		return clubNode;
	}
	public void setClubNode(ClubNodes clubNode) {
		this.clubNode = clubNode;
	}
	
}
