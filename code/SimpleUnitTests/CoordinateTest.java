package SimpleUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;
import primatives.Coordinate;

public class CoordinateTest {
	
	
	//@SuppressWarnings("deprecation")
	@Test
	public void getCoordinat() {
		
		Coordinate temp= new Coordinate(3);
		double y= temp.getCoordinate();
		assertEquals(3,y, 0.0);
	
	}
	
public void addCoordinat() {
		
		Coordinate temp1= new Coordinate(3);
		Coordinate temp2= new Coordinate(3);
		temp1.add(temp2);
		Coordinate help= new Coordinate(6);
		assertEquals(help,temp1);
	
	}
public void subCoordinat() {
	
	Coordinate temp1= new Coordinate(3);
	Coordinate temp2= new Coordinate(3);
	temp1.subtract(temp2);
	Coordinate help= new Coordinate(0);
	assertEquals(help,temp1);

}


}
