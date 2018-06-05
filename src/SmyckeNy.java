import javax.swing.*;
import java.awt.*;

class SmyckeNy extends JFrame {
  JTextField nfält = new JTextField(10);
  JTextField afält = new JTextField(10);

    SmyckeNy() {
		
			setLayout(new FlowLayout());
			JPanel rad1 = new JPanel();
			rad1.add(new JLabel("Namn:"));
			rad1.add(nfält);
			add(rad1);
			JPanel rad2 = new JPanel();
			rad2.add(new JLabel("test:"));
			rad2.add(nfält);
			add(rad2);
			setSize(230, 100); 
			setVisible(true);
        
    }

   /* public String getNamn() {
        return nfält.getText();
    }

    public int getAntal() {
        return Integer.parseInt(afält.getText());
       
    }*/
    
    public static void main(String[] args){ new SmyckeNy(); 
    }
}

