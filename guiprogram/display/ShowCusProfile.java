package guiprogram.display;

import guiprogram.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import guiprogram.user.*;

//showing customer info
public class ShowCusProfile extends JFrame implements ActionListener
{
		JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
		JButton b1,b2; 
		JTextField t1,t2,t3,t4,t5;
		JPanel p1;
        private String CUSTOMER_ID = "";
        private String ADMIN_ID = "";

		public ShowCusProfile(){}
		
	public ShowCusProfile(String Id)
	{
		super(" Electricity Billing System ");
		this.setSize(750,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.CUSTOMER_ID = Id;

        //user operation started
        String[] customerInfo = new String[7];
        User c = new User();
        customerInfo = c.showParticularInfo("customer", CUSTOMER_ID);
        //user operation ended

		p1 = new JPanel();
		p1.setSize(new Dimension(750,500));
		p1.setBackground(Color.LIGHT_GRAY);
		p1.setLayout(null);
		
		l1 = new JLabel("                           PROFILE  DETAILS  ");
		l1.setFont(new Font("Serif",Font.ITALIC,25));
		l1.setBackground(Color.blue);
		l1.setOpaque(true);
		l1.setForeground(Color.black);
		l1.setBounds(1,30,750,40);
		p1.add(l1);
		
		l2 = new JLabel("   USER NAME             :  ");
		l2.setFont(new Font("Serif",Font.BOLD,15));
		l2.setBackground(Color.DARK_GRAY);
		l2.setOpaque(true);
		l2.setForeground(Color.white);
		l2.setBounds(80,90,180,20);
		p1.add(l2);
		      
		l3 = new JLabel("     METER NO             :  ");
		l3.setFont(new Font("Serif",Font.BOLD,15));
		l3.setBackground(Color.DARK_GRAY);
		l3.setOpaque(true);
		l3.setForeground(Color.white);
		l3.setBounds(80,130,180,20);
		p1.add(l3);
		
		l4 = new JLabel("    ADDRESS                 :  ");
		l4.setFont(new Font("Serif",Font.BOLD,15));
		l4.setBackground(Color.DARK_GRAY);
		l4.setOpaque(true);
		l4.setForeground(Color.white);
		l4.setBounds(80,170,180,20);
		p1.add(l4);
		
		l5 = new JLabel("     ID NO                       :  ");
		l5.setFont(new Font("Serif",Font.BOLD,15));
		l5.setBackground(Color.DARK_GRAY);
		l5.setOpaque(true);
		l5.setForeground(Color.white);
		l5.setBounds(80,210,180,20);
		p1.add(l5);
		
		l6 = new JLabel("  REGISTERED DATE  :");
		l6.setFont(new Font("Serif",Font.BOLD,15));
		l6.setBackground(Color.DARK_GRAY);
		l6.setOpaque(true);
		l6.setForeground(Color.white);
		l6.setBounds(80,255,185,20);
		p1.add(l6);
		
		l7 = new JLabel(" "+customerInfo[1]+"  ");
		l7.setFont(new Font("Serif",Font.BOLD,15));
		l7.setBackground(Color.red);
		l7.setOpaque(true);
		l7.setForeground(Color.white);
		l7.setBounds(360,90,200,25);
		p1.add(l7);
		
		l8 = new JLabel(" "+customerInfo[6]+"  ");
		l8.setFont(new Font("Serif",Font.BOLD,15));
		l8.setBackground(Color.red);
		l8.setOpaque(true);
		l8.setForeground(Color.white);
		l8.setBounds(360,130,200,25);
		p1.add(l8);
		
		l9 = new JLabel(" "+customerInfo[4]+"  ");
		l9.setFont(new Font("Serif",Font.BOLD,15));
		l9.setBackground(Color.red);
		l9.setOpaque(true);
		l9.setForeground(Color.white);
		l9.setBounds(360,170,200,25);
		p1.add(l9);
		
		l10 = new JLabel(" "+customerInfo[0]+"  ");
		l10.setFont(new Font("Serif",Font.BOLD,15));
		l10.setBackground(Color.red);
		l10.setOpaque(true);
		l10.setForeground(Color.white);
		l10.setBounds(360,210,200,25);
		p1.add(l10);
		
		l11 = new JLabel(" "+customerInfo[5]+"  ");
		l11.setFont(new Font("Serif",Font.BOLD,15));
		l11.setBackground(Color.red);
		l11.setOpaque(true);
		l11.setForeground(Color.white);
		l11.setBounds(360,250,200,25);
		p1.add(l11);
		
		
		b1 = new JButton(" Exit ");
		b1.setFont(new Font("Serif",Font.BOLD,20));
		b1.setForeground(Color.black);
		b1.setBackground(Color.GREEN);
		b1.setBounds(150,320,350,40);
		b1.addActionListener(this);
		p1.add(b1);
		
		this.add(p1);
	}
    public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==b1)
			{
				//System.exit(0);
				CusDashboard k = new CusDashboard(CUSTOMER_ID);
				this.setVisible(false);
				k.setVisible(true);
			}
		}
    //set id
    public void setId(String Id){
		this.CUSTOMER_ID = Id;
	}
	/*public void setAdminId(String Id){
		this.ADMIN_ID = Id;
	}*/
    public static void main(String[] args){
        ShowCusProfile s = new ShowCusProfile("1");
        s.setId("1");
        s.show();
    }
}