package bound;

class TwoD {// from ww w . j a va2 s.co m
	int x, y;

	TwoD(int a, int b) {
		x = a;
		y = b;
	}
}

// Three-dimensional coordinates.
class ThreeD extends TwoD {
	int z;

	ThreeD(int a, int b, int c) {
		super(a, b);
		z = c;
	}
}

class Map<T extends TwoD> {
	T[] coords;

	Map(T[] o) {
		coords = o;
	}
}

public class Calc3 {
	static void showXY(Map<?> c) {
		for (int i = 0; i < c.coords.length; i++) {
			System.out.println(c.coords[i].x + " " + c.coords[i].y);
		}
	}

	static void showXYZ(Map<? extends ThreeD> c) {
		for (int i = 0; i < c.coords.length; i++) {
			System.out.println(c.coords[i].x + " " + c.coords[i].y + " " + c.coords[i].z);
		}
	}

	public static void main(String args[]) {
		TwoD td[] = { new TwoD(0, 0), new TwoD(-1, -2) };
		Map<TwoD> map = new Map<TwoD>(td);
		System.out.println("Contents of tdlocs.");

		showXY(map);
		
		ThreeD td3[] = { new ThreeD(0, 0, 0), new ThreeD(-1, -2, -3) };
		Map<ThreeD> map3 = new Map<ThreeD>(td3);
		System.out.println("Contents of tdlocs.");
		
		showXYZ(map3);
		
	}
}