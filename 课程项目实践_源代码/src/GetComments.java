import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class GetComments extends JFrame {
    private int Rank = 0;

    public GetComments() throws Exception {
        intiCompent();
    }

    public void intiCompent() throws Exception {

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

        String filePath = name + "评价.txt";
        DefaultListModel<String> dlm = new DefaultListModel<String>();
        JFrame jf = new JFrame("学生对于您的评价");
        jf.setSize(800, 500);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();

        // 创建一个 JList 实例
        final JList<String> list = new JList<String>();

        // 设置一下首选大小
        list.setPreferredSize(new Dimension(600, 300));

        // 允许可间断的多选
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        for (int i = 0; (Rank <= dlm.size()) && (i < getFileContext(filePath).size()) && ((getFileContext(filePath).get(i)) != null); ) {
            dlm.add(Rank, getFileContext(filePath).get(i));
            System.out.println(getFileContext(filePath).get(i));
            Rank++;
            i++;
        }

        list.setModel(dlm);

        panel.add(list);

        jf.setContentPane(panel);
        jf.setVisible(true);

    }

    public static List<String> getFileContext(String path) throws Exception {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> list = new ArrayList<String>();
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            if (str.trim().length() > 0) {
                list.add(str);
            }
        }
        return list;
    }

    public static void main(String arg[]) throws Exception {
        new GetComments();
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


