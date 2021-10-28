import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import javafx.scene.image.ImageView;


public class HelloDemo extends Application{

        public static GameScene SCENERY;


        public void start(Stage primaryStage){
            primaryStage.setTitle("Demo");
            Group root = new Group ();
            SCENERY=new GameScene(root,800,400);

            primaryStage.setScene(SCENERY);


            root.getChildren().add(SCENERY.getThing());
            root.getChildren().add(SCENERY.getThing2());













            primaryStage.show();








        }
        public static void main(String[] args) {
            launch(args);
            // write your code here
        }


    }

