package bullethell.levels;

import bullethell.bullets.Bullet01;
import bullethell.bullets.BulletTextures;
import bullethell.bullets.Bullets;
import bullethell.enemies.Enemy;
import bullethell.enemies.Enemy01;
import bullethell.enemies.EnemyTextures;
import bullethell.model.World;
import bullethell.movement.CommonPaths;
import bullethell.view.WorldRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.utils.Array;

/**
 * A demo level displaying the main functionality of the game.
 * 
 * @author russ
 * 
 */
public class Demo {
	private Music m1 = Gdx.audio.newMusic(Gdx.files
			.internal("music/creeping_death.mp3"));
	private Music m2 = Gdx.audio.newMusic(Gdx.files
			.internal("music/cosmo_blast.mp3"));

	// time elapsed
	private float te;

	// time in tenths of seconds
	private int t = 0;

	private World world;
	// I can use an array for unnamed enemies.
	private Array<Enemy> enemies = new Array<Enemy>();

	// I can also name enemies if I need them to do more specific things. (i.e.
	// bosses)
	Enemy enemy1;
	Enemy enemy2;
	Enemy enemy3;
	Enemy enemy4;
	Enemy enemy5;
	Enemy enemy6;
	Enemy enemy7;
	Enemy enemy8;

	public Demo(World world) {
		te = 0;
		this.world = world;
	}

	public boolean update(float delta) {
		te += delta;
		if (te > 0.1f) {
			t++;
			te = 0;
		} else {
			return false;
		}
		// phase1();
		// return false;
		return (Chiruno.phase1(t, world.player));
		// frames++;
		// System.out.println(frames);
		// at 2, 4, 6, 8, 10, 12, and 14
		// if (frames < 1000){
		// phase1();
		// }
		// else if (frames < 2000){
		// phase2();
		// }

		// if (t == 1) {
		// enemies.add(new
		// Enemy01(-1f,20f,2,1.5f,CommonPaths.twoPointsArray(20f, 0, 2f),
		// EnemyTextures.enemy01));
		// }

		// if (t ==1) {
		// m2.play();
		// }
		//
		// if (1 == 1){
		// phase1();
		// return false;
		// }
		// if (t < 200){
		// phase2();
		// return false;
		// }
		//
		// return true;
	}

	private void phase1() {
		if (t % 10 == 0) {
			// enemy from left
			if (t % 20 == 0) {
				enemies.add(new Enemy01(-1f, 20f, 2, 1.5f, CommonPaths
						.originPointArray(20f, 0, 2f), EnemyTextures.BLUE));
			}
			// enemy from right
			else {
				enemies.add(new Enemy01(17f, 18f, 2, 1.5f, CommonPaths
						.originPointArray(-20f, 0, 2f), EnemyTextures.RED));
			}
		}

		if (t % 5 == 0) {
			for (int i = enemies.size - 1; i >= 0; i--) {
				Enemy enemy = enemies.get(i);
				if (enemy.isDead() || enemy.isFinished()) {
					enemies.removeIndex(i);
				} else {
					float x1 = enemy.getX();
					float y1 = enemy.getY();
					// if on screen spawn seeking and normal bullets
					if (x1 > 0 && x1 < WorldRenderer.CAMERA_WIDTH && y1 > 0
							&& y1 < WorldRenderer.CAMERA_HEIGHT) {
						float x2 = world.player.x;
						float y2 = world.player.y;
						Enemy01.addEnemyBullet(Bullets.seeking(x1, y1, x2, y2,
								10f, BulletTextures.RED, 0, 0.5f));
						Enemy01.addEnemyBullet(new Bullet01(x1, y1));
						Enemy01.addEnemyBullet(new Bullet01(x1, y1, 10f,
								(float) (-85f - Math.random() * 10f)));
						Enemy01.addEnemyBullet(new Bullet01(x1, y1, 1f, 270f,
								BulletTextures.RED, 2f, 0.5f));
					}
				}
			}
		}

	}

