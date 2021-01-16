package SimpleUnitTests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import primatives.Material;
import primatives.Point3D;
import primatives.Ray;
import primatives.Vector;

import org.junit.Test;

import geometries.Plane;

public class PlaneTest {
	

	@Test
	  public void testGetNormal() {
		Vector help= new Vector(2,2,2);
		Material m =new Material();
	    Plane plane=new Plane(new Point3D(2,2,2), help, m);
	    Vector ans = plane.getNormal(new Point3D(2,2,2));
	    help.normalize();
	    assertEquals(help.toString(),ans.toString());
	  }
	
	@Test
	public void testPlaneIntersections() {


		// creating the expected values
		
		List<Point3D> answerList = new ArrayList<Point3D>();		
		Point3D answerPoint = new Point3D(0, 0, -200);		
		answerList.add(answerPoint);
		
		// building the plane
		
		Point3D directionPoint = new Point3D(0, 0, -1);
		Point3D planePoint = new Point3D(0, 100, -200);
				
		Vector direction = new Vector(directionPoint);
		Material m =new Material();
		Plane plane = new Plane(Color.white, planePoint, direction, m);
			
		// building the ray that will intersect the plane
		
		Point3D centerPoint = new Point3D(0,0,0);
		Vector vector = new Vector(0, 0, -5);
		Ray ray = new Ray(centerPoint, vector);
	
		// testing the findIntersection function
		
		List<Point3D> list = new ArrayList<Point3D>();
		list = plane.findIntersections(ray);
		assertEquals(answerList, list);
	
	}

}
