package view;

import controller.UserController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.UserBag;

public class Demo extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		UserBag uB = new UserBag(30);
		LoginPane lP = new LoginPane(primaryStage);
		lP.buildLoginPane();
		
		UserController uC = new UserController(lP,uB);
		
		
		
//		UserPane uP = new UserPane(primaryStage);
	}

}
