package guiprogram.bill;

import guiprogram.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import guiprogram.user.*;
import guiprogram.operation.*;

//month with customer details 
public class CusBillDetails extends JFrame implements ActionListener 
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	JButton b1;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
	JPanel p1,p2; 
	JTable tab;
	
	private String ADMIN_ID;

    public CusBillDetails(){}

	public CusBillDetails(String customerId)
	{

		super(" Electricity Billing System ");
		this.setSize(650,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //fetch customer details beginning
		User u = new User();
		String[] partCusDet = new String[7];
		partCusDet = u.showParticularInfo("customer", customerId);

		String uname = "";
		String regD = "";
		String met = "";
		String addr = "";
		String nid = "";

		if(partCusDet.length == 2){
			uname = "Empty";
			regD = "Empty";
			met = "Empty";
			addr = "Empty";
			nid = "Empty";
		}else{
			uname = partCusDet[1];
			regD = partCusDet[5];
			met = partCusDet[6];
			addr = partCusDet[4];
			nid = partCusDet[3];
		}
        //fetch customer details ending
		
		p1 = new JPanel();
		p1.setSize(new Dimension(350,590));
		p1.setBackground(Color.GRAY);
		p1.setLayout(null);
		
		l1 = new JLabel("  CUSTOMER DETAILS ");
		l1.setFont(new Font("Serif",Font.BOLD,25));
		l1.setBackground(Color.DARK_GRAY);
		l1.setOpaque(true);
		l1.setForeground(Color.magenta);
		l1.setBounds(15,25,300,50);
		p1.add(l1);
		
		
		l2 = new JLabel(" Name                :");
		l2.setFont(new Font("Serif",Font.BOLD,15));
		l2.setForeground(Color.black);
		l2.setBounds(10,100,180,30);
		p1.add(l2);
		
		l3 = new JLabel(" Register Date   :");
		l3.setFont(new Font("Serif",Font.BOLD,15));
		l3.setForeground(Color.black);
		l3.setBounds(10,138,181,30);
		p1.add(l3);
		
		l4 = new JLabel(" Meter No.         :");
		l4.setFont(new Font("Serif",Font.BOLD,15));
		l4.setForeground(Color.black);
		l4.setBounds(10,176,180,30);
		p1.add(l4);
		
		l5 = new JLabel("Address              :");
		l5.setFont(new Font("Serif",Font.BOLD,15));
		l5.setForeground(Color.black);
		l5.setBounds(10,214,180,30);
		p1.add(l5);
		
		l6 = new JLabel("NID                    :");
		l6.setFont(new Font("Serif",Font.BOLD,15));
		l6.setForeground(Color.black);
		l6.setBounds(10,252,196,30);
		p1.add(l6);
		
		t1 = new JTextField();
		t1.setBounds(200,100,100,30);
		t1.setText(uname);
		p1.add(t1);
		
		t2 = new JTextField();
		t2.setBounds(200,138,100,30);
		t2.setText(regD);
		p1.add(t2);
		
		t3 = new JTextField();
		t3.setBounds(200,176,100,30);
		t3.setText(met);
		p1.add(t3);
		
		t4 = new JTextField();
		t4.setBounds(200,214,100,30);
		t4.setText(addr);
		p1.add(t4);
		
		t5 = new JTextField();
		t5.setBounds(200,252,100,30);
		t5.setText(nid);
		p1.add(t5);
		
		
		p2 = new JPanel();
		p2.setSize(new Dimension(250,590));
		p2.setBackground(Color.LIGHT_GRAY);
		p2.setLayout(null);
		
		l7 = new JLabel("  BILLING MONTHS ");
		l7.setFont(new Font("Serif",Font.BOLD,22));
		l7.setBackground(Color.DARK_GRAY);
		l7.setOpaque(true);
		l7.setForeground(Color.cyan);
		l7.setBounds(380,65,220,35);
		p2.add(l7);
		
		//get data from file stating
        FileOperation fo = new FileOperation("customer/"+customerId+".txt");
        String[] cusInfoRows = fo.getData();
        //get data from file ending

		//bill month table stated
        String[] column =  new String[3];
        String[] cusInfoFieldData  =  new String[3];

        column[0] = "Meter No.";
        column[1] = "Dues";
        column[2] = "Month";
        
        String[][] data = new String[100][3];
        
        for(int i=0; cusInfoRows[i] != null; i++){

            cusInfoFieldData = cusInfoRows[i].split("\t");
            
            data[i][0] = cusInfoFieldData[0];
            data[i][1] = cusInfoFieldData[1];
            data[i][2] = cusInfoFieldData[2];  
        }
        
        
        tab = new JTable(data, column);
        tab.setPreferredScrollableViewportSize(new Dimension(220, 300));
        tab.setFillsViewportHeight(true);
        
        JScrollPane jp = new JScrollPane(tab);
        jp.setBounds(380, 130, 220, 300);
        p2.add(jp);
		//bill month table ended
		
		
		
		b1 = new JButton("< Back");
		b1.setFont(new Font("Serif",Font.BOLD,20));
		b1.setForeground(Color.black);
		b1.setBackground(Color.red);
		b1.setBounds(450,450,100,50);
		b1.addActionListener(this);
		p2.add(b1);
		
		this.add(p1);
		this.add(p2);
	}
	public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==b1)
			{
				
				FmDashboard f = new FmDashboard(ADMIN_ID);
				this.setVisible(false);
				f.setVisible(true);
				
			}
		}
		public void setAdminId(String Id){
			this.ADMIN_ID = Id;
		}
    public static void main(String[] args){
        CusBillDetails cbd = new CusBillDetails("4");
        cbd.show();
    }
}