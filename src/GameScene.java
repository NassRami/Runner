import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.awt.*;

public class GameScene extends Scene
{

    public static staticThing leftBack;
    public static staticThing rightBack;
    private Camera camera;
    private long lastTime=0;
    private static Objet tuyau;
    private Rectangle GameOver ;



    private double dX;

    private Heros hero;


    public GameScene(Group root)
    {
        super(root);



        leftBack = new staticThing("desert.png",800,400);
        rightBack = new staticThing("desert.png",800,400);


        hero=new Heros(0,250,"heros.png");
        tuyau= new Objet("tuyauRouge.png");

        camera = new Camera(0,0,hero);
        GameOver= new Rectangle();






        root.getChildren().add(leftBack.getBackView());
        root.getChildren().add(rightBack.getBackView());
        root.getChildren().add(hero.getAnimatedView());
        root.getChildren().add(tuyau.getAnimatedObjet());

        root.getChildren().add(GameOver);

        timer.start();


    }


    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long time) {
            double elapsedTime =( (time - lastTime) / 10000000);
            if(elapsedTime>100) elapsedTime=0;
            hero.update(time,elapsedTime);
            camera.update(elapsedTime);
            lastTime = time;
            render();


        }
    };

        void render(){

            int offset = (int) (camera.getcX()%leftBack.getLargeur());
            leftBack.getBackView().setViewport(new Rectangle2D(offset, 0, leftBack.getLargeur()-offset, leftBack.getHauteur()));
            rightBack.getBackView().setX(rightBack.getLargeur()-offset);
            //hearts.getBackView().setViewport(new Rectangle2D(0,0 , (numberOfLives*27)+1,27 ));
            //hearts.getBackView().setX();
            hero.getAnimatedView().setX(hero.getX()-camera.getcX()+100);
            hero.getAnimatedView().setY(hero.getY()-camera.getcY());

            tuyau.getAnimatedObjet().setX(700-offset);
            tuyau.getAnimatedObjet().setY(275);

            System.out.println("yPers="+hero.getY());
            System.out.println("PersoVy="+hero.getVy());





            this.setOnKeyPressed(ev -> {
                if (ev.getCode() == KeyCode.SPACE) {
                    System.out.println("JUMP");
                    hero.jump();
                }
            });

            /*if(offset>=1){timer.stop();

                GameOver.setX(200);
                GameOver.setY(100);
                GameOver.setWidth(400);
                GameOver.setHeight(100);
                GameOver.setFill(Color.RED);

            }
*/



        }
    }


















