package SimpleUnitTests;



import java.awt.Color;

import org.junit.Test;

import Renderer.ImageWriter;
import Renderer.Render;
import Scene.Scene;
import elements.DirectionalLight;
import elements.SpotLight;
import geometries.Sphere;
import primatives.Material;
import primatives.Point3D;
import primatives.Vector;

public class myTest {
	@Test
	public void myTest1(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(200);
		Material material = new Material();	
		scene.setBackground(Color.CYAN);
		
		Sphere sphere = new Sphere(new Color(0,0, 100), 600, new Point3D(0.0, 0.0, -1000));		
		material.set_nShininess(20); 
		material.set_kt(0.8);
		sphere.set_material(new Material(material));
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(new Color (100, 20, 20), 500, new Point3D(0.0, 0.0, -1000));
		material.set_kt(0.7);	
		sphere2.set_material(new Material(material));
		scene.addGeometry(sphere2);
		
		Sphere sphere3 = new Sphere(Color.green, 300, new Point3D(0.0, 0.0, -1000));
		material.set_kt(0.6);	
		sphere3.set_material(new Material(material));
		scene.addGeometry(sphere3);

		Sphere sphere4 = new Sphere(Color.CYAN, 200, new Point3D(0.0, 0.0, -1000));
		material.set_kt(0.4);	
		sphere4.set_material(new Material(material));
		scene.addGeometry(sphere4);

		Sphere sphere5 = new Sphere(Color.pink, 100, new Point3D(0.0, 0.0, -1000));
		material.set_kt(0.3);	
		sphere5.set_material(new Material(material));
		scene.addGeometry(sphere5);


		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
							   0.1, 0.00001, 0.000005,  new Vector(2, 2, -3))); // NOW
				
		ImageWriter imageWriter = new ImageWriter("myTest", 500, 500, 500, 500);
		
		Render render = new Render( scene, imageWriter);
		
		render.renderImage();
		//render.printGrid(50);
		imageWriter.writeToimage();
		
	}


	}