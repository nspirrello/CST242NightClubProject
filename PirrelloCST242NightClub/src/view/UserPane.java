package view;

import java.util.ArrayList;

import controller.MyEventObject;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
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
	private Menu myAccount;
	
	private ScrollPane middlePane;
	private BorderPane paneCollection;
	
	private VBox contentHolder;
	Stage stage;
	LoginPane lP;
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
		myAccount = new Menu("My Account");
		
		mainMenu.getItems().addAll(clubSubMenu,invoice);
		clubSubMenu.getItems().addAll(searchClubs, myClubs);
		menu.getMenus().addAll(mainMenu,notifications,myAccount);
		
		myClubs.setOnAction(event -> {
			contentHolder.getChildren().removeAll(contentHolder.getChildren());
			buildMainUserMenu(paneCollection);
		});
		
		pane.setTop(menu);
	}
	public void buildMainUserMenu(BorderPane pane){
		System.out.println(lP.getUsersName());
		MyEventObject ev = new MyEventObject(this,lP.getUsersName(),this);
			if(lP.getMyEventListener() != null){
				lP.getMyEventListener().passFollowing(ev);
			}
		
		//rather than this. I have to go throught the controller and grab the bag of clubs the user is following, then place 
		middlePane.setContent(contentHolder);
		
		pane.setCenter(middlePane);
		
	}
	public void fillNodes(String text){
		new ClubNodes(text,contentHolder);
	}
	public void buildMyAccount(){
		
	}
	
}
