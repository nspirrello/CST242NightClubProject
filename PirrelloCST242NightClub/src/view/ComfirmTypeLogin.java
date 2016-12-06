package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComfirmTypeLogin {
	private Label selection;
	private Button manager ;
	private Button user;
	Stage stage;
	CreateLoginPane cLP;
	public ComfirmTypeLogin(Stage stage){
		selection = new Label("Are you a User or a Manager");
		user= new Button("User");
		manager = new Button("Manager");
		this.stage = stage;
	}
	public void buildPane(){
		
		VBox vbox = new VBox(15);
		HBox hbox = new HBox(15);
		hbox.setAlignment(Pos.CENTER);
		vbox.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(user,manager);
		vbox.getChildren().addAll(selection,hbox);
		
		user.setOnAction(event -> {
			//build the userLoginPage
			cLP = new CreateLoginPane(stage);
			cLP.selectPane(stage, "u");;
		});
		manager.setOnAction(event -> {
			//build the managerLoginPage
			cLP = new CreateLoginPane(stage);
			cLP.selectPane(stage,"m");
		});
		
		stage.setScene(new Scene(vbox,300,400));
		stage.show();
	}

	public Button getManager() {
		return manager;
	}

	public Button getUser() {
		return user;
	}
	
}
