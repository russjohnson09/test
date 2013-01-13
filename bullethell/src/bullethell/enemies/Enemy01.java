package bullethell.enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

import bullethell.bullets.Bullet;
import bullethell.movement.CommonPaths;
import bullethell.movement.Parametric2d;
import bullethell.view.WorldRenderer;

public class Enemy01 implements Enemy {
	
	//relative location on the path (ox, oy)
	private float ox;
	private float oy;
	
	//current location
	private float x;
	private float y;

	//enemy's health
	private int health;
	
	//static array of all bullets fired by Enemy objects
	private static Array<Bullet> enemyBullets = new Array<Bullet>();
	
	//enemies texture file
	private Texture texture;

	//hitbox size
	private float size;
	
	//contains all of the Enemies that have been instantiated.
	private static Array<Enemy> enemies = new Array<Enemy>();
	
	//enemy's path
	private Array<Parametric2d> path;
	
	//true if end of path reached
	boolean isFinished = false;
	
	//current location in path
	private int index = 0;
		
	/**
	 * Default constructor for Enemy.
	 */
	public Enemy01() {
		this.x = ox = 2f;
		this.y = oy = WorldRenderer.CAMERA_HEIGHT - 2f;
		this.path = CommonPaths.square(10f);
		this.texture = EnemyTextures.BLUE;
		this.size = 1f;
		this.health = 10;
		enemies.add(this);
	}
	
	public Enemy01(float x, float y, int health, float size, Array<Parametric2d> path, Texture texture) {
		this.x = ox = x;
		this.y = oy = y; 
		this.path = path;
		this.texture = texture;
		this.size = size;
		this.health = health;
		enemies.add(this);
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
	public float getSize() {
		return size;
	}

	public static Array<Bullet> getEnemyBullets() {
		return enemyBullets;
	}

	public static void addEnemyBullet(Bullet bullet) {
		enemyBullets.add(bullet);
		
	}

	public static Array<Enemy> getEnemies() {
		return enemies;
	}

	@Override
	public Texture getTexture() {
		return texture;
	}

	@Override
	public boolean update(float delta) {
		//return true if enemy has been destroyed
		if (health <= 0) 
			return true;
		
		//end reached
		if (index == path.size) {
			this.isFinished = true;
			return true;
		}
		
		Parametric2d para = path.get(index);
		//is the parametric equation we are on done
		boolean isFinished = para.update(delta);
		//update current location
		x = ox + para.x.loc;
		y = oy + para.y.loc;
		//go to next parametric equation if current one is finished
		if (isFinished){
			//update the relative locations for px and py
			ox = x;
			oy = y;
			//increase the index
			index++;
		}
		return false;
	}

	public String toString() {
		return enemies.indexOf(this, true) + "\tx: " + x + "\ty: " + y + "\ts: " + size + "\tt: " + texture;
	}

	@Override
	public void damage() {
		health--;
		
	}

	@Override
	public boolean isFinished() {
		return isFinished;
	}

	@Override
	public boolean isDead() {
		return health <= 0;
	}
		
}
