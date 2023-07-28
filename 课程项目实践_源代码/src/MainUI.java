import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.IOException;
import java.sql.SQLException;

public class MainUI extends JFrame implements ActionListener {

    //定义组件
    JButton jb1, jb2, jb3, jb4 = null;//方框按钮
    JRadioButton jrb1, jrb2, jrb3 = null;//圆点按钮
    JPanel jp1, jp2, jp3, jp4, jp5 = null;//面板上的文字
    JPanel jp6 = (JPanel) this.getContentPane();
    JTextField jtf = null;//输入用户名
    JTextField jsn = null;//输入学号
    JLabel jlb1, jlb2, jlb3, jlb4 = null;//面板上的文字
    JPasswordField jpf = null;//输入密码
    ButtonGroup bg = null;

    FileWriter fWriter = null;
    BufferedWriter bWritter = null;

    public static void main(String[] args) throws IOException {
        MainUI mUI = new MainUI();
    }

    public MainUI() {

//创建组件
        jb1 = new JButton("登录");
        jb2 = new JButton("重置");
        jb3 = new JButton("退出");
        jb4 = new JButton("注册");
//设置监听
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
        jrb1 = new JRadioButton("教师");
        jrb2 = new JRadioButton("学生");
        jrb3 = new JRadioButton("管理员");
        bg = new ButtonGroup();
        bg.add(jrb1);
        bg.add(jrb2);
        bg.add(jrb3);
        jrb2.setSelected(true); //初始页面默认选择权限为学生
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();

        jlb1 = new JLabel("用户名：");
        jlb2 = new JLabel("学工号：");
        jlb3 = new JLabel("密 码：");
        jlb4 = new JLabel("权 限：");
        jlb1.setForeground(Color.white);
        jlb4.setForeground(Color.white);
        jlb2.setForeground(Color.white);
        jlb3.setForeground(Color.white);

        jtf = new JTextField(10);//用户名
        jpf = new JPasswordField(10);//密码
        jsn = new JTextField(10);//学号

//加?到JPanel中
        jp1.add(jlb1);
        jp1.add(jtf);
        jp2.add(jlb2);
        jp2.add(jsn);
        jp3.add(jlb3);
        jp3.add(jpf);
        jp4.add(jlb4); //添加标签
        jp4.add(jrb1);
        jp4.add(jrb2);
        jp4.add(jrb3);

        jp5.add(jb1); //添加按钮
        jp5.add(jb2);
        jp5.add(jb3);
        jp5.add(jb4);

        jp1.setOpaque(false);
        jp2.setOpaque(false);
        jp3.setOpaque(false);
        jp4.setOpaque(false);
        jp5.setOpaque(false);
        jp6.setOpaque(false);

        //主页面背景图片
        ImageIcon img = new ImageIcon("主页面背景.jpg");
        JLabel imgLabel = new JLabel(img);
        this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

//加?JFrame中
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);
        this.setLayout(new GridLayout(5, 1)); //选择GridLayout布局管理器
        this.setTitle("教务管理系统");
        this.setSize(img.getIconWidth(), img.getIconHeight());
        this.setLocation(400, 200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //设置当关闭窗口时，若有后续操作，则该窗口关闭程序运行；若无后续操作，则退出程序
        this.setVisible(true);
        this.setResizable(false);
    }

    public void actionPerformed(ActionEvent e) { //事件判断

        if (e.getActionCommand() == "登录") {
            if (jrb1.isSelected())//如果选中教师登录
            {
                tealogin(); //连接到教师的方法页面
            } else if (jrb2.isSelected()) //学?在登录系统
            {
                stulogin(); //连接到学生的方法页面
            } else if (jrb3.isSelected()) {
                adminlogin();//连接到管理员的方法页面
            }
        } else if (e.getActionCommand() == "重置") {
            clear();
        } else if (e.getActionCommand() == "退出") {
            System.exit(0);
        } else if (e.getActionCommand() == "注册") {
            if (jrb1.isSelected())//如果选中教师注册
            {
                tearegister(); //连接到教师的方法页面
            } else if (jrb2.isSelected()) //学生在登录系统
            {
                sturegister(); //连接到学生的方法页面
            } else if (jrb3.isSelected()) {
                adminregister();//连接到管理员的方法页面
            }
        }
    }

