package SimpleUnitTests;

//import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import Renderer.ImageWriter;
import Renderer.Render;
import Scene.Scene;
import geometries.Sphere;
import geometries.Triangle;
import primatives.Material;
import primatives.Point3D;

public class renderTest {

	
		@Test
		
		public void basicRendering(){
			
			Scene scene = new Scene();
			Material m =new Material();
			scene.addGeometry(new Sphere(Color.blue, 50, new Point3D(0.0, 0.0, -150), m));
			Triangle triangle = new Triangle(Color.red,new Point3D( 100, 0, -149),
					 						 new Point3D(  0, 100, -149),
					 						 new Point3D( 100, 100, -149), m);
			
			Triangle triangle2 = new Triangle(Color.green,new Point3D( 100, 0, -149),
					 			 			  new Point3D(  0, -100, -149),
					 			 			  new Point3D( 100,-100, -149), m);
			
			Triangle triangle3 = new Triangle(Color.orange,new Point3D(-100, 0, -149),
					 						  new Point3D(  0, 100, -149),
					 						  new Point3D(-100, 100, -149), m);
			
			Triangle triangle4 = new Triangle(Color.pink,new Point3D(-100, 0, -149),
					 			 			  new Point3D(  0,  -100, -149),
					 			 			  new Point3D(-100, -100, -149), m);
			
			scene.addGeometry(triangle);
			scene.addGeometry(triangle2);
			scene.addGeometry(triangle3);
			scene.addGeometry(triangle4);
			
			ImageWriter imageWriter = new ImageWriter("Render test1", 500, 500, 500, 500);
			
			Render render = new Render(scene, imageWriter);
			
			render.renderImage();
			render.printGrid(50);
			imageWriter.writeToimage();
		}


		@Test
		
		public void basicRendering1(){
			Scene scene = new Scene();
	        ImageWriter imageWriter = new ImageWriter("Render test2", 500, 500, 10, 10);
			
			Render render = new Render(scene, imageWriter);
			render.printGrid(50);
			imageWriter.writeToimage();
			
		}
	}


