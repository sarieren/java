package geometries;

import primatives.Vector;

import java.awt.Color;
import java.util.ArrayList;

import primatives.Material;
import primatives.Point3D;
import primatives.Ray;

public class Sphere extends RadialGeometry{
  

/**
 * Sphere is the Class that represent Sphere in tree Dimensions 
 */
  protected Point3D _center;
  
  /**
   * constructor
   * @param color - color the emission color
   * @param radius - radius the radius of the Sphere
   * @param center - point center of the Sphere
   * @param material - material of the sphere
   */
  public Sphere(Color color, double radius, Point3D center, Material material) {
		super(color, radius, material);
		this._center = new Point3D(center);
	}
  
  /**
   * constructor without material
   * @param color - color the emission color
   * @param radius - radius the radius of the Sphere
   * @param center - point center of the Sphere
   */
  public Sphere(Color color, double radius, Point3D center) {
		super(color, radius, new Material());
		this._center = new Point3D(center);
	}
  
  /**
   * constructor without color and material
   * @param radius - radius the radius of the Sphere
   * @param center - point center of the Sphere
   */
  public Sphere(double radius, Point3D _center) {
		super(new Color(0,0,0),radius,  new Material());
		this._center = new Point3D(_center);
	}
  
  /**
   * Copy constructor
   * @param temp - The same object is copied
   */
  public Sphere(Sphere temp) {
	  super();
	    this._center = new Point3D(temp._center);
	  }
  
  

/**
 * Default constructor
   */
  public Sphere() {
	super();
    this._center = new Point3D();
  }

  /**
   * Returns the center point
   * @return center - point center of the Sphere
   */
  public Point3D getCenter() {
    return new Point3D(_center);
  }
  
  /**
   * Defines the center point
   * @param center - point center of the Sphere
   */
  public void setCenter(Point3D center) {
    this._center = new Point3D(center);
  }
  
  /**
   * Prints the sphere
   */
 
  @Override
public String toString() {
	return "Sphere [_center=" + _center + "]";
}

  /**
   * Checks whether 2 circles are equal
   */
  @Override
  public boolean equals(Object obj) {
  	if (this == obj)
  		return true;
  	if (!super.equals(obj))
  		return false;
  	if (getClass() != obj.getClass())
  		return false;
  	Sphere other = (Sphere) obj;
  	if (_center == null) {
  		if (other._center != null)
  			return false;
  	} else if (!_center.equals(other._center))
  		return false;
  	return true;
  }

  
  /**
   * A function that returns the normal to sphere at the given point
   * @param point - point to get the normal
   * @return  vector - normal to plane
   */
  @Override
	public Vector getNormal(Point3D point) {
		Vector vector = new Vector(_center, point);
		vector.normalize();
		return vector;
	}

  /**
   *An abstract function that finds cutting points in sphere according to the given ray
   * @param ray - ray to get the intersection points
   * @return list of intersection point accirding to ray on sphere
   */
  @Override
  public ArrayList<Point3D> findIntersections(Ray ray)
	{	
	  	ArrayList<Point3D> intersectionPoints = new ArrayList<Point3D>();
	  	Point3D p= null;
	  	Vector O = new Vector(_center);//O
	  	Vector p0 = new Vector(ray.getPOO());//P0
	  	Vector L = new Vector(O.subtractV(p0));//O-p0
	  	double tm = L.dotProduct(ray.getDirection());//tm=l*v
	    double d = Math.sqrt(Math.pow(L.length(), 2) - Math.pow(tm, 2));//(|L|^2+tm^2)^0.5
	    if (d > this.getRadius()) //אם הנקודה מחוץ למעגל זה גדול מהרדיוס
	    {
	    	
	        return intersectionPoints;
	    }
	    else
	    {
	    	if(d == this.getRadius())
		      {
		         p = new Point3D(ray.getPOO().addP(ray.getDirection().scaleV(tm).getHead()));
		         intersectionPoints.add(p);
		         return intersectionPoints;
		      }
		    else
		    {
		    double th = Math.sqrt(Math.pow(this.getRadius(), 2) - Math.pow(d, 2));//(r^2-t^2)^0.5
		    double t1 = tm - th;
		    double t2 = tm + th;
		    if (t1 > 0) 
		    {
		        Vector direct = new Vector(ray.getDirection());
		        direct.scale(t1);
		        Point3D P1 = new Point3D(ray.getPOO());
		        P1.add(new Vector(direct));
		        intersectionPoints.add(P1);
		     }
		    
		     if (t2 > 0) 
		     {
		        Vector dirc = new Vector(ray.getDirection());
		        dirc.scale(t2);
		        Point3D P2 = new Point3D(ray.getPOO());
		        P2.add(new Vector(dirc));
		        intersectionPoints.add(P2);
		     }
		     
		   return intersectionPoints;
		    }

	    }
	    	}

}