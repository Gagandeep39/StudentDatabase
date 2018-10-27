package com.gagandeep;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

public class AddStudent  extends JFrame implements ActionListener  {
    JTextField textFiledRollNo, textFieldMarks ,textFieldName;
    JLabel labelRollNo, labelName, labelMarks;
    JButton saveButton, backButton;

    static Socket cs;
    static DataOutputStream dout;
    static DataInputStream din;
    static Student st = null;
    static ObjectOutputStream oout;
    static ObjectInputStream oin;
    static ArrayList<Student> al = null;
    int studentRollNo;
    String studentName;
    double studentMarks;


    public static void main(String[] args) {

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backButton) {Main oo =new Main();
            oo.setVisible(true);
            this.dispose();
        } else if (ae.getSource() == saveButton) {

            Connection con = DB.getConnection();
            try {
                studentRollNo = Integer.parseInt(textFiledRollNo.getText());
                studentName = textFieldName.getText();
                studentMarks = Integer.parseInt(textFieldMarks.getText());
                PreparedStatement ps = con.prepareStatement("insert into Student(rollNo, name, marks) values(?,?,?)");
                ps.setInt(1, studentRollNo);
                ps.setString(2, studentName);
                ps.setDouble(3, studentMarks);



                if(ps.executeUpdate() ==1 ){

                    JOptionPane.showMessageDialog(this,"Data Inserted","Success",JOptionPane.PLAIN_MESSAGE);
                    Main oo =new Main();
                    oo.setVisible(true);
                    this.dispose();
                }
                else {
                    textFieldMarks.setText("");
                    textFieldName.setText("");
                    textFiledRollNo.setText("");
                    JOptionPane.showMessageDialog(this,"Incorrect data entered","Failed",JOptionPane.PLAIN_MESSAGE);
                }
            }
            catch(Exception l)
            {   textFieldMarks.setText("");
                textFieldName.setText("");
                textFiledRollNo.setText("");
                JOptionPane.showMessageDialog(this,"Incorrect data entered","Failed",JOptionPane.PLAIN_MESSAGE);

                System.out.println("Exception:"+l);
            }





        }
    }

    AddStudent() {
        setLayout(null);
        setLayout(new BorderLayout());
        JLabel background = new JLabel();
        labelRollNo = new JLabel("Roll No");
        labelName = new JLabel("Name");
        textFiledRollNo = new JTextField(30);
        textFieldMarks = new JTextField(30);
        labelMarks = new JLabel("Marks");
        textFieldName = new JTextField(30);
        saveButton = new JButton("Save");
        backButton = new JButton("Back");
        add(background);

        background.add(labelRollNo);
        background.add(textFiledRollNo);
        background.add(labelName);
        background.add(textFieldMarks);
        background.add(labelMarks);
        background.add(textFieldName);
        background.add(saveButton);
        background.add(backButton);

        setSize(860, 480);
        setTitle("Add Student");
        setVisible(true);

        backButton.setForeground(Color.BLACK);

        labelName.setBackground(Color.BLACK);
        labelRollNo.setBackground(Color.MAGENTA);
        saveButton.setBackground(Color.GREEN);
        backButton.setBackground(Color.RED);

        labelRollNo.setBounds(450, 200, 200, 30);
        textFiledRollNo.setBounds(600, 200, 200, 30);
        labelName.setBounds(450, 250, 200, 30);
        textFieldName.setBounds(600, 250, 200, 30);
        labelMarks.setBounds(450, 300, 200, 30);
        textFieldMarks.setBounds(600, 300, 200, 30);
        saveButton.setBounds(450, 375, 150, 30);
        backButton.setBounds(650, 375, 150, 30);

        saveButton.addActionListener(this);
        backButton.addActionListener(this);

    }


}
