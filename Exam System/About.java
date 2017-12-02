import java.awt.*;       //All AWT Controls and classes
import javax.swing.*;    // All controls
import java.awt.event.*; //All events
import javax.swing.border.*;
import java.sql.*;
class About
{
	JFrame fr;
	JPanel p;
	JLabel lblAbout,Aimage1,Aimage2,Aimage3;
	JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7;
	public About()
	{
		try{
		p=new JPanel();
		fr=new JFrame("ABOUT SOFTWARE");
		/*lblAbout=new JLabel("");
		lblAbout.setBounds(0,0,500,400);
		lblAbout.setOpaque(true);
		lblAbout.setBackground(Color.white);*/
		
		
		ImageIcon img1=new ImageIcon("Aimage1.jpg");
        Aimage1=new JLabel("",img1,JLabel.CENTER);
        ImageIcon img2=new ImageIcon("Aimage2.jpg");
        Aimage2=new JLabel("",img2,JLabel.CENTER);
        ImageIcon img3=new ImageIcon("Aimage3.gif");
        Aimage3=new JLabel("",img3,JLabel.CENTER);
        Aimage1.setBounds(0,0,600,400);
        Aimage2.setBounds(425,20,160,200);
        Aimage3.setBounds(0,10,80,50);
        lbl1=new JLabel("PREFACE");
      	lbl2=new JLabel("Software Developed By:->Mr.Nitesh Kumar Sharma");
      	lbl3=new JLabel("MobNo:->8010128108");
      	lbl4=new JLabel("Email Id:->niteshsharma871@gmail.com");
      	lbl5=new JLabel("Software Guided By:->Tarun Sir");
      	lbl6=new JLabel("Address:->Indirapuram Ghaziabad");
      	lbl7=new JLabel("");
      	lbl1.setBounds(140,0,145,25);
      	lbl1.setForeground(Color.red);
      	lbl1.setFont(new Font("Wide Latin",Font.BOLD,14));
      	//lbl1.setOpaque(true);
      	//lbl1.setBackground(Color.red);	
      	lbl2.setBounds(40,55,400,25);
      	lbl2.setForeground(Color.white);
      	lbl2.setFont(new Font("@DFKai-SB",Font.ITALIC,17));
      	lbl3.setBounds(40,85,400,25);
      	lbl3.setForeground(Color.white);
      	lbl3.setFont(new Font("@DFKai-SB",Font.ITALIC,17));
      	lbl4.setForeground(Color.white);
      	lbl4.setFont(new Font("@DFKai-SB",Font.ITALIC,17));
      	lbl4.setBounds(40,115,400,25);
      	lbl5.setForeground(Color.white);
      	lbl5.setFont(new Font("@DFKai-SB",Font.ITALIC,17));
      	lbl5.setBounds(40,145,400,25);
      	lbl6.setForeground(Color.white);
      	lbl6.setFont(new Font("@DFKai-SB",Font.ITALIC,17));
      	lbl6.setBounds(40,175,400,25);
      	lbl7.setBackground(Color.red);
      	lbl7.setBounds(140,25,145,4);
      	lbl7.setOpaque(true);
		
		fr.setSize(600,280);
		fr.setLocation(300,185);
		fr.setResizable(false);
		p.setBackground(new Color(200,200,200));
		fr.setDefaultLookAndFeelDecorated(true);
		p.setLayout(null);
		p.add(Aimage1);
		Aimage1.add(Aimage2);
		Aimage1.add(Aimage3);
		Aimage1.add(lbl1);
		Aimage1.add(lbl2);
		Aimage1.add(lbl3);
		Aimage1.add(lbl4);
		Aimage1.add(lbl5);
		Aimage1.add(lbl6);
		Aimage1.add(lbl7);
		fr.getContentPane().add(p);
		fr.setVisible(true);
	   }
	   catch(Exception e)
	   {
	   }
	}
	public static void main(String v[])
	{
		About ab=new About();
	}
}