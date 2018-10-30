package cloud.nivlheim.LudoBoard;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.TouchEvent;

public class Controller {


	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private ImageView ludoimg;

	    @FXML
	    void initialize() throws FileNotFoundException {
	       InputStream imgst = new BufferedInputStream(new FileInputStream("ludo-board.png"));
	       
	    	Image ludo = new Image(imgst);
	    	
	    	this.ludoimg.imageProperty().set(ludo);
	    	this.ludoimg.setPickOnBounds(true);
	    	this.ludoimg.resize(ludo.getWidth(), ludo.getHeight());
	    	
	    	this.ludoimg.setOnMouseClicked(e->{
	    		Double x = e.getX();
	    		Double y = e.getY();
	    		
	    		System.out.println("User pressed coordinate x,y: (" + e.getX() + ", " + e.getY() + ")");
	    		
	    		
	    		Double xRoute = x / 48.13;
	    		Double yRoute = y / 48.13;
	    		
	    		System.out.println("You pressed block: (" + xRoute + ", " + yRoute + ")");
	    		
	    		
	    	});
	    	
	    	System.out.println(this.ludoimg.getBoundsInLocal().getWidth() + ", "
					+ this.ludoimg.getBoundsInLocal().getHeight());
	    	System.out.println("Image properties: " + ludoimg.getBoundsInParent().getWidth() + ", " + ludoimg.getBoundsInParent().getHeight()); 

	    }
	
	    @FXML
	    void coordinate(TouchEvent event) {
	    	Double xpos = event.getTouchPoint().getX();
	    	Double ypos = event.getTouchPoint().getY();
	    	
	    	System.out.println("User pressed coordinate x,y: (" + xpos + ", " + ypos + ")");

	    }

}
