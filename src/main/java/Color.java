/*
 * Color class that takes rgb values and returns a color value.
*/

public class Color extends Vec3 {
	public Color() { super(0, 0, 0); }
	public Color(double r, double g, double b) { super(r, g, b); }

	// return a color value.
	public final int writeColor() {
		int ir = (int)(255.999 * x());
		int ig = (int)(255.999 * y());
		int ib = (int)(255.999 * z());

		return ((ir<<16) + (ig<<8) + ib);
	}

	public final Color rayColor(Ray r) {
		Vec3 v = new Vec3();
		Vec3 unitDirection = v.unitVector(r.direction());

		double t = 0.5 * (unitDirection.y() + 1.0);

		Color color1 = new Color(1.0, 1.0, 1.0);
		Color color2 = new Color(0.5, 0.7, 1.0);
    	
    	// Misschien deze return veranderen.
    	return color1.MultiplyByScalar(1.0 - t).Add(color2.MultiplyByScalar(t));
	}

	/* Override Vec3 methods to a different return type (Color) */
	public final Color MultiplyByScalar(double n) { return new Color(e[0] * n, e[1] * n, e[2] * n); }

	public final Color Add(Vec3 v) { return new Color(e[0] + v.e[0], e[1] + v.e[1], e[2] + v.e[2]); }
}
	
