package Renderer;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import java.util.Map;
import java.util.Map.Entry;

import Scene.Scene;
import elements.Light;
import geometries.Geometry;
import primatives.Ray;
import primatives.Vector;
import primatives.Point3D;

/*
 * Render is the class that renderTests the image from scene
 */
public class Render {
	protected Scene _scene;
	protected ImageWriter _imageWriter;
	int RECURSION_LEVEL=3;
	
	/**
	 * A constructor that accepts values
	 * @param scene - scene the Scene
	 * @param imageWriter - imageWriter ImageWriter object
	 */
	public Render(Scene scene, ImageWriter imageWriter) 
	{
		this._scene = scene; 
		this._imageWriter = imageWriter;
	}
	
  
	/**
	 * A function that returns a scene
	 * @return the Scene object
	 */
	public Scene getScene() {
		return new Scene(_scene);
	}
	
	/**
	 * A function that defines a scene
	 * @param scene the Scene 
	 */
	public void set_scene(Scene scene) {
		this._scene = new Scene(scene);
	}
	
	
	/**
	 * Function that returns imageWriter
	 * @return the ImageWriter Object
	 */
	public ImageWriter getImageWriter() {
		return _imageWriter;
	}
	
	/**
	 *  Function that defines imageWriter
	 * @param imageWriter - imageWriter ImageWriter object
	 */
	public void setImageWriter(ImageWriter imageWriter) {
		this._imageWriter = imageWriter;
	}
	
	/**
	 * A function that prints a renderer
	 */
	@Override
	public String toString() {
		return "Render [_scene=" + _scene + ", _imageWriter=" + _imageWriter + "]";
	}


	/**
	 * A function that checks whether 2 objects are equal to each other
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Render other = (Render) obj;
		if (_imageWriter == null) {
			if (other._imageWriter != null)
				return false;
		} else if (!_imageWriter.equals(other._imageWriter))
			return false;
		if (_scene == null) {
			if (other._scene != null)
				return false;
		} else if (!_scene.equals(other._scene))
			return false;
		return true;
	}
	
	
	/**
	 * A function that prints a grid on the background
	 * @param interval - A variable that determines the size of each grid slot
	 */
	public void printGrid(int interval)
	{

		for(int i=0; i < this._imageWriter.getHeight(); i++)
		{
			for(int j=0; j<this._imageWriter.getWidth(); j++)
			{
				if((i % interval == 0)||(j % interval==0))
					_imageWriter.writePixel(i,j,Color.WHITE);
			}
		}
	}

	/**
	 * calculating the Diffusive factor
	 * @param kd - kd Diffuse factor
	 * @param normal - vector that normal to light source
	 * @param vecL - vector light direction
	 * @param intensity - lightIntensity
	 * @return New color calculated by: calcDiffusiveComp
	 */
	private Color calcDiffusiveComp(double kd, Vector normal, Vector vecL, Color intensity)
	{
		Vector N = new Vector(normal);
		Vector L = new Vector(vecL);
		N.normalize();
		L.normalize();
		double kdNL = kd*(N.dotProduct(L));
		if(kdNL<0) kdNL=kdNL*(-1);
		if(kdNL>1) kdNL = 1;
		int red= (int)(kdNL * intensity.getRed());
		if(red>255) red=255;
		int green = (int)(kdNL * intensity.getGreen());
		if(green>255) green=255;
		int blue = (int)(kdNL * intensity.getBlue());
		if(blue>255) blue = 255;
		return new Color (red, green, blue);
	}
	
	

   
/**
 * calculating the Specular  factor
 * @param ks - ks Specular factor
 * @param vector - Light direction
 * @param normal - vector that normal to light source
 * @param vecL - vector form the camera to the object
 * @param shininess - nShininess shininess factor
 * @param intensity - lightIntensity light Intensity
 * @return New color calculated by: calcSpecularComp
 */
	 private Color calcSpecularComp(double ks, Vector vector, Vector normal, Vector vecL, double shininess, Color intensity)
	 {
		 Vector V = new Vector(vector);
		 Vector N = new Vector(normal);
		 Vector L = new Vector(vecL); 
		 V.normalize();
		 N.normalize();
		 L.normalize();
		 double d = (L.dotProduct(N))*(-2);//calcuate R
		 N.scale(d);
		 L.add(N);
		 Vector R = new Vector(L);
		 double VR = V.dotProduct(R);//V*R
		 if(VR < 0) VR = 0;
		 else
			 VR = Math.pow(VR, shininess);
		 VR= VR*ks;
		 if(VR>1) VR = 1;
		 if(VR<0) VR = 0;
		 int red= (int)(VR * intensity.getRed());
		 if(red>255) red=255;
		 int green = (int)(VR * intensity.getGreen());
		 if(green>255) green=255;
		 int blue = (int)(VR * intensity.getBlue());
		 if(blue>255) blue = 255;
		 return new Color (red, green, blue);
	 }

	
	 /**
	  * Construct Reflected Ray
	  * @param N - normal
	  * @param point - point on the geometry
	  * @param ray - ray to direction of the original ray
	  * @return Reflected Ray
	  */
	Ray constructReflectedRay(Vector N, Point3D point, Ray ray)
	{
		N.normalize();
		Vector D = new Vector(ray.getDirection());
     	D.normalize();
  
     	double A=D.dotProduct(N);
     	Vector B=N.scaleV(A*(-2));
     	D.add(B);
     	Point3D point1 = new Point3D(point);
     	point1.add(D);
  
     	return new Ray(point1 ,D);
	}
	


