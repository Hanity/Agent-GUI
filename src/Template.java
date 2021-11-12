/*****************************************************************

    Template.java:    Program which sends messages to agents "a1" and "a2"
                     and uses 2 behaviours with different templates to
                     select the responses
    
  Test:  % java jade.Boot main:Template a1:Responder a2:Responder
    
*****************************************************************/


import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.*;

//import jade.domain.AMSService;
//import jade.domain.FIPAAgentManagement.*;

import jade.lang.acl.*;


public class Template extends Agent 
{
    MessageTemplate mt1 = 
       MessageTemplate.and(  
           MessageTemplate.MatchPerformative( ACLMessage.INFORM ),
           MessageTemplate.MatchSender( new AID( "a1", 
                                                 AID.ISLOCALNAME))) ;

    protected void setup() 
    {
        // set up Behaviour 0
        // Send messages to "a1" and "a2"
        addBehaviour(new CyclicBehaviour(this) 
        {
             public void action( ) 
             {  
            	 ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                 msg.setContent( "Ping" );
                 for (int i = 1; i<=2; i++)
                     msg.addReceiver( new AID( "a" + i, AID.ISLOCALNAME) );
                 send(msg);
             }
        });
        
    // Set-up Behaviour 1
    
    
        addBehaviour(new CyclicBehaviour(this) 
        {
             public void action( ) 
             {  
                System.out.print("Behaviour ONE: ");
                ACLMessage msg= receive( mt1 );
                if (msg!=null)
                    System.out.println( "gets " 
                     +  msg.getPerformative() + " from "
                     +  msg.getSender().getLocalName() + "="
                     +  msg.getContent() );
                else
                    System.out.println( "gets NULL" );
                block();
             }
        });
        
    // Set-up Behaviour 2
    
        addBehaviour(new CyclicBehaviour(this) 
        {   
             public void action()
             {  
                System.out.print("Behaviour TWO: ");
                ACLMessage msg= receive();
                if (msg!=null)
                    System.out.println( "gets " 
                     +  msg.getPerformative() + " from "
                     +  msg.getSender().getLocalName() + "="
                     +  msg.getContent() );
                else
                    System.out.println( "gets NULL" );
                block();
             }
        });
    }
}