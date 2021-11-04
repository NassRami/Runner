import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import javafx.scene.image.ImageView;

public class Heros extends AnimatedThing
{
    public Heros (double x, double y, String filename) {
        super(x, y, filename);
    }

    void update(long time,double time2){
        this.axPers+=(0.000001*time2);
        this.vxPers+=this.axPers*time2;
        this.xPers+=vxPers*time2;

        indexPers= (int) (((time/100000000))%6);//duree entre 2 frames
        animatedView.setViewport(new Rectangle2D(4+indexPers*84,2,80,97));

    }


}
