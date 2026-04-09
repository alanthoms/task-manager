package todo;

import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Addtask {
    //intance vars
    private JPanel panel;
    private JTextField taskTextField;
    private JButton addButton;

    //consutructor to initialize the panel, text field and button
    public Addtask(){
        //create panel for pop up to get task input
        panel = new JPanel();
        panel.setLayout(null);

        //create label for task input
        JLabel label = new JLabel("Enter Task:");
        label.setBounds(10, 10, 50, 20);
        //create text field for task input
        taskTextField = new JTextField();
        taskTextField.setBounds(70, 10, 200, 20);

        //create add button with an icon
        ImageIcon icon = new ImageIcon("images/add.png");
        Image scaledImage = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        addButton = new JButton("Add Task", scaledIcon);
        addButton.setBounds(10, 40, 100, 30);

        //set margin to zero and remove focus painted to make the button look better
        addButton.setMargin(new Insets(0, 0, 0, 0));
        addButton.setFocusPainted(false);

        //add components to the panel
        panel.add(label);
        panel.add(taskTextField);
        panel.add(addButton);
    }


    //getter methods
    public JPanel getPanel() {
        return panel;
    }
    public JTextField getTaskTextField() {
        return taskTextField;
    }
    public JButton getAddButton() {
        return addButton;
    }
}