	private void phase2() {
		if (t % 50 == 0) {
			// enemy from left
			if (t % 100 == 0) {
				enemies.add(new Enemy01(-1f, 20f, 2, 1.5f, CommonPaths
						.originPointArray(20f, 0, 2f), EnemyTextures.BLUE));
			}
			// enemy from right
			else {
				enemies.add(new Enemy01(17f, 18f, 2, 1.5f, CommonPaths
						.originPointArray(-20f, 0, 2f), EnemyTextures.RED));
			}
		}

		if (t % 10 == 0) {
			for (int i = enemies.size - 1; i >= 0; i--) {
				Enemy enemy = enemies.get(i);
				if (enemy.isDead() || enemy.isFinished()) {
					enemies.removeIndex(i);
				} else {
					float x1 = enemy.getX();
					float y1 = enemy.getY();
					// if on screen spawn seeking and normal bullets
					if (x1 > 0 && x1 < WorldRenderer.CAMERA_WIDTH && y1 > 0
							&& y1 < WorldRenderer.CAMERA_HEIGHT) {
						float x2 = world.player.x;
						float y2 = world.player.y;
						Enemy01.addEnemyBullet(Bullets.seeking(x1, y1, x2, y2,
								10f, BulletTextures.RED, 0, 0.5f));
						Enemy01.addEnemyBullet(new Bullet01(x1, y1));
						Enemy01.addEnemyBullet(new Bullet01(x1, y1, 10f,
								(float) (-85f - Math.random() * 10f)));
					}
				}
			}
		}

	}

	// private void phase1() {
	// if (frames%50==0) {
	// //enemy from left
	// if (frames % 100 ==0){
	// enemies.add(new Enemy01(-1f,20f,2,1.5f,CommonPaths.twoPointsArray(20f, 0,
	// 2f), EnemyTextures.enemy01));
	// }
	// //enemy from right
	// else{
	// enemies.add(new Enemy01(17f,18f,2,1.5f,CommonPaths.twoPointsArray(-20f,
	// 0, 2f), EnemyTextures.enemy01));
	// }
	// }
	//
	// if (frames%20 == 0){
	// for (int i = enemies.size-1; i>=0; i--) {
	// Enemy enemy = enemies.get(i);
	// if (enemy.isDead() || enemy.isFinished()) {
	// enemies.removeIndex(i);
	// }
	// else{
	// float x1 = enemy.getX();
	// float y1 = enemy.getY();
	// //if on screen spawn seeking and normal bullets
	// if (x1 > 0 && x1 < WorldRenderer.CAMERA_WIDTH && y1 > 0 && y1 <
	// WorldRenderer.CAMERA_HEIGHT){
	// float x2 = world.player.x;
	// float y2 = world.player.y;
	// Enemy01.addEnemyBullet(Bullets.seeking(x1, y1, x2, y2, 10f,
	// BulletTextures.bullet01, 0, 0.5f));
	// Enemy01.addEnemyBullet(new Bullet01(x1, y1));
	// Enemy01.addEnemyBullet(new
	// Bullet01(x1,y1,10f,(float)(-85f-Math.random()*10f)));
	// }
	// }
	// }
	// }
	//
	// }

	// private void phase2() {
	// if (frames%50==0) {
	// //enemy from left
	// if (frames % 100 ==0){
	// enemies.add(new Enemy01(-1f,20f,2,1.5f,CommonPaths.twoPointsArray(20f, 0,
	// 2f), EnemyTextures.enemy01));
	// }
	// //enemy from right
	// else{
	// enemies.add(new Enemy01(17f,18f,2,1.5f,CommonPaths.twoPointsArray(-20f,
	// 0, 2f), EnemyTextures.enemy01));
	// }
	// }
	//
	// if (frames%10 == 0){
	// for (int i = enemies.size-1; i>=0; i--) {
	// Enemy enemy = enemies.get(i);
	// if (enemy.isDead() || enemy.isFinished()) {
	// enemies.removeIndex(i);
	// }
	// else{
	// float x1 = enemy.getX();
	// float y1 = enemy.getY();
	// //if on screen spawn seeking and normal bullets
	// if (x1 > 0 && x1 < WorldRenderer.CAMERA_WIDTH && y1 > 0 && y1 <
	// WorldRenderer.CAMERA_HEIGHT){
	// float x2 = world.player.x;
	// float y2 = world.player.y;
	// Enemy01.addEnemyBullet(Bullets.seeking(x1, y1, x2, y2, 10f,
	// BulletTextures.bullet01, 0, 0.5f));
	// Enemy01.addEnemyBullet(new Bullet01(x1, y1));
	// Enemy01.addEnemyBullet(new
	// Bullet01(x1,y1,10f,(float)(-85f-Math.random()*10f)));
	// }
	// }
	// }
	// }
	//
	// }

}
