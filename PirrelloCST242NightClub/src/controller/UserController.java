package controller;

import java.util.ArrayList;

import model.Manager;
import model.ManagerBag;
import model.Nightclub;
import model.NightclubBag;
import model.User;
import model.UserBag;
import view.ClubNodes;
import view.LoginPane;
import view.UserPane;
/*
 * for transferring the following list, just make it so when you go to myClubs
 */
public class UserController {
	public UserController(LoginPane view, UserBag uB, NightclubBag ncB, ManagerBag mB){
		view.setMyEventListener(new MyEventListener(){
			
			@Override
			public void confirmUserCreationButton(MyEventObject ev) {
				uB.add(new User(ev.getEmail(),ev.getName(),ev.getUsername(),ev.getPassword()));
			}

			@Override
			public void passFollowing(MyEventObject ev) {
				User user = (User) uB.find(ev.getUsername());
				if(user != null){
					UserPane uP = ev.getPane();
					ArrayList<Nightclub> nc = user.getFollowing();
					for(int i = 0;i < nc.size();i++){
						uP.fillNodes(nc.get(i).getClubName() + "\n" + nc.get(i).getClubAddress().toString() + "\nTicket Price: " + nc.get(i).getTicketPrice(),nc.get(i).getClubName());
					}
				}
			}
			
			@Override
			public void clubSearchNode(MyEventObject ev) {
				//COMPARE THE NIGHTCLUB LIST TO THE FOLLOWING OF THE USER AND REMOVE THE DUPLICATES
				UserPane uP = ev.getPane();
				User user = uB.find(ev.getUsername());
				ArrayList<Nightclub> follow = user.getFollowing();
				Nightclub[] ncArray = ncB.getNightclubBag();
				
				ArrayList<Nightclub> unique = new ArrayList<Nightclub>();
				for(int m = 0;m < ncB.getnElems();m++){
					unique.add(ncArray[m]);
				}
				
				for(int i = 0;i < unique.size();i++){
					for(int j = 0;j < follow.size();j++){
						if(unique.get(i).getClubName().equals(follow.get(j).getClubName())){
							unique.remove(i);
						}
					}
				}
				for(int i = 0;i < unique.size();i++){
					System.out.println(unique.get(i).getClubName());
				}
				
				for(int i = 0;i < unique.size();i++){
					String text = unique.get(i).getClubName() + "\n" + unique.get(i).getClubAddress().toString() + "\nTicket Price: " + unique.get(i).getTicketPrice();
					uP.createNodes(text,unique.get(i).getClubName());
				}
				
			}
			
			public void setMyAccount(MyEventObject ev){
				UserPane uP = ev.getPane();
//				uB.find(ev.getUsername()).setName(ev.getName());
//				uB.find(ev.getUsername()).setEmail(ev.getEmail());
//				uB.find(ev.getUsername()).setUsername(ev.getUsername());
//				uB.find(ev.getUsername()).setPassword(ev.getPassword());
				User user = (User) uB.find(ev.getUsername());
				uP.getEmailF().setText(user.getEmail());;
				uP.setNameF(user.getName());
				uP.setUsernameF(user.getUsername());
				uP.setPasswordF(user.getPassword());
			}
			
			public void editMyAccount(MyEventObject ev){
				UserPane uP = ev.getPane();
				System.out.println(uB.find(ev.getOldName()));
				System.out.println(uP.getNameF().getText());
				User user = (User) uB.find(ev.getOldName());
				user.setEmail(ev.getEmail());
				user.setName(ev.getName());
				user.setPassword(ev.getPassword());
				user.setUsername(ev.getUsername());
			}

			@Override
			public void passThroughInfo(MyEventObject ev) {
				//for the ClubNodes removal from user's Following arraylist
				User user = (User) uB.find(ev.getUsername());
				Nightclub nc = null;
				ArrayList<Nightclub> ncal = user.getFollowing();
				for(int i = 0;i < ncal.size();i++){
					if(ncal.get(i).getClubName().equals(ev.getNightclub())){
						nc = ncal.get(i);
					}
				}
				user.getFollowing().remove(nc);
				user.unfollow(nc);
			}

			@Override
			public void confirmLogin(MyEventObject ev) {
//				System.out.println(ev.getUsername());
//				System.out.println(uB.find(ev.getUsername()));
				uB.display();
				String username = ev.getUsername();
				String password = ev.getPassword();
				String className = uB.find(username).getClass().getSimpleName();
				if(className.equals("User")){
					if(uB.correctLogin(username,password)){
						view.setUsersName(username);
						view.setuP(new UserPane(view.getStage(),view));
					}else{
						//make an alert saying wrong username/password combination
					}
					
				} else if(className.equals("Manager")){
					if(mB.correctLogin(username, password)){
						//create the managerPane
					}
				}
					
				
			}

			@Override
			public void fillTheClubNode(MyEventObject ev) {
				ClubNodes cN = ev.getClubNode();
				Nightclub nc = ncB.find(ev.getNightclub());
				cN.getAddF().setText(nc.getClubAddress().toString());
				cN.getNameF().setText(nc.getClubName());
				cN.getTicketF().setText(Integer.toString(nc.getTicketPrice()));
			}

			@Override
			public void createAManager(MyEventObject ev) {
				ncB.add(ev.getNc());
				mB.add(new Manager(ev.getNc(),ev.getName(),ev.getPhone(),ev.getUsername(),ev.getPassword()));
			}

			@Override
			public void passFollowThrough(MyEventObject myEventObject) {
				
			}

			
			
		});
	}
}
