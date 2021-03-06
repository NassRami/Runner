import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class HelloDemo extends Application{

        public static GameScene SCENERY;
        public static HomeScene welcomeScene;


        public void start(Stage primaryStage){

            primaryStage.setTitle("Demo");

            Group root = new Group ();
            Group root2 = new Group();

            //Scene d'accueil
            welcomeScene = new HomeScene(root2);

            Button startButton=new Button("Start");
            startButton.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
            startButton.setLayoutX(350);
            startButton.setLayoutY(325);

            root2.getChildren().add(startButton);


            startButton.setOnAction(e -> {
                SCENERY=new GameScene(root);
                SCENERY.setFill(Color.BLACK);
                primaryStage.setScene(SCENERY);
            });

            primaryStage.setScene(welcomeScene);


            primaryStage.show();


        }
        public static void main(String[] args) {
            launch(args);

            // write your code here
        }


    }

