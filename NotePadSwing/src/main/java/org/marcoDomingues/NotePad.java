package org.marcoDomingues;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;

public class NotePad extends JFrame implements ActionListener, WindowListener {

    JTextArea jta = new JTextArea();
    File fnameContainer;

    public NotePad() {

        Font fnt = new Font("Arial", Font.PLAIN, 14);
        Container con = getContentPane();

        JMenuBar jmb = new JMenuBar();
        JMenu jmfile = new JMenu("File");
        JMenu jmedit = new JMenu("Edit");
        JMenu jmhelp = new JMenu("Help");

        con.setLayout(new BorderLayout());
        //adding scroll bar
        JScrollPane sbrText = new JScrollPane(jta);
        sbrText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sbrText.setVisible(true);

        jta.setFont(fnt);
        jta.setLineWrap(true);
        jta.setWrapStyleWord(true);

        con.add(sbrText);

        createMenuItem(jmfile, "New");
        createMenuItem(jmfile, "Open");
        createMenuItem(jmfile, "Save");
        jmfile.addSeparator();
        createMenuItem(jmfile, "Exit");

        createMenuItem(jmfile, "Cut");
        createMenuItem(jmfile, "Copy");
        createMenuItem(jmfile, "Paste");

        createMenuItem(jmfile, "About Notepad");

        jmb.add(jmfile);
        jmb.add(jmedit);
        jmb.add(jmhelp);

        setJMenuBar(jmb);
        setIconImage(Toolkit.getDefaultToolkit().getImage("notepad.gif"));
        addWindowListener(this);
        setSize(500, 500);
        setTitle("Untitled.txt - Notepad");

        setVisible(true);
    }

    public void createMenuItem(JMenu jm, String txt) {
        JMenuItem jmi = new JMenuItem(txt);
        jmi.addActionListener(this);
        jm.add(jmi);
    }

    public void actionPerformed(ActionEvent event) {
        JFileChooser jfc = new JFileChooser();

        if (event.getActionCommand().equals("New")) {
            //creating new file
            this.setTitle("Untitled.txt - Notepad");
            jta.setText("");
            fnameContainer = null;
        } else if (event.getActionCommand().equals("Open")) {
            //open file
            int ret = jfc.showDialog(null, "Open");

            if (ret == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = jfc.getSelectedFile();
                    OpenFile(file.getAbsolutePath());
                    this.setTitle(file.getname() + " - Notepad");
                    fnameContainer = file;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (event.getActionCommand().equals("Save")) {
                //save file
                if (fnameContainer != null) {
                    jfc.setCurrentDirectory(fnameContainer);
                    jfc.setSelectedFile(fnameContainer);
                } else {
                    jfc.setSelectedFile(new File("Untitled.txt"));
                }
            }
            int ret = jfc.showDialog(null);

            if (ret == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = jfc.getSelectedFile();
                    SaveFile(file.getAbsolutePath());
                    this.setTitle(file.getName() + " - Notepad");
                    fnameContainer = file;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (event.getActionCommand().equals("Exit")) {
                //exit
                Exiting();
            } else if (event.getActionCommand().equals("Copy")) {
                //copy
                jta.copy();
            } else if (event.getActionCommand().equals("Paste")) {
                //paste
                jta.paste();
            } else if (event.getActionCommand().equals("About Notepad")) {
                //about
                JOptionPane.showMessageDialog(this, "Created by: Marco Domingues", "Noteapad", JOptionPane.INFORMATION_MESSAGE);
            } else if (event.getActionCommand().equals("Cut")) {
                jta.cut();
            }
        }
    }

    public void OpenFile(String fname) throw

    IOException {
        //open file code here
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fname)));
        String str;
        //clear the textbox
        jta.setText("");

        setCursor(new Cursor(Cursor.WAIT_CURSOR));

        while ((str = d.readLine)) !=null){
            jta.setText(jta.getText() + str + "\r\n");
        }

        setCursor((new Cursor(Cursor.DEFAULT_CURSOR)));
        d.close();
    }

    public void SaveFile(String fname) throws IOException {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        DataOutputStream dos = new DataOutputStream(new FilterOutputStream(fname));
        o.writeBytes(jta.getText());
        o.close();
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    public void windowDeactivated(WindowEvent we){};
    public void windowActivated(WindowEvent we){}
    public void windowDeiconified(WindowEvent we){}
    public void windowIconified(WindowEvent we){}
    public void windowClosed(WindowEvent we){}

    public void windowClosing(WindowEvent we) {
        Exiting();
    }

    public void windowOpened(WindowEvent we){}

    public void Exiting() {
        System.exit(0);
    }



}
