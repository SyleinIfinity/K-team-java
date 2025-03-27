package code.CONTROLLER;

import javax.swing.table.AbstractTableModel;
import code.MODEL.USER;
import java.util.List;

/**
 * Table model for displaying user data in a JTable.
 * @author AD
 */
public class tb_USER extends AbstractTableModel {
    
    private List<USER> data;
    private String[] colNames = {"User ID", "Name", "Phone", "Email", "Role"};
    private Class<?>[] colClasses = {String.class, String.class, String.class, String.class, String.class};
    
    public tb_USER(List<USER> list) {
        this.data = list;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        USER user = data.get(rowIndex);
        switch (columnIndex) {
            case 0: return user.getUserId();
            case 1: return user.getName();
            case 2: return user.getPhone();
            case 3: return user.getEmail();
            case 4: return user.getroleId();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return colClasses[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
