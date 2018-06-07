import java.util.ArrayList;
import javax.swing.*;

import java.awt.*;

public class Program extends JFrame{
	
	
	
	JTextArea display;
	private JRadioButton namnSort = new JRadioButton("Namn",false);
	private JRadioButton vardeSort = new JRadioButton("Värde", false);

	
	Program(){
		
		super("Värdesaker");
		setLayout(new BorderLayout());
		
		display = new JTextArea();
		JScrollPane scroll = new JScrollPane(display);
		display.setEditable(false);
		add(scroll, BorderLayout.CENTER);
		
		JPanel topPanel = new JPanel();
        add(topPanel, BorderLayout.NORTH);
        topPanel.add(new JLabel("Värdesaker"));
		
		
		JPanel hogra=new JPanel();
		hogra.setLayout(new BoxLayout(hogra, BoxLayout.Y_AXIS));
		add(hogra,BorderLayout.EAST);
		hogra.add(new JLabel("Sortering"));
		hogra.add(namnSort);
		hogra.add(vardeSort);
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Program();
	}

}