package view;

import controller.MyEventObject;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Address;
import model.Nightclub;

public class CreateLoginPane {
	private Button userAccept;
	private Button managerAccept;
	private Button userCancel;
	private Button managerCancel;
	private Button createNC;
	Stage stage;
	LoginPane lP;
	UserPane uP;
	private Label clubAddress;
	private Label clubName;
	private Label clubZip;
	private Label numTables;
	private Label ticketPrice;
	private Label clubState;
	private TextField nameF;
	private TextField addF;
	private TextField stateF;
	private TextField zipF;
	private TextField tablesF;
	private TextField ticketF;
	
	Nightclub nc;
	
	public CreateLoginPane() {
		super();
	}
	public CreateLoginPane(Stage stage, LoginPane lP){
		userAccept = new Button("Accept");
		managerAccept = new Button("Accept");
		userCancel = new Button("Cancel");
		managerCancel = new Button("Cancel");
		createNC = new Button("Create Nightclub");
		this.stage = stage;
		this.lP = lP;
	}
	public void selectPane(Stage stage, String selection){
		if(selection.equals("u")){
			buildUserPane();
		} else if(selection.equals("m")){
			buildManagerPane();
		}
	}
	public void buildUserPane(){
		Label name = new Label("Name");
		Label email = new Label("Email");
		Label username = new Label("Username");
		Label password = new Label("Password");
		TextField nameField = new TextField();
		TextField emailField = new TextField();
		TextField userField = new TextField();
		TextField passField = new TextField();
		
		
		userAccept.setOnAction(event -> {
			//launch userGUI
			String n = nameField.getText();
			String e = emailField.getText();
			String u = userField.getText();
			String p = passField.getText();
			lP.setUsersName(u);
			System.out.println(lP.getUsersName());
			MyEventObject ev = new MyEventObject(this,u,p,n,e);
			if(lP.getMyEventListener() != null){
				lP.getMyEventListener().confirmUserCreationButton(ev);
			}
			uP = new UserPane(stage,lP);
		});
		userCancel.setOnAction(event -> {
			//go back to the login menu
			lP.buildLoginPane();
		});
		
		HBox hbox = new HBox(15);
		hbox.setAlignment(Pos.CENTER);
		VBox vbox = new VBox(15);
		vbox.setAlignment(Pos.CENTER);
		
		vbox.getChildren().addAll(name,nameField,email,emailField,username,userField,password,passField);
		hbox.getChildren().addAll(vbox,getUserCancel(),getUserAccept());
		stage.setScene(new Scene(hbox,300,400));
		stage.show();
		
	}
	public void buildManagerPane(){
		Label name = new Label("Name");
		Label phoneNumber = new Label("Phone Number");
		Label username = new Label("Username");
		Label password = new Label("Password");
		Label nightclub = new Label("Nightclub");
		TextField nameField = new TextField();
		TextField phoneField = new TextField();
		TextField userField = new TextField();
		TextField passField = new TextField();
		TextField ncField = new TextField();
		createNC.setOnAction(event ->{
			clubName = new Label("Club Name");
			clubAddress = new Label("Club Address");
			clubZip = new Label("Zip Code");
			clubState = new Label("State");
			numTables = new Label("# of Tables");
			ticketPrice = new Label("Price of Tickets");
			nameF = new TextField();
			addF = new TextField();
			zipF = new TextField();
			stateF = new TextField();
			tablesF = new TextField();
			ticketF = new TextField();
			Button confirm = new Button("Confirm");
			
			HBox hbox1 = new HBox(15);
			hbox1.setAlignment(Pos.CENTER);
			hbox1.getChildren().addAll(clubName,nameF);
			HBox hbox2 = new HBox(15);
			hbox2.setAlignment(Pos.CENTER);
			hbox2.getChildren().addAll(clubAddress,addF);
			HBox hbox3 = new HBox(15);
			hbox3.setAlignment(Pos.CENTER);
			hbox3.getChildren().addAll(numTables,tablesF);
			HBox hbox4 = new HBox(15);
			hbox4.setAlignment(Pos.CENTER);
			hbox4.getChildren().addAll(ticketPrice,ticketF);
			VBox vbox = new VBox(15);
			vbox.getChildren().addAll(hbox1,hbox2,hbox3,hbox4,confirm);
			
			Stage stage = new Stage();
			stage.setScene(new Scene(vbox,300,400));
			stage.show();
			
			confirm.setOnAction(event2 -> {
				String address = clubAddress.getText();
				int split = address.indexOf(" ");
				String clubNum = address.substring(0, split);
				String clubSt = address.substring(split+1);
				Address ad = new Address(clubNum,clubSt,zipF.getText(),stateF.getText());
				nc = new Nightclub(nameF.getText(),ad,Integer.parseInt(tablesF.getText()),Integer.parseInt(ticketF.getText()));
				ncField.setText(ad.toString());
				stage.close();
			});
			
			
		});
		managerAccept.setOnAction(event -> {
			//launch userGUI
			//need object with name, phone, username, password and nightclub object
			MyEventObject ev = new MyEventObject(this,nameField.getText(),phoneField.getText(),userField.getText(),passField.getText(),nc);
			if(lP.getMyEventListener() != null){
				lP.getMyEventListener().createAManager(ev);
			}
			
		});
		managerCancel.setOnAction(event -> {
			lP.buildLoginPane();
		});
		
		HBox hbox = new HBox(15);
		hbox.setAlignment(Pos.CENTER);
		VBox vbox = new VBox(15);
		vbox.setAlignment(Pos.CENTER);
		VBox vbox1 = new VBox(15);
		vbox1.setAlignment(Pos.CENTER);
		
		vbox.getChildren().addAll(name,nameField,phoneNumber,phoneField,username,userField,password,passField,nightclub,ncField);
		vbox1.getChildren().addAll(getCreateNC(),getManagerAccept(),getManagerCancel());
		hbox.getChildren().addAll(vbox,vbox1);
		stage.setScene(new Scene(hbox,300,400));
		stage.show();
	}
	
	public Button getUserCancel() {
		return userCancel;
	}
	public void setUserCancel(Button userCancel) {
		this.userCancel = userCancel;
	}
	public Button getManagerCancel() {
		return managerCancel;
	}
	public void setManagerCancel(Button managerCancel) {
		this.managerCancel = managerCancel;
	}
	public Button getUserAccept() {
		return userAccept;
	}
	public Button getManagerAccept() {
		return managerAccept;
	}
	public void setUserAccept(Button userAccpet) {
		this.userAccept = userAccpet;
	}
	public void setManagerAccept(Button managerAccept) {
		this.managerAccept = managerAccept;
	}
	public Button getCreateNC() {
		return createNC;
	}
	public void setCreateNC(Button createNC) {
		this.createNC = createNC;
	}
	
	
}
