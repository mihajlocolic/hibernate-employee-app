package gui;

import main.Employee;
import main.Application;

import javax.swing.*;
import java.awt.*;

public class AddDialog extends JDialog {

    private Application application;
    public AddDialog() {
        setModal(true);
        setTitle("Add Employee");
        setSize(400, 450);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel firstNameLabel = new JLabel("First Name");
        firstNameLabel.setBounds(30, 50, 100, 16);
        firstNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        contentPane.add(firstNameLabel);

        JTextField firstNameTextField = new JTextField();
        firstNameTextField.setBounds(120, 50, 200, 20);
        contentPane.add(firstNameTextField);

        JLabel lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setBounds(30, 100, 100, 16);
        lastNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        contentPane.add(lastNameLabel);

        JTextField lastNameTextField = new JTextField();
        lastNameTextField.setBounds(120, 100, 200, 20);
        contentPane.add(lastNameTextField);

        JLabel yearsLabel = new JLabel("Years");
        yearsLabel.setBounds(30, 150, 100, 16);
        yearsLabel.setFont(new Font("Arial", Font.BOLD, 16));
        contentPane.add(yearsLabel);

        JTextField yearsTextField = new JTextField();
        yearsTextField.setBounds(120, 150, 200, 20);
        contentPane.add(yearsTextField);

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(30, 200, 100, 16);
        addressLabel.setFont(new Font("Arial", Font.BOLD, 16));
        contentPane.add(addressLabel);

        JTextField addressTextField = new JTextField();
        addressTextField.setBounds(120, 200, 200, 20);
        contentPane.add(addressTextField);

        JLabel salaryLabel = new JLabel("Salary");
        salaryLabel.setBounds(30, 250, 100, 16);
        salaryLabel.setFont(new Font("Arial", Font.BOLD, 16));
        contentPane.add(salaryLabel);

        JTextField salaryTextField = new JTextField();
        salaryTextField.setBounds(120, 250, 200, 20);
        contentPane.add(salaryTextField);

        JButton buttonAdd = new JButton("Add");
        buttonAdd.setBounds(60, 320, 100, 25);
        contentPane.add(buttonAdd);

        JButton buttonCancel = new JButton("Cancel");
        buttonCancel.setBounds(230, 320, 100, 25);
        contentPane.add(buttonCancel);

        try {
            application = new Application();
        } catch (Exception e) {
            e.printStackTrace();
        }

        buttonAdd.addActionListener(ActionEvent -> {

            String firstName = firstNameTextField.getText();
            String lastName = lastNameTextField.getText();
            String years = yearsTextField.getText();
            String address = addressTextField.getText();
            String salary = salaryTextField.getText();

            if(firstName.isBlank() || lastName.isBlank() || years.isBlank()|| address.isBlank() || salary.isBlank()) {
                JOptionPane.showMessageDialog(contentPane, "You need to fill all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {

                try {
                    Employee employee = new Employee(firstName, lastName, Integer.parseInt(years), address, Integer.parseInt(salary));
                    application.addEmployee(employee);
                    JOptionPane.showMessageDialog(contentPane, "New employee successfully added.", "Employee added", JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }


            }

        });

        buttonCancel.addActionListener(ActionEvent -> {
            setVisible(false);
            System.out.println("Add dialog closed.");
        });


        setVisible(true);
    }
}
