import java.awt.*;       //All AWT Controls and classes
import javax.swing.*;
import javax.swing.border.*;    // All controls
import java.awt.event.*; //All events
import java.io.*;
import java.sql.*;
class OnlineAppearTestDetail implements ActionListener,ItemListener
{
	ResultSet rs;
	Connection cn;
	Statement st;
	JPanel p; 
	JFrame fr;
	String A,B,C,D;
	int isSearch=0,n;
	JLabel lblOnlineAppearTestDetail,lblCorrectAns,lblObtainedMarks;	
	JComboBox cmbAppearSrNo,cmbQNo;
	JTextField txtCorrectAns,txtObtainedMarks,txtQDescription;
	JCheckBox chkChA,chkChB,chkChC,chkChD;
	JLabel lblAppearSrNo,lblQNo,lblQDescription,lblChA,lblChB,lblChC,lblChD;
	JButton bSearch,bPrint;
    public OnlineAppearTestDetail() // Constructor
	{
		A="A";
		B="B";
		C="C";
		D="D";
		fr = new JFrame("Online Appear Test Detail...");
		lblOnlineAppearTestDetail=new JLabel("Online Appear Test Detail");
		lblAppearSrNo=new JLabel("Appear SrNo");
		lblQNo=new JLabel("QNo.");
		lblQDescription=new JLabel("QDescription");
		lblChA=new JLabel("  A");
		lblChB=new JLabel("  B");
		lblChC=new JLabel("  C");
		lblChD=new JLabel("  D");
		lblCorrectAns=new JLabel("CorrectAns");
		lblObtainedMarks=new JLabel("ObtainedMarks");
		cmbAppearSrNo=new JComboBox();
		cmbQNo=new JComboBox();
		txtCorrectAns=new JTextField();
		txtObtainedMarks=new JTextField();
		txtQDescription=new JTextField();
		chkChA=new JCheckBox();
		chkChB=new JCheckBox();
		chkChC=new JCheckBox();
		chkChD=new JCheckBox();
		p=new JPanel();
	
		bSearch=new JButton("Search");
		
		bPrint=new JButton("Print");
	
	
		fr.setSize(700,500);
		fr.setResizable(false);
		fr.setLocation(300,200);
		p.setBackground(new Color(200,200,200));
		lblOnlineAppearTestDetail.setBounds(100,20,500,25);
		lblOnlineAppearTestDetail.setForeground(new Color(1,110,234));
		lblOnlineAppearTestDetail.setFont(new Font("Wide Latin",Font.BOLD,20));
        lblAppearSrNo.setBounds(50,70,70,25);
		lblQNo.setBounds(50,105,50,25);
		lblQDescription.setBounds(50,140,80,25);
		lblChA.setBounds(130,200,20,25);
		lblChB.setBounds(130,235,20,25);
		lblChC.setBounds(130,270,20,25);
		lblChD.setBounds(130,305,20,25);
		cmbAppearSrNo.setBounds(130,70,100,25);
		cmbAppearSrNo.setEditable(true);
		txtQDescription.setBounds(130,140,500,50);
		lblCorrectAns.setBounds(130,345,100,25);
		lblObtainedMarks.setBounds(420,345,100,25);
		txtCorrectAns.setBounds(200,345,100,25);
		txtObtainedMarks.setBounds(510,345,100,25);
		cmbQNo.setBounds(130,105,100,25);
		cmbQNo.setEditable(true);
	    chkChA.setBounds(150,200,500,20);
		chkChB.setBounds(150,235,500,20);
		chkChC.setBounds(150,270,500,20);
		chkChD.setBounds(150,305,500,20);
		chkChA.setBackground(new Color(200,200,200));
		chkChB.setBackground(new Color(200,200,200));
		chkChC.setBackground(new Color(200,200,200));
		chkChD.setBackground(new Color(200,200,200));
		//bSave.setBounds(20,240,90,24);
		bSearch.setBounds(180,410,150,30);
		//bUpdate.setBounds(220,240,90,24);
		//bDelete.setBounds(320,240,90,24);
		bPrint.setBounds(370,410,150,30);
		bSearch.setToolTipText("SEARCH");
	    bPrint.setToolTipText("PRINT");
	    bSearch.setBackground(new Color(1,110,234));
		bSearch.setForeground(Color.white);
		bPrint.setBackground(new Color(1,110,234));
		bPrint.setForeground(Color.white);
        p.setLayout(null);
        p.add(lblOnlineAppearTestDetail);
        p.add(lblAppearSrNo);
		p.add(lblQNo);
		p.add(lblQDescription);
		p.add(lblCorrectAns);
		p.add(lblObtainedMarks);
		p.add(cmbAppearSrNo);
		p.add(cmbQNo);
		p.add(txtQDescription);
		p.add(txtCorrectAns);
		p.add(txtObtainedMarks);
		p.add(lblChA);
		p.add(lblChB);
		p.add(lblChC);
		p.add(lblChD);
		p.add(chkChA);
		p.add(chkChB);
		p.add(chkChC);
		p.add(chkChD);
		//p.add(bSave);
		p.add(bSearch);
		//p.add(bUpdate);
		//p.add(bDelete);
		p.add(bPrint);
		fr.getContentPane().add(p);
		fr.setVisible(true);
		cmbAppearSrNo.addItemListener(this);
		cmbQNo.addItemListener(this);
		bSearch.addActionListener(this);
	
		bPrint.addActionListener(this);
	    cmbAppearSrNo.addActionListener(this);
	    cmbQNo.addActionListener(this);
	    //fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    try{	
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		        //cn=DriverManager.getConnection("Jdbc:Odbc:OESPDSN");
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                       cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ns","ns");
			st=cn.createStatement();	   
			
			
		}
		catch(SQLException e)
		{
			 JOptionPane.showMessageDialog(null,"Invalid Query"+e, " Online Option Choice ",JOptionPane.ERROR_MESSAGE );

		}
		catch(ClassNotFoundException e)
		{
			 JOptionPane.showMessageDialog(null,"Driver Class Invalid"+e, " Online Option Choice ",JOptionPane.ERROR_MESSAGE );

		}
	}
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource()==bSearch)
		{
			try{
				isSearch=0;
				cmbQNo.removeAllItems();
				cmbAppearSrNo.removeAllItems();
	 			txtQDescription.setText("");
	 			chkChA.setSelected(false);
	 			chkChB.setSelected(false);
	 			chkChC.setSelected(false);
	 			chkChD.setSelected(false);
	 			chkChA.setText("");
	 			chkChB.setText("");
	 			chkChC.setText("");
	 			chkChD.setText("");
	 			txtCorrectAns.setText("");
	 			txtObtainedMarks.setText("");
				rs=st.executeQuery("Select distinct(AppearSrNo) from AppearTestDetail order by AppearSrNo");
				while(rs.next())
				{
					cmbAppearSrNo.addItem(rs.getInt("AppearSrNo"));
				}			
				cmbAppearSrNo.setSelectedIndex(-1);
				isSearch=1;
		   }
		   	catch(SQLException e)
		{
			 JOptionPane.showMessageDialog(null,"Invalid Query"+e, " Online Option Choice ",JOptionPane.ERROR_MESSAGE );

		}
			
		}
		
	}
	 public void itemStateChanged(ItemEvent evt)
	 {
	 	if(evt.getSource()==cmbAppearSrNo && isSearch==1)
	 	{
	 		try{
	 			isSearch=0;
	 			cmbQNo.removeAllItems();
	 			txtQDescription.setText("");
	 			chkChA.setSelected(false);
	 			chkChB.setSelected(false);
	 			chkChC.setSelected(false);
	 			chkChD.setSelected(false);
	 			chkChA.setText("");
	 			chkChB.setText("");
	 			chkChC.setText("");
	 			chkChD.setText("");
	 			txtCorrectAns.setText("");
	 			txtObtainedMarks.setText("");
		 		rs=st.executeQuery("select QNo from AppearTestDetail where AppearSrNo="+Integer.parseInt(cmbAppearSrNo.getSelectedItem().toString())+" order by QNo");
		 		while(rs.next())
		 		{
		 			cmbQNo.addItem(rs.getInt("QNo"));
		 		}
		 		cmbQNo.setSelectedIndex(-1);
		 		isSearch=1;
		 	}
	 	   	catch(SQLException e)
	        {
		         JOptionPane.showMessageDialog(null,"Invalid Query"+e, " Online Option Choice ",JOptionPane.ERROR_MESSAGE );
            }
	 	
	 	}
	 	if(evt.getSource()==cmbQNo && isSearch==1)
	 	{
	 		try{
	 			rs=st.executeQuery("select * from AppearTestDetail where AppearSrNo="+Integer.parseInt(cmbAppearSrNo.getSelectedItem().toString())+" and QNo="+Integer.parseInt(cmbQNo.getSelectedItem().toString()));
	 			if(rs.next())
	 			{
	 				txtQDescription.setText(rs.getString("QDescription"));
	 				n=rs.getInt("chA");
	 				if(n==1)
	 				chkChA.setSelected(true);
	 				else
	 				chkChA.setSelected(false);
	 				n=rs.getInt("chB");
	 				if(n==1)
	 				chkChB.setSelected(true);
	 				else
	 				chkChB.setSelected(false);
	 				n=rs.getInt("chC");
	 				if(n==1)
	 				chkChC.setSelected(true);
	 				else
	 				chkChC.setSelected(false);
	 				n=rs.getInt("chD");
	 				if(n==1)
	 				chkChD.setSelected(true);
	 				else
	 				chkChD.setSelected(false);
	 				txtCorrectAns.setText(rs.getString("CorrectAns"));
	 				txtObtainedMarks.setText(""+rs.getInt("ObtainedMarks"));
	 			}
	 			rs=st.executeQuery("select OptionDescription from OptionChoiceDetail where OptionId='"+A+"' and QNo="+Integer.parseInt(cmbQNo.getSelectedItem().toString()));
	 			if(rs.next())
	 			{
	 				chkChA.setText(rs.getString("OptionDescription"));
	 			}
	 			rs=st.executeQuery("select OptionDescription from OptionChoiceDetail where OptionId='"+B+"' and QNo="+Integer.parseInt(cmbQNo.getSelectedItem().toString()));
	 			if(rs.next())
	 			{
	 				chkChB.setText(rs.getString("OptionDescription"));
	 			}
	 			rs=st.executeQuery("select OptionDescription from OptionChoiceDetail where OptionId='"+C+"' and QNo="+Integer.parseInt(cmbQNo.getSelectedItem().toString()));
	 			if(rs.next())
	 			{
	 				chkChC.setText(rs.getString("OptionDescription"));
	 			}
	 			rs=st.executeQuery("select OptionDescription from OptionChoiceDetail where OptionId='"+D+"' and QNo="+Integer.parseInt(cmbQNo.getSelectedItem().toString()));
	 			if(rs.next())
	 			{
	 				chkChD.setText(rs.getString("OptionDescription"));
	 			}
	 		}
	 		catch(SQLException e)
	        {
		         JOptionPane.showMessageDialog(null,"Invalid Query"+e, " Online Option Choice ",JOptionPane.ERROR_MESSAGE );
            }
	 		
	 	} 
	 }
	public static void main(String s[])
	{
	    OnlineAppearTestDetail obj= new OnlineAppearTestDetail();
	}
}