package bullethell.enemies;

import com.badlogic.gdx.graphics.Texture;

public interface Enemy {

	float MARGIN = 1f;
	
	float getX();
	
	float getY();
	
	float getSize();
	
	boolean isFinished();
	
	boolean isDead();
	
	void damage();
	
	Texture getTexture();
	
	boolean update(float delta);
	

}
