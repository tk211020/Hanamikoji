import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Main extends Application{
	Scene scene;
	Parent parent;

	@Override
	public void start(Stage stage){
		try{
			parent = FXMLLoader.load(getClass().getResource("HanaScene.fxml"));
		}
		catch(Exception ex){
			System.out.println(ex.toString());
		}
		scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
	}	
	public static void main (String[] args){
		launch(args);
	
		
	}
}