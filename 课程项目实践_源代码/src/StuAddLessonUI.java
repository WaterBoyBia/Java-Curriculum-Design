import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class StuAddLessonUI {
    private JFrame f;
    private JMenuBar bar;
    private JMenu fileMenu, subMenu;
    private JMenuItem closeItem, subItem1, subItem2;
    private JMenuItem openItem, saveItem;
    //定义打开和保存对话框
    private FileDialog openDia, saveDia;

    //设置文本区域来保存打开的数据
    private TextArea ta;

    private File file;

    StuAddLessonUI() {
        init();
    }

    public void init() {
        f = new JFrame("学生选课");
        f.setBounds(300, 100, 500, 600);

        bar = new JMenuBar();

        ta = new TextArea();

        fileMenu = new JMenu("文件");
        subMenu = new JMenu("子菜单");

        openItem = new JMenuItem("打开");
        saveItem = new JMenuItem("保存");
        subItem1 = new JMenuItem("子条目1");
        subItem2 = new JMenuItem("子条目2");
        closeItem = new JMenuItem("退出");

        subMenu.add(subItem1);
        subMenu.add(subItem2);


        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(subMenu);
        fileMenu.add(closeItem);
        bar.add(fileMenu);

        f.setJMenuBar(bar);

        //默认模式为 FileDialog.LOAD
        openDia = new FileDialog(f, "我的打卡", FileDialog.LOAD);
        saveDia = new FileDialog(f, "我的保存", FileDialog.SAVE);

        f.add(ta);

        myEvent();

        f.setVisible(true);


    }

    private void myEvent() {
        saveItem.addActionListener(new ActionListener() {
            //设置保存文件的功能
            public void actionPerformed(ActionEvent e) {
                if (file == null)//文件不存在情况下 创建文件
                {
                    saveDia.setVisible(true);
                    String dirPath = saveDia.getDirectory();
                    String fileName = saveDia.getFile();

                    if (dirPath == null || fileName == null)
                        return;
                    file = new File(dirPath, fileName);
                }

                try {
                    BufferedWriter bufw = new BufferedWriter(new FileWriter(file));

                    String text = ta.getText();

                    bufw.write(text);

                    bufw.close();
                } catch (IOException ex) {
                    throw new RuntimeException("文件保存失败！");
                }
            }
        });

        openItem.addActionListener(new ActionListener() {
            //设置打开文件功能
            public void actionPerformed(ActionEvent e) {
                openDia.setVisible(true);
                String dirPath = openDia.getDirectory();//获取文件路径
                String fileName = openDia.getFile();//获取文件名称
                //System.out.println(dirPath +"++"+ fileName);

                //如果打开路径 或 目录为空 则返回空
                if (dirPath == null || fileName == null)
                    return;

                ta.setText("");//清空文本

                file = new File(dirPath, fileName);

                try {
                    BufferedReader bufr = new BufferedReader(new FileReader(file));

                    String line = null;

                    while ((line = bufr.readLine()) != null) {
                        ta.append(line + "\r\n");
                    }
                    bufr.close();
                } catch (IOException ex) {
                    throw new RuntimeException("文件读取失败！");
                }

            }
        });

      f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new StuAddLessonUI();
    }
}
