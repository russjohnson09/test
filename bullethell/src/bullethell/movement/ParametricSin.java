package bullethell.movement;

public class ParametricSin extends Parametric {
	
	
	public float b;
	public float c;
	
	//a*sin(b*t+c)
	public ParametricSin(float a, float b, float c, float endT) {
		super(a, endT);
		this.b = b;
		this.c = c;
	}

	
	public boolean update(float delta) {
		t += delta;
		if (t < endT){
			loc = (float)(a*Math.sin(b*t+c));
			return false;
		}
		else{
			return true;
		}
		
	}
}
