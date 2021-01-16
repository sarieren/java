package geometries;

import primatives.Vector;
//import java.util.Vector;

import java.awt.Color;
import java.util.ArrayList;

import primatives.Material;
import primatives.Point3D;
import primatives.Ray;



public class Plane extends Geometry implements FlatGeometry{
  protected Point3D _p1;
  protected Vector _plumb;
  
  
  /**
   * A constructor that accepts values
   * @param c - emission color
   * @param p1 - point on the plane
   * @param plumb - normal to the plane
   * @param m - material of the plane
   */
  public Plane(Color c, Point3D p1, Vector plumb, Material m) {
	    super(c, m);
	    this._p1 = new Point3D(p1);
	    this._plumb = new Vector(plumb);
	  }
	  
  /**
   * constructor
   * @param p1 - point on the plane
   * @param plumb - normal to the plane
   */
  public Plane(Point3D p1, Vector plumb, Material m) {
	    super(new Color(0,0,0),m);
	    this._p1 = new Point3D(p1);
	    this._plumb = new Vector(plumb);
	  }

  
  /**
   * Copy Constructor
   * @param temp - The same object is copied
   */
  public Plane(Plane temp) {
	    super(temp._color, temp._material);
	    this._p1 = new Point3D(temp._p1);
	    this._plumb = new Vector(temp._plumb);
	  }
	  
  /**
   * Default constructor
   */
  public Plane() {
    super();
    this._p1 = new Point3D();
    this._plumb =  new Vector();
  }
  


  /**
   * Returns a point on the plane
   * @return p1 - point on the plane
   */
  public Point3D getP1() {
    return new Point3D(_p1);
  }

  /**
   * Defines a point on the plane
   * @param p1 - point on the plane
   */
  public void setP1(Point3D p1) 
  {
    this._p1 = new Point3D(p1);
  }
/**
 * Returns a normal to the plane
 * @return plumb - normal to the plane
 */
  public Vector getPlumb() 
  {
    return new Vector(_plumb);
  }

  /**
   * Defines a normal to the plane
   * @param plumb - normal to the plane
   */
  public void setPlumb(Vector plumb) 
  {
    this._plumb = new Vector(plumb);
  }
  
  /**
   * Prints the plane
   */
  @Override
  public String toString()
  {
    return "Plane [_p1=" + _p1 + ", _plumb=" + _plumb + "]";
  }

  /**
   * Checks whether 2 planes are equal
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Plane other = (Plane) obj;
    if (_p1 == null) {
      if (other._p1 != null)
        return false;
    } else if (!_p1.equals(other._p1))
      return false;
    if (_plumb == null) {
      if (other._plumb != null)
        return false;
    } else if (!_plumb.equals(other._plumb))
      return false;
    return true;
  }

  /**
   * A function that returns the normal to geometry at the given point
   * @param point - point to get the normal
   * @return  vector - normal to plane
   */
	  public Vector getNormal(Point3D p) {
		  _plumb.normalize();
			return new Vector(_plumb);

  }
	  
/**
 *function that finds cutting points in geometry according to the given ray
* @param ray - ray to get the intersection points
* @return list of intersection point according to ray on plane
 */
public ArrayList<Point3D> findIntersections(Ray ray)
{
	ArrayList<Point3D> intersectionPoints = new ArrayList<Point3D>();
    Vector direction = new Vector(ray.getDirection());//
    double mechane = direction.dotProduct(_plumb);//V*N
    if (mechane != 0) 
    {
    	Vector P0 = new Vector(ray.getPOO());//P0
        P0.subtract(new Vector(this._p1));//P0-Q0
        double t = -(_plumb.dotProduct(P0) / mechane);//-n*(p0-q0)\V*N
        direction.scale(t);
        Point3D newPoint = new Point3D(direction.getHead());
        Point3D p = new Point3D(ray.getPOO());
        p.add(newPoint);
        if(t<0)
        	return intersectionPoints;
        intersectionPoints.add(p.addP(newPoint));
    
    }
    return intersectionPoints;		
}

}
