import jade.core.Agent;

import jade.core.behaviours.*;
import jade.lang.acl.*;


public class agent2 extends Agent 
{
	
    protected void setup() 
    {
		addBehaviour(new CyclicBehaviour(this) 
		{
			 public void action() {
				ACLMessage msg= receive();
				if (msg!=null) {
					System.out.println( " - " +
					   myAgent.getLocalName() + " <- " +
					   msg.getContent() );
				
				ACLMessage reply = msg.createReply();
				reply.setPerformative( ACLMessage.INFORM );
				reply.setContent(" Hola" );
				send(reply);
				
			 }
			 block();
			 }
		});
	}
}
