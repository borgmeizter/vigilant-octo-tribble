import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.util.*;

public class Program extends JFrame implements ActionListener

{
	
	 private String[] vardesaker = { "Värdesaker", "Smycke", "Aktie", "Apparat" };
	 private JComboBox<String> box = new JComboBox<>(vardesaker);

	
	JTextArea display;
	private JRadioButton namnSort = new JRadioButton("Namn",false);
	private JRadioButton vardeSort = new JRadioButton("Värde", false);

	
	Program(){
		
		
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
		
		JPanel nedre=new JPanel();
		add(nedre, BorderLayout.SOUTH);
		
		//Skroll { "Välj värdesak", "Smycke", "Aktie", "Apparat" };
		 nedre.add(box);
		 box.addActionListener(this);
		 
		// Knappar
		 JButton visaKnapp = new JButton("Visa");
	     nedre.add(visaKnapp);
	      
	    JButton borskrasch=new JButton("Börskrasch");
	    nedre.add(borskrasch);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 600);
		setVisible(true);
	}
	
	//För att relatera tryckningen i fönstret med att skapa nya smycken och liknande
	
	public void actionPerformed(ActionEvent ave) {
        if (box.getSelectedIndex() == 2) {
            nyAktie();
        }
            
        else if (box.getSelectedIndex() == 1) {
            	nySmycke();
            	}
        
        else if (box.getSelectedIndex() == 3) {
        	nyApparat();
        }
            }

       
            
     private void nyAktie() {
                NyAktie aktieForm = new NyAktie();
                while (true) {
                    int test = JOptionPane.showConfirmDialog(null, aktieForm, "Ny aktie", JOptionPane.OK_CANCEL_OPTION);
                    if (test == 2 || test == -1) {
                        break;
                    }
                }
            }
	
    private void nySmycke() {
         NyttSmycke Smycke = new NyttSmycke();
         while (true) {
             int test = JOptionPane.showConfirmDialog(null, Smycke, "Nytt Smycke", JOptionPane.OK_CANCEL_OPTION);
             if (test == 2 || test == -1) {
                 break;
             }
         }
     }

     
     private void nyApparat() {
     NyApparat Apparat = new NyApparat();
     while (true) {
         int test = JOptionPane.showConfirmDialog(null, Apparat, "Ny Apparat", JOptionPane.OK_CANCEL_OPTION);
         if (test == 2 || test == -1) {
             break;
         }
     }
 }
     
     
	public static void main(String[] args) {
		new Program();
	}
	
	

}