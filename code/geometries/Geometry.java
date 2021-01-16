package geometries;
import java.awt.Color;

//import java.util.List;
import java.util.ArrayList;

import primatives.Material;
import primatives.Point3D;
import primatives.Ray;
import primatives.Vector;


public abstract class Geometry
{
protected Color _color; //color of the Geometry
protected Material _material; //material of the Geometry


/**
 * Default constructor
 */
public Geometry() 
{
	this._color = new Color(0,0,0);
	this._material= new Material();
}


/**
 * A constructor that accepts values
 * @param color - color of the Geometry
 * @param kd - Diffuse factor
 * @param ks - specular factor
 * @param kr - Reflection factor
 * @param kt - Transparency factor
 * @param nShininess - object Shininess
 */
public Geometry(int color,double kd,double ks, double kr, double kt, double nShininess) 
{
	this._color = new Color(color);
	this._material= new Material(kd, ks, kr, kt, nShininess);
}



/**
 * A constructor who receives color and material
 * @param color - color of the Geometry
 * @param material - material of the Geometry
 */
public Geometry(Color color,Material material) 
{
	this._color = color;
	this._material= new Material(material);
}

/**
 * A constructor who receives color
 * @param color - color of the Geometry
 */
public Geometry(Color color) 
{
	this._color = color;
	this._material= new Material();
}


/**
 * Copy constructor
 * @param temp - The same object is copied
 */
public Geometry(Geometry temp) 
{
	this._color = temp._color;
	this._material= new Material(temp._material);
}

/**
 * get color
 * @return _color - color of the Geometry
 */
public Color get_color()
{
	return _color;
}

/**
 * set _color
 * @param color - color of the Geometry
 */
public void set_color(Color color) 
{
	this._color = color;
}


/**
 * get material
 * @return _material - material of the Geometry
 */
public Material get_material()
{
	return new Material(_material);
}

/**
 * set material 
 * @param _material - material of the Geometry
 */
public void set_material(Material material)
{
	this._material = new Material(material);
}

/**
 * A function that prints the class
 */
@Override
public String toString() 
{
	return "Geometry [_color=" + _color + ", _material=" + _material + "]";
}

/**
 * A function that checks whether 2 values are equal to one another
 */
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Geometry other = (Geometry) obj;
	if (_color == null) {
		if (other._color != null)
			return false;
	} else if (!_color.equals(other._color))
		return false;
	if (_material == null) {
		if (other._material != null)
			return false;
	} else if (!_material.equals(other._material))
		return false;
	return true;
}



/**
 * A function that returns the normal to geometry at the given point
 * @param point - point to get the normal
 * @return  vector - normal to Geometry
 */
public abstract Vector getNormal(Point3D point);

/**
 *An abstract function that finds cutting points in geometry according to the given ray
 * @param ray - ray to get the intersection points
 * @return list of intersection point accirding to ray on plane
 */
public abstract ArrayList<Point3D> findIntersections(Ray ray);

/**
 * Function that returns color 
 * @return color - color of the Geometry
 */
public Color getEmmission()
{
  return this._color;
}
}

