package entities;
import javax.swing.*;
import java.awt.event.*;

public class MainFrame extends JFrame {

    private JTextField tfTempo;
    private JPanel mainPanel;
    private JTextField tffrequency;
    private JTextField tfMeasure;
    private JList tfnormal;
    private JList tfTriplet;
    private JList tfDotted;
    private JList tfNotesLength;

    public MainFrame(){
        setContentPane(mainPanel);
        setTitle("Delay Time Calculator");
        setSize(450,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        tfTempo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tempo = tfTempo.getText();

            }
        });
    }


}
