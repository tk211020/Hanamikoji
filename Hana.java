import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;  
import javafx.scene.input.MouseEvent;
import javafx.event.*; 
import javafx.stage.Stage;  
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class Hana extends Application {  
	@Override 	
	public void start(Stage stage) {
		

		int i =0;
		String nowmyhand = "myhand"+(i+1);
		System.out.println(nowmyhand);

		Image p[1] = new Image(Hana.class.getResourceAsStream("p5sak.png")); 
		Image p[2] = new Image(Hana.class.getResourceAsStream("p4tea.png")); 
		Image p3umb = new Image(Hana.class.getResourceAsStream("p3umb.png")); 
		Image p3sha = new Image(Hana.class.getResourceAsStream("p3sha.png")); 
		Image p2flu = new Image(Hana.class.getResourceAsStream("p2flu.png")); 
		Image p2fan = new Image(Hana.class.getResourceAsStream("p2fan.png")); 
		Image p2book = new Image(Hana.class.getResourceAsStream("p2book.png")); 
		Image back = new Image(Hana.class.getResourceAsStream("back.png")); 

		//p5sak = new Image(Hana.class.getResourceAsStream("p3umb.png"));

		ImageView p5sakV = new ImageView(p5sak); 
		ImageView p4teaV = new ImageView(p4tea);  
		ImageView p3umbV = new ImageView(p3umb);  
		ImageView p3shaV = new ImageView(p3sha);  
		ImageView p2fluV = new ImageView(p2flu);  
		ImageView p2fanV = new ImageView(p2fan);  
		ImageView p2bookV = new ImageView(p2book); 
		ImageView backV = new ImageView(back); 

		
			
		
		p5sakV.setX(50);
		p5sakV.setY(350);
		p5sakV.setFitHeight(350);
		p5sakV.setFitWidth(150); 
		p5sakV.setPreserveRatio(true) ;  

		p4teaV.setX(200);
		p4teaV.setY(350);
		p4teaV.setFitHeight(350);
		p4teaV.setFitWidth(150); 
		p4teaV.setPreserveRatio(true) ; 
		

		p3umbV.setX(350);
		p3umbV.setY(350);
		p3umbV.setFitHeight(350);
		p3umbV.setFitWidth(150); 
		p3umbV.setPreserveRatio(true) ; 

		p3shaV.setX(500);
		p3shaV.setY(350);
		p3shaV.setFitHeight(350);
		p3shaV.setFitWidth(150); 
		p3shaV.setPreserveRatio(true) ; 


		p2fluV.setX(650);
		p2fluV.setY(350);
		p2fluV.setFitHeight(350);
		p2fluV.setFitWidth(150); 
		p2fluV.setPreserveRatio(true) ; 


		p2fanV.setX(800);
		p2fanV.setY(350);
		p2fanV.setFitHeight(350);
		p2fanV.setFitWidth(150); 
		p2fanV.setPreserveRatio(true) ; 
		

		p2bookV.setX(950);
		p2bookV.setY(350);
		p2bookV.setFitHeight(350);
		p2bookV.setFitWidth(150); 
		p2bookV.setPreserveRatio(true) ; 


		backV.setX(1150);
		backV.setY(350);
		backV.setFitHeight(230);
		backV.setFitWidth(150); 
		
 		Group root = new Group() ; 
		root.getChildren().add(p5sakV);
		root.getChildren().add(p4teaV);
		root.getChildren().add(p3umbV);
		root.getChildren().add(p3shaV);
		root.getChildren().add(p2fluV);
		root.getChildren().add(p2fanV);
		root.getChildren().add(p2bookV);
		root.getChildren().add(backV);
		Scene scene = new Scene(root, 1500, 1500) ; 
		
		stage.setTitle("Hanamikoji") ;
		stage.setScene(scene) ;
		stage.show() ; 
p5sakV = new ImageView(p2fan); 
	}
}