import javax.swing.*;

public class NyttSmycke extends JPanel{
    
	//Kolla namngivning på exempel för JTextField
	private JTextField nText = new JTextField(10);
    private JTextField sText = new JTextField(5);
   
    private JCheckBox gBox = new JCheckBox("Guld");

    public NyttSmycke() {
        setLayout((new BoxLayout(this, BoxLayout.Y_AXIS)));
        JPanel rad1 = new JPanel();
        add(rad1);
        rad1.add(new JLabel("Namn:"));
        rad1.add(nText);
        JPanel rad2 = new JPanel();
        add(rad2);
        rad2.add(new JLabel("Antal stenar:"));
        rad2.add(sText);
        add(gBox);
    }

    public String getNamn() {
        return nText.getText();
    }

    public String getStenFalt() {
        return sText.getText();
    }

    public int getStenar() {
        return Integer.parseInt(sText.getText());
    }

    public boolean getGuld() {
        return gBox.isSelected();
    }
}