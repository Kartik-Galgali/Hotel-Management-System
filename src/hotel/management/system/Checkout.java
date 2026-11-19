package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class Checkout extends JFrame implements ActionListener{

    JButton checkout, back;
    Choice ccustomer;
    JLabel lblroomnumber, lblcheckintime, lblcheckouttime;
    
   Checkout() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
       JLabel text = new JLabel("Checkout");
       text.setBounds(100, 20, 100, 30);
       text.setForeground(Color.blue);
       text.setFont(new Font("Tahoma", Font.PLAIN, 20));
       add(text);
       
       JLabel lblid = new JLabel("Customer Id");
       lblid.setBounds(30, 80, 100, 30);
       add(lblid);
       
        ccustomer = new Choice();
        ccustomer.setBounds(150, 80, 160, 30);
        add(ccustomer);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        i1 = new ImageIcon(i2);
        JLabel tick = new JLabel(i1);
        tick.setBounds(320, 80, 20, 20);
        add(tick);
        
       JLabel lblroom = new JLabel("Room Number");
       lblroom.setBounds(30, 130, 100, 30);
       add(lblroom);
       
       lblroomnumber = new JLabel();
       lblroomnumber.setBounds(150, 130, 160, 30);
       add(lblroomnumber);
       
       JLabel lblcheckin = new JLabel("Checkin Time");
       lblcheckin.setBounds(30, 180, 100, 30);
       add(lblcheckin);
       
       lblcheckintime = new JLabel();
       lblcheckintime.setBounds(150, 180, 160, 30);
       add(lblcheckintime);
       
       try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from customer");
            if (rs.next()) {
                ccustomer.add(rs.getString("number"));
                lblroomnumber.setText(rs.getString("roomno"));
                lblcheckintime.setText(rs.getString("checkin"));
            }
       } catch (Exception e) {
           e.printStackTrace();
       }
       
       JLabel lblcheckout = new JLabel("Checkout Time");
       lblcheckout.setBounds(30, 230, 100, 30);
       add(lblcheckout);
       
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd yyyy hh:mm:ss a");
        String dformat = sdf.format(date);
       
       lblcheckouttime = new JLabel(dformat);
       lblcheckouttime.setBounds(150, 230, 160, 30);
       add(lblcheckouttime);
       
        checkout = new JButton("Checkout");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.white);
        checkout.setBounds(30, 280, 120, 30);
        checkout.addActionListener(this);
        add(checkout);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(170, 280, 120, 30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i4 = i3.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        i3 = new ImageIcon(i4);
        JLabel image = new JLabel(i3);
        image.setBounds(360, 65, 400, 250);
        add(image);
        
        setBounds(300,200, 800, 400);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Checkout();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == checkout){
            String query1 = "delete from customer where number = '"+ccustomer.getSelectedItem()+"'";
            String query2 = "update room set availability = 'Available' where roomnumber = '"+lblroomnumber.getText()+"'";
            
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Checkout Done");
                
                setVisible(false);
                new Reception();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        
        }
        
        else if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }
}
