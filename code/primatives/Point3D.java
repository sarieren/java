	package primatives;
	
	
	import primatives.Vector;
	
	
	/**
	 * Point3D is the Class that represent Point in three Dimensions *
	 */
	public class Point3D extends Point2D {
	  protected Coordinate _z;
	
	  /**
	   * Default constructor
	   */
	  public Point3D() {
	    super();
	    this._z = new Coordinate();
	  }
	  
	  /**
	   * A constructor that receives 3 coordinates
	   * @param x - x Coordinate
	   * @param y - y Coordinate
	   * @param z - z Coordinate
	   */
	public Point3D(Coordinate x, Coordinate y, Coordinate z)
	{
	   super(x, y);
	   this._z = new Coordinate(z);
	}
	  
	  /**
	   * A constructor who gets one Cordinata
	   * @param z - z Coordinate
	   */
	public Point3D(Coordinate z) 
	{
		super(new Coordinate(), new Coordinate());
		this._z = new Coordinate(z);
	}
	
	/**
	 * A constructor receiving 2 coordinates
	 * @param x - x Coordinate
	 * @param y - y Coordinate
	 */
	public Point3D(Coordinate x, Coordinate y)
	{
		super(x, y);
		this._z = new Coordinate();
	}
		
	 /**
	  * Copy constructor
	  * @param temp - The same object is copied
	  */
	 public Point3D(Point3D temp) 
	 {
	     super(temp.getX(),temp.getY());
	     this._z = new Coordinate(temp._z);
	}
	
	 /**
	  * A constructor that gets a two-dimensional point
	  * @param p2 - point 2D
	  */
	  public Point3D(Point2D p2) 
		{
			super(p2);
			this._z = new Coordinate();
		}
	  
	  /**
	   * A constructor who gets 3 doubles
	   * @param x - x double
	   * @param y - y double
	   * @param z - z double
	   */
	  public Point3D(double x, double y, double z)
	  {
		  super(new Coordinate(x),new Coordinate(y));
		  _z = new Coordinate(z);
	  }
	  
	  /**
	   * A function that returns a cordinate z
	   * @return z - z Coordinate
	   */
	  public Coordinate getZ() 
	  {
	    return new Coordinate(_z);
	  }
	
	  /**
	   * A function that modifies a point using a double
	   * @param z - z double
	   */
	public void setZ(double z) 
	{
	  this._z = new Coordinate(z);
	}
	  /**
	   * A function that defines a z ccordinate
	   * @param z - z Coordinate
	   */
	  public void setZ(Coordinate z) {
	    this._z = new Coordinate(z);
	  }
	
	  /**
	   * A function that prints a 3-D point
	   */
	  @Override
	  public String toString() {
	    return "Point3D:("+ getX() + "," + getY() +"," + getZ() + ")";
	 
	  }
	
	  /**
	   * A function that checks whether two 3-D points are equal
	   */
	  @Override
	  public boolean equals(Object obj) {
	    if (this == obj)
	      return true;
	    if (!super.equals(obj))
	      return false;
	    if (getClass() != obj.getClass())
	      return false;
	    Point3D other = (Point3D) obj;
	    if (_z == null) {
	      if (other._z != null)
	        return false;
	    } else if (!_z.equals(other._z))
	      return false;
	    return true;
	  }
	  
	  /**
	   * A function that adds to a three-dimensional vector point
	   * @param vector - Vector to add
	   */
		
		public void add(Vector vector) 
	  {	
			this._x.setCoordinate(this.getX().getCoordinate()+vector.getHead().getX().getCoordinate());
			this._y.setCoordinate(this.getY().getCoordinate()+vector.getHead().getY().getCoordinate());
			this._z.setCoordinate(this.getZ().getCoordinate()+vector.getHead().getZ().getCoordinate());
	
	  }
	  
		/**
		 * A function that adds a 3-D point to a 3-D point
		 * @param point - point to add
		 */
	  public void add(Point3D point)
	  {
	    this.getX().add(point.getX());
	    this.getY().add(point.getY());
	    this.getZ().add(point.getZ());
	  }
	  
	  /**
	   * A function that connects between two 3-point points and returns a new point
	   * @param point - point to add
	   * @return new Point3D - connects between two 3-point points
	   */
	  public Point3D addP(Point3D point)
	  {
		  Point3D help= new Point3D();
		  help.setX(new Coordinate(_x.getCoordinate()+point.getX().getCoordinate()));
		  help.setY(new Coordinate(_y.getCoordinate()+point.getY().getCoordinate()));
		  help.setZ(new Coordinate(_z.getCoordinate()+point.getZ().getCoordinate()));
		  return new Point3D(help);
	  }
	  
	  /**
	   * A function that connects a three-dimensional point vector and returns a new point
	   * @param vector - Vector to add
	   * @return new vector - connects a three-dimensional point vector
	   */
	  public Vector addV(Vector vector)
	  {
		  Point3D help= new Point3D();
		  help.setX(this.getX().addV(vector.getHead().getX()));
		  help.setY(this.getY().addV(vector.getHead().getY()));
		  help.setZ(this.getZ().addV(vector.getHead().getZ()));
		  return new Vector(help);
	  }
	 
	  
	  /**
	   * A function that is missing between two 3-point points and returns a new point
	   * @param point - point to subtract
	   * @return new Point3D - subtract between two 3-point points
	   */
	  public Point3D subtract(Point3D point)
	  {
		  Point3D help= new Point3D();
		  help.setX(new Coordinate(_x.getCoordinate()-point.getX().getCoordinate()));
		  help.setY(new Coordinate(_y.getCoordinate()-point.getY().getCoordinate()));
		  help.setZ(new Coordinate(_z.getCoordinate()-point.getZ().getCoordinate()));
		  return new Point3D(help);
	  }
	  
	  
	  /**
	   * A function that is missing between two 3D-point points and returns a new vector
	   * @param point - point to subtract
	   * @return new vector - subtract between two 3-point points
	   */
		public Vector subtractV(Point3D temp) {
			 Point3D help= new Point3D();
			  help.setX(new Coordinate(_x.getCoordinate()-temp.getX().getCoordinate()));
			  help.setY(new Coordinate(_y.getCoordinate()-temp.getY().getCoordinate()));
			  help.setZ(new Coordinate(_z.getCoordinate()-temp.getZ().getCoordinate()));
			  return new Vector(help);
		}
	  
	  /**
	   * A function that is drawn from a three-dimensional vector point
	   * @param vector - vector to subtract
	   */
	  public void subtract(Vector vector)
	  {
		    this.setX(this.getX().subtractV(vector.getHead().getX()));
			this.setY(this.getY().subtractV(vector.getHead().getY()));
			this.setZ(this.getZ().subtractV(vector.getHead().getZ()));
	  }
	  
	  /**
	   * A function that excludes from a 3-D point a second point
	   * @param point - point to subtract
	   */
	  public void subtractP(Point3D point)
	  {	
			this.getX().subtract(point.getX());
			this.getY().subtract(point.getY());
			this.getZ().subtract(point.getZ());
	  }
			
		
	  /**A function that adds a number to 
	   * any 3-point point and returns it as a new vector
	   * @param y - number to add point3d
	   * @return new vector - add between  3-point and number
	   */
	  public Vector add(double y)
	  {
	    Vector help = new Vector(getX().getCoordinate() + y, getY().getCoordinate() + y,getZ().getCoordinate() + y);
	    return new Vector(help);
	  }
	  
		/**
		 * A function that returns a distance between 2 points
		 * @param point - The point from which the distance is checked
		 * @return distance - distance between 2 points
		 */
	  public double distance(Point3D point)
	  { 
		  double distance=Math.sqrt(Math.pow(point.getX().getCoordinate()-this.getX().getCoordinate(),2)+
				  Math.pow(point.getY().getCoordinate()-this.getY().getCoordinate(),2)+
				  Math.pow(point.getZ().getCoordinate()-this.getZ().getCoordinate(),2));
		  return distance;
	  }
	  
	
	}