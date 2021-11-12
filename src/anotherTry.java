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
public class anotherTry extends GuiAgent {

    private Gui9 RA1;

    protected void setup() {
        System.out.println("Hello World! My name is " + getLocalName());
        RA1 = new Gui9();
        RA1.setAgent(this);
        RA1.show();
        //System.out.println(RA1.textArea.getText());
        

        // Make this agent terminate
        //doDelete();
    }

    protected void onGuiEvent(GuiEvent ev) {
        RA1.setTitle("My Agent Name is: " + this.getName());
        //RA1.textArea.append("hola");
        System.out.println(RA1.textArea.getText());
    }
}

class Gui9 extends JFrame implements ActionListener {

    private anotherTry myAgent;
    public JButton B;
    private JToolBar jToolBar1;
    public JScrollPane scrollPaneSent;
    public JTextArea textArea;
    public JTextField textField_1;
    
    protected void frameInit() {
        super.frameInit();
        setLayout(null);
    	setSize(700, 500);
        setTitle("I am an Agent GUI, Click my Button to Get My Agent's Name");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        
        
		JScrollPane scrollPaneSent = new JScrollPane();
		scrollPaneSent.setBounds(315, 60, 165, 85);
		this.add(scrollPaneSent);
		
		JTextArea textArea = new JTextArea();
		scrollPaneSent.setViewportView(textArea);
		textArea.setText("Sending Fuck you");
        
		textField_1 = new JTextField();
		textField_1.setBounds(60, 150, 150, 150);
		add(textField_1);
		textField_1.setColumns(20);

		B = new JButton("Send");
		B.setForeground(new Color(0, 0, 255));
		B.setBounds(10, 270, 89, 23);
		add(B);
        B.addActionListener(this);
        setVisible(true);
    }

    public void setAgent(anotherTry a) {
        myAgent = a;
    }

    public void actionPerformed(java.awt.event.ActionEvent ae) {
        // TODO add your handling code here:

        GuiEvent ge = new GuiEvent(this, 1);

        if (ae.getSource() == this.B) {
            myAgent.postGuiEvent(ge);
        }
    }
}
