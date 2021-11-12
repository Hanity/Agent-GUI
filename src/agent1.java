import jade.core.Agent;

import jade.core.AID;
import jade.core.behaviours.*;
import jade.lang.acl.*;

public class agent1 extends Agent {

	 protected void setup() 
	    {
		// First set-up answering behaviour
		
			addBehaviour(new CyclicBehaviour(this) 
			{
				 public void action() {
					ACLMessage msg= receive();
					if (msg!=null)
						System.out.println( "== Answer" + " <- " 
						 +  msg.getContent() + " from "
						 +  msg.getSender().getName() );
					block();
				 }
			});
			
		// Send messages to "a1" and "a2"
		
			ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
			//msg.setContent( "Ping agent1" );
			//for (int i = 1; i<=2; i++)
	        //msg.addReceiver( new AID( "a" + i, AID.ISLOCALNAME) );
			
			msg.setContent( "Hola" );
			msg.addReceiver( new AID( "a2", AID.ISLOCALNAME) );

			send(msg);
			
		}
	}