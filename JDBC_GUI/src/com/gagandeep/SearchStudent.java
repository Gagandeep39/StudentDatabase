package com.gagandeep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchStudent extends JFrame implements ActionListener {
    JButton searchButton, backButton;
    JLabel labelRollNo;
    JTextField textFiledRollNo;

    SearchStudent(){
        setLayout(null);
        setLayout(new BorderLayout());
        JLabel background = new JLabel();
        labelRollNo = new JLabel("Roll No");
        textFiledRollNo = new JTextField(30);
        searchButton = new JButton("Search");
        backButton = new JButton("Back");
        add(background);

        background.add(labelRollNo);
        background.add(textFiledRollNo);
        background.add(searchButton);
        background.add(backButton);

        setSize(860, 480);
        setTitle("Search Student");
        setVisible(true);
        backButton.setForeground(Color.BLACK);
        labelRollNo.setBackground(Color.MAGENTA);
        searchButton.setBackground(Color.GREEN);
        backButton.setBackground(Color.RED);

        labelRollNo.setBounds(450, 200, 200, 30);
        textFiledRollNo.setBounds(600, 200, 200, 30);
        searchButton.setBounds(450, 375, 150, 30);
        backButton.setBounds(650, 375, 150, 30);

        searchButton.addActionListener(this);
        backButton.addActionListener(this);
    }




    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backButton) {
            Main oo =new Main();
            oo.setVisible(true);
            this.dispose();
        } else if (ae.getSource() == searchButton) {
            String rollNoString =  textFiledRollNo.getText();
            int  rollNo = Integer.parseInt(rollNoString);
                SearchResult oo =new SearchResult(rollNo);
                oo.setVisible(true);
                this.dispose();


        }
    }
}
