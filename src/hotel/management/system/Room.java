package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener{

    JTable table;
    JButton back;
    
    Room() {
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        i1.getImage().getScaledInstance(600, 600,Image.SCALE_DEFAULT);
        JLabel image = new JLabel(i1);
        image.setBounds(500, 0, 600, 600);
        add(image);
        
        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(10, 10, 100, 20);
        add(l1);
        
        JLabel l2 = new JLabel("Availability");
        l2.setBounds(120, 10, 100, 20);
        add(l2);
        
        JLabel l3 = new JLabel("Status");
        l3.setBounds(230, 10, 80, 20);
        add(l3);
        
        JLabel l4 = new JLabel("Price");
        l4.setBounds(320, 10, 80, 20);
        add(l4);
        
        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(410, 10, 80, 20);
        add(l5);
        
        table = new JTable();
        table.setBounds(0, 40, 500, 400);
        add(table);
        
        try {
            Conn conn = new Conn();
            String query = "Select * from room order by roomnumber";
            ResultSet rs = conn.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBounds(180, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setBounds(300, 200, 1050, 600);
        setVisible(true);
    }  
    
    public static void main(String[] args) {
        new Room();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }
}
