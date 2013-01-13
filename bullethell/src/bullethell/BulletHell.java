package bullethell;

import bullethell.screens.GameScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class BulletHell extends Game {
	
    private GameScreen stage1;

	@Override
	public void create() {
		stage1 = new GameScreen();

		setScreen(stage1);
	}

}