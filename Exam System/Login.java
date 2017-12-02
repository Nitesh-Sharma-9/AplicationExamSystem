import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{

	Container c;
	JPanel jl;
	JLabel lblTitle,lbluser_name,lblpassword;
	Label lbl,lblReg;
	TextField txtuser_name;
	JPasswordField txtpassword;
	TextField txt;
	JButton btnlogin,btnlogout;
	String user_name,password;
	JTabbedPane tp;
	Connection con;
    Statement st;
	PreparedStatement ps;				
	ResultSet rs;

	//String user_name,password;
	
	public Login()
	{
		
		
		try
		{
		       Class.forName("oracle.jdbc.driver.OracleDriver");
               con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ns","ns");
              
               //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	           // con=DriverManager.getConnection("Jdbc:Odbc:OESPDSN","","");
		       st=con.createStatement();	 
	           System.out.println(" Connection established ");
		}
		catch(Exception e)
		{
			System.out.print(" Not connected "+e);			
		}
		user_name="";
		password="";	
		setResizable(false);
		setBounds(450,200,348,330);   
		setTitle("ABES EXAM SYSTEM");
		c=getContentPane();
		c.setLayout(null);
		lblTitle=new JLabel("USER LOGIN FORM ");
		lblTitle.setBounds(30,15,350,30);
		lblTitle.setFont(new Font("Wide Latin",Font.BOLD,14));
		lblTitle.setForeground(new Color(1,110,234));
		lbl=new Label(" ");
		lbl.setBackground(new Color(1,110,234));
		lbl.setBounds(0,46,350,2);
		c.add(lblTitle);
		c.add(lbl);
		
		//tp = new JTabbedPane();
		//tp.setBounds(60,50,300,300);
		//c.add(tp);
        lblReg =new Label("New Registration");
        lblReg.setBounds(200,0,100,25);
        lblReg.setForeground(Color.red);
        lblReg.setFont(new Font("Wide Latin",Font.BOLD,12));
		jl = new JPanel();
		jl.setLayout(null);
		jl.setBounds(20,55,300,220);
		c.add(jl);
		
		//tp.addTab("Login Form",jl);
		jl.setBackground(new Color(255,255,255));
		
		lbluser_name= new JLabel("User Id :");
		lbluser_name.setForeground(Color.blue);
		lbluser_name.setBounds(70,30,100,25);
		txtuser_name= new TextField();
		txtuser_name.setBounds(70,60,150,25);
		txtuser_name.setFont(new Font("",Font.BOLD,12));
		lblpassword= new JLabel("Password :");
		lblpassword.setForeground(Color.blue);
		lblpassword.setBounds(70,90,100,25);
		txtpassword= new JPasswordField();
		txtpassword.setBounds(70,120,150,25);
		txtpassword.setFont(new Font("Wide Latin",Font.BOLD,16));
		
		jl.add(lbluser_name);
		jl.add(txtuser_name);
		jl.add(lblpassword);
		jl.add(txtpassword);
		jl.add(lblReg);
		
		btnlogin=new JButton("LOGIN");
		btnlogout=new JButton("LOGOUT");
		jl.add(btnlogin);
		jl.add(btnlogout);
		
		btnlogin.addActionListener(this);
		btnlogout.addActionListener(this);
		
		btnlogin.setBounds(40,180,100,25);
		btnlogout.setBounds(160,180,100,25);
		btnlogin.setBackground(new Color(1,110,234));
		btnlogin.setForeground(Color.white);
		btnlogout.setBackground(new Color(1,110,234));
		btnlogout.setForeground(Color.white);
		//txtuser_name.addKeyListener(new Win());
		//txtuser_name.setsetFocus(true);
		lblReg.addMouseListener(new Mouse());
		
	}
	class Mouse extends MouseAdapter
	{
		public void mouseClicked(MouseEvent e)
		{
			if(e.getSource()==lblReg)
			{
				new OnlineRegistrationTest();
				dispose();
			}
		}
	}
	class Th1 extends Thread
	{
		int r=0,g=255,b=100;
		public void run()
		{
			try{
				while(true)
				{
				
				lblReg.setForeground(new Color(r+=5,g-=3,b+=2));
			if(r==255)
			    r=0;
			if(g==0)
				g=255;	
		    if(b==200)
		    	b=100;
			Thread.sleep(100);
				}
			}
			catch(Exception e)
			{
			}
	    }
	}
	/*class Win extends KeyAdapter
	{
		public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( !((c >= 'A' && c <= 'Z') ||(c >= 'a' && c <= 'z')) )
               {
                    e.consume();
                }
            }
	}*/
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnlogin)
		{
			user_name=txtuser_name.getText();
			password=txtpassword.getText();
			try
			{	
				
				ps=con.prepareStatement("select UserName,Password,useridentity from Login where UserName='"+user_name+"' and Password='"+password+"'");
				rs=ps.executeQuery();
				if(rs.next()==true)
				{	
				
					JOptionPane.showMessageDialog(this,"Login Successful...");				
					if(rs.getString("useridentity").equals("ADMIN"))
					{
					    OnlineMenu mf=new OnlineMenu();
					    mf.show();
				        dispose();
					    //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					}
				    else
				    {
				    	OnlineTestExam obj=new OnlineTestExam();
					    obj.show();
					    dispose();
				    }   
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Wrong User Name or Password ...","Login",JOptionPane.ERROR_MESSAGE);
					txtuser_name.setText("");
					txtpassword.setText("");
					txtuser_name.requestFocus();
		
				}
				rs.close();
			}
			catch(Exception ex)
			{
			}
		
		}
		else
		{
			JOptionPane.showMessageDialog(this,"Logout Successful","Logout",JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}
			
	}
	public static void main(String args[])
	{
		Login l=new Login();
	    l.show();
	    Th1 t1=l.new Th1();   
        t1.start();
                
	}
}

