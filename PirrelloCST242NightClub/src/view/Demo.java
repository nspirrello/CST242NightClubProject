package view;

import controller.UserController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Address;
import model.ManagerBag;
import model.Nightclub;
import model.NightclubBag;
import model.User;
import model.UserBag;

public class Demo extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		UserBag lB = new UserBag(30);
		NightclubBag ncB = new NightclubBag(30);
		ManagerBag mB = new ManagerBag(30);
		ncB.add(new Nightclub("Spirits1",new Address("89","Birch St","11787","NY"),15,45));
		ncB.add(new Nightclub("Spirits2",new Address("89","Birch St","11787","NY"),15,45));
		ncB.add(new Nightclub("Spirits3",new Address("89","Birch St","11787","NY"),15,45));
		ncB.add(new Nightclub("Spirits4",new Address("89","Birch St","11787","NY"),15,45));
		ncB.add(new Nightclub("Spirits5",new Address("89","Birch St","11787","NY"),15,45));
		User user = new User("nickpirr@aol.com","Nicholas","Dangerly","test123");
		lB.add(user);
		
		LoginPane lP = new LoginPane(primaryStage);
		lP.buildLoginPane();
		lB.display();
		UserController uC = new UserController(lP,lB,ncB,mB);
		
		
		
//		UserPane uP = new UserPane(primaryStage);
	}

}
