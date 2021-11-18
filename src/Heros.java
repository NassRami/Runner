import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

import javafx.scene.image.ImageView;

import java.awt.*;

public class Heros extends AnimatedThing
{
    private double g=0.5;
    private double vy=0;
    private Rectangle rectangle;
    private boolean jump=false;
    private boolean contactAvant=false;
    private int numberContact=0;
    private static boolean contactPiece;

    //-------------------------------------- Constructor -----------------------------------------
    public Heros (double x, double y, String filename) {
        super(x, y, filename);
    }


    // --------------------------------- Methods -------------------------------------------------------------

       //1
    void update(long time, double time2){
        this.axPers=0.005;
        this.vxPers+=this.axPers*time2;
        this.xPers+=vxPers*time2;

        if(jump==false ){

        indexPers= (int) (((time/100000000))%6);//duree entre 2 frames
        animatedView.setViewport(new Rectangle2D(4+indexPers*84,2,80,99));
        rectangle=new Rectangle();
        }
         if(vy<0)
        {
            animatedView.setViewport(new Rectangle2D(16,161,70,103));
        }
        else if(vy>0){animatedView.setViewport(new Rectangle2D(85,167,70,103));
            jump=false;}


        vy+=g*time2;
        yPers+=vy*time2;
        if (yPers>=250)
        {
            yPers=250;
            vy=0;
        }



    }

    //2
    public boolean jump() {

          this.vy=-1.25*Math.sqrt(250*this.g);
          return jump=true;
    }


    //3
    public boolean contactAvant(Objet objet)
    {
        if(((this.xPers+80)<objet.getX() ) || this.xPers+80>objet.getX()+objet.getLargeur() || (this.yPers+99)<=objet.getY()+ objet.getHauteur() || this.yPers >= objet.getY()+ 65 ) {return contactAvant=false;}
        else
        {
             xPers+=(objet.getLargeur()+100);
             numberContact++;
            return contactAvant=true;

        }


    }

    public void setContactAvant(boolean contactAvant) {
        this.contactAvant = contactAvant;
    }

    //4
    public boolean contactPiece(Objet objet)
    {
        if((this.xPers+80)<objet.getX() || this.xPers+80>objet.getX()+objet.getLargeur() || (this.yPers+99)<=objet.getY()+ objet.getHauteur() || this.yPers >= objet.getY()+objet.getHauteur()){return contactPiece=false;}
        else return contactPiece=true;
    }

    //------------------------------ GETTERS-------------------------------------
    public boolean isContactPiece() {
        return contactPiece;
    }

    public int getNumberContact() {
        return numberContact;
    }

    public double getVy() {
        return vy;
    }









}
