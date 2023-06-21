package guiprogram.bill;

import guiprogram.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import guiprogram.operation.*;
import guiprogram.update.*;
import guiprogram.delete.*;

//showing unapproved bill to approve
public class BillApproval extends JFrame implements ActionListener
{
		JButton b1, b2, b3; 
		JPanel p1,p2,p3;
        JTable tab;
        JTextField t1;
        JLabel l1,l2;
		private String ADMIN_ID;
		
	public BillApproval()
	{
		super(" Electricity Billing System ");
		this.setSize(750,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p1 = new JPanel();
		p1.setSize(new Dimension(750,60));
		p1.setBackground(Color.GRAY);
		p1.setLayout(null);
		
		l1 = new JLabel("                   UNAPPROVED  BILL        ");
		l1.setFont(new Font("Serif",Font.ITALIC,25));
		l1.setBackground(Color.RED);
		l1.setOpaque(true);
		l1.setForeground(Color.WHITE);
		l1.setBounds(1,6,750,40);
		p1.add(l1);
		
		p2 = new JPanel();
		p2.setSize(new Dimension(750,400));
		p2.setBackground(Color.LIGHT_GRAY);
		//p2.setLayout(new FlowLayout());
		p2.setLayout(null);

        //get data from file stating
        Bill fo = new Bill();
        String[] billInfoRows = fo.showBill();
        //get data from file ending
		
        //table operation started
        String[] column =  new String[8];
        String[] billInfoFieldData  =  new String[8];

        column[0] = "ID";
        column[1] = "Name";
        column[2] = "Meter No";
        column[3] = "Total Bill";
        column[4] = "Issue Date";
        column[5] = "Due Date";
        column[6] = "Month";
        column[7] = "Approval";
        
        String[][] data = new String[1000][8];
        
        for(int i=0; billInfoRows[i] != null; i++){

            billInfoFieldData = billInfoRows[i].split("\t");
            if(billInfoFieldData.length == 2){
                data[i][0] = billInfoFieldData[0];
                data[i][1] = billInfoFieldData[1];
            }else{
                data[i][0] = billInfoFieldData[0];
                data[i][1] = billInfoFieldData[1];
                data[i][2] = billInfoFieldData[2];
                data[i][3] = billInfoFieldData[3];
                data[i][4] = billInfoFieldData[4];
                data[i][5] = billInfoFieldData[5];
                data[i][6] = billInfoFieldData[6];
                data[i][7] = billInfoFieldData[7];
            }
        }
        
        
        tab = new JTable(data, column);
        tab.setPreferredScrollableViewportSize(new Dimension(700, 300));
        tab.setFillsViewportHeight(true);
        
        JScrollPane jp = new JScrollPane(tab);
        jp.setBounds(20, 80, 700, 300);
        p2.add(jp);
        //table operation ended
		
		p3 = new JPanel();
		p3.setSize(new Dimension(750,150));
		p3.setBackground(Color.GRAY);
		p3.setLayout(null);
	    
		b1 = new JButton("< Back");
		b1.setFont(new Font("Serif",Font.BOLD,18));
		b1.setForeground(Color.black);
		b1.setBackground(Color.red);
		b1.setBounds(565,420,150,30);
		b1.addActionListener(this);

        l2 = new JLabel("  SELECT ID  : ");
		l2.setFont(new Font("Serif",Font.PLAIN,15));
	    l2.setBackground(Color.black);
		l2.setOpaque(true);
		l2.setForeground(Color.blue);
		l2.setBounds(15,420,100,30);
		p3.add(l2);

        t1 = new JTextField();
		t1.setBounds(125, 422, 100, 25);
		p3.add(t1);

        b2 = new JButton("APPROVE");
		b2.setFont(new Font("Serif",Font.BOLD,17));
		b2.setForeground(Color.red);
		b2.setBackground(Color.black);
		b2.setBounds(400,420,150,30);
		b2.addActionListener(this);

        /*b3 = new JButton("DELETE");
		b3.setFont(new Font("Serif",Font.BOLD,12));
		b3.setForeground(Color.black);
		b3.setBackground(Color.red);
		b3.setBounds(270,420,100,30);
		b3.addActionListener(this);*/

		p3.add(b1);
		p3.add(b2);
		//p3.add(b3);
		
		
        this.add(p1);		
        this.add(p2);
		this.add(p3);
	}

    public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==b1)
			{
				//System.exit(0);
				ExeDashboard f = new ExeDashboard(ADMIN_ID);
				this.setVisible(false);
				f.setVisible(true);
			}
			else if(ae.getSource()==b2)
			{
				String CUSTOMER_ID = t1.getText();

                Bill app = new Bill(CUSTOMER_ID);
                app.billApproval();

			}
			/*else if(ae.getSource()==b3)
			{
				String CUSTOMER_ID = t1.getText();
                
                DeleteCus dc = new DeleteCus();
                dc.setId(CUSTOMER_ID);
                this.setVisible(false);
                dc.setVisible(true);
			}*/
		}
		public void setAdminId(String Id){
			this.ADMIN_ID = Id;
		}
    public static void main(String[] args){
        BillApproval s = new BillApproval();
        s.show();
    }
}
