public interface Shape {
	public double area();

	public double perimeter();

	public boolean isInside(Point p);

	public boolean isOn(Point p);

	public Shape translate(double x, double y);

	public Shape scale(double k);
}
