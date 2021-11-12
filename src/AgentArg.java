
/**
   Agent with Arguments
 */
import jade.core.Agent;
import java.util.Iterator;


public class AgentArg extends Agent {

  protected void setup() {
  	System.out.println("Hello World! My name is "+getAID().getLocalName());
        System.out.println("Hello World. Im an agent!");
        System.out.println("My local-name is "+getAID().getLocalName());
        System.out.println("My GUID is "+getAID().getName());
        System.out.println("My addresses are:");
        Iterator it = getAID().getAllAddresses();
        while (it.hasNext()) {
        System.out.println("- "+it.next());
        }
        System.out.println("My arguments are:");
        Object[] args = getArguments();
        if (args != null) {
            for (int i = 0; i < args.length; ++i) {
            System.out.println("- "+args[i]);
            }
        }
        String s = args[0].toString();
        int x =1;
        if(s.equals("Hi"))
            System.out.println("My Firs Argument is Hi Therefore I have to reply you back Hi Hi");
        else
            System.out.println("My First Argument is not Hi Sorry Bye");
  	// Make this agent terminate
  	//doDelete();
  } 
}

