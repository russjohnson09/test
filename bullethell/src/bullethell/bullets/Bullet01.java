package bullethell.bullets;

import bullethell.view.WorldRenderer;

import com.badlogic.gdx.graphics.Texture;

/**
 * Most basic bullet has only location, acceleration, and direction in degrees.
 * 
 * @author russ
 * 
 */
public class Bullet01 implements Bullet {

	private boolean isGrazed = false;

	private final float velocity;
	private float x;
	private float y;

	// direction of bullet in radians counterclockwise
	private final float direction;

	// used for updating x position
	private float a;

	// used for updating y position
	private float b;

	// diameter of bullet
	private final float size;

	private Texture texture;

	private float delay;

	/**
	 * Default constructor bullet at top of screen moving done at 1
	 */
	public Bullet01() {
		velocity = 10f;
		x = WorldRenderer.CAMERA_WIDTH / 2f;
		y = WorldRenderer.CAMERA_HEIGHT - 1f;
		direction = (float) Math.toRadians(270f);
		this.texture = BulletTextures.RED;
		this.delay = 0;
		this.size = 0.5f;
		setAB();
	}

	public Bullet01(float x, float y) {
		velocity = 10f;
		this.x = x;
		this.y = y;
		direction = (float) Math.toRadians(270f);
		this.texture = BulletTextures.RED;
		this.delay = 0;
		this.size = 0.5f;
		setAB();
	}

	public Bullet01(float x, float y, float velocity, float direction) {
		this.x = x;
		this.y = y;
		this.velocity = velocity;
		this.direction = (float) Math.toRadians(direction);
		this.texture = BulletTextures.RED;
		this.delay = 0;
		this.size = 0.5f;
		setAB();
	}

	public Bullet01(float x, float y, float velocity, float direction,
			Texture texture, float delay, float size) {
		this.x = x;
		this.y = y;
		this.velocity = velocity;
		this.direction = (float) Math.toRadians(direction);
		this.texture = texture;
		this.delay = delay;
		this.size = size;
		setAB();
	}

	@Override
	public float getX() {
		return x;
	}

	@Override
	public float getY() {
		return y;
	}

	@Override
	public boolean update(float delta) {
		if (delay > 0) {
			delay -= delta;
			return false;
		} else {
			x += delta * a;
			y += delta * b;
			return (x > WorldRenderer.CAMERA_WIDTH + MARGIN || x < -MARGIN
					|| y < -MARGIN || y > WorldRenderer.CAMERA_HEIGHT + MARGIN);
		}
	}

	private void setAB() {
		a = (float) (velocity * Math.cos(direction));
		b = (float) (velocity * Math.sin(direction));
	}

	@Override
	public float getSize() {
		return size;
	}

	@Override
	public Texture getTexture() {
		return texture;
	}

	@Override
	public float getDelay() {
		return delay;
	}

	@Override
	public boolean isCollision(float x, float y, float d) {
		if (delay > 0)
			return false;
		else
			return (this.x - x) * (this.x - x) + (this.y - y) * (this.y - y) < (size / 2 + d / 2)
					* (size / 2 + d / 2);
	}

	@Override
	public void setIsGrazed(boolean b) {
		isGrazed = b;
	}

	@Override
	public boolean getIsGrazed() {
		return isGrazed;
	}

	// public String toString() {
	// return "x: " + x + "\ty: " + y + "\tr: " + size;
	// }

}
