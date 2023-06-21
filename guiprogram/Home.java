package guiprogram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Home page
public class Home extends JFrame implements ActionListener
{
		JLabel l1;
		JButton b1,b2,b3,b4;
		JPanel p1,p2;
		
		
	public Home()
	{
		super(" Electricity Billing System ");
		this.setSize(650,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p1 = new JPanel();
		p1.setSize(new Dimension(650,600));
		p1.setBackground(Color.gray);
		p1.setLayout(null);
		
		l1 = new JLabel("                     Home  Page            ");
		l1.setFont(new Font("Serif",Font.ITALIC,40));
		l1.setBackground(Color.RED);
		l1.setOpaque(true);
		l1.setForeground(Color.WHITE);
		l1.setBounds(1,80,650,50);
		p1.add(l1);
		
		b1 = new JButton("EXECUTIVE ENGINEER");
		b1.setFont(new Font("Serif",Font.BOLD,15));
		b1.setForeground(Color.black);
		b1.setBackground(Color.cyan);
		b1.setBounds(50,180,230,80);
		b1.addActionListener(this);
		p1.add(b1);
		
		b2 = new JButton("FIELD MANEGER");
		b2.setFont(new Font("Serif",Font.BOLD,15));
		b2.setForeground(Color.black);
		b2.setBackground(Color.cyan);
		b2.setBounds(300,180,230,80);
		b2.addActionListener(this);
		p1.add(b2);
		
		b3 = new JButton("CUSTOMER");
		b3.setFont(new Font("Serif",Font.BOLD,15));
		b3.setForeground(Color.black);
		b3.setBackground(Color.cyan);
		b3.setBounds(50,300,230,80);
		b3.addActionListener(this);
		p1.add(b3);
		
		b4 = new JButton("EXIT");
		b4.setFont(new Font("Serif",Font.BOLD,15));
		b4.setForeground(Color.RED);
		b4.setBackground(Color.pink);
		b4.setBounds(300,300,230,80);
		b4.addActionListener(this);
		p1.add(b4);
		
		
		this.add(p1);

	    
		
	}

	public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==b1)
			{
				ExeLogin e = new ExeLogin();
				this.setVisible(false);
				e.setVisible(true);
			}
			else if(ae.getSource()==b2)
			{
				FmLogin f = new FmLogin();
				this.setVisible(false);
				f.setVisible(true);
			}
			else if(ae.getSource()==b3)
			{
				CusLogin c = new CusLogin();
				this.setVisible(false);
				c.setVisible(true);
			}
            else if(ae.getSource()==b4)
			{
				System.exit(0);
			}
			
		}
        //for testing
        public static void main(String[] args){
            Home h = new Home();
            h.show();
        }


}
