package elements;

import java.awt.Color;

import primatives.Point3D;
import primatives.Vector;

/**
 * Light class is abstract class for all types of com.ud_avi.raytrace.lights
 */

abstract public class Light {
  protected Color _color;
  
/**
 * A constructor that gets color
 * @param color - color of the light
 */
public Light(Color color) {
	super();
	if(color!=null)
	{
		int red = color.getRed();
		if(red > 255) red = 255;
		int green = color.getGreen();
		if(green > 255)  green = 255;
		int blue = color.getBlue();
		if(blue > 255) blue = 255;
		this._color = new Color(red, green, blue);
	}
	else
		_color = new Color(0,0,0);
}

/**
 * Default constructor
 */
public Light() {
	_color = new Color(0,0,0);
}

/**
 * Copy constructor
  * @param temp - The same object is copied
 */
public Light(Light temp) {
	super();
     this._color = temp._color;
}

/**
 * Function that returns color
 * @return color - color of light
 */
public Color getColor() {
	if(_color != null)
		return  new Color(_color.getRGB());
    else
    	return _color = new Color(0,0,0);

}


/**
 * Function that defines color of light
 * @param color -  color of light
 */
public void setColor(Color color) {
	if(color != null)
		this._color =  new Color(color.getRGB());
		else
			_color = new Color(0,0,0);

}


/**
 * A function that prints color
 */
@Override
public String toString() {
	return "Light [_color=" + _color + "]";
}

/**
 * A function that checks whether 2 
 * objects are equal to each other
 */
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Light other = (Light) obj;
	if (_color == null) {
		if (other._color != null)
			return false;
	} else if (!_color.equals(other._color))
		return false;
	return true;
}

    /**
	 *  A function abstract that returns the actual amount of light
	 * @param point - Where the light is
	 * @return actual amount of light
	 */
abstract public Color getIntensity(Point3D point);

 
/**
 * A function abstract that returns the vector from the light source to 
 * the point it receives as a parameter 
 * @param point - point to find
 * @return normal vector
 */
abstract public Vector getL(Point3D point);


}
  

