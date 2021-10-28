public class Camera {
    private double xOffset;
    private double yOffset;

    public Camera(double x , double y )
    {
        this.xOffset=x;
        this.yOffset=y;


    }

    public void move(float x , float y)
    {xOffset+=x;
     yOffset+=y;
     GameScene.Fond1.se
    }

    public double getcX()
    {
        return x;
    }

    public double getcY()
    {
        return y ;
    }


}
