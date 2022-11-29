package gui;

import main.Application;
import main.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class UpdateDialog extends JDialog {

    private Application app;
    public UpdateDialog() {
        setModal(true);
        setSize(300, 250);
        setLocationRelativeTo(null);
        setTitle("Update Employee");
        setResizable(false);

        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JLabel updateLabel = new JLabel("Enter the employees id");
        updateLabel.setBounds(20, 70, 250, 16);
        updateLabel.setFont(new Font("Arial", Font.BOLD, 16));
        contentPane.add(updateLabel);

        JTextField employeeIDTextField = new JTextField();
        employeeIDTextField.setBounds(200, 70, 50, 20);
        contentPane.add(employeeIDTextField);

        JButton updateButton = new JButton("Update");
        updateButton.setBounds(35, 160, 100, 30);
        contentPane.add(updateButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(180, 160, 100, 30);
        contentPane.add(cancelButton);

        try {
            app = new Application();
        } catch (Exception e) {
            e.printStackTrace();
        }

        employeeIDTextField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });

        updateButton.addActionListener(actionEvent -> {
            String id = employeeIDTextField.getText();

            if(id.isEmpty()) {
                JOptionPane.showMessageDialog(contentPane, "You need to enter the ID of the employee.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (Integer.parseInt(id) < 1) {
                JOptionPane.showMessageDialog(contentPane, "ID cannot be below 1.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    Employee employee = app.getEmployeeByID(Integer.parseInt(id));
                    EmployeeUpdateForm employeeUpdateForm = new EmployeeUpdateForm();
                    employeeUpdateForm.getEmployeeData(employee);
                    setVisible(false);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }


            }


        });

        cancelButton.addActionListener(actionEvent -> setVisible(false));


        setVisible(true);


    }




}
