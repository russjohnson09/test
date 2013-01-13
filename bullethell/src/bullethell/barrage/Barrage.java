package bullethell.barrage;

/**
 * Various convenience methods for creating large numbers of entities.
 * 
 * @author russ
 * 
 */

public class Barrage {

	/**
	 * Makes an Enemy that goes back and forth i times. Spawning a bullet twice
	 * every two seconds with 0.1 second delay.
	 * 
	 * @param i
	 * @return Enemy
	 */
	// public static Enemy horizontal(int i) {
	// Array<Parametric2d> path = new Array<Parametric2d>();
	// for (int j = 0; j<i; j++){
	// Parametric2d para1 = CommonPara.twoPointsPara(10f, 0, 1f);
	// Parametric2d para2 = CommonPara.twoPointsPara(0f, -10f, 1f);
	// Parametric2d para3 = CommonPara.twoPointsPara(-10f, 0, 1f);
	// Parametric2d para4 = CommonPara.twoPointsPara(0, 10f, 1f);
	// path.add(para1);
	// path.add(para2);
	// path.add(para3);
	// path.add(para4);
	//
	// }
	// Enemy enemy = new Enemy(1f, 24f, 10f, 1f, path, new
	// Texture(Gdx.files.internal("images/high.png")));
	// Array<Bullet> bullets = enemy.spawnBullets;
	// Array<Float> times = enemy.waitTimes;
	// for (int j = 0; j < 20; j++){
	// times.add(2f);
	// bullets.add(new Bullet(0,0,
	// new Parametric2d(new Parametric(0,10f), new Parametric(-20f, 10f))));
	// times.add(0.5f);
	// bullets.add(new Bullet(enemy.x, enemy.y,
	// new Parametric2d(new Parametric(0,10f), new Parametric(-20f, 10f))));
	// times.add(0.5f);
	// bullets.add(new Bullet(0,0,
	// new Parametric2d(new Parametric(-10,10f), new Parametric(-20f, 10f))));
	// times.add(0.5f);
	// bullets.add(new Bullet(0,0,
	// new Parametric2d(new Parametric(-20,10f), new Parametric(-20f, 10f))));
	// times.add(0.5f);
	// bullets.add(new Bullet(0,0,
	// new Parametric2d(new Parametric(10,10f), new Parametric(-20f, 10f))));
	// }
	//
	// return enemy;
	//
	// }
	//
	// /**
	// * Square pattern shots bullets randomly.
	// * @param t delay
	// * @return
	// */
	// public static Enemy berzerker(float t) {
	// Array<Parametric2d> path = new Array<Parametric2d>();
	// for (int j = 0; j< 5; j++){
	// Parametric2d para1 = CommonPara.twoPointsPara(10f, 0, 1f);
	// Parametric2d para2 = CommonPara.twoPointsPara(0f, -10f, 1f);
	// Parametric2d para3 = CommonPara.twoPointsPara(-10f, 0, 1f);
	// Parametric2d para4 = CommonPara.twoPointsPara(0, 10f, 1f);
	// path.add(para1);
	// path.add(para2);
	// path.add(para3);
	// path.add(para4);
	//
	// }
	// Enemy enemy = new Enemy(1f, 24f, 10f, 1f, path, new
	// Texture(Gdx.files.internal("images/high.png")));
	// Array<Bullet> bullets = enemy.spawnBullets;
	// Array<Float> times = enemy.waitTimes;
	// //wait one second before hell storm
	// times.add(1f);
	// for (int j = 0; j < 300; j++){
	// times.add(t);
	// bullets.add(new Bullet(0,0,
	// new Parametric2d(new Parametric((float)(-5*Math.random()),10f), new
	// Parametric(-10f, 10f))));
	// }
	//
	// return enemy;
	//
	// }
	//
	// public static Enemy berzerker2(float t) {
	// Array<Parametric2d> path = new Array<Parametric2d>();
	// for (int j = 0; j< 5; j++){
	// Parametric2d para1 = CommonPara.twoPointsPara(-10f, 0, 1f);
	// Parametric2d para2 = CommonPara.twoPointsPara(0f, -10f, 1f);
	// Parametric2d para3 = CommonPara.twoPointsPara(10f, 0, 1f);
	// Parametric2d para4 = CommonPara.twoPointsPara(0, 10f, 1f);
	// path.add(para1);
	// path.add(para2);
	// path.add(para3);
	// path.add(para4);
	//
	// }
	// Enemy enemy = new Enemy(13f, 24f, 10f, 1f, path, new
	// Texture(Gdx.files.internal("images/high.png")));
	// Array<Bullet> bullets = enemy.spawnBullets;
	// Array<Float> times = enemy.waitTimes;
	// //wait one second before hell storm
	// times.add(1f);
	// for (int j = 0; j < 300; j++){
	// times.add(t);
	// bullets.add(new Bullet(0,0,
	// new Parametric2d(new Parametric((float)(-10*Math.random()),10f), new
	// Parametric(-10f, 10f))));
	// }
	//
	// return enemy;
	//
	// }
	//
	// public static Enemy berzerker3(float t) {
	// Array<Parametric2d> path = new Array<Parametric2d>();
	// for (int j = 0; j< 5; j++){
	// ParametricSin parasin1 = new
	// ParametricSin(4f,4f,(float)Math.PI,(float)Math.PI/4);
	// ParametricSin parasin2 = new
	// ParametricSin(4f,4f,(float)Math.PI,(float)Math.PI/4);
	// Parametric paraeq1 = new Parametric(15f,10f);
	// Parametric paraeq2 = new Parametric(-15f,10f);
	// Parametric paraeq3 = new Parametric(0f, 3f);
	// Parametric2d para1 = new Parametric2d(paraeq1,parasin1);
	// Parametric2d para2 = new Parametric2d(paraeq2,parasin2);
	// path.add(para1);
	// path.add(para2);
	//
	// }
	// Enemy enemy = new Enemy(1f, 24f, 10f, 1f, path, new
	// Texture(Gdx.files.internal("images/high.png")));
	// Array<Bullet> bullets = enemy.spawnBullets;
	// Array<Float> times = enemy.waitTimes;
	// //wait one second before hell storm
	// times.add(1f);
	// for (int j = 0; j < 300; j++){
	// times.add(t);
	// bullets.add(new Bullet(0,0,
	// new Parametric2d(new Parametric((float)(-10*Math.random()),10f), new
	// Parametric(-10f, 10f))));
	// }
	//
	// return enemy;
	//
	// }

	// public static Bullet playerBullet(float speed) {
	//
	// }
}
