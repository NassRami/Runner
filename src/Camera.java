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

    }

    public double getcX()
    {
        return xOffset;
    }

    public double getcY()
    {
        return yOffset ;
    }


}
