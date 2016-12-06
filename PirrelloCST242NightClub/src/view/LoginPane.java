package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginPane {	
	private Button loginBttn;
	private Button signBttn;
	ComfirmTypeLogin cTL;
	Stage stage;
	public LoginPane(Stage stage){
		this.stage = stage;
	}
	
	public void buildLoginPane(){
		Label username = new Label("Username");
		Label password = new Label("Password");
		TextField userField = new TextField();
		TextField passField = new TextField();
		loginBttn = new Button("Login");
		signBttn = new Button("Sign up");
		
		ImageView imv = new ImageView();
		Image image = new Image("https://thumbs.dreamstime.com/t/neon-club-club-neon-sign-bright-attracts-attention-luminous-saying-53510286.jpg");
		imv.setImage(image);
		
		//top portion
		HBox graphicSec = new HBox(30);
		graphicSec.getChildren().addAll(imv);
		graphicSec.setAlignment(Pos.CENTER);
		//middle portion
		HBox credentials = new HBox(15);
		VBox credOrganizer = new VBox(15);
		credOrganizer.getChildren().addAll(username,userField,password,passField);
		credentials.getChildren().add(credOrganizer);
		credentials.setAlignment(Pos.CENTER);
		credOrganizer.setAlignment(Pos.CENTER);
		//bottom portion
		HBox bttnSec = new HBox(30);
		bttnSec.getChildren().addAll(signBttn,loginBttn);
		bttnSec.setAlignment(Pos.CENTER);
		//collective portion
		VBox paneLayout = new VBox(30);
		paneLayout.getChildren().addAll(graphicSec,credentials,bttnSec);
		paneLayout.setAlignment(Pos.CENTER);
		
		loginBttn.setOnAction(event -> {
			//depending on if the login is type user or manage launch a different tab
		});
		
		signBttn.setOnAction(event -> {
			//launch the create login page
			cTL = new ComfirmTypeLogin(stage);
			cTL.buildPane();
		});
		
		stage.setScene(new Scene(paneLayout,300,400));
		stage.show();
	}
	public Button getLoginBttn() {
		return loginBttn;
	}
	public Button getSignBttn() {
		return signBttn;
	}
	
}
