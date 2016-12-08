package controller;

import java.util.ArrayList;

import model.Nightclub;
import model.User;
import model.UserBag;
import view.CreateLoginPane;
import view.LoginPane;
import view.UserPane;
/*
 * for transferring the following list, just make it so when you go to myClubs
 */
public class UserController {
	public UserController(LoginPane view,UserBag uB){
		CreateLoginPane cLP = view.getcTL().getcLP();
		view.setMyEventListener(new MyEventListener(){
			
			@Override
			public void confirmUserCreationButton(MyEventObject ev) {
				uB.add(new User(ev.getEmail(),ev.getName(),ev.getUsername(),ev.getPassword()));
			}

			@Override
			public void passFollowing(MyEventObject ev) {
				User user = uB.find(ev.getUsername());
				if(user != null){
					UserPane uP = ev.getPane();
					ArrayList<Nightclub> nc = user.getFollowing();
					for(int i = 0;i < nc.size();i++){
						System.out.println(nc.get(i).getClubName() + "\n" + nc.get(i).getClubAddress() + "\nTicket Price: " + nc.get(i).getTicketPrice());
						uP.fillNodes(nc.get(i).getClubName() + "\n" + nc.get(i).getClubAddress().toString() + "\nTicket Price: " + nc.get(i).getTicketPrice());
					}
				}
			}
			
		});
	}
}
