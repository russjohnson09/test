package bullethell.screens;

import bullethell.bullets.Bullet;
import bullethell.controller.WorldController;
import bullethell.enemies.Enemy;
import bullethell.enemies.Enemy01;
import bullethell.model.World;
import bullethell.view.WorldRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.utils.Array;

public class GameScreen implements Screen {

	private World world;
	private WorldRenderer renderer;
	private WorldController controller;

	private int width, height;

	private Array<Bullet> playerBullets;
	private Array<Bullet> enemyBullets = Enemy01.getEnemyBullets();
	private Array<Enemy> enemies = Enemy01.getEnemies();

	private Sound grazeSound;

	@Override
	public void show() {
		world = new World();
		playerBullets = world.player.playerBullets;

		renderer = new WorldRenderer(world, false);

		renderer.setSize(480, 854);
		controller = new WorldController(world);

		grazeSound = Gdx.audio.newSound(Gdx.files.internal("sounds/click.wav"));

	}

	@Override
	public void render(float delta) {
		// make screen black
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		// update level
		world.demo.update(delta);

		// update player
		controller.update(delta);

		// update player bullets
		updatePlayerBullets(delta);

		// update enemies
		updateEnemies(delta);

		// update enemyBullets
		updateEnemyBullets(delta);

		renderer.render();

	}

	// also updates players health and deaths
	private void updateEnemyBullets(float delta) {
		for (int i = enemyBullets.size - 1; i >= 0; i--) {
			Bullet bullet = enemyBullets.get(i);
			if (bullet.update(delta)) {
				enemyBullets.removeIndex(i);
			}
			if (bullet.isCollision(world.player.x, world.player.y,
					world.player.grazeSize)) {
				if (bullet.isCollision(world.player.x, world.player.y,
						world.player.size)) {
					enemyBullets.removeIndex(i);
					if (world.player.invincibility < 0) {
						world.player.health--;
						if (world.player.health == 0) {
							world.player.health = 10;
							world.player.invincibility = 3f;
							world.player.deaths++;
							System.out
									.println("Deaths: " + world.player.deaths);
						}
					}
				}
				// graze only counts if not invincible
				else if (!bullet.getIsGrazed()
						&& world.player.invincibility < 0) {
					world.player.graze++;
					grazeSound.play();
					bullet.setIsGrazed(true);
					System.out.println("Grazes: " + world.player.graze);
				}
			}
		}

	}

	private void updateEnemies(float delta) {
		for (int i = enemies.size - 1; i >= 0; i--) {
			Enemy enemy = enemies.get(i);
			for (int j = playerBullets.size - 1; j >= 0; j--) {
				Bullet bullet = playerBullets.get(j);
				if (bullet.isCollision(enemy.getX(), enemy.getY(),
						enemy.getSize())) {
					enemy.damage();
					playerBullets.removeIndex(j);
				}
			}
			// remove from array if killed or end of path reached
			if (enemy.update(delta)) {
				enemies.removeIndex(i);
				// increase players kills
				if (enemy.isDead()) {
					world.player.kills++;
				}
			}
		}

	}

	private void updatePlayerBullets(float delta) {
		for (int i = playerBullets.size - 1; i >= 0; i--) {
			Bullet bullet = playerBullets.get(i);
			if (bullet.update(delta)) {
				playerBullets.removeIndex(i);
			}
		}

	}

	@Override
	public void resize(int width, int height) {
		renderer.setSize(width, height);
		this.width = width;
		this.height = height;

	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);

	}

	@Override
	public void pause() {
		dispose();

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		Gdx.input.setInputProcessor(null);

	}

}