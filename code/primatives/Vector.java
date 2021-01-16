	package primatives;
	
	
	/**
	 * Vector is the Class that represent Vector in tree Dimensions 
	 */
	
	public class Vector {
	  protected Point3D _head;
	
	  /**
	   * A constructor that receives a 3-D point and builds a vector
	   * @param _head - haed of the vector
	   */
	public Vector(Point3D head) {
	  super();
	  this._head = new Point3D(head);
	}
	/**
	 * Default constructor
	 */
	public Vector() {
		super();
	    this._head = new Point3D();
	}
	
	/**
	 * Copy constructor
	 * @param temp - The same object is copied
	 */
	public Vector(Vector temp) {
		  super();
		  this._head = temp.getHead();
		}
	
	/**
	 * A constructor who receives 3 doubles and builds a vector
	 * @param x - x point
	 * @param y - y point
	 * @param z - z point
	 */
	public Vector(double x, double y, double z)
	{
		_head = new Point3D(x, y, z);
	}
	
	/**
	 * A constructor that receives 2 3-D points and builds a vector
	 * @param p1 - one point
	 * @param p2 - two point
	 */
	public Vector(Point3D p1, Point3D p2){
		  Coordinate x=new Coordinate(p2.getX().getCoordinate()-p1.getX().getCoordinate());
		  Coordinate y=new Coordinate(p2.getY().getCoordinate()-p1.getY().getCoordinate());
		  Coordinate z=new Coordinate(p2.getZ().getCoordinate()-p1.getZ().getCoordinate());
		    this._head = new Point3D(x,y,z);
	}
	
	
	
	
	/**
	 * Function that returns a vector
	 * @return head - haed of the vector
	 */
	public Point3D getHead() {
	  return new Point3D(_head);
	}
	
	/**
	 * A function that defines a vector
	 * @param head - haed of the vector
	 */
	public void setHead(Point3D head) {
	  this._head = new Point3D(head);
	}
	
	/**
	 * Function that prints vector
	 */
	@Override
	
		public String toString() 
		  {
		    return "Vector: (" + _head._x +","+_head._y + ","+_head.getZ()+")";
		  }
	
	
	/**
	 * A function that checks whether 2 vectors are equal
	 */
	@Override
	public boolean equals(Object obj) {
	  if (this == obj)
	    return true;
	  if (obj == null)
	    return false;
	  if (getClass() != obj.getClass())
	    return false;
	  Vector other = (Vector) obj;
	  if (_head == null) {
	    if (other._head != null)
	      return false;
	  } else if (!_head.equals(other._head))
	    return false;
	  return true;
	}
	
	/**
	 * The function connects the first vector to the second vector  
	 * @param vector - vector who add for first vector
	 */
	public void add(Vector vector) 
	{
		this._head.add(vector);
	}
	
	/**
	 * A function that returns a new vector which is a connection of 2 vectors
	 * @param vector - vector who add for first vector
	 * @return new vector - Connection of 2 vectors
	 */
	public Vector addV(Vector vector)
	{
		  Vector temp = new Vector(this._head);
		  temp.add(vector);
		  return temp;
	}
	
	/**
	 * A function that returns the first vector to the second vector
	 * @param vector - vector who subtract for first vector
	 */
	public void subtract(Vector vector )
	{
	  this._head.subtract(vector);
	}
	
	/**
	 * A function that returns a new vector which is subtraction of 2 vectors
	 * @param vector - vector who subtract for first vector
	 * @return new vector - subtract of 2 vectors
	 */
	public Vector subtractV(Vector vector)
	{
		  Vector temp = new Vector(this._head);
		  temp.subtract(vector);
		  return temp;
	}
	
	/**
	 * A function that multiplies a scalar vector
	 * @param scalingFactor - the number to Multi
	 */
	public void scale(double scalingFactor)
	{
	  Coordinate helpX = new Coordinate(scalingFactor*getHead().getX().getCoordinate());
	  Coordinate helpY = new Coordinate(scalingFactor*getHead().getY().getCoordinate());
	  Coordinate helpZ = new Coordinate(scalingFactor*getHead().getZ().getCoordinate());
	  setHead(new Point3D(helpX, helpY, helpZ));
	}
	
	/**
	 * A function that multiplies a scalar vector and return new Vector
	 * @param scalingFactor  - scalar to Multi
	 * @return new vector - The doubled vector
	 */
	public Vector scaleV(double scalingFactor)
	{
	  Coordinate helpX = new Coordinate(scalingFactor*getHead().getX().getCoordinate());
	  Coordinate helpY = new Coordinate(scalingFactor*getHead().getY().getCoordinate());
	  Coordinate helpZ = new Coordinate(scalingFactor*getHead().getZ().getCoordinate());
	  Vector v = new Vector(new Point3D(helpX, helpY, helpZ));
	  return v;
	}
	
	
	/**
	 * Function that returns the length of the vector
	 * @return Length of vector 
	 */
	public double length()
	{
	   return Math.sqrt(Math.pow(getHead().getX().getCoordinate(), 2) + Math.pow(getHead().getY().getCoordinate(), 2)
	   					+ Math.pow(getHead().getZ().getCoordinate(), 2));
	}
	
	/**
	 * Multiples between 2 vectors and returns a double
	 * @param vector - vector who multi for first vector
	 * @return dotProduct -  multi vector
	 */
	public double dotProduct(Vector vector)
	{
	  double dotX= _head._x.mul(vector._head._x);
	  double dotY= _head._y.mul(vector._head._y);
	  double dotZ= _head._z.mul(vector._head._z);
	  return dotX+dotY+dotZ;    
	  
	}
	
	
	
	/**
	 * Multiples between 2 vectors and returns a vector
	 * @param vector - vector who multi for first vector
	 * @return crossProduct vector who multi for first vector
	 */
	public Vector crossProduct(Vector vector)
	{
		
		    Point3D cross = new Point3D();
		    double coord1=(this._head._y.mul(vector._head._z));
		    double coord2=(this._head._z.mul(vector._head._y));
		    cross.setX(coord1-coord2);
		    coord1=(this._head._z.mul(vector._head._x));
		    coord2=(this._head._x.mul(vector._head._z));
		    cross.setY(coord1-coord2);
		    coord1=(this._head._x.mul(vector._head._y));
		    coord2=(this._head._y.mul(vector._head._x));
		    cross.setZ(coord1-coord2);
		    return new Vector(cross);
		  }
	
	 
	/**
	 * Normalization vector
	 */
	public void normalize() 
	{
		
			double length=this.length();
			this._head.setX(this.getHead().getX().getCoordinate()/length);  
			this._head.setY(this.getHead().getY().getCoordinate()/length);  
			this._head.setZ(this.getHead().getZ().getCoordinate()/length);  
	}
	
	}
