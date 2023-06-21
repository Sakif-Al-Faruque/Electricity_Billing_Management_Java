package guiprogram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//LoginError page
public class LoginError extends JFrame implements ActionListener
{
		JLabel l1;
		JButton b1,b2,b3,b4;
		JPanel p1,p2;
		private String userInfo;
		
		public LoginError(){}
		
	public LoginError(String userInfo)
	{
		super(" Electricity Billing System(Login Failed) ");
		this.setSize(650,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.userInfo = userInfo;
		
		p1 = new JPanel();
		p1.setSize(new Dimension(650,600));
		p1.setBackground(Color.gray);
		p1.setLayout(null);
		
		l1 = new JLabel("    "+userInfo+" Login  Failed            ");
		l1.setFont(new Font("Serif",Font.ITALIC,40));
		l1.setBackground(Color.RED);
		l1.setOpaque(true);
		l1.setForeground(Color.WHITE);
		l1.setBounds(1,80,650,50);
		p1.add(l1);
		
		b1 = new JButton("TRY AGAIN");
		b1.setFont(new Font("Serif",Font.BOLD,15));
		b1.setForeground(Color.black);
		b1.setBackground(Color.cyan);
		b1.setBounds(190,180,230,80);
		b1.addActionListener(this);
		p1.add(b1);
		
		this.add(p1);

	    
		
	}

	public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==b1)
			{
				if(userInfo.equals("Executive Engineer")){
					ExeLogin e = new ExeLogin();
					this.setVisible(false);
					e.setVisible(true);
				}else if(userInfo.equals("Field Maneger")){
					FmLogin e = new FmLogin();
                    this.setVisible(false);
                    e.setVisible(true);
				}else if(userInfo.equals("Customer")){
					CusLogin e = new CusLogin();
                    this.setVisible(false);
                    e.setVisible(true);
				}
			}
			
		}
        //for testing
        public static void main(String[] args){
            LoginError h = new LoginError("Field Maneger");
            h.show();
        }


}