    //学生登录判断方法
    public void stulogin() {

        BufferedReader reader;
        //int count = 0;
        try {
            reader = new BufferedReader(new FileReader("stu.txt"));
            String line = reader.readLine();
            int count = 1;
            while (line != null) {

                if ((jtf.getText() + " " + jsn.getText() + " " + jpf.getText()).equals(line)) {

                    System.out.println(count);
                    try {
                        String countX = String.valueOf(count);
                        fWriter = new FileWriter("testStd.txt", true);
                        bWritter = new BufferedWriter(fWriter);
                        //System.out.println(account.length);
                        bWritter.write(countX);
                        bWritter.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {

                            bWritter.close();
                            fWriter.close();
                        } catch (Exception e2) {
                        }
                    }

                    JOptionPane.showMessageDialog(null, "登录成功！", "提示消息", JOptionPane.WARNING_MESSAGE);
                    dispose();
                    clear();
                    StdUI ui = new StdUI(); //创建新界面

                } else {
                    // read next line
                    line = reader.readLine();
                    count++;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //教师登录判断?法
    public void tealogin() {
        BufferedReader reader;
        //int count = 0;
        try {
            reader = new BufferedReader(new FileReader("tea.txt"));


            String line = reader.readLine();
            int count = 1;
            while (line != null) {

                if ((jtf.getText() + " " + jsn.getText() + " " + jpf.getText()).equals(line)) {

                    System.out.println(count);
                    try {
                        String countX = String.valueOf(count);
                        fWriter = new FileWriter("testTea.txt", true);
                        bWritter = new BufferedWriter(fWriter);
                        //System.out.println(account.length);
                        bWritter.write(countX);
                        bWritter.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {

                            bWritter.close();
                            fWriter.close();
                        } catch (Exception e2) {
                        }
                    }

                    JOptionPane.showMessageDialog(null, "登录成功！", "提示消息", JOptionPane.WARNING_MESSAGE);
                    dispose();
                    clear();
                    TerUI ui = new TerUI(); //创建新界面

                } else {
                    // read next line
                    line = reader.readLine();
                    count++;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //清空文本框和密码框
    public void clear() {
        jtf.setText("");
        jpf.setText("");
        jsn.setText("");
    }

    //判断管理员登陆
    public void adminlogin() {

        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("admin.txt"));

            String line = reader.readLine();
            int count = 1;
            while (line != null) {

                if ((jtf.getText() + " " + jsn.getText() + " " + jpf.getText()).equals(line)) {

                    System.out.println(count);
                    try {
                        String countX = String.valueOf(count);
                        fWriter = new FileWriter("testAdmin.txt", true);
                        bWritter = new BufferedWriter(fWriter);
                        //System.out.println(account.length);
                        bWritter.write(countX);
                        bWritter.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {

                            bWritter.close();
                            fWriter.close();
                        } catch (Exception e2) {
                        }
                    }

                    JOptionPane.showMessageDialog(null, "登录成功！", "提示消息", JOptionPane.WARNING_MESSAGE);
                    dispose();
                    clear();
                    AdminUI ui = new AdminUI(); //创建新界面

                } else {
                    // read next line
                    line = reader.readLine();
                    count++;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void tearegister() {
        Account tea = new Account();
        tea.setName(jtf.getText());
        tea.setNum(jsn.getText());
        tea.setPwd(jpf.getText());
        if (jtf.getText().isEmpty() || jpf.getText().isEmpty() || jsn.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "请检查用户名、学工号和密码！", "提示消息", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "老师" + " " + jtf.getText() + " " + "注册成功！", "提示消息", JOptionPane.INFORMATION_MESSAGE);
            String[] account = {tea.getName() + " " + tea.getNum() + " " + tea.getPwd()};
            try {

                fWriter = new FileWriter("tea.txt", true);
                bWritter = new BufferedWriter(fWriter);
                bWritter.write(account[0]);
                bWritter.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {

                    bWritter.close();
                    fWriter.close();
                } catch (Exception e2) {
                }
            }

            clear();
        }
    }

    public void sturegister() {
        Account stu = new Account();
        stu.setName(jtf.getText());
        stu.setNum(jsn.getText());
        stu.setPwd(jpf.getText());
        if (jtf.getText().isEmpty() || jpf.getText().isEmpty() || jsn.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "请检查用户名、学工号和密码！", "提示消息", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "学生" + " " + jtf.getText() + " " + "注册成功！", "提示消息", JOptionPane.INFORMATION_MESSAGE);

            String[] account = {stu.getName() + " " + stu.getNum() + " " + stu.getPwd()};
            try {

                fWriter = new FileWriter("stu.txt", true);
                bWritter = new BufferedWriter(fWriter);

                bWritter.write(account[0]);
                bWritter.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {

                    bWritter.close();
                    fWriter.close();
                } catch (Exception e2) {
                }
            }

            clear();
        }
    }

    public void adminregister() {
        Account admin = new Account();
        admin.setName(jtf.getText());
        admin.setNum(jsn.getText());
        admin.setPwd(jpf.getText());
        if (jtf.getText().isEmpty() || jpf.getText().isEmpty() || jsn.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "请检查用户名、学工号和密码！", "提示消息", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "管理员" + " " + jtf.getText() + " " + "注册成功！", "提示消息", JOptionPane.INFORMATION_MESSAGE);

            String[] account = {admin.getName() + " " + admin.getNum() + " " + admin.getPwd()};
            try {

                fWriter = new FileWriter("admin.txt", true);
                bWritter = new BufferedWriter(fWriter);

                bWritter.write(account[0]);
                bWritter.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {

                    bWritter.close();
                    fWriter.close();
                } catch (Exception e2) {
                }
            }
            clear();
        }
    }


}