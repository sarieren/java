package elements;

import java.awt.Color;

import primatives.Point3D;


public class AmbientLight{

	protected Color _color;
	protected double _Ka = 0.1;
	
	
	/**
	 * A function that copies a color to a new color
	 * @param color - The color that copy
	 * @return new color - The color is copied
	 */
	public Color setMyColor(Color color)
	{
		if(color == null)
			return new Color(0,0,0);
		int red = color.getRed();
		if(red>255)red = 255;
		int blue = color.getBlue();
		if(blue>255) blue = 255;
		int green = color.getGreen();
		if(green >255) green = 255;
		return new Color(red, green, blue);
	}
	
	/**
	 * A constructor that gets 3 int's and builds a color
	 * @param x - the red color
	 * @param y - the green color
	 * @param z - the blue color
	 */
	public AmbientLight(int x, int y, int z) 
	{
		if(x>255)x = 255;
		if(y>255) y = 255;
		if(z >255) z = 255;
		this._color = new Color(x, y, z); 
		_Ka = 0.1;
	}
	
	/**
	 * A constructor that accepts values
	 * @param color - The color of ambient light
	 * @param Ka - Restriction factor
	 */
	public AmbientLight(Color color, double ka) {
		this._color = setMyColor(color);
		if(ka<0) _Ka= 0;
		else if(ka>1) _Ka =1;
		else
		_Ka = ka;
	}

	/**
	 * A constructor that gets color
	 * @param color - The color of ambient light
	 */
	public AmbientLight(Color color) 
	{
		this._color =setMyColor(color); 
		_Ka=0.1;
	}
	
	/**
	 * Copy constructor
	 * @param light - The same object is copied
	 */
	public AmbientLight(AmbientLight light) 
	{
		this._color = setMyColor(light._color);
		this.setKa(light.getKa());
	}
	
	/**
	 * Default constructor
	 */
	public AmbientLight() 
	{
		_color = new Color(0,0,0); 
		_Ka=0.1;
	}
	
	/**
	 * Function that returns color
	 * @return color - The color of ambient light
	 */
	public Color getColor() {
		return setMyColor(_color);
	}

	/**
	 * Function that defines color
	 * @param color - The color of ambient light
	 */
	public void setColor(Color color) {
		this._color = setMyColor(color);
	}

	


	/**
	 * function that returns _ka 
	 * @return _ka - Restriction factor
	 */
	public double getKa() {
		return _Ka;
	}

	/**
	 * A function that defines the _ka
	 * @param ka- Restriction factor
	 */
	public void setKa(double ka) {
		if(ka<0) _Ka= 0;
		else if(ka>1) _Ka =1;
		else
		_Ka = ka;
	}

	/**
	 * A function that prints the Ambient Light
	 */
	
	@Override
	public String toString() {
		return "AmbientLight [_color=" + _color + ", _Ka=" + _Ka + "]";
	}
	
	/**
	 * A function that checks whether 
	 * two elements are equal to each other
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AmbientLight other = (AmbientLight) obj;
		if (Double.doubleToLongBits(_Ka) != Double.doubleToLongBits(other._Ka))
			return false;
		if (_color == null) {
			if (other._color != null)
				return false;
		} else if (!_color.equals(other._color))
			return false;
		return true;
	}

	
	/**
	 * A function that returns the actual amount of light
	 * @param point - It is not used
	 * @return color - The original color is double the displacement factor
	 */
	public Color getIntensity(Point3D point)
	{
		int red = (int)(_color.getRed()*_Ka);
		if(red>255)red = 255;
		int blue = (int)(_color.getBlue()*_Ka);
		if(blue>255) blue = 255;
		int green = (int)(_color.getGreen()*_Ka);
		if(green >255) green = 255;
		return new Color(red, green, blue);
	}
}
