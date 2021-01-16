package elements;

import java.awt.Color;

import primatives.Point3D;
import primatives.Vector;


public class DirectionalLight extends Light{
	protected Vector _direction;

	/**
	 * A constructor that receives direction vector
	 * @param direction - vector direction of light
	 */
	public DirectionalLight(Vector direction) {
		super(new Color(0, 0, 0));
		this._direction = new Vector(direction);
	}
	
	/**
	 * A constructor that gets vector and color
	 * @param color - color of Directional Light
	 * @param direction - vector direction of light
	 */
	public DirectionalLight(Color color, Vector direction) 
	{
		super(color);
		this._direction = new Vector(direction);
	}
	
	/**
	 * Default constructor
	 */
	public DirectionalLight() 
	{
		super(new Color(0,0,0));
		this._direction = new Vector(0,0,1);
	}
	
	/**
	 * A constructor that gets color
	 * @param color - color of Directional light
	 */
	public DirectionalLight(Color color) 
	{
		super(color);
		this._direction = new Vector();
	}
	
	/**
	 * Copy constructor
	 * @param temp - The same object is copied
	 */
	public DirectionalLight(DirectionalLight temp) 
	{
		super(temp._color);
		this._direction = new Vector(temp._direction);
	}
	
	/**
	 * A function that returns vector direction
	 * @return _direction - direction vector of light
	 */
	public Vector getDirection() {
		return new Vector(_direction);
	}

	/**
	 * A function that defines vector direction 
	 * @param direction - direction vector of light
	 */
	public void setDirection(Vector direction) {
		this._direction = new Vector(direction);
	}

	/**
	 * A function that checks whether 2 elements are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DirectionalLight other = (DirectionalLight) obj;
		if (_direction == null) {
			if (other._direction != null)
				return false;
		} else if (!_direction.equals(other._direction))
			return false;
		return true;
	}

	/**
	 * Function that prints the DirectionalLight
	 */
	@Override
	public String toString() {
		return "DirectionalLight [_direction=" + _direction + "]";
	}
	
	/**
	 *  A function that returns the actual amount of light
	 *  @return color - actual amount of light
	 */
	public Color getIntensity(Point3D point)
	{
		return this._color;
	}
	
	/**
	 * A function that returns the vector from the light source to 
	 * the point it receives as a parameter
	 * @param pount - point to find
	 * @return normal vector 
	 */

	public Vector getL(Point3D point)
	{
		Vector x = new Vector(_direction);
		x.normalize();
		return new Vector(x);
	}
}