	/**
	 *  A function that returns the closest cutting point of the geometry
	 * @param ray - The ray checking whether it has a cutting point with the surface
	 * @return map -  the closest point to the view
	 */
	private Map<Geometry, Point3D>findClosesntIntersection(Ray ray)
	 {
		Map<Geometry, ArrayList<Point3D>> help = getSceneRayIntersections(ray);
		return getClosestPoint(help);
	 }
	
	/**
     * Construct Refracted Ray
     * @param D- normal
     * @param point - point on the geometry
     * @param ray - ray to direction of the original ray
     * @return ray - the Refracted Ray
     */
	private Ray constructRefractedRay(Vector D,Point3D point, Ray ray)
	{

		ray.getDirection().normalize();
		Vector temp = new Vector(ray.getDirection());
		
		 Point3D point1 = new Point3D(point);
		 point1.add(temp);
		return new Ray(point1, ray.getDirection());


	}
	
	
	
	/**
	 * A function that returns a list with all the cutting points of the geometry in the scene
	 * @param ray - The ray checking whether it has a cutting point with the surface
	 * @return list with all the cutting points of the geometry in the scene
	 */
	private Map<Geometry, ArrayList<Point3D>> getSceneRayIntersections(Ray ray)
	{

		 Iterator<Geometry> geometries = this._scene.getGeometriesIterator();
		 Map<Geometry, ArrayList<Point3D>> intersectionPoints = new HashMap<Geometry, ArrayList<Point3D>>(); 
		 while (geometries.hasNext())
		 {
			 Geometry geometry = geometries.next();
			 ArrayList<Point3D> geometryIntersectionPoints =geometry.findIntersections(ray);
			 if (!geometryIntersectionPoints.isEmpty())
			       intersectionPoints.put(geometry, geometryIntersectionPoints);
		 }
		 return intersectionPoints;
	}


	/**
	 * A function that returns the closest cutting point of the geometry
	 * @param temp - pointsMap Map of points with geometries
	 * @return Map - the closest point to the view
	 */
	private Map<Geometry, Point3D> getClosestPoint(Map<Geometry, ArrayList<Point3D>> intersectionPoints)
	{
			double distance = Double.MAX_VALUE;
			Point3D P0 = _scene.getCamera().getP0();
			Map<Geometry, Point3D> minDistancePoint  = new HashMap<Geometry, Point3D>();
			for (Entry<Geometry, ArrayList<Point3D>> entry : intersectionPoints.entrySet())  
				{
				for (Point3D point: entry.getValue())  
					{
					if (P0.distance(point) < distance)
						{
							minDistancePoint.clear();
							minDistancePoint.put(entry.getKey(), new Point3D(point));
							distance = P0.distance(point);
						}
					}
				}
			return minDistancePoint;
	}
	
	/**
	 * Checks for a hidden point
	 * @param light - A list of light sources that reflect the calculated point
	 * @param point - The point at which they calculate whether it is hidden or not
	 * @param geometry - The type of geometry you are testing is hidden or not
	 * @return It is true if the point is not removed and false if it is hidden
	 */
	private boolean occluded(Light light, Point3D point, Geometry geometry) {
		Vector lightDirection = light.getL(point);
		lightDirection.scale(-1);
		Point3D geometryPoint = new Point3D(point);
		Vector epsVector = new Vector(geometry.getNormal(point));
		epsVector.scale(2);
		geometryPoint.add(epsVector);
		Ray lightRay = new Ray(geometryPoint, lightDirection);
		Map<Geometry, ArrayList<Point3D>> intersectionPoints = getSceneRayIntersections(lightRay);
		if (true/*geometry instanceof FlatGeometry*/ )
			intersectionPoints.remove(geometry);
		for (Entry<Geometry, ArrayList<Point3D>> entry: intersectionPoints.entrySet())
			if (entry.getKey().get_material().get_kt() == 0)
				return true;//true
			return false;
		
		}

	 
	/**
     * calculate the color of point on Geometry, recursively.
     * @param geometry - The geometry you want to paint
     * @param ray  ray to trace
     * @param point - The point in geometry you want to paint
     * @return the color at this point
     */
	private Color calcColor(Geometry geometry, Point3D point,Ray inRay) 
	{
		return calcColor( geometry, point,inRay, 0);
	}
	
