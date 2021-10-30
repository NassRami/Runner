import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//class pour les backgrounds

public class staticThing {
    private Image imgFond1 ;
    private ImageView imgViewFond1 ;


    private double largeur;
    private double hauteur;

    private double posX;


    public staticThing( String filename, double largeur, double hauteur  )
    {
        this.largeur= largeur ;
        this.hauteur= hauteur ;
        this.posX= posX ;


        imgFond1 = new Image(filename,largeur,hauteur,true,true);
        imgViewFond1 = new ImageView(imgFond1);




    }
    public double getLargeur() {
        return largeur;
    }
    public double getHauteur() {
        return hauteur;
    }

    public  ImageView getBackView(){return imgViewFond1;}

    public void deplacement(){
        posX--;
        this.imgViewFond1.setX(posX);
    }


}
