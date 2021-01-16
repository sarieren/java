package SimpleUnitTests;

import static org.junit.Assert.*;

import primatives.Vector;

import org.junit.Test;



public class VectorTest {

	@Test
	public void VectorAdd() {
		
		Vector temp1 = new Vector(3.0,3.0,3.0);
		Vector temp2 = new Vector(3.0,3.0,3.0);
		temp1.add(temp2);
		Vector temp3 = new Vector(6.0, 6.0, 6.0);
		assertEquals(temp3.toString(),temp1.toString());
	
	}
	

		@Test
		public void VectorScale() {
			Vector temp1 = new Vector(3.0,3.0,3.0);
			temp1.scale(-1);
			Vector temp2 = new Vector(-3.0,-3.0,-3.0);
			assertEquals(temp2.toString(),temp1.toString());
		}
		
		@Test
		public void VectorSubtruct() {
			
			Vector temp1 = new Vector(3.0,3.0,3.0);
			Vector temp2 = new Vector(3.0,3.0,3.0);
			temp1.subtract(temp2);
			Vector temp3 = new Vector(0.0, 0.0, 0.0);
			assertEquals(temp3.toString(),temp1.toString());
		}
		
		@Test
		public void Vectorlength() {
			
			Vector temp1 = new Vector(3.0,3.0,3.0);
			double temp=temp1.length();
			double temp3 = Math.sqrt(27);
			assertEquals(temp3,temp, 0.0);
		}
		
		@Test
		public void VectorDotProduct() {
			
			Vector temp1 = new Vector(3.0,3.0,3.0);
			Vector temp2 = new Vector(3.0,3.0,3.0);
			double help = temp1.dotProduct(temp2);
			double temp3 = 27;
			assertEquals(temp3,help, 0.0);
		}
		
		
		@Test
		public void VectorCrossProduct() {
			
			 Vector v1=new Vector(1,2,3);
	         Vector v2=new Vector(2,3,4);
	         Vector v4=new Vector();
	         v4=v1.crossProduct(v2);
	         Vector v3=new Vector(-1,2,-1);
	         assertEquals(v3.toString(),v4.toString());
		}
		
		@Test
       public void VectorNormalize() {
			Vector temp1 = new Vector(3.0,3.0,3.0);
			double x= temp1.length();
			temp1.normalize();
			Vector temp3 = new Vector(3/x, 3/x, 3/x);
			assertEquals(temp3.toString(),temp1.toString());
		}
  
		
		@Test
	    public void testDotProduct1() 
	    {
	      Vector v1=new Vector(5.0,5.0,5.0);
	      Vector v2=new Vector(2.0,2.0,2.0);
	      double ans=v1.dotProduct(v2);
	      assertEquals(30,ans,0.01);
	    }
}