	/**
     * calculate the color of point on Geometry, recursively.
     * @param geometry - The geometry you want to paint
     * @param point - The point in geometry you want to paint
     * @param ray  ray to trace
     * @param level - The number of times the recursion is done
     * @return the color at this point
     */
		private Color calcColor(Geometry geometry, Point3D point ,Ray inRay, int level) {
			if (level == RECURSION_LEVEL) return new Color(0, 0, 0);
			Color ambientLight = _scene.getAmbientLight().getIntensity(point);
			Color emissionLight = geometry.getEmmission();
			
			Iterator<Light> lights = _scene.getLightsIterator();
			Color ColorDiffuseLight= new Color(0,0,0);
			Color SpecularLight = new Color(0,0,0);
			Color reflectedLight = new Color(0,0,0);
			Color refractedLight = new Color(0,0,0);
			while (lights.hasNext()){
				Light light = lights.next();
				if (!occluded(light, point, geometry))
				{	
			     ColorDiffuseLight = addColor(ColorDiffuseLight, calcDiffusiveComp(geometry.get_material().get_kd(),
						geometry.getNormal(point),  light.getL(point),  light.getIntensity(point)));
			
				SpecularLight = addColor(SpecularLight, calcSpecularComp(geometry.get_material().get_ks(),
						new Vector(point, _scene.getCamera().getP0()),
						geometry.getNormal(point),  light.getL(point), geometry.get_material().get_nShininess(),
											light.getIntensity(point)));
				
				}
			}
			
			Ray reflectedRay = new Ray(constructReflectedRay(geometry.getNormal(point), point, inRay));
			 Map<Geometry, Point3D> reflectedEntry = findClosesntIntersection(reflectedRay);
			 if (!reflectedEntry.isEmpty()) 
			 {
				 	Color reflectedColor = calcColor(reflectedEntry.entrySet().iterator().next().getKey(),
						 		reflectedEntry.entrySet().iterator().next().getValue(), reflectedRay, level + 1);	
				 	double kr = geometry.get_material().get_kr();
					int reflectR = (int) (kr * reflectedColor.getRed());
			        int reflectG = (int) (kr * reflectedColor.getGreen());
			        int reflectB = (int) (kr * reflectedColor.getBlue());
			        reflectedLight = new Color(reflectR, reflectG, reflectB);
			 }
			Ray refractedRay = constructRefractedRay(geometry.getNormal(point), point, inRay);
			 Map<Geometry, Point3D> refractedEntry = findClosesntIntersection(refractedRay);
			 if (!refractedEntry.isEmpty())
			{
				 Color refractedColor = calcColor(refractedEntry.entrySet().iterator().next().getKey(), 
						 refractedEntry.entrySet().iterator().next().getValue(), refractedRay, level + 1);
				 double kt = geometry.get_material().get_kt();
				 int refractR = (int) (kt * refractedColor.getRed());
		         int refractG = (int) (kt * refractedColor.getGreen());
		         int refractB = (int) (kt * refractedColor.getBlue());
		         refractedLight = new Color(refractR, refractG, refractB);				
			}
			
			
			double totalRed = ambientLight.getRed() + emissionLight.getRed() + ColorDiffuseLight.getRed() + SpecularLight.getRed() + reflectedLight.getRed() + refractedLight.getRed();
			double totalBlue = ambientLight.getBlue() + emissionLight.getBlue() + ColorDiffuseLight.getBlue() + SpecularLight.getBlue() + reflectedLight.getBlue() + refractedLight.getBlue();
			double totalGreen = ambientLight.getGreen() + emissionLight.getGreen() + ColorDiffuseLight.getGreen() + SpecularLight.getGreen()+reflectedLight.getGreen() + refractedLight.getGreen();
			if(totalRed>255) totalRed = 255;
			if(totalBlue>255) totalBlue = 255;
			if(totalGreen>255) totalGreen = 255;
			return new Color((int)totalRed, (int)totalGreen, (int)totalBlue);
	}	

	
	
	

/**
 * A function that connects between two colors
 * @param c1 - one color
 * @param c2 - two color
 * @return new color - onnects between two colors
 */
	public Color addColor(Color c1, Color c2)
	{
		int red=c1.getRed()+c2.getRed();
		if(red>255) red=255;
		int green=c1.getGreen()+c2.getGreen();
		if(green>255) green=255;
		int blue=c1.getBlue()+c2.getBlue();
		if(blue>255) blue=255;
		return new Color(red, green, blue);
	}
	
	
	
