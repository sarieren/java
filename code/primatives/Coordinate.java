package primatives;

/**
* Coordinate is the Class that represent Coordinate in some Dimension
*/
public class Coordinate {
  protected double _coordinate;
  
  
  /**
   * Default constructor coordinate
   */
  public Coordinate() {
    this._coordinate = 0;
  }
  
  /**
   * A constructor who gets a double
   * @param x - A value from which Cordinarte builds
   */
  public Coordinate(double x)
  {
	  this._coordinate = x;
  }
  
  /**
   * constructor copy
   * @param temp - The same object is copied
   */
  public Coordinate(Coordinate temp) {
    this._coordinate = temp.getCoordinate();
  }
  

  /**
   * Cordinata returns
   * @return coordinate - A value from which Cordinarte builds
   */
  public double getCoordinate() {
    return _coordinate;
  }

  /**
   * set coordinate
   * @param coordinate - A value from which Cordinarte builds
   */
  public void setCoordinate(double coordinate) {
    this._coordinate = coordinate;
  }

  /**
   * print string: coordinate
   */
  @Override
  public String toString() {
    return ""+ _coordinate ;
  }

  
  @Override
  /**
   * Checks whether the two coordinates are equal
   */
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Coordinate other = (Coordinate) obj;
    if (Double.doubleToLongBits(_coordinate) != Double.doubleToLongBits(other._coordinate))
      return false;
    return true;
  }
  
  /**
   * Connects 2 coordinates
   * @param other - other Coordinate
   */
  public void add(Coordinate other) 
  {
    double temp=this.getCoordinate()+ other.getCoordinate();
    this.setCoordinate(temp);
  }
  

  /**
   * Connects 2 coordinates and returns a new cordynthesis
   * @param other - other Coordinate
   * @return new Coordinate
   */
  public Coordinate addV(Coordinate other) 
  {
    double temp=this.getCoordinate()+ other.getCoordinate();
    Coordinate help = new Coordinate(temp);
    return help;
  }
  
  /**
   * Multiply between 2 coordinates
   * @param other - other Coordinate
   * @return new Coordinate - Multiply between 2 coordinates
   */
  public double mul(Coordinate other)
  {
    return this._coordinate*other.getCoordinate();
  }
  
  /**
   * Subtract between 2 coordinates
   * @param other- other Coordinate
   */
  public void subtract (Coordinate other)
  {
    double temp=this.getCoordinate()- other.getCoordinate();
    this.setCoordinate(temp);
  }
  
 /**
  * Subtracts between 2 coordinates and returns a new coordinate
  * @param other - other Coordinate
  * @return new Coordinate - Subtract between 2 coordinates
  */
  public Coordinate subtractV(Coordinate other) 
  {
    double temp=this.getCoordinate() - other.getCoordinate();
    Coordinate help = new Coordinate(temp);
    return help;
  }
}