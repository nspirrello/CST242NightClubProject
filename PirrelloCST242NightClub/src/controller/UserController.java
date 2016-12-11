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
						uP.fillNodes(nc.get(i).getClubName() + "\n" + nc.get(i).getClubAddress().toString() + "\nTicket Price: " + nc.get(i).getTicketPrice(),nc.get(i).getClubName());
					}
				}
			}
			
			public void setMyAccount(MyEventObject ev){
				UserPane uP = ev.getPane();
//				uB.find(ev.getUsername()).setName(ev.getName());
//				uB.find(ev.getUsername()).setEmail(ev.getEmail());
//				uB.find(ev.getUsername()).setUsername(ev.getUsername());
//				uB.find(ev.getUsername()).setPassword(ev.getPassword());
				User user = uB.find(ev.getUsername());
				uP.getEmailF().setText(user.getEmail());;
				uP.setNameF(user.getName());
				uP.setUsernameF(user.getUsername());
				uP.setPasswordF(user.getPassword());
			}
			
			public void editMyAccount(MyEventObject ev){
				UserPane uP = ev.getPane();
				System.out.println(uB.find(ev.getOldName()));
				System.out.println(uP.getNameF().getText());
				User user = uB.find(ev.getOldName());
				user.setEmail(ev.getEmail());
				user.setName(ev.getName());
				user.setPassword(ev.getPassword());
				user.setUsername(ev.getUsername());
			}

			@Override
			public void passThroughInfo(MyEventObject ev) {
				//for the ClubNodes removal from user's Following arraylist
				User user = uB.find(ev.getUsername());
				Nightclub nc = null;
				ArrayList<Nightclub> ncal = user.getFollowing();
				for(int i = 0;i < ncal.size();i++){
					if(ncal.get(i).getClubName().equals(ev.getNightclub())){
						nc = ncal.get(i);
					}
				}
				user.getFollowing().remove(nc);
			}
			
		});
	}
}
