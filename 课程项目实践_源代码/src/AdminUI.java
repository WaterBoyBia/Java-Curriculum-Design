import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AdminUI extends JFrame implements ActionListener {

    JFrame frame = new JFrame();
    JPanel jp1 = new JPanel();

    JButton printLessonButton = new JButton("打印课表");

    JButton removeLessonButton = new JButton("减课");

    JButton addLessonButton = new JButton("加课");

    public AdminUI() {

        addLessonButton.addActionListener(this);
        removeLessonButton.addActionListener(this);
        printLessonButton.addActionListener(this);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(250, 200, 300, 200);
        frame.setTitle("管理员");

        jp1.setBounds(50, 50, 200, 150);

        jp1.add(addLessonButton);
        jp1.add(removeLessonButton);
        jp1.add(printLessonButton);

        frame.add(jp1);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source == addLessonButton) {
            new AdminAddLessonUI();
        } else if (source == removeLessonButton) {
            new RemoveLessonUI();
        } else if (source == printLessonButton) {
            new CoursesToChoose();
        }

    }


    public static void main(String[] args) {
        new AdminUI();
    }
}