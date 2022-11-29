package gui;

import main.Application;
import main.HibernateUtil;
import org.hibernate.HibernateException;

import javax.swing.*;
import java.awt.*;

public class DeleteDialog extends JDialog {

    private Application app;
    public DeleteDialog() {
        setModal(true);
        setTitle("Delete Employee");
        setResizable(false);
        setSize(300, 250);
        setLocationRelativeTo(null);


        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JLabel idLabel = new JLabel("Enter the employees id");
        idLabel.setBounds(20, 70, 250, 16);
        idLabel.setFont(new Font("Arial", Font.BOLD, 16));
        contentPane.add(idLabel);

        JTextField employeeIDTextField = new JTextField();
        employeeIDTextField.setBounds(200, 70, 50, 20);
        contentPane.add(employeeIDTextField);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(35, 160, 100, 30);
        contentPane.add(deleteButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(180, 160, 100, 30);
        contentPane.add(cancelButton);

        try {
            app = new Application();
         } catch (Exception e) {
            e.printStackTrace();
        }

        deleteButton.addActionListener(actionEvent -> {
            int employeeID = Integer.parseInt(employeeIDTextField.getText());
            try {
                app.deleteEmployee(employeeID);
                JOptionPane.showMessageDialog(contentPane, "Employee deleted.", " ", JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);
            } catch (HibernateException e) {
                throw new RuntimeException(e);
            } finally {
                HibernateUtil.close();
            }

        });

        cancelButton.addActionListener(actionEvent -> setVisible(false));


        setVisible(true);

    }
}
