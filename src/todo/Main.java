package todo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Main {
    //instance var
    private static JPanel taskPanel;

    
    public static void main(String[] args) {
        // Create the main application window frame
        JFrame frame = new JFrame("Task List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);

        //create task panel to hold the tasks
        taskPanel = new JPanel();
        taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));

        //create scroll
        JScrollPane scrollPane = new JScrollPane(taskPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 10, 460, 460);

        //create instance of Addtask class
        Addtask addTask = new Addtask();
        JButton addButton = addTask.getAddButton();

        addButton.setBounds(120, 420, 120, 30);

        //add action listener to the add button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                addnewTask();
            }
        });

        //create clear button

        JButton clearButton = new JButton("Clear Tasks");
        clearButton.setBounds(250, 420, 120, 30);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearAllTasks();
            }
        });

        //set and add components to the frame
        frame.add(addButton);
        frame.add(clearButton);
        frame.add(scrollPane);






    }
}
