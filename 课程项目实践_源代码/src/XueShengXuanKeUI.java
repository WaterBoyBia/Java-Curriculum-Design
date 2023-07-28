import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class XueShengXuanKeUI extends JFrame implements ActionListener {

    JFrame frame = new JFrame();
    JPanel jp1 = new JPanel();

    JButton printLessonButton = new JButton("打印课表");

    JButton removeLessonButton = new JButton("可选课程");

    JButton addLessonButton = new JButton("选课");

    public XueShengXuanKeUI() {

        addLessonButton.addActionListener(this);
        removeLessonButton.addActionListener(this);
        printLessonButton.addActionListener(this);


        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(250, 100, 400, 300);
        frame.setTitle("学生选课");

        jp1.setBounds(0, 0, 100, 300);

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
            new StuAddLessonUI();
        } else if (source == removeLessonButton) {
            new CoursesToChoose();
        } else if (source == printLessonButton) {
            new StuKeChengBiaoUI();
        }

    }


    public static void main(String[] args) {
        new XueShengXuanKeUI();
    }
}