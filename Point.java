public class Point {
	public final double x;
	public final double y;
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Point translateX(double t) {
		return new Point(x + t, y);
	}

	public Point translateY(double t) {
		return new Point(x, y + t);
	}
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	public static double distance(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
	}

	public static Point centerOfMass(Point[] points){
	    double x=0;
	    double y=0;
	    for (int i = 0; i<points.length; i++){
	        x += points[i].x;
	    }
	    x /= points.length;
	    for (int i = 0; i<points.length; i++){
	        y += points[i].y;
	    }
	    y /= points.length;
	    return new Point(x,y);
	}
	public double angle(Point p){
	    return Math.toDegrees(Math.atan2(p.y, p.x));
	}
	public Point rotate(double a){
	    Point origin = new Point(0,0);
	    a = Math.toRadians(a);
	    a += Math.atan2(this.y, this.x);
	    double y = Math.round(100*Math.sin(a)*Point.distance(this,origin));
	    double x = Math.round(100*Math.cos(a)*Point.distance(this,origin));
	    y /= 100;
	    x /= 100;
	    return new Point(x,y);
	}
}
