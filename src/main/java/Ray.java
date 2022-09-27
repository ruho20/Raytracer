/* P(t) = Point3 + t * direction  */
public class Ray {
	Vec3 origin;
	Vec3 direction;

	public Ray(final Vec3 origin, final Vec3 direction) {
		this.origin = origin;
		this.direction = direction;
	}

	public final Vec3 origin() { return this.origin; }

	public final Vec3 direction() { return this.direction; }

	public final Vec3 at(double t) { return this.origin.Add(this.direction.MultiplyByScalar(t)); }
}
