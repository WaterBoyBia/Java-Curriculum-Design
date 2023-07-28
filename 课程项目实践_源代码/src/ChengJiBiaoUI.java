import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class ChengJiBiaoUI extends JFrame {
    public ChengJiBiaoUI() {
        intiComponent();
    }

    //初始化窗体组件
    private void intiComponent() {
        String[] columnNames =
                {"课程数目", "课程名称", "学分", "绩点", "分数", "补考"}; //设置JTable的列名
        Object[][] obj = new Object[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                switch (j) {
                    case 0:
                        obj[0][0] = " 1";
                        obj[0][1] = " 光纤通信";
                        obj[0][2] = " 2";
                        obj[0][3] = " 1.5";
                        obj[0][4] = " 75";
                        obj[0][5] = " 否";
                        break;
                    case 1:
                        obj[1][0] = " 2";
                        obj[1][1] = " Android";
                        obj[1][2] = " 2";
                        obj[1][3] = " 1.8";
                        obj[1][4] = " 5";
                        obj[1][5] = " 否";
                        break;
                    case 2:
                        obj[2][0] = " 3";
                        obj[2][1] = " 物联网";
                        obj[2][2] = " 1.5";
                        obj[2][3] = " 1.2";
                        obj[2][4] = " 70";
                        obj[2][5] = " 否";
                        break;
                    case 3:
                        obj[3][0] = " 4";
                        obj[3][1] = " 电磁场";
                        obj[3][2] = " 2";
                        obj[3][3] = " 1.6";
                        obj[3][4] = " 78";
                        obj[3][5] = " 否";
                        break;
                    case 4:
                        obj[4][0] = " 5";
                        obj[4][1] = " 手机维修";
                        obj[4][2] = " 1.0";
                        obj[4][3] = " 1.0";
                        obj[4][4] = " 优秀";
                        obj[4][5] = " 否";
                        break;
                    case 5:
                        obj[5][0] = " 6";
                        obj[5][1] = " DSP";
                        obj[5][2] = " 1.0";
                        obj[5][3] = " 1.0";
                        obj[5][4] = " 良好";
                        obj[5][5] = " 否";
                        break;
                    case 6:
                        obj[6][0] = " 7";
                        obj[6][1] = " 通信原理实验";
                        obj[6][2] = " 1.0";
                        obj[6][3] = " 1.0";
                        obj[6][4] = " 良好";
                        obj[6][5] = " 否";
                        break;
                }
            }
        }
        JTable table = new JTable(obj, columnNames); //JTable的其中⼀种构造⽅法
        TableColumn column = null; //设置JTable的列默认的宽度和⾼度
        int colunms = table.getColumnCount();
        for (int i = 0; i < colunms; i++) {
            column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(100); //将每⼀列的默认宽度设置为100
        }
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); //设置JTable⾃动调整列表的状态，此处设置为关闭
        JScrollPane scroll = new JScrollPane(table); //⽤JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看
        scroll.setSize(300, 50);
        add(scroll);
        this.setLocation(450, 200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
    }

    public static void main(String[] args) {
        new ChengJiBiaoUI();
    }
}

