package bullethell.bullets;

import com.badlogic.gdx.graphics.Texture;

public class Bullets {
	
	
	
	public static Bullet01 seeking(float x1, float y1, float x2, float y2, float speed, Texture texture, float delay, float size) {
		return new Bullet01(x1, y1, speed, (float)(Math.atan2(y2-y1, x2-x1)*(180/Math.PI)), texture, delay, size);	
	}

}
