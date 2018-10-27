package com.gagandeep;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class FailedResult extends JFrame implements ActionListener {



    private JTable table;
    private JButton buttonBack;

    public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

    }
    String columns[] = {"rollNo", "name", "marks"};
    FailedResult(int failMarks){


        setLayout(null);
        setLayout(new BorderLayout());
        JLabel background = new JLabel();
        buttonBack = new JButton("Back");
        add(background);

        background.add(buttonBack);
        setSize(860, 480);
        setTitle("Failed Student List");
        setVisible(true);
        buttonBack.setBounds(650, 375, 150, 30);
        buttonBack.addActionListener(this);





        try{
            Connection cn = DB.getConnection();
            Statement smt = cn.createStatement();
            String failString = "select * from student where marks < " + failMarks;
            System.out.println(failString);
            ResultSet rs = smt.executeQuery(failString);

            JTable table = new JTable(buildTableModel(rs));

            add(table);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == buttonBack) {
            Main oo =new Main();
            oo.setVisible(true);
            this.dispose();
        }
    }
}
