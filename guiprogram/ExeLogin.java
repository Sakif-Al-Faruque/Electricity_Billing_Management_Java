package guiprogram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//user login form
public class ExeLogin extends JFrame implements ActionListener 
{
	JLabel l1,l2,l3;
	JTextField t1,t2;
	JButton b1,b2,b3; 
	JPanel p1;
	JPasswordField passPF;

	
	public ExeLogin()
	{
		super(" LogIn Form ");
		this.setSize(550,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p1 = new JPanel();
		p1.setSize(new Dimension(550,500));
		p1.setBackground(Color.gray);
		p1.setLayout(null);
		
		l1 = new JLabel("         EXECUTIVE  MANEGER  SIGN IN ");
		l1.setFont(new Font("Serif",Font.ITALIC,25));
		l1.setBackground(Color.RED);
		l1.setOpaque(true);
		l1.setForeground(Color.WHITE);
		l1.setBounds(1,20,649,50);
		p1.add(l1);
		
		l2 = new JLabel("  Username  :");
		l2.setFont(new Font("Serif",Font.PLAIN,25));
		l2.setBackground(Color.black);
		l2.setOpaque(true);
		l2.setForeground(Color.blue);
		l2.setBounds(100,100,150,40);
		p1.add(l2);
		
		l3 = new JLabel("  Password :");
		l3.setFont(new Font("Serif",Font.PLAIN,25));
		l3.setBackground(Color.black);
		l3.setOpaque(true);
		l3.setForeground(Color.blue);
		l3.setBounds(100,170,150,40);
		p1.add(l3);
		
		t1 = new JTextField();
		t1.setBounds(300,100,150,40);
		p1.add(t1);

		passPF = new JPasswordField( );
		passPF.setBounds(300,170,150,40);
		p1.add(passPF);
		
		b1 = new JButton("Cancel");
		b1.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		b1.setForeground(Color.black);
		b1.setBounds(150,240,100,40);
		b1.addActionListener(this);
		p1.add(b1);
		
		b2 = new JButton("Login");
		b2.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		b2.setForeground(Color.black);
		b2.setBounds(300,240,100,40);
		b2.addActionListener(this);
		p1.add(b2);
		
		this.add(p1);
	}
	public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==b1)
			{
				//System.exit(0);
                this.setVisible(false);
                Home h = new Home();
                h.setVisible(true);
			}
			else if(ae.getSource()==b2)
			{
                String Username = t1.getText();
                String Password = passPF.getText();
				Login l = new Login(Username, Password, "executive engineer");
                if(l.checkUser()){
                    //forward executive engineer dashboard page
					ExeDashboard e = new ExeDashboard(l.getUserId());
					//e.setId(l.getUserId());
                    this.setVisible(false);
                    e.setVisible(true);
                }else{
                    //show invalid user
                    /*FormNo2 f1 = new FormNo2();
				    this.setVisible(false);
				    f1.setVisible(true);*/

                    LoginError h = new LoginError("Executive Engineer");
                    this.setVisible(false);
                    h.setVisible(true);
                }

                
			}
		}
        //for testing
        /*public static void main(String[] args){
            ExeLogin e = new ExeLogin();
            e.show();
        }*/
}	