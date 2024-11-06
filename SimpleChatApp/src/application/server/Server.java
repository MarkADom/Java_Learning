package application.server;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Server implements ActionListener {

    JTextField text;
    JPanel a1;
    static Box vertical = Box.createVerticalBox();
    static JFrame f = new JFrame();
    static DataOutputStream dOut;

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String out = text.getText();
            JPanel p2 = formatLabel(out);
            JPanel right = new JPanel(new BorderLayout());
            right.add(p2, BorderLayout.LINE_END);
            vertical.add(right);
            vertical.add(Box.createVerticalStrut(15));
            a1.add(vertical, BorderLayout.PAGE_START);
            dOut.writeUTF(out);
            text.setText("");
            f.repaint();
            f.invalidate();
            f.validate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JPanel formatLabel(String out) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel output = new JPanel(Boolean.parseBoolean("<html><p style=\"with: 150px\">" + out + "</p></html>"));
        output.setFont(new Font("Tahoma", Font.PLAIN, 16));
        output.setBackground(new Color(37, 211, 102));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15, 15, 15, 50));
        panel.add(output);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));
        panel.add(time);
        return panel;
    }

    public static void main(String[] args) {
        new Server();
        try {
            ServerSocket skt = new ServerSocket(6001);
            while (true) {
                Socket s = skt.accept();
                DataInputStream din = new DataInputStream(s.getInputStream());
                dOut = new DataOutputStream(s.getOutputStream());
                while (true) {
                    String msg = din.readUTF();
                    JPanel panel = formatLabel(msg);
                    JPanel left = new JPanel(new BorderLayout());
                    left.add(panel, BorderLayout.LINE_START);
                    vertical.add(left);
                    f.validate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Server() {
        f.setLayout(null);
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(37, 147, 211));
        p1.setBounds(0, 0, 450, 70);
        p1.setLayout(null);
        f.add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("arrow.png"));
        Image i2 = i1.getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(5, 20, 24, 24);
        p1.add(back);

        back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae) {
                System.exit(0);
            }
        });

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource(""));
        Image i5 = i4.getImage().getScaledInstance(24,24,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel profile = new JLabel(i6);
        profile.setBounds(40,10,24,24);
        p1.add(profile);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("video.png"));
        Image i8 = i7.getImage().getScaledInstance(28,28,Image.SCALE_DEFAULT);
        ImageIcon i9 =new ImageIcon(i8);
        JLabel video = new JLabel(i9);
        video.setBounds(300,20,28,28);
        p1.add(video);

        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("phone.png"));
        Image i11 = i10.getImage().getScaledInstance(24,24,Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel phone = new JLabel(i12);
        phone.setBounds(360,20,36,24);
        p1.add(phone);

        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("menu.png"));
        Image i14 = i13.getImage().getScaledInstance(36,36,Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel menu = new JLabel(i15);
        phone.setBounds(420,20,36,36);
        p1.add(menu);

        JLabel name = new JLabel("Friend");
        name.setBounds(110,15,100,18);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SAN_SERIF", Font.BOLD,18));
        p1.add(name);

        JLabel status = new JLabel("Active");
        status.setBounds(110, 35,100,18);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN_SERIF", Font.BOLD,14));
        p1.add(status);

        a1 = new JPanel();
        a1.setBounds(5,75,440,500);
        f.add(a1);

        text = new JTextField();
        text.setBounds(5,575,310,40);
        text.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        f.add(text);

        JButton send = new JButton("Send");
        send.setBounds(320,575,123,40);
        send.setBackground(new Color(37,147,211));
        send.setForeground(Color.WHITE);
        send.addActionListener(this);
        send.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        f.add(send);

        f.setSize(450,700);
        f.setLocation(200,50);
        f.setUndecorated(true);
        f.getContentPane().setBackground(Color.WHITE);
        f.setVisible(true);
    }
}