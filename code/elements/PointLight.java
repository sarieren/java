package elements;

import java.awt.Color;

import primatives.Point3D;
import primatives.Vector;


/**
 * PointLight is class that represent Point Light in scene
 */

public class PointLight extends Light{
      Point3D _position; //position of the light in scene
      double _kc; //kc const factor
      double _kl; //kl linear factor
      double _kq; //Kq qubic factor
      
      /**
       * A constructor that accepts values
       * @param color - color of the light
       * @param position - position of the light in scene
       * @param kc - kc const factor
       * @param kl - kl linear factor
       * @param kq - Kq qubic factor
       */
	public PointLight(Color color, Point3D position, double kc, double kl, double kq) {
		super(color);
		this._position = new Point3D(position);
		if(kc<0)  _kc = 0;
		else if(kc>1) _kc = 1;
		 else     _kc = kc;
		
		 if(kl<0) _kl = 0;
		 else if(kl>1) _kl = 1;
		 else     _kl = kl;
		 
		 if(kq<0) _kq = 0;
		 else if(kq>1) _kq = 1;
		 else     _kq = kq;
	}
	
	/**
	 * Default constructor
	 */
	public PointLight() {
		super();
		this._position = new Point3D();
		this._kc = 0;
		this._kl = 0.1;
		this._kq = 0.1;
	}
	
	/**
	 * Copy constructor
	 * @param temp - The same object is copied
	 */
	public PointLight(PointLight temp) {
		super(temp._color);
		this._position = new Point3D(temp._position);
		this._kc = temp._kc;
		this._kl = temp._kl;
		this._kq = temp._kq;
	}
	
	/**
	 * A function that returns a position of the light in scene
	 * @return position - position of the light in scene
	 */
	public Point3D getPosition() {
		return new Point3D(_position);
	}

	/**
	 * A function that defines a 3-D point
	 * @param position - position of the light in scene
	 */
	public void setPosition(Point3D position) {
		this._position = new Point3D(position);
	}

	/**
	 * Function that returns kc
	 * @return kc - kc const factor
	 */
	public double getkc() {
		return _kc;
	}

	/**
	 * function that defines kc
	* @param kc - kc const factor
	 */
	public void setkc(double kc) {
		this._kc = kc;
	}

	/**
	 * Function that returns kl 
	 * @return kl - kl linear factor
	 */
	public double getkl() {
		return _kl;
	}

	/**
	 * function that defines kl
	 * @param kl - kl linear factor
	 */
	public void setkl(double kl) {
		this._kl = kl;
	}

	/**
	 * Function that returns kq 
	 * @return kq - Kq qubic factor 
	 */
	public double getkq() {
		return _kq;
	}

	/**
	 * function that defines kq 
	 * @param kq - Kq qubic factor
	 */
	public void setkq(double kq) {
		this._kq = kq;
	}

	
/**
 * A function that prints the point Light
 */
	@Override
	public String toString() {
		return "PointLight [_position=" + _position + ", _kc=" + _kc + ", _kl=" + _kl + ", _kq=" + _kq + "]";
	}

	/**
	 * A function that checks whether 2 objects are equal to each other
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PointLight other = (PointLight) obj;
		if (_kc != other._kc)
			return false;
		if (_kl != other._kl)
			return false;
		if (_kq != other._kq)
			return false;
		if (_position == null) {
			if (other._position != null)
				return false;
		} else if (!_position.equals(other._position))
			return false;
		return true;
	}
	
	
	
	
	

	
	/**
	 *  A function that returns the actual amount of light According to the Fong model
	 * @param point - point to find Intensity
	 * @return actual amount of light
	 */
	public Color getIntensity(Point3D point)
	{
		double d = _position.distance(point);
		Color I0 = this._color;
		double mechane = _kc +(_kl*d)+(_kq*d*d);
		double ILred = I0.getRed()/Math.max(mechane,1);
		if(ILred>255) ILred= 255;
		if(ILred<0) ILred = 0;
		double ILgreen = I0.getGreen()/Math.max(mechane, 1);
		if(ILgreen>255) ILgreen= 255;
		if(ILgreen<0) ILgreen = 0;
		double ILblue = I0.getBlue()/Math.max(mechane, 1);
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
		Vector help =  new Vector(_position, point);
		help.normalize();
		return help;
	}
}




























