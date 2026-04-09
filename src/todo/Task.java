package todo;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.concurrent.Flow;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Task {
    private JPanel taskPanel;
    private JCheckBox taskCheckBox;
    private JLabel taskLabel;
    private JPanel parentPanel;

    //constructor method
    public Task(String taskText, JPanel parentPanel){
        this.parentPanel = parentPanel;//store the parent panel
        taskPanel = new JPanel();
        taskPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        //create checkbox and label for the task
        taskCheckBox = new JCheckBox();
        taskLabel = new JLabel(taskText);

        //add an action listener to the checkbox to remove the task when checked 
        //and move completed tasks to the bottom

        taskCheckBox.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTaskStatus();
                moveCompletedTasksToEnd();
            }
        });


        taskCheckBox.setBounds(10, 10, 20, 20);
        taskLabel.setBounds(40, 10, 200, 20);

        taskPanel.add(taskCheckBox);
        taskPanel.add(taskLabel);

        //Add a right click menu to delete and rename the task
        JPopupMenu popupMenu = new JPopupMenu();

        //add delete option to the popup menu
        popupMenu.add("Delete").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteTask();
            }
        });

        //add rename option to the popup menu
        popupMenu.add("Rename").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                renameTask();   
            }
        });

    //add mouse listener to the task panel to show the popup menu on right click
        taskPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){
                if(e.isPopupTrigger()){
                    //show the popup menu at the location of the mouse click
                    popupMenu.show(taskPanel, e.getX(), e.getY());
                }
            }
        });


    }

    //method to update the task status when the checkbox is clicked
    private void updateTaskStatus() {
        //if checkbox is selected, grey out and italicize the task label to indicate completion
        if(taskCheckBox.isSelected()){
            taskLabel.setForeground(Color.GRAY);
            taskLabel.setFont(new Font(taskLabel.getFont().getName(), Font.ITALIC, taskLabel.getFont().getSize()));

        } else {
            taskLabel.setForeground(Color.BLACK);
            taskLabel.setFont(new Font(taskLabel.getFont().getName(), Font.PLAIN, taskLabel.getFont().getSize()));
        }

    }

    //method to move completed tasks to the end of the list
    private void moveCompletedTasksToEnd() {
        //if the task is completed, remove it from the current position and add it to the end of the parent panel
        if (taskCheckBox.isSelected()) {
            parentPanel.remove(taskPanel);
            parentPanel.add(taskPanel);
            parentPanel.revalidate();
            parentPanel.repaint();
        }
    }

    //method for renaming the task

    private void renameTask() {
        //show input dialog to get new task name and update the task label if the user clicks OK and enters a non-empty name
        String newTaskText = javax.swing.JOptionPane.showInputDialog("Enter new task name:", taskLabel.getText());
        if (newTaskText != null && !newTaskText.trim().isEmpty()) {
            taskLabel.setText(newTaskText);
        }
    }

    //method to delete the task
    private void deleteTask() {
        //remove the task panel from the parent panel and repaint to update the UI
        parentPanel.remove(taskPanel);
        parentPanel.revalidate();
        parentPanel.repaint();  
    }

    //getter method for the task panel
    public JPanel getTaskPanel() {
        return taskPanel;
    }

    
}
