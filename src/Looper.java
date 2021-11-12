import jade.core.Agent;
import jade.core.behaviours.*;

class Looper extends SimpleBehaviour
{
	static String offset = "";
	//static String ziada = "";
	static long   t0     = System.currentTimeMillis();

	String tab = "" ;
	int    n   = 1;
	long   dt;

	public Looper( Agent a, long dt) {
		super(a);
		this.dt = dt;
		offset += "    " ;
   		tab = new String(offset) ;
	}

	public void action()
	{
		System.out.println( "I am with:"+ this.dt + tab +
		   (System.currentTimeMillis()-t0)/10*10 + ": " +
			myAgent.getLocalName());
		block( dt );
		n++;
	}

	public  boolean done() {  return n>6;  }

}