package guiprogram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import guiprogram.adduser.*;
import guiprogram.display.*;
import guiprogram.bill.*;
import guiprogram.user.*;

//Executive engineer dashboard
public class ExeDashboard extends JFrame implements ActionListener 
{
	JLabel l1,l2;
	JButton b1,b2,b3,b4;
	JPanel p1,p2;
	private String EXECUTIVE_ENGINEER_ID = "";

	public ExeDashboard(){}
	public ExeDashboard(String EXECUTIVE_ENGINEER_ID)
	{
		
		super(" Electricity Billing System ");
		this.setSize(650,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.EXECUTIVE_ENGINEER_ID = EXECUTIVE_ENGINEER_ID;
		User c = new User();
		String[] info = c.showParticularInfo("executive engineer", EXECUTIVE_ENGINEER_ID);

		p1 = new JPanel();
		p1.setSize(new Dimension(650,600));
		p1.setBackground(Color.LIGHT_GRAY);
		p1.setLayout(null);
		
		l1 = new JLabel("            EXECUTIVE  ENGINEER  DASHBOARD   ");
		l1.setFont(new Font("Serif",Font.ITALIC,25));
		l1.setBackground(Color.RED);
		l1.setOpaque(true);
		l1.setForeground(Color.WHITE);
		l1.setBounds(1,80,650,50);
		p1.add(l1);
		
		b1 = new JButton(" APPROVE BILL ");
		b1.setFont(new Font("Serif",Font.BOLD,15));
		b1.setForeground(Color.black);
		b1.setBackground(Color.cyan);
		b1.setBounds(50,190,230,80);
		b1.addActionListener(this);
		p1.add(b1);
		
		b2 = new JButton(" FIELD MANEGER INFO ");
		b2.setFont(new Font("Serif",Font.BOLD,15));
		b2.setForeground(Color.black);
		b2.setBackground(Color.cyan);
		b2.setBounds(300,190,230,80);
		b2.addActionListener(this);
		p1.add(b2);
		
		b3 = new JButton(" ADD FIELD MANEGER ");
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

		l2 = new JLabel("                                                                                      Executive Engineer: "+info[1]);
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
				//approve bill
				//System.out.println(EXECUTIVE_ENGINEER_ID);
				BillApproval ba = new BillApproval();
				ba.setAdminId(EXECUTIVE_ENGINEER_ID);
				this.setVisible(false);
				ba.setVisible(true);
				
			}
			else if(ae.getSource()==b2)
			{
				//field maneger info
				System.out.println("fm info");
				ShowAllFm fm = new ShowAllFm();
				fm.setAdminId(EXECUTIVE_ENGINEER_ID);
				this.setVisible(false);
				fm.setVisible(true);
				
			}
			else if(ae.getSource()==b3)
			{
				//add field maneger
				System.out.println("add fm info");
				AddFm a = new AddFm();
				a.setAdminId(EXECUTIVE_ENGINEER_ID);
				this.setVisible(false);
				a.setVisible(true);
			}
            else if(ae.getSource()==b4)
			{
				ExeLogin f = new ExeLogin();
				this.setVisible(false);
				f.setVisible(true);
			}
			
		}
		//set id
		public void setId(String Id){
			this.EXECUTIVE_ENGINEER_ID = Id;
		}
        public static void main(String[] args){
            ExeDashboard f = new ExeDashboard("10");
            f.show();
        }
}