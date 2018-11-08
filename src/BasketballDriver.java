import java.text.DecimalFormat;
import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BasketballDriver extends Application {
Text action;
Image graphic;	
Text results;
Text results2;
Text results3;
Text results4;
Text results5;
int totalShots;
double doublePointAvg;
double triplePointAvg;
public static void main(String[] args) {
	launch(args);

}
DecimalFormat df = new DecimalFormat("0.##");
 //static BorderPane court;

@Override
public void start(Stage stadium) throws Exception {
	action = new Text(250,100, "Click Below to Start");
	results = new Text(420,120, "");
	results2 = new Text(420,140, "");
	results3 = new Text(420,160, "");
	results4 = new Text(420,180, "");
	results5 = new Text(420,200, "");
	
	GridPane  court = new GridPane();
	court.setPrefSize(400,300);
	Button play = new Button("Play");
	
	court.setPadding(new Insets(10, 12, 100, 10));
	court.setVgap(2);
	court.setHgap(2);
	court.setStyle("-fx-background-color: #77f442;");
	court.setLayoutX(175);
	court.setLayoutY(50);
	
	GridPane button = new GridPane();
	button.setPadding(new Insets(10, 10, 10, 10));
	button.setVgap(2);
	button.setHgap(2);
	button.setStyle("-fx-background-color: #ccd7ea;");
	button.setLayoutX(330);
	button.setLayoutY(300);
	button.setPrefSize(100, 50);
	button.add(play, 4, 4);
	
	
	ImageView imgView2pts = new ImageView(graphic);
	imgView2pts.setFitHeight(150); imgView2pts.setFitWidth(120);
	imgView2pts.setX(290);
	imgView2pts.setY(120);
	
	play.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			
			
			
				Random rand = new Random();
				int randAction = rand.nextInt(4);
				 
				 
				 if (randAction == 0){
		    		Basketball.setTwoPoints(Basketball.getTwoPoints() + 1);
		    		action.setText("2-Points!");
		    		 graphic = new Image("file:src\\2points.png");
		    		imgView2pts.setImage(graphic);
		    		} else if(randAction == 1) {
						Basketball.setThreePoints(Basketball.getThreePoints()+1);
						action.setText("3-Points!");
						 graphic = new Image("file:src\\3points.jpg");
						 imgView2pts.setImage(graphic);
					}else if (randAction ==2) {
						Basketball.setFouls(Basketball.getFouls()+1);
						action.setText("Foul");
						graphic = new Image("file:src\\foul.png");
						imgView2pts.setImage(graphic);
					}else if (randAction ==3) {
						Basketball.setMisses(Basketball.getMisses()+1);
						action.setText("Miss");
						graphic = new Image("file:src\\miss.png");
						imgView2pts.setImage(graphic);
					}
				results.setText("No. of 2 Pointers: " + Basketball.getTwoPoints());
				results2.setText("No. of 3 Pointers: " + Basketball.getThreePoints());
				results3.setText("No. of Fouls: " + Basketball.getFouls());
				results4.setText("No. of Misses: " + Basketball.getMisses());
				totalShots = Basketball.getTwoPoints()+Basketball.getThreePoints() + 
						Basketball.getMisses() + Basketball.getFouls();
				doublePointAvg = (double) Basketball.getTwoPoints() / totalShots;
				triplePointAvg = (double) Basketball.getThreePoints() / totalShots;
				results5.setText("Total Shots: " + totalShots +"\nDouble pt avg: "+ df.format(doublePointAvg) + "\nTriple pt avg: "
						+ df.format(triplePointAvg));
					
				
					
				}
				
	});
	
	
	
	
	
	Group root = new Group(court, button, action, imgView2pts, results, results2, results3, results4, results5);
	Scene scene = new Scene(root, 800, 600, Color.BEIGE);
	stadium.setScene(scene);
	stadium.setTitle("Basketball");
	stadium.show();
	
	


}}