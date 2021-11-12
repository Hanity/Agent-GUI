import jade.core.Agent;
import jade.core.behaviours.*;


public class LooperAgent extends Agent
{

    protected void setup()
    {
    	addBehaviour( new Looper( this, 300 ) );
    	addBehaviour( new Looper( this, 500 ) );
    	addBehaviour( new Looper( this, 800 ) );
    }
}
