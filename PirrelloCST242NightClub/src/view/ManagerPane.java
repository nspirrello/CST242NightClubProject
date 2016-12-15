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

public class ManagerPane {
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
	private Button update;
	private Button sendAd;
	private Button logout;
	Label name;
	Label phoneNumber;
	Label username;
	Label password;
	Label nightclub;
	TextField nameField;
	TextField phoneField;
	TextField userField;
	TextField passField;
	TextField ncField;
	VBox paneCollection;
	CreateLoginPane cLP;
	
	Stage stage;
	LoginPane lP;
	public ManagerPane(Stage stage, LoginPane lP){
		this.stage = stage;
		this.lP = lP;
		clubAddress = new Label("Club Address");
		clubName = new Label("Club Name");
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
		update = new Button("Update");
		name = new Label("Name");
		phoneNumber = new Label("Phone Number");
		username = new Label("Username");
		password = new Label("Password");
		nameField = new TextField();
		phoneField = new TextField();
		userField = new TextField();
		passField = new TextField();
		ncField = new TextField();
		sendAd = new Button("Alert Followers");
		logout = new Button("Logout");
		buildPane(this.stage);
		stage.setScene(new Scene(paneCollection,300,400));
		stage.show();
	}
	public void buildPane(Stage stage){
		paneCollection = new VBox(30);
		
		MyEventObject ev = new MyEventObject(this,lP.getUsersName(),this);
		if(lP.getMyEventListener() != null){
			lP.getMyEventListener().fillManager(ev);
		}
		
		logout.setOnAction(event -> {
			lP.buildLoginPane();
		});
		
		update.setOnAction(event1 -> {
			 MyEventObject ev1 = new MyEventObject(nameField.getText(),phoneField.getText(),userField.getText(),passField.getText(),nameF.getText(),lP.getUsersName(),cLP.getNc(),this,this);
			 if(lP.getMyEventListener() != null){
				 lP.getMyEventListener().updateManager(ev1);
				 lP.setUsersName(userField.getText());
			 }
			 
		});
		
		HBox contentPane = new HBox(10);
		HBox contentPane2 = new HBox(10);
		
		VBox top1 = new VBox(10);
		VBox top2 = new VBox(10);
		top1.setAlignment(Pos.CENTER);
		top1.getChildren().addAll(name,nameField,phoneNumber,phoneField);
		top2.setAlignment(Pos.CENTER);
		top2.getChildren().addAll(username,userField,password,passField);
		
		VBox right1 = new VBox(10);
		right1.setAlignment(Pos.CENTER);
		right1.getChildren().addAll(clubName,nameF,clubAddress,addF,clubZip,zipF);
		VBox right2 = new VBox(10);
		right2.setAlignment(Pos.CENTER);
		right2.getChildren().addAll(clubState,stateF,ticketPrice,ticketF,numTables,tablesF);
		
		contentPane.getChildren().addAll(top1,top2);
		contentPane2.getChildren().addAll(right1,right2);
		
		HBox bttnPane = new HBox(15);
		bttnPane.setAlignment(Pos.CENTER);
		bttnPane.getChildren().addAll(update,sendAd,logout);
		
		paneCollection.getChildren().addAll(contentPane,contentPane2,bttnPane);
		
		
	}
	public Label getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(Label ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public TextField getNameF() {
		return nameF;
	}
	public void setNameF(TextField nameF) {
		this.nameF = nameF;
	}
	public TextField getAddF() {
		return addF;
	}
	public void setAddF(TextField addF) {
		this.addF = addF;
	}
	public TextField getStateF() {
		return stateF;
	}
	public void setStateF(TextField stateF) {
		this.stateF = stateF;
	}
	public TextField getZipF() {
		return zipF;
	}
	public void setZipF(TextField zipF) {
		this.zipF = zipF;
	}
	public TextField getTablesF() {
		return tablesF;
	}
	public void setTablesF(TextField tablesF) {
		this.tablesF = tablesF;
	}
	public TextField getTicketF() {
		return ticketF;
	}
	public void setTicketF(TextField ticketF) {
		this.ticketF = ticketF;
	}
	public Button getUpdate() {
		return update;
	}
	public void setUpdate(Button update) {
		this.update = update;
	}
	public TextField getNameField() {
		return nameField;
	}
	public void setNameField(TextField nameField) {
		this.nameField = nameField;
	}
	public TextField getPhoneField() {
		return phoneField;
	}
	public void setPhoneField(TextField phoneField) {
		this.phoneField = phoneField;
	}
	public TextField getUserField() {
		return userField;
	}
	public void setUserField(TextField userField) {
		this.userField = userField;
	}
	public TextField getPassField() {
		return passField;
	}
	public void setPassField(TextField passField) {
		this.passField = passField;
	}
	public CreateLoginPane getcLP() {
		return cLP;
	}
	public void setcLP(CreateLoginPane cLP) {
		this.cLP = cLP;
	}
	
}
