package bullethell.movement;


/*
 * Class of parametric equations x = at
 */
public class Parametric {
	
	public float a; //scalar
	public float endT; //end time
	public float loc; //location
	public float t = 0; //current time

	//at
	public Parametric(float a, float endT){
		this.a = a;
		this.endT = endT;
	}

	/**
	 * Returns true if the end of the
	 * parametric equation is reached.
	 * @param delta
	 * @return
	 */
	public boolean update(float delta) {
		t += delta;
		if (t < endT){
			loc = a*t;
			return false;
		}
		else{
			return true;
		}
		
	}

}
