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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class RemoveLessonUI implements ActionListener {

    File Lesson = new File("LessonList.txt");

    FileWriter fWriter = null;
    BufferedWriter bWritter = null;
    FileReader fReader = null;
    BufferedReader bReader = null;

    ArrayList<Lesson> LessonList = new ArrayList<Lesson>();

    ArrayList<JMenuItem> items = new ArrayList<JMenuItem>();

    JFrame jf = new JFrame("减课");

    JButton jb = new JButton("确定");


    private int remove_num;

    public RemoveLessonUI() {
        jb.setMargin(new Insets(0, 0, 0, 0));
        try {

            fReader = new FileReader(Lesson);
            bReader = new BufferedReader(fReader);
            String str = null;

            while ((str = bReader.readLine()) != null) {
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
                bReader.close();
                fReader.close();
            } catch (Exception e2) {
            }
        }

        jf.setBounds(300, 150, 300, 200);

        JMenuBar bar = new JMenuBar();
        bar.setBounds(700, 700, 100, 100);

        JMenu lessonMenu = new JMenu("请选择课程");


        jb.setBounds(150, 70, 60, 30);


        for (int i = 0; i < LessonList.size(); i++) {
            JMenuItem item = new JMenuItem(LessonList.get(i).getName());
            lessonMenu.add(item);
            items.add(item);
        }

        for (int i = 0; i < items.size(); i++) {
            items.get(i).addActionListener(this);
        }

        jb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                removeLesson(remove_num);
                new OKUI();
            }
        });

        bar.add(lessonMenu);

        jf.add(jb);
        jf.add(bar);

        jf.setVisible(true);
    }


    public void removeLesson(int i) {

        LessonList.remove(i);

        try {

            fWriter = new FileWriter(Lesson, false);
            bWritter = new BufferedWriter(fWriter);

            for (int j = 0; j < LessonList.size(); j++) {
                String[] str = {LessonList.get(j).getNum() + " " + LessonList.get(j).getName() + " "
                        + LessonList.get(j).getTeacher() + " " + LessonList.get(j).getCredit()};

                bWritter.write(str[0]);
                bWritter.newLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bWritter.close();
                fWriter.close();
            } catch (Exception e2) {
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem source = (JMenuItem) e.getSource();

        for (int i = 0; i < items.size(); i++) {
            if (source == items.get(i)) {
                remove_num = i;
            }
        }

    }

    public static void main(String[] args) {
        new RemoveLessonUI();
    }
}
