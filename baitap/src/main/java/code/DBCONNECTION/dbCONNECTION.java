package code.DBCONNECTION;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbCONNECTION implements IConnector {
    private  String UserName;
    private  String PassWord ;
    private  String DataBaseName;
    private  String ServerName;
    private  String  DriverClass;
    private  String  DriverURL;
    private  Connection cnn=null;
    private   Statement stm=null;

    public dbCONNECTION()
    {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=quanlykhachsan;encrypt=true;trustServerCertificate=true";
            this.UserName = "sa";
            this.PassWord = "12345";
            this.DataBaseName = "quanlykhachsan";
            this.cnn = DriverManager.getConnection(url, this.UserName, this.PassWord);
            System.out.println("Connect Success!");
        } catch(Exception ex)
        {
            System.out.println("Error");
        }
    }

    @Override
    public void Open() {
            try{
                String url = "jdbc:sqlserver://localhost:1433;databaseName=quanlykhachsan;encrypt=true;trustServerCertificate=true";
                cnn = DriverManager.getConnection(url, this.UserName, this.PassWord);
                System.out.println("Connect Success!");
                stm = cnn.createStatement();  
                System.out.println("Connect Success!");
            }catch(Exception ex){}
    }

    public Connection GetConnection() {
        return this.cnn;
    }

    @Override
    public void Close() {
        try{
        this.stm.close();
        this.cnn.close();
        }catch(SQLException ex){}
    }

    @Override
    public ResultSet GetResultSetSQL(String sql) {
        ResultSet rs = null;
        try {
            if (cnn == null || cnn.isClosed()) {
                Open(); // Đảm bảo kết nối mở trước khi chạy truy vấn
            }
            Statement stmt = cnn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    

    @Override
    public ResultSet GetResultSetStoredProcedurce(String procedureName, Object[] param) {
        ResultSet rs = null;
    

        try {
            this.Open();
            CallableStatement  ps = this.cnn.prepareCall("{call "+procedureName+"}");
            if(param!=null)
            {
            int i = 1;
            for (Object value : param) {
                ps.setObject(i, value);
                i++;
            }
            }
            rs = ps.executeQuery();
            ps.close();
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public int ExecuteUpdateSQL(String SQL) {
        try {
            this.Open();
    int k=this.stm.executeUpdate(SQL);
    
    return  k;
        } catch (Exception e) {
        }
    return 0;
    }

    @Override
    public int ExecuteUpdateStoredProcedurce(String procedureName, Object[] param) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        dbCONNECTION conn = new dbCONNECTION();
        conn.Open();
    }

}
