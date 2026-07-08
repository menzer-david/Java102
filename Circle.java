public class Circle implements Shape {
	public final Point center;
	public final double radius;

	public Circle(Point center, double radius) {
		this.center = center;
		this.radius = radius;
	}

	public double area() {
		return Math.PI * Math.pow(radius, 2);
	}

	public double perimeter() {
		return 2 * Math.PI * radius;
	}

	public boolean isInside(Point p) {
		return Point.distance(center, p) < radius;
	}

	public boolean isOn(Point p) {
		return Point.distance(center, p) == radius;
	}

	public Circle translate(double x, double y) {
		return new Circle(center.translateX(x).translateY(y), radius);
	}

	public Circle scale(double k) {
		return new Circle(center, radius * k);
	}

	@Override
	public String toString() {
		return "(center: " + center + "; radius: " + radius + ")";
	}

	public static Circle fromPoints(Point p1, Point p2, Point p3) {
		double d = 2*(p1.x*(p2.y-p3.y)+p2.x*(p3.y-p1.y)+p3.x*(p1.y-p2.y));
		if (d == 0){
			return null;
		}
		double sq1 = Math.pow(p1.x,2)+Math.pow(p1.y,2);
		double sq2 = Math.pow(p2.x,2)+Math.pow(p2.y,2);
		double sq3 = Math.pow(p3.x,2)+Math.pow(p3.y,2);
		double h = (sq1*(p2.y-p3.y)+sq2*(p3.y-p1.y)+sq3*(p1.y-p2.y))/d;
		double k = (sq1*(p3.x-p2.x)+sq2*(p1.x-p3.x)+sq3*(p2.x-p1.x))/d;
		double r = Math.sqrt(Math.pow((p1.x-h),2)+Math.pow((p1.y-k),2));
		Point c = new Point(h,k);
		return new Circle(c,r);
	}
}
