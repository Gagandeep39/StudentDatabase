package com.gagandeep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    //GUI


    private JButton buttonAddStudent,buttonDeleteStudent,buttonSearchStudent,buttonFailedStudent,buttonDisplayStudent, buttonExit;

    public static void main(String[] args) {

    new Main();
    }



    Main(){

        setLayout(null);
        setLayout(new BorderLayout());
        JLabel background=new JLabel();
        buttonAddStudent=new JButton("Add Student");
        buttonDeleteStudent=new JButton("Delete Student");
        buttonSearchStudent=new JButton("Search Student");
        buttonFailedStudent=new JButton("Failed Student");
        buttonDisplayStudent=new JButton("Display Student");
        buttonExit = new JButton("Exit");


        Font myFont = new Font("Courier", Font.BOLD,15);
        buttonAddStudent.setFont(myFont);
        buttonDeleteStudent.setFont(myFont);
        buttonSearchStudent.setFont(myFont);
        buttonFailedStudent.setFont(myFont);
        buttonDisplayStudent.setFont(myFont);
        buttonExit.setFont(myFont);


        add(background);
        background.add(buttonAddStudent);
        background.add(buttonDeleteStudent);
        background.add(buttonFailedStudent);
        background.add(buttonDisplayStudent);
        background.add(buttonSearchStudent);
        background.add(buttonExit);

        buttonAddStudent.setForeground(Color.white);
        buttonDeleteStudent.setForeground(Color.BLACK);
        buttonSearchStudent.setForeground(Color.white);
        buttonFailedStudent.setForeground(Color.white);

        buttonAddStudent.setBackground(Color.GREEN);
        buttonDeleteStudent.setBackground(Color.yellow);
        buttonSearchStudent.setBackground(Color.RED);
        buttonFailedStudent.setBackground(Color.BLACK);
        buttonDisplayStudent.setBackground(Color.CYAN);
        setSize(860,480);
        setTitle("Home Page");
        setVisible(true);

        buttonAddStudent.setBounds(100,100,200,30);	//distance from y axis, xaxis, width, height
        buttonDeleteStudent.setBounds(400,100,200,30);
        buttonFailedStudent.setBounds(100,200,200,30);
        buttonDisplayStudent.setBounds(400,200,200,30);
        buttonSearchStudent.setBounds(100,300,200,30);
        buttonExit.setBounds(400,300,200,30);

        buttonAddStudent.addActionListener(this);
        buttonDeleteStudent.addActionListener(this);
        buttonSearchStudent.addActionListener(this);
        buttonFailedStudent.addActionListener(this);
        buttonDisplayStudent.addActionListener(this);
        buttonExit.addActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource()==buttonAddStudent)
        {
            AddStudent obj=new AddStudent();
            obj.setVisible(true);
            this.dispose();
        }

        if(ae.getSource()==buttonDeleteStudent)
        {
            DeleteStudent obj=new DeleteStudent();
            obj.setVisible(true);
            this.dispose();
        }

        if(ae.getSource()==buttonSearchStudent)
        {
            SearchStudent h=new SearchStudent();
            h.setVisible(true);
            this.dispose();
        }

        if(ae.getSource()==buttonFailedStudent)
        {
            FailedStudent f = new FailedStudent();
            f.setVisible(true);
            this.dispose();
        }
        if(ae.getSource()==buttonDisplayStudent)
        {
        DisplayStudent obj = new DisplayStudent();
        obj.setVisible(true);
            this.dispose();
        }

        if(ae.getSource()==buttonExit)
        {
            System.exit(0);
        }



    }

}
