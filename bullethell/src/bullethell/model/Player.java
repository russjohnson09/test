package bullethell.model;

import bullethell.bullets.Bullet;
import bullethell.bullets.Bullet01;
import bullethell.bullets.Bullet02;
import bullethell.bullets.BulletTextures;
import bullethell.movement.Parametric;
import bullethell.movement.Parametric2d;
import bullethell.view.WorldRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.utils.Array;

public class Player {
	
	
	public int health = 10;
	
	//number of times player has been hit
	public int deaths = 0;
	
	//number of grazes
	public int graze = 0;
	
	//player's location (x,y)
	public float x,y;
	
	//player's size (circle)
	public float size;
	
	//size of graze area (circle)
	public float grazeSize;
	
	//player's texture file
	public Texture texture;
	
	//speed of player
	public float speed;
	
	public float bulletSpeed;
	
	//0.5 is a 50% slowdown
	public float slowDown;
	
	public float fireDelay;
	
	//is the player dying
	public boolean isDying = false;
	
	//is the player firing
	public boolean isFiring = false;
	
	//is player moving slowly
	public boolean slow = false;
	
	//fire delay initialized to zero (can fire right away)
	public float timeTilFire = 0f;
	
	//an array of bullets spawned by player
	public Array<Bullet> playerBullets = new Array<Bullet>();
	
	//which direction is the player going
	public StateM sX = StateM.ZERO;
	public StateM sY = StateM.ZERO;
	
	public Sound shot = Gdx.audio.newSound(Gdx.files.internal("sounds/silenced-gun.wav"));

	public float invincibility = 3f;

	public int kills = 0;
	
	/*
	 * Default constructor for Player
	 */
	public Player() {
		this.x = 2f;
		this.y = 2f;
		this.size = 0.1f;
		this.grazeSize = 2f;
		this.speed = 10f;
		this.bulletSpeed = 100f;
		this.slowDown = 0.5f;
		this.fireDelay = 0.1f;
		this.texture = new Texture(Gdx.files.internal("images/player/ship.png"));
	}
	
	public Player(float x, float y, float size, float grazeSize, float speed, float bulletSpeed, float slowDown, float fireDelay, Texture texture) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.grazeSize = grazeSize;
		this.speed = speed;
		this.bulletSpeed = bulletSpeed;
		this.slowDown = slowDown;
		this.fireDelay = fireDelay;
		this.texture = texture;
	}
	
	/*
	 * Adjust player's position, add bullets to playerBullets.
	 */
	public void updateLocation(float delta) {
		invincibility -= delta; //decrease invinciblity time
		timeTilFire -= delta; //decrease timeTilFire
		
		//speed of player when slowdown is taken into account
		float s;
		if (slow)
			s = this.speed * slowDown;
		else
			s = this.speed;
		
		//change in location equals delta*speed
		delta *= s;
		
		if (sX == StateM.NEG) {
			x -= delta;
		}
		else if (sX == StateM.POS) {
			x += delta;
		}
		
		if (sY == StateM.NEG) {
			y -= delta;
		}
		
		else if (sY == StateM.POS) {
			y += delta;
		}
		
		if (isFiring && timeTilFire <= 0){
			timeTilFire = fireDelay; //reset fire limiter
			addBullet();
		}
		
		if (y > WorldRenderer.CAMERA_HEIGHT){
			y = WorldRenderer.CAMERA_HEIGHT;
		}
		else if (y < 0){
			y = 0;
		}
		
		if (x > WorldRenderer.CAMERA_WIDTH) {
			x = WorldRenderer.CAMERA_WIDTH;
		}
		else if (x < 0){
			x = 0;
		}
			
	}


	private void addBullet() {
		shot.play();
		double random = Math.random();
//		playerBullets.add(new Bullet02(x, y, 0.1f, 0.1f, 90f, BulletTextures.bullet01, 0, 0.1f));
		if (random < 0.75){
			playerBullets.add(new Bullet01(x, y, 50f,90f, BulletTextures.BLUE, 0, 0.1f));
		}
		else{
			playerBullets.add(new Bullet01(x, y, 50f,(float)(87.5f+5f*Math.random()), BulletTextures.BLUE, 0, 0.1f));
		}
	}

}

