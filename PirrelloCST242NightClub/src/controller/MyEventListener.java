package controller;

import java.util.EventListener;

public interface MyEventListener extends EventListener{
	public void confirmUserCreationButton(MyEventObject myEventObject);
	public void passFollowing(MyEventObject myEventObject);
}
