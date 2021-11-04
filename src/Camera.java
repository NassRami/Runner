public class Camera {
    private double xCam;
    private double yCam;
    private double vxCam ;


    private double axCam;

    private Heros monHeros;

    private final double k=1;

    public void setxCam(double xCam) {
        this.xCam = xCam;
    }

    private final double f=1;

    public Camera(double x , double y,Heros hero )
    {
        this.xCam=x;
        this.yCam=y;
        this.monHeros=hero;
        vxCam=0;
        axCam=0;

    }


    public void update(double time)
    {
        axCam = (monHeros.getX() - xCam) * k -(f*vxCam);
        vxCam=vxCam+axCam*time;
        xCam=xCam+vxCam*time;

    }



    public double getcX()
    {
        return xCam;
    }

    public double getcY()
    {
        return yCam ;
    }

    public double getcAX(){ return axCam;}
    public double getcvX(){ return vxCam;}


}
