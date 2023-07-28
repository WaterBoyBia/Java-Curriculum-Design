

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class OKUI {

	
	public OKUI()
	{
		JFrame jf = new JFrame();
		
		JLabel jl = new JLabel("修改成功");
		
		JButton jb = new JButton("确定");
		jb.setMargin(new Insets(0,0,0,0));
		
		jf.setBounds(500, 300, 200, 100);
		jl.setBounds(50, 50, 30, 20);
		jb.setBounds(70, 60, 50, 40);
		
		jb.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            	jf.dispose();
            }
        });

		jf.add(jb);
		jf.add(jl);
		jf.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		OKUI a = new OKUI();

	}

}