	/**
	 * A function that calculates the average between the data colors and builds a new color
	 * @param red - red color
	 * @param green - green color
	 * @param blue - blue color
	 * @param num - num to avarage
	 * @return new color - color with avarage
	 */
	public Color avarage(int red, int green, int blue, int num)
	{
		red=red/num;
		if(red > 255)
			red = 255;
		green = green/num;
		if(green>255)
			green = 255;
		blue = blue/num;
		if(blue>255)
			blue = 255;
		
	return new Color(red, green, blue);
	}
	
	
	
	
	/**
	 * advantage 1 and 2
	 * A function that builds my image by the cutting points 
	 */
	public void renderImage() 
	{
		for(int i=0; i < this._imageWriter.getHeight(); i++)
		{
			for(int j=0;j<this._imageWriter.getWidth();j++)
			{
				Ray ray = _scene.getCamera().constructRayThroughPixel
						(_imageWriter.getNx(), _imageWriter.getNy(),
						i, j, _scene.getScreenDistance(), _imageWriter.getWidth(),
						_imageWriter.getHeight());

						Map<Geometry, ArrayList<Point3D>> intersectionPoints = getSceneRayIntersections(ray);
						if (intersectionPoints.isEmpty()){
						    _imageWriter.writePixel(i, j, _scene.getBackground());
						}
						
						else
						{
							Color color= new Color(0,0,0);
							int red=0, green=0, blue=0;
							ArrayList<Ray>rayList = _scene.getCamera().constructRayThroughPixel2
									(_imageWriter.getNx(), _imageWriter.getNy(),
									i, j, _scene.getScreenDistance(), _imageWriter.getWidth(),
									_imageWriter.getHeight());
							 for (Iterator<Ray> iterator = rayList.iterator(); iterator.hasNext();) 
						        {
						        	Ray iteratorRay = iterator.next();
						        	Map<Geometry, ArrayList<Point3D>> intersectionPoints1 = getSceneRayIntersections(iteratorRay);
						        	if (intersectionPoints1.isEmpty())
						        	{
										red += _scene.getBackground().getRed();
										green += _scene.getBackground().getGreen();
										blue += _scene.getBackground().getBlue();
						        	}
						        	else
						        	{
						        	Map<Geometry, Point3D> closestPoint = getClosestPoint(intersectionPoints1);
						        	color = calcColor(closestPoint.entrySet().iterator().next().getKey() 
										            	,closestPoint.entrySet().iterator().next().getValue(), ray);
						        	red += color.getRed();
									green += color.getGreen();
									blue += color.getBlue();
						        	}
						        }
							 red = red/4;
							 green = green/4;
							 blue = blue/4;
									 
							 Map<Geometry, Point3D> closestPoint = getClosestPoint(intersectionPoints);  
							Color midColor =  calcColor(closestPoint.entrySet().iterator().next().getKey() 
									,closestPoint.entrySet().iterator().next().getValue(), ray);
							red = red + midColor.getRed();
							green = green + midColor.getGreen();
							blue = blue + midColor.getBlue();
							color = avarage(red, green, blue, 2);
							 _imageWriter.writePixel(i, j, color) ;
							
						
						}
			}
			
		}

	}
	
	

	 /**
    * renders the image to the screen
    */
/*		public void renderImage() 
		{
			for(int i=0; i < this._imageWriter.getHeight(); i++)
			{
				for(int j=0;j<this._imageWriter.getWidth();j++)
				{
					Ray ray = _scene.getCamera().constructRayThroughPixel
							(_imageWriter.getNx(), _imageWriter.getNy(),
							i, j, _scene.getScreenDistance(), _imageWriter.getWidth(),
							_imageWriter.getHeight());

							Map<Geometry, ArrayList<Point3D>> intersectionPoints = getSceneRayIntersections(ray);
							if (intersectionPoints.isEmpty()){
							    _imageWriter.writePixel(i, j, _scene.getBackground());
							}
							
							else
							{
								Map<Geometry, Point3D> closestPoint = getClosestPoint(intersectionPoints);
								_imageWriter.writePixel(i, j, calcColor(closestPoint.entrySet().iterator().next().getKey() 
										,closestPoint.entrySet().iterator().next().getValue(), ray));
							}
				}
				
			}
		}*/
				
			

	

		
	
}

	
