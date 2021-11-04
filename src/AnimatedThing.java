import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AnimatedThing {

    protected double xPers;
    protected double yPers;

    protected ImageView animatedView;
    protected int indexPers;
    protected double axPers,vxPers;



    public AnimatedThing(double x, double y, String filename) {

        this.xPers = x;
        this.yPers = y;
        this.animatedView =new ImageView(new Image(filename));
        animatedView.setViewport(new Rectangle2D(20,2,60,97));
        axPers=vxPers=0;




        animatedView.setViewport(new Rectangle2D(4+indexPers*84,2,80,97));
    }

    public boolean contactAvant(Camera  cam)
    {
        if(cam.getcX()==523){return true;}else {
            return false;
        }

    }
    public double getX() {
        return xPers;
    }
    public double getY() {
        return yPers;
    }

    public ImageView getAnimatedView() {
        return animatedView;
    }


}
