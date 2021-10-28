import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


// we’ll use to display static
//element (background or number of life). This class is defined
//by two double (x,y), one ImageView.
public class staticThing {
    private Image imgFond1 ;
    private ImageView imgViewFond1 ;


    private double largeur;
    private double hauteur;

    private double posX;


    public staticThing( String filename, double largeur, double hauteur ,double posX )
    {
        this.largeur= largeur ;
        this.hauteur= hauteur ;
        this.posX= posX ;


        imgFond1 = new Image(filename,largeur,hauteur,true,true);
        imgViewFond1 = new ImageView(imgFond1);
        imgViewFond1.setX(posX);



    }

    public  ImageView getThing(){return imgViewFond1;}

    public void deplacement(){
        posX--;
        this.imgViewFond1.setX(posX);
    }
}
