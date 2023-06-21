package guiprogram.bill;


import guiprogram.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import guiprogram.operation.*;

//pay bill
public class PayBill extends JFrame implements ActionListener 
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JButton b1,b2;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	JPanel p1;
	
    private String customerId;

    public PayBill(){}

	public PayBill(String customerId)
	{
		super(" Electricity Billing System ");
		this.setSize(650,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //showing approved particular bill starting
        this.customerId = customerId;
        FileOperation fo = new FileOperation("approved-bill.txt");
        String[] rows = fo.getData();

        String uname = "";
        String issueDate = "";
        String dueDate = "";
        String meter = "";
        String totalBill = "";
        String month = "";

        for(int i=0; rows[i] != null; i++){
            String[] fields = new String[8];
            fields = rows[i].split("\t");
            
            if(fields[0].equals(customerId)){
                if(fields.length == 2){
					uname = "Empty";
					issueDate = "Empty";
					dueDate = "Empty";
					meter = "Empty";
					totalBill = "Empty";
					month = "Empty";
            	}else{
					uname = fields[1];
					issueDate = fields[4];
					dueDate = fields[5];
					meter = fields[2];
					totalBill = fields[3];
					month = fields[6];
            	}
        	}
		}
        //showing approved particular bill ending
		
		p1 = new JPanel();
		p1.setSize(new Dimension(650,600));
		p1.setBackground(Color.GRAY);
		p1.setLayout(null);
		
		l1 = new JLabel("                         ELECTRICITY  BILL           ");
		l1.setFont(new Font("Serif",Font.ITALIC,25));
		l1.setBackground(Color.BLUE);
		l1.setOpaque(true);
		l1.setForeground(Color.black);
		l1.setBounds(1,25,649,50);
		p1.add(l1);
		
		l2 = new JLabel("   Name              :");
		l2.setFont(new Font("Serif",Font.BOLD,15));
		l2.setBackground(Color.black);
		l2.setOpaque(true);
		l2.setForeground(Color.white);
		l2.setBounds(10,120,130,30);
		p1.add(l2);
		
		l3 = new JLabel("  Issue Date       :");
		l3.setFont(new Font("Serif",Font.BOLD,15));
		l3.setBackground(Color.black);
		l3.setOpaque(true);
		l3.setForeground(Color.white);
		l3.setBounds(10,165,130,30);
		p1.add(l3);
		
		l4 = new JLabel("  Due Date         :");
		l4.setFont(new Font("Serif",Font.BOLD,15));
		l4.setBackground(Color.black);
		l4.setOpaque(true);
		l4.setForeground(Color.white);
		l4.setBounds(10,210,130,30);
		p1.add(l4);
		
		l5 = new JLabel("  Meter No.        :");
		l5.setFont(new Font("Serif",Font.BOLD,15));
		l5.setBackground(Color.black);
		l5.setOpaque(true);
		l5.setForeground(Color.white);
		l5.setBounds(10,255,130,30);
		p1.add(l5);
		
		
		/*l6 = new JLabel("  Previous Dues  :");
		l6.setFont(new Font("Serif",Font.BOLD,15));
		l6.setBackground(Color.black);
		l6.setOpaque(true);
		l6.setForeground(Color.white);
		l6.setBounds(10,260,150,30);
		p1.add(l6);*/
		
		l7 = new JLabel("    ID                   :");
		l7.setFont(new Font("Serif",Font.BOLD,15));
		l7.setBackground(Color.black);
		l7.setOpaque(true);
		l7.setForeground(Color.white);
		l7.setBounds(10,300,130,30);
		p1.add(l7);
		
		l8 = new JLabel("   Total Bill          :");
		l8.setFont(new Font("Serif",Font.BOLD,15));
		l8.setBackground(Color.black);
		l8.setOpaque(true);
		l8.setForeground(Color.white);
		l8.setBounds(10,345,130,30);
		p1.add(l8);
		
		l9 = new JLabel("  Billing Month   :");
		l9.setFont(new Font("Serif",Font.BOLD,15));
		l9.setBackground(Color.black);
		l9.setOpaque(true);
		l9.setForeground(Color.white);
		l9.setBounds(10,390,130,30);
		p1.add(l9);
		
		t1 = new JTextField();
		t1.setBounds(200,120,150,30);
		t1.setText(uname);
		p1.add(t1);
		
		t2 = new JTextField();
		t2.setBounds(200,165,150,30);
        t2.setText(issueDate);
		p1.add(t2);
		
		t3 = new JTextField();
		t3.setBounds(200,210,150,30);
        t3.setText(dueDate);
		p1.add(t3);
		
		t4 = new JTextField();
		t4.setBounds(200,255,150,30);
        t4.setText(meter);
		p1.add(t4);
		
		/*t5 = new JTextField();
		t5.setBounds(200,260,150,30);
		p1.add(t5);*/
		
		t6 = new JTextField();
		t6.setBounds(200,300,150,30);
        t6.setText(customerId);
		p1.add(t6);
		
		t7 = new JTextField();
		t7.setBounds(200,345,150,30);
        t7.setText(totalBill);
		p1.add(t7);
		
		t8 = new JTextField();
		t8.setBounds(200,390,150,30);
        t8.setText(month);
		p1.add(t8);
		
		b1 = new JButton(" Pay Bill ");
		b1.setFont(new Font("Serif",Font.BOLD,20));
		b1.setForeground(Color.black);
		b1.setBackground(Color.red);
		b1.setBounds(450,100,120,150);
		b1.addActionListener(this);
		p1.add(b1);
		
		b2 = new JButton(" Cancel ");
		b2.setFont(new Font("Serif",Font.BOLD,20));
		b2.setForeground(Color.black);
		b2.setBackground(Color.red);
		b2.setBounds(450,290,120,150);
		b2.addActionListener(this);
		p1.add(b2);
		
		
		this.add(p1);
	}
    public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==b1)
			{
				//pay bill
                Bill b = new Bill(customerId);
                b.payBill();

				PayMsg h = new PayMsg(customerId);
				this.setVisible(false);
				h.setVisible(true);
                
			}
			else if(ae.getSource()==b2)
			{
                //System.exit(0);
				CusDashboard k = new CusDashboard(customerId);
				this.setVisible(false);
				k.setVisible(true);
			}
		}
        public static void main(String[] args){
            PayBill pb = new PayBill("1");
            pb.show();
        }
}