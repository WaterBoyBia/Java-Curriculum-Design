import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class JudgeStudents extends JFrame {

    public JudgeStudents() {
        try {
            intiCompent();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void intiCompent() throws FileNotFoundException, IOException {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //-----------------------------------------每一列表头
        Vector<String> col = new Vector<String>();
        col.addElement("姓名");
        col.addElement("分数");


        Vector<Vector> rowData = new Vector<Vector>();//声明所有行
        //----------------------------------------开始读文本文件

        //此处为储存课表文件的路径
        String name;
        String num;

        Scanner readerx = new Scanner(new FileReader("testTea.txt"));


        String line = readerx.nextLine();
        int linenumber = Integer.parseInt(line);

        String fileName = "tea.txt";

        String content;

        content = readPointLIne(fileName, linenumber);

        String[] sa = content.split(" ");
        name = sa[0];
        readerx.close();

        String filePath = name + "学生.txt";
        //此处表示在路径上增加具体的文件名

        System.out.println(filePath);
        File file = new File(filePath);
        FileReader reader = null;
        try {
            reader = new FileReader(filePath);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        BufferedReader br = new BufferedReader(reader);

        String eachLine = null;//定义每一行
        try {
            while ((eachLine = br.readLine()) != null) {//读文件至末尾
                //-----split(String):根据给定正则表达式的匹配拆分此字符串。
                String[] temp = eachLine.split(" ");//每一行里的空格
                //-----声明每一行，必须在这里，外部是不行地。
                Vector<String> row = new Vector<String>();
                for (int i = 0; i < temp.length; i++) {//遍历每一行
                    row.add(temp[i]);//把每一行都加入row
                }
                rowData.add(row);//再把每一个row的数据给rowData
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        JTable table = new JTable(rowData, col);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(300, 150);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        new JudgeStudents();
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