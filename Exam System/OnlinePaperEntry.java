import java.awt.*;       //All AWT Controls and classes
import javax.swing.*;    // All controls
import java.awt.event.*; //All events
import javax.swing.border.*;
import java.sql.*;
class OnlinePaperEntry implements ActionListener,ItemListener
{
	ResultSet rs;
	Connection cn;
	Statement st;
	JPanel p; 
	int isSearch;
	JFrame fr;
	JLabel lblPaperEntry,lblMin,lblNegativeMarkingOnWrongAns;	
	JComboBox cmbPaperId;
	JTextField txtDescription,txtTotalMarks,txtNoOfQuestion,txtQualifyingPercentage,txtTotalTime,txtNegativeMarkingOnWrongAns;
	JLabel lblPaperId,lblDescription,lblTotalMarks,lblNoOfQuestion,lblQualifyingPercentage,lblTotalTime;
	JButton bSave,bSearch,bUpdate,bDelete,bReset,bPrint;
	
    public OnlinePaperEntry() // Constructor
	{
		isSearch=0;
		fr = new JFrame("OnlinePaperEntry...");
		lblPaperEntry=new JLabel("Paper Entry");
		lblPaperId=new JLabel("Paper Id");
		lblDescription=new JLabel("Description");
		lblTotalMarks=new JLabel("Total Marks");
		lblNoOfQuestion=new JLabel("Total Number Of Questions");
		lblQualifyingPercentage=new JLabel("Qualifying %ge");
		lblTotalTime=new JLabel("Total Time");
		lblNegativeMarkingOnWrongAns=new JLabel("Negative Marking On Wrong Ans");
		lblMin=new JLabel("min");
		cmbPaperId=new JComboBox();
		txtDescription=new JTextField(10);
		txtTotalMarks=new JTextField(10);
		txtNoOfQuestion=new JTextField(10);
		txtNegativeMarkingOnWrongAns=new JTextField(10);
		txtQualifyingPercentage=new JTextField(10);
		txtTotalTime=new JTextField(10);
		p=new JPanel();
		bSave=new JButton("NEW");
		bSearch=new JButton("SEARCH");
		bUpdate=new JButton("UPDATE");
		bDelete=new JButton("DELETE");
		bReset=new JButton("RESET");
		bPrint=new JButton("PRINT");
		


		//third.setEnabled(false);
		fr.setSize(600,400);
		fr.setResizable(false);
		fr.setLocation(400,210);
		p.setBackground(new Color(200,200,200));
	//	p.setBackground(new Color(12,225,125));
		lblPaperEntry.setBounds(160,20,300,25);
		lblPaperEntry.setForeground(new Color(1,110,234));
		lblPaperEntry.setFont(new Font("Wide Latin",Font.BOLD,23));
		lblPaperId.setBounds(50,70,70,25);
		lblDescription.setBounds(50,115,70,25);
		lblTotalMarks.setBounds(50,160,70,25);
		txtTotalMarks.setBounds(130,160,70,25);
		txtTotalMarks.setFont(new Font("DejaVu Sans Mono",Font.BOLD,12));
		lblNoOfQuestion.setBounds(220,160,200,25);
		txtNoOfQuestion.setBounds(410,160,100,25);
		txtNoOfQuestion.setFont(new Font("DejaVu Sans Mono",Font.BOLD,12));
		lblQualifyingPercentage.setBounds(50,205,90,25);
		txtQualifyingPercentage.setBounds(140,205,60,25);
		txtQualifyingPercentage.setFont(new Font("DejaVu Sans Mono",Font.BOLD,12));
		lblNegativeMarkingOnWrongAns.setBounds(220,205,200,25);
		txtNegativeMarkingOnWrongAns.setBounds(410,205,100,25);
		txtNegativeMarkingOnWrongAns.setFont(new Font("DejaVu Sans Mono",Font.BOLD,12));
		lblTotalTime.setBounds(370,70,70,25);
		cmbPaperId.setBounds(130,70,110,25);
		cmbPaperId.setFont(new Font("DejaVu Sans Mono",Font.BOLD,12));
		cmbPaperId.setEditable(true);
		txtDescription.setBounds(130,115,410,25);
		txtDescription.setFont(new Font("DejaVu Sans Mono",Font.BOLD,12));
		txtTotalTime.setBounds(450,70,50,25);
		txtTotalTime.setFont(new Font("DejaVu Sans Mono",Font.BOLD,12));
		lblMin.setBounds(510,70,40,25);
		bSave.setBounds(15,300,90,24);
		bSearch.setBounds(110,300,90,24);
		bUpdate.setBounds(205,300,90,24);
		bDelete.setBounds(300,300,90,24);
		bReset.setBounds(395,300,90,24);
		bPrint.setBounds(490,300,90,24);
		cmbPaperId.setToolTipText("Paper Id");
		txtDescription.setToolTipText("Description");
		txtTotalTime.setToolTipText("Total Time");
		txtTotalMarks.setToolTipText("Total Marks");
		txtNoOfQuestion.setToolTipText("No. of Question");
		txtQualifyingPercentage.setToolTipText("Qualifying Percentage");
		
		bSave.setToolTipText("NEW");
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
		
		Border bd=BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.red,Color.green);
		bd=BorderFactory.createLineBorder(Color.WHITE,10);
		//p.setBorder(bd);
		fr.setDefaultLookAndFeelDecorated(true);
		/*bSave.setBorder(bd);
		bSearch.setBorder(bd);
		bUpdate.setBorder(bd);
		bDelete.setBorder(bd);
		bRESET.setBorder(bd);
		bPrint.setBorder(bd);*/
		//p.setBorder(bd);
        p.setLayout(null);
        p.add(lblPaperEntry);
		p.add(cmbPaperId);
		p.add(txtDescription);
		p.add(txtTotalMarks);
		p.add(txtNoOfQuestion);
		p.add(txtQualifyingPercentage);
		p.add(txtTotalTime);
		p.add(bSave);
		p.add(bSearch);
		p.add(bUpdate);
		p.add(bDelete);
		p.add(bReset);
		p.add(bPrint);
		p.add(lblPaperId);
		p.add(lblDescription);
		p.add(lblTotalMarks);
		p.add(lblNoOfQuestion);
		p.add(lblQualifyingPercentage);
		p.add(lblTotalTime);
		p.add(lblMin);
		p.add(lblNegativeMarkingOnWrongAns);
		p.add(txtNegativeMarkingOnWrongAns);
		fr.getContentPane().add(p);
		fr.setVisible(true);
		bSave.addActionListener(this);
		bSearch.addActionListener(this);
		bUpdate.addActionListener(this);
		bDelete.addActionListener(this);
		bReset.addActionListener(this);
		bPrint.addActionListener(this);
	    cmbPaperId.addActionListener(this);
	    cmbPaperId.addItemListener(this);
		//fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try{	
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		        //cn=DriverManager.getConnection("Jdbc:Odbc:OESPDSN");
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ns","ns");
		        st=cn.createStatement();	   
		         rs=st.executeQuery("Select distinct * from AppearTest order by AppearSrNo");
			//st=Admin.connectO().createStatement();			
			
			
		}
		catch(SQLException e)
		{
			 JOptionPane.showMessageDialog(null,"Invalid Query"+e, " Online Option Choice ",JOptionPane.ERROR_MESSAGE );

		}
		catch(ClassNotFoundException e)
		{
			 JOptionPane.showMessageDialog(null,"Driver Class Invalid"+e, " Online Option Choice ",JOptionPane.ERROR_MESSAGE );

		}
                 catch(Exception e)
		{
			 JOptionPane.showMessageDialog(null,"Invalid Query"+e, " Online Option Choice ",JOptionPane.ERROR_MESSAGE );

		}
	}
	public void clrscr()
	{
		cmbPaperId.setSelectedItem("");
		txtDescription.setText("");
		txtTotalMarks.setText("");
		txtNoOfQuestion.setText("");
		txtQualifyingPercentage.setText("");
		txtTotalTime.setText("");
	}
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource()==bSave)
		{
			try{
				bSearch.setBackground(new Color(1,110,234));
				bSearch.setForeground(Color.white);
				if(bSave.getText()=="NEW")
				{
					isSearch=0;
					cmbPaperId.setEditable(true);
					cmbPaperId.removeAllItems();
					clrscr();
					bSave.setText("SAVE");
					bSave.setToolTipText("SAVE");
					bSave.setBackground(Color.white);
					bSave.setForeground(Color.BLUE);
				}
				else
				{
					int r;
			        r=st.executeUpdate("insert into PaperEntry values("+Integer.parseInt(cmbPaperId.getSelectedItem().toString())+",'"+txtDescription.getText()+"',"+Integer.parseInt(txtTotalMarks.getText())+","+Integer.parseInt(txtNoOfQuestion.getText())+","+Integer.parseInt(txtQualifyingPercentage.getText())+","+Integer.parseInt(txtTotalTime.getText())+","+Integer.parseInt(txtNegativeMarkingOnWrongAns.getText())+")");
			        if(r>0)
	                JOptionPane.showMessageDialog(null,"Record Saved...", " Online Paper Entry ",JOptionPane.INFORMATION_MESSAGE );
				    bSave.setText("NEW");
				    bSave.setToolTipText("NEW");
				    bSave.setBackground(new Color(1,110,234));
				    bSave.setForeground(Color.white);
			   }
			}
			catch(SQLException e)
			{
			 JOptionPane.showMessageDialog(null,"SQL Error"+e, " Online Paper Entry ",JOptionPane.ERROR_MESSAGE );
			}
			
			
		}
		if(evt.getSource()==bSearch)
		{
			try{
			      
				  isSearch=0;
				  clrscr();    
		          cmbPaperId.removeAllItems();
				//cmbPaperId.addItem("");
				rs=st.executeQuery("select PaperId from PaperEntry order by PaperId");
				while(rs.next())
				{
					cmbPaperId.addItem(rs.getInt("PaperId"));
				}
				cmbPaperId.setSelectedIndex(-1);
				bSave.setText("NEW");
				bSave.setToolTipText("NEW");
				bSave.setBackground(new Color(1,110,234));
				bSave.setForeground(Color.white);
				bSearch.setBackground(Color.white);
				bSearch.setForeground(Color.blue);
				
				JOptionPane.showMessageDialog(null,"Please select any PaperId", " Online Paper Entry ",JOptionPane.INFORMATION_MESSAGE );
				//String select="Select";
				  cmbPaperId.setEditable(true);
				  cmbPaperId.setSelectedItem("Select");
				  isSearch=1;
				  cmbPaperId.setEditable(false);
				
			}
			catch(SQLException e)
			{
			 JOptionPane.showMessageDialog(null,"SQL Error"+e, " Online Paper Entry ",JOptionPane.ERROR_MESSAGE );
			}
						
			
		}
		if(evt.getSource()==bUpdate)
		{
			
			
			if(cmbPaperId.getSelectedItem().equals("")==false && cmbPaperId.getSelectedItem().equals("Select")==false)
			{		
			try{
				isSearch=0;
				bSave.setText("NEW");
				bSave.setToolTipText("NEW");
				bSave.setBackground(new Color(1,110,234));
				bSave.setForeground(Color.white);
				bSearch.setBackground(new Color(1,110,234));
				bSearch.setForeground(Color.white);
				bUpdate.setBackground(Color.white);
				bUpdate.setForeground(Color.blue);
				String s;
			    s=cmbPaperId.getSelectedItem().toString();
			    int n=Integer.parseInt(s);
			    int x=JOptionPane.showConfirmDialog(null,"Are you sure", " Online Paper Entry ",JOptionPane.YES_NO_OPTION);
			    if(x==0)
			    {
				    int r;
				    r=st.executeUpdate("update PaperEntry set Description='"+txtDescription.getText()+"',TotalMarks="+txtTotalMarks.getText()+",NoOfQuestion="+txtNoOfQuestion.getText()+",QualifyingPercentage="+txtQualifyingPercentage.getText()+",TotalTime="+txtTotalTime.getText()+" where PaperId="+n+"");
				    if(r>0)
	                JOptionPane.showMessageDialog(null,"Record Updated...", " Online Paper Entry ",JOptionPane.INFORMATION_MESSAGE );
				    
				    //cmbPaperId.removeAllItems();
				    
				    bSearch.setBackground(Color.white);
				    bSearch.setForeground(Color.blue);
				    bUpdate.setBackground(new Color(1,110,234));
				    bUpdate.setForeground(Color.white);
				    cmbPaperId.setEditable(true);
				    clrscr();
				    cmbPaperId.setSelectedItem("Select");
				    cmbPaperId.setEditable(false);
				    isSearch=1;
				}
				else
				{
					cmbPaperId.setEditable(true);
					clrscr();
				    bSearch.setBackground(Color.white);
				    bSearch.setForeground(Color.blue);
				    bUpdate.setBackground(new Color(1,110,234));
				    bUpdate.setForeground(Color.white);
				    cmbPaperId.setSelectedItem("Select");
				    cmbPaperId.setEditable(false);
				    isSearch=1;
				}
			}
			
			catch(SQLException e)
			{
			 JOptionPane.showMessageDialog(null,"SQL Error"+e, " Online Paper Entry ",JOptionPane.ERROR_MESSAGE );
			}
			
		  }
		  else
		  {
		  	JOptionPane.showMessageDialog(null,"Update operation fail", " Online Paper Entry ",JOptionPane.INFORMATION_MESSAGE);
		  }
	    }
		if(evt.getSource()==bDelete)
		{
			if(cmbPaperId.getSelectedItem().equals("")==false && cmbPaperId.getSelectedItem().equals("Select")==false)
			{
			  isSearch=0;
			try{
				bSave.setText("NEW");
				bSave.setToolTipText("NEW");
				bSave.setBackground(new Color(1,110,234));
				bSave.setForeground(Color.white);
				bSearch.setBackground(new Color(1,110,234));
				bSearch.setForeground(Color.white);
				bDelete.setBackground(Color.white);
				bDelete.setForeground(Color.blue);
				String s;
				int i=cmbPaperId.getSelectedIndex();
			    s=cmbPaperId.getSelectedItem().toString();
			    int n=Integer.parseInt(s);
			    int r;
			    int x=JOptionPane.showConfirmDialog(null,"Are you sure", " Online Paper Entry ",JOptionPane.YES_NO_OPTION);
			    if(x==0)
			    {
				    r=st.executeUpdate("delete from PaperEntry where PaperId="+n);
				    if(r>0)
	                JOptionPane.showMessageDialog(null,"one Record Delete...", " Online Paper Entry ",JOptionPane.INFORMATION_MESSAGE );
				    cmbPaperId.removeItemAt(i);
				    bSearch.setBackground(Color.white);
				    bSearch.setForeground(Color.blue);
				    bDelete.setBackground(new Color(1,110,234));
				    bDelete.setForeground(Color.white);
				    cmbPaperId.setEditable(true);
				    clrscr();
				    cmbPaperId.setSelectedItem("Select");
				    cmbPaperId.setEditable(false);
				    isSearch=1;
			    }
			    else
			    {
			    	bSearch.setBackground(Color.white);
				    bSearch.setForeground(Color.blue);
				    bDelete.setBackground(new Color(1,110,234));
				    bDelete.setForeground(Color.white);
				    cmbPaperId.setEditable(true);
				    clrscr();
				    cmbPaperId.setSelectedItem("Select");
				    cmbPaperId.setEditable(false);
				    isSearch=1;
			    }
			}
			catch(SQLException e)
			{
			 JOptionPane.showMessageDialog(null,"SQL Error"+e, " Online Paper Entry ",JOptionPane.ERROR_MESSAGE );
			}
		 }
		 else
		  {
		  	JOptionPane.showMessageDialog(null,"Delete operation fail", " Online Paper Entry ",JOptionPane.INFORMATION_MESSAGE);
		  }
			
		}
		if(evt.getSource()==bReset)
		{
			isSearch=0;
			cmbPaperId.setEditable(true);
			bReset.setBackground(Color.white);
		    bReset.setForeground(Color.blue);
			bSave.setText("NEW");
			bSave.setToolTipText("NEW");
			cmbPaperId.removeAllItems();
			clrscr();
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
			
		}
		
	}
     public void itemStateChanged(ItemEvent evt)
	 {
	 	if(evt.getSource()==cmbPaperId && isSearch==1)
	 	{
	 		try{
	 			cmbPaperId.setEditable(false);
	 			String s=cmbPaperId.getSelectedItem().toString();
	 		    int n=Integer.parseInt(s);
	 		     rs=st.executeQuery("select * from PaperEntry where PaperId="+n); 
	            if(rs.next())
	            {
	            	
	            	txtDescription.setText(rs.getString("Description"));
	                txtTotalMarks.setText(String.valueOf(rs.getInt("TotalMarks")));
					txtNoOfQuestion.setText(String.valueOf(rs.getInt("NoOfQuestion")));
					txtQualifyingPercentage.setText(String.valueOf(rs.getInt("QualifyingPercentage")));
					txtTotalTime.setText(String.valueOf(rs.getInt("TotalTime")));
	            	
	            }
	 		}
	 		catch(SQLException e)
			{
			 JOptionPane.showMessageDialog(null,"SQL Error"+e, " Online Paper Entry ",JOptionPane.ERROR_MESSAGE );
			}
	 	}
	 }
	public static void main(String s[])
	{
		OnlinePaperEntry obj= new OnlinePaperEntry();
	}
}