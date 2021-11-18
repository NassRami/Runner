import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Random;

public class GameScene extends Scene
{

    public static staticThing leftBack;
    public static staticThing rightBack;
    public static staticThing hearts;
    public static staticThing gameOver;

    private Camera camera;
    private long lastTime=0;

    private int offset=0;

    //obstacle

    private ArrayList<Objet> tabObjets;

    //piece

    private  ArrayList<Objet> tabPiece;


    private Rectangle GameOver ;
    private int nbrPiece=0;



    private double dX;

    private Heros hero;

    private Text text;
    private StackPane stack;


    public GameScene(Group root)
    {
        super(root);


        leftBack = new staticThing("desert.png",800,400);
        rightBack = new staticThing("desert.png",800,400);
        hearts = new staticThing("hearts.png",81,27);
        gameOver = new staticThing("GameOver.png",223,152);


        gameOver.getBackView().setX(250);
        gameOver.getBackView().setY(100);

        hero=new Heros(0,250,"heros.png");

        camera = new Camera(100,0,hero);


        creatObstacle(5);
        creatPiece(10);



        root.getChildren().add(leftBack.getBackView());
        root.getChildren().add(rightBack.getBackView());
        root.getChildren().add(hero.getAnimatedView());
        root.getChildren().add(hearts.getBackView());
        root.getChildren().add(gameOver.getBackView());

        gameOver.hideImage();

        text = new Text("\nVotre score est :" + nbrPiece);
        text.setX(500);

        root.getChildren().add(text);




        for(Objet objet : tabObjets)
        {
            root.getChildren().add(objet.getAnimatedObjet());
        }

        for(Objet objet : tabPiece)
        {
            root.getChildren().add(objet.getAnimatedObjet());
        }



        //root.getChildren().add(GameOver);

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

    public int getOffset() {
        return offset;
    }

    void render(){
            text.setText("\nVotre score est :" + nbrPiece);
            offset = (int) (camera.getcX()%leftBack.getLargeur());
            leftBack.getBackView().setViewport(new Rectangle2D(offset, 0, leftBack.getLargeur()-offset, leftBack.getHauteur()));
            rightBack.getBackView().setX(rightBack.getLargeur()-offset);
            //hearts.getBackView().setViewport(new Rectangle2D(0,0, 81,27 ));

            hero.getAnimatedView().setX(hero.getX()-camera.getcX());
            hero.getAnimatedView().setY(hero.getY()-camera.getcY());

            for(Objet objet : tabObjets)
            {
                objet.update(offset,hero);
                if(hero.contactAvant(objet)==true  )
                {
                    if(hero.getNumberContact()==1){  hearts.getBackView().setViewport(new Rectangle2D(0,0, 54,27 ));}
                    else if(hero.getNumberContact()==2){  hearts.getBackView().setViewport(new Rectangle2D(0,0, 27,27 ));}
                    else {
                        timer.stop();
                        gameOver.showImage();

                    }

                }


            }
            for(Objet objet : tabPiece)
            {
                objet.update(offset,hero);
            }



            //System.out.println("xPers="+(hero.getX()+80));
            //System.out.println(hero.isContactPiece());


            this.setOnKeyPressed(ev -> {
                if (ev.getCode() == KeyCode.SPACE) {
                    System.out.println("SAUT ! ");
                    hero.jump();
                }
            });

        for(Objet objet : tabPiece)
        {
            System.out.println(hero.isContactPiece());
            if(hero.contactPiece(objet)==true)
            {
                nbrPiece++;
                objet.getAnimatedObjet().setImage(null);

            }

        }





        }
        void creatObstacle(int numberOfOsbtacles)
        {
            tabObjets=new ArrayList<Objet>();
            for(int i=0 ; i<numberOfOsbtacles;i++)
            {
                Objet tuyau1= new Objet(400+i*1000,275,43,65,"tuyauRouge.png");
                tabObjets.add(tuyau1);
                System.out.println((400+i*1000));

            }
        }

    void creatPiece(int numberOfPieces)
    {
        tabPiece=new ArrayList<Objet>();
        for(int i=0 ; i<numberOfPieces;i++)
        {
            Objet piece1=new Objet(350+i*500,275,25,30,"piece1.png");
            tabPiece.add(piece1);
            System.out.println((400+i*1000));

        }
    }

    }


















