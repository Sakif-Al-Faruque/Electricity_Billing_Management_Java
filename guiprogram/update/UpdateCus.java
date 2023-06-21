package guiprogram.update;

import guiprogram.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import guiprogram.operation.*;
import guiprogram.user.*;


//adding field maneger
public class UpdateCus extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5, l6, l7, l8;
	JButton b1,b2; 
	JTextField t1,t2,t3,t4, t5, t6, t7;
	JPanel p1;
    private String CUSTOMER_ID = "";
    private String ADMIN_ID = "";
    
	public UpdateCus(){}

	public UpdateCus(String Id)
	{	
		super(" Electricity Billing System ");
		this.setSize(750,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.CUSTOMER_ID = Id;

        //user operation started
		System.out.println(CUSTOMER_ID);
        User csg = new User();
        String[] preCusInfo = new String[7];
        preCusInfo = csg.showParticularInfo("customer", CUSTOMER_ID);

		String id = "";
		String uname = "";
		String pass = "";
		String nid = "";
		String addr = "";
		String regD = "";
		String met = "";

		if(preCusInfo.length == 2){
			id = preCusInfo[0];
			uname = preCusInfo[1];
			pass = "Empty";
			nid = "Empty";
			addr = "Empty";
			regD = "Empty";
			met = "Empty";
		}else{
			id = preCusInfo[0];
			uname = preCusInfo[1];
			pass = preCusInfo[2];
			nid = preCusInfo[3];
			addr = preCusInfo[4];
			regD = preCusInfo[5];
			met = preCusInfo[6];
		}

        //user operation ended
		
		p1 = new JPanel();
		p1.setSize(new Dimension(750,500));
		p1.setBackground(Color.LIGHT_GRAY);
		p1.setLayout(null);
		
		l1 = new JLabel("                       UPDATE  CUSTOMER  INFO  ");
		l1.setFont(new Font("Serif",Font.ITALIC,25));
		l1.setBackground(Color.DARK_GRAY);
		l1.setOpaque(true);
		l1.setForeground(Color.WHITE);
		l1.setBounds(1,30,750,40);
		p1.add(l1);
		
		l2 = new JLabel("  ID                                   :  ");
		l2.setFont(new Font("Serif",Font.BOLD,15));
		l2.setForeground(Color.black);
		l2.setBounds(80,90,250,20);
		p1.add(l2);
		
		l3 = new JLabel("  USERNAME                  :  ");
		l3.setFont(new Font("Serif",Font.BOLD,15));
		l3.setForeground(Color.black);
		l3.setBounds(80,130,250,20);
		p1.add(l3);
		
		l4 = new JLabel("  PASSWORD                  :  ");
		l4.setFont(new Font("Serif",Font.BOLD,15));
		l4.setForeground(Color.black);
		l4.setBounds(80,170,250,20);
		p1.add(l4);
		
		l5 = new JLabel("  NID                                 :  ");
		l5.setFont(new Font("Serif",Font.BOLD,15));
		l5.setForeground(Color.black);
		l5.setBounds(80,210,250,20);
		p1.add(l5);

        l6 = new JLabel("  ADDRESS                      :  ");
		l6.setFont(new Font("Serif",Font.BOLD,15));
		l6.setForeground(Color.black);
		l6.setBounds(80,250,250,20);
		p1.add(l6);

        l7 = new JLabel("  REGISTERED DATE    :  ");
		l7.setFont(new Font("Serif",Font.BOLD,15));
		l7.setForeground(Color.black);
		l7.setBounds(80,290,250,20);
		p1.add(l7);

        l8 = new JLabel("  METER NO                   :  ");
		l8.setFont(new Font("Serif",Font.BOLD,15));
		l8.setForeground(Color.black);
		l8.setBounds(80,330,250,20);
		p1.add(l8);
		
		t1 = new JTextField();
		t1.setBounds(360,90,250,25);
        t1.setText(id+"  (Not changable)");
		p1.add(t1);

		t2 = new JTextField();
		t2.setBounds(360,130,250,25);
        t2.setText(uname);
		p1.add(t2);
		
		t3 = new JTextField();
		t3.setBounds(360,170,250,25);
        t3.setText(pass);
		p1.add(t3);

		t4 = new JTextField();
		t4.setBounds(360,210,250,25);
        t4.setText(nid);
		p1.add(t4);

        t5 = new JTextField();
		t5.setBounds(360,250,250,25);
        t5.setText(addr);
		p1.add(t5);

        t6 = new JTextField();
		t6.setBounds(360,290,250,25);
        t6.setText(regD);
		p1.add(t6);

        t7 = new JTextField();
		t7.setBounds(360,330,250,25);
        t7.setText(met);
		p1.add(t7);
		
		b1 = new JButton(" UPDATE ");
		b1.setFont(new Font("Serif",Font.BOLD,20));
		b1.setForeground(Color.white);
		b1.setBackground(Color.DARK_GRAY);
		b1.setBounds(400,370,140,30);
		b1.addActionListener(this);
		p1.add(b1);
		
		b2 = new JButton(" CANCEL ");
		b2.setFont(new Font("Serif",Font.BOLD,20));
		b2.setForeground(Color.white);
		b2.setBackground(Color.red);
		b2.setBounds(570,370,140,30);
		b2.addActionListener(this);
		p1.add(b2);
		
		this.add(p1);
	}
    public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==b1)
			{
				String[] csInfo = new String[6];
                csInfo[0] = t2.getText();
                csInfo[1] = t3.getText();
                csInfo[2] = t4.getText();
                csInfo[3] = t5.getText();
                csInfo[4] = t6.getText();
                csInfo[5] = t7.getText();

                System.out.println("Hello");
                for(int i=0; i<6; i++){
                    System.out.println(csInfo[i]);
                }

                User cs = new User(csInfo);
                cs.updateInfo("customer", CUSTOMER_ID, csInfo);

                UpdateCus f = new UpdateCus(CUSTOMER_ID);
				f.setAdminId(ADMIN_ID);
				this.setVisible(false);
				f.setVisible(true);
			}
			else if(ae.getSource()==b2)
			{
				//System.exit(0);
				FmDashboard f = new FmDashboard(ADMIN_ID);
				this.setVisible(false);
				f.setVisible(true);
			}
			
		}
    //set id
    /*public void setId(String Id){
		this.CUSTOMER_ID = Id;
	}*/
	public void setAdminId(String Id){
			this.ADMIN_ID = Id;
	}
    public static void main(String[] args){
        UpdateCus a = new UpdateCus("2");
        //a.setId();
        a.show();
    }
}