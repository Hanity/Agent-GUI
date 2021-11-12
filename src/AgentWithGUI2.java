//package examples.hello;

//import ontologyconnection.*;
import jade.core.Agent;
import jade.core.*;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.gui.*;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

/**
This example shows a minimal agent that just prints "Hallo World!" 
and then terminates.
@author Giovanni Caire - TILAB
 */
public class AgentWithGUI2 extends GuiAgent {

    private Gui2 RA1;
    protected void setup() {
        System.out.println("Hello World! My name is " + getLocalName());
        RA1 = new Gui2();
        RA1.setAgent(this);
    }
    // Put here the onGuiEvent to trigger upon clicking on the send button (sending msgs)
    protected void onGuiEvent(GuiEvent ev) {
    	System.out.println("U clicked on Button Send");
    	RA1.frame.setTitle("My Agent Name is: " + this.getName());
    }
    
    //Put the Cyclic behaviour concerning receiving msgs and putting them in the TextArea
    
}

class Gui2 extends JFrame implements ActionListener {

    private AgentWithGUI2 myAgent;
 //   public JButton B;
    public JButton btnNewButton;
    public JButton btnCancel;
    private JToolBar jToolBar1;
    //private JToolBar jToolBar2;
    public JScrollPane scrollPaneSent;
    public JScrollPane scrollPaneReceived;
    public JLabel PerformativeLabel;
    public JLabel ReceiverLabel;
    public JLabel ContentLabel;
    public JLabel SentLabel;
    public JLabel ReceivedLabel;
    public JTextArea SentArea;
    public JTextArea ReceivedArea;
    public JFrame frame;
    //private JTextField textField_1;
	//private JTextField textField_2;

    protected void frameInit() {
    	super.frameInit();
    	setLayout(null);
    	setSize(700, 500);
    	//frame = new JFrame();
        //setBounds(100, 100, 566, 373);
    	setTitle("I am an Agent GUI, Click my Button to Get My Agent's Name");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

	      //Label for sent field
		JLabel SentLabel = new JLabel("Sent msgs");
		SentLabel.setBounds(335, 10, 80, 80);
		SentLabel.setForeground(new Color(128, 0, 128));
		add(SentLabel);
        //========Sent msgs field
		JScrollPane scrollPaneSent = new JScrollPane();
		scrollPaneSent.setBounds(315, 60, 165, 85);
		getContentPane().add(scrollPaneSent);
		
		JTextArea SentArea = new JTextArea();
		scrollPaneSent.setViewportView(SentArea);
		SentArea.setText("Sending Fuck you");
		
		
		//Label for received field
		JLabel ReceivedLabel = new JLabel("Received msgs");
		ReceivedLabel.setBounds(335, 140, 120, 80);
		ReceivedLabel.setForeground(new Color(0, 128, 0));
		getContentPane().add(ReceivedLabel);
		//========Received msgs field
		JScrollPane scrollPaneReceived = new JScrollPane();
		scrollPaneReceived.setBounds(315, 200, 165, 85);
		getContentPane().add(scrollPaneReceived);
		
		JTextArea ReceivedArea = new JTextArea();
		scrollPaneReceived.setViewportView(ReceivedArea);
		ReceivedArea.setText("Received Fuck you too");
		
        //jToolBar1 = new JToolBar();
        //add(jToolBar1);
        
        
        //=======Labels=================================================

		

        
        //=======End Labels==================================================

       

		//=========End Buttons============================
		setVisible(true);
    }

    public void setAgent(AgentWithGUI2 a) {
        myAgent = a;
    }

    public void actionPerformed(java.awt.event.ActionEvent ae) {
        // TODO add your handling code here:

        //GuiEvent ge = new GuiEvent(this, 1);
    	GuiEvent ge = new GuiEvent(this, 1);
        if (ae.getSource() == this.btnNewButton) {
            myAgent.postGuiEvent(ge);
        }
        
       
    }
}
