package guiprogram.delete;

import guiprogram.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import guiprogram.user.*;

//showing customer info
public class DeleteFm extends JFrame implements ActionListener
{
		JLabel l1,l2,l4,l5,l6,l7,l9,l10,l11;
		JButton b1,b2; 
		JTextField t1,t2,t3,t4,t5;
		JPanel p1;
        private String FIELD_MANEGER_ID = "";
        private String ADMIN_ID = "";
		
	public DeleteFm(String Id)
	{	
		super(" Electricity Billing System ");
		this.setSize(750,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.FIELD_MANEGER_ID = Id;
		
        //user operation started
        String[] fmInfo = new String[6];
        User f = new User();
        fmInfo = f.showParticularInfo("field-maneger", FIELD_MANEGER_ID);
        //user operation ended

		p1 = new JPanel();
		p1.setSize(new Dimension(750,500));
		p1.setBackground(Color.LIGHT_GRAY);
		p1.setLayout(null);
		
		l1 = new JLabel("                                      Delete Field Maneger           ");
		l1.setFont(new Font("Serif",Font.ITALIC,25));
		l1.setBackground(Color.blue);
		l1.setOpaque(true);
		l1.setForeground(Color.black);
		l1.setBounds(1,30,749,40);
		p1.add(l1);
		
		l2 = new JLabel("  USER NAME                  :  ");
		l2.setFont(new Font("Serif",Font.BOLD,15));
		l2.setBackground(Color.DARK_GRAY);
		l2.setOpaque(true);
		l2.setForeground(Color.white);
		l2.setBounds(80,120,190,30);
		p1.add(l2);
		         
		l4 = new JLabel("  ADDRESS                       :  ");
		l4.setFont(new Font("Serif",Font.BOLD,15));
		l4.setBackground(Color.DARK_GRAY);
		l4.setOpaque(true);
		l4.setForeground(Color.white);
		l4.setBounds(80,165,190,30);
		p1.add(l4);
		
		l5 = new JLabel("  ID NO                               :  ");
		l5.setFont(new Font("Serif",Font.BOLD,15));
		l5.setBackground(Color.DARK_GRAY);
		l5.setOpaque(true);
		l5.setForeground(Color.white);
		l5.setBounds(80,210,190,30);
		p1.add(l5);
		
		l6 = new JLabel("  REGISTERED DATE     :  ");
		l6.setFont(new Font("Serif",Font.BOLD,15));
		l6.setBackground(Color.DARK_GRAY);
		l6.setOpaque(true);
		l6.setForeground(Color.white);
		l6.setBounds(80,255,190,30);
		p1.add(l6);
		
		l7 = new JLabel(" "+fmInfo[1]+"  ");
		l7.setFont(new Font("Serif",Font.BOLD,15));
		l7.setBackground(Color.BLACK);
		l7.setOpaque(true);
		l7.setForeground(Color.RED);
		l7.setBounds(360,120,220,30);
		p1.add(l7);
		
		l9 = new JLabel(" "+fmInfo[4]+"  ");
		l9.setFont(new Font("Serif",Font.BOLD,15));
		l9.setBackground(Color.BLACK);
		l9.setOpaque(true);
		l9.setForeground(Color.RED);
		l9.setBounds(360,165,220,30);
		p1.add(l9);
		
		l10 = new JLabel(" "+fmInfo[0]+"  ");
		l10.setFont(new Font("Serif",Font.BOLD,15));
		l10.setBackground(Color.BLACK);
		l10.setOpaque(true);
		l10.setForeground(Color.RED);
		l10.setBounds(360,210,220,30);
		p1.add(l10);
		
		l11 = new JLabel(" "+fmInfo[5]+"  ");
		l11.setFont(new Font("Serif",Font.BOLD,15));
		l11.setBackground(Color.BLACK);
		l11.setOpaque(true);
		l11.setForeground(Color.RED);
		l11.setBounds(360,255,220,30);
		p1.add(l11);
		
		
		b1 = new JButton(" Exit ");
		b1.setFont(new Font("Serif",Font.BOLD,20));
		b1.setForeground(Color.black);
		b1.setBackground(Color.GREEN);
		b1.setBounds(150,330,150,40);
		b1.addActionListener(this);
		p1.add(b1);

        b2 = new JButton(" Delete ");
		b2.setFont(new Font("Serif",Font.BOLD,20));
		b2.setForeground(Color.black);
		b2.setBackground(Color.GREEN);
		b2.setBounds(330,330,150,40);
		b2.addActionListener(this);
		p1.add(b2);
		
		this.add(p1);
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
				User c = new User();
                c.deleteInfo("field-maneger", FIELD_MANEGER_ID);
			}
		}
    //set id
    /*public void setId(String Id){
		this.FIELD_MANEGER_ID = Id;
	}*/
	public void setAdminId(String Id){
			this.ADMIN_ID = Id;
	}
    public static void main(String[] args){
        DeleteFm s = new DeleteFm("12");
        //s.setId("12");
        s.show();
    }
}