package primatives;


	/**
	 * Material is class that represent Material of geometry
	 */
	
	public class Material 
	{
		protected double _kd; 
	protected double _ks; 
	protected double _kr;
	protected double _kt;
	protected double _nShininess; 
	
	
	
	/**
	 * Default constructor
	 */
	public Material()
	{
		_kd = 1;
		_ks = 1;
		_kr = 0;
		_kt = 0;
		_nShininess = 19;
	}
	
	/**
	 * constructor
	 * @param kd - kd Diffuse factor
	 * @param ks - ks Specular factor
	 * @param kr - kr Reflection factor
	 * @param kt - kt Transparency factor
	 * @param nShininess - nShininess object Shininess
	 */
		public Material(double kd,double ks, double kr, double kt,double nShininess)
		{
			if(kd<0) _kd = 0;
			else if(kd>1) _kd = 1;
			else     _kd = kd;
	 
			if(ks<0) _ks = 0;
			else if(ks>1) _ks = 1;
			else     _ks = ks;
	 
			if(kr<0) _kr = 0;
			else if(kr>1) _kr = 1;
			else     _kr = kr;
	 
			if(kt<0) _kt = 0;
			else if(kt>1) _kt = 1;
			else     _kt = kt;
	 
			_nShininess = nShininess;
	 
		}
		/**
	 * Copy constructor
	 * @param temp - The same object is copied
	 */
	public Material(Material temp)
	{
		_kd = temp._kd;
		_ks = temp._ks;
		_kr = temp._kr;
		_kt = temp._kt;
		_nShininess = temp._nShininess;
	}
	
	/**
	 * set _kr - kr Reflection factor
	 * @return kr - kr Reflection factor
	 */
	public double get_kr() 
	{
		return _kr;
	}
	
	/**
	 * set _kr
	 * @param _kr - kr Reflection factor
	 */
	public void set_kr(double kr) {
		this._kr = kr;
	}
	
	/**
	 * set _kt
	 * @return _kt - kt Transparency factor
	 */
	public double get_kt() {
		return _kt;
	}
	
	/**
	 * set _kt
	 * @param _kt - kt Transparency factor
	 */
	public void set_kt(double _kt) {
		this._kt = _kt;
	}
	
	/**
	 * get _kd
	 * @return _kd - kd Diffuse factor
	 */
	public double get_kd() 
	{
		return _kd;
	}
	
	/**
	 * set _kd
	 * @param kd - kd Diffuse factor
	 */
	public void set_kd(double kd)
	{
		this._kd = kd;
	}
	
	/**
	 * get _ks
	 * @return _ks - ks Specular factor
	 */
	public double get_ks()
	{
		return _ks;
	}
	
	/**
	 * set _ks
	 * @param _ks - ks Specular factor
	 */
	public void set_ks(double ks)
	{
		this._ks = ks;
	}

	/**
	 * get _nShininess
	 * @return _nShininess - nShininess object Shininess
	 */
	public double get_nShininess()
	{
		return _nShininess;
	}

	/**
	 * set _nShininess
	 * @param _nShininess - nShininess object Shininess
	 */
	public void set_nShininess(double nShininess)
	{
		this._nShininess = nShininess;
	}
	
	
	
	
	/**
	 * A function that checks whether two materials are equal to each other
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		if (Double.doubleToLongBits(_kd) != Double.doubleToLongBits(other._kd))
			return false;
		if (Double.doubleToLongBits(_kr) != Double.doubleToLongBits(other._kr))
			return false;
		if (Double.doubleToLongBits(_ks) != Double.doubleToLongBits(other._ks))
			return false;
		if (Double.doubleToLongBits(_kt) != Double.doubleToLongBits(other._kt))
			return false;
		if (Double.doubleToLongBits(_nShininess) != Double.doubleToLongBits(other._nShininess))
			return false;
		return true;
	}
	
	/**
	 * Prints the material
	 */
	@Override
	public String toString() {
		return "Material [_kd=" + _kd + ", _ks=" + _ks + ", _kr=" + _kr + ", _kt=" + _kt + ", _nShininess=" + _nShininess
				+ "]";
	}
	
	
	
	
	
	}
	
