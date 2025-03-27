package code.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class frm_main extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu menuUser, menuRoom, menuBooking;
    private JMenuItem menuItemManageUsers, menuItemManageRooms, menuItemManageBookings;
    
    public frm_main() {
        setTitle("Hotel Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        initMenu();
    }
    
    private void initMenu() {
        menuBar = new JMenuBar();
        
        menuUser = new JMenu("User Management");
        menuItemManageUsers = new JMenuItem("Manage Users");
        menuItemManageUsers.addActionListener(this);
        menuUser.add(menuItemManageUsers);
        
        menuRoom = new JMenu("Room Management");
        menuItemManageRooms = new JMenuItem("Manage Rooms");
        menuItemManageRooms.addActionListener(this);
        menuRoom.add(menuItemManageRooms);
        
        menuBooking = new JMenu("Booking Management");
        menuItemManageBookings = new JMenuItem("Manage Bookings");
        menuItemManageBookings.addActionListener(this);
        menuBooking.add(menuItemManageBookings);
        
        menuBar.add(menuUser);
        menuBar.add(menuRoom);
        menuBar.add(menuBooking);
        
        setJMenuBar(menuBar);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuItemManageUsers) {
            frm_USER userFrame = new frm_USER();
            userFrame.setVisible(true);
        } else if (e.getSource() == menuItemManageRooms) {
            // Open room management form
        } else if (e.getSource() == menuItemManageBookings) {
            // Open booking management form
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new frm_main().setVisible(true);
        });
    }
}
