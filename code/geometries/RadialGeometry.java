package geometries;

import java.awt.Color;

import primatives.Material;

/**
 * Bsae class for all Radial Geometry shapes
 *
 */
public abstract class RadialGeometry extends Geometry{
	
	double radius;


/**
 * Constuctor 
 * @param color - color emission color
 * @param radius - radius of the Geometry
 * @param material - material of the Geometry
 */
	public RadialGeometry(Color color, double radius, Material material) {
		super(color, material);
		this.radius = radius;
	}
	
/**
 * Default constructor
 */
	public RadialGeometry() {
		super();
		this.radius = 0;
	}
	
/**
 * Copy constructor
 * @param temp - The same object is copied
 */
	public RadialGeometry(RadialGeometry temp) {
		super(temp._color, temp._material);
		this.radius = temp.radius;
	}
	
	/**
	 * Returns radius length
	 * @return radius- radius length
	 */
	public double getRadius() {
		return radius;
	}

/**
 * Sets radius length
 * @param radius - radius length
 */
	public void setRadius(double radius) {
		this.radius = radius;
	}


/**
 * Checks whether 2 radius are equal
 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RadialGeometry other = (RadialGeometry) obj;
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
			return false;
		return true;
	}

/**
 * Prints the radius
 */
	@Override
	public String toString() {
		return "RadialGeometry [radius=" + radius + "]";
	}


}
