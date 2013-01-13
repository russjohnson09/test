package bullethell.movement;

import bullethell.view.WorldRenderer;

import com.badlogic.gdx.utils.Array;

/** This class has static methods that creates parametric equations.
 * 
 * @author russ
 *
 */
public class CommonPaths {
	
	/**
	 * Origin is always at (ox, oy) which is the entities spawn point. 
	 * Goes from (ox, oy) to (ox+x,ox+y) in deltaT seconds.
	 * @param x
	 * @param y
	 * @param deltaT
	 * @return
	 */
	public static Parametric2d originPointPara(float x, float y, float deltaT) {		
		return new Parametric2d(new Parametric(x/deltaT,deltaT), 
				new Parametric(y/deltaT,deltaT));
		
	}
	
	public static Array<Parametric2d> originPointArray(float x, float y, float deltaT) {
		Array<Parametric2d> array = new Array<Parametric2d>();
		array.add(new Parametric2d(new Parametric(x/deltaT,deltaT), 
				new Parametric(y/deltaT,deltaT)));
		return array;
		
	}
	
	public static Parametric2d twoPointsPara(float x1, float y1, float x2, float y2, float deltaT) {
		return originPointPara(x2-x1,y2-y1,deltaT);
		
	}
	
	public static Array<Parametric2d> twoPointsArray(float x1, float y1, float x2, float y2, float deltaT) {
		return originPointArray(x2-x1,y2-y1,deltaT);
		
	}
	
	/**
	 * starting at point (?, y) make an array that goes of the screen at a constant speed
	 * @param x
	 * @param y
	 * @param speed
	 * @return
	 */
	public static Array<Parametric2d> upArray(float y, float speed) {
		//distance to travel
		y -= WorldRenderer.CAMERA_HEIGHT;
		Array<Parametric2d> array = new Array<Parametric2d>();
		array.add(new Parametric2d(new Parametric(0,y/speed), 
				new Parametric(speed,y/speed)));
		return array;
		
	}
	
	/**
	 * A square with width equal to width and speed 10.
	 * @param x
	 * @return
	 */
	public static Array<Parametric2d> square(float width) {
		Array<Parametric2d> path = new Array<Parametric2d>();
		path.add(new Parametric2d(new Parametric(10f,width/10f), new Parametric(0, width/10f)));
		path.add(new Parametric2d(new Parametric(0,width/10f), new Parametric(-10f, width/10f)));
		path.add(new Parametric2d(new Parametric(-10f,width/10f), new Parametric(0, width/10f)));
		path.add(new Parametric2d(new Parametric(0,width/10f), new Parametric(10f, width/10f)));
		return path;
	}
	
}