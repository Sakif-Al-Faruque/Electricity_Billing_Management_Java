package guiprogram.adduser;

import guiprogram.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import guiprogram.operation.*;
import guiprogram.user.*;


//adding field maneger
public class AddFm extends JFrame implements ActionListener
{
		JLabel l1,l2,l3,l4,l5, l6, l7;
		JButton b1,b2; 
		JTextField t1,t2,t3,t4, t5, t6;
		JPanel p1;
		
		private String ADMIN_ID;

	public AddFm()
	{
		super(" Electricity Billing System ");
		this.setSize(750,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p1 = new JPanel();
		p1.setSize(new Dimension(750,500));
		p1.setBackground(Color.LIGHT_GRAY);
		p1.setLayout(null);
		
		l1 = new JLabel("                          FIELD  MANEGER  INFO  ");
		l1.setFont(new Font("Serif",Font.ITALIC,25));
		l1.setBackground(Color.DARK_GRAY);
		l1.setOpaque(true);
		l1.setForeground(Color.blue);
		l1.setBounds(1,20,750,45);
		p1.add(l1);
		
		l2 = new JLabel("  ID                                    :  ");
		l2.setFont(new Font("Serif",Font.BOLD,15));
		l2.setForeground(Color.black);
		l2.setBounds(82,90,250,20);
		p1.add(l2);
		
		l3 = new JLabel(" USERNAME                    :  ");
		l3.setFont(new Font("Serif",Font.BOLD,15));
		l3.setForeground(Color.black);
		l3.setBounds(80,130,250,20);
		p1.add(l3);
		
		l4 = new JLabel(" PASSWORD                    :  ");
		l4.setFont(new Font("Serif",Font.BOLD,15));
		l4.setForeground(Color.black);
		l4.setBounds(80,170,250,20);
		p1.add(l4);
		
		l5 = new JLabel("  NID                                  :  ");
		l5.setFont(new Font("Serif",Font.BOLD,15));
		l5.setForeground(Color.black);
		l5.setBounds(80,210,250,20);
		p1.add(l5);

        l6 = new JLabel("  ADDRESS                       :  ");
		l6.setFont(new Font("Serif",Font.BOLD,15));
		l6.setForeground(Color.black);
		l6.setBounds(80,250,250,20);
		p1.add(l6);

        l7 = new JLabel("  REGISTERED DATE    :  ");
		l7.setFont(new Font("Serif",Font.BOLD,15));
		l7.setForeground(Color.black);
		l7.setBounds(80,290,250,20);
		p1.add(l7);
		
		t1 = new JTextField();
		t1.setBounds(360,90,250,25);
		p1.add(t1);

		t2 = new JTextField();
		t2.setBounds(360,130,250,25);
		p1.add(t2);
		
		t3 = new JTextField();
		t3.setBounds(360,170,250,25);
		p1.add(t3);

		t4 = new JTextField();
		t4.setBounds(360,210,250,25);
		p1.add(t4);

        t5 = new JTextField();
		t5.setBounds(360,250,250,25);
		p1.add(t5);

        t6 = new JTextField();
		t6.setBounds(360,290,250,25);
		p1.add(t6);
		
		b1 = new JButton(" ADD ");
		b1.setFont(new Font("Serif",Font.BOLD,20));
		b1.setForeground(Color.green);
		b1.setBackground(Color.black);
		b1.setBounds(440,380,140,30);
		b1.addActionListener(this);
		p1.add(b1);
		
		b2 = new JButton(" CANCEL ");
		b2.setFont(new Font("Serif",Font.BOLD,20));
		b2.setForeground(Color.black);
		b2.setBackground(Color.red);
		b2.setBounds(590,380,140,30);
		b2.addActionListener(this);
		p1.add(b2);
		
		this.add(p1);
	}
    public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==b1)
			{
				String[] fmInfo = new String[6];
                fmInfo[0] = t1.getText();
                fmInfo[1] = t2.getText();
                fmInfo[2] = t3.getText();
                fmInfo[3] = t4.getText();
                fmInfo[4] = t5.getText();
                fmInfo[5] = t6.getText();

                User fm = new User(fmInfo);
                fm.addInfo();

                AddFm f = new AddFm();
				this.setVisible(false);
				f.setVisible(true);
			}
			else if(ae.getSource()==b2)
			{
				//System.exit(0);
				ExeDashboard exd = new ExeDashboard(ADMIN_ID);
				this.setVisible(false);
				exd.setVisible(true);
			}
			
		}
		public void setAdminId(String Id){
			this.ADMIN_ID = Id;
		}

    public static void main(String[] args){
        AddFm a = new AddFm();
        a.show();
    }
}