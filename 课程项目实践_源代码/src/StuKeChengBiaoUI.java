import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTable;

public class StuKeChengBiaoUI extends JFrame {

    File Lesson = new File("StuKeList.txt");

    FileReader fReader_l = null;
    BufferedReader bReader_l = null;

    ArrayList<Lesson> LessonList = new ArrayList<Lesson>();

    public StuKeChengBiaoUI() {
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
                lesson.setFive(strArray[4]);
                lesson.setSix(strArray[5]);
                lesson.setSeven(strArray[6]);
                lesson.setEight(strArray[7]);

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

        JFrame frame = new JFrame();
        JPanel jp = new JPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200, 150, 500, 500);
        frame.setTitle("课程表");
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        Object[][] obj = new Object[LessonList.size()][8];
        for (int i = 0; i < LessonList.size(); i++) {
            obj[i][0] = LessonList.get(i).getNum();
            obj[i][1] = LessonList.get(i).getName();
            obj[i][2] = LessonList.get(i).getTeacher();
            obj[i][3] = LessonList.get(i).getCredit();
            obj[i][4] = LessonList.get(i).getFive();
            obj[i][5] = LessonList.get(i).getSix();
            obj[i][6] = LessonList.get(i).getSeven();
            obj[i][7] = LessonList.get(i).getEight();


        }

        String[] columnNames = {"课节数", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期天"};

        JTable table = new JTable(obj, columnNames);
        jp.add(new JScrollPane(table));
        frame.add(jp);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        StuKeChengBiaoUI kcb = new StuKeChengBiaoUI();

    }

}