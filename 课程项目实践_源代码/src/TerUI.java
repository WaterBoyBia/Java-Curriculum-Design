import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JButton;

public class TerUI extends JFrame implements ActionListener {
    //定义组件
    JButton jb1, jb2, jb3 ,jb4= null;
    JPanel jp1, jp2, jp3, jp4 = null;
    JLabel jlb1, jlb2, jlb3, jlb4, jlb5, jlb6 = null;

    public static void main(String[] args) {
        TerUI ui = new TerUI();
    }

    public TerUI() {
//创建组件
        jb1 = new JButton("课程管理");
        jb1.setForeground(Color.BLUE);
        jb2 = new JButton("学生名单");
        jb2.setForeground(Color.BLUE);
        jb3 = new JButton("查看学生评价");
        jb3.setForeground(Color.BLUE);
        jb4 = new JButton("评价学生");
        jb4.setForeground(Color.BLUE);

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jlb1 = new JLabel("姓名：");
        jlb2 = new JLabel("工号：");
        jlb3 = new JLabel("最新公告：");
        jlb3.setForeground(Color.red);
        jlb4 = new JLabel("我院举行体测的通知");
        jlb5 = new JLabel("王老师");
        jlb6 = new JLabel("114514");
        jp1.add(jlb1);
        jp1.add(jlb5);
        jp1.add(jlb2);
        jp1.add(jlb6);
        jp2.add(jb1);
        jp2.add(jb2);
        jp2.add(jb3);
        jp2.add(jb4);
        jp3.add(jlb3);
        jp3.add(jlb4);
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.setLayout(new GridLayout(4, 3, 50, 50)); //设置布局管理器
        this.setTitle("学⽣成绩管理系统");
        this.setSize(400, 300);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb1) {
            new GetCourses(); //创建⼀个新界⾯
        } else if (e.getSource() == jb2) {
            new XueShengMingDanUI(); //创建⼀个新界⾯
        } else if (e.getSource() == jb3)
       {
            try {
                new GetComments();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }else if( e.getSource() == jb4){
            new JudgeStudents();
        }
    }
}
