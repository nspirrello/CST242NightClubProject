package view;

import controller.MyEventObject;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/*
 * Ok so first off, for the notifcation system, i have to make it so the GUI knows when the Nightclub
 */
public class UserPane {
	private MenuBar menu;
	private Menu mainMenu;
	private MenuItem invoice;
	private Menu clubSubMenu;
	private MenuItem myClubs;
	private MenuItem searchClubs;
	private Menu notifications;
	private MenuItem myAccount;
	private Menu account;
	private MenuItem logout;
	
	private ScrollPane middlePane;
	private BorderPane paneCollection;
	
	private VBox contentHolder;
	private VBox searchHolder;
	Stage stage;
	LoginPane lP;
	
	Label name = new Label("Name:");
	TextField nameF = new TextField();
	Label email = new Label("Email:");
	TextField emailF = new TextField();
	Label username = new Label("Username:");
	TextField usernameF = new TextField();
	Label password = new Label("Password:");
	TextField passwordF = new TextField();
	Button update = new Button("Update");
	
	TextArea invoiceArea = new TextArea();
	
	public UserPane(Stage stage, LoginPane lP){
		this.stage = stage;
		contentHolder = new VBox(5);
		searchHolder = new VBox(5);
		middlePane = new ScrollPane();
		paneCollection = new BorderPane();
		middlePane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		middlePane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		this.lP = lP;
		buildMenu(paneCollection);
		buildMainUserMenu(paneCollection);		
		stage.setScene(new Scene(paneCollection,300,400));
		stage.show();
	}
	public void buildMenu(BorderPane pane){
		menu = new MenuBar();
		mainMenu = new Menu("Explore");
		invoice = new MenuItem("My Invoice");
		clubSubMenu = new Menu("Clubs");
		myClubs = new MenuItem("My Clubs");
		searchClubs = new MenuItem("Search Clubs");
		notifications = new Menu("Notifications");
		myAccount = new MenuItem("User Settings");
		account = new Menu("My Account");
		logout = new MenuItem("Logout");
		
		mainMenu.getItems().addAll(clubSubMenu);
		account.getItems().addAll(invoice,myAccount,logout);
		clubSubMenu.getItems().addAll(searchClubs, myClubs);
		menu.getMenus().addAll(mainMenu,notifications,account);
		
		myClubs.setOnAction(event -> {
			contentHolder.getChildren().removeAll(contentHolder.getChildren());
			buildMainUserMenu(paneCollection);
		});
		
		myAccount.setOnAction(event -> {
			buildMyAccount(paneCollection);
		});
		
		logout.setOnAction(event -> {
			lP.setuP(null);
			lP.buildLoginPane();
		});
		
		searchClubs.setOnAction(event -> {
			searchHolder.getChildren().removeAll(searchHolder.getChildren());
			buildClubSearch(paneCollection);
		});
		
		invoice.setOnAction(event -> {
			buildInvoice(paneCollection);
		});
		
		pane.setTop(menu);
	}
	public void buildMainUserMenu(BorderPane pane){
		MyEventObject ev = new MyEventObject(this,lP.getUsersName(),this);
			if(lP.getMyEventListener() != null){
				lP.getMyEventListener().passFollowing(ev);
			}
		
		//rather than this. I have to go throught the controller and grab the bag of clubs the user is following, then place 
		middlePane.setContent(contentHolder);
		
		pane.setCenter(middlePane);
		
	}
	public void buildInvoice(BorderPane pane){
		contentHolder.getChildren().removeAll(contentHolder.getChildren());
		MyEventObject ev = new MyEventObject(this,lP.getUsersName(),this);
		if(lP.getMyEventListener() != null){
			lP.getMyEventListener().createInvoice(ev);
		}
		Button clear = new Button("Clear Last Entry");
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);
		invoiceArea.setPrefSize(298, 348);
		invoiceArea.setEditable(false);
		vbox.getChildren().addAll(invoiceArea,clear);
		
		clear.setOnAction(event -> {
			invoiceArea.clear();
			MyEventObject ev1 = new MyEventObject(this,lP.getUsersName(),this);
			if(lP.getMyEventListener() != null){
				lP.getMyEventListener().clearInvoice(ev1);
			}
		});
		
		contentHolder.getChildren().add(vbox);
		middlePane.setContent(contentHolder);
		
		pane.setCenter(middlePane);
		
		
	}
	public void fillNodes(String text, String nightclub){
		new ClubNodes(text,contentHolder,lP, nightclub,this);
	}
	public void createNodes(String text, String nightclub){
		new ClubNodes(text,searchHolder,lP,nightclub);
	}
	public void buildMyAccount(BorderPane pane){
		
		MyEventObject ev = new MyEventObject(this,lP.getUsersName(),this);
		if(lP.getMyEventListener() != null){
			lP.getMyEventListener().setMyAccount(ev);
		}
		
		update.setOnAction(event -> {
			MyEventObject eventO = new MyEventObject(this,usernameF.getText(),passwordF.getText(),nameF.getText(),emailF.getText(),lP.getUsersName(),this);
			if(lP.getMyEventListener() != null){
				lP.getMyEventListener().editMyAccount(eventO);
				lP.setUsersName(usernameF.getText());
			}
		});
		
		
		
		VBox vbox = new VBox(15);
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(name,nameF,email,emailF,username,usernameF,password,passwordF,update);
		
		pane.setCenter(vbox);
		
	}
	
	public void buildClubSearch(BorderPane pane){
		MyEventObject ev = new MyEventObject(this,lP.getUsersName(),this);
		if(lP.getMyEventListener() != null){
			lP.getMyEventListener().clubSearchNode(ev);
		}
		
		middlePane.setContent(searchHolder);
		
		pane.setCenter(middlePane);
	}
	
	public void setNameF(String s) {
		nameF.setText(s);
	}
	
	public void setEmailF(String s) {
		emailF.setText(s);
	}
	public void setUsernameF(String s) {
		usernameF.setText(s);;
	}
	
	public void setPasswordF(String s) {
		passwordF.setText(s);
	}
	
	public TextField getNameF() {
		return nameF;
	}
	public TextField getEmailF() {
		return emailF;
	}
	public TextField getUsernameF() {
		return usernameF;
	}
	public TextField getPasswordF() {
		return passwordF;
	}
	public ScrollPane getMiddlePane() {
		return middlePane;
	}
	public TextArea getInvoiceArea() {
		return invoiceArea;
	}
	
}
