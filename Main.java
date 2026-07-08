import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Point p = new Point(3, 4);
		Point q = new Point(7, 6);
		Point[] points = {p, q};
		System.out.println(p.angle(p));
		System.out.println(p.rotate(90));
		System.out.println(Point.centerOfMass(points));

		Grid<Integer> grid = new Grid<>(3, 0);
		grid.set(1, 1, 2);
		System.out.println(grid.diagonal());
		System.out.println(Grid.maxSideLength());

		Point p1 = new Point(0, 0);
		Point p2 = new Point(0, 2);
		Point p3 = new Point(2, 0);
		Circle c = Circle.fromPoints(p1, p2, p3);
		System.out.println(c);
		System.out.println(Point.distance(c.center, p1));
		System.out.println(Point.distance(c.center, p2));
		System.out.println(Point.distance(c.center, p3));

		Point corner = new Point(0, 0);
		Point test = new Point(1, 1);
		RightTriangle t = new RightTriangle(corner, 3, 4);
		RightTriangle t2 = new RightTriangle(corner, 6, 8);
		System.out.println(t.area());
		System.out.println(t.perimeter());
		System.out.println(t.isInside(test));
		System.out.println(t.scale(2).area());
		System.out.println(RightTriangle.similar(t, t2));
	}

	public static void returnAll(LibraryItem[] items) {
		for (int i=0; i<items.length; i++){
			items[i].returnItem();
		}
	}

	public static ArrayList<LibraryItem> availableItems(LibraryItem[] items) {
		ArrayList<LibraryItem> arr = new ArrayList<>();
		for (int i=0; i<items.length; i++){
			if (items[i].available()){
				arr.add(items[i]);
			}
		}
		return arr;
	}
}
