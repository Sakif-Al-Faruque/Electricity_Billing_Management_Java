package guiprogram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import guiprogram.display.*;
import guiprogram.bill.*;
import guiprogram.user.*;

//customer dashboard
public class CusDashboard extends JFrame implements ActionListener 
{
	JLabel l1,l2;
	JButton b1,b2,b3;
	JPanel p1;
	private String CUSTOMER_ID = "";
	
	public CusDashboard(){}
	public CusDashboard(String CUSTOMER_ID)
	{
		super(" Electricity Billing System ");
		this.setSize(650,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//upgraded part started
		this.CUSTOMER_ID = CUSTOMER_ID;
		User c = new User();
		String[] info = c.showParticularInfo("customer", CUSTOMER_ID);
		/*for(int m=0; m<cusInfo.length; m++){
			System.out.println(cusInfo[m]);
		}*/
		//upgraded part ended

		p1 = new JPanel();
		p1.setSize(new Dimension(650,600));
		p1.setBackground(Color.LIGHT_GRAY);
		p1.setLayout(null);
		
		l1 = new JLabel("               CUSOTMER  DASHBOARD                ");
		l1.setFont(new Font("Serif",Font.ITALIC,30));
		l1.setBackground(Color.RED);
		l1.setOpaque(true);
		l1.setForeground(Color.WHITE);
		l1.setBounds(1,80,650,50);
		p1.add(l1);
		
		b1 = new JButton(" SHOW PROFILE ");
		b1.setFont(new Font("Serif",Font.BOLD,20));
		b1.setForeground(Color.black);
		b1.setBackground(Color.cyan);
		b1.setBounds(50,180,250,100);
		b1.addActionListener(this);
		p1.add(b1);
		
		b2 = new JButton(" PAY BILL ");
		b2.setFont(new Font("Serif",Font.BOLD,18));
		b2.setForeground(Color.black);
		b2.setBackground(Color.cyan);
		b2.setBounds(320,180,250,100);
		b2.addActionListener(this);
		p1.add(b2);
		
		
		b3 = new JButton("LOGOUT");
		b3.setFont(new Font("Serif",Font.BOLD,20));
		b3.setForeground(Color.white);
		b3.setBackground(Color.black);
		b3.setBounds(320,310,250,100);
		b3.addActionListener(this);
		p1.add(b3);
		
		l2 = new JLabel("                                                                                                Customer: "+info[1]);
		l2.setFont(new Font("Serif",Font.ITALIC,15));
		l2.setBackground(Color.black);
		l2.setOpaque(true);
		l2.setForeground(Color.WHITE);
		l2.setBounds(1,490,650,30);
		p1.add(l2);
		
		this.add(p1);		
	}
    public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==b1)
			{
				//show profile
				ShowCusProfile s = new ShowCusProfile(CUSTOMER_ID);
        		s.setId(CUSTOMER_ID);
				//s.setAdminId(CUSTOMER_ID);
				this.setVisible(false);
				s.setVisible(true);
			}
			else if(ae.getSource()==b2)
			{
				//pay bill
				PayBill pb = new PayBill(CUSTOMER_ID);
				this.setVisible(false);
				pb.setVisible(true);
			}
			else if(ae.getSource()==b3)
			{
				CusLogin f = new CusLogin();
				this.setVisible(false);
				f.setVisible(true);
			}
		}
		public void setId(String Id){
			this.CUSTOMER_ID = Id;
		}
        public static void main(String[] args){
            CusDashboard k = new CusDashboard("1");
            k.show();
        }
}