package bullethell.model;

import bullethell.movement.Parametric2d;
import bullethell.view.WorldRenderer;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * Base class for all entities. This includes bullets,
 * the player, and all types of enemies.
 * @author russ
 *
 */
public class Entity {
	
	//spawn point (ox, oy)
	public float ox;
	public float oy;
	
	//point relative to current path
	public float px;
	public float py;
	
	//current location
	public float x;
	public float y;
	
	//current time
	public float t = 0;
	
	//the path for an entity is an array of parametric equations
	public Array<Parametric2d> path;
	
	//location in path
	public int index = 0;
	
	
	/**
	 * Default constructor for Entity.
	 */
	public Entity() {
		ox = x = px = 2f;
		oy = y = py = 23f;
	}
	
	public Entity(float ox, float oy, Array<Parametric2d> path) {
		//the current location is equal to its origin at time zero
		this.ox = x = px = ox;
		this.oy = y = py = oy;
		this.path = path;
	}
	
	/**
	 * Updates the position
	 * 
	 * @param delta the change in time
	 * 
	 * @return boolean true if the end of the path is reached
	 */
	public boolean update(float delta) {
		//end reached or out of bounds
		if (index == path.size || x < 0 || x > WorldRenderer.CAMERA_WIDTH || 
				y < 0 || y > WorldRenderer.CAMERA_HEIGHT) {
			return true;
		}
		
		Parametric2d para = path.get(index);
		//is the parametric equation we are on done
		//also updates current parametric equation with delta
		boolean isFinished = para.update(delta);
		//update current location
		updateLocation(para);
		//go to next parametric equation if current one is finished
		if (isFinished){
			//update the relative locations for px and py
			px += para.x.loc;
			py += para.y.loc;
			//increase the index
			index++;
		}
		t += delta;
		return false;
	}

	public void updateLocation(Parametric2d para) {
		x = px + para.x.loc;
		y = py + para.y.loc;
		
	}
	
	public String toString() {
		return "x: " + x + "\ty: " + y;
	}
	

}
