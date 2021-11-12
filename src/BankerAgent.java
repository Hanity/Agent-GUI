
/**
   This example shows a minimal agent that just prints "Hello     
   World!" 
   The Agent also returns its name
   and then terminates.
 */
import jade.core.Agent;
import jade.core.*;
import jade.core.behaviours.*;
import jade.domain.*;
import jade.domain.FIPAAgentManagement.*;
import jade.lang.acl.*;
import jade.content.*;
import jade.content.lang.*;
import jade.content.lang.sl.*;
import jade.content.onto.*;
import jade.content.onto.basic.*;
import jade.util.leap.*;
import jade.gui.*;
import jade.lang.acl.ACLMessage;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.DFService;
import jade.domain.FIPAException;

import java.util.Iterator;
import java.util.Date;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.io.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;



public class BankerAgent extends Agent {

    String CustomerName = null;

    protected void setup() {

        /** Registration with the DF */
        DFAgentDescription dfd = new DFAgentDescription();
        ServiceDescription sd = new ServiceDescription();
        sd.setType("SenderAgent");
        sd.setName(getName());
        sd.setOwnership("ExampleReceiversOfJADE");
        sd.addOntologies("SenderAgent");
        dfd.setName(getAID());
        dfd.addServices(sd);
        try {
        DFService.register(this,dfd);
        } catch (FIPAException e) {
        System.err.println(getLocalName()+" registration with DF unsucceeded. Reason: "+e.getMessage());
        doDelete();
        }


        System.out.println("Hello World! My name is " + getAID().getLocalName());
        SendMessage sm = new SendMessage();
        ReceiveMessage rm = new ReceiveMessage();
        addBehaviour(sm);
        addBehaviour(rm);
    }

    public class SendMessage extends OneShotBehaviour {

        public void action() {
            System.out.println("Please Enter Your Name for Loan:");

            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                CustomerName = br.readLine();

            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
           
            if (!CustomerName.isEmpty()) {

                ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
                msg.addReceiver(new AID("C", AID.ISLOCALNAME));
                msg.setLanguage("English");
                msg.setContent(CustomerName);
                send(msg);
                System.out.println("****I Sent Message to::> C *****" + "\n" +
                        "The Content of My Message is::>" + msg.getContent());

            }


        }
    }

    public class ReceiveMessage extends CyclicBehaviour {

        // Variable to Hold the content of the received Message
        private String Message_Performative;
        private String Message_Content;
        private String SenderName;
        private String MyPlan;

        public void action() {
            ACLMessage msg = receive();
            if (msg != null) {

                Message_Performative = msg.getPerformative(msg.getPerformative());
                Message_Content = msg.getContent();
                SenderName = msg.getSender().getLocalName();

                System.out.println(" ****I Received a Message***" + "\n" +
                        "The Sender Name is::>" + SenderName + "\n" +
                        "The Content of the Message is::> " + Message_Content + "\n" +
                        "::: And Performative is::> " + Message_Performative + "\n");
                System.out.println("ooooooooooooooooooooooooooooooooooooooo");

                if (SenderName.equals("C")) {

                    if (Message_Performative.equals("INFORM") && Message_Content.equals("EXIST")) {

                        System.out.println("You Are a Valid " +
                                "Customer and Eligible for Loan");
                        

                        ACLMessage msgl = new ACLMessage(ACLMessage.REQUEST);
                        msgl.addReceiver(new AID("L", AID.ISLOCALNAME));
                        msgl.setLanguage("English");
                        msgl.setContent(CustomerName);
                        send(msgl);
                        
                        System.out.println("A Message has Been Sent to LoanAgent");
                    } else {
                        System.out.println("You Are Not a Valid " +
                                "Customer and not Eligible for Loan");
                        System.out.println("Request Rejected");
                    }
                } else if (SenderName.equals("L") && Message_Performative.equals("INFORM") &&
                        Message_Content.equals("EXIST")) {
                    System.out.println("Loan Recorded and Customer is not new");
                } else {
                    System.out.println("Loan Recorded");
                }
            }

        }
    }





}

