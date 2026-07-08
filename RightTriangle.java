public class RightTriangle implements Shape {
	public final Point corner;
	public final double height;
	public final double width;

	public RightTriangle(Point corner, double height, double width) {
		this.corner = corner;
		this.height = height;
		this.width = width;
	}

	public double area() {
		return height*width/2;
	}

	public double perimeter() {
		return height+width+(Math.sqrt(Math.pow(height,2)+Math.pow(width,2)));
	}

	public boolean isInside(Point p) {
		return p.x>corner.x && p.y>corner.y && (p.x - corner.x)/width  +  (p.y - corner.y)/height <  1;
	}

	public boolean isOn(Point p) {
		return (p.x>=corner.x && p.y>=corner.y && (p.x - corner.x)/width  +  (p.y - corner.y)/height <=  1)&&(p.x==corner.x || p.y==corner.y || (p.x - corner.x)/width  +  (p.y - corner.y)/height ==  1);
	}

	public Shape translate(double x, double y) {
		return new RightTriangle(corner.translateX(x).translateY(y), height, width);
	}

	public Shape scale(double k) {
		return new RightTriangle(corner, k*height, k*width);
	}

	public static boolean similar(RightTriangle t1, RightTriangle t2) {
		return (t1.height/t1.width==t2.height/t2.width)||(t1.height/t1.width == t2.width/t2.height);
	}
}
