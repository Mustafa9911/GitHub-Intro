package Circle;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class main extends Application{


	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
       
		Group root = new Group();
        Scene scene = new Scene(root, 400, 300);

        
        Player cir = new Player(15,Color.GREEN);
        cir.setTranslateX(200);
        cir.setTranslateY(150);
        
        root.getChildren().add(cir);
        
        
        scene.setOnKeyPressed(event ->{
        	
        	
        	if(event.getCode() == KeyCode.W){
        		
        		cir.setTranslateY(cir.getTranslateY()-3);
        		
        	}else if(event.getCode() == KeyCode.S){
        		
        		cir.setTranslateY(cir.getTranslateY()+3);
        		
        	}else if(event.getCode() == KeyCode.A){
            		
            		cir.setTranslateX(cir.getTranslateX()-3);
            		
            	}else if(event.getCode() == KeyCode.D){
            		
            		cir.setTranslateX(cir.getTranslateX()+3);
            		
            	}
        		
        		
        		
        	
        	
        	
        });
        
        primaryStage.setTitle("My JavaFX Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	
	public static void main(String[] args) {
		launch(args);
	}
	

}
