import java.text.SimpleDateFormat;
import java.awt.*;       //All AWT Controls and classes
import javax.swing.*;
import java.awt.event.*; //All events
import java.io.*;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.*;
class OnlineChoice
{
	int chk1,chk2,chk3,chk4; 
	public OnlineChoice()
	{
	   
	   chk1=0;
	   chk2=0;
	   chk3=0;
	   chk4=0;
	}
	public void setData(int c1,int c2,int c3,int c4)
	{
		chk1=c1;
		chk2=c2;
		chk3=c3;
		chk4=c4;
	}
	
	int getC1()
	{
		return chk1;
	}
	int getC2()
	{
		return chk2;
	}
	int getC3()
	{
		return chk3;
	}
	int getC4()
	{
		return chk4;
	}
	
    
}
public class OnlineTestExam extends JFrame implements ActionListener,KeyListener,Runnable
{
	public int td,hr1,min1,k,j,cnt,l,t,w,h,mq,r1,r2,qes,tom;
    public int hr,min,sec,AM,marks;
	public String AMPM;
    String cs;
    ResultSet rs;
	Connection cn;
	Statement st;
	JFrame fr;
	JPanel p; 
	int i=0,x,rt,rt1;
	Thread threadX;
	OnlineChoice oc[],oc1[];
	JLabel lblOnlineExamTest,lblSelectChoice,lblStart,lblPrev,lblNext,lblStartTime,lblTimeDuration;;
	JLabel lblRegNo,lblApplicantName,lblPaperId,lblTotalMarks,lblTotalTime,lblMarksForEachQn;
	JLabel lblTotalNoOfQn,lblQNo,lblDescription,lblQDescription,lblCurrentTime,lblRemainingTime;
	JLabel lblSave,lblCancel,lblNegativeMarkingOnWrongAns,lblMinute1,lblDate;
	JTextField txtRegNo,txtPaperId,txtApplicantName,txtDescription,txtTotalMarks,txtTotalTime;
	JTextField txtTotalNoOfQn,txtQNo,txtStartTime,txtTimeDuration,txtCurrentTime,txtRemainingTime;
	JTextArea txtQDescription;
	JCheckBox chkA,chkB,chkC,chkD;
	JLabel lblA,lblB,lblC,lblD,lblMinute,lblLine1,lblLine2,lblLine3,lblLine4,lblLine5,lblQnList;
	JButton bStart,bPrev,bNext,bSave,bCancel;
	JTextField txtMarksForEachQn,txtNegativeMarkingOnWrongAns,txtDate;
	JButton btn[];
	JLabel TestImage1,TestImage2,TestImage3,TestImage4;
	JLabel title;
	
