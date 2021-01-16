	package primatives;
	
	/**
	 * 
	 * Ray is the Class that represents Ray in three Dimensions
	 *
	 */
	public class Ray {
	  protected Point3D _POO;
	  protected Vector _direction;
	 
	  /**
	   * Default constructor
	   */
	 public Ray() {
	    this._POO = new Point3D();
	    this._direction =new  Vector();
	    this._direction.normalize();
	  }
	 
	 /**
	  * A constructor that receives a vector and a point and builds a beam
	  * @param POO - Point of the Ray
	  * @param direction - Direction of the Ray
	  */
	public Ray(Point3D POO, Vector direction) {
	  this._POO = new Point3D(POO);
	  this._direction = new Vector(direction);
	  this._direction.normalize();
	}
	
	/**
	 * Copy constructor
	 * @param temp - The same object is copied
	 */
	public Ray(Ray temp) {
		  this._POO = temp.getPOO();
		  this._direction = temp.getDirection();
		  this._direction.normalize();
		}
	
	/**
	 * Function that returns a three-dimensional point of the ray
	 * @return POO - Point of the Ray
	 */
	public Point3D getPOO() {
	  return new Point3D(_POO);
	}
	
	/**
	 * A function that defines a three-dimensional point of the ray
	 * @param POO - Point of the Ray
	 */
	public void setPOO(Point3D POO) {
	  this._POO = new Point3D(POO);
	}
	
	/**
	 * A function that returns the distance of the ray
	 * @return direction - Direction of the Ray
	 */
	public Vector getDirection() {
	  return new Vector(_direction);
	}
	
	/**
	 * A function that defines the distance of the ray
	 * @param direction - - Direction of the Ray
	 */
	public void setDirection(Vector direction) {
	  this._direction = new Vector(direction);
	}
	
	/**
	 * Function that prints the ray
	 */
	@Override
	public String toString() {
	  return "Ray [_POO=" + _POO + ", _direction=" + _direction + "]";
	}
	
	/**
	 * A function that checks whether 2 rays are equal
	 */
	@Override
	public boolean equals(Object obj) {
	  if (this == obj)
	    return true;
	  if (obj == null)
	    return false;
	  if (getClass() != obj.getClass())
	    return false;
	  Ray other = (Ray) obj;
	  if (_POO == null) {
	    if (other._POO != null)
	      return false;
	  } else if (!_POO.equals(other._POO))
	    return false;
	  if (_direction == null) {
	    if (other._direction != null)
	      return false;
	  } else if (!_direction.equals(other._direction))
	    return false;
	  return true;
	}
	 
	 
	}