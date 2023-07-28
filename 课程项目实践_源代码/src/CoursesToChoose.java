import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTable;

public class CoursesToChoose extends JFrame {

    File Lesson = new File("LessonList.txt");

    FileReader fReader_l = null;
    BufferedReader bReader_l = null;

    ArrayList<Lesson> LessonList = new ArrayList<Lesson>();

    public CoursesToChoose() {
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

        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(200, 100, 500, 400);
        frame.setTitle("课程表");

        Object[][] obj = new Object[LessonList.size()][4];
        for (int i = 0; i < LessonList.size(); i++) {
            obj[i][0] = LessonList.get(i).getNum();
            obj[i][1] = LessonList.get(i).getName();
            obj[i][2] = LessonList.get(i).getTeacher();
            obj[i][3] = LessonList.get(i).getCredit();
        }

        String[] columnNames = {"课序号", "课程名称", "任课教师", "学分"};

        JTable table = new JTable(obj, columnNames);

        frame.add(table);
        frame.setVisible(true);
    }


    public static void main(String[] args) {

        CoursesToChoose kcb = new CoursesToChoose();

    }

}
