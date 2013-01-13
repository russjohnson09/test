package bullethell.view;

import bullethell.bullets.Bullet;
import bullethell.bullets.BulletTextures;
import bullethell.enemies.Enemy;
import bullethell.enemies.Enemy01;
import bullethell.enemies.EnemyTextures;
import bullethell.model.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.Array;

import bullethell.model.World;

public class WorldRenderer {
	
	//ratio for 480 x 854 phone
	public static final float CAMERA_WIDTH = 15f;
	public static final float CAMERA_HEIGHT = 26.6875f;
	
	private World world;
	private OrthographicCamera cam;
	
	private SpriteBatch spriteBatch;
	
	private ShapeRenderer debugRenderer = new ShapeRenderer();
	
	private boolean debug = false;
	
	private int width;
	private int height;
	private float ppuX;	// pixels per unit on the X axis
	private float ppuY;	// pixels per unit on the Y axis
	
	//game's player
	private Player player;
	private Array<Bullet> playerBullets;
	
	private Array<Bullet> enemyBullets = Enemy01.getEnemyBullets();
	private Array<Enemy> enemies = Enemy01.getEnemies();
	
	public void setSize (int w, int h) {
		this.width = w;
		this.height = h;
		ppuX = (float)width / CAMERA_WIDTH;
		ppuY = (float)height / CAMERA_HEIGHT;
	}

	public WorldRenderer(World world, boolean debug) {
		this.world = world;
		this.player = world.player;
		this.playerBullets = player.playerBullets;
		
		this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT); //camera's dimension's are the screen
		this.cam.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0); //camera is centered
		this.cam.update();
		this.debug = debug; //should debug?
		spriteBatch = new SpriteBatch(); //spritebatch for textures

	}
	
	public void render() {
//		drawHealthBar();

		debugRenderer.setProjectionMatrix(cam.combined);
		debugRenderer.begin(ShapeType.Rectangle);
		drawEnemyBulletsDebug();
		drawPlayerDebug();
		debugRenderer.end();
		
		spriteBatch.begin();
		drawEnemyHealth();
		drawScore();
		drawEnemies();
		drawPlayerBullets();
		drawEnemyBullets();
		drawPlayer();
		spriteBatch.end();
	}
	
	private void drawEnemyHealth() {
		TextureRegion u = new TextureRegion(EnemyTextures.ENEMY_HEALTH_DARKBLUE, (int)EnemyTextures.ENEMY_HEALTH_DARKBLUE.getWidth()*player.health/10, EnemyTextures.ENEMY_HEALTH_DARKBLUE.getHeight()); 
//		spriteBatch.draw(EnemyTextures.ENEMY_HEALTH_BLUE, 2*ppuX, 22*ppuY, 6*ppuX, 0.5f*ppuY);
		spriteBatch.draw(u, 2*ppuX, 22*ppuY, 6f*player.health/10f*ppuX, 0.5f*ppuY);
//		spriteBatch.draw(u, 3*ppuX, 5*ppuY, 0, 0, 10*ppuX, 0.5f*ppuY, 1, 1, 45f);
		
	}

	private void drawScore() {
		BitmapFont font = new BitmapFont();
//		font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
//		font.setScale(0.8f);
		font.draw(spriteBatch, "Graze: "+player.graze, 0.5f*ppuX, 1*ppuY);
		font.draw(spriteBatch, "Kills: "+player.kills , 0.5f*ppuX, 2*ppuY);	
	}

	
	
	private void drawHealthBar() {
		
		debugRenderer.setProjectionMatrix(cam.combined);
		debugRenderer.begin(ShapeType.FilledRectangle);
//		debugRenderer.begin(ShapeType.Rectangle);
		debugRenderer.setColor(new Color(1, 0, 0, 1));
		debugRenderer.filledRect(2, 24, (float) (player.health/2.0), 0.5f);
//		debugRenderer.rect(2, 24, (float) (player.health/2.0), 0.5f);
		debugRenderer.end();
	}

	private void drawEnemyBullets() {
		for (Bullet bullet : enemyBullets) {
			float s = bullet.getSize();
			float x = (bullet.getX() - s/2)*ppuX;
			float y = (bullet.getY() - s/2)*ppuY;
			
			if (bullet.getDelay() > 0) {
				spriteBatch.draw(BulletTextures.CLOUD, x, y, s*ppuX, s*ppuY);
			}
			else{
				spriteBatch.draw(bullet.getTexture(), x, y, s*ppuX, s*ppuY);
			}
		}
		
	}

	private void drawPlayerBullets() {
		for (Bullet bullet : playerBullets) {
			float s = bullet.getSize();
			float x = (bullet.getX() - s/2)*ppuX;
			float y = (bullet.getY() - s/2)*ppuY;
			spriteBatch.draw(bullet.getTexture(), x, y, s*ppuX, s*ppuY);
		}
		
	}

	private void drawEnemies() {
		for (Enemy enemy : enemies) {
			float s = enemy.getSize();
			float x = (enemy.getX() - s/2)*ppuX;
			float y = (enemy.getY() - s/2)*ppuY;
			spriteBatch.draw(enemy.getTexture(), x, y, s*ppuX, s*ppuY);
		}
			
	}

	//	
	private void drawPlayer() {
		float s = player.grazeSize;
		float x = (player.x-s/4)*ppuX;
		float y = (player.y-s/4)*ppuY;
		//draw transparent player
		if (player.invincibility > 0) {
			spriteBatch.draw(player.texture,x,y,s/2*ppuX,s/2*ppuY);
		}
		//draw normal player
		else{
			spriteBatch.draw(player.texture,x,y,s/2*ppuX,s/2*ppuY);
		}
		
	}

	private void drawDebug() {
		debugRenderer.setProjectionMatrix(cam.combined);
		debugRenderer.begin(ShapeType.Rectangle);
		debugRenderer.setColor(new Color(1, 0, 0, 1));
		drawPlayerDebug();
		drawPlayerBulletsDebug();
		drawEnemiesDebug();
		drawEnemyBulletsDebug();
		
		
		debugRenderer.end();
		
	}

	private void drawEnemyBulletsDebug() {
		for (Bullet bullet : enemyBullets) {
			if (bullet.getDelay() > 0) {
				debugRenderer.setColor(new Color(Color.GREEN));
			}
			else{
				debugRenderer.setColor(new Color(1, 0, 0, 1));
			}
			float s = bullet.getSize();
			float x = bullet.getX() - s/2;
			float y = bullet.getY() - s/2;
			debugRenderer.rect(x, y, s, s);
			debugRenderer.setColor(new Color(1, 0, 0, 1));
		}
		
	}

	private void drawEnemiesDebug() {
		for (Enemy enemy : enemies) {
			float s = enemy.getSize();
			float x = enemy.getX() - s/2;
			float y = enemy.getY() - s/2;
			debugRenderer.rect(x, y, s, s);
		}
		
	}

	private void drawPlayerDebug() {
		float s = player.size;
		float x = player.x - s/2;
		float y = player.y - s/2;
		debugRenderer.rect(x, y, s, s);
		s = player.grazeSize;
		x = player.x - s/2;
		y = player.y - s/2;
		debugRenderer.rect(x, y, s, s);
	}
	

	private void drawPlayerBulletsDebug() {
		for (Bullet bullet : playerBullets) {
			float s = bullet.getSize();
			float x = bullet.getX() - s/2;
			float y = bullet.getY() - s/2;
			debugRenderer.rect(x, y, s, s);
		}
		
	}

}
