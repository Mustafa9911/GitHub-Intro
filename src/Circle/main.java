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

	private final double WIDTH = 500;
	private final double HEIGHT= 500;
	
	boolean pressingW = false;
	boolean pressingS = false;
	boolean pressingA = false;
	boolean pressingD = false;
	String pressingKeyStr="";
	
	double moveSpeed;
	@Override
	public void start(Stage primaryStage) throws Exception {
		
       
		Group root = new Group();
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        double radius = ((WIDTH+HEIGHT)/2.0)/30.0;
        
        Player cir = new Player(radius,Color.GREEN);
        cir.setTranslateX(WIDTH/2.0);
        cir.setTranslateY(HEIGHT/2.0);
        
        moveSpeed = radius/5.0;
        
        Text text = new Text(pressingKeyStr);
        text.setFont(Font.font(30));
        text.setFill(Color.BLUE);
        text.setTranslateY(25);
        
        root.getChildren().addAll(cir,text);
        
       
        
        AnimationTimer t = new AnimationTimer(){

			@Override
			public void handle(long arg0) {
			

				if(pressingW) {
					cir.setTranslateY(cir.getTranslateY()-moveSpeed);
					pressingKeyStr += "UP ";
				}
				if(pressingS){ 
					cir.setTranslateY(cir.getTranslateY()+moveSpeed);
					pressingKeyStr += "DOWN ";
				}
				if(pressingA){ 
					cir.setTranslateX(cir.getTranslateX()-moveSpeed);
					pressingKeyStr += "LEFT ";

				}
				if(pressingD){ 
					cir.setTranslateX(cir.getTranslateX()+moveSpeed);
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
