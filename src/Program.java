import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.util.*;


public class Program extends JFrame implements ActionListener {
	
	private String[] vardesaker = { "Värdesaker", "Smycke", "Aktie", "Apparat" };
	private JComboBox<String> box = new JComboBox<>(vardesaker);

	//Listorna för värdesaker & behöver en för Aktier då de ska nollställas vid börskrash.
	
	private ArrayList<Vardesaker> vardeSaker = new ArrayList<>();
	private ArrayList<Aktie> aktieLista = new ArrayList<>();
	
	
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
		
		// { "Välj värdesak", "Smycke", "Aktie", "Apparat" };
		 nedre.add(box);
		 box.addActionListener(this);
		 
		// Knappar
		 JButton visaKnapp = new JButton("Visa");
	     nedre.add(visaKnapp);
	     visaKnapp.addActionListener(new VisaLyss());
	     namnSort.addActionListener(new visaSortering());
	    
	    JButton borskrasch=new JButton("Börskrasch");
	    nedre.add(borskrasch);
	    borskrasch.addActionListener(new Borskrasch());
		
	    
	    
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

       
    // Skapandet av ny Aktie  
	
     private void nyAktie() {
                
    	 NyAktie aktieNy = new NyAktie();
                
                boolean sant = true;
                
                while (sant) {
                    
                	//Byt ut namnet "test" och ge en förklaring till utseendet
                	int test = JOptionPane.showConfirmDialog(null, aktieNy, "Ny aktie", JOptionPane.OK_CANCEL_OPTION);
                    if (test == 2 || test == -1) {
                        break;
                    }
                    if (aktieNy.getNamn() == null || aktieNy.getNamn().equals("")) {
                        JOptionPane.showMessageDialog(null, "Fyll i namnet!", "Fel", JOptionPane.ERROR_MESSAGE);
                        continue;
                }
                
                    if (aktieNy.getAntalFalt().equals("")) {
                        JOptionPane.showMessageDialog(null, "Fyll i namnet på antalet!", "Fel", JOptionPane.ERROR_MESSAGE);
                        continue;
                }
                    if(aktieNy.getAntal() <1) {
                    	JOptionPane.showMessageDialog(null, "Antalet måste vara fler än noll", "Fel", JOptionPane.ERROR_MESSAGE);
                    	continue;
                    }
                    if(aktieNy.getKursFalt() == null || aktieNy.getKursFalt().equals("")) {
                    	
                    	JOptionPane.showMessageDialog(null, "Fyll i kursen", "Fel", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    try {
                    	String namn = aktieNy.getNamn();
                    	int antal=aktieNy.getAntal();
                    	Double kurs=aktieNy.getKurs();
                    	Aktie aNy= new Aktie(namn, antal,kurs);
                    	
                    	aktieLista.add(aNy);
                    	vardeSaker.add(aNy);
                    	break;
                    	
                    }
                  
                    catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Fel format!", "Fel", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    }         
            }
	
     
    // Skapandet av nytt Smycke
    private void nySmycke() {
         
    	NyttSmycke smyckeNy = new NyttSmycke();
    	boolean sant = true;
         while (sant) {
             int test = JOptionPane.showConfirmDialog(null, smyckeNy, "Nytt Smycke", JOptionPane.OK_CANCEL_OPTION);
             if (test == 2 || test == -1) {
                 break;
             }
             if ( smyckeNy.getNamn()==null || smyckeNy.getNamn().equals("")) {
            	 JOptionPane.showMessageDialog(null, "Fyll i namnet!", "Fel", JOptionPane.ERROR_MESSAGE);
                 continue;
             }
             // Lägg in .equals(null)
             if (smyckeNy.getStenFalt().equals("")) {
            	 JOptionPane.showMessageDialog(null, "Fyll i antal stenar!", "Fel", JOptionPane.ERROR_MESSAGE);
                 continue;
             }
             
             if (smyckeNy.getStenar() < 0) {
                 JOptionPane.showMessageDialog(null, "Antalet stenar kan ej vara negativt", "Fel", JOptionPane.ERROR_MESSAGE);
                 continue;
             }
             
             // Exception handling
             try {
            	
            	 String namn = smyckeNy.getNamn();
                 int stenar = smyckeNy.getStenar();
                 boolean guld = smyckeNy.getGuld();
                 Smycke sNy = new Smycke(namn, stenar, guld);
                 
                 // Lägger in i värdesakslistan
                 vardeSaker.add(sNy);
                 break;
             }
             catch (NumberFormatException e) {
                 JOptionPane.showMessageDialog(null, "Fel format!", "Fel", JOptionPane.ERROR_MESSAGE);
             }
            	 
             
             
         }
     }

     
    // Skapandet av ny Apparat
    
     private void nyApparat() {
     NyApparat apparatNy = new NyApparat();
     while (true) {
         int test = JOptionPane.showConfirmDialog(null, apparatNy, "Ny Apparat", JOptionPane.OK_CANCEL_OPTION);
         if (test == 2 || test == -1) {
             break;
         }
         
         if (apparatNy.getNamn().equals("") || apparatNy.getNamn() == null) {
        	 JOptionPane.showMessageDialog(null, "Namn måste finnas", "Fel", JOptionPane.ERROR_MESSAGE);
        	 continue;
         }
         
         if (apparatNy.getPrisFalt().equals("") || apparatNy.getPrisFalt() == null) {
        	 JOptionPane.showMessageDialog(null, "Lägg in pris", "Fel", JOptionPane.ERROR_MESSAGE);
         }
         
         if(apparatNy.getPris() <0) {
        	 JOptionPane.showMessageDialog(null, "Priset kan inte vara mindre än noll", "", JOptionPane.ERROR_MESSAGE);
        	 continue;
         }
         
         if(apparatNy.getSlitage() <1 || apparatNy.getSlitage()>10) {
        	 JOptionPane.showMessageDialog(null, "Slitage måste vara mellan 1 och 10", "Fel värde", JOptionPane.ERROR_MESSAGE);
         }
         
         if(apparatNy.getSlitageFalt().equals("") || apparatNy.getSlitageFalt() == null) {
        	 JOptionPane.showMessageDialog(null, "Lägg in slitage", "Inget värde, sätt in för slitage", JOptionPane.ERROR_MESSAGE);
         }
         
         try {
        	 String namn = apparatNy.getName();
        	 Double pris = apparatNy.getPris();
        	 int slitage = apparatNy.getSlitage();
        	 
        	 Apparat aNy = new Apparat(namn,slitage,pris);
        	// Lägger in i värdesakslistan
             vardeSaker.add(aNy);
         } 
         
         catch (NumberFormatException e) {
             JOptionPane.showMessageDialog(null, "Fel format!", "Fel", JOptionPane.ERROR_MESSAGE);
         }
        	
         
      
     }
 }
     
     
     // Sortering för namn
     
     private void sortByName() {
    	 
    	 System.out.println("****Här börjar namn sortering**** \n ");
         Collections.sort(vardeSaker, new Comparator<Vardesaker>() {
             public int compare(Vardesaker result1, Vardesaker result2) {
                 return result1.getNamn().compareTo(result2.getNamn());
             }
         });
         for (Vardesaker resultInstance : vardeSaker) {
             display.append(resultInstance + "\n");
         }
     }
     
     
     class VisaLyss implements ActionListener {
         public void actionPerformed(ActionEvent ave) {
        	 display.setText("");
             for (Vardesaker va : vardeSaker) {
                 display.append(va.toString() + "\n");
             }
         }
     }
     
     class Borskrasch implements ActionListener {
         public void actionPerformed(ActionEvent ave) {
             for (Aktie ak : aktieLista) {
                 ak.setKurs(0.0);
             }
         }
     }
    
     
     class visaSortering implements ActionListener {
         public void actionPerformed(ActionEvent ave) {
             display.setText("");
             sortByName();
         }
     }
     
     // Test för att se att koden fungerar
     private void test() {
    	 Aktie ak1 = new Aktie("Ericsson", 4, 0.25);
         vardeSaker.add(ak1);
         aktieLista.add(ak1);
         Aktie ak2 = new Aktie("Apple", 8, 5.5);
         vardeSaker.add(ak2);
         aktieLista.add(ak2);
     }
     
	public static void main(String[] args) {
		new Program().test();
	}
	
	

}