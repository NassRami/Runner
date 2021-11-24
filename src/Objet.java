import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Objet {

    private int largeur,hauteur;
    private double x,y;



    public Image image;
    public ImageView animatedObjet;


    public Image getImage() {
        return image;
    }

    //constructeur
    public Objet (double x,double y,int largeur,int hauteur,String filename)
    {
        this.x=x;
        this.y=y;
        this.largeur=largeur;
        this.hauteur=hauteur;
        this.image=new Image(filename);
        animatedObjet=new ImageView(image);
        animatedObjet.setViewport(new Rectangle2D(0,0,largeur,hauteur));



    }

    public ImageView getAnimatedObjet() {
        return animatedObjet;
    }

    public void setLargeur(int largeur) {this.largeur = largeur;}

    public void setHauteur(int hauteur) {this.hauteur = hauteur;}

    public void setX(int x) {this.x = x;}

    public void setY(int y) {this.y = y;}

    public int getLargeur() {return largeur;}

    public int getHauteur() { return hauteur;}

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void update(double offset, Heros heros){
        animatedObjet.setX(x-heros.getX());
        animatedObjet.setY(y);
        /*if(heros.getX()>this.x)
        {
            animatedObjet.setX((800+x)-offset);
        }
*/

    }
}
