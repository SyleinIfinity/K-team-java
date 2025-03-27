package code.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import code.MODEL.USER;
import code.CONTROLLER.ctl_USER;

public class frm_USER extends JInternalFrame implements ActionListener {
    private JLabel lblUserId, lblName, lblPhone, lblEmail, lblPassword, lblRole;
    public JTextField txtUserId, txtName, txtPhone, txtEmail, txtPassword;
    public JComboBox<String> cobRole;
    public JButton btnAdd, btnDelete, btnUpdate, btnClose;
    public JTable tblUser;
    public JScrollPane jScrollPaneUser;
    private ctl_USER bluser;

    public frm_USER() {
        super("Quản lý người dùng", true, true, true, true);
        setLayout(null);
        setSize(700, 500);
        initComponents();
        bluser = new ctl_USER(this);
    }

    public void initComponents() {
        lblUserId = new JLabel("User ID:");
        lblUserId.setBounds(30, 50, 100, 30);
        add(lblUserId);
        txtUserId = new JTextField();
        txtUserId.setBounds(140, 50, 200, 30);
        add(txtUserId);
        
        lblName = new JLabel("Tên:");
        lblName.setBounds(30, 90, 100, 30);
        add(lblName);
        txtName = new JTextField();
        txtName.setBounds(140, 90, 200, 30);
        add(txtName);
        
        lblPhone = new JLabel("SĐT:");
        lblPhone.setBounds(350, 50, 100, 30);
        add(lblPhone);
        txtPhone = new JTextField();
        txtPhone.setBounds(450, 50, 200, 30);
        add(txtPhone);
        
        lblEmail = new JLabel("Email:");
        lblEmail.setBounds(350, 90, 100, 30);
        add(lblEmail);
        txtEmail = new JTextField();
        txtEmail.setBounds(450, 90, 200, 30);
        add(txtEmail);
        
        lblPassword = new JLabel("Mật khẩu:");
        lblPassword.setBounds(30, 130, 100, 30);
        add(lblPassword);
        txtPassword = new JTextField();
        txtPassword.setBounds(140, 130, 200, 30);
        add(txtPassword);
        
        lblRole = new JLabel("Vai trò:");
        lblRole.setBounds(350, 130, 100, 30);
        add(lblRole);
        cobRole = new JComboBox<>(new String[]{"Khách hàng", "Nhân viên", "Admin"});
        cobRole.setBounds(450, 130, 200, 30);
        add(cobRole);
        
        btnAdd = new JButton("Thêm");
        btnAdd.setBounds(50, 180, 100, 30);
        btnAdd.addActionListener(this);
        add(btnAdd);
        
        btnDelete = new JButton("Xóa");
        btnDelete.setBounds(170, 180, 100, 30);
        btnDelete.addActionListener(this);
        add(btnDelete);
        
        btnUpdate = new JButton("Sửa");
        btnUpdate.setBounds(290, 180, 100, 30);
        btnUpdate.addActionListener(this);
        add(btnUpdate);
        
        btnClose = new JButton("Đóng");
        btnClose.setBounds(400, 180, 100, 30);
        btnClose.addActionListener(this);
        add(btnClose);
        
        tblUser = new JTable();
        tblUser.setBounds(60, 230, 600, 200);
        tblUser.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tblUserMouseClicked(evt);
            }
        });
        
        jScrollPaneUser = new JScrollPane();
        jScrollPaneUser.setViewportView(tblUser);
        jScrollPaneUser.setBounds(60, 230, 600, 200);
        add(jScrollPaneUser);
    }
    
    private void tblUserMouseClicked(MouseEvent evt) {
        if (tblUser.getSelectedRow() >= 0) {
            txtUserId.setText(tblUser.getValueAt(tblUser.getSelectedRow(), 0).toString());
            txtName.setText(tblUser.getValueAt(tblUser.getSelectedRow(), 1).toString());
            txtPhone.setText(tblUser.getValueAt(tblUser.getSelectedRow(), 2).toString());
            txtEmail.setText(tblUser.getValueAt(tblUser.getSelectedRow(), 3).toString());
            txtPassword.setText(tblUser.getValueAt(tblUser.getSelectedRow(), 4).toString());
            cobRole.setSelectedItem(tblUser.getValueAt(tblUser.getSelectedRow(), 5).toString());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == btnAdd) {
            bluser.InsertUser();
            bluser.LoadUsers();
        }
        if (ev.getSource() == btnUpdate) {
            bluser.UpdateUser();
            bluser.LoadUsers();
        }
        if (ev.getSource() == btnDelete) {
            int result = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa thông tin này không?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                bluser.DeleteUser();
                JOptionPane.showMessageDialog(this, "Thông tin đã được xóa");
                bluser.LoadUsers();
            }
        }
        if (ev.getSource() == btnClose) {
            dispose();
        }
    }
}
