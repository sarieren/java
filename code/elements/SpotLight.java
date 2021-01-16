package elements;

import java.awt.Color;

import primatives.Point3D;
import primatives.Vector;

public class SpotLight extends 	PointLight{
   Vector _direction; //direction of the spot

   /**
    * Constructor receives values
    * @param color - color of the light
    * @param position - position of the light in scene
	* @param kc - kc const factor
	* @param kl - kl linear factor
	* @param kq - kq qubic factor
	* @param direction - direction of the spot
    */
public SpotLight(Color color, Point3D position, double kc, double kl, double kq, Vector direction) {
	super(color, position, kc, kl, kq);
	this._direction = new Vector(direction);
} 
  

/**
 * Default constructor
 */
public SpotLight() {
	super();
	this._direction = new Vector();
}

/**
 * Copy constructor
 * @param temp - The same object is copied
 */
public SpotLight(SpotLight temp) {
	super(temp._color, temp._position, temp._kc, temp._kl, temp._kq);
	this._direction = new Vector(temp._direction);
} 


/**
 * A function that returns the the direction vector
 * @return direction - direction of the spot
 */
public Vector getDirection() {
	return new Vector(_direction);
}


/**
 * Function that defines the direction vector
 * @param direction - direction of the spot
 */
public void setDirection(Vector direction) {
	this._direction = new Vector(direction);
}


/**
 * A function that prints the class
 */
@Override
public String toString() {
	return "SpotLight [_direction=" + _direction + "]";
}



/**
 * A function that checks whether 
 * 2 objects are equal to each other
 */
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!super.equals(obj))
		return false;
	if (getClass() != obj.getClass())
		return false;
	SpotLight other = (SpotLight) obj;
	if (_direction == null) {
		if (other._direction != null)
			return false;
	} else if (!_direction.equals(other._direction))
		return false;
	return true;
} 


/**
 *  A function that returns the actual amount of light
 * @param point - point to find Intensity
 * @return actual amount of light
 */
public Color getIntensity(Point3D point)
{
	Vector L= new Vector(getPosition(),point);
	L.normalize();//L
	Vector D = new Vector(_direction);
	D.normalize();
	double DL= D.dotProduct(L);
	double d = _position.distance(point);//d
	double mechane = _kc +(_kl*d)+(_kq*d*d);
	Color I0 = this._color;
	double ILred = Math.abs(I0.getRed()*DL/(Math.max(mechane, 1)));
	if(ILred>255) ILred= 255;
	if(ILred<0) ILred = 0;
	double ILgreen = Math.abs(I0.getGreen()*DL/Math.max(mechane, 1));
	if(ILgreen>255) ILgreen= 255;
	if(ILgreen<0) ILgreen = 0;
	double ILblue = Math.abs(I0.getBlue()*DL/Math.max(mechane, 1));
	if(ILblue>255) ILblue= 255;
	if(ILblue<0) ILblue = 0;	
	Color IL = new Color((int)ILred, (int)ILgreen, (int)ILblue);
	return IL;
}

/**
 * A function  that returns the vector from the light source to 
 * the point it receives as a parameter
 * @param point - point to find 
 * @return normal vector 
 */
public Vector getL(Point3D point) 
{		
	
	return super.getL(point);
}		

}
