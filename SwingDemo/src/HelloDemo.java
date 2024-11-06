import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloDemo extends JFrame {
    private JPanel panelMain;
    private JTextField textName;
    private JButton btnClick;


    public HelloDemo() {
        btnClick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(btnClick, textName.getText() + "Hello");
            }
        });
    }

    public static void main(String[] args) {
        HelloDemo h =new  HelloDemo();
        h.setContentPane(h.panelMain);
        h.setTitle("Hello");
        h.setBounds(600,200,200,200);
        // h.setSize(500,200);
        h.setVisible(true);
        h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
