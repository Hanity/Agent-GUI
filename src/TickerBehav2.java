
/**
   This example shows a TickerBehavior Added to an Agent
 */
import jade.core.Agent;
import jade.core.behaviours.*;
import java.util.*;


public class TickerBehav2 extends Agent
{
       
        long      t0 = System.currentTimeMillis();
	Behaviour loop;

	protected void setup()
	{
		loop = new TickerBehaviour( this, 1000 )
			{
                            protected void onTick() {
                            
                            System.out.println( System.currentTimeMillis()-t0 +
						": " + myAgent.getLocalName());
                            }
			};

		addBehaviour( loop );
                
	}
}
