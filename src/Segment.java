import java.util.Locale;

import static java.lang.Math.*;

public class Segment
{


    private final Vec2 p1;
    private final Vec2 p2;
    public Segment (Vec2 p1, Vec2 p2)
    {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Vec2 getP1() {
        return p1;
    }

    public Vec2 getP2() {
        return p2;
    }

    public float distance()
    {
        return (float) hypot(p1.x - p2.x, p1.y - p2.y);
    }
    // <line x1="0" y1="0" x2="200" y2="200" style="stroke:rgb(255,0,0);stroke-width:2" />
    public String toSVG(){
        return String.format(Locale.ENGLISH, "<line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" style=\"stroke:rgb(255,0,0);stroke-width:2\" />",p1.x,p1.y,p2.x,p2.y);
    }

    public static Segment[] perpendicular(Segment line, Vec2 point, double r) {
        double a;
        a = (line.p1.y - line.p2.y) / (line.p1.x - line.p2.x);
        double b;
        a=-1/a;
        b=point.y-a*point.x;

        double x0 = point.x;
        double y0 = point.y;
        //double r = line.distance();

        double root = Math.sqrt(-y0*y0+(2*a*x0+2*b)*y0-a*a*x0*x0-2*a*b*x0+(a*a+1)*r*r-b*b);
        double x1 = -(root-a*y0-x0+a*b)/(a*a+1);
        double y1 = -(a*root-a*a*y0-a*x0-b)/(a*a+1);
        double x2 = (root+a*y0+x0-a*b)/(a*a+1);
        double y2 = (a*root+a*a*y0+a*x0+b)/(a*a+1);

        return new Segment[]{new Segment(point, new Vec2(x1,y1)), new Segment(point, new Vec2(x2,y2))};
    }

    public static Segment[] perpendicular(Segment line, Vec2 point) {
        return perpendicular(line, point, line.distance());
    }
}
