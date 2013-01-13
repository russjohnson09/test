package bullethell.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;

import bullethell.model.Player;
import bullethell.model.StateM;
import bullethell.model.World;

public class WorldController implements InputProcessor {
	
	private World world;
	private Player player;
	
	public WorldController(World world) {
		this.world = world;

		this.player = world.player;
		
		Gdx.input.setInputProcessor(this);
	}
	
	
	/** The main update method **/
	public void update(float delta) {
		float dz = 0f; //deadzone
		//tilting up is negative (we want it positive)
		float y = -(Gdx.input.getAccelerometerY());
		//tilting to the right is negative
		float x = -(Gdx.input.getAccelerometerX());
		
		//if x is not in dead zone move player
		if (x < -dz || x > dz){
			player.x += x*0.08f;
		}
		
		//if y is not in dead zone move player
		if (y < -dz || y > dz){
			player.y += y*0.08f;
		}
		player.updateLocation(delta);
	}

	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.LEFT)
			player.sX = StateM.NEG;
		if (keycode == Keys.RIGHT)
			player.sX = StateM.POS;
		if (keycode == Keys.UP)
			player.sY = StateM.POS;
		if (keycode == Keys.DOWN)
			player.sY = StateM.NEG;
		if (keycode == Keys.SHIFT_LEFT || keycode == Keys.SHIFT_RIGHT)
			player.slow = true;
		if (keycode == Keys.Z)
			player.isFiring = true;
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Keys.LEFT && player.sX == StateM.NEG)
			player.sX = StateM.ZERO;
		if (keycode == Keys.RIGHT && player.sX == StateM.POS)
			player.sX = StateM.ZERO;
		if (keycode == Keys.UP && player.sY == StateM.POS)
			player.sY = StateM.ZERO;
		if (keycode == Keys.DOWN && player.sY== StateM.NEG)
			player.sY = StateM.ZERO;
		if (keycode == Keys.SHIFT_LEFT || keycode == Keys.SHIFT_RIGHT)
			player.slow = false;
		if (keycode == Keys.Z)
			player.isFiring = false;
		return true;
	}



	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		if (player.isFiring == true) {
			player.isFiring = false;
		}
		else {
			player.isFiring = true;
		}
		return true;
	}



	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		return true;
	}



	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean touchMoved(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}