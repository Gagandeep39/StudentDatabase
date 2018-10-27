package com.gagandeep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FailedStudent extends JFrame implements ActionListener {
    JButton searchButton, backButton;
    JLabel labelFailMarks;
    JTextField textFieldFailMarks;

    FailedStudent(){
        setLayout(null);
        setLayout(new BorderLayout());
        JLabel background = new JLabel();
        labelFailMarks = new JLabel("Minimum Passing Marks");
        textFieldFailMarks = new JTextField(30);
        searchButton = new JButton("Search");
        backButton = new JButton("Back");
        add(background);

        background.add(labelFailMarks);
        background.add(textFieldFailMarks);
        background.add(searchButton);
        background.add(backButton);

        setSize(860, 480);
        setTitle("Search Student");
        setVisible(true);
        backButton.setForeground(Color.BLACK);
        labelFailMarks.setBackground(Color.MAGENTA);
        searchButton.setBackground(Color.GREEN);
        backButton.setBackground(Color.RED);

        labelFailMarks.setBounds(450, 200, 200, 30);
        textFieldFailMarks.setBounds(600, 200, 200, 30);
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
            String failMarksString =  textFieldFailMarks.getText();
            int  failMarksInt = Integer.parseInt(failMarksString);
            FailedResult oo =new FailedResult(failMarksInt);
            oo.setVisible(true);
            this.dispose();


        }

    }
}
