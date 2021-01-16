package geometries;

import primatives.Vector;

import java.awt.Color;
import java.util.ArrayList;

import primatives.Material;
import primatives.Point3D;
import primatives.Ray;

/**
* Triangle is the Class that represent Triangle in tree Dimensions 
*/
public class Triangle extends Geometry implements FlatGeometry{
  protected Point3D _p1;
  protected Point3D _p2;
  protected Point3D _p3;
  
  
  
  /**
   * constructor
   * @param p - color the emission color
   * @param p1 - a Point 1
   * @param p2 - a Point 2
   * @param p3 - a Point 3
   * @param m - material of the triangle
   */
  public Triangle(Color p, Point3D p1, Point3D p2, Point3D p3, Material m) 
  {
	super(p, m);
    this._p1 = new Point3D(p1);
    this._p2 = new Point3D(p2);
    this._p3 = new Point3D(p3);
  }
  
  /**
   * constructor without color and material
   * @param p1 - a Point 1
   * @param p2 - a Point 2
   * @param p3 - a Point 3
   */
  public Triangle(Point3D p1, Point3D p2, Point3D p3) 
  {
	super(new Color(0,0,0), new Material());
    this._p1 = new Point3D(p1);
    this._p2 = new Point3D(p2);
    this._p3 = new Point3D(p3);
  }
  
  /***
   * Copy constructor
   * @param temp - The same object is copied
   */
  public Triangle(Triangle temp) 
  {
	super(temp._color, temp._material);
    this._p1 = new Point3D(temp._p1);
    this._p2 = new Point3D(temp._p2);
    this._p3 = new Point3D(temp._p3);
  }
  
  /**
   * Default constructor
   */
    public Triangle() 
    {
    	super();
    	this._p1 = new Point3D();
    	this._p2 = new Point3D();
    	this._p3 = new Point3D();
  }

  /**
   * Returns a 3-D point
   * @return p1 - a Point 1
   */
  public Point3D getP1() {
    return new Point3D(_p1);
  }

  /**
   * Defines a three-dimensional point
   * @param p1 - a Point 1
   */
  public void setP1(Point3D p1) {
    this._p1 = new Point3D(p1);
  }

  /**
   * Returns a 3-D point
   * @return p2 - a Point 2
   */
  public Point3D getP2() {
    return new Point3D(_p2);
  }

  /**
   * Returns a 3-D point
   * @param p2 - a Point 2
   */
  public void setP2(Point3D p2) {
    this._p2 = new Point3D(p2);
  }

  /**
   * Returns a 3-D point
   * @return p3 - a Point 3
   */
  public Point3D getP3() {
    return new Point3D(_p3);
  }

  /**
   * Defines a three-dimensional point
   * @param p3 - a Point 3
   */
  public void setP3(Point3D p3) {
    this._p3 = new Point3D(p3);
  }

  /**
   * Prints the triangle
   */
  @Override
  public String toString() {
    return "Triangle [_p1=" + _p1 + ", _p2=" + _p2 + ", _p3=" + _p3 + "]";
  }

  /**
   * Checks whether 2 triangles are equal
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Triangle other = (Triangle) obj;
    if (_p1 == null) {
      if (other._p1 != null)
        return false;
    } else if (!_p1.equals(other._p1))
      return false;
    if (_p2 == null) {
      if (other._p2 != null)
        return false;
    } else if (!_p2.equals(other._p2))
      return false;
    if (_p3 == null) {
      if (other._p3 != null)
        return false;
    } else if (!_p3.equals(other._p3))
      return false;
    return true;
  }
  
  /**
   * A function that returns the normal to triangle at the given point
   * @param point - point to get the normal
   * @return  vector - normal to triangle
   */
  @Override
	public Vector getNormal(Point3D p) 
  {
		Vector v1 = new Vector(_p1, _p2);
		Vector v2 = new Vector(_p1, _p3);
		Vector v = v2.crossProduct(v1);
		v.normalize();
		return v;
	}
  
  /**
   *An abstract function that finds cutting points in triangle according to the given ray
   * @param ray - ray to get the intersection points
   * @return list of intersection point accirding to ray on triangle
   */
  @Override
  public ArrayList<Point3D> findIntersections (Ray ray)
  {
          Vector v = this.getNormal(new Point3D());
          ArrayList<Point3D> intersectionPoints = new ArrayList<Point3D>();
          Plane p = new Plane(this.get_color(),this._p1,v, this.get_material());
             intersectionPoints = p.findIntersections(ray);
             if (intersectionPoints.isEmpty())
             {
                 return intersectionPoints; 
             }         
             Triangle tr1 = new Triangle(this.get_color(), ray.getPOO(), _p1, _p2,this.get_material());
             Vector N1 = new Vector(tr1.getNormal(new Point3D()));
             Triangle tr2 = new Triangle(this.get_color(), ray.getPOO(), _p2, _p3,this.get_material());
             Vector N2 = new Vector(tr2.getNormal(new Point3D()));
             Triangle tr3 = new Triangle(this.get_color(), ray.getPOO(), _p3, _p1,this.get_material());
             Vector N3 = new Vector(tr3.getNormal(new Point3D()));
             
             Vector v1 = new Vector(intersectionPoints.get(0));
               Vector v2=new Vector(ray.getPOO());
               Vector sign=new Vector(v1.subtractV(v2));
               
             if (((sign.dotProduct(N1) >= 0) && (sign.dotProduct(N2) >= 0) 
                 && (sign.dotProduct(N3) >= 0)) || ((sign.dotProduct(N1) < 0) && 
                    (sign.dotProduct(N2) < 0) && (sign.dotProduct(N3) < 0))) 
             {
                 return intersectionPoints;
             }
             
             intersectionPoints.clear();
             return intersectionPoints;    
     }

 }


