package bullethell.bullets;

import bullethell.view.WorldRenderer;

import com.badlogic.gdx.graphics.Texture;

public class Bullet02 implements Bullet {
	
	private boolean isGrazed = false;
	
	private float x;
	private float y;
	private float velocity;
	private final float acceleration;
	
	//direction of bullet in radians counterclockwise
	private final float direction;
	
	private final float size;
	
	private Texture texture;
	
	private final float delay;
	
	/**
	 * Default constructor bullet at top of screen moving done at 1
	 */
	public Bullet02() {
		x = WorldRenderer.CAMERA_WIDTH/2f;
		y = WorldRenderer.CAMERA_HEIGHT - 1f;
		velocity = 1f;
		acceleration = 0;
		direction = (float) Math.toRadians(90f);
		this.texture = BulletTextures.RED;
		this.delay = 0;
		this.size = 1f;
	}
	
	public Bullet02(float x, float y, float velocity, float acceleration, float direction, Texture texture, float delay, float size){
		this.x = x;
		this.y = y;
		this.velocity = velocity;
		this.acceleration = acceleration;
		this.direction = (float) Math.toRadians(direction);
		this.texture = texture;
		this.delay = delay;
		this.size = size;
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
		velocity += acceleration;
		x += velocity*delta*Math.cos(direction);
		y += velocity*delta*Math.sin(direction);
		return (x > WorldRenderer.CAMERA_WIDTH + MARGIN ||
				x < -MARGIN ||
				y < -MARGIN ||
				y > WorldRenderer.CAMERA_HEIGHT + MARGIN);
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
	public boolean isCollision(float x, float y, float r) {
		return (this.x - x)*(this.x - x) + (this.y - y)*(this.y - y) < (size+r)*(size+r);
	}

	@Override
	public void setIsGrazed(boolean b) {
		isGrazed = b;
	}

	@Override
	public boolean getIsGrazed() {
		return isGrazed;
	}

}
