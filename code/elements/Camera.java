package elements;

import primatives.Vector;

import java.util.ArrayList;

import primatives.Point3D;
import primatives.Ray;

public class Camera {
	protected Point3D _P0;
	protected Vector _vUp;
	protected Vector _vTo;
	protected Vector _vRight;
	
	/**
	 * CONSTRUCTOR WITH 3 VALUES
	 * @param P0 - Center point
	 * @param vUp - vector up
	 * @param vTo - vector towards
	 */
	public Camera(Point3D P0, Vector vUp, Vector vTo) {
		this._P0 = new Point3D(P0);
		this._vUp = new Vector(vUp);
		this._vTo = new Vector(vTo);
		this._vRight = new Vector(vTo.crossProduct(vUp));
	}
	
	/**
	 *  A constructor that receives 2-way rays
	 * @param vUp - vector up
	 * @param vTo - vector towards
	 */
		public Camera( Vector vUp, Vector vTo) {
			this._P0=new Point3D(0,0,0);
			this._vUp = new Vector(vUp);
			this._vTo = new Vector(vTo);
			this._vRight = new Vector(vTo.crossProduct(vUp));
		}
	
	/**
	 * A constructor that accepts 4 values
	 * @param p - center point
	 * @param vUp - vector up
	 * @param vToward - vector towards
	 * @param vRight - vector right
	 */
	public Camera(Point3D p, Vector vUp, Vector vToward, Vector vRight) 
    {
		this._P0 = new Point3D(p);
		this._vUp = new Vector(vUp);
		this._vTo = new Vector(vToward) ;
		this._vRight = new Vector(vRight);
	}
	
