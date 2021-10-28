import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.concurrent.Delayed;

public class GameScene extends Scene
{

    public static staticThing Fond1;
    public static staticThing Fond2;
    public static staticThing Mario;

    private int largeur=0;
    private int hauteur=0;

    private double dX;

    private Heros hero=null;

    public GameScene(Group root, int largeur, int hauteur)
    {
        super(root,largeur,hauteur);

        this.largeur=largeur;
        this.hauteur=hauteur;

        Fond1= new staticThing("desert.png",largeur,hauteur,0);
        Fond2= new staticThing("desert.png",largeur,hauteur,800);








        hero = new Heros(100,250,"heros.png");
        /*AnimationTimer tm = new TimerMethod();
        tm.start();**/

    }



    public ImageView getThing()
    {
        return Fond1.getThing();

    }


    public ImageView getThing2()
    {
        return Fond2.getThing();

    }













    private class TimerMethod extends AnimationTimer {
        private int x=0;
        private int move=0;
        public void handle(long now) {

        Fond1.deplacement();
        Fond2.deplacement();







         System.out.println("ok!");

        }
    }

















}
