package bullethell.bullets;

import bullethell.view.WorldRenderer;

import com.badlogic.gdx.graphics.Texture;

public class Laser01 implements Bullet {

	private boolean isGrazed = false;

	private float x;
	private float y;
	
	//direction of bullet in radians counterclockwise
	private final float direction;
	
	//collision detection Ax+By=0
	private float A;
	private float B;
	
	private final float size;
	
	private Texture texture;
	
	private float delay;
	
	public Laser01() {
		x = WorldRenderer.CAMERA_WIDTH/2f;
		y = WorldRenderer.CAMERA_HEIGHT - 1f;
		direction = (float) Math.toRadians(270f);
		this.texture = BulletTextures.BLUE_LASER;
		this.delay = 0;
		this.size = 0.5f;
		setAB();
	}
	
	
	private void setAB() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public float getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setIsGrazed(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getIsGrazed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Texture getTexture() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float getDelay() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isCollision(float x, float y, float r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(float delta) {
		// TODO Auto-generated method stub
		return false;
	}

}
