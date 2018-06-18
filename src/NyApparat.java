import javax.swing.*;

public class NyApparat extends JPanel {
    
	// Kolla namngivning på exempel för JTextField
	private JTextField nText = new JTextField(10);
    private JTextField pText = new JTextField(5);
    private JTextField sText = new JTextField(5);

    public NyApparat() {
        setLayout((new BoxLayout(this, BoxLayout.Y_AXIS)));
        JPanel rad1 = new JPanel();
        add(rad1);
        rad1.add(new JLabel("Namn:"));
        rad1.add(nText);
        JPanel rad2 = new JPanel();
        add(rad2);
        rad2.add(new JLabel("Pris:"));
        rad2.add(pText);
        JPanel rad3 = new JPanel();
        add(rad3);
        rad3.add(new JLabel("Slitage:"));
        rad3.add(sText);
    }

    public String getNamn() {
        return nText.getText();
    }

    public double getPris() {
        return Double.parseDouble(pText.getText());
    }

    public String getPrisFalt() {
        return pText.getText();
    }

    public int getSlitage() {
        return Integer.parseInt(sText.getText());
    }

    public String getSlitageFalt() {
        return sText.getText();
    }
}