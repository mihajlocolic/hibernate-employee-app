package gui;


import main.Application;
import main.Employee;
import main.HibernateUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EmployeeUpdateForm extends JDialog {

    JTextField firstNameTextField;
    JTextField lastNameTextField;
    JTextField yearsTextField;
    JTextField addressTextField;
    JTextField salaryTextField;

    Application app;

    private int employeeId;
    public EmployeeUpdateForm() {
        setModal(true);
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("Employee Update Form");
        setSize(400, 450);
        setResizable(false);
        setLocationRelativeTo(null);


        JLabel firstNameLabel = new JLabel("First Name");
        firstNameLabel.setBounds(30, 50, 100, 16);
        firstNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        contentPane.add(firstNameLabel);

        firstNameTextField = new JTextField();
        firstNameTextField.setEditable(true);
        firstNameTextField.setBounds(120, 50, 200, 20);
        contentPane.add(firstNameTextField);

        JLabel lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setBounds(30, 100, 100, 16);
        lastNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        contentPane.add(lastNameLabel);

        lastNameTextField = new JTextField();
        lastNameTextField.setEditable(true);
        lastNameTextField.setBounds(120, 100, 200, 20);
        contentPane.add(lastNameTextField);

        JLabel yearsLabel = new JLabel("Years");
        yearsLabel.setBounds(30, 150, 100, 16);
        yearsLabel.setFont(new Font("Arial", Font.BOLD, 16));
        contentPane.add(yearsLabel);

        yearsTextField = new JTextField();
        yearsTextField.setEditable(true);
        yearsTextField.setBounds(120, 150, 200, 20);
        contentPane.add(yearsTextField);

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(30, 200, 100, 16);
        addressLabel.setFont(new Font("Arial", Font.BOLD, 16));
        contentPane.add(addressLabel);

        addressTextField = new JTextField();
        addressTextField.setEditable(true);
        addressTextField.setBounds(120, 200, 200, 20);
        contentPane.add(addressTextField);

        JLabel salaryLabel = new JLabel("Salary");
        salaryLabel.setBounds(30, 250, 100, 16);
        salaryLabel.setFont(new Font("Arial", Font.BOLD, 16));
        contentPane.add(salaryLabel);

        salaryTextField = new JTextField();
        salaryTextField.setEditable(true);
        salaryTextField.setBounds(120, 250, 200, 20);
        contentPane.add(salaryTextField);

        JButton buttonUpdate = new JButton("Update");
        buttonUpdate.setBounds(60, 320, 100, 25);
        contentPane.add(buttonUpdate);

        JButton buttonCancel = new JButton("Cancel");
        buttonCancel.setBounds(230, 320, 100, 25);
        contentPane.add(buttonCancel);

        try {
            app = new Application();
        } catch (Exception e) {
            e.printStackTrace();
        }

        yearsTextField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });

        salaryTextField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });


        buttonUpdate.addActionListener(actionEvent -> {
            String firstName = firstNameTextField.getText();
            String lastName = lastNameTextField.getText();
            String years = yearsTextField.getText();
            String address = addressTextField.getText();
            String salary = salaryTextField.getText();


            if(firstName.isEmpty() || lastName.isEmpty() || address.isEmpty() || years.isEmpty() || salary.isEmpty()) {
                JOptionPane.showMessageDialog(contentPane, "All fields must be filled.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    app.updateEmployee(employeeId, firstName, lastName, Integer.parseInt(years), address, Integer.parseInt(salary));
                    JOptionPane.showMessageDialog(contentPane, "Employee updated.", " ", JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }



        });

        buttonCancel.addActionListener(actionEvent -> {
            setVisible(false);
            HibernateUtil.close();
        });
    }

    public void getEmployeeData(Employee employee) {
        employeeId = employee.getId();
        firstNameTextField.setText(employee.getFirstName());
        lastNameTextField.setText(employee.getLastName());
        yearsTextField.setText(String.valueOf(employee.getYears()));
        addressTextField.setText(employee.getAddress());
        salaryTextField.setText(String.valueOf(employee.getSalary()));
        System.out.println("Debugging getEmployeeData: " + employee);

        setVisible(true);

    }
}
