//import javax.swing.JFrame;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.table.TableColumn;
//
//public class KeChengGuanLiUI extends JFrame {
//    public KeChengGuanLiUI() {
//        intiComponent();
//    }
//
//    private void intiComponent() {
//        String[] columnNames =
//                {"课节数", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
//        Object[][] obj = new Object[8][8];
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                switch (j) {
//                    case 0:
//                        obj[0][0] = " 第一节课";
//                        obj[0][1] = " 有课";
//                        obj[0][2] = " ";
//                        obj[0][3] = " ";
//                        obj[0][4] = " 有课";
//                        obj[0][5] = " ";
//                        obj[0][6] = "";
//                        obj[0][7] = " ";
//                        break;
//                    case 1:
//                        obj[1][0] = " 第二节课";
//                        obj[1][1] = " 有课";
//                        obj[1][2] = "";
//                        obj[1][3] = "";
//                        obj[1][4] = " 有课";
//                        obj[1][5] = " ";
//                        obj[1][6] = "";
//                        obj[1][7] = " ";
//                        break;
//                    case 2:
//                        obj[2][0] = " 第三节课";
//                        obj[2][1] = "";
//                        obj[2][2] = " ";
//                        obj[2][3] = " 有课";
//                        obj[2][4] = "";
//                        obj[2][5] = "";
//                        obj[2][6] = "";
//                        obj[2][7] = " ";
//                        break;
//                    case 3:
//                        obj[3][0] = " 第四节课";
//                        obj[3][1] = "";
//                        obj[3][2] = " ";
//                        obj[3][3] = " 有课";
//                        obj[3][4] = " ";
//                        obj[3][5] = "";
//                        obj[3][6] = "";
//                        obj[3][7] = "";
//                        break;
//                    case 4:
//                        obj[4][0] = " 第五节课";
//                        obj[4][1] = "";
//                        obj[4][2] = " ";
//                        obj[4][3] = " ";
//                        obj[4][4] = " ";
//                        obj[4][5] = " ";
//                        obj[4][6] = " ";
//                        obj[4][7] = " ";
//                        break;
//                    case 5:
//                        obj[5][0] = " 第六节课";
//                        obj[5][1] = "";
//                        obj[5][2] = " 开会";
//                        obj[5][3] = " ";
//                        obj[5][4] = " ";
//                        obj[5][5] = " ";
//                        obj[5][6] = " ";
//                        obj[5][7] = " ";
//                        break;
//                    case 6:
//                        obj[6][0] = " 第七节课";
//                        obj[6][1] = "";
//                        obj[6][2] = " 有课";
//                        obj[6][3] = " ";
//                        obj[6][4] = " 开会";
//                        obj[6][5] = " ";
//                        obj[6][6] = " ";
//                        obj[6][7] = " ";
//                        break;
//                    case 7:
//                        obj[7][0] = " 第八节课";
//                        obj[7][1] = "";
//                        obj[7][2] = " 有课 ";
//                        obj[7][3] = " ";
//                        obj[7][4] = " ";
//                        obj[7][5] = " ";
//                        obj[7][6] = " ";
//                        obj[7][7] = " ";
//                        break;
//                }
//            }
//        }
//        JTable table = new JTable(obj, columnNames);
//        TableColumn column = null;
//        int colunms = table.getColumnCount();
//        for (int i = 0; i < colunms; i++) {
//            column = table.getColumnModel().getColumn(i);
//            column.setPreferredWidth(100);
//        }
//        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        JScrollPane scroll = new JScrollPane(table);
//        scroll.setSize(300, 50);
//        add(scroll);
//        this.setLocation(450, 200);
//        this.setVisible(true);
//        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        this.pack();
//    }
//
//    public static void main(String[] args) {
//        new KeChengGuanLiUI();
//    }
//}
//
