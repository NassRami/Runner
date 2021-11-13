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
import java.util.ArrayList;

public class GameScene extends Scene
{

    public static staticThing leftBack;
    public static staticThing rightBack;
    private Camera camera;
    private long lastTime=0;
    private static Objet tuyau1;
    private static Objet tuyau2;
    private static Objet tuyau3;
    private Rectangle GameOver ;
    private ArrayList<Objet> tabObjets;



    private double dX;

    private Heros hero;


    public GameScene(Group root)
    {
        super(root);



        leftBack = new staticThing("desert.png",800,400);
        rightBack = new staticThing("desert.png",800,400);


        hero=new Heros(0,250,"heros.png");
        tuyau1= new Objet(100,275,"tuyauRouge.png");
        tuyau2= new Objet(400,275,"tuyauRouge.png");
        tuyau3= new Objet(700,275,"tuyauRouge.png");


        tabObjets=new ArrayList<Objet>();
        this.tabObjets.add(tuyau1);
        this.tabObjets.add(tuyau2);
        this.tabObjets.add(tuyau3);






        camera = new Camera(0,0,hero);
        GameOver= new Rectangle();






        root.getChildren().add(leftBack.getBackView());
        root.getChildren().add(rightBack.getBackView());
        root.getChildren().add(hero.getAnimatedView());
        for(Objet objet : tabObjets)
        {
            root.getChildren().add(objet.getAnimatedObjet());
        }



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
            hero.getAnimatedView().setX(hero.getX()-camera.getcX());
            hero.getAnimatedView().setY(hero.getY()-camera.getcY());

            for(Objet objet : tabObjets)
            {
                objet.update(offset,hero);
            }
            //System.out.println("yPers="+(hero.getY()+99));
            //System.out.println("tuyau="+(tuyau.getX()-offset));
            System.out.println("offset="+(offset+80));
            System.out.println("setx="+tuyau1.getX());

            //System.out.println("tuyau="+tuyau.getX());






            this.setOnKeyPressed(ev -> {
                if (ev.getCode() == KeyCode.SPACE) {
                    System.out.println("SAUT ! ");
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


*/          for(Objet objet : tabObjets)
            {
                if(hero.contactAvant(objet)==true){
                    System.out.println("tjrs pas");
                    timer.stop();
                }
            }




        }
    }


















