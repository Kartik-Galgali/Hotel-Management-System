package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Reception extends JFrame implements ActionListener {
    
    JButton newcustomer,rooms, department, allemployees, managerinfo, customerinfo, checkout, updatestat, updateroom, pickupservice, searchroom, logout;

    Reception() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        newcustomer = new JButton("New Customer Form");
        newcustomer.setBounds(10, 30, 200, 30);
        newcustomer.setBackground(Color.BLACK);
        newcustomer.setForeground(Color.WHITE);
        newcustomer.addActionListener(this);
        add(newcustomer);
        
        rooms = new JButton("Rooms");
        rooms.setBounds(10, 70, 200, 30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);
        
        department = new JButton("Department");
        department.setBounds(10, 110, 200, 30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department);
        
        allemployees = new JButton("All Employees");
        allemployees.setBounds(10, 150, 200, 30);
        allemployees.setBackground(Color.BLACK);
        allemployees.setForeground(Color.WHITE);
        allemployees.addActionListener(this);
        add(allemployees);
        
        customerinfo = new JButton("Customer Info");
        customerinfo.setBounds(10, 190, 200, 30);
        customerinfo.setBackground(Color.BLACK);
        customerinfo.setForeground(Color.WHITE);
        customerinfo.addActionListener(this);
        add(customerinfo);
        
        managerinfo = new JButton("Manager Info");
        managerinfo.setBounds(10, 230, 200, 30);
        managerinfo.setBackground(Color.BLACK);
        managerinfo.setForeground(Color.WHITE);
        managerinfo.addActionListener(this);
        add(managerinfo);
        
        checkout = new JButton("Checkout");
        checkout.setBounds(10, 270, 200, 30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);
        
        updatestat = new JButton("Update Status");
        updatestat.setBounds(10, 310, 200, 30);
        updatestat.setBackground(Color.BLACK);
        updatestat.setForeground(Color.WHITE);
        updatestat.addActionListener(this);
        add(updatestat);
        
        updateroom = new JButton("Update Room Status");
        updateroom.setBounds(10, 350, 200, 30);
        updateroom.setBackground(Color.BLACK);
        updateroom.setForeground(Color.WHITE);
        updateroom.addActionListener(this);
        add(updateroom);
        
        pickupservice = new JButton("Pickup Service");
        pickupservice.setBounds(10, 390, 200, 30);
        pickupservice.setBackground(Color.BLACK);
        pickupservice.setForeground(Color.WHITE);
        pickupservice.addActionListener(this);
        add(pickupservice);
        
        searchroom = new JButton("Search Room");
        searchroom.setBounds(10, 430, 200, 30);
        searchroom.setBackground(Color.BLACK);
        searchroom.setForeground(Color.WHITE);
        searchroom.addActionListener(this);
        add(searchroom);
        
        logout = new JButton("Logout");
        logout.setBounds(10, 470, 200, 30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250, 30, 500, 470);
        add(image);
        
        setBounds(350, 200, 800, 570);
        setVisible(true);
    } 
    
    public static void main(String[] args) {
        new Reception();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == newcustomer){
            setVisible(false);
            new AddCustomer();
        }
        else if(ae.getSource() == rooms){
            setVisible(false);
            new Room();
        }
        else if (ae.getSource() == department) {
            setVisible(false);
            new Department();
        }
        else if (ae.getSource() == allemployees) {
            setVisible(false);
            new EmployeeInfo();
        }
        else if (ae.getSource() == customerinfo) {
            setVisible(false);
            new CustomerInfo();
        }
        else if (ae.getSource() == managerinfo) {
            setVisible(false);
            new ManagerInfo();
        }
    }
}
