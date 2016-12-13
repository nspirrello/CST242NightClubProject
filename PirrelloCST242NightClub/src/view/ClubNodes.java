package view;

import controller.MyEventObject;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ClubNodes {
	private HBox paneNode;
	private Label workPls;
	private Button unfollow;
	private Button viewClub;
	
	private String ncName;
	Label clubname ;
	Label clubAddress;
	Label ticket;
	Label table;
	Button ticketBttn;
	Button tableBttn;
	Button unfollowBttn;
	TextField nameF;
	TextField addF;
	TextField ticketF;
	UserPane uP;
	
	Label info;
	Button follow;
	public ClubNodes(String text, VBox vbox, LoginPane lP, String ncName, UserPane uP){
		workPls = new Label(text);
		viewClub = new Button("View Club");
		unfollow = new Button("Unfollow");
		this.uP = uP;
		this.ncName = ncName;
		//make it change when you hover from following to unfollow
		unfollow.setAlignment(Pos.BASELINE_RIGHT);
		unfollow.setOnAction(event -> {
			//needs event sent to controller for user to unsubscribe from the nightclubs notify list
			vbox.getChildren().remove(paneNode);
			MyEventObject ev = new MyEventObject(this, lP.getUsersName(), ncName);
			if(lP.getMyEventListener() != null){
				lP.getMyEventListener().passThroughInfo(ev);
			}
		});
		viewClub.setOnAction(event -> {
			clubname = new Label("Club Name:");
			clubAddress = new Label("Club Address:");
			ticket = new Label("Ticket Price:");
			table = new Label("Table Price:");
			ticketBttn = new Button("Buy Ticket");
			tableBttn = new Button("Reserve Table");
			unfollowBttn = new Button("Unfollow");
			nameF = new TextField();
			addF = new TextField();
			ticketF = new TextField();
			nameF.setEditable(false);
			ticketF.setEditable(false);
			addF.setEditable(false);
			HBox hbox = new HBox(20);
			hbox.setPadding(new Insets(50,15,0,20));
			VBox vbox1 = new VBox(10);
			vbox1.getChildren().addAll(clubname,nameF,clubAddress,addF,ticket,ticketF);
			VBox vbox2 = new VBox(10);
			hbox.setAlignment(Pos.CENTER);
			vbox1.setAlignment(Pos.CENTER);
			vbox2.setAlignment(Pos.CENTER);
			vbox2.getChildren().addAll(ticketBttn,tableBttn);
			hbox.getChildren().addAll(vbox1,vbox2);
			uP.getMiddlePane().setContent(hbox);
			
			//Sent nc name over and then fill textFields with info
			MyEventObject ev = new MyEventObject(this,ncName,this);
			if(lP.getMyEventListener() != null){
				lP.getMyEventListener().fillTheClubNode(ev);
			}
			ticketBttn.setOnAction(event1 -> {
				//needs club name, price of ticket, and user's username
				
				MyEventObject ev1 = new MyEventObject(ncName,this,lP.getUsersName());
				if(lP.getMyEventListener() != null){
					lP.getMyEventListener().passTicket(ev1);
				}
				
			});
		});
		
		
		
		
		paneNode = new HBox(15);
		paneNode.setAlignment(Pos.CENTER);
		paneNode.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		paneNode.setPrefSize(298, 50);
		paneNode.getChildren().addAll(workPls, viewClub,unfollow);
		vbox.getChildren().addAll(paneNode);
		
		
	}
	public ClubNodes(String text, VBox vbox, LoginPane lP,String ncName){
		info = new Label(text);
		this.ncName = ncName;
		follow = new Button("Follow");
//		implement follow using this
		
		HBox paneNode = new HBox(15);
		paneNode.setAlignment(Pos.CENTER);
		paneNode.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		paneNode.setPrefSize(298, 50);
		paneNode.getChildren().addAll(info,follow);
		vbox.getChildren().add(paneNode);
		
		follow.setOnAction(event -> {
			vbox.getChildren().remove(paneNode);
			MyEventObject ev = new MyEventObject(this,uP,lP.getUsersName(),ncName);
			if(lP.getMyEventListener() != null){
				lP.getMyEventListener().passFollowThrough(ev);
			}
			
		});
		
	}
	public String toString(){
		return "Text " + workPls.getText(); 
	}
	public TextField getNameF() {
		return nameF;
	}
	public TextField getAddF() {
		return addF;
	}
	public TextField getTicketF() {
		return ticketF;
	}
	
}
