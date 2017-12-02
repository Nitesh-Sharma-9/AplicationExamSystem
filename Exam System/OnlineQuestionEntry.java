import java.awt.*;       //All AWT Controls and classes
import javax.swing.*;
import javax.swing.border.*;    // All controls
import java.awt.event.*; //All events
import java.sql.*;
class OnlineQuestionEntry implements ActionListener,ItemListener
{
	ResultSet rs;
	Connection cn;
	Statement st;
	JPanel p; 
	int isSearch,isLoad,rt;
	JFrame fr;
	JLabel lblOnlineQuestionEntry;	
	JComboBox cmbPaperId,cmbQNo;
	JCheckBox chkIsActive;
	JTextField txtDescription,txtCorrectChoice;
	JTextArea txtQDescription;
	JLabel lblPaperId,lblQNo,lblDescription,lblQDescription,lblIsActive,lblCorrectChoice;
	JButton bSave,bSearch,bUpdate,bDelete,bReset,bPrint;
    public OnlineQuestionEntry() // Constructor
	{
		fr = new JFrame("Online Question Entry...");
		lblOnlineQuestionEntry=new JLabel("Online Question Entry");
		lblPaperId=new JLabel("Paper Id");
		lblQNo=new JLabel("QNo");
		lblDescription=new JLabel("Description");
		lblQDescription=new JLabel("QDescription");
		cmbPaperId=new JComboBox();
		cmbQNo=new JComboBox();
		txtDescription=new JTextField(10);
		txtQDescription=new JTextArea(100,10);
		txtQDescription.setColumns(100);
		txtQDescription.setLineWrap(true);
		txtQDescription.setRows(10);
		txtCorrectChoice=new JTextField(10);
		chkIsActive=new JCheckBox();
		lblCorrectChoice=new JLabel("Correct Choice");
		lblIsActive=new JLabel("IsActive");
		p=new JPanel();
		bSave=new JButton("SAVE");
		bSearch=new JButton("SEARCH");
		bUpdate=new JButton("UPDATE");
		bDelete=new JButton("DELETE");
		bReset=new JButton("RESET");
		bPrint=new JButton("PRINT");
		bSave.setToolTipText("Save");
		bSearch.setToolTipText("SEARCH");
		bUpdate.setToolTipText("UPDATE");
		bDelete.setToolTipText("DELETE");
		bReset.setToolTipText("RESET");
		bPrint.setToolTipText("PRINT");
		
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
		
		fr.setSize(590,450);
		fr.setResizable(false);
		fr.setLocation(400,210);
		p.setBackground(new Color(200,200,200));
		lblOnlineQuestionEntry.setBounds(110,10,380,25);
		lblOnlineQuestionEntry.setForeground(Color.blue);
		lblOnlineQuestionEntry.setFont(new Font("Wide Latin",Font.BOLD,18));
        lblQNo.setBounds(50,70,70,25);
		lblPaperId.setBounds(340,70,100,25);
		lblDescription.setBounds(50,115,70,25);
		lblQDescription.setBounds(50,160,70,25);
		cmbQNo.setBounds(130,70,130,25);
		cmbQNo.setEditable(true);
		cmbPaperId.setBounds(400,70,130,25);
		cmbPaperId.setEditable(true);
		txtDescription.setBounds(130,115,270,25);
		txtQDescription.setBounds(130,160,400,75);
		
		lblIsActive.setBounds(50,245,100,25);
		lblCorrectChoice.setBounds(340,245,100,25);
		chkIsActive.setBounds(130,245,20,25);
		txtCorrectChoice.setBounds(430,245,100,25);
		bSave.setBounds(20,310,90,24);
		bSearch.setBounds(110,310,90,24);
		bUpdate.setBounds(200,310,90,24);
		bDelete.setBounds(290,310,90,24);
		bReset.setBounds(380,310,90,24);
		bPrint.setBounds(470,310,90,24);
		cmbQNo.setToolTipText("Question No.");
		cmbPaperId.setToolTipText("Paper Id");
		txtDescription.setToolTipText("Description");
		txtQDescription.setToolTipText("Question Description");
		chkIsActive.setToolTipText("IsActive");
		txtCorrectChoice.setToolTipText("Correct Choice");
		bSave.setToolTipText("Save");
		bSearch.setToolTipText("Search");
		bUpdate.setToolTipText("Update");
		bDelete.setToolTipText("Delete");
		bReset.setToolTipText("Reset");
		bPrint.setToolTipText("Print");
        p.setLayout(null);
        p.add(lblOnlineQuestionEntry);
        p.add(lblPaperId);
		p.add(lblQNo);
		p.add(lblDescription);
		p.add(lblQDescription);
		p.add(cmbPaperId);
		p.add(cmbQNo);
		p.add(txtDescription);
		p.add(txtQDescription);
		p.add(lblIsActive);
		p.add(lblCorrectChoice);
		p.add(chkIsActive);
		p.add(txtCorrectChoice);
		p.add(bSave);
		p.add(bSearch);
		p.add(bUpdate);
		p.add(bDelete);
		p.add(bReset);
		p.add(bPrint);
		fr.getContentPane().add(p);
		fr.setVisible(true);
		bSave.addActionListener(this);
		bSearch.addActionListener(this);
		bUpdate.addActionListener(this);
		bDelete.addActionListener(this);
		bReset.addActionListener(this);
		bPrint.addActionListener(this);
	    cmbPaperId.addActionListener(this);
	    cmbQNo.addActionListener(this);
	    cmbPaperId.addItemListener(this);
	    cmbQNo.addItemListener(this);
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
			rs=st.executeQuery("select max(QNo) from QuestionEntry");
			if(rs.next())
			{
			   rt=rs.getInt(1);
			   if(rt==0)
			   {
			   	rt=1;	
				cmbQNo.setSelectedItem(rt);
			   }
			   else
			   {
			   	rt=rt+1;
			   	cmbQNo.setSelectedItem(rt);
			   }
			}			
			
			
		}
		catch(SQLException e)
		{
			 JOptionPane.showMessageDialog(null,"Invalid Query"+e, " Online Question Entry ",JOptionPane.ERROR_MESSAGE );

		}
		catch(ClassNotFoundException e)
		{
			   JOptionPane.showMessageDialog(null,"Invalid Driver Class"+e, " Online Question Entry ",JOptionPane.ERROR_MESSAGE );

		}
	}
	public void clrscr()
	{
		cmbPaperId.setSelectedItem("");
		txtDescription.setText("");
		txtQDescription.setText("");
		chkIsActive.setSelected(false);
		txtCorrectChoice.setText("");
		
	}
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource()==bSave)
		{
			int x=0; String s="";
			try{
					if (chkIsActive.isSelected()==true)
						s="yes";
						else
						s="No";
					
				int r;
		        r=st.executeUpdate("insert into QuestionEntry values("+Integer.parseInt(cmbPaperId.getSelectedItem().toString())+",'"+txtDescription.getText()+"',"+Integer.parseInt(cmbQNo.getSelectedItem().toString())+",'"+txtQDescription.getText()+"','"+s+"','"+txtCorrectChoice.getText()+"')");
		        if(r>0)
                JOptionPane.showMessageDialog(null,"Record Saved...", " QuestionEntry ",JOptionPane.INFORMATION_MESSAGE );
		        clrscr();
		        rs=st.executeQuery("select max(QNo) from QuestionEntry");
			if(rs.next())
			{
			   rt=rs.getInt(1);
			   if(rt==0)
			   {
			   	rt=1;	
				cmbQNo.setSelectedItem(rt);
			   }
			   else
			   {
			   	rt=rt+1;
			   	cmbQNo.setSelectedItem(rt);
			   }
			}	
		 }
			catch(SQLException e)
			{
			 JOptionPane.showMessageDialog(null,"SQL Error"+e, " Online QuestionEntry ",JOptionPane.ERROR_MESSAGE );
			}
			
		}
		if(evt.getSource()==bSearch)
		{
			try{
				    isSearch=0;
				    clrscr();
				    cmbPaperId.removeAllItems();
				    cmbQNo.removeAllItems();
				
				rs=st.executeQuery("select QNo from QuestionEntry order by QNo");
				while(rs.next())
				{
					cmbQNo.addItem(rs.getInt("QNo"));
				}
				cmbQNo.setSelectedIndex(-1);
				isSearch=1;
			}
			catch(SQLException e)
			{
			 JOptionPane.showMessageDialog(null,"SQL Error"+e, " Online QuestionEntry ",JOptionPane.ERROR_MESSAGE );
			}
			
		}
		    if(evt.getSource()==bUpdate)
		    {
		    	isSearch=0;
			
					
			try{
				int x=0; String s="";
				if (chkIsActive.isSelected()==true)
				    s="yes";
				else
				    s="No";
				String s1;
			    s1=cmbQNo.getSelectedItem().toString();
			    int n=Integer.parseInt(s1);
			    int r;
			    r=st.executeUpdate("update QuestionEntry set PaperId='"+Integer.parseInt(cmbPaperId.getSelectedItem().toString())+"',Description="+txtDescription.getText()+",QDescription="+txtQDescription.getText()+",isActive="+s+",CorrectChoice="+txtCorrectChoice.getText()+" where QNo="+n+"");
			    if(r>0)
                JOptionPane.showMessageDialog(null,"Record Updated...", " Online Paper Entry ",JOptionPane.INFORMATION_MESSAGE );
			    clrscr();
			    //cmbPaperId.removeAllItems();
			    isSearch=1;
			}
			
			catch(SQLException e)
			{
			 JOptionPane.showMessageDialog(null,"SQL Error"+e, " Online Paper Entry ",JOptionPane.ERROR_MESSAGE );
			}
		    }
		    if(evt.getSource()==bDelete)
		    {
		    }
			if(evt.getSource()==bReset)
		{
			isSearch=0;
			clrscr();
			cmbQNo.removeAllItems();
			cmbPaperId.removeAllItems();
			try{
				rs=st.executeQuery("select max(QNo) from QuestionEntry");
			    if(rs.next())
			  {
			   rt=rs.getInt(1);
			   if(rt==0)
			   {
			   	rt=1;	
				cmbQNo.setSelectedItem(rt);
			   }
			   else
			   {
			   	rt=rt+1;
			   	cmbQNo.setSelectedItem(rt);
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
		
	}
	public void itemStateChanged(ItemEvent evt)
	 {
	 	/*if(evt.getSource()==cmbPaperId && isSearch==1 && cmbPaperId.getSelectedIndex()>=0)
	 	{
	 		
	 		try{
	 			
	 			cmbQNo.removeAllItems();
	 			isSearch=0;
	 		   rs=st.executeQuery("Select QNo from QuestionEntry where PaperId="+ Integer.parseInt(cmbPaperId.getSelectedItem().toString()) +" order by QNo");
			   while(rs.next())
			   {
				cmbQNo.addItem(rs.getInt("QNo"));
			   }
			   cmbQNo.setSelectedIndex(-1);	
			   isSearch=1;
			}
			catch(SQLException e)
		   {
			 JOptionPane.showMessageDialog(null,"Invalid Query"+e, " Online Question Entry ",JOptionPane.ERROR_MESSAGE );
		   }
		
	   }*/
	   if(evt.getSource()==cmbQNo && isSearch==1 && cmbQNo.getSelectedIndex()>=0)
	    {
	    	try{
	    		clrscr();
	    		String s=cmbQNo.getSelectedItem().toString();
	 		    int n=Integer.parseInt(s);
	 		     rs=st.executeQuery("select * from QuestionEntry where QNo="+n); 
	            if(rs.next())
	            {  	
	                cmbPaperId.setSelectedItem(rs.getInt("PaperId"));
	            	txtDescription.setText(rs.getString("Description"));
	            	txtQDescription.setText(rs.getString("QDescription"));
	            	String x=rs.getString("isActive");
	            	if(x.equals("yes")==true)
	            	chkIsActive.setSelected(true);
	            	else
	            	chkIsActive.setSelected(false);
	            	txtCorrectChoice.setText(rs.getString("CorrectChoice"));
	            }
	            
	    	}
	    	catch(SQLException e)
		    {
			 JOptionPane.showMessageDialog(null,"Invalid Query"+e, " Online Question Entry ",JOptionPane.ERROR_MESSAGE );
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
	 			 	txtDescription.setText(rs.getString("Description"));
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
		OnlineQuestionEntry obj= new OnlineQuestionEntry();
	}
}