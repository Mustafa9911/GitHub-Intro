package Circle;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class main extends Application{

	boolean pressingW = false;
	boolean pressingS = false;
	boolean pressingA = false;
	boolean pressingD = false;
	String pressingKeyStr="";
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
       
		Group root = new Group();
        Scene scene = new Scene(root, 400, 300);

        
        Player cir = new Player(15,Color.GREEN);
        cir.setTranslateX(200);
        cir.setTranslateY(150);
        
        Text text = new Text(pressingKeyStr);
        text.setFont(Font.font(30));
        text.setFill(Color.BLUE);
        text.setTranslateY(25);
        
        root.getChildren().addAll(cir,text);
        
       
        
        AnimationTimer t = new AnimationTimer(){

			@Override
			public void handle(long arg0) {
			

				if(pressingW) {
					cir.setTranslateY(cir.getTranslateY()-3);
					pressingKeyStr += "UP ";
				}
				if(pressingS){ 
					cir.setTranslateY(cir.getTranslateY()+3);
					pressingKeyStr += "DOWN ";
				}
				if(pressingA){ 
					cir.setTranslateX(cir.getTranslateX()-3);
					pressingKeyStr += "LEFT ";

				}
				if(pressingD){ 
					cir.setTranslateX(cir.getTranslateX()+3);
					pressingKeyStr += "RIGHT ";

				}
				text.setText(pressingKeyStr);
				pressingKeyStr="";

				
        
	        scene.setOnKeyPressed(event ->{
	        	
	        	
	        	if(event.getCode() == KeyCode.W){
	        		
	        		pressingW = true;
	
	        		
	        	}else if(event.getCode() == KeyCode.S){
	        		
	        		pressingS = true;
	
	        		
	        	}else if(event.getCode() == KeyCode.A){
	            		
		        		pressingA = true;
	
	            		
	            	}else if(event.getCode() == KeyCode.D){
	            		
		        		pressingD = true;
	
	            		
	            	}
	        		
	        	
	        });
	        
        
	        scene.setOnKeyReleased(event->{
	        	
	        	if(event.getCode() == KeyCode.W){
	        		pressingW = false;
	        	}
	        	else if(event.getCode() == KeyCode.S){        	
	        		pressingS = false;
	        	}
	        	else if(event.getCode() == KeyCode.A){
	        		pressingA = false;
	        	}
	        	else if(event.getCode() == KeyCode.D){
	        		pressingD = false;
	
	        	}
	
	        });
			}
        };
        
        t.start();
      
        primaryStage.setTitle("My JavaFX Application");
        primaryStage.setScene(scene);
        primaryStage.show();
   
        }
	public static void main(String[] args) {
		launch(args);
	}
	

}
