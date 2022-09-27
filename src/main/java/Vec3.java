public class Vec3 {

	/*
	 * e[0] is the x coordinate.
	 * e[1] is the y coordinate.
	 * e[2] is the z coordinate.
	*/
	double[] e = new double[3];

	public Vec3() {
		e[0] = 0;
		e[1] = 0;
		e[2] = 0;
	}

	public Vec3(double e0, double e1, double e2) {
		e[0] = e0;
		e[1] = e1;
		e[2] = e2;
	}

	public final double x() { return e[0]; }

	public final double y() { return e[1]; }

	public final double z() { return e[2]; }

	// Substract vector.
	public final Vec3 Substract(Vec3 v) {
		return new Vec3(e[0] - v.e[0], e[1] - v.e[1], e[2] - v.e[2]);
	}

	// Return coordinate value of x or y or z.
	public final double coordinate(int i) { return e[i]; }

	// Add vector.
	public Vec3 Add(Vec3 v) { return new Vec3(e[0] + v.e[0], e[1] + v.e[1], e[2] + v.e[2]); }

	// Multiply vector.
	public final Vec3 Multiply(Vec3 v) { return new Vec3(e[0] * v.e[0], e[1] * v.e[1], e[2] * v.e[2]); } 

	// Multiply by scalar.
	public Vec3 MultiplyByScalar(double n) { return new Vec3(e[0] * n, e[1] * n, e[2] * n); } 

	// Divide vector.
	public final Vec3 Divide(Vec3 v) { return new Vec3(e[0] / v.e[0], e[1] / v.e[1], e[2] / v.e[2]); }

	// Divide by scalar
	public final Vec3 DivideByScalar(double number) { return new Vec3(e[0] / number, e[1] / number, e[2] / number); }

	// Length of vector
	public final double length() {
		return (double)Math.sqrt(
			Math.pow(e[0], 2.0) + Math.pow(e[1], 2.0) + Math.pow(e[2], 2.0));
	}

	// Sqrt length
	public final double sqrtLength() {
		return (Math.pow(e[0], 2.0) + Math.pow(e[1], 2.0) + Math.pow(e[2], 2.0));
	}

	/* Vec3 utility functions */

	public Vec3 unitVector(Vec3 v) { return v.DivideByScalar(v.length()); }
}
