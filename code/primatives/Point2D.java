	package primatives;
	
	
	/**
	 * 
	 * Point2D is the Class that represent Point in tow Dimensions *
	 */
	
	public class Point2D {
	  protected Coordinate _x;
	  protected Coordinate _y;
	  
	  /**
	   * A constructor that gets 2 coordinates
	   * @param x - x Coordinate
	   * @param y - y Coordinate
	   */
	  public Point2D(Coordinate x, Coordinate y) {
	    this._x = new Coordinate(x);
	    this._y = new Coordinate(y);
	  }
	  
	  /**
	   * Copy constructor 
	   * @param temp - The same object is copied
	   */
	  public Point2D(Point2D temp) {
		    this._x = new Coordinate(temp.getX());
		    this._y = new Coordinate(temp.getY());
		  }
	  
	  /**
	   * Default constructor
	   */
	  public Point2D() {
	    this._x =new Coordinate();
	    this._y = new Coordinate();
	  }
	  
	  /**
	   * A constructor who gets 2 doubles
	   * @param x - x Coordinate
	   * @param y - y Coordinate
	   */
	public Point2D(double x, double y)
	{
		this._x=new Coordinate(x) ;
		this._y=new Coordinate(y) ;
	}
	  
	  /**
	   * A function that returns the cordinate x
	   * @return x - x Coordinate
	   */
	public Coordinate getX() 
	{
	    return new Coordinate(_x);
	}
	
	  /**
	   * A function that defines the cordinate x
	   * @param x - x Coordinate
	   */
	public void setX(Coordinate x) 
	{
	  this._x = new Coordinate(x);
	}
	  
	/**
	 * A function that defines the cordinata as a double
	 * @param x - x Coordinate
	 */
	public void setX(double x)
	{
	   this._x = new Coordinate(x);
	}
	  
	  /**
	   * A function that returns the cordinate y
	   * @return y - y Coordinate
	   */
	public Coordinate getY() 
	{
	   return  new Coordinate(_y);
	}
	  
	/**
	 * A function that defines the cordinata as a double
	 * @param y - y Coordinate
	 */
	public void setY(double y) 
	{
		this._y = new Coordinate(y);
	}
	
	  /**
	   * A function that defines the cordinate y
	   * @param y - y Coordinate
	   */
	public void setY(Coordinate y) 
	{
	   this._y = new Coordinate(y);
	}
	  
	  /**
	   * Function that prints the point 
	   */
	  @Override
	  public String toString() {
	    return "Point2D [_x=" + _x + ", _y=" + _y + "]";
	  }
	  
	  /**
	   * A function that checks whether 2 points are equal
	   */
	  @Override
	  public boolean equals(Object obj) {
	    if (this == obj)
	      return true;
	    if (obj == null)
	      return false;
	    if (getClass() != obj.getClass())
	      return false;
	    Point2D other = (Point2D) obj;
	    if (_x == null) {
	      if (other._x != null)
	        return false;
	    } else if (!_x.equals(other._x))
	      return false;
	    if (_y == null) {
	      if (other._y != null)
	        return false;
	    } else if (!_y.equals(other._y))
	      return false;
	    return true;
	  }
	  
	}