package bullethell.movement;

/**
 * This class has a parametric equation for x and y.
 * Has only one method update.
 * @author russ
 *
 */
public class Parametric2d {

public Parametric x;
public Parametric y;

public Parametric2d(Parametric x, Parametric y){
	this.x = x;
	this.y = y;
}

/**
 * Update both x and y's parametric equations.
 * @param delta
 * @return
 */
public boolean update(float delta){
	//if either has reached the end the parametric2d has reached the end
	return x.update(delta) || y.update(delta);
//	boolean flag1 = x.update(delta);
//	boolean flag2 = y.update(delta);
//	return flag1 || flag2;
		
}

}
