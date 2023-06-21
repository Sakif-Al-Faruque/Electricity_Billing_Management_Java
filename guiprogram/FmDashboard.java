package guiprogram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import guiprogram.adduser.*;
import guiprogram.display.*;
import guiprogram.bill.*;
import guiprogram.user.*;

//field maneger dashboard
public class FmDashboard extends JFrame implements ActionListener 
{
	JLabel l1,l2;
	JButton b1,b2,b3,b4;
	JPanel p1,p2;
	private String FIELD_MANEGER_ID = "";
	
	public FmDashboard(){}
	public FmDashboard(String FIELD_MANEGER_ID)
	{
		super(" Electricity Billing System ");
		this.setSize(650,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//upgraded part started
		this.FIELD_MANEGER_ID = FIELD_MANEGER_ID;
		User c = new User();
		String[] info = c.showParticularInfo("field-maneger", FIELD_MANEGER_ID);
		/*for(int m=0; m<cusInfo.length; m++){
			System.out.println(cusInfo[m]);
		}*/
		//upgraded part ended
		
		p1 = new JPanel();
		p1.setSize(new Dimension(650,600));
		p1.setBackground(Color.LIGHT_GRAY);
		p1.setLayout(null);
		
		l1 = new JLabel("               FIELD  MANEGER  DASHBOARD ");
		l1.setFont(new Font("Serif",Font.ITALIC,25));
		l1.setBackground(Color.RED);
		l1.setOpaque(true);
		l1.setForeground(Color.WHITE);
		l1.setBounds(1,80,6490,50);
		p1.add(l1);
		
		b1 = new JButton(" ISSUE BILL ");
		b1.setFont(new Font("Serif",Font.BOLD,15));
		b1.setForeground(Color.black);
		b1.setBackground(Color.cyan);
		b1.setBounds(50,180,230,80);
		b1.addActionListener(this);
		p1.add(b1);
		
		b2 = new JButton(" CUSTOMER INFO ");
		b2.setFont(new Font("Serif",Font.BOLD,15));
		b2.setForeground(Color.black);
		b2.setBackground(Color.cyan);
		b2.setBounds(300,180,230,80);
		b2.addActionListener(this);
		p1.add(b2);
		
		b3 = new JButton(" ADD CUSTOMER ");
		b3.setFont(new Font("Serif",Font.BOLD,15));
		b3.setForeground(Color.black);
		b3.setBackground(Color.cyan);
		b3.setBounds(50,300,230,80);
		b3.addActionListener(this);
		p1.add(b3);
		
		
		b4 = new JButton("LOGOUT");
		b4.setFont(new Font("Serif",Font.BOLD,15));
		b4.setForeground(Color.white);
		b4.setBackground(Color.black);
		b4.setBounds(300,300,230,80);
		b4.addActionListener(this);
		p1.add(b4);
		
		l2 = new JLabel("                                                                                                Field Maneger: "+info[1]);
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
				//issue bill
				IssueBill ib = new IssueBill();
				ib.setAdminId(FIELD_MANEGER_ID);
				this.setVisible(false);
				ib.setVisible(true);
			}
			else if(ae.getSource()==b2)
			{
				//Customer info
				ShowAllCus cs = new ShowAllCus();
				cs.setAdminId(FIELD_MANEGER_ID);
				this.setVisible(false);
				cs.setVisible(true);
			}
			else if(ae.getSource()==b3)
			{
				//add customer
				AddCus a = new AddCus();
				this.setVisible(false);
				a.setVisible(true);
			}
            else if(ae.getSource()==b4)
			{
				FmLogin f = new FmLogin();
				this.setVisible(false);
				f.setVisible(true);
			}
			
		}
		public void setId(String Id){
			this.FIELD_MANEGER_ID = Id;
		}
		
        public static void main(String[] args){
            FmDashboard f = new FmDashboard("3");
            f.show();
        }
}