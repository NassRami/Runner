public class Camera {
    private double xOffset;
    private double yOffset;
    private double vx ;


    private double ax;

    private Heros monHeros;

    private final double k=1;
    private final double f=1.2;

    public Camera(double x , double y )
    {
        this.xOffset=x;
        this.yOffset=y;
    }


    public void update(double time)
    {
        ax=(monHeros.getX()-xOffset)*k-(f*vx);
        vx=vx+ax*time;
        xOffset=xOffset+vx*time;

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
