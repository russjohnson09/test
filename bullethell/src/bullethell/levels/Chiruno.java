package bullethell.levels;

import bullethell.bullets.BulletTextures;
import bullethell.bullets.Bullets;
import bullethell.enemies.Enemy;
import bullethell.enemies.Enemy01;
import bullethell.enemies.EnemyTextures;
import bullethell.model.Player;
import bullethell.movement.CommonPaths;
import bullethell.movement.Parametric2d;

import com.badlogic.gdx.utils.Array;

public class Chiruno {

	private static Enemy chirno;
	private static float speed = 1;

	public static boolean phase1(float t, Player player) {

		// create chiruno phase one enemy
		if (t == 1) {
			Array<Parametric2d> chirnoPath = chirnoPath();
			chirno = new Enemy01(7.5f, 28f, 30, 2, chirnoPath,
					EnemyTextures.RED);
		}

		if (t == 10 || t == 20 || t == 15) {
			Enemy01.addEnemyBullet(Bullets.seeking(chirno.getX(),
					chirno.getY(), player.x, player.y, 5f, BulletTextures.RED,
					0, 2f));
		}

		if (t % 5 == 0) {
			Enemy01.addEnemyBullet(Bullets.seeking(chirno.getX(),
					chirno.getY(), player.x, player.y, 5f, BulletTextures.RED,
					0, 2f));
		}
		return t > 100;
	}

	private static Array<Parametric2d> chirnoPath() {
		Array<Parametric2d> path = CommonPaths.twoPointsArray(7.5f, 28f, 7.5f,
				24f, 1f);
		path.add(CommonPaths.twoPointsPara(7.5f, 24, 3, 24, 1f));
		path.add(CommonPaths.twoPointsPara(3, 24, 3, 19, 1f));
		path.add(CommonPaths.twoPointsPara(3, 19, 13, 19, 2f));
		path.add(CommonPaths.twoPointsPara(13, 19, 7.5f, 21.5f, 1f));
		path.add(CommonPaths.twoPointsPara(7.5f, 21.5f, 7.5f, 15, 1f));
		return path;

	}

}
