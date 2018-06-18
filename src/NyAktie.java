import javax.swing.*;

public class NyAktie extends JPanel {
   
	
	//Kolla namngivning på exempel för JTextField
	private JTextField nText = new JTextField(10);
    private JTextField aText = new JTextField(5);
    private JTextField kText = new JTextField(5);

    public NyAktie() {
        
    	
    	setLayout((new BoxLayout(this, BoxLayout.Y_AXIS)));
        JPanel rad1 = new JPanel();
        add(rad1);
        rad1.add(new JLabel("Namn:"));
        rad1.add(nText);
        JPanel rad2 = new JPanel();
        add(rad2);
        rad2.add(new JLabel("Antal:"));
        rad2.add(aText);
        JPanel rad3 = new JPanel();
        add(rad3);
        rad3.add(new JLabel("Kurs:"));
        rad3.add(kText);
    }

    public String getNamn() {
        return nText.getText();
    }

    public int getAntal() {
        return Integer.parseInt(aText.getText());
    }

    public String getAntalFalt() {
        return aText.getText();
    }

    public Double getKurs() {
        return Double.parseDouble(kText.getText());
    }

    public String getKursFalt() {
        return kText.getText();
    }
}