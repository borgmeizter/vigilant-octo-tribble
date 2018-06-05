import javax.swing.*;
import java.awt.*;

class SmyckeNy extends JPanel {
    private JTextField nfält = new JTextField(10);
    private JTextField afält = new JTextField(10);

    public SmyckeNy() {

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        JPanel rad1 = new JPanel();
        rad1.add(new JLabel("Namn:"));
        rad1.add(nfält);
        add(rad1);
        JPanel rad2 = new JPanel();
        rad2.add(new JLabel("Antal:"));
        rad2.add(afält);
        add(rad2);
        
    }

    public String getNamn() {
        return nfält.getText();
    }

    public int getAntal() {
        return Integer.parseInt(afält.getText());
    }
}