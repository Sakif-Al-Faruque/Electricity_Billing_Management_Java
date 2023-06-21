package guiprogram.bill;

import guiprogram.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//issue bill to upapproval data list
public class IssueBill extends JFrame implements ActionListener 
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
	JButton b1,b2,b3;
	JTextField t1,t2,t3,t4,t5,t6,t7,t9,t10,t11;
	JPanel p1,p2,p3;
    Bill b;

	private String ADMIN_ID;
	
	public IssueBill()
	{
		super(" Electricity Billing System ");
		this.setSize(650,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        //bill info getting started
        String totalBill = "0";
        String previousBill = "";
        String meterNo = "";
        

        /*if(b != null){
            totalBill = b.getTotalDues();

            String[] billFields = new String[3];
            for(int i=0; b.showParticularBill()[i] != null; i++){
                billFields = b.showParticularBill()[i].split("\t");
            }

            previousBill = billFields[1];
            meterNo = billFields[0];
        }*/
        //bill info getting ended

		p1 = new JPanel();
		p1.setSize(new Dimension(650,70));
		p1.setBackground(Color.LIGHT_GRAY);
		p1.setLayout(null);
		
		l1 = new JLabel("                      BILLING  SYSTEM                ");
		l1.setFont(new Font("Serif",Font.ITALIC,30));
		l1.setBackground(Color.DARK_GRAY);
		l1.setOpaque(true);
		l1.setForeground(Color.WHITE);
		l1.setBounds(1,20,640,40);
		p1.add(l1);
		
		p2 = new JPanel();
		p2.setSize(new Dimension(350,590));
		p2.setBackground(Color.WHITE);
		p2.setLayout(null);
		
		l2 = new JLabel(" Customer Id    :");
		l2.setFont(new Font("Serif",Font.BOLD,15));
		l2.setForeground(Color.black);
		l2.setBounds(10,100,180,30);
		p2.add(l2);
		
		/*l3 = new JLabel("Previous Dues(Not Req*)   :");
		l3.setFont(new Font("Serif",Font.BOLD,15));
		l3.setForeground(Color.black);
		l3.setBounds(10,118,181,30);
		p2.add(l3);*/
		
		l4 = new JLabel(" Recent Dues    :");
		l4.setFont(new Font("Serif",Font.BOLD,15));
		l4.setForeground(Color.black);
		l4.setBounds(10,140,180,30);
		p2.add(l4);
		
		l5 = new JLabel(" Issue  Date       :");
		l5.setFont(new Font("Serif",Font.BOLD,15));
		l5.setBackground(Color.WHITE);
		l5.setOpaque(true);
		l5.setForeground(Color.black);
		l5.setBounds(10,180,180,30);
		p2.add(l5);
		
		l6 = new JLabel(" Due Date          :");
		l6.setFont(new Font("Serif",Font.BOLD,15));
		l6.setBackground(Color.WHITE);
		l6.setOpaque(true);
		l6.setForeground(Color.black);
		l6.setBounds(10,220,180,30);
		p2.add(l6);
		
		l7 = new JLabel(" Billing Month   :");
		l7.setFont(new Font("Serif",Font.BOLD,15));
		l7.setBackground(Color.WHITE);
		l7.setOpaque(true);
		l7.setForeground(Color.black);
		l7.setBounds(10,260,180,30);
		p2.add(l7);
		
        
        /*l8 = new JLabel("Total Bill            :");
        l8.setFont(new Font("Serif",Font.BOLD,15));
        l8.setBackground(Color.WHITE);
        l8.setOpaque(true);
        l8.setForeground(Color.black);
        l8.setBounds(10,300,180,30);
        p2.add(l8);
            
        l9 = new JLabel(totalBill+" $"); //here the total bill variable
        l9.setFont(new Font("Serif",Font.BOLD,15));
        l9.setBackground(Color.WHITE);
        l9.setOpaque(true);
        l9.setForeground(Color.black);
        //l9.setBounds(200,346,100,30);
        l9.setBounds(230,300,100,30);
        p2.add(l9);*/
        
		
		
		t1 = new JTextField();
		t1.setBounds(200,100,100,30);
		p2.add(t1);
		
		/*t2 = new JTextField();
		t2.setBounds(200,118,100,30);
        t2.setText(previousBill);
		p2.add(t2);*/
		
		t2 = new JTextField();
		t2.setBounds(200,140,100,30);
		p2.add(t2);
		
		t3 = new JTextField();
		t3.setBounds(200,180,100,30);
		p2.add(t3);
		
		t4 = new JTextField();
		t4.setBounds(200,220,100,30);
		p2.add(t4);
		
		t5 = new JTextField();
		t5.setBounds(200,260,100,30);
		p2.add(t5);
		
		/*t6 = new JTextField();
		t6.setBounds(200,300,100,30);
		p2.add(t6);*/
		
		p3 = new JPanel();
		p3.setSize(new Dimension(250,500));
		p3.setBackground(Color.DARK_GRAY);
		p3.setLayout(null);
		
		/*l10 = new JLabel(" DETAILS ");
		l10.setFont(new Font("Serif",Font.BOLD,25));
		l10.setBackground(Color.black);
		l10.setOpaque(true);
		l10.setForeground(Color.white);
		l10.setBounds(400,130,200,40);
		p3.add(l10);*/
		
		/*l11 = new JLabel(" Meter No.        : ");
		l11.setFont(new Font("Serif",Font.BOLD,15));
		l11.setForeground(Color.white);
		l11.setBounds(370,195,120,20);
		p3.add(l11);
		
		l12 = new JLabel("Previous Dues   : ");
		l12.setFont(new Font("Serif",Font.BOLD,15));
		l12.setForeground(Color.white);
		l12.setBounds(370,225,120,20);
		p3.add(l12);
		
		t9 = new JTextField();
		t9.setBounds(520,195,100,20);
		t9.setText(meterNo);
		p3.add(t9);
		
		t10 = new JTextField();
		t10.setBounds(520,225,100,20);
        t10.setText(previousBill);
		p3.add(t10);*/
		
		
		b1 = new JButton("Show More Details>>");
		b1.setFont(new Font("Serif",Font.BOLD,18));
		b1.setForeground(Color.black);
		b1.setBackground(Color.red);
		b1.setBounds(380,180,220,120);
		b1.addActionListener(this);
		p3.add(b1);
		
		b2 = new JButton("Request For Approval");
		b2.setFont(new Font("Serif",Font.BOLD,16));
		b2.setForeground(Color.black);
		b2.setBackground(Color.yellow);
		b2.setBounds(120,450,200,60);
		b2.addActionListener(this);
		p2.add(b2);
		
		b3 = new JButton("Cancel");
		b3.setFont(new Font("Serif",Font.BOLD,15));
		b3.setForeground(Color.blue);
		b3.setBackground(Color.black);
		b3.setBounds(450,490,150,40);
		b3.addActionListener(this);
		p3.add(b3);
		
		this.add(p1);
		this.add(p2);
		this.add(p3);
		
	}
    public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==b1)
			{
				//Show More Details
				String customerId = t1.getText();

                //send this id to Customer Details Bill Table
				CusBillDetails cbd = new CusBillDetails(customerId);
				cbd.setAdminId(ADMIN_ID);
				this.setVisible(false);
				cbd.setVisible(true);
				
			}
			else if(ae.getSource()==b2)
			{
				//Request For Approval
                System.out.println("hello");
                String customerId = t1.getText();

                String[] info = new String[4];
                info[0] = t2.getText();
                info[1] = t3.getText();
                info[2] = t4.getText();
                info[3] = t5.getText();

				b = new Bill(customerId);
				b.issueBill(info);

                this.setVisible(false);
				this.setVisible(true);
			}
			else if(ae.getSource()==b3)
			{
				//Cancel
                //System.exit(0);
				FmDashboard f = new FmDashboard(ADMIN_ID);
				this.setVisible(false);
				f.setVisible(true);

				
			}
		}
		public void setAdminId(String Id){
			this.ADMIN_ID = Id;
		}
    public static void main(String[] args){
        IssueBill ib = new IssueBill();
        ib.show();
    }
}