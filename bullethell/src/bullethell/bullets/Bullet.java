package bullethell.bullets;

import com.badlogic.gdx.graphics.Texture;

public interface Bullet {

	float MARGIN = 1f;
	
	//gets the current location of the x-coordinate
	float getX();
	
	//gets the current location of the y-coordinate
	float getY();
	
	float getSize();
	
	void setIsGrazed(boolean b);
	
	boolean getIsGrazed();
	
	Texture getTexture();
	
	float getDelay();
	
	boolean isCollision(float x, float y, float r);
	
	/**
	 * updates the location of bullet returns true when
	 * bullet is finished
	 * @param delta
	 * @return
	 */
	
	boolean update(float delta);
}
