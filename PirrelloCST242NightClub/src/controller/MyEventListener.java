package controller;

import java.util.EventListener;

public interface MyEventListener extends EventListener{
	public void confirmUserCreationButton(MyEventObject myEventObject);
	public void passFollowing(MyEventObject myEventObject);
	public void setMyAccount(MyEventObject myEventObject);
	public void editMyAccount(MyEventObject myEventObject);
	public void passThroughInfo(MyEventObject myEventObject);
	public void confirmLogin(MyEventObject myEventObject);
	public void fillTheClubNode(MyEventObject myEventObject);
	public void createAManager(MyEventObject myEventObject);
	public void clubSearchNode(MyEventObject myEventObject);
	public void passFollowThrough(MyEventObject myEventObject);
}
