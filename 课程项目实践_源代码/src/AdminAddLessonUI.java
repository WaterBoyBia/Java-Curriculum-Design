import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class AdminAddLessonUI extends JFrame implements ActionListener {

    File Lesson = new File("LessonList.txt");
    File Teacher = new File("TeacherList.txt");

    FileWriter fWriter_l = null;
    BufferedWriter bWritter_l = null;

    FileReader fReader_l = null;
    BufferedReader bReader_l = null;

    FileReader fReader_t = null;
    BufferedReader bReader_t = null;

    ArrayList<Lesson> LessonList = new ArrayList<Lesson>();
    ArrayList<Teacher> TeacherList = new ArrayList<Teacher>();
    ArrayList<JMenuItem> items = new ArrayList<JMenuItem>();

    private int add_num;

    JFrame jf = new JFrame("加课");

    JLabel l_name = new JLabel("课程名称");
    JLabel l_num = new JLabel("课序号");
    JLabel l_crdt = new JLabel("学分");

    JTextField txt_name = new JTextField(20);
    JTextField txt_num = new JTextField(20);
    JTextField txt_crdt = new JTextField(20);

    JButton jb = new JButton("完成");

    public AdminAddLessonUI() {
        jb.setMargin(new Insets(0, 0, 0, 0));
        try {

            fReader_l = new FileReader(Lesson);
            bReader_l = new BufferedReader(fReader_l);
            String str = null;

            while ((str = bReader_l.readLine()) != null) {
                Lesson lesson = new Lesson();

                String[] strArray = str.split("\\s+");
                lesson.setNum(strArray[0]);
                lesson.setName(strArray[1]);
                lesson.setTeacher(strArray[2]);
                lesson.setCredit(strArray[3]);

                LessonList.add(lesson);
            }
        } catch (Exception e) {
        } finally {
            try {
                bReader_l.close();
                fReader_l.close();
            } catch (Exception e2) {
            }
        }

        try {
            fReader_t = new FileReader(Teacher);
            bReader_t = new BufferedReader(fReader_t);
            String str = null;

            while ((str = bReader_t.readLine()) != null) {
                Teacher teacher = new Teacher();

                String[] strArray = str.split("\\s+");
                teacher.setName(strArray[0]);
                teacher.setNum(strArray[1]);

                TeacherList.add(teacher);
            }
        } catch (Exception e) {
        } finally {
            try {
                bReader_l.close();
                fReader_l.close();
            } catch (Exception e2) {
            }
        }


        jf.setBounds(300, 150, 400, 300);

        JMenuBar bar = new JMenuBar();
        bar.setBounds(700, 700, 100, 100);

        JMenu teacherMenu = new JMenu("选择教师");

        l_name.setBounds(125, 50, 100, 25);
        l_num.setBounds(125, 100, 100, 25);
        l_crdt.setBounds(125, 150, 100, 25);

        txt_name.setBounds(250, 50, 100, 25);
        txt_num.setBounds(250, 100, 100, 25);
        txt_crdt.setBounds(250, 150, 100, 25);

        jb.setBounds(200, 200, 60, 30);


        for (int i = 0; i < TeacherList.size(); i++) {
            JMenuItem item = new JMenuItem(TeacherList.get(i).getName());
            teacherMenu.add(item);
            items.add(item);
        }

        for (int i = 0; i < items.size(); i++) {
            items.get(i).addActionListener(this);
        }

        jb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addLesson(add_num);
                new OKUI();
            }
        });

        bar.add(teacherMenu);

        jf.add(l_crdt);
        jf.add(l_num);
        jf.add(l_name);
        jf.add(txt_crdt);
        jf.add(txt_name);
        jf.add(txt_num);
        jf.add(jb);
        jf.add(bar);

        jf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JMenuItem source = (JMenuItem) e.getSource();

        for (int i = 0; i < items.size(); i++) {
            if (source == items.get(i)) {
                add_num = i;
            }
        }
    }

    public void addLesson(int i) {

        try {
            fWriter_l = new FileWriter(Lesson, true);
            bWritter_l = new BufferedWriter(fWriter_l);

            String[] str = {txt_num.getText() + " " + txt_name.getText() + " " +
                    TeacherList.get(i).getName() + " " + txt_crdt.getText()};

            bWritter_l.write(str[0]);
            bWritter_l.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bWritter_l.close();
                fWriter_l.close();
            } catch (Exception e2) {
            }
        }

    }

    public static void main(String[] args) {
        AdminAddLessonUI alUI = new AdminAddLessonUI();
    }
}
