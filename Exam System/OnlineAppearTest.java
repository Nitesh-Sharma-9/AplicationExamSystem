import java.awt.*;       //All AWT Controls and classes
import javax.swing.*;
import javax.swing.border.*;    // All controls
import java.awt.event.*; //All events
import java.io.*;
import java.sql.*;
class OnlineAppearTest implements ActionListener,ItemListener
{
	ResultSet rs;
	Connection cn;
	Statement st;
	JPanel p; 
	int isSearch;
	JFrame fr;
	JLabel lblOnlineAppearTest;	
	JComboBox cmbRegNo,cmbPaperId;
	JTextField txtAppearSrNo,txtAppearDt,txtRegNo,txtApplicantName,txtPaperName,txtAppearingTime,txtTotalTime,txtCurrentTime,txtTimeRemg;
	JCheckBox chkChA,chkChB,chkChC,chkChD;
	JLabel lblAppearSrNo,lblAppearDt,lblRegNo,lblApplicantName,lblPaperId,lblPaperName,lblAppearingTime,lblTotalTime,lblCurrentTime,lblTimeRemg;
	JButton bSearch,bPrint;
	JLabel lblTotalObtainedMarks,lblObtainedPercentage;
	JTextField txtTotalObtainedMarks,txtObtainedPercentage;
    public OnlineAppearTest() // Constructor
	{
		fr = new JFrame("Online Appear Test...");
		lblOnlineAppearTest=new JLabel("Online Appear Test");
		
		lblAppearSrNo=new JLabel("Appear SrNo");
		lblAppearDt=new JLabel("Appear Date");
		lblRegNo=new JLabel("RegNo");
		lblApplicantName=new JLabel("Applicant Name");
		lblPaperId=new JLabel("Paper Id");
		lblPaperName=new JLabel("Paper Name");
		lblAppearingTime=new JLabel("Appearing Time");
		lblTotalTime=new JLabel("Total Time");
		lblCurrentTime=new JLabel("Current Time");
		lblTimeRemg=new JLabel("Time Remaining");
		lblTotalObtainedMarks=new JLabel("TotalObtainedMarks");
		lblObtainedPercentage=new JLabel("ObtainedPercentage");
		txtAppearSrNo=new JTextField();
		cmbRegNo=new JComboBox();
		cmbPaperId=new JComboBox();
        txtAppearDt=new JTextField();
        txtApplicantName=new JTextField();
        txtPaperName=new JTextField();
        txtAppearingTime=new JTextField();
        txtTotalTime=new JTextField();
        txtCurrentTime=new JTextField();
        txtTimeRemg=new JTextField();
		p=new JPanel();
		
		bSearch=new JButton("Search");
		bPrint=new JButton("Print");
		txtTotalObtainedMarks=new JTextField();
		txtObtainedPercentage=new JTextField();
		fr.setSize(620,500);
		fr.setLocation(400,90);
		fr.setResizable(false);
		p.setBackground(new Color(200,200,200));
		lblOnlineAppearTest.setBounds(120,20,400,25);
		lblOnlineAppearTest.setForeground(new Color(1,110,234));
		lblOnlineAppearTest.setFont(new Font("Wide Latin",Font.BOLD,22));
		//lblOnlineAppearTest.setFont(Font);
        lblRegNo.setBounds(50,70,100,25);
		lblPaperId.setBounds(350,70,100,25);
		lblAppearSrNo.setBounds(50,115,90,25);
		lblApplicantName.setBounds(50,160,100,25);
		lblAppearDt.setBounds(350,115,70,25);
		lblPaperName.setBounds(50,205,70,25);
		lblAppearingTime.setBounds(50,250,100,25);
		lblTotalTime.setBounds(350,250,70,25);
		lblCurrentTime.setBounds(50,295,100,25);
		lblTimeRemg.setBounds(350,295,70,25);
		cmbRegNo.setBounds(140,70,130,25);
		cmbRegNo.setEditable(true);
		txtAppearSrNo.setBounds(140,115,130,25);
		txtAppearSrNo.setEditable(true);
		txtAppearDt.setBounds(430,115,130,25);
		cmbPaperId.setBounds(430,70,130,25);
		cmbPaperId.setEditable(true);
		txtApplicantName.setBounds(140,160,300,25);
		txtPaperName.setBounds(140,205,300,25);
		txtAppearingTime.setBounds(140,250,130,25);
		txtTotalTime.setBounds(430,250,130,25);
		txtCurrentTime.setBounds(140,295,130,25);
		txtTimeRemg.setBounds(430,295,130,25);
		lblTotalObtainedMarks.setBounds(50,340,130,25);
		lblObtainedPercentage.setBounds(350,340,130,25);
		txtTotalObtainedMarks.setBounds(170,340,100,25);
		txtObtainedPercentage.setBounds(460,340,100,25);
	    bSearch.setToolTipText("SEARCH");
	    bPrint.setToolTipText("PRINT");
	    bSearch.setBackground(new Color(1,110,234));
		bSearch.setForeground(Color.white);
		bPrint.setBackground(new Color(1,110,234));
		bPrint.setForeground(Color.white);
		bSearch.setBounds(160,400,120,35);
		bPrint.setBounds(360,400,120,35);
        p.setLayout(null);
        p.add(lblOnlineAppearTest);
        p.add(lblAppearSrNo);
		p.add(lblAppearDt);
		p.add(lblRegNo);
		p.add(lblApplicantName);
		p.add(lblPaperId);
		p.add(lblPaperName);
		p.add(lblAppearingTime);
		p.add(lblTotalTime);
		p.add(lblCurrentTime);
		p.add(lblTimeRemg);
		p.add(txtAppearSrNo);
		p.add(cmbRegNo);
		p.add(cmbPaperId);
		p.add(txtAppearDt);
		p.add(txtApplicantName);
		p.add(txtPaperName);
		p.add(txtAppearingTime);
		p.add(txtTotalTime);
		p.add(txtCurrentTime);
		p.add(txtTimeRemg);
		p.add(lblTotalObtainedMarks);
		p.add(lblObtainedPercentage);
		p.add(txtTotalObtainedMarks);
		p.add(txtObtainedPercentage);
		p.add(bSearch);
		p.add(bPrint);
		fr.getContentPane().add(p);
		fr.setVisible(true);
	
		bSearch.addActionListener(this);
		
		bPrint.addActionListener(this);
	    
	    cmbRegNo.addActionListener(this);
	    
	    cmbRegNo.addItemListener(this);
	    
	   // fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    try{	
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		       // cn=DriverManager.getConnection("Jdbc:Odbc:OESPDSN");
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
	public void clrscr()
	{
		        txtAppearSrNo.setText("");
		        cmbPaperId.setSelectedItem("");
		        //cmbRegNo.setSelectedItem("");
		        txtAppearDt.setText("");
            	txtApplicantName.setText("");
            	txtPaperName.setText("");
            	txtAppearingTime.setText("");
            	txtTotalTime.setText("");
            	txtCurrentTime.setText("");
            	txtTimeRemg.setText("");
		        txtTotalObtainedMarks.setText("");
		        txtObtainedPercentage.setText("");
            	
	}
	public void actionPerformed(ActionEvent evt)
	{
	
		if(evt.getSource()==bSearch)
		{
			try{
				isSearch=0;
				clrscr();
				cmbRegNo.removeAllItems();
				rs=st.executeQuery("Select distinct(RegNo) from AppearTest order by RegNo");
			    while(rs.next())
			    {
				cmbRegNo.addItem(rs.getInt("RegNo"));
			    }
			    cmbRegNo.setSelectedIndex(-1);
			    isSearch=1;
		
		  }
		  catch(SQLException e)
		  {
			 JOptionPane.showMessageDialog(null,"Invalid Query..", " Online Appear Test ",JOptionPane.ERROR_MESSAGE );
		  }
		
	   }
  }
	 public void itemStateChanged(ItemEvent evt)
	 {
	 	if(evt.getSource()==cmbRegNo && isSearch==1 && cmbRegNo.getSelectedIndex()>=0)
	 	{
	 		try{
	 			isSearch=0;
	 			clrscr();
		 	    String s=cmbRegNo.getSelectedItem().toString();
		 	    int n=Integer.parseInt(s);
		 	    //cmbPaperId.removeAllItems();
		 	    rs=st.executeQuery("select * from AppearTest where RegNo="+n);
		 	    if(rs.next())
		 	    {
		 	    	txtAppearSrNo.setText(""+rs.getInt("AppearSrNo"));
		 	    	cmbPaperId.setSelectedItem(rs.getInt("PaperId"));
		 	    	txtAppearDt.setText(rs.getString("AppearDt"));
	            	txtApplicantName.setText(rs.getString("Applicantname"));
	            	txtPaperName.setText(rs.getString("PaperName"));
	            	txtAppearingTime.setText(rs.getString("AppearingTime"));
	            	txtTotalTime.setText(String.valueOf(rs.getInt("TotalTime")));
	            	txtCurrentTime.setText(rs.getString("CurrentTime"));
	            	txtTimeRemg.setText(rs.getString("TimeRemg"));
	            	txtTotalObtainedMarks.setText(""+rs.getInt("TotalObtainedMarks"));
		            txtObtainedPercentage.setText(""+rs.getInt("ObtainedPercentage"));
	            	
		 	    } 
		 	    
		 	    isSearch=1;
		 	    
		 	 }
		 	 catch(SQLException e)
		  {
			 JOptionPane.showMessageDialog(null,"Invalid Query..", " Online Appear Test ",JOptionPane.ERROR_MESSAGE );
		  }	
	 	}
	 	
	 	
	 	
	 }
	public static void main(String s[])
	{
	    OnlineAppearTest obj= new OnlineAppearTest();
	}
}