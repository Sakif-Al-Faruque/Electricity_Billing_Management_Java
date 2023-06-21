package guiprogram.update;

import guiprogram.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import guiprogram.operation.*;
import guiprogram.user.*;


//adding field maneger
public class UpdateFm extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5, l6, l7;
	JButton b1,b2; 
	JTextField t1,t2,t3,t4, t5, t6;
	JPanel p1;
    private String FIELD_MANEGER_ID = " ";
    private String ADMIN_ID = " ";
    
	public UpdateFm(){}

	public UpdateFm(String Id)
	{	
		super(" Electricity Billing System ");
		this.setSize(750,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.FIELD_MANEGER_ID = Id;

        //user operation started
        User fmg = new User();
        String[] preFmInfo = new String[6];
        preFmInfo = fmg.showParticularInfo("field-maneger", FIELD_MANEGER_ID);

		String id = "";
		String uname = "";
		String pass = "";
		String nid = "";
		String addr = "";
		String regD = "";

		if(preFmInfo.length == 2){
			id = preFmInfo[0];
			uname = preFmInfo[1];
			pass = "Empty";
			nid = "Empty";
			addr = "Empty";
			regD = "Empty";
		}else{
			id = preFmInfo[0];
			uname = preFmInfo[1];
			pass = preFmInfo[2];
			nid = preFmInfo[3];
			addr = preFmInfo[4];
			regD = preFmInfo[5];
		}
        //user operation ended
		
		p1 = new JPanel();
		p1.setSize(new Dimension(750,500));
		p1.setBackground(Color.LIGHT_GRAY);
		p1.setLayout(null);
		
		l1 = new JLabel("                       UPDATE  FIELD  MANAGER  INFO  ");
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
		
		t1 = new JTextField();
		t1.setBounds(360,90,250,25);
        t1.setText(id);
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
				String[] fmInfo = new String[5];
                fmInfo[0] = t2.getText();
                fmInfo[1] = t3.getText();
                fmInfo[2] = t4.getText();
                fmInfo[3] = t5.getText();
                fmInfo[4] = t6.getText();

                User cs = new User(fmInfo);
                cs.updateInfo("field-maneger", FIELD_MANEGER_ID, fmInfo);

                UpdateFm f = new UpdateFm(FIELD_MANEGER_ID);
				f.setAdminId(ADMIN_ID);
				this.setVisible(false);
				f.setVisible(true);
			}
			else if(ae.getSource()==b2)
			{
				//System.exit(0);
				ExeDashboard f = new ExeDashboard(ADMIN_ID);
				this.setVisible(false);
				f.setVisible(true);
			}
			
	}
    //set id
    /*public void setId(String Id){
		this.FIELD_MANEGER_ID = Id;
		//System.out.println(FIELD_MANEGER_ID);
	}*/
	public void setAdminId(String Id){
			this.ADMIN_ID = Id;
	}
    public static void main(String[] args){
        UpdateFm a = new UpdateFm("4");
        //a.setId("5");
        a.show();
    }
}