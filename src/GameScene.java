import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.concurrent.Delayed;

public class GameScene extends Scene
{

    public static staticThing leftBack;
    public static staticThing rightBack;
    private Camera camera;



    private double dX;

    private Heros hero=null;
    private long lastTime=0;

    public GameScene(Group root)
    {
        super(root);



        leftBack = new staticThing("desert.png",800,400);
        rightBack = new staticThing("desert.png",800,400);
        hero=new Heros(1350,250,0,"heros.png");
        hero.getAnimatedView().setY(200);

        camera = new Camera(1200,0,hero);

        root.getChildren().add(leftBack.getBackView());
        root.getChildren().add(rightBack.getBackView());
        root.getChildren().add(hero.getAnimatedView());


        AnimationTimer tm = new TimerMethod();
        tm.start();

    }




    private class TimerMethod extends AnimationTimer {
        public void handle(long now) {
            double elapsedTime=(now-lastTime)/1000000000;
            hero.update(now);
            camera.update(elapsedTime);

            lastTime=now;


         System.out.println("ok!");

        }
    }

















}
