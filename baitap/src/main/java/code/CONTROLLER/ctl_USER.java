package code.CONTROLLER;

import java.util.Vector;
import code.GUI.frm_USER;

import code.MODEL.USER;
import code.MODEL.USERS;

public class ctl_USER {
    
    frm_USER guiUser;
    USERS pdUser;
    
    public ctl_USER(frm_USER user) {
        guiUser = user;
        pdUser = new USERS();
        LoadUsers();
    }
    
    public void LoadUsers() {
        Vector<USER> vector = new Vector<>(this.pdUser.getLISTUSER().values());
        tb_USER modelUser = new tb_USER(vector);
        guiUser.tblUser.setModel(modelUser);
    }
    
    public int InsertUser() {
        USER user = new USER();
        user.setName(guiUser.txtName.getText());
        user.setPhone(guiUser.txtPhone.getText());
        user.setEmail(guiUser.txtEmail.getText());
        user.setPassword(guiUser.txtPassword.getText());
        user.setroleId(guiUser.cobRole.getSelectedItem().toString());
        int k = this.pdUser.AddUser(user);
        return k;
    }
    
    public int UpdateUser() {
        USER user = new USER();
        user.setUserId(guiUser.txtUserId.getText());
        user.setName(guiUser.txtName.getText());
        user.setPhone(guiUser.txtPhone.getText());
        user.setEmail(guiUser.txtEmail.getText());
        user.setPassword(guiUser.txtPassword.getText());
        user.setroleId(guiUser.cobRole.getSelectedItem().toString());
        int k = this.pdUser.UpdateUser(user);
        return k;
    }
    
    public int DeleteUser() {
        int k = this.pdUser.DeleteUser(guiUser.txtUserId.getText());
        return k;
    }
}
