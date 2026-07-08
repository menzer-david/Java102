public class Square implements Shape {
	public final Point corner;
	public final double sideLength;

	public Square(Point corner, double sideLength) {
		this.corner = corner;
		this.sideLength = sideLength;
	}

	public double area() {
		return sideLength * sideLength;
	}

	public double perimeter() {
		return 4 * sideLength;
	}

	public boolean isInside(Point p) {
		double dx = p.x - corner.x;
		double dy = p.y - corner.y;
		return 0 < dx && dx < sideLength && 0 < dy && dy < sideLength;
	}

	public boolean isOn(Point p) {
		double dx = p.x - corner.x;
		double dy = p.y - corner.y;
		return 0 <= dx && dx <= sideLength && 0 <= dy && dy <= sideLength &&
			   (dx == 0 || dx == sideLength || dy == 0 || dy == sideLength);
	}

	public Square translate(double x, double y) {
		return new Square(corner.translateX(x).translateY(y), sideLength);
	}

	public Square scale(double k) {
		return new Square(corner, sideLength * k);
	}

	public Point[] corners() {
		Point a = corner;
		Point b = corner.translateX(sideLength);
		Point c = corner.translateX(sideLength).translateY(sideLength);
		Point d = corner.translateY(sideLength);
		return new Point[]{a, b, c, d};
	}

	@Override
	public String toString() {
		return "(corner: " + corner + "; side length: " + sideLength + ")";
	}
}
