import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.JButton;

public class StdUI extends JFrame implements ActionListener {
    //定义组件
    JButton jb1 = new JButton();
    JButton jb2 = new JButton();
    JButton jb3 = new JButton();
    JPanel jp1, jp2, jp3, jp4 = null;
    JLabel jlb1, jlb2, jlb3, jlb4, jlb5, jlb6, jlb7 = null;

    public static void main(String[] args) throws Exception {

        StdUI ui = new StdUI();
    }

    //****************************事件判断**********************
//构造函数
    public StdUI() throws FileNotFoundException, IOException //不能申明为void!!!!!否则弹不出新界⾯
    {
//创建组件
        String name;
        String num;

        Scanner reader = new Scanner(new FileReader("testStd.txt"));
        String line = reader.nextLine();
        int linenumber = Integer.parseInt(line);

        String fileName = "stu.txt";

        String content = readPointLIne(fileName, linenumber);
        String[] sa = content.split(" ");
        name = sa[0];
        num = sa[1];

        reader.close();
        File file = new File("testStd.txt");
        file.delete();

        jb1 = new JButton("课程表");
        jb1.setForeground(Color.BLUE);
        jb2 = new JButton("成绩查询");
        jb2.setForeground(Color.BLUE);
        jb3 = new JButton("我要选课");
        jb3.setForeground(Color.BLUE);
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();

        jlb1 = new JLabel("姓名：");
        jlb2 = new JLabel("学号：");
        jlb3 = new JLabel("最新公告：");
        jlb3.setForeground(Color.red);
        jlb4 = new JLabel("我院举行学生体测通知");
        jlb5 = new JLabel(name);
        jlb6 = new JLabel(num);
        jp1.add(jlb1);
        jp1.add(jlb5);
        jp1.add(jlb2);
        jp1.add(jlb6);
        jp2.add(jb1);
        jp2.add(jb2);
        jp3.add(jlb3);
        jp3.add(jlb4);

        jp4.add(jb3);

        this.add(jp1);
        this.add(jp2);
        this.add(jp4);
        this.add(jp3);
//设置布局管理器
        this.setLayout(new GridLayout(4, 3, 50, 50));
        this.setTitle("学生成绩管理系统");
        this.setSize(400, 300);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb1) {
            new StuKeChengBiaoUI();
        } else if (e.getSource() == jb2) {
            new ChengJiBiaoUI();
        } else if (e.getSource() == jb3) {
            new XueShengXuanKeUI();
        }
    }


    public static String readPointLIne(String fileName, int readLine) throws IOException {
        String line;//读取每行的内容
        try (
                BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            int i = 0;
            //每次读取一行，一行一行的读取 br.readLine()
            while ((line = br.readLine()) != null) {
                i++;
                if (i == readLine) {
                    return line;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
