import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class display extends JFrame{
	
	public final JTextField input;
	public final JTextArea output;
	public String print;
	
	public display(){
	
	setSize(600,400);
	setLayout (new BorderLayout());
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	output = new JTextArea();
	JButton button = new JButton("Summarize");
	input = new JTextField("Enter URL and Click Summarize");
	Container c = getContentPane();
	c.add(output, BorderLayout.CENTER);
	c.add(button, BorderLayout.SOUTH);
	c.add(input, BorderLayout.NORTH);
	button.addActionListener(new ActionListener(){


		private String print = this.print;

		public void actionPerformed(ActionEvent e) {
			output.append(this.print);
		}
		
		
		
	});

	
	
	
	
	setVisible(true);
	}
	
	public static void main(String[] args) {
		display x = new display();
	}

}
