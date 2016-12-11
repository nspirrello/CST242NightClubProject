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
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
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
	
	private ScrollPane middlePane;
	private BorderPane paneCollection;
	
	private VBox contentHolder;
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
	
	public UserPane(Stage stage, LoginPane lP){
		this.stage = stage;
		contentHolder = new VBox(5);
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
		
		mainMenu.getItems().addAll(clubSubMenu);
		account.getItems().addAll(invoice,myAccount);
		clubSubMenu.getItems().addAll(searchClubs, myClubs);
		menu.getMenus().addAll(mainMenu,notifications,account);
		
		myClubs.setOnAction(event -> {
			contentHolder.getChildren().removeAll(contentHolder.getChildren());
			buildMainUserMenu(paneCollection);
		});
		
		myAccount.setOnAction(event -> {
			buildMyAccount(paneCollection);
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
	public void fillNodes(String text, String nightclub){
		new ClubNodes(text,contentHolder,lP, nightclub);
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
}
