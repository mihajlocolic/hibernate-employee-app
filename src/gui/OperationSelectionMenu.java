package gui;

import javax.swing.*;
import java.awt.*;

public class OperationSelectionMenu extends JFrame {

    public OperationSelectionMenu() {
        setTitle("Operation Selection Menu");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel();
        label.setText("Select the operation.");
        label.setBounds(70, 50, 200, 18);
        label.setFont(new Font("Arial", Font.PLAIN, 18));

        contentPane.add(label);

        JButton buttonAdd = new JButton("Add");
        buttonAdd.setFocusPainted(false);
        buttonAdd.setBounds(100, 75, 100, 35);
        contentPane.add(buttonAdd);
        JButton buttonUpdate = new JButton("Update");
        buttonUpdate.setFocusPainted(false);
        buttonUpdate.setBounds(100, 125, 100, 35);
        contentPane.add(buttonUpdate);
        JButton buttonDelete = new JButton("Delete");
        buttonDelete.setFocusPainted(false);
        buttonDelete.setBounds(100, 175, 100, 35);
        contentPane.add(buttonDelete);
        JButton buttonShowSearch = new JButton("Show/Search");
        buttonShowSearch.setFocusPainted(false);
        buttonShowSearch.setBounds(75, 225, 150, 35);
        contentPane.add(buttonShowSearch);



        buttonAdd.addActionListener(actionEvent -> new AddDialog());
        buttonUpdate.addActionListener(actionEvent -> new UpdateDialog());
        buttonDelete.addActionListener(actionEvent -> new DeleteDialog());
        buttonShowSearch.addActionListener(actionEvent -> new ShowSearchDialog());

        setVisible(true);
    }
}
