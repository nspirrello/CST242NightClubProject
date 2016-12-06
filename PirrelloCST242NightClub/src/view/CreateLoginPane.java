package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CreateLoginPane {
	private Button userAccept;
	private Button managerAccept;
	private Button userCancel;
	private Button managerCancel;
	Stage stage;
	LoginPane lP;
	public CreateLoginPane(Stage stage){
		userAccept = new Button("Accept");
		managerAccept = new Button("Accept");
		userCancel = new Button("Cancel");
		managerCancel = new Button("Cancel");
		this.stage = stage;
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
		});
		userCancel.setOnAction(event -> {
			//go back to the login menu
			lP = new LoginPane(stage);
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
		Label email = new Label("Email");
		Label username = new Label("Username");
		Label password = new Label("Password");
		TextField nameField = new TextField();
		TextField emailField = new TextField();
		TextField userField = new TextField();
		TextField passField = new TextField();
		
		managerAccept.setOnAction(event -> {
			//launch userGUI
		});
		managerCancel.setOnAction(event -> {
			//go back to the login menu
			lP = new LoginPane(stage);
			lP.buildLoginPane();
		});
		
		HBox hbox = new HBox(15);
		hbox.setAlignment(Pos.CENTER);
		VBox vbox = new VBox(15);
		vbox.setAlignment(Pos.CENTER);
		
		vbox.getChildren().addAll(name,nameField,email,emailField,username,userField,password,passField);
		hbox.getChildren().addAll(vbox,getManagerCancel(),getManagerAccept());
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
	
	
}
