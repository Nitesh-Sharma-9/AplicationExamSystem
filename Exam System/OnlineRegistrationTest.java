import java.awt.*;       //All AWT Controls and classes
import javax.swing.*; 
import javax.swing.border.*;   // All controls
import java.awt.event.*; //All events
import java.sql.*;
class OnlineRegistrationTest implements ActionListener,ItemListener
{ 
    ResultSet rs;
	Connection cn;
	Statement st;
	JPanel p; 
	int rt;
	int isSearch,isLoad;
	JFrame fr;
	JLabel lblRegistrationTest,lblMin,lblDescription;	
	JComboBox cmbRegNo,cmbPaperId;
	JPasswordField passNew,passConfirm;
	JLabel lblNew,lblConfirm;
	JTextField txtApplicantName,txtTotalNoOfQn,txtMarksForEachQn,txtNegativeMarkingOnWrongAns,txtTotalTime,txtDescription;
	JLabel lblRegNo,lblApplicantName,lblPaperId,lblTotalNoOfQn,lblMarksForEachQn,lblNegativeMarkingOnWrongAns,lblTotalTime;
	JButton bSave,bSearch,bUpdate,bDelete,bReset,bPrint,bClose;
    public OnlineRegistrationTest() // Constructor
	{
		fr = new JFrame("Online Registration Test...");
		lblRegistrationTest=new JLabel("Registration Form");
		lblRegNo=new JLabel("Reg.No.");
		lblApplicantName=new JLabel("Applicant Name");
		lblPaperId=new JLabel("Paper Id");
		lblTotalNoOfQn=new JLabel("Total No. Of Qn");
		lblMarksForEachQn=new JLabel("Marks For Each Qn");
		lblNegativeMarkingOnWrongAns=new JLabel("Negative Marking On Wrong Ans");
		lblTotalTime=new JLabel("Total Time");
		lblMin=new JLabel("min");
		cmbRegNo=new JComboBox();
		txtApplicantName=new JTextField(10);
		cmbPaperId=new JComboBox();
		txtTotalNoOfQn=new JTextField(10);
		txtMarksForEachQn=new JTextField(10);
		txtNegativeMarkingOnWrongAns=new JTextField(10);
		txtTotalTime=new JTextField(10);
	    txtDescription=new JTextField();
	    lblDescription=new JLabel("Paper Name");
	    lblNew=new JLabel("New Password");
	    lblConfirm=new JLabel("Confirm Password");
	    passNew=new JPasswordField();
	    passConfirm=new JPasswordField();
		p=new JPanel();
		bSave=new JButton("SAVE");
		bSearch=new JButton("SEARCH");
		bUpdate=new JButton("UPDATE");
		bDelete=new JButton("DELETE");
		bReset=new JButton("RESET");
		bPrint=new JButton("PRINT");
		bClose=new JButton("Close");
		bSave.setToolTipText("SAVE");
		bSearch.setToolTipText("SEARCH");
		bUpdate.setToolTipText("UPDATE");
		bDelete.setToolTipText("DELETE");
		bReset.setToolTipText("RESET");
		bPrint.setToolTipText("PRINT");
		bClose.setToolTipText("Close");
        bSave.setBackground(new Color(1,110,234));
		bSave.setForeground(Color.white);
		bSearch.setBackground(new Color(1,110,234));
		bSearch.setForeground(Color.white);
		bUpdate.setBackground(new Color(1,110,234));
		bUpdate.setForeground(Color.white);
		bDelete.setBackground(new Color(1,110,234));
		bDelete.setForeground(Color.white);
		bReset.setBackground(new Color(1,110,234));
		bReset.setForeground(Color.white);
		bPrint.setBackground(new Color(1,110,234));
		bPrint.setForeground(Color.white);
	    bClose.setBackground(new Color(1,110,234));
		bClose.setForeground(Color.white);

			
		fr.setSize(620,500);
		fr.setResizable(false);
		fr.setLocation(400,210);
		p.setBackground(new Color(200,200,200));
		lblRegistrationTest.setBounds(150,10,350,25);
		lblRegistrationTest.setForeground(new Color(1,110,234));
		lblRegistrationTest.setFont(new Font("Wide Latin",Font.BOLD,20));
        lblRegNo.setBounds(50,70,120,25);
        lblDescription.setBounds(50,115,80,25);
        txtDescription.setBounds(130,115,320,25);
		lblApplicantName.setBounds(50,160,80,25);
		txtApplicantName.setBounds(130,160,430,25);
		lblTotalTime.setBounds(50,205,70,25);
		txtTotalTime.setBounds(130,205,90,25);
		lblTotalNoOfQn.setBounds(300,205,90,25);
		txtTotalNoOfQn.setBounds(410,205,150,25);
		lblMarksForEachQn.setBounds(50,250,120,25);
		txtMarksForEachQn.setBounds(180,250,100,25);
		lblNegativeMarkingOnWrongAns.setBounds(300,250,200,25);
		txtNegativeMarkingOnWrongAns.setBounds(500,250,60,25);
		lblNew.setBounds(50,295,100,25);
		passNew.setBounds(150,295,150,25);
		lblConfirm.setBounds(50,340,100,25);
		passConfirm.setBounds(150,340,150,25);
		
		lblPaperId.setBounds(400,70,70,25);
		cmbRegNo.setBounds(130,70,110,25);
		cmbRegNo.setEditable(true);
		cmbPaperId.setBounds(450,70,110,25);
		cmbPaperId.setEditable(true);
		lblMin.setBounds(230,205,40,25);
		bSave.setBounds(150,390,90,24);
		bReset.setBounds(250,390,90,24);
		bClose.setBounds(350,390,90,24);
		//bUpdate.setBounds(210,330,90,24);
		//bDelete.setBounds(310,330,90,24);
		//bSearch.setBounds(410,330,90,24);
		//bPrint.setBounds(510,330,90,24);
		cmbPaperId.setToolTipText("Paper Id");
		cmbRegNo.setToolTipText("Registration No.");
		txtApplicantName.setToolTipText("ApplicantName");
		txtTotalTime.setToolTipText("Total Time");
		txtTotalNoOfQn.setToolTipText("Total No. Of Question");
		txtMarksForEachQn.setToolTipText("Marks For Each Question");
		txtNegativeMarkingOnWrongAns.setToolTipText("Negative Marking On Wrong Ans");

		/*bSave.setToolTipText("SAVE");
		bSearch.setToolTipText("SEARCH");
		bUpdate.setToolTipText("UPDATE");
		bDelete.setToolTipText("DELETE");
		bReset.setToolTipText("RESET");
		bPrint.setToolTipText("PRINT");*/
		
		bSave.setBackground(new Color(1,110,234));
		bSave.setForeground(Color.white);
		bSearch.setBackground(new Color(1,110,234));
		bSearch.setForeground(Color.white);
		bUpdate.setBackground(new Color(1,110,234));
		bUpdate.setForeground(Color.white);
		bDelete.setBackground(new Color(1,110,234));
		bDelete.setForeground(Color.white);
		bReset.setBackground(new Color(1,110,234));
		bReset.setForeground(Color.white);
		bPrint.setBackground(new Color(1,110,234));
		bPrint.setForeground(Color.white);
        p.setLayout(null);
        p.add(lblRegistrationTest);
		p.add(cmbRegNo);
		p.add(txtApplicantName);
		p.add(cmbPaperId);
		p.add(txtTotalNoOfQn);
		p.add(txtMarksForEachQn);
		p.add(txtNegativeMarkingOnWrongAns);
		p.add(txtTotalTime);
		p.add(bSave);
		p.add(bSearch);
		p.add(bUpdate);
		p.add(bDelete);
		p.add(bReset);
		p.add(bPrint);
		p.add(bClose);
		p.add(lblRegNo);
		p.add(lblApplicantName);
		p.add(lblPaperId);
		p.add(lblTotalNoOfQn);
		p.add(lblMarksForEachQn);
		p.add(lblNegativeMarkingOnWrongAns);
		p.add(lblTotalTime);
		p.add(lblMin);
		p.add(lblDescription);
		p.add(txtDescription);
		p.add(lblNew);
		p.add(passNew);
		p.add(lblConfirm);
		p.add(passConfirm);
		fr.getContentPane().add(p);
		fr.setVisible(true);
		bSave.addActionListener(this);
		bSearch.addActionListener(this);
		bUpdate.addActionListener(this);
		bDelete.addActionListener(this);
		bReset.addActionListener(this);
		
		bClose.addActionListener(this);
		cmbRegNo.addActionListener(this);
	    cmbRegNo.addItemListener(this);
	    cmbPaperId.addActionListener(this);
	    cmbPaperId.addItemListener(this);
		//fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try{	
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		    //cn=DriverManager.getConnection("Jdbc:Odbc:OESPDSN");
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                       cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ns","ns");
			st=cn.createStatement();	   
			 rs=st.executeQuery("Select PaperId from PaperEntry order by PaperId");
			 isLoad=0;
			while(rs.next())
			{
				cmbPaperId.addItem(rs.getInt("PaperId"));
			}
			cmbPaperId.setSelectedIndex(-1);			
			isLoad=1;
			rs=st.executeQuery("select max(RegNo) from RegistrationTest");
			if(rs.next())
			{
			   rt=rs.getInt(1);
			   if(rt==0)
			   {
			   	rt=109901001;	
				cmbRegNo.setSelectedItem(rt);
				cmbRegNo.setEditable(false);
			   }
			   else
			   {
			   	rt=rt+1;
			   	cmbRegNo.setSelectedItem(rt);
			   	cmbRegNo.setEditable(false);
			   }
			}	
			String adm="admin";
		    rs=st.executeQuery("select useridentity from login where username='"+adm+"'");
		    if(rs.next())
		    {	
		    	if  (!(rs.getString(1).equals("ADMIN")))	
			    JOptionPane.showMessageDialog(null,"Choose Paper Id....", " Registration Form",JOptionPane.INFORMATION_MESSAGE );
		    }
			
		}
		catch(SQLException e)
		{
			 JOptionPane.showMessageDialog(null,"Invalid Query"+e, " Online Option Choice ",JOptionPane.ERROR_MESSAGE );

		}
		catch(ClassNotFoundException e)
		{
			   JOptionPane.showMessageDialog(null,"Invalid Driver Class"+e, " Online Option Choice ",JOptionPane.ERROR_MESSAGE );

		}
	}
	
               
           

	public void clrscr()
	{
		cmbRegNo.setEditable(true);
		cmbRegNo.setSelectedItem("");
		txtDescription.setText("");
		txtApplicantName.setText("");
		cmbPaperId.setSelectedItem("");
		txtTotalNoOfQn.setText("");
		txtMarksForEachQn.setText("");
		txtNegativeMarkingOnWrongAns.setText("");
		txtTotalTime.setText("");
	    passNew.setText("");
     	passConfirm.setText("");	

	}

	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource()==bSave)
		{
			try{
				if(txtApplicantName.getText().equals(""))
				{
				   JOptionPane.showMessageDialog(null,"Please Enter Applicant Name..", " Registration Form",JOptionPane.INFORMATION_MESSAGE );	
				}
				else if(!(passConfirm.getText().equals(passNew.getText())))
				{
					JOptionPane.showMessageDialog(null,"Password not match", " Registration Form",JOptionPane.ERROR_MESSAGE );	
					passNew.setText("");
					passConfirm.setText("");	
				}
				else
				{		
				bSearch.setBackground(new Color(1,110,234));
				bSearch.setForeground(Color.white);
				int r1,r2;
		        r1=st.executeUpdate("insert into RegistrationTest values("+Integer.parseInt(cmbRegNo.getSelectedItem().toString())+",'"+txtApplicantName.getText()+"',"+Integer.parseInt(cmbPaperId.getSelectedItem().toString())+",'"+txtDescription.getText()+"',"+Integer.parseInt(txtTotalNoOfQn.getText())+","+Integer.parseInt(txtMarksForEachQn.getText())+","+Integer.parseInt(txtNegativeMarkingOnWrongAns.getText())+","+Integer.parseInt(txtTotalTime.getText())+")");
		        r2=st.executeUpdate("insert into Login (username,password)values('"+cmbRegNo.getSelectedItem().toString()+"','"+passConfirm.getText()+"')");
		        if(r1>0 && r2>0)
		        {
                    //JOptionPane.showMessageDialog(null,"Record Saved...", " Registration Test ",JOptionPane.INFORMATION_MESSAGE );
                    JOptionPane.showMessageDialog(null,"You are registered successfully...\nYou User Id is:-"+cmbRegNo.getSelectedItem().toString(), " Registration Form",JOptionPane.INFORMATION_MESSAGE );
                    
		        }
				bSave.setBackground(new Color(1,110,234));
				bSave.setForeground(Color.white);
			    clrscr();
			    cmbPaperId.setSelectedIndex(-1);
			    rs=st.executeQuery("select max(RegNo) from RegistrationTest");
			    if(rs.next())
			  {
			   rt=rs.getInt(1);
			   if(rt==0)
			   {
			   	rt=1;
			   	cmbRegNo.setEditable(true);	
				cmbRegNo.setSelectedItem(rt);
				cmbRegNo.setEditable(false);
			   }
			   else
			   {
			   	rt=rt+1;
			   	cmbRegNo.setEditable(true);
			   	cmbRegNo.setSelectedItem(rt);
			   	cmbRegNo.setEditable(false);
			   }
			}
			 //cmbRegNo.setEditable(true);
			 fr.dispose();
			 Login lobj=new Login();
			 lobj.show();
			 
			}
			}
			catch(SQLException e)
			{
			 JOptionPane.showMessageDialog(null,"SQL Error"+e, " Online Registration Test ",JOptionPane.ERROR_MESSAGE );
			}
				
		}
		if(evt.getSource()==bSearch)
		{
			try{
				    isSearch=0;
				    isLoad=0;
				    clrscr();
				    cmbRegNo.setEditable(true);
				    cmbRegNo.removeAllItems();
				    cmbPaperId.removeAllItems();
				
				rs=st.executeQuery("select  RegNo from RegistrationTest order by RegNo");
				while(rs.next())
			{
				cmbRegNo.addItem(rs.getInt("RegNo"));
			}
			cmbRegNo.setSelectedIndex(-1);
			cmbRegNo.setEditable(false);	
				isSearch=1;
			}
			catch(SQLException e)
			{
			 JOptionPane.showMessageDialog(null,"SQL Error"+e, " Online Registration Test ",JOptionPane.ERROR_MESSAGE );
			}
			
		}
		if(evt.getSource()==bUpdate)
		{
			isSearch=0;			
			try{
				String s;
				s=cmbPaperId.getSelectedItem().toString();
				int m=Integer.parseInt(s);
			    s=cmbRegNo.getSelectedItem().toString();
			    int n=Integer.parseInt(s);
			    int r;
			    r=st.executeUpdate("update RegistrationTest set ApplicantName='"+txtApplicantName.getText()+"',TotalNoOfQn="+txtTotalNoOfQn.getText()+",MarksForEachQn="+txtMarksForEachQn.getText()+",NegativeMarkingOnWrongAns="+txtNegativeMarkingOnWrongAns.getText()+",TotalTime="+txtTotalTime.getText()+" where PaperId="+m+" and RegNo="+n+"");
			    if(r>0)
                JOptionPane.showMessageDialog(null,"Record Updated...", " Online Registration Test ",JOptionPane.INFORMATION_MESSAGE );
			    clrscr();
			    //cmbRegNo.removeAllItems();
			    //cmbPaperId.setSelectedIndex(-1);
			    isSearch=1;
			    
			}
			
			catch(SQLException e)
			{
			 JOptionPane.showMessageDialog(null,"SQL Error"+e, " Online Registration Test ",JOptionPane.ERROR_MESSAGE );
			}
				
		}
		if(evt.getSource()==bDelete)
		{
			isSearch=0;
			try{
				String s;
				s=cmbPaperId.getSelectedItem().toString();
			    int m=Integer.parseInt(s);
			    s=cmbRegNo.getSelectedItem().toString();
			    int n=Integer.parseInt(s);
			    int r;
			    r=st.executeUpdate("delete from RegistrationTest where PaperId="+m+" and RegNo="+n);
			    if(r>0)
                JOptionPane.showMessageDialog(null,"One Record Deleted...", " Online Registration Test ",JOptionPane.INFORMATION_MESSAGE );
			    clrscr();
			    cmbRegNo.removeAllItems();
			    cmbRegNo.setEditable(false);
			    cmbPaperId.setSelectedIndex(-1);
			}
			catch(SQLException e)
			{
			 JOptionPane.showMessageDialog(null,"SQL Error"+e, " Online Registration Test ",JOptionPane.ERROR_MESSAGE );
			}
			
		}
		if(evt.getSource()==bReset)
		{
			isSearch=0;
			clrscr();
			cmbRegNo.setEditable(true);
			cmbRegNo.removeAllItems();
			cmbRegNo.setEditable(false);
			cmbPaperId.removeAllItems();
			try{
				rs=st.executeQuery("select max(RegNo) from RegistrationTest");
			    if(rs.next())
			  {
			   rt=rs.getInt(1);
			   if(rt==0)
			   {
			   	rt=109901001;
			   	cmbRegNo.setEditable(true);	
				cmbRegNo.setSelectedItem(rt);
				cmbRegNo.setEditable(false);
			   }
			   else
			   {
			   	rt=rt+1;
			   	cmbRegNo.setEditable(true);
			   	cmbRegNo.setSelectedItem(rt);
			   	cmbRegNo.setEditable(false);
			   }
			}
			rs=st.executeQuery("Select PaperId from PaperEntry order by PaperId");
			 isLoad=0;
			while(rs.next())
			{
				cmbPaperId.addItem(rs.getInt("PaperId"));
			}
			cmbPaperId.setSelectedIndex(-1);			
			isLoad=1;
			}
		    catch(SQLException e)
			{
			 JOptionPane.showMessageDialog(null,"SQL Error"+e, " Online Registration Test ",JOptionPane.ERROR_MESSAGE );
			}	
		}
		if(evt.getSource()==bClose)
		{
			int x=JOptionPane.showConfirmDialog(null,"Are you sure...", " Registration Form ",JOptionPane.YES_NO_OPTION);
      		if(x==0)
      		fr.dispose();
      		else
      		{}
		}
		
		
		
	}
	public void itemStateChanged(ItemEvent evt)
	 {
	 /*	if(evt.getSource()==cmbPaperId && isSearch==1 && cmbPaperId.getSelectedIndex()>=0)
	 	{
	 		try{
	 			clrscr();
	 			cmbRegNo.removeAllItems();
	 			isSearch=0;
	 		   rs=st.executeQuery("Select RegNo from RegistrationTest where PaperId="+ Integer.parseInt(cmbPaperId.getSelectedItem().toString()) +" order by RegNo");
			   while(rs.next())
			   {
				cmbRegNo.addItem(rs.getInt("RegNo"));
			   }
			   cmbRegNo.setSelectedIndex(-1);
			   
			   isSearch=1;
			}
			catch(SQLException e)
		   {
			 JOptionPane.showMessageDialog(null,"Invalid Query"+e, " Online Question Entry ",JOptionPane.ERROR_MESSAGE );
		   }
	 	
	 	}*/
	 	if(evt.getSource()==cmbRegNo && isSearch==1 && cmbRegNo.getSelectedIndex()>=0)
	 	{
	 		try{
	 			String s=cmbRegNo.getSelectedItem().toString();
	 		    int n=Integer.parseInt(s);
	 		     rs=st.executeQuery("select * from RegistrationTest where RegNo="+n); 
	            if(rs.next())
	            {
	            	cmbPaperId.setSelectedItem(rs.getInt("PaperId"));
	            	txtDescription.setText(rs.getString("Description"));
	            	txtApplicantName.setText(rs.getString("ApplicantName"));
					txtTotalNoOfQn.setText(String.valueOf(rs.getInt("TotalNoOfQn")));
					txtMarksForEachQn.setText(String.valueOf(rs.getInt("MarksForEachQn")));
					txtTotalTime.setText(String.valueOf(rs.getInt("TotalTime")));
					txtNegativeMarkingOnWrongAns.setText(String.valueOf(rs.getInt("NegativeMarkingOnWrongAns")));
	            	
	            }
	 		}
	 		catch(SQLException e)
			{
			 JOptionPane.showMessageDialog(null,"SQL Error"+e, " Online Registration Test ",JOptionPane.ERROR_MESSAGE );
			}
	 	}
	 	if(evt.getSource()==cmbPaperId && isLoad==1 && cmbPaperId.getSelectedIndex()>=0)
	 	{
	 		try{
	 			String s=cmbPaperId.getSelectedItem().toString();
	 			int n=Integer.parseInt(s);
	 			 rs=st.executeQuery("select * from PaperEntry where PaperId="+n);
	 			 if(rs.next())
	 			 {
	 			 	txtDescription.setText(rs.getString("description"));
	 			 	txtTotalNoOfQn.setText(String.valueOf(rs.getInt("NoOfQuestion")));
	 			 	txtMarksForEachQn.setText(String.valueOf(rs.getInt("TotalMarks")/Integer.parseInt(txtTotalNoOfQn.getText())));
	 			    txtTotalTime.setText(String.valueOf(rs.getInt("TotalTime")));
	 			    txtNegativeMarkingOnWrongAns.setText(""+rs.getInt("NegativeMarkingOnWrongAns"));
	 			 }
	 		}
	 		catch(SQLException e)
	 		{
	 			JOptionPane.showMessageDialog(null,"SQL Error"+e, " Online Registration Test ",JOptionPane.ERROR_MESSAGE );
	 		}
	 	}
    }
	public static void main(String s[])
	{
		OnlineRegistrationTest obj= new OnlineRegistrationTest();
	}
}