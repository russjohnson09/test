package bullethell.model;

import bullethell.barrage.Barrage;
import bullethell.enemies.Enemy;
import bullethell.enemies.Enemy01;
import bullethell.levels.Demo;

public class World {
	
	public Player player;
	public Demo demo;
	
	public static Enemy boss = null;
	
	
	public World() {
		createDemoWorld();
	}
	
	
	private void createDemoWorld() {
		player = new Player();
		demo = new Demo(this);
//		Enemy enemy01 = new Enemy01();
//		createEnemy1();
//		Barrage.berzerker(0.1f);
//		Barrage.berzerker2(0.1f);
//		Barrage.berzerker3(0.1f);
	}


//	private void createEnemy1() {
//		Barrage.horizontal(10);
//		
//	}

}
