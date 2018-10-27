package com.gagandeep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStudent extends JFrame implements ActionListener {


    JButton deleteButton, backButton;
    JLabel labelRollNo;
    JTextField textFiledRollNo;


    DeleteStudent() {
        setLayout(null);
        setLayout(new BorderLayout());
        JLabel background = new JLabel();
        labelRollNo = new JLabel("Roll No");
        textFiledRollNo = new JTextField(30);
        deleteButton = new JButton("Delete");
        backButton = new JButton("Back");
        add(background);

        background.add(labelRollNo);
        background.add(textFiledRollNo);
        background.add(deleteButton);
        background.add(backButton);

        setSize(860, 480);
        setTitle("Delete Page");
        setVisible(true);
        backButton.setForeground(Color.BLACK);
        labelRollNo.setBackground(Color.MAGENTA);
        deleteButton.setBackground(Color.GREEN);
        backButton.setBackground(Color.RED);

        labelRollNo.setBounds(450, 200, 200, 30);
        textFiledRollNo.setBounds(600, 200, 200, 30);
        deleteButton.setBounds(450, 375, 150, 30);
        backButton.setBounds(650, 375, 150, 30);

        deleteButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backButton) {
            Main oo =new Main();
            oo.setVisible(true);
            this.dispose();
        } else if (ae.getSource() == deleteButton) {


                Connection con = DB.getConnection();
        try {

           String rollNoString =  textFiledRollNo.getText();
             int  rollNo = Integer.parseInt(rollNoString);

        PreparedStatement ps = con.prepareStatement("delete from Student where rollNo = ?");
        ps.setInt(1, rollNo);

            if(ps.executeUpdate() ==1 ){

                JOptionPane.showMessageDialog(this,"Data Deleted Successfully","Success",JOptionPane.PLAIN_MESSAGE);
                Main oo =new Main();
                oo.setVisible(true);
                this.dispose();
            }
            else {
                textFiledRollNo.setText("");
                JOptionPane.showMessageDialog(this,"Incorrect data entered","Failed",JOptionPane.PLAIN_MESSAGE);
            }
        con.close();
    } catch (
    SQLException e) {
            textFiledRollNo.setText("");
            JOptionPane.showMessageDialog(this,"Incorrect data entered","Failed",JOptionPane.PLAIN_MESSAGE);

            e.printStackTrace();
    }


        }
        }



}
