import java.util.ArrayList;
import javax.swing.*;

import java.awt.*;

public class Program extends JFrame{
	
	JTextArea display;
	JRadioButton allaButton;
	
	Program(){
		
		super("Värdesaker");
		setLayout(new BorderLayout());
		
		display = new JTextArea();
		JScrollPane scroll = new JScrollPane(display);
		display.setEditable(false);
		add(scroll, BorderLayout.CENTER);
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Program();
	}

}