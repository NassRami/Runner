import javafx.geometry.Rectangle2D;
import javafx.scene.shape.Rectangle;

public class Heros extends AnimatedThing
{
    private double g=0.5;
    private double vy=0;
    private Rectangle rectangle;
    private boolean jump=false;
    private boolean contact;
    private int numberContact=0;
    private static boolean pieceContact=true;
    private int numberContactPiece=0;
    private double invincibility=0;

    //-------------------------------------- Constructor -----------------------------------------
    public Heros (int x, double y, String filename) {
        super(x, y, filename);
    }


    // --------------------------------- Methods -------------------------------------------------------------

       //1
    void update(long time, double time2){
        this.axPers=0.015;
        this.vxPers+=this.axPers*time2;
        this.xPers+=vxPers*time2;

        if(invincibility>0)
        {
            invincibility-=time2;
        }



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

          if(200<yPers && yPers<=250){this.vy=-1.25*Math.sqrt(250*this.g);}
          return jump=true;
    }


    //3
    public void contactAvant(Objet objet)
    {
        if(((this.xPers+80)<objet.getX() ) || this.xPers+80>objet.getX()+objet.getLargeur() || (this.yPers+99)<=objet.getY()+ objet.getHauteur() || this.yPers >= objet.getY()+ 65 ) { contact=false;}
        else
        {

            xPers += (objet.getLargeur() + 100);
            numberContact++;
            contact=true;


        }




    }
    public void invincible()
    {
        if(invincibility>0){contact=false;}
    }

    public double getInvincibility() {
        return invincibility;
    }

    public void becomeInvincible()
   {
       invincibility=100;
   }




    public static boolean isPieceContact() {
        return pieceContact;
    }

    public int getNumberContactPiece() {
        return numberContactPiece;
    }

    //4
    public boolean contactPiece(Objet objet)
    {
        if((this.xPers+80)<objet.getX() || this.xPers+80>objet.getX()+objet.getLargeur() || (this.yPers+99)<=objet.getY()+ objet.getHauteur() || this.yPers >= objet.getY()+objet.getHauteur()){ pieceContact=true; return false;}
        else {  return true;}


    }


    public void addContactpiece(Objet objet) {
        double x=0;
        x=(xPers+80)/ objet.getX();
        //
        //System.out.println(x);
        if (x==1) {
            numberContactPiece++;
        }
    }

    public boolean isContactAvant() {
        return contact;
    }

//------------------------------ GETTERS-------------------------------------


    public int getNumberContact() {
        return numberContact;
    }


}

