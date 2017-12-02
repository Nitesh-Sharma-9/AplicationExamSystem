import java.awt.*;       //All AWT Controls and classes
import javax.swing.*; 
import javax.swing.event.*; 
import javax.swing.border.*;   // All controls
import java.awt.event.*; //All events
import java.sql.*;
import java.io.*;
class OnlineMenu extends JFrame implements ActionListener,ItemListener,MouseListener
{ 
     JLabel image1,image2,image3,image4,image5,image6,image7,image8,image9;
     JPanel p; 
     JFrame fr;
     JMenuBar MnuBar;
     JMenu MnuMaster,MnuTransaction,MnuReport;
	 JMenuItem MnuPaperEntry,MnuRegistrationTest,MnuQuestionEntry,MnuOptionChoiceDetail,MnuAppearTestDetail,MnuAppearTest,MnuExamTest,MnuColor,MnuClose;  
	 JMenuItem RPaperEntry,RRegistrationTest,RQuestionEntry,ROptionChoiceDetail,RAppearTestDetail,RAppearTest,RExamTest,show;  
	 //ReportList rl;
	 
	 public OnlineMenu()
      {
      	   
      	   
      	   fr = new JFrame("Online Exam System");
      	   p=new JPanel();
      	   MnuBar=new JMenuBar();
      	   MnuMaster=new JMenu("Master     ");
      	   MnuMaster.setFont(new Font("Wide Latin",Font.BOLD,15));	
      	   MnuMaster.setForeground(Color.blue);	
	       MnuTransaction=new JMenu("Transaction     ");
	       MnuTransaction.setForeground(Color.blue);
	       MnuTransaction.setFont(new Font("Wide Latin",Font.BOLD,15));
	       		
	       MnuReport=new JMenu("Report     ");
	       MnuReport.setForeground(Color.blue);
	       MnuReport.setFont(new Font("Wide Latin",Font.BOLD,15));		
      	   MnuPaperEntry=new JMenuItem("PaperEntry ");
      	   MnuPaperEntry.setBackground(Color.orange);
      	   MnuPaperEntry.setFont(new Font("Wide Latin",Font.BOLD,12));	
      	   MnuPaperEntry.setForeground(Color.blue);	
	       MnuRegistrationTest=new JMenuItem("RegistrationTest ");
	       MnuRegistrationTest.setBackground(Color.orange);
      	   MnuRegistrationTest.setFont(new Font("Wide Latin",Font.BOLD,12));	
      	   MnuRegistrationTest.setForeground(Color.blue);	
	       MnuQuestionEntry=new JMenuItem("QuestionEntry ");
	       MnuQuestionEntry.setBackground(Color.orange);
      	   MnuQuestionEntry.setFont(new Font("Wide Latin",Font.BOLD,12));	
      	   MnuQuestionEntry.setForeground(Color.blue);	
	       MnuOptionChoiceDetail=new JMenuItem("OptionChoiceDetail ");
	       MnuOptionChoiceDetail.setBackground(Color.orange);
	       MnuOptionChoiceDetail.setFont(new Font("Wide Latin",Font.BOLD,12));	
      	   MnuOptionChoiceDetail.setForeground(Color.blue);	
	       MnuAppearTestDetail=new JMenuItem("AppearTestDetail ");
	       MnuAppearTestDetail.setBackground(Color.orange);
	       MnuAppearTestDetail.setFont(new Font("Wide Latin",Font.BOLD,12));	
      	   MnuAppearTestDetail.setForeground(Color.blue);	
	       MnuAppearTest=new JMenuItem("AppearTest ");
	       MnuAppearTest.setBackground(Color.orange);
	       MnuAppearTest.setFont(new Font("Wide Latin",Font.BOLD,12));	
      	   MnuAppearTest.setForeground(Color.blue);	
      	   MnuExamTest=new JMenuItem("Online Exam Test ");
	       MnuExamTest.setBackground(Color.orange);
	       MnuExamTest.setFont(new Font("Wide Latin",Font.BOLD,12));	
      	   MnuExamTest.setForeground(Color.blue);	
      	   
      	   show=new JMenuItem("Show");
      	   show.setBackground(Color.orange);
      	   show.setFont(new Font("Wide Latin",Font.BOLD,12));	
      	   show.setForeground(Color.blue);	
      	   
      	   RPaperEntry=new JMenuItem("ReportList ");
      	   RPaperEntry.setBackground(Color.orange);
      	   RPaperEntry.setFont(new Font("Wide Latin",Font.BOLD,12));	
      	   RPaperEntry.setForeground(Color.blue);	
	       RRegistrationTest=new JMenuItem("RegistrationTest ");
	       RRegistrationTest.setBackground(Color.orange);
      	   RRegistrationTest.setFont(new Font("Wide Latin",Font.BOLD,12));	
      	   RRegistrationTest.setForeground(Color.blue);	
	       RQuestionEntry=new JMenuItem("QuestionEntry ");
	       RQuestionEntry.setBackground(Color.orange);
      	   RQuestionEntry.setFont(new Font("Wide Latin",Font.BOLD,12));	
      	   RQuestionEntry.setForeground(Color.blue);	
	       ROptionChoiceDetail=new JMenuItem("OptionChoiceDetail ");
	       ROptionChoiceDetail.setBackground(Color.orange);
	       ROptionChoiceDetail.setFont(new Font("Wide Latin",Font.BOLD,12));	
      	   ROptionChoiceDetail.setForeground(Color.blue);	
	       RAppearTestDetail=new JMenuItem("AppearTestDetail ");
	       RAppearTestDetail.setBackground(Color.orange);
	       RAppearTestDetail.setFont(new Font("Wide Latin",Font.BOLD,12));	
      	   RAppearTestDetail.setForeground(Color.blue);	
	       RAppearTest=new JMenuItem("AppearTest ");
	       RAppearTest.setBackground(Color.orange);
	       RAppearTest.setFont(new Font("Wide Latin",Font.BOLD,12));	
      	   RAppearTest.setForeground(Color.blue);	
      	   RExamTest=new JMenuItem("Online Exam Test ");
	       RExamTest.setBackground(Color.orange);
	       RExamTest.setFont(new Font("Wide Latin",Font.BOLD,12));	
      	   RExamTest.setForeground(Color.blue);	
      	   
	       MnuColor=new JMenu("About     ");
	       MnuColor.setForeground(Color.blue);
	       MnuColor.setFont(new Font("Wide Latin",Font.BOLD,15));		
	       MnuClose=new JMenu("Exit      ");
	       MnuClose.setForeground(Color.blue);
	       MnuClose.setFont(new Font("Wide Latin",Font.BOLD,15));		
	       MnuBar.setBounds(340,100,700,40);
	       MnuBar.setBackground(new Color(200,200,200));
	       
	       
	       p.setBackground(Color.white);
	       ImageIcon img1=new ImageIcon("image1.jpg");
           image1=new JLabel("",img1,JLabel.CENTER);
           ImageIcon img2=new ImageIcon("image2.jpg");
           image2=new JLabel("",img2,JLabel.CENTER);
           ImageIcon img3=new ImageIcon("image3.jpg");
           image3=new JLabel("",img3,JLabel.CENTER);
           ImageIcon img4=new ImageIcon("image4.jpg");
           image4=new JLabel("",img4,JLabel.CENTER);
           ImageIcon img5=new ImageIcon("image5.jpg");
           image5=new JLabel("",img5,JLabel.CENTER);
           ImageIcon img6=new ImageIcon("image6.jpg");
           image6=new JLabel("",img6,JLabel.CENTER);
           ImageIcon img7=new ImageIcon("image7.jpg");
           image7=new JLabel("",img7,JLabel.CENTER);
           ImageIcon img8=new ImageIcon("image8.jpg");
           image8=new JLabel("",img8,JLabel.CENTER);
           //ImageIcon img9=new ImageIcon("image9.jpg");
           //image9=new JLabel("",img9,JLabel.CENTER);
           image1.setBounds(340,140,700,600);
           image2.setBounds(325,0,730,100);
           image3.setBounds(30,140,300,300);
           image4.setBounds(1050,140,300,300);
           image5.setBounds(30,420,300,300);
           image6.setBounds(1050,400,300,300);
           image7.setBounds(10,0,300,150);
           image8.setBounds(1060,0,300,150);
           //image9.setBounds(340,640,700,100);
           
           

	       
	       
	       
	       
	       
	       fr.setSize(1400,750);
		   fr.setLocation(0,0);
		   fr.setResizable(false);
		   
		   p.setLayout(null);
		   p.add(image1);
		   p.add(image2);
		   p.add(image3);
		   p.add(image4);
		   p.add(image5);
		   p.add(image6);
		   p.add(image7);
		   p.add(image8);
		   //p.add(image9);
		   MnuBar.add(MnuMaster);
		   MnuBar.add(MnuTransaction);
		   MnuBar.add(MnuReport);
		   MnuBar.add(MnuColor);
	       MnuBar.add(MnuClose);
	       MnuMaster.add(MnuPaperEntry);
	       MnuMaster.add(MnuRegistrationTest);
	       MnuMaster.add(MnuQuestionEntry);
	       MnuTransaction.add(MnuOptionChoiceDetail);
	       MnuTransaction.add(MnuAppearTestDetail);
	       MnuTransaction.add(MnuAppearTest);
	       MnuTransaction.add(MnuExamTest);
	       MnuReport.add(RPaperEntry);
	       //MnuColor.add(show);
	       /*MnuReport.add(RRegistrationTest);
	       MnuReport.add(RQuestionEntry);
	       MnuReport.add(ROptionChoiceDetail);
	       MnuReport.add(RAppearTestDetail);
	       MnuReport.add(RAppearTest);*/
	       
	       
	       //Border bd=BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.red,Color.green);
		   //bd=BorderFactory.createLineBorder(Color.blue,2);
		   //MnuBar.setBorder(bd);
		   //p.setBorder(bd);
	       p.add(MnuBar);
	       fr.getContentPane().add(p);
		   fr.setVisible(true);
		   
		   MnuPaperEntry.addActionListener(this);
		   MnuRegistrationTest.addActionListener(this);
		   MnuQuestionEntry.addActionListener(this);
		   MnuOptionChoiceDetail.addActionListener(this);
		   MnuAppearTestDetail.addActionListener(this);
		   MnuColor.addActionListener(this);
		   show.addActionListener(this);
		   MnuColor.addItemListener(this);
		   MnuAppearTest.addActionListener(this);
		   MnuExamTest.addActionListener(this);
		   MnuReport.addActionListener(this);
		   
		   RPaperEntry.addActionListener(this);
		   MnuClose.addActionListener(this);
		   MnuClose.addItemListener(this);
		   MnuClose.addMouseListener(this);
		   MnuColor.addMouseListener(this);
		   fr.setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);
		   fr.setDefaultLookAndFeelDecorated(true);
		   
      }
	  public void actionPerformed(ActionEvent evt)
	  {
	  	if(evt.getSource()==MnuPaperEntry)
      	{
      		
      		OnlinePaperEntry ope=new OnlinePaperEntry();
      		ope.fr.setLocation(390,175);
        
      		 		
      	}
      	if(evt.getSource()==MnuRegistrationTest)
      	{
      		
      		OnlineRegistrationTest ort=new OnlineRegistrationTest();
      		ort.fr.setLocation(365,185);
      		ort.fr.setSize(660,400);
      		ort.passConfirm.setBounds(-200,200,1,1);
      		ort.passNew.setBounds(-200,200,1,1);
      		ort.lblConfirm.setBounds(-200,200,1,1);
      		ort.lblNew.setBounds(-200,200,1,1);
      		//ort.bSave.setBounds(0,300,90,24);
	   	    ort.bSearch.setBounds(30,300,90,24);
		    ort.bUpdate.setBounds(130,300,90,24);
		    ort.bDelete.setBounds(230,300,90,24);
		    ort.bReset.setBounds(330,300,90,24);
		    ort.bPrint.setBounds(430,300,90,24);
		    ort.bClose.setBounds(530,300,90,24); 
		    ort.isLoad=0;
		    ort.cmbPaperId.removeAllItems();   		
      	}
      	if(evt.getSource()==MnuQuestionEntry)
      	{
      		OnlineQuestionEntry oqe=new OnlineQuestionEntry(); 
      		oqe.fr.setLocation(395,175);     		
      	}
      	if(evt.getSource()==MnuOptionChoiceDetail)
      	{
      		
      		OnlineOptionChoiceDetail opcd=new OnlineOptionChoiceDetail();
      		opcd.fr.setLocation(385,175);      		
      	}
      	if(evt.getSource()==MnuAppearTestDetail)
      	{
      		
      		OnlineAppearTestDetail oatd=new OnlineAppearTestDetail();
      		oatd.fr.setLocation(343,165);      		
      	}
      	if(evt.getSource()==MnuAppearTest)
      	{
      		
      		OnlineAppearTest oat=new OnlineAppearTest();
      		oat.fr.setLocation(380,165);      		
      	}
      	if(evt.getSource()==MnuExamTest)
      	{
      	    OnlineTestExam oet= new OnlineTestExam();
      	    oet.fr.setLocation(0,0);
      	}
      	
      	if(evt.getSource()==RPaperEntry)
      	{
      	    //ReportList rl=new ReportList();	
      	    
      	   // rl.setSize(450,200);
      	    //rl.setLocation(445,195);
      	    //rl.p.setBackground(new Color(200,200,200));
      	}
      	if(evt.getSource()==MnuClose)
      	{
      		int x=JOptionPane.showConfirmDialog(null,"Are you sure...", " Online Paper Entry ",JOptionPane.YES_NO_OPTION);
      		if(x==0)
      		System.exit(0);
      		else
      		{}
      	}
	  }
	  public void itemStateChanged(ItemEvent evt)
      {
      
      }
      public void mouseExited(MouseEvent evt)
      {
      	
      }
      public void mouseEntered(MouseEvent evt)
      {
      	
      }
      public void mouseReleased(MouseEvent evt)
      {
      }
      public void mousePressed(MouseEvent evt)
      {
      }
      public void mouseClicked(MouseEvent evt)
      {
      	if(evt.getSource()==MnuClose)
      	{
      		int x=JOptionPane.showConfirmDialog(null,"Are you sure...", " Online Exam System ",JOptionPane.YES_NO_OPTION);
      		if(x==0)
      		System.exit(0);
      		else
      		{}
      	}
      	if(evt.getSource()==MnuColor)
      	{
      		About ab=new About();
		   ab.fr.setLocation(395,215);
		   
      		      		
      	}
      }
      public static void main(String s[])
	  {
		OnlineMenu obj= new OnlineMenu();
		
		obj.show();
		
	  }
}