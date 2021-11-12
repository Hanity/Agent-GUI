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
public class letsseeifthisworks extends GuiAgent {

    public Gui RA1;

    public void setup() {
        System.out.println("ola pendejos! My name is " + getLocalName());
        RA1 = new Gui();
        RA1.setAgent(this);
    }
    // Put here the onGuiEvent to trigger upon clicking on the send button (sending msgs)
    public void onGuiEvent(GuiEvent ev) {
    	int type = ev.getType();
        //RA1.frameInit();
    	//RA1.SentArea.setText("henlo");
    	System.out.println(RA1.textField_2.getText());
    	RA1.SentArea.setText(RA1.textField_2.getText());
        //System.out.println("ur text area has the following currently: " + RA1.SentArea.getText());
    	System.out.println("Event is : "+ type);
    	if (type ==1) {
    		System.out.println("U clicked on Button Send");
    		//System.out.println("Check out the sent msg text area in ur GUI :p");
    		//RA1.scrollPaneSent = new JScrollPane();
    		//RA1.scrollPaneSent.setBounds(315, 60, 165, 85);
    		//RA1.add(RA1.scrollPaneSent);
    		
    		//RA1.SentArea = new JTextArea();
    		//RA1.scrollPaneSent.setViewportView(RA1.SentArea);
    		//RA1.SentArea.setText(RA1.textField_2.getText());
    		//System.out.println("msg in content is: " + RA1.SentArea.getText());
    		
    		//RA1.SentArea.setText(RA1.textField_2.getText());
    		
    		//System.out.println("Text area content is: " + RA1.SentArea.getText());
    		//RA1.setTitle("My Agent Name is: " + this.getName());
    	}
    	else {
    		System.out.println("U probably clicked on cancel han");
    	}
    	
    }
    
    //Put the Cyclic behaviour concerning receiving msgs and putting them in the TextArea
    
}

class Hununuw extends JFrame implements ActionListener {

    public letsseeifthisworks myAgent;
 //   public JButton B;
    public JButton btnSend;
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
    public JTextField textField_1;
    public JTextField textField_2;
    public JComboBox comboBox;
    //public JFrame frame;
    //private JTextField textField_1;
	//private JTextField textField_2;

    public Hununuw() {
        super.frameInit();
        setLayout(null);
        //setSize(700, 500);
    	//frame = new JFrame();
        //setBounds(100, 100, 566, 373);
        setBounds(100, 100, 566, 373);
        setTitle("I am an Agent GUI, Click my Button to Get My Agent's Name");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // =============Text areas===================================
        //========Sent msgs field
		this.scrollPaneSent = new JScrollPane();
		this.scrollPaneSent.setBounds(315, 60, 165, 85);
		this.add(scrollPaneSent);
		
		
		this.SentArea = new JTextArea();
		this.scrollPaneSent.setViewportView(SentArea);
		this.SentArea.setText("work !");
		
		//========Received msgs field
		JScrollPane scrollPaneReceived = new JScrollPane();
		scrollPaneReceived.setBounds(315, 200, 165, 85);
		this.add(scrollPaneReceived);
		
		JTextArea ReceivedArea = new JTextArea();
		scrollPaneReceived.setViewportView(ReceivedArea);
		//ReceivedArea.setText("Received Fuck you too");
		
		// =============End Text areas===================================
		

        
		//======Text Fields==============================================
		this.textField_1 = new JTextField();
		this.textField_1.setBounds(60, 150, 96, 20);
		this.add(textField_1);
		this.textField_1.setColumns(20);
		
		this.textField_2 = new JTextField();
		this.textField_2.setBounds(60, 225, 96, 20);
		this.add(textField_2);
		this.textField_2.setColumns(20);
		
		String perfos[] = {"","INFORM","REQUEST"};
		comboBox = new JComboBox<Object>(perfos);
		comboBox.setBounds(55,80, 108, 22);
		this.add(comboBox);
		
		
		//======End Text Fields=========================================
        
        //=======Labels=================================================

	    //Label for sent field
		JLabel SentLabel = new JLabel("Sent msgs");
		SentLabel.setBounds(335, 10, 80, 80);
		SentLabel.setForeground(new Color(128, 0, 128));
		add(SentLabel);

		//Label for received field
		JLabel ReceivedLabel = new JLabel("Received msgs");
		ReceivedLabel.setBounds(335, 140, 120, 80);
		ReceivedLabel.setForeground(new Color(0, 128, 0));
		add(ReceivedLabel);
		
		//Performative
		JLabel PerformativeLabel = new JLabel("Performative");
		PerformativeLabel.setBounds(64, 50, 78, 14);
		PerformativeLabel.setForeground(new Color(0, 128, 0));
		add(PerformativeLabel);
		
		//Receiver
		JLabel ReceiverLabel = new JLabel("Receiver?");
		ReceiverLabel.setBounds(69, 120, 78, 14);
		ReceiverLabel.setForeground(new Color(50, 128, 0));
		add(ReceiverLabel);
		
		//Content
		JLabel ContentLabel = new JLabel("Content");
		ContentLabel.setBounds(69, 190, 78, 14);
		ContentLabel.setForeground(new Color(50, 128, 0));
		add(ContentLabel);
        //=======End Labels==================================================

       
		//=========Buttons==================================================
        //jToolBar1 = new JToolBar();
        //jToolBar1.setBounds(60, 270, 120, 80);
        //add(jToolBar1);
        
		btnSend = new JButton("Send");
		btnSend.setForeground(new Color(0, 0, 255));
		btnSend.setBounds(10, 270, 89, 23);
		add(btnSend);
		//jToolBar1.add(btnSend);
		btnSend.addActionListener(this);
	        //setVisible(true);

		btnCancel = new JButton("Cancel");
		btnCancel.setForeground(new Color(255, 0, 0));
		btnCancel.setBounds(123, 270, 89, 23);
		add(btnCancel);
		btnCancel.addActionListener(this);
		//jToolBar1.add(btnCancel);
		//=========End Buttons==============================================
		setVisible(true);
        
    }

    public void setAgent(letsseeifthisworks a) {
        myAgent = a;
    }

    public void actionPerformed(java.awt.event.ActionEvent ae) {
        // TODO add your handling code here:

        //GuiEvent ge = new GuiEvent(this, 1);

        if (ae.getSource() == this.btnSend) {
        	GuiEvent ge = new GuiEvent(this, 1);
        	System.out.println("send clicked");
        	//System.out.println(this.SentArea.getText());
        	//SentArea.setText(textField_1.getText());
        	myAgent.postGuiEvent(ge);
        }
        else if (ae.getSource() == this.btnCancel){
        	GuiEvent ge = new GuiEvent(this, 2);
        	myAgent.postGuiEvent(ge);
        }
       
       
    }
}

