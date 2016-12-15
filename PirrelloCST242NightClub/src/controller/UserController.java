package controller;

import java.util.ArrayList;

import model.Address;
import model.Manager;
import model.ManagerBag;
import model.Nightclub;
import model.NightclubBag;
import model.User;
import model.UserBag;
import model.UserInvoice;
import view.ClubNodes;
import view.LoginPane;
import view.ManagerPane;
import view.UserPane;
/*
 * for transferring the following list, just make it so when you go to myClubs
 */
public class UserController {
	public UserController(LoginPane view, UserBag uB, NightclubBag ncB, ManagerBag mB){
		ArrayList<Nightclub> unique = new ArrayList<Nightclub>();
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


				String username = ev.getUsername();
				String password = ev.getPassword();
				
				if(uB.isIn(username)){
					if(uB.correctLogin(username,password)){
						view.setUsersName(username);
						view.setuP(new UserPane(view.getStage(),view));
					}else{
						//make an alert saying wrong username/password combination
					}
				}else if(mB.isIn(username)){
					System.out.println(mB.isIn(username));
					if(mB.correctLogin(username, password)){
						//create the managerPane
						view.setUsersName(username);
						view.setmP(new ManagerPane(view.getStage(),view));
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
			public void passFollowThrough(MyEventObject ev) {
				//make a user using username passed in
				//find the nightclub and register it to the user following and o list
				User user = uB.find(ev.getUsername());
				Nightclub nc = ncB.find(ev.getNightclub());
				user.getFollowing().add(nc);
				user.setToNotify(nc);
				//send through a up so the object can be removed from the vbox
				unique.remove(nc);
			}

			@Override
			public void passTicket(MyEventObject ev) {
				//get a nightclub from ev and then find the price, get a user from username and then invoke the buy ticket item
				Nightclub nc = ncB.find(ev.getNightclub());
				User user = uB.find(ev.getUsername());
				int price = nc.getTicketPrice();
				user.buyTicket(ev.getNightclub(), price, user.getUsername());
			}

			@Override
			public void createInvoice(MyEventObject ev) {
				User user = uB.find(ev.getUsername());
				UserPane pane = ev.getPane();
				
				UserInvoice uI = user.getUserI();
				pane.getInvoiceArea().setText(uI.printAll());
			}

			@Override
			public void clearInvoice(MyEventObject ev) {
				User user = uB.find(ev.getUsername());
				UserInvoice uI = user.getUserI();
				UserPane uP = ev.getPane();
				for(int i = 0;i < uI.getSize();i++){
					uI.remove(uI.get(i));
				}
				System.out.println(uI.printAll());
				uP.getInvoiceArea().setText(uI.printAll());
			}

			@Override
			public void updateManager(MyEventObject ev) {
				Nightclub nc = ncB.find(ev.getNc().getClubName());
				ManagerPane mP = ev.getmP();
				nc.setClubName(mP.getNameF().getText());
				String add = mP.getAddF().getText();
				int split = add.indexOf(" ");
				String num = add.substring(0, split);
				String addSt = add.substring(split+1);
				Address newAdd = new Address(num,addSt,mP.getZipF().getText(),mP.getStateF().getText());
				nc.setClubAddress(newAdd);
				nc.setNumOfTables(Integer.parseInt(mP.getTablesF().getText()));
				nc.setTicketPrice(Integer.parseInt(mP.getTicketF().getText()));
				
				Manager manager = mB.find(ev.getOldName());
				manager.setName(ev.getName());
				manager.setPassword(ev.getPassword());
				manager.setPhoneNumber(ev.getPhone());
				manager.setUsername(ev.getUsername());
				
			}

			@Override
			public void fillManager(MyEventObject ev) {
				ManagerPane mP = ev.getmP();
				Manager manager = mB.find(ev.getUsername());
				Nightclub nc = ncB.find(manager.getNightClub().getClubName());
				//nightclub
				mP.getAddF().setText(nc.getStNum() + " " + nc.getStName());
				mP.getNameF().setText(nc.getClubName());
				mP.getStateF().setText(nc.getState());
				mP.getZipF().setText(nc.getZip());
				mP.getTablesF().setText(nc.getNumOfTables()+"");
				mP.getTicketF().setText(nc.getTicketPrice()+"");
				//manager
				mP.getNameField().setText(manager.getName());
				mP.getPhoneField().setText(manager.getPhoneNumber());
				mP.getUserField().setText(manager.getUsername());
				mP.getPassField().setText(manager.getPassword());
			}

			
			
		});
	}
}
