import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import javafx.scene.image.ImageView;

public class Heros
{
    private double posX;
    private double posY;


    private Image spriteSheet = null;
    private ImageView sprite ;


    public Heros(double x , double y,String filename )
    {
        this.posX=x;
        this.posY=y;
        spriteSheet=new Image(filename);
        sprite=new ImageView(spriteSheet);
        sprite.setViewport(new Rectangle2D(20,15,60,80));
        sprite.setY(posY);
        sprite.setX(posX);


    }

    public double getX()
    {
        return posX;
    }



    public ImageView getSprite()
    {
        return sprite;
    }

    public void update(int x)
    {
       if(x==0)
       {
           sprite.setViewport(new Rectangle2D(93, 4, 70, 89));
           sprite.setX(posX + 10);
       }
       else if(x==1)
    {
        sprite.setViewport(new Rectangle2D(170,9,89,102));
        sprite.setX(posX+20);
    }

       else if(x==3)
       {

           sprite.setViewport(new Rectangle2D(269,11,67,98));
           sprite.setX(posX+40);
       }

    }




}
