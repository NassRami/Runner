import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;
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

    private int score;



    private double dX;

    private Heros hero;

    private Text text;
    private StackPane stack;

//-----------------------------------------
    public GameScene(Group root)
    {
        super(root);


        leftBack = new staticThing("desert.png",800,400);
        rightBack = new staticThing("desert.png",800,400);
        hearts = new staticThing("hearts.png",81,27);
        gameOver = new staticThing("over.png",300,150);


        gameOver.getBackView().setX(250);
        gameOver.getBackView().setY(100);

        hero=new Heros(0,250,"heros.png");

        camera = new Camera(100,0,hero);


        creatObstacle(30);
        creatPiece(50);



        root.getChildren().add(leftBack.getBackView());
        root.getChildren().add(rightBack.getBackView());
        root.getChildren().add(hero.getAnimatedView());
        root.getChildren().add(hearts.getBackView());
        root.getChildren().add(gameOver.getBackView());

        gameOver.hideImage();
        score=0;

        text = new Text("\nVotre score est :" + (score+nbrPiece));
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



    void render(){
            score++;
            text.setText("\nVotre score est :" + ((score/10)+nbrPiece));
            offset = (int) (camera.getcX()%leftBack.getLargeur());
            leftBack.getBackView().setViewport(new Rectangle2D(offset, 0, leftBack.getLargeur()-offset, leftBack.getHauteur()));
            rightBack.getBackView().setX(rightBack.getLargeur()-offset);
            //hearts.getBackView().setViewport(new Rectangle2D(0,0, 81,27 ));

            hero.getAnimatedView().setX(hero.getX()-camera.getcX());
            hero.getAnimatedView().setY(hero.getY()-camera.getcY());



            for(Objet objet : tabObjets)
            {
                objet.update(offset,hero);
                hero.contactAvant(objet);
                if(hero.isContactAvant()==true)
                {

                    if(hero.getNumberContact()==1){ hero.becomeInvincible(); hearts.getBackView().setViewport(new Rectangle2D(0,0, 54,27 ));}
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
/*-------------------------Test---------------------------------------------*/


            //System.out.println("numberContact="+hero.getNumberContact());
            //System.out.println(hero.isContactAvant());
            // System.out.println("Contact : "+hero.isContactAvant());
            //System.out.println("number : "+hero.getNumberContact());

//-------------------------------------------------------------------------------

            this.setOnKeyPressed(ev -> {
                if (ev.getCode() == KeyCode.SPACE) {
                    System.out.println("SAUT ! ");
                    hero.jump();
                }
            });

        for(Objet objet : tabPiece)
        {
            //System.out.println(hero.isContactPiece());
            if(hero.contactPiece(objet)==true)
            {

                objet.getAnimatedObjet().setImage(null);
                nbrPiece++;



            }

        }
        for(Objet objet : tabPiece)
        {
            hero.addContactpiece(objet);
            //System.out.println(hero.getNumberContactPiece());
            //System.out.println(("xPErs : "+(hero.getX()+80)));
            //System.out.println("objet"+(objet.getX()+ objet.getLargeur()));




        }


        }
        //-------------------------------------------------Methods---------------------------------------
        void creatObstacle(int numberOfOsbtacles)
        {
            tabObjets=new ArrayList<Objet>();
            for(int i=0 ; i<numberOfOsbtacles;i++)
            {
                Objet tuyau1= new Objet(1000+i*1000,275,43,65, "tuyauRouge.png");
                tabObjets.add(tuyau1);
                System.out.println((400+i*1000));

            }
        }

    void creatPiece(int numberOfPieces)
    {
        tabPiece=new ArrayList<Objet>();
        for(int i=0 ; i<numberOfPieces;i++)
        {

            Objet piece1=new Objet((200 +(i*500)),275,25,30, "piece1.png");
            tabPiece.add(piece1);
            System.out.println((400+i*1000));

        }
    }
    //------------------------------------------Getters--------------------------------------------
    public int getOffset() {
        return offset;
    }



}


















