
/**
   This example shows a TickerBehavior Added to an Agent
 */
import jade.core.Agent;
import java.util.Iterator;
import jade.core.behaviours.*;

public class TickerBehav1 extends Agent {
	protected void setup() {
		addBehaviour(new TickerBehaviour(this, 1000) {
			int x = 0;
			protected void onTick() {
			// perform operation Y
			    System.out.println("I am Counting");
			    x++;
			}
		} );
	}
}

