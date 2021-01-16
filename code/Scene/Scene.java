package Scene;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import elements.AmbientLight;
import elements.Camera;
import elements.Light;
import geometries.Geometry;


/**
 * Scene is the Class that represent Scene
 */

public class Scene{
	String _sceneName;
	Color _background;
	AmbientLight _ambientLight;
	ArrayList<Geometry> _geometries;
	ArrayList<Light> _lights;
	Camera _camera;
	double _screenDistance;
	
	
	/**
	 * Default constructor
	 */
	public Scene() 
	{
		super();
		_sceneName = new String();
		_background = Color.black; 
		_ambientLight = new AmbientLight();
		_geometries= new ArrayList<Geometry>();
		_lights = new ArrayList<Light>();
		_camera = new Camera();
		_screenDistance = 145;
	}
	
	
	
	/**
	 *  A constructor that accepts values
	 * @param sceneName - name of scene
	 * @param background - color of cackground
	 * @param ambientLight - the ambient light of the scene
	 * @param geometries - list of geometry in scene
	 * @param lights - ist of lights in scene
	 * @param camera - the camera of the scene
	 * @param screenDistance - distance from the view
	 */
	public Scene(String sceneName, Color background, AmbientLight ambientLight, ArrayList<Geometry> geometries,
			ArrayList<Light> lights, Camera camera, double screenDistance) {
		super();
		this._sceneName = new String(sceneName);
		this._background = background;
		this._ambientLight = new AmbientLight(ambientLight);
		this._geometries = new ArrayList<Geometry>(geometries);
		this._lights = new ArrayList<Light>(lights);
		this._camera = new Camera(camera);
		this._screenDistance = screenDistance;
	}
	
	/**
	 * Copy constructor
	 * @param temp - The same object is copied
	 */
	public Scene(Scene temp) {
		super();
		this._sceneName = new String(temp._sceneName);
		this._background = temp._background;
		this._ambientLight = new AmbientLight(temp._ambientLight);
		this._geometries = new ArrayList<Geometry>(temp._geometries);
		this._lights = new ArrayList<Light>(temp._lights);
		this._camera = new Camera(temp._camera);
		this._screenDistance = temp._screenDistance;
	}

	/**
	 * A function that returns the name of the scene
	 * @return sceneName - name of scene
	 */
	public String getSceneName() {
		return new String(_sceneName);
	}

	/**
	 * A function that defines the name of the scen
	 * @param sceneName - name of scene
	 */
	public void setSceneName(String sceneName) {
		 if (sceneName == null) 
	            _sceneName = new String();
		 else
	           this._sceneName = new String(sceneName);
	}

	/**
	 *  A function that defines the scene background
	 * @return background - color of cackground
	 */
	public Color getBackground() {
		return new Color(_background.getRGB());
	}

	/**
	 * A function that defines the scene background
	 * @param background - color of cackground
	 */
	public void setBackground(Color background) {
		if (_background == null) 
            this._background = new Color(0,0,0);
		else 
            this._background = new Color(background.getRGB());
        
	}

	/**
	 * A function that returns the light in the scene
	 * @return ambientLight - the ambient light of the scene
	 */
	public AmbientLight getAmbientLight() {
		return new AmbientLight(_ambientLight);
	}

	/**
	 * A function that sets the light in the scene
	 * @param ambientLight - the ambient light of the scene
	 */
	public void setAmbientLight(AmbientLight ambientLight) {
		this._ambientLight = new AmbientLight(ambientLight);
	}

	/**
	 *  A function that returns the list of geometry in the scene
	 * @return list - list of geometry in the scene
	 */
	public ArrayList<Geometry> getGeometries() {
		ArrayList<Geometry> list = new ArrayList<Geometry>();
        for (Iterator<Geometry> iterator = this._geometries.iterator(); iterator.hasNext();) 
        {
        	Geometry next = iterator.next();
            list.add(next);
        }
        return list;	
     
	}

	/**
	 * A function that sets the list of geometry in the scene
	 * @param list - list of geometry in the scene
	 */
	public void setGeometries(ArrayList<Geometry> geometries) {
		if(geometries == null) 
        {
            this._geometries = new ArrayList<Geometry>();
        }
		else
			this._geometries = new ArrayList<Geometry>(geometries);	
	}

	/**
	 * A function that returns the camera
	 * @return _camera - the camera of the scene
	 */
	public Camera getCamera() {
		return new Camera(_camera);
	}

	/**
	 * A function that returns the list of geometry in the scene
	 * @return list of light
	 */
	public ArrayList<Light> getLights() {
		ArrayList<Light> list = new ArrayList<Light>();
	    for (Iterator<Light> iterator = this._lights.iterator(); iterator.hasNext();) 
	    {
	    	Light next = iterator.next();
	        list.add(next);
	    }
	    return list;
	}
	
	
	/**
	 * set light to list
	 * @param _lights - list of light
	 */
	public void setLights(ArrayList<Light> lights) {
		if(_lights == null) 
        {
            this._lights = new ArrayList<Light>();
        }
		else
			this._lights = new ArrayList<Light>(lights);	
	}

	/**
	 * A function that sets the camera
	 * @param camera - _camera - the camera of the scene
	 */
	public void setCamera(Camera camera) {
		this._camera = new Camera(camera);
	}

	/**
	 *  A function that returns the ScreenDistance
	 * @return _screenDistance - distance from the view
	 */
	public double getScreenDistance() {
		return _screenDistance;
	}

	/**
	 * set _screenDistance
	 * @param _screenDistance - distance from the view
	 */
	public void setScreenDistance(double _screenDistance) {
		this._screenDistance = _screenDistance;
	}
	
	/**
	 * A function that adds geometry to the list
	 * @param geometries - adds geometry to the list
	 */
	public void addGeometry(Geometry geometries)
	{
		this._geometries.add(geometries);
	}
	
	/**
	 * A function that adds geometry to the list and return him
	 * @param geometries - adds geometry to the list
	 * @return list of geometry
	 */
	public ArrayList<Geometry> addGeometryreturn(Geometry geometries)
	{
		this._geometries.add(geometries);
		return _geometries;
	}
	
	/**
	 * A function that returns an iterator that indicates the geometry
	 * @return iterator - indicates the lighting on the list of geometry
	 */
	public Iterator<Geometry>getGeometriesIterator()
	{
		return _geometries.iterator();
	}

	/**
	 *  adding a light source to the lightSource list
	 * @param light - light to add to scene
	 */
	public void addLight(Light lights)
	{
		this._lights.add(lights);
	}
	
	/**
	 * A function that returns an iterator that indicates the lighting
	 * @return iterator - indicates the lighting on the list of light
	 */
	public Iterator<Light>getLightsIterator()
	{
		return _lights.iterator();
	}

 
}