	public  OnlineTestExam()
	{
		tom=0;
		hr=0;
		min=0;
		sec=0;
		AM=0;
		k=0;
		j=0;
		td=0;
		hr1=0;
		min1=0;
		threadX=new Thread(this);
		fr = new JFrame("Online Exam Test");
		
		p=new JPanel();
		
		
        
		lblOnlineExamTest=new JLabel("ONLINE EXAM TEST");
		lblDate=new JLabel("DATE");
		lblRegNo=new JLabel("REG.NO.");
		//lblRegNo.setFont(new Font("Courier New",Font.BOLD,10));
		lblPaperId=new JLabel("PAPER ID");
		//lblPaperId.setFont(new Font("Courier New",Font.BOLD,10));
		lblApplicantName=new JLabel("APPLICANT NAME");
		//lblApplicantName.setFont(new Font("Courier New",Font.BOLD,10));
		lblDescription=new JLabel("DESCRIPTION");
		//lblDescription.setFont(new Font("Courier New",Font.BOLD,10));
		lblTotalMarks=new JLabel("TOTAL MARKS");
		//lblTotalMarks.setFont(new Font("Courier New",Font.BOLD,10));
		lblTotalTime=new JLabel("TOTAL TIME");
		//lblTotalTime.setFont(new Font("Courier New",Font.BOLD,10));
		lblMinute1=new JLabel("MIN");
		//lblMinute1.setFont(new Font("Courier New",Font.BOLD,10));
		lblTotalNoOfQn=new JLabel("TOTAL NO. OF QN");
		//lblTotalNoOfQn.setFont(new Font("Courier New",Font.BOLD,10));
		lblMarksForEachQn=new JLabel("Marks For Each Qn");
		//lblMarksForEachQn.setFont(new Font("Courier New",Font.BOLD,10));
		lblNegativeMarkingOnWrongAns=new JLabel("NEGATIVE MARKING ON WRONG ANS");
		//lblNegativeMarkingOnWrongAns.setFont(new Font("Courier New",Font.BOLD,10));
		lblQNo=new JLabel("QNO");
		//lblQNo.setFont(new Font("Courier New",Font.BOLD,10));
		lblQDescription=new JLabel("QDESCRIPTION");
		//lblQDescription.setFont(new Font("Courier New",Font.BOLD,10));
		lblStart=new JLabel("START");
		//lblStart.setFont(new Font("Courier New",Font.BOLD,10));
		lblPrev=new JLabel("PREV");
		//lblPrev.setFont(new Font("Courier New",Font.BOLD,10));
		lblNext=new JLabel("NEXT");
		//lblNext.setFont(new Font("Courier New",Font.BOLD,10));
		lblStartTime=new JLabel("START TIME");
		//lblStartTime.setFont(new Font("Courier New",Font.BOLD,10));
		lblTimeDuration=new JLabel("TOTAL DURATION");
		//lblTimeDuration.setFont(new Font("Courier New",Font.BOLD,10));
		lblMinute=new JLabel("MIN");
		//lblMinute.setFont(new Font("Courier New",Font.BOLD,10));
		lblCurrentTime=new JLabel("CURRRENT TIME");
		//lblCurrentTime.setFont(new Font("Courier New",Font.BOLD,10));
		lblRemainingTime=new JLabel("REMAINING TIME");
		//lblRemainingTime.setFont(new Font("Courier New",Font.BOLD,10));
		lblSave=new JLabel("SAVE");
		//lblSave.setFont(new Font("Courier New",Font.BOLD,10));
		lblCancel=new JLabel("CANCEL");
		//lblCancel.setFont(new Font("Courier New",Font.BOLD,12));
		title=new JLabel("       ABES-EC COLLEGE GZB");
		
		txtDate=new JTextField(20);
		txtRegNo=new JTextField(10);
		txtRegNo.setFont(new Font("Simplified Arabic Fixed",Font.BOLD,16));
		txtPaperId=new JTextField(10);
		txtPaperId.setFont(new Font("Simplified Arabic Fixed",Font.BOLD,16));
		txtApplicantName=new JTextField(10);
		txtApplicantName.setFont(new Font("Simplified Arabic Fixed",Font.BOLD,16));
		txtDescription=new JTextField(10);
		txtDescription.setFont(new Font("Simplified Arabic Fixed",Font.BOLD,16));
		txtTotalMarks=new JTextField(10);
		txtTotalMarks.setFont(new Font("Simplified Arabic Fixed",Font.BOLD,16));
		txtTotalTime=new JTextField(10);
		txtTotalTime.setFont(new Font("Simplified Arabic Fixed",Font.BOLD,16));
		txtTotalNoOfQn=new JTextField(10);
		txtTotalNoOfQn.setFont(new Font("Simplified Arabic Fixed",Font.BOLD,16));
		txtMarksForEachQn=new JTextField(10);
		txtMarksForEachQn.setFont(new Font("Simplified Arabic Fixed",Font.BOLD,16));
		txtNegativeMarkingOnWrongAns=new JTextField(10);
		txtNegativeMarkingOnWrongAns.setFont(new Font("Simplified Arabic Fixed",Font.BOLD,16));
		txtQNo=new JTextField();
		txtQNo.setFont(new Font("Simplified Arabic Fixed",Font.BOLD,16));
		txtQDescription=new JTextArea(150,10);
		txtQDescription.setColumns(150);
		txtQDescription.setLineWrap(true);
		txtQDescription.setRows(10);
		txtQDescription.setFont(new Font("Simplified Arabic Fixed",Font.BOLD,16));
		chkA=new JCheckBox();
		chkA.setFont(new Font("Simplified Arabic Fixed",Font.BOLD,16));
		chkB=new JCheckBox();
		chkB.setFont(new Font("Simplified Arabic Fixed",Font.BOLD,16));
		chkC=new JCheckBox();
		chkC.setFont(new Font("Simplified Arabic Fixed",Font.BOLD,16));
		chkD=new JCheckBox();
		chkD.setFont(new Font("Simplified Arabic Fixed",Font.BOLD,16));
		lblA=new JLabel("A");
		lblB=new JLabel("B");
		lblC=new JLabel("C");
		lblD=new JLabel("D");
		
		
		ImageIcon img1=new ImageIcon("TestImage1.png");
        TestImage1=new JLabel("",img1,JLabel.CENTER);
        ImageIcon img2=new ImageIcon("TestImage2.png");
        TestImage2=new JLabel("",img2,JLabel.CENTER);
        //ImageIcon img3=new ImageIcon("TestImage3.jpg");
        //TestImage3=new JLabel("",img3,JLabel.CENTER);
        //ImageIcon img4=new ImageIcon("TestImage4.jpg");
        //TestImage4=new JLabel("",img4,JLabel.CENTER);
        TestImage1.setBounds(80,5,80,80);
        TestImage2.setBounds(620,5,80,80);
        //TestImage4.setBounds(100,70,200,50);
        //TestImage3.setBounds(350,70,200,50);
	
		title.setBounds(180,45,420,20);
		title.setForeground(Color.white);
		title.setFont(new Font("Simplified Arabic Fixed",Font.BOLD,18));
		title.setOpaque(true);
		title.setBackground(new Color(200,21,23));
	
	    bStart=new JButton("START");
	    bStart.setBackground(new Color(1,110,234));
		bStart.setForeground(Color.white);
		bPrev=new JButton("PREV");
		bPrev.setBackground(new Color(1,110,234));
		bPrev.setForeground(Color.white);
		bNext=new JButton("NEXT");
		bNext.setBackground(new Color(1,110,234));
		bNext.setForeground(Color.white);
		txtStartTime=new JTextField(10);
		txtStartTime.setFont(new Font("Simplified Arabic Fixed",Font.BOLD,18));
	    txtTimeDuration=new JTextField(10);
	    txtTimeDuration.setFont(new Font("Simplified Arabic Fixed",Font.BOLD,18));
	    txtCurrentTime=new JTextField(10);
	    txtCurrentTime.setFont(new Font("Simplified Arabic Fixed",Font.BOLD,18));
	    txtRemainingTime=new JTextField(10);
	    txtRemainingTime.setFont(new Font("Simplified Arabic Fixed",Font.BOLD,18));
	    bSave=new JButton("SAVE");
	    bSave.setBackground(new Color(1,110,234));
		bSave.setForeground(Color.white);
		bCancel=new JButton("CANCEL");
		bCancel.setBackground(new Color(1,110,234));
		bCancel.setForeground(Color.white);
	    
	    lblQnList=new JLabel("    QUESTION OPTIONS"); 
	     
	    lblLine1=new JLabel("");
	    lblLine2=new JLabel("");
	    lblLine3=new JLabel("");
	    lblLine4=new JLabel("");
	    lblLine5=new JLabel("");
	     
	    
        
		setResizable(false);
		
		fr.setSize(1380,750);
		fr.setLocation(0,0);
		
		p.setBackground(new Color(200,200,200));
	    lblOnlineExamTest.setBounds(160,15,500,30);
		lblOnlineExamTest.setForeground(Color.YELLOW);
		lblOnlineExamTest.setFont(new Font("Wide Latin",Font.BOLD,23));
		lblDate.setBounds(800,65,60,25);
		txtDate.setBounds(840,65,120,25);
		txtDate.setFont(new Font("Simplified Arabic Fixed",Font.BOLD,16));
		lblRegNo.setBounds(50,70,50,25);
		txtRegNo.setBounds(140,70,100,25);
		lblApplicantName.setBounds(245,70,100,25);
		txtApplicantName.setBounds(340,70,200,25);
		
		
		lblRegNo.setBounds(1000,175,100,35);
		txtRegNo.setBounds(1100,175,100,35);
		//txtRegNo.setBackground(Color.LIGHT_GRAY);
		lblApplicantName.setBounds(1000,210,100,35);
		txtApplicantName.setBounds(1100,210,230,35);
	    //txtApplicantName.setBackground(Color.LIGHT_GRAY);
		
		
		
		lblPaperId.setBounds(5,115,70,25);
		txtPaperId.setBounds(75,115,100,25);
		lblDescription.setBounds(200,115,80,25);
		txtDescription.setBounds(290,115,200,25);
		lblTotalMarks.setBounds(500,115,80,25);
		txtTotalMarks.setBounds(590,115,100,25);
		lblTotalTime.setBounds(700,115,80,25);
		txtTotalTime.setBounds(790,115,100,25);
		lblMinute1.setBounds(891,115,30,25);
		lblTotalNoOfQn.setBounds(5,160,120,25);
		txtTotalNoOfQn.setBounds(135,160,40,25);
		lblMarksForEachQn.setBounds(185,160,150,25);
		txtMarksForEachQn.setBounds(345,160,40,25);
		lblNegativeMarkingOnWrongAns.setBounds(395,160,200,25);
		txtNegativeMarkingOnWrongAns.setBounds(655,160,40,25);
		lblQNo.setBounds(50,205,50,25);
		txtQNo.setBounds(140,205,120,25);
		lblQDescription.setBounds(50,235,100,25);
		txtQDescription.setBounds(140,235,820,25);
		
		
		
		//txtRegNo.setEditable(false);
		txtApplicantName.setEditable(false);
		txtApplicantName.setBackground(Color.white);
		txtPaperId.setEditable(false);
		txtPaperId.setBackground(Color.white);
		txtDescription.setEditable(false);
		txtDescription.setBackground(Color.white);
		txtTotalMarks.setEditable(false);
		txtTotalMarks.setBackground(Color.white);
		txtTotalTime.setEditable(false);
		txtTotalTime.setBackground(Color.white);
		txtTotalNoOfQn.setEditable(false);
		txtTotalNoOfQn.setBackground(Color.white);
		txtMarksForEachQn.setEditable(false);
		txtMarksForEachQn.setBackground(Color.white);
		txtNegativeMarkingOnWrongAns.setEditable(false);
		txtNegativeMarkingOnWrongAns.setBackground(Color.white);
		txtQNo.setEditable(false);
		txtQNo.setBackground(Color.white);
		txtQDescription.setEditable(false);
		txtQDescription.setBackground(Color.white);
		

		
		
		//lblSelectChoice.setBounds(140,340,180,25);
		//lblSelectChoice.setForeground(Color.blue);
		//lblSelectChoice.setFont(new Font("Wide Latin",Font.ITALIC,12));
		lblA.setBounds(143,320,10,20);
		lblB.setBounds(143,360,10,20);
		lblC.setBounds(143,400,10,20);
		lblD.setBounds(143,440,10,20);
		
		chkA.setBounds(150,320,580,20);
		chkB.setBounds(150,360,580,20);
		chkC.setBounds(150,400,580,20);
		chkD.setBounds(150,440,580,20);
		chkA.setBackground(new Color(200,200,200));
		chkB.setBackground(new Color(200,200,200));
		chkC.setBackground(new Color(200,200,200));
		chkD.setBackground(new Color(200,200,200));
		bStart.setBounds(150,480,120,25);
		bNext.setBounds(470,480,120,25);
		bPrev.setBounds(790,480,120,25);
		
		
		
		lblStartTime.setBounds(1000,20,120,25);
		txtStartTime.setBounds(1130,20,150,25);
		lblTimeDuration.setBounds(1000,55,150,25);
		txtTimeDuration.setBounds(1130,55,120,25);
		lblMinute.setBounds(1251,55,30,25);
		lblCurrentTime.setBounds(1000,90,120,25);
		txtCurrentTime.setBounds(1130,90,150,25);
		lblRemainingTime.setBounds(1000,125,120,25);
		txtRemainingTime.setBounds(1130,125,150,25);
		txtStartTime.setBackground(Color.white);
		txtTimeDuration.setBackground(Color.white);
		txtCurrentTime.setBackground(Color.white);
		txtRemainingTime.setBackground(Color.white);
		
		
		lblQnList.setBounds(1000,250,270,25);
		lblQnList.setFont(new Font("Wide Latin",Font.BOLD,12));
		lblQnList.setOpaque(true);
		lblQnList.setBackground(Color.red);
		lblQnList.setForeground(Color.white);
		
		bSave.setBounds(1000,600,130,35);
	    bCancel.setBounds(1200,600,130,35);
		
		lblLine1.setBounds(0,94,980,4);
		lblLine1.setOpaque(true);
		lblLine1.setBackground(Color.red);
		
		lblLine2.setBounds(980,0,4,750);
		lblLine2.setOpaque(true);
		lblLine2.setBackground(Color.red);
		
		lblLine3.setBounds(0,535,980,4);
		lblLine3.setOpaque(true);
		lblLine3.setBackground(Color.red);
		
		lblLine4.setBounds(0,195,980,4);
		lblLine4.setOpaque(true);
		lblLine4.setBackground(Color.red);
		
		lblLine5.setBounds(980,160,420,4);
		lblLine5.setOpaque(true);
		lblLine5.setBackground(Color.red);
		
		
		
		//Date d=new Date();
		GregorianCalendar c= new GregorianCalendar();
		AM=c.get(Calendar.AM_PM);
		min=c.get(Calendar.MINUTE);
		sec=c.get(Calendar.SECOND);
		hr=(c.get(Calendar.HOUR)+8);
		
		if(hr>=8 && hr<=11 && AM==0)
	    AM=1;
		else if(hr>=12 && hr<=19 &&AM==0) AM=0;
		else if(hr>=8 && hr<=11 && AM==1)  AM=0;
		else if(hr==12 && AM==1)  AM=1;
		else if(hr>=13 && hr<=19 && AM==0)  AM=1;
		else if(hr>=8 && hr<=19 && AM==1)  AM=1;
		


		if(AM==1) AMPM="PM"; else AMPM="AM";
		hr=hr%12;
		

		
		
		p.setLayout(null);
	    p.add(TestImage1);
	    p.add(TestImage2);
	    //p.add(TestImage3);
	    //p.add(TestImage4);
	    p.add(lblOnlineExamTest);
	    p.add(lblDate);
	    p.add(txtDate);
	    p.add(lblRegNo);
	    p.add(txtRegNo);
	    p.add(lblPaperId);
	    p.add(txtPaperId);
	    p.add(lblApplicantName);
	    p.add(txtApplicantName);
	    p.add(lblDescription);
	    p.add(txtDescription);
	    p.add(lblTotalMarks);
	    p.add(txtTotalMarks);
	    p.add(lblTotalTime);
	    p.add(txtTotalTime);
	    p.add(lblMinute1);
	    p.add(lblTotalNoOfQn);
	    p.add(txtTotalNoOfQn);
	    p.add(lblMarksForEachQn);
	    p.add(txtMarksForEachQn);
	    p.add(lblNegativeMarkingOnWrongAns);
	    p.add(txtNegativeMarkingOnWrongAns);	
	    p.add(lblQNo);
	    p.add(txtQNo);
	    p.add(lblQDescription);
	    p.add(txtQDescription);
	    //p.add(lblSelectChoice);	
	    p.add(chkA);
	    p.add(chkB);
	    p.add(chkC);
	    p.add(chkD);
	    p.add(lblA);
	    p.add(lblB);
	    p.add(lblC);
	    p.add(lblD);
	    p.add(bStart);
	    p.add(bNext);
	    p.add(bPrev);
	    p.add(lblStartTime);
	    p.add(lblTimeDuration);
	    p.add(lblCurrentTime);
	    p.add(lblRemainingTime);
	    p.add(txtStartTime);
	    p.add(txtTimeDuration);
	    p.add(lblMinute);
	    p.add(txtCurrentTime);
	    p.add(txtRemainingTime);
	    p.add(bSave);
	    p.add(bCancel);
	    p.add(lblLine1);
	    p.add(lblLine2);
	    p.add(lblLine3);
	    p.add(lblLine4);
	    p.add(lblLine5);
	    p.add(lblQnList);
	    p.add(title);
	    
	    
	    fr.setResizable(false);	    
	    fr.getContentPane().add(p);
	    fr.setVisible(true);
	    txtRegNo.addKeyListener(this);
	    bStart.addActionListener(this);
	    bNext.addActionListener(this);
	    bPrev.addActionListener(this);
	    bSave.addActionListener(this);
	    bCancel.addActionListener(this);
	    //fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    try{	
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//Class.forName("oracle.jdbc.driver.OracleDriver");
               Class.forName("oracle.jdbc.driver.OracleDriver");
               cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ns","ns");
		      //cn=DriverManager.getConnection("Jdbc:Odbc:OESPDSN");
			st=cn.createStatement();	
			
			rs=st.executeQuery("select count(QNo) from QuestionEntry");
			if(rs.next())
			{
			   cnt=rs.getInt(1);
			}
			btn=new JButton[cnt];
			for(int i1=0;i1<cnt;i1++)
			btn[i1]=new JButton(""+(i1+1));
			l=1000;t=295;w=50;h=35;
			for(int j1=0;j1<cnt;j1++)
			{
				if(j1<5)
				{
					 btn[j1].setBounds(l,t,w,h);
				     btn[j1].setBackground(new Color(1,110,234));
		             btn[j1].setForeground(Color.white);
				     l=l+w+5;
				     if(j1==4)
				     {
				         l=1000;
				         t=t+h+10;
				     }
			     
			     }
			     else if(j1>4 && j1<10)
			     {
			     	btn[j1].setBounds(l,t,w,h);
			     	btn[j1].setBackground(new Color(1,110,234));
		             btn[j1].setForeground(Color.white);
			     	l=l+w+5;
				     if(j1==9)
				     {
				         l=1000;
				         t=t+h+10;
				     }
			     }
			     else if(j1>9 && j1<15)
			     {
			     	btn[j1].setBounds(l,t,w,h);
			     	btn[j1].setBackground(new Color(1,110,234));
		             btn[j1].setForeground(Color.white);
			     	l=l+w+5;
				     if(j1==14)
				     {
				         l=1000;
				         t=t+h+10;
				     }
			     }			   
			     else if(j1>14 && j1<20)
			     {
			     	btn[j1].setBounds(l,t,w,h);
			     	btn[j1].setBackground(new Color(1,110,234));
		             btn[j1].setForeground(Color.white);
			     	l=l+w+5;
				     if(j1==19)
				     {
				         l=1000;
				         t=t+h+10;
				     }
			     }
			     else if(j1>19 && j1<25)
			     {
			     	btn[j1].setBounds(l,t,w,h);
			     	btn[j1].setBackground(new Color(1,110,234));
		             btn[j1].setForeground(Color.white);
			     	l=l+w+5;
				     if(j1==24)
				     {
				         l=1000;
				         t=t+h+10;
				     }
			     }			   			   
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
		
		for(int z=0;z<cnt;z++)
		{
			p.add(btn[z]);
			btn[z].addActionListener(this);
			btn[z].setEnabled(false);
		}
		txtQNo.setEnabled(false);
		txtQDescription.setEnabled(false);
		chkA.setEnabled(false);
		chkB.setEnabled(false);
		chkC.setEnabled(false);
		chkD.setEnabled(false);
		bStart.setEnabled(false);
		bNext.setEnabled(false);
		bPrev.setEnabled(false);
		
		
     }
     public void run()
     {
     	try{
     		
     		txtTimeDuration.setEditable(true);
     		txtTimeDuration.setEnabled(true);
     		td=Integer.parseInt(txtTimeDuration.getText());
     		if(td>=60)
     		{
     			
     		while(td>=60)
			    {
			    	hr1=td/60;
			    	td=td%60;
			    	min1=td;
			    }
			   }
			   else
			   {
			   	min1=td;
			   }
			   //JOptionPane.showMessageDialog(null,"ok", " Online Option Choice ",JOptionPane.ERROR_MESSAGE );
     		for(int i2=sec,j=0;;i2++,j--)
     		{
		     	 k=j;
		     	Thread.sleep(1000);
		     	if(i2==60 && min<59)
		     	{
		     		
			
					
		     	  i2=0;
		     	  min=min+1;
		     	  if((hr>=0 && hr<=9) && (min>=0 && min<=9) && (i2>=0 && i2<=9) ) 
		     	   txtCurrentTime.setText("0"+hr+":"+"0"+min+":"+"0"+i2+" "+AMPM);
		     	   else if((hr>=0 && hr<=9) && (min>=0 && min<=9) && (i2>9) ) 
		     	   txtCurrentTime.setText("0"+hr+":"+"0"+min+":"+i2+" "+AMPM);
		     	  else if((hr>=0 && hr<=9) && (min>9) && (i2>=0 && i2<=9) ) 
		     	   txtCurrentTime.setText("0"+hr+":"+min+":"+"0"+i2+" "+AMPM);
		     	   else if((hr>=0 && hr<=9) && (min>9) && ( i2>9) ) 
		     	   txtCurrentTime.setText("0"+hr+":"+min+":"+i2+" "+AMPM);
		     	   else if((hr>9) && (min>=0 && min<=9) && (i2>=0 && i2<=9) ) 
		     	   txtCurrentTime.setText(""+hr+":"+"0"+min+":"+"0"+i2+" "+AMPM);
		     	   else if((hr>9) && (min>=0 && min<=9) && (i2>9) ) 
		     	   txtCurrentTime.setText(""+hr+":"+"0"+min+":"+i2+" "+AMPM);
		     	    else if((hr>9) && (min>9) && (i2>=0 && i2<=9) ) 
		     	   txtCurrentTime.setText(""+hr+":"+min+":"+"0"+i2+" "+AMPM);
		     	   else //r>9) && (min>9) && (i>9) ) 
		     	   txtCurrentTime.setText(""+hr+":"+min+":"+i2+" "+AMPM);
		     	   
		     	   
		     	   
		     	     
		        }
		        else if(i2==60 && min==59)
		        {
		        	if(hr==11 && min==59 && i2==60 && AMPM=="AM")
					{
						AMPM="PM";
						hr=0;
					}
					
		     	    else if(hr==11 && min==59 && i2==60 && AMPM=="PM")
		     	    {
		     	        AMPM="AM";
		     	        hr=0;
		     	    }
		     	    else
		     	    hr=hr+1;
		        	
		        	i2=0;
		        	
		        	
		        	min=0;
		        	if((hr>=0 && hr<=9) && (min>=0 && min<=9) && (i2>=0 && i2<=9) ) 
		     	   txtCurrentTime.setText("0"+hr+":"+"0"+min+":"+"0"+i2+" "+AMPM);
		     	   else if((hr>=0 && hr<=9) && (min>=0 && min<=9) && (i2>9) ) 
		     	   txtCurrentTime.setText("0"+hr+":"+"0"+min+":"+i2+" "+AMPM);
		     	  else if((hr>=0 && hr<=9) && (min>9) && (i2>=0 && i2<=9) ) 
		     	   txtCurrentTime.setText("0"+hr+":"+min+":"+"0"+i2+" "+AMPM);
		     	   else if((hr>=0 && hr<=9) && (min>9) && ( i2>9) ) 
		     	   txtCurrentTime.setText("0"+hr+":"+min+":"+i2+" "+AMPM);
		     	   else if((hr>9) && (min>=0 && min<=9) && (i2>=0 && i2<=9) ) 
		     	   txtCurrentTime.setText(""+hr+":"+"0"+min+":"+"0"+i2+" "+AMPM);
		     	   else if((hr>9) && (min>=0 && min<=9) && (i2>9) ) 
		     	   txtCurrentTime.setText(""+hr+":"+"0"+min+":"+i2+" "+AMPM);
		     	    else if((hr>9) && (min>9) && (i2>=0 && i2<=9) ) 
		     	   txtCurrentTime.setText(""+hr+":"+min+":"+"0"+i2+" "+AMPM);
		     	   else //((hr>9) && (min>9) && (i>9) ) 
		     	   txtCurrentTime.setText(""+hr+":"+min+":"+i2+" "+AMPM);
		     	   
		        }
		        
		        else
		        {
		        	
					if(hr==11 && min==59 && i2==60 && AMPM=="AM")
					{
						AMPM="PM";
						hr=0;
					}
					
		     	    else if(hr==11 && min==59 && i2==60 && AMPM=="PM")
		     	    {
		     	        AMPM="AM";
		     	        hr=0;
		     	    }
		     	    
			        if((hr>=0 && hr<=9) && (min>=0 && min<=9) && (i2>=0 && i2<=9) ) 
		     	   txtCurrentTime.setText("0"+hr+":"+"0"+min+":"+"0"+i2+" "+AMPM);
		     	   else if((hr>=0 && hr<=9) && (min>=0 && min<=9) && (i2>9) ) 
		     	   txtCurrentTime.setText("0"+hr+":"+"0"+min+":"+i2+" "+AMPM);
		     	  else if((hr>=0 && hr<=9) && (min>9) && (i2>=0 && i2<=9) ) 
		     	   txtCurrentTime.setText("0"+hr+":"+min+":"+"0"+i2+" "+AMPM);
		     	   else if((hr>=0 && hr<=9) && (min>9) && ( i2>9) ) 
		     	   txtCurrentTime.setText("0"+hr+":"+min+":"+i2+" "+AMPM);
		     	   else if((hr>9) && (min>=0 && min<=9) && (i2>=0 && i2<=9) ) 
		     	   txtCurrentTime.setText(""+hr+":"+"0"+min+":"+"0"+i2+" "+AMPM);
		     	   else if((hr>9) && (min>=0 && min<=9) && (i2>9) ) 
		     	   txtCurrentTime.setText(""+hr+":"+"0"+min+":"+i2+" "+AMPM);
		     	    else if((hr>9) && (min>9) && (i2>=0 && i2<=9) ) 
		     	   txtCurrentTime.setText(""+hr+":"+min+":"+"0"+i2+" "+AMPM);
		     	   else //((hr>9) && (min>9) && (i>9) ) 
		     	   txtCurrentTime.setText(""+hr+":"+min+":"+i2+" "+AMPM);
			       
		     	   
			     }
			     
			    
	        
	          
	           
		           
	           	  if(k==0)
	           	    {
				    if((hr1>=0 && hr1<=9) && (min1>=0 && min1<=9) && (k>=0 && k<=9) ) 
			     	   txtRemainingTime.setText("0"+hr1+":"+"0"+min1+":"+"0"+k);
			     	   else if((hr1>=0 && hr1<=9) && (min1>=0 && min1 <=9) && (k>9) ) 
			     	   txtRemainingTime.setText("0"+hr1+":"+"0"+min1+":"+k);
			     	  else if((hr1>=0 && hr1<=9) && (min1 >9) && (k>=0 && k<=9) ) 
			     	   txtRemainingTime.setText("0"+hr1+":"+min1+":"+"0"+k);
			     	   else if((hr1>=0 && hr1<=9) && (min1 >9) && ( k>9) ) 
			     	   txtRemainingTime.setText("0"+hr1+":"+min1+":"+k);
			     	   else if((hr1>9) && (min1>=0 && min1 <=9) && (k>=0 && k<=9) ) 
			     	   txtRemainingTime.setText(""+hr1+":"+"0"+min1+":"+"0"+k);
			     	   else if((hr1>9) && (min1>=0 && min1 <=9) && (k>9) ) 
			     	   txtRemainingTime.setText(""+hr1+":"+"0"+min1+":"+k);
			     	    else if((hr1>9) && (min1>9) && (k>=0 && k<=9) ) 
			     	   txtRemainingTime.setText(""+hr1+":"+min1+":"+"0"+k);
			     	   else //((hr>9) && (min>9) && (sec>9) ) 
			     	   txtRemainingTime.setText(""+hr1+":"+min1+":"+k);
			     	   
			     	   if(hr1==0 && min1==0 && k==0)
			     	   {
			     	   	     txtQNo.setText("");
							txtQDescription.setText("");
							txtRegNo.setEditable(false);
							
							chkA.setText("");
							chkB.setText("");
							chkC.setText("");
							chkD.setText("");
				     	   	 bNext.setEnabled(false);
				     	   	 bPrev.setEnabled(false);
				     	   	 txtQNo.setEnabled(false);
							txtQDescription.setEnabled(false);
							chkA.setEnabled(false);
							chkB.setEnabled(false);
							chkC.setEnabled(false);
							chkD.setEnabled(false);
							for(int z=0;z<cnt;z++)
							{
								btn[z].setEnabled(false);
							}
				     	   	 JOptionPane.showMessageDialog(null,"TIME OVER....", "Online Exam Test ",JOptionPane.WARNING_MESSAGE );
				     	   	 threadX.stop();
				     	   	 
			     	   	 
			     	   	 
			     	   }
			     	   if(min1==0)
			     	   {
				     	   min1=59;
				     	   if(hr1>0)
				     	   hr1=hr1-1;
			           }
			     	   else
			     	   min1=min1-1;
			     	   
			     	   j=60;
			     }
			     else
			     {
			     	
			     	if((hr1>=0 && hr1<=9) && (min1>=0 && min1<=9) && (k>=0 && k<=9) ) 
			     	   txtRemainingTime.setText("0"+hr1+":"+"0"+min1+":"+"0"+k);
			     	   else if((hr1>=0 && hr1<=9) && (min1>=0 && min1 <=9) && (k>9) ) 
			     	   txtRemainingTime.setText("0"+hr1+":"+"0"+min1+":"+k);
			     	  else if((hr1>=0 && hr1<=9) && (min1 >9) && (k>=0 && k<=9) ) 
			     	   txtRemainingTime.setText("0"+hr1+":"+min1+":"+"0"+k);
			     	   else if((hr1>=0 && hr1<=9) && (min1 >9) && ( k>9) ) 
			     	   txtRemainingTime.setText("0"+hr1+":"+min1+":"+k);
			     	   else if((hr1>9) && (min1>=0 && min1 <=9) && (k>=0 && k<=9) ) 
			     	   txtRemainingTime.setText(""+hr1+":"+"0"+min1+":"+"0"+k);
			     	   else if((hr1>9) && (min1>=0 && min1 <=9) && (k>9) ) 
			     	   txtRemainingTime.setText(""+hr1+":"+"0"+min1+":"+k);
			     	    else if((hr1>9) && (min1>9) && (k>=0 && k<=9) ) 
			     	   txtRemainingTime.setText(""+hr1+":"+min1+":"+"0"+k);
			     	   else //((hr>9) && (min>9) && (sec>9) ) 
			     	   txtRemainingTime.setText(""+hr1+":"+min1+":"+k);
			     }
			     	  
			     	 
			}   
	     }
	     catch(Exception e)
		 {
				JOptionPane.showMessageDialog(null,"Invalid Thread"+e, " Online Option Choice ",JOptionPane.ERROR_MESSAGE );
		 }
     } 
     public void actionPerformed(ActionEvent evt)
	{
		
		if(evt.getSource()==bStart)
		{
			
			String s;
			//threadX.stop();
			txtDate.setText("");
			txtStartTime.setText("");
			txtQNo.setEnabled(true);
			txtQDescription.setEnabled(true);
			chkA.setEnabled(true);
			chkB.setEnabled(true);
			chkC.setEnabled(true);
			chkD.setEnabled(true);
			bNext.setEnabled(true);
			bPrev.setEnabled(true);
			
			try{
				
				for(int y=0;y<cnt;y++)
			     btn[y].setEnabled(true);
				//Thread threadX=new Thread(this);		
		        
				rs=st.executeQuery("select TotalTime from RegistrationTest where RegNo="+Integer.parseInt(txtRegNo.getText()));
				if(rs.next())
				{
					txtTimeDuration.setText(""+rs.getInt("TotalTime"));
				}
				
				oc=new OnlineChoice[Integer.parseInt(txtTotalNoOfQn.getText())];
				for(int j5=0;j5<oc.length;j5++)
				oc[j5]=new OnlineChoice();
			
					
				rs=st.executeQuery("select min(QNo) from QuestionEntry");
			    if(rs.next())
			    {
			    	txtQNo.setText(""+rs.getInt(1));
			    	
			    }
			    int n=Integer.parseInt(txtQNo.getText());
			    rs=st.executeQuery("select QDescription from QuestionEntry where QNo="+n);  
			    if(rs.next())
			    {
			        txtQDescription.setText(rs.getString("QDescription"));	
			    }
			    int n1=Integer.parseInt(txtQNo.getText());
			    rs=st.executeQuery("select  OptionDescription from OptionChoiceDetail where QNo="+(n1));
			    if(rs.next())
			    {
			        chkA.setText(rs.getString("OptionDescription"));
			    }
			    if(rs.next())
			    {
			        chkB.setText(rs.getString("OptionDescription"));
			    }
			    if(rs.next())
			    {
			        chkC.setText(rs.getString("OptionDescription"));
			    }
			    if(rs.next())
			    {
			        chkD.setText(rs.getString("OptionDescription"));
			    }
			     bStart.setEnabled(false);
			    
			     if((hr>=0 && hr<=9) && (min>=0 && min <=9) && (sec>=0 && sec<=9) ) 
		     	   txtStartTime.setText("0"+hr+":"+"0"+min+":"+"0"+sec+" "+AMPM);
		     	   else if((hr>=0 && hr<=9) && (min>=0 && min <=9) && (sec>9) ) 
		     	   txtStartTime.setText("0"+hr+":"+"0"+min+":"+sec+" "+AMPM);
		     	  else if((hr>=0 && hr<=9) && (min >9) && (sec>=0 && sec<=9) ) 
		     	   txtStartTime.setText("0"+hr+":"+min+":"+"0"+sec+" "+AMPM);
		     	   else if((hr>=0 && hr<=9) && (min >9) && ( sec>9) ) 
		     	   txtStartTime.setText("0"+hr+":"+min+":"+sec+" "+AMPM);
		     	   else if((hr>9) && (min>=0 && min <=9) && (sec>=0 && sec<=9) ) 
		     	   txtStartTime.setText(""+hr+":"+"0"+min+":"+"0"+sec+" "+AMPM);
		     	   else if((hr>9) && (min>=0 && min <=9) && (sec>9) ) 
		     	   txtStartTime.setText(""+hr+":"+"0"+min+":"+sec+" "+AMPM);
		     	    else if((hr>9) && (min>9) && (sec>=0 && sec<=9) ) 
		     	   txtStartTime.setText(""+hr+":"+min+":"+"0"+sec+" "+AMPM);
		     	   else //((hr>9) && (min>9) && (sec>9) ) 
		     	   txtStartTime.setText(""+hr+":"+min+":"+sec+" "+AMPM);
			    
			    
			    
			    threadX.start();
			    
			    txtStartTime.setEditable(false);
			    txtTimeDuration.setEditable(false);
			    txtCurrentTime.setEditable(false);
			    txtRemainingTime.setEditable(false);
			    txtRegNo.setEditable(false);
			    
			    TestDt dt=new TestDt();
			    txtDate.setText(dt.TodayDate);
		  }
			catch(SQLException e)
		    {
			 JOptionPane.showMessageDialog(null,"Invalid Query"+e, " Online Option Choice ",JOptionPane.ERROR_MESSAGE );
		    }
		    catch(ArrayIndexOutOfBoundsException e)
		    {
			 JOptionPane.showMessageDialog(null,"Invalid Array"+e, " Online Option Choice ",JOptionPane.ERROR_MESSAGE );
		    }
		    catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Invalid Thread in start "+e, " Online Option Choice ",JOptionPane.ERROR_MESSAGE );
			}
			
		}
		if(evt.getSource()==bNext)
		{
			try{
				rs=st.executeQuery("select max(QNo) from QuestionEntry");
				if(rs.next())
				{
				   mq=rs.getInt(1);
				}
				 if(Integer.parseInt(txtQNo.getText())<mq)
				{
					i=Integer.parseInt(txtQNo.getText());
				
				
				   int s1,s2,s3,s4;
				 if(chkA.isSelected()==true)
				  s1=1;
				 else
				  s1=0;
				 if(chkB.isSelected()==true)
				  s2=1;
				 else
				  s2=0;
				 if(chkC.isSelected()==true)
				  s3=1;
				 else
				  s3=0;
				 if(chkD.isSelected()==true)
				  s4=1;
				 else
				  s4=0;
				   
				   
				   oc[(i-1)].setData(s1,s2,s3,s4);
				   i=i+1;
				   
				
				   
				   if(oc[(i-1)].getC1()==1)
				  	chkA.setSelected(true);
				  	else
				  	chkA.setSelected(false);
				  	
				  	if(oc[(i-1)].getC2()==1)
				  	chkB.setSelected(true);
				  	else
				  	chkB.setSelected(false);
				  	
				  	if(oc[(i-1)].getC3()==1)
				  	chkC.setSelected(true);
				  	else
				  	chkC.setSelected(false);
				  	
				  	if(oc[(i-1)].getC4()==1)
				  	chkD.setSelected(true);
				  	else
				  	chkD.setSelected(false);
				
				//int n=Integer.parseInt(txtPaperId.getText());
				int m=Integer.parseInt(txtQNo.getText());
				rs=st.executeQuery("select QNo,QDescription from QuestionEntry where QNo>"+m);
				if(rs.next())
				{
					txtQNo.setText(""+rs.getInt("QNo"));
					txtQDescription.setText(rs.getString("QDescription"));
				}
				int m1=Integer.parseInt(txtQNo.getText());
			    rs=st.executeQuery("select  OptionDescription from OptionChoiceDetail where QNo="+(m1));
			    if(rs.next())
			    {
			        chkA.setText(rs.getString("OptionDescription"));
			    }
			    if(rs.next())
			    {
			        chkB.setText(rs.getString("OptionDescription"));
			    }
			    if(rs.next())
			    {
			        chkC.setText(rs.getString("OptionDescription"));
			    }
			    if(rs.next())
			    {
			        chkD.setText(rs.getString("OptionDescription"));
			    }
			  }
			  else{}
			  //JOptionPane.showMessageDialog(null,"now Question the end", " Online Option Choice ",JOptionPane.ERROR_MESSAGE );	
			}
			catch(SQLException e)
		    {
			 JOptionPane.showMessageDialog(null,"Invalid Query"+e, " Online Option Choice ",JOptionPane.ERROR_MESSAGE );
		    }
		    catch(ArrayIndexOutOfBoundsException e)
		    {
			 JOptionPane.showMessageDialog(null,"Invalid Array"+e, " Online Option Choice ",JOptionPane.ERROR_MESSAGE );
		    }
		}
		if(evt.getSource()==bPrev)
		{
			try{
				 if(Integer.parseInt(txtQNo.getText())>1)
				{
					i=Integer.parseInt(txtQNo.getText());
				int s1,s2,s3,s4;
				 if(chkA.isSelected()==true)
				  s1=1;
				 else
				  s1=0;
				 if(chkB.isSelected()==true)
				  s2=1;
				 else
				  s2=0;
				 if(chkC.isSelected()==true)
				  s3=1;
				 else
				  s3=0;
				 if(chkD.isSelected()==true)
				  s4=1;
				 else
				  s4=0;
				   
				   
				   oc[(i-1)].setData(s1,s2,s3,s4);
				   i=i-1;
				  
				  
				    if(oc[(i-1)].getC1()==1)
				  	chkA.setSelected(true);
				  	else
				  	chkA.setSelected(false);
				  	
				  	if(oc[(i-1)].getC2()==1)
				  	chkB.setSelected(true);
				  	else
				  	chkB.setSelected(false);
				  	
				  	if(oc[(i-1)].getC3()==1)
				  	chkC.setSelected(true);
				  	else
				  	chkC.setSelected(false);
				  	
				  	if(oc[(i-1)].getC4()==1)
				  	chkD.setSelected(true);
				  	else
				  	chkD.setSelected(false);
				  	
				
				
				int m=Integer.parseInt(txtQNo.getText());
				rs=st.executeQuery("select max(QNo)  from QuestionEntry where QNo<"+m);
				if(rs.next())
				{
					int n1=rs.getInt(1);
					if(n1==0)
					{}
					else
					txtQNo.setText(""+n1);
					
				}
				int a=Integer.parseInt(txtQNo.getText());
				rs=st.executeQuery("select QDescription from QuestionEntry where QNo="+a);
				if(rs.next())
				{
				   txtQDescription.setText(rs.getString("QDescription"));					
				}
				int n2=Integer.parseInt(txtQNo.getText());
			    rs=st.executeQuery("select  OptionDescription from OptionChoiceDetail where QNo="+(n2));
			    if(rs.next())
			    {
			        chkA.setText(rs.getString("OptionDescription"));
			    }
			    if(rs.next())
			    {
			        chkB.setText(rs.getString("OptionDescription"));
			    }
			    if(rs.next())
			    {
			        chkC.setText(rs.getString("OptionDescription"));
			    }
			    if(rs.next())
			    {
			        chkD.setText(rs.getString("OptionDescription"));
			    }
			    }
			  else{}
			  //JOptionPane.showMessageDialog(null,"now Question the end", " Online Option Choice ",JOptionPane.ERROR_MESSAGE );	
			    
			}
			catch(SQLException e)
		    {
			 JOptionPane.showMessageDialog(null,"Invalid Query"+e, " Online Option Choice ",JOptionPane.ERROR_MESSAGE );
		    }
		}
		if(evt.getSource()==bSave)
		{
			try{ 
			       //OnlineAppearTestDetail otc=new OnlineAppearTestDetail();
			       
					rs=st.executeQuery("select max(QNo) from QuestionEntry");
					if(rs.next())
					{
					   rt=rs.getInt(1);
					   
					}
					rs=st.executeQuery("select max(AppearSrNo) from AppearTestDetail");
					if(rs.next())
					{
					   rt1=rs.getInt(1);
					   if(rt1==0)
					   {
					   	rt1=1;	
					   }
					   else
					   {
					   	rt1=rt1+1;
					   }
					}
					
					for(int p=0;p<rt;p++)
					{
						r2=st.executeUpdate("insert into AppearTestDetail (AppearSrNo,QNo) values("+(rt1)+","+(p+1)+")");
					    
					}
				    for(int q=0;q<rt;q++)
					{
						
						rs=st.executeQuery("select QDescription,CorrectChoice from QuestionEntry where  QNo="+(q+1));
						if(rs.next())
						{
						  r2=st.executeUpdate("update AppearTestDetail set QDescription='"+rs.getString("QDescription")+"',chA="+oc[q].getC1()+",chB="+oc[q].getC2()+",chC="+oc[q].getC3()+",chD="+oc[q].getC4()+",CorrectAns='"+rs.getString("CorrectChoice")+"' where AppearSrNo="+(rt1)+" and QNo="+(q+1));
					    }
					 }  
					 for(int pq=0;pq<rt;pq++)
					 { 
						cs="";
						if(oc[pq].getC1()==1)
						cs="A";
						else if(oc[pq].getC2()==1)
						cs=cs.concat("B");
						else if(oc[pq].getC3()==1)
						cs=cs.concat("C");
						else if(oc[pq].getC4()==1)
						cs=cs.concat("D");
						rs=st.executeQuery("select CorrectAns from AppearTestDetail where AppearSrNo="+rt1+" and QNo="+(pq+1));
					    if(rs.next())
					    {
					    	if(cs.equals(rs.getString("CorrectAns"))==true)
					    	{
					           rs=st.executeQuery("select MarksForEachQn from RegistrationTest where RegNo="+Integer.parseInt(txtRegNo.getText()));
					    	   if(rs.next())
					    	   {
					    	   	   marks=rs.getInt("MarksForEachQn");
					    	   	    r2=st.executeUpdate("update AppearTestDetail set ObtainedMarks="+marks+" where AppearSrNo="+rt1+" and QNo="+(pq+1));   
					    	   }
					    	}
					    	else if(cs.equalsIgnoreCase("")==true)
					    	{
					    		marks=0;
					    	  r2=st.executeUpdate("update AppearTestDetail set ObtainedMarks="+marks+" where AppearSrNo="+rt1+" and QNo="+(pq+1));    
					    	}
					    	else
					    	{
					    		rs=st.executeQuery("select NegativeMarkingOnWrongAns from RegistrationTest where RegNo="+Integer.parseInt(txtRegNo.getText()));
					    	   if(rs.next())
					    	   {
					    	   	   marks=rs.getInt("NegativeMarkingOnWrongAns");
					    	   	   r2=st.executeUpdate("update AppearTestDetail set ObtainedMarks="+marks+" where AppearSrNo="+rt1+" and QNo="+(pq+1));   
					    	   }
					    	}
					   	}
				       }
				       
				       r2=st.executeUpdate("insert into AppearTest (AppearSrNo,AppearDt,RegNo,ApplicantName,PaperId,PaperName,AppearingTime,TotalTime,CurrentTime,TimeRemg) values("+rt1+",'"+txtDate.getText()+"',"+Integer.parseInt(txtRegNo.getText())+",'"+txtApplicantName.getText()+"',"+Integer.parseInt(txtPaperId.getText())+",'"+txtDescription.getText()+"','"+txtStartTime.getText()+"',"+Integer.parseInt(txtTotalTime.getText())+",'"+txtCurrentTime.getText()+"','"+txtRemainingTime.getText()+"')");
				       
				       for(int p1=0;p1<rt;p1++)
				       {
				       	
				          rs=st.executeQuery("select ObtainedMarks from AppearTestDetail where AppearSrNo="+rt1+" and QNo="+(p1+1));
				          if(rs.next())
				          {
				          	tom=tom+rs.getInt("ObtainedMarks");
				          }
				      }
				      double per=0.0;
				      rs=st.executeQuery("select MarksForEachQn from RegistrationTest where RegNo="+Integer.parseInt(txtRegNo.getText()));
					    	   if(rs.next())
					    	   {
					    	   	   marks=rs.getInt("MarksForEachQn");
					    	   	}
				      
				      per=(tom*100)/(marks*rt);
				      
				      r2=st.executeUpdate("update AppearTest set TotalObtainedMarks="+tom+",ObtainedPercentage="+per+" where AppearSrNo="+(rt1));
				       
				       
					   JOptionPane.showMessageDialog(null,"SAVED....", " Online Option Choice ",JOptionPane.INFORMATION_MESSAGE );
					fr.dispose();
				}
				catch(SQLException e)
		    {
			 JOptionPane.showMessageDialog(null,"Invalid Query"+e, " Online Option Choice ",JOptionPane.ERROR_MESSAGE );
		    }
				
		}
		if(evt.getSource()==bCancel)
		{
		     int x=JOptionPane.showConfirmDialog(null,"Are you sure", " Online Paper Entry ",JOptionPane.YES_NO_OPTION);
		     if(x==0)
		     {
		         txtRegNo.setText("");
		         txtApplicantName.setText("");
		         txtApplicantName.setEditable(false);
		         txtQNo.setText("");
		         txtQDescription.setText("");
		         chkA.setText("");
		         chkB.setText("");
		         chkC.setText("");
		         chkD.setText("");
		         chkA.setEnabled(false);
		         chkB.setEnabled(false);
		         chkC.setEnabled(false);
		         chkD.setEnabled(false);
		         txtStartTime.setEditable(false);
			    txtTimeDuration.setEditable(false);
			    txtCurrentTime.setEditable(false);
			    txtRemainingTime.setEditable(false);
			    txtStartTime.setText("");
			    txtTimeDuration.setText("");	
			    txtCurrentTime.setText("");
			    txtRemainingTime.setText("");
			    fr.dispose();
		     }
		     else
		     {
		     }
		     
		}
		else
		{
			for(x=0;x<cnt;x++)
			{
			    if(evt.getSource().equals(btn[x])==true)
			    break;
			 }
			 if(evt.getSource()==btn[x])
			 {
			 	try{
			 		    
							int qno=Integer.parseInt(txtQNo.getText());
							
				 		int s1,s2,s3,s4;
					 if(chkA.isSelected()==true)
					  s1=1;
					 else
					  s1=0;
					 if(chkB.isSelected()==true)
					  s2=1;
					 else
					  s2=0;
					 if(chkC.isSelected()==true)
					  s3=1;
					 else
					  s3=0;
					 if(chkD.isSelected()==true)
					  s4=1;
					 else
					  s4=0;
					   
					   
					   oc[(qno-1)].setData(s1,s2,s3,s4);
					   
					  
					  
					    
				 		
				 		//i=0;
						txtQNo.setText("");
						txtQDescription.setText("");
						rs=st.executeQuery("select QNo,QDescription from QuestionEntry where QNo="+(x+1));
						if(rs.next())
						{
							txtQNo.setText(""+rs.getInt("QNo"));
							txtQDescription.setText(rs.getString("QDescription"));
						}
						if(oc[x].getC1()==1)
					  	chkA.setSelected(true);
					  	else
					  	chkA.setSelected(false);
					  	
					  	if((oc[x]).getC2()==1)
					  	chkB.setSelected(true);
					  	else
					  	chkB.setSelected(false);
					  	
					  	if(oc[x].getC3()==1)
					  	chkC.setSelected(true);
					  	else
					  	chkC.setSelected(false);
					  	
					  	if(oc[x].getC4()==1)
					  	chkD.setSelected(true);
					  	else
					  	chkD.setSelected(false);
					  	
						int m1=Integer.parseInt(txtQNo.getText());
					    rs=st.executeQuery("select  OptionDescription from OptionChoiceDetail where QNo="+(m1));
					    if(rs.next())
					    {
					        chkA.setText(rs.getString("OptionDescription"));
					    }
					    if(rs.next())
					    {
					        chkB.setText(rs.getString("OptionDescription"));
					    }
					    if(rs.next())
					    {
					        chkC.setText(rs.getString("OptionDescription"));
					    }
					    if(rs.next())
					    {
					        chkD.setText(rs.getString("OptionDescription"));
					    }
			 }
			 catch(SQLException e)
		    {
			 JOptionPane.showMessageDialog(null,"Invalid Query"+e, " Online Option Choice ",JOptionPane.ERROR_MESSAGE );
		    }
		}
	}
}
	public void keyPressed(KeyEvent k)
	{
		if(k.getKeyCode()==(10))
		{
			try{
				
				 boolean b=false;
				 int n=Integer.parseInt(txtRegNo.getText());
				 rs=st.executeQuery("select * from RegistrationTest where RegNo="+n);
				 if(rs.next())
				 {
					txtApplicantName.setText(rs.getString("ApplicantName"));
					txtPaperId.setText(""+rs.getInt("PaperId"));
					txtTotalNoOfQn.setText(""+rs.getInt("TotalNoOfQn"));
					txtMarksForEachQn.setText(""+rs.getInt("MarksForEachQn"));
					txtNegativeMarkingOnWrongAns.setText(""+rs.getInt("NegativeMarkingOnWrongAns"));
					txtTotalTime.setText(""+rs.getInt("TotalTime"));
				    b=true;
				    if(threadX.isAlive()==true)
				    threadX.stop();
				 }
				 else 
				 {
					  JOptionPane.showMessageDialog(null,"Invlid RegistrationNo.\n", " Online Exam Text",JOptionPane.ERROR_MESSAGE );
				      txtRegNo.setText("");
				      txtPaperId.setText("");
				      txtApplicantName.setText("");
				      txtDescription.setText("");
				      txtTotalMarks.setText("");
				      txtTotalTime.setText("");
				      txtTotalNoOfQn.setText("");
				      txtMarksForEachQn.setText("");
				      txtNegativeMarkingOnWrongAns.setText("");
				      
			          bStart.setEnabled(false);
				      bNext.setEnabled(false);
				      bPrev.setEnabled(false);
				      
				      txtStartTime.setText("");
				      txtCurrentTime.setText("");
				      txtTimeDuration.setText("");
				      txtRemainingTime.setText("");
				      txtQNo.setText("");
				      txtQDescription.setText("");
				      chkA.setText("");
				      chkB.setText("");
				      chkC.setText("");
				      chkD.setText("");
				      chkA.setSelected(false);
				      chkB.setSelected(false);
				      chkC.setSelected(false);
				      chkD.setSelected(false);
				      chkA.setEnabled(false);
					  chkB.setEnabled(false);
					  chkC.setEnabled(false);
					  chkD.setEnabled(false);
					
					
			      } 
			      if(b==true)
			      {
					    int m=Integer.parseInt(txtPaperId.getText());
					    rs=st.executeQuery("select TotalMarks,Description from PaperEntry where PaperId="+m);
					    if(rs.next())
					    {
					    	txtDescription.setText(rs.getString("Description"));
					    	txtTotalMarks.setText(""+rs.getInt("TotalMarks"));
					    }
					    i=0;
					    bStart.setEnabled(true);
					    bNext.setEnabled(false);
					    bPrev.setEnabled(false);
					    txtQNo.setText("");
					    txtQDescription.setText("");
					    chkA.setText("");
					    chkB.setText("");
					    chkC.setText("");
					    chkD.setText("");
					    chkA.setSelected(false);
					    chkB.setSelected(false);
					    chkC.setSelected(false);
					    chkD.setSelected(false);
					    chkA.setEnabled(false);
						chkB.setEnabled(false);
						chkC.setEnabled(false);
						chkD.setEnabled(false);		
						//threadX.stop();
				        txtStartTime.setText("");
				        txtCurrentTime.setText("");
				        txtTimeDuration.setText("");
				        txtRemainingTime.setText("");
				        txtQNo.setText("");
				        txtQDescription.setText("");
				  }
			    
			}
			catch(SQLException e)
			{
			 JOptionPane.showMessageDialog(null,"SQL Error\n"+e, " Online Exam Text",JOptionPane.ERROR_MESSAGE );
			}
			catch(Exception e)
			{
			 JOptionPane.showMessageDialog(null,"Thread Exception\n"+e, " Online Exam Text",JOptionPane.ERROR_MESSAGE );
			}
			
		}
	}
	public void keyReleased(KeyEvent kevt)
	{
	}
	public void keyTyped(KeyEvent kevt)
	{
	  	
	}
	public static void main(String s[])
	{
		OnlineTestExam obj= new OnlineTestExam();
			
		
    }
    
    	
}