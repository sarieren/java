package geometries;

import primatives.Vector;

import java.util.ArrayList;

import primatives.Material;
import primatives.Point3D;
import primatives.Ray;

public class Cylinder extends RadialGeometry{
  protected Point3D _axisPoint; //point on cylinder
  protected Vector _axisDirection; //direction vector
 
  
  /**
   * Default constructor
   */
  public Cylinder() {
		super();
		this._axisPoint = new Point3D();
		this._axisDirection = new Vector();
		
	}
  
  /**
   * Copy Constructor
   * @param temp - The same object is copied
   */
  public Cylinder(Cylinder temp) {
	     super(temp._color, temp.radius, temp._material);
		this._axisPoint = new Point3D(temp.getAxisPoint());
		this._axisDirection = new Vector(temp.getAxisDirection());
	
	}
  /**
   * A constructor that accepts values
   * @param axisPoint - point on cylinder
   * @param axisDirection - direction vector
   * @param radius - radius of cylinder
   */
  public Cylinder(Point3D axisPoint, Vector axisDirection, double radius, Material matrial) {
	this._axisPoint = new Point3D(axisPoint);
	this._axisDirection = new Vector(axisDirection);
	this.radius = radius;
	_material = new Material(matrial);
}

/**
 * A function that returns a point on cylinder
 * @return axisPoint - point on cylinder
 */
public Point3D getAxisPoint() {
	return new Point3D(_axisPoint);
}

/**
 * set axisPoint
 * @param axisPoint - point on cylinder
 */
public void setAxisPoint(Point3D axisPoint) {
	this._axisPoint = new Point3D(axisPoint);
}

/**
 * A function that returns vector direction
 * @return axisDirection - direction vector
 */
public Vector getAxisDirection() {
	return new Vector(_axisDirection);
}

/**
 * set axisDirection
 * @param axisDirection - direction vector
 */
public void setAxisDirection(Vector axisDirection) {
	this._axisDirection = new Vector(axisDirection);
}

/**
 * Checks whether 2 cylinders are equal
 */
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!super.equals(obj))
		return false;
	if (getClass() != obj.getClass())
		return false;
	Cylinder other = (Cylinder) obj;
	if (_axisDirection == null) {
		if (other._axisDirection != null)
			return false;
	} else if (!_axisDirection.equals(other._axisDirection))
		return false;
	if (_axisPoint == null) {
		if (other._axisPoint != null)
			return false;
	} else if (!_axisPoint.equals(other._axisPoint))
		return false;
	return true;
}

/**
 * Prints the cylinder
 */
@Override
public String toString() {
	return "Cylinder [_axisPoint=" + _axisPoint + ", _axisDirection=" + _axisDirection + "]";
}

/**
 * Returns the norm to the cylinder
 */
public Vector getNormal(Point3D p) {
		return null;
	}

/**
 * Splitting point cutting with cylinder
 */
public ArrayList<Point3D> findIntersections(Ray ray)
{
	return null;
}

}