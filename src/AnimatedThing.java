import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AnimatedThing {

    private double x;
    private double y;
    private double dt;
    private ImageView animatedView;
    private int index;
    private int offs;


    public AnimatedThing(double x, double y, double dt, String filename) {

        this.x = x;
        this.y = y;
        this.animatedView =new ImageView(new Image(filename));
        animatedView.setViewport(new Rectangle2D(20,2,60,97));

        this.dt = dt;


        offs = 84;
        animatedView.setViewport(new Rectangle2D(4+index*offs,2,80,97));
    }
    void update(long time){
        index= (int) (((time/100000000))%6);//duree entre 2 frames
        animatedView.setViewport(new Rectangle2D(4+index*offs,2,80,97));

    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    public ImageView getAnimatedView() {
        return animatedView;
    }


}
