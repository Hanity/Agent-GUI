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
public class AgentWithGUI extends GuiAgent {

    public Gui4 RA1;

    /**
     * @wbp.parser.entryPoint
     */
    public void setup() {
        System.out.println("Hello World! My name is " + getLocalName());
        RA1 = new Gui4();
        RA1.btnSend.setForeground(new Color(0, 0, 0));
        RA1.btnSend.setBackground(new Color(0, 51, 102));
        RA1.getContentPane().setBackground(new Color(255, 153, 153));
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(102, 0, 51));
        panel.setBounds(0, 0, 276, 338);
        RA1.getContentPane().add(panel);
        panel.setLayout(null);
        RA1.setAgent(this);
        
    }
    // Put here the onGui4Event to trigger upon clicking on the send button (sending msgs)
    public void onGuiEvent(GuiEvent ev) {
    	int type = ev.getType();
    	System.out.println(RA1.textField_2.getText());
    	RA1.SentArea.setText(RA1.textField_2.getText());
    	System.out.println("Event is : "+ type);
    	if (type ==1) {
    		System.out.println("U clicked on Button Send");
            System.out.println("The seclected performative is: "+ RA1.comboBox.getSelectedItem());
    	}
    	else {
    		System.out.println("U probably clicked on cancel han");
    	}
    	
    }
    
    //Put the Cyclic behaviour concerning receiving msgs and putting them in the TextArea
    
}

class Gui4 extends JFrame implements ActionListener {

    public AgentWithGUI myAgent;
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

    public Gui4() {
        super.frameInit();
        setLayout(null);
        //setSize(700, 500);
        setBounds(100, 100, 566, 373);
        setTitle("I a Agent GUI");
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
        
		this.btnSend = new JButton("Send");
		this.btnSend.setForeground(new Color(0, 0, 255));
		this.btnSend.setBounds(10, 270, 89, 23);
		add(this.btnSend);
		//jToolBar1.add(btnSend);
		this.btnSend.addActionListener(this);
	        //setVisible(true);

		this.btnCancel = new JButton("Cancel");
		this.btnCancel.setForeground(new Color(255, 0, 0));
		this.btnCancel.setBounds(123, 270, 89, 23);
		add(this.btnCancel);
		this.btnCancel.addActionListener(this);
		//jToolBar1.add(btnCancel);
		//=========End Buttons==============================================
		setVisible(true);
        
    }

    public void setAgent(AgentWithGUI a) {
        myAgent = a;
    }

    public void actionPerformed(java.awt.event.ActionEvent ae) {
        // TODO add your handling code here:

        //GuiEvent ge = new GuiEvent(this, 1);

        if (ae.getSource() == this.btnSend) {
        	GuiEvent ge = new GuiEvent(this, 1);
        	System.out.println("send clicked");
        	myAgent.postGuiEvent(ge);
        }
        else if (ae.getSource() == this.btnCancel){
        	GuiEvent ge = new GuiEvent(this, 2);
        	myAgent.postGuiEvent(ge);
        }
       
       
    }
}
