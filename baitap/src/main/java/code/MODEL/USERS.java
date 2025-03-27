package code.MODEL;

import code.DBCONNECTION.*;

import java.sql.*;
import java.util.HashMap;

public class USERS {
    private HashMap<String, USER> LISTUSER;
    private dbCONNECTION conn;

    public USERS() {
        LISTUSER = new HashMap<>();
        conn = new dbCONNECTION();
        // conn.GetConnection();
    }


    public void setLISTUSER(HashMap<String, USER> lISTUSER) {
        LISTUSER = lISTUSER;
    }

    public HashMap<String, USER> getLISTUSER() {
        try {
            LISTUSER.clear();
            String SQL = "SELECT * FROM [USER]";

            ResultSet rs = conn.GetResultSetSQL(SQL);
            
            while (rs.next()) {
                USER user = new USER(
                    rs.getString("user_id"),
                    rs.getString("name"),
                    rs.getString("phone"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("role_id")
                );
                LISTUSER.put(user.getUserId(), user);
                System.out.println("User loaded: " + user.getName());
            }
            System.out.println("Suuu");
        } catch (Exception ex) {
            System.out.println("Error fetching users: " + ex.getMessage());
        }
        return LISTUSER;
    }

    public int AddUser(USER user) {
        String SQL = "INSERT INTO USER (user_id, name, phone, email, password, role_id) VALUES ('"
                + user.getUserId() + "', '"
                + user.getName() + "', '"
                + user.getPhone() + "', '"
                + user.getEmail() + "', '"
                + user.getPassword() + "', '"
                + user.getroleId() + "')";
        return conn.ExecuteUpdateSQL(SQL);
    }

    public int DeleteUser(String userId) {
        String SQL = "DELETE FROM USER WHERE userId='" + userId + "'";
        return conn.ExecuteUpdateSQL(SQL);
    }

    public int UpdateUser(USER user) {
        String SQL = "UPDATE USER SET name='" + user.getName() + "', phone='" + user.getPhone()
                + "', email='" + user.getEmail() + "', password='" + user.getPassword()
                + "', role_id='" + user.getroleId() + "' WHERE user_id='" + user.getUserId() + "'";
        return conn.ExecuteUpdateSQL(SQL);
    }

    public static void main(String[] args) {
        USERS users = new USERS();
        users.getLISTUSER();
    }

}
