package gui;


import main.Application;
import main.Employee;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ShowSearchDialog extends JDialog {
    private Application application;

    public ShowSearchDialog() {
        setTitle("Show/Search Operation");
        setModalityType(ModalityType.APPLICATION_MODAL);
        setSize(690, 550);
        setLocationRelativeTo(null);
        setResizable(false);



        JPanel panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(null);

        JLabel lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setBounds(20, 30, 150, 16);
        lastNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JTextField lastNameTextField = new JTextField();
        lastNameTextField.setBounds(110, 25, 150, 30);
        JButton searchButton = new JButton("Search");
        searchButton.setBounds(260, 25, 100, 30);
        JButton showButton = new JButton("Show All");
        showButton.setBounds(380, 25,100, 30);
        JButton closeButton = new JButton("Close");
        closeButton.setBounds(580, 25,100, 30);
        JTable employeesTable = new JTable();
        employeesTable.setBounds(20, 100, 650, 400);
        panel.add(lastNameLabel);
        panel.add(lastNameTextField);
        panel.add(searchButton);
        panel.add(showButton);
        panel.add(closeButton);
        panel.add(employeesTable);



        try {
            application = new Application();
        } catch (Exception e) {
            e.printStackTrace();
        }


        searchButton.addActionListener(actionEvent -> {
            try {
                String lastName = lastNameTextField.getText();

                List<Employee> employees = null;

                if(lastName != null && lastName.trim().length() > 0) {
                    employees = application.searchEmployees(lastName);

                } else {
                    JOptionPane.showMessageDialog(panel, "You must enter the last name first.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                TableModel tableModel = new TableModel(employees);
                employeesTable.setModel(tableModel);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        showButton.addActionListener(actionEvent -> {

            try {
                List<Employee> employees;
                employees = application.getAllEmployees();

                TableModel tableModel = new TableModel(employees);
                employeesTable.setModel(tableModel);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

         closeButton.addActionListener(actionEvent -> setVisible(false));

        setVisible(true);
    }
}
