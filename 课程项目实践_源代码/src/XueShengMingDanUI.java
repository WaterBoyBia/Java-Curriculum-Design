import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class XueShengMingDanUI extends JFrame {
    public XueShengMingDanUI() {
        intiComponent();
    }

    //初始化窗体组件
    private void intiComponent() {
// 设置JTable的列名
        String[] columnNames =
                {"学号", "姓名", "专业", "班级"};
        Object[][] obj = new Object[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                switch (j) {
                    case 0:
                        obj[0][0] = " 14140301";
                        obj[0][1] = " 王小明";
                        obj[0][2] = " 通信工程";
                        obj[0][3] = " 2";
                        break;
                    case 1:
                        obj[1][0] = " 14140302";
                        obj[1][1] = " 王雷";
                        obj[1][2] = " 通信工程";
                        obj[1][3] = " 2";
                        break;
                    case 2:
                        obj[2][0] = " 14140303";
                        obj[2][1] = " 李芳";
                        obj[2][2] = " 通信工程";
                        obj[2][3] = " 2";
                        break;
                    case 3:
                        obj[3][0] = " 14140304";
                        obj[3][1] = " 张三";
                        obj[3][2] = " 通信工程";
                        obj[3][3] = " 2";
                        break;
                    case 4:
                        obj[4][0] = " 14140305";
                        obj[4][1] = " 李四";
                        obj[4][2] = " 通信工程";
                        obj[4][3] = " 2";
                        break;
                    case 5:
                        obj[5][0] = " 14140306";
                        obj[5][1] = " 文宇";
                        obj[5][2] = " 通信工程";
                        obj[5][3] = " 2";
                        break;
                    case 6:
                        obj[6][0] = " 14140307";
                        obj[6][1] = " 王飞";
                        obj[6][2] = " 通信工程";
                        obj[6][3] = " 2";
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
        new XueShengMingDanUI();
    }
}