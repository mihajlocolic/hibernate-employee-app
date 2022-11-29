package gui;

import main.Employee;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableModel extends AbstractTableModel {

    private static final int idCol = 0;
    private static final int firstNameCol = 1;

    private static final int yearsCol = 3;
    private static final int addressCol = 4;
    private static final int salaryCol = 5;

    private final String[] columnNames = {"ID", "First Name", "Last Name", "Years", "Address", "Salary"};

    private final List<Employee> employees;

    public TableModel(List<Employee> employeesList) { employees = employeesList;}

    @Override
    public int getColumnCount() { return columnNames.length;}

    @Override
    public int getRowCount() { return employees.size();}

    @Override
    public String getColumnName(int col) { return columnNames[col];}

    @Override
    public Object getValueAt(int row, int col) {
        Employee tmp = employees.get(row);
        return switch (col) {
            case idCol -> tmp.getId();
            case firstNameCol -> tmp.getFirstName();
            case yearsCol -> tmp.getYears();
            case addressCol -> tmp.getAddress();
            case salaryCol -> tmp.getSalary();
            default -> tmp.getLastName();
        };
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