	/**
	 * Default constructor
	 */
	public Camera() {
		this._P0 = new Point3D(0,0,0);
		this._vUp = new Vector(0,1,0);
		this._vTo = new Vector(0,0,-1);
		this._vRight = new Vector(_vTo.crossProduct(_vUp));
	}
	/**
	 * Copy constructor
	 * @param temp - The same object is copied
	 */
	public Camera(Camera temp) {
		this._P0 = temp.getP0();
		this._vUp = temp.getVUp();
		this._vTo = temp.getVTo();
		this._vRight =  _vTo.crossProduct(_vUp);
	}

/**
 * Returns P0
 * @return P0 - center point
 */
	public Point3D getP0() {
		return new Point3D(_P0);
	}

/**
 * set P0
 * @param P0 - center point
 */
	public void setP0(Point3D P0) {
		this._P0 = new Point3D(P0);
	}

/**
 * Returns the top vector
 * @return _vup - vector up
 */
	public Vector getVUp() {
		return new Vector(_vUp);
	}

/**
 * set _vup
 * @param vUp - vector up
 */
	public void setVUp(Vector vUp) {
		this._vUp = new Vector(vUp);
	}

/**
 * Returns _vto
 * @return _vto - vector toward
 */
	public Vector getVTo() {
		return new Vector(_vTo);
	}

/**
 * set _vto
 * @param vTo - vector towards
 */
	public void setVTo(Vector vTo) {
		this._vTo = new Vector(vTo);
	}

/**
 * Returns the right vector
 * @return _vright-vector right
 */
	public Vector getVRight() {
		return new Vector(_vRight);
	}

/**
 * set _vRight
 * @param vRight - vector right
 */
	public void setVRight(Vector vRight) {
		this._vRight = new Vector(vRight);
	}

/**
 * Returns a string of the class
 *  /
	@Override
	public String toString() {
		return "Camera [_P0=" + _P0 + ", _vUp=" + _vUp + ", _vTo=" + _vTo + ", _vRight=" + _vRight + "]";
	}

/**
 * Checks whether a particular object belongs to the class
 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Camera other = (Camera) obj;
		if (_P0 == null) {
			if (other._P0 != null)
				return false;
		} else if (!_P0.equals(other._P0))
			return false;
		if (_vRight == null) {
			if (other._vRight != null)
				return false;
		} else if (!_vRight.equals(other._vRight))
			return false;
		if (_vTo == null) {
			if (other._vTo != null)
				return false;
		} else if (!_vTo.equals(other._vTo))
			return false;
		if (_vUp == null) {
			if (other._vUp != null)
				return false;
		} else if (!_vUp.equals(other._vUp))
			return false;
		return true;
	}
	
	
	/**
	 * Creates a new fund 
	 * @param Nx - number of pixelim for width
	 * @param Ny - number of pixelim for height
	 * @param x - The size of the pixel width
	 * @param y - The size of the pixel height
	 * @param screenDist - the distance from the camera
	 * @param screenWidth - The width of the image
	 * @param screenHeight - The height of the image
	 * @return A new beam that moves from the center of the camera through the pixel
	 */
	public Ray constructRayThroughPixel(double Nx, double Ny, double x, double y,
            double screenDist, double screenWidth, double screenHeight)
  {
     Vector vRtemp = new Vector(_vRight);
     Vector vTo = new Vector(_vTo);
     Vector vUp = new Vector(_vUp);
     Point3D P0= new Point3D(_P0);
     vTo.scale(screenDist);
     P0.add(vTo);
     Vector pc= new Vector(P0);
     double Rx = screenWidth/Nx;
     double Ry = screenHeight/Ny;
     double tempX= (x- (Nx/2.0))*Rx+(Rx/2.0);
     double tempy= (y- (Ny/2.0))*Ry+(Ry/2.0);
     vRtemp.scale(tempX);
     vUp.scale(tempy);
     vRtemp.subtract(vUp);
     pc.add(vRtemp);
     Point3D tempPoint = new Point3D(pc.getHead());
     pc.normalize();
     return new Ray(new Point3D(tempPoint), pc);
  }
	
	
	/**
	 * advantage 1
	 * Creates 4 new fund to all sides
	 * @param Nx - number of pixelim for width
	 * @param Ny - number of pixelim for height
	 * @param x - The size of the pixel width
	 * @param y - The size of the pixel height
	 * @param screenDist - the distance from the camera
	 * @param screenWidth - The width of the image
	 * @param screenHeight - The height of the image
	 * @return A new beam that moves from the center of the camera through the pixel
	 */
	public ArrayList<Ray> constructRayThroughPixel2(int Nx, int Ny, double x, double y,double screenDist, 
			                                       double screenWidth, double screenHeight)
	{
		ArrayList<Ray> rays = new ArrayList<Ray>();
		
		//point up left
		 double Rx = screenWidth/Nx;
	     double Ry = screenHeight/Ny;
		 Vector vRtemp = new Vector(_vRight);
	     Vector vTo = new Vector(_vTo);
	     Vector vUp = new Vector(_vUp);
	     Point3D P0 = new Point3D(_P0);
	     vTo.scale(screenDist);
	     P0.add(vTo);
	     Vector pc= new Vector(P0);
	     double tempX = (x- (Nx/2.0))*Rx;
	     double tempy = (y- (Ny/2.0))*Ry;
	     vRtemp.scale(tempX);
	     vUp.scale(tempy);
	     vRtemp.subtract(vUp);
	     pc.add(vRtemp);
	     Point3D tempPoint = new Point3D(pc.getHead());
	     pc.normalize();
		rays.add(new Ray(new Point3D(tempPoint), pc));

		// point up right
	    vRtemp = new Vector(_vRight);
	    vTo = new Vector(_vTo);
	    vUp = new Vector(_vUp);
	    P0= new Point3D(_P0);
	    vTo.scale(screenDist);
	    P0.add(vTo);
	    pc= new Vector(P0);
	    Ry = screenHeight/Ny;
	    tempX = (x- (Nx/2.0))*Rx + Rx;
	    tempy = (y- (Ny/2.0))*Ry;
	    vRtemp.scale(tempX);
	    vUp.scale(tempy);
	    vRtemp.subtract(vUp);
	    pc.add(vRtemp);
	    tempPoint = new Point3D(pc.getHead());
	    pc.normalize();
		rays.add(new Ray(new Point3D(tempPoint), pc));
				
		// point down left
		vRtemp = new Vector(_vRight);
	    vTo = new Vector(_vTo);
	    vUp = new Vector(_vUp);
	    P0= new Point3D(_P0);
	    vTo.scale(screenDist);
	    P0.add(vTo);
	    pc= new Vector(P0);
	    tempX= (x- (Nx/2.0))*Rx;
	    tempy= (y- (Ny/2.0))*Ry+Ry;
	    vRtemp.scale(tempX);
	    vUp.scale(tempy);
	    vRtemp.subtract(vUp);
	    pc.add(vRtemp);
	    tempPoint = new Point3D(pc.getHead());
	    pc.normalize();
		rays.add(new Ray(new Point3D(tempPoint), pc));
				
		
		
		//point down right
		vRtemp = new Vector(_vRight);
	    vTo = new Vector(_vTo);
	    vUp = new Vector(_vUp);
	    P0= new Point3D(_P0);
	    vTo.scale(screenDist);
	    P0.add(vTo);
	    pc= new Vector(P0);
	    tempX= (x- (Nx/2.0))*Rx+Rx;
	    tempy= (y- (Ny/2.0))*Ry+Ry;
	    vRtemp.scale(tempX);
	    vUp.scale(tempy);
	    vRtemp.subtract(vUp);
	    pc.add(vRtemp);
	    tempPoint = new Point3D(pc.getHead());
	    pc.normalize();
		rays.add(new Ray(new Point3D(tempPoint), pc));
		return rays;
		}

	}

