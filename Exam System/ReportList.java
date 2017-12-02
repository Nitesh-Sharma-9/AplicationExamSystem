import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

 class ReportList extends JFrame implements ActionListener,ItemListener
 {
   JComboBox cmbReport;
   JButton BtnClose;
   JLabel lblReport;
   JPanel p;int r;
   Connection cn;
   Statement cSr;
   ResultSet rcSet;
   JLabel ReportList;
  public  ReportList()
 {
    String st[]={"Paper Entry","Registration Test"
                  ,"Question Entry",
                  "Option Choice Details","Appear Test Detail","Appear Test"};
				cmbReport=new  JComboBox(st);
				cmbReport.setSelectedIndex(-1);
				BtnClose=new JButton("Close");
				lblReport= new JLabel("Report :");
				p=new JPanel();
				p.setLayout(null);
				p.setBackground(Color.cyan);
				ReportList=new JLabel("Report List");
				ReportList.setBounds(120,10,200,25);
				ReportList.setForeground(new Color(1,110,234));
		        ReportList.setFont(new Font("Wide Latin",Font.BOLD,16));
				lblReport.setBounds(90,70,100,24);
				cmbReport.setBounds(150,70,270,24);
				BtnClose.setBounds(150,120,120,24);
				cmbReport.setEditable(true);
				setResizable(false);
				setLocation(250,100);
				setSize(490,300);
				setTitle("Report List");
				setVisible(true);
				p.add(lblReport);
				p.add(cmbReport);
   				p.add(BtnClose);
   				p.add(ReportList);
				r=0;
     			getContentPane().add(p);
				BtnClose.addActionListener(this);
				cmbReport.addItemListener(this);
	  try
     {
       Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );
       cn = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=OnLineExamDB.mdb;DriverID=22;READONLY=true}" ,"","");
      }
        catch(ClassNotFoundException e)
        {
           System.out.print("Not ConnectedWn"+e);
           //System.exit(0);
        }
catch(SQLException e)
        {
           System.out.print("Not ConnectedWn"+e);
           //System.exit(0);
        }
        
  
}
public void PrintReport(String RecordQuery,int id)
{
	final ExtFrame PrintFrame 	= new ExtFrame();
	PrintFrame.setResizable( false );
	PrintFrame.setTitle( "Print Preview" );
	PrintFrame.getContentPane().setLayout( new java.awt.FlowLayout() );
	DEObjects Objects = new DEObjects();
	final DEObjects.DETextArea PrintPreview = Objects.new DETextArea( 39, 89 );
    //PrintFrame.setLocation(0,20);
	PrintFrame.setVisible( true );
	PrintFrame.getContentPane().add( PrintPreview.withScrollbar() );
	PrintPreview.withScrollbar().setPreferredSize( PrintPreview.getPreferredSize().getSize() );
	String Text = "";
	try
	{
				cSr = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				rcSet= cSr.executeQuery(RecordQuery);
				ResultSetMetaData rsmd= rcSet.getMetaData();
				int ColCnt = rsmd.getColumnCount();
				if(id==0)  //Report Title
				Text="\n\t\t\t\t\t\t\t\tPAPER ENTRY\n\n\n\n";
				else if(id==1)
				Text="\t\t\t\t\t\tRegistration Test\n\n\n";
				else if(id==2)
				Text="\t\t\t\t\t\tQuestion Entry\n\n\n";
				else if(id==3)
				Text="\t\t\t\t\t\t\tOption Choice Details\n\n\n";
				else if(id==4)
				Text="\t\t\t\t\t\t\tAppear Test Detail\n\n\n";
				else if(id==5)
				Text="\t\t\t\t\t\t\tAppear Test\n\n\n";
				int i;
				for(i=1;i<= ColCnt;i++)
					if(id==0)
					{
						if(i==1)
						Text= Text+ rsmd.getColumnLabel(i)+ "\t";
						else
						Text= Text+ rsmd.getColumnLabel(i)+ "\t\t";
						//if(i==3)
						//Text= Text+ rsmd.getColumnLabel(i)+ "\t\t";
					}
					else if(id==1)
					{
						if(i==1)
						Text= Text+ rsmd.getColumnLabel(i)+ "\t";
						else if(i==2)
						Text= Text+ rsmd.getColumnLabel(i)+ "\t\t\t";
						else
						Text= Text+ rsmd.getColumnLabel(i)+ "\t\t";
						
						
	   				}
					else if(id==2)
					{
						if(i==1)
						Text= Text+ rsmd.getColumnLabel(i)+ "\t";
						else if(i==4)
						Text= Text+ rsmd.getColumnLabel(i)+ "\t\t\t\t";
						else if(i>=2 && i<4)
						Text= Text+ rsmd.getColumnLabel(i)+ "\t\t";
						else
						Text= Text+ rsmd.getColumnLabel(i)+"\t\t";
	   				}
					else if(id==3)
					{
						if(i==3)
						Text= Text+ rsmd.getColumnLabel(i)+ "\t\t\t\t\t\t";
						else if(i==4)
						Text= Text+ rsmd.getColumnLabel(i)+ "\t\t";
						else
						Text= Text+ rsmd.getColumnLabel(i)+ "\t";
	   				}
					else if(id==4)
					{
						if(i==3)
						Text= Text+ rsmd.getColumnLabel(i)+ "\t\t";
						else
						Text= Text+ rsmd.getColumnLabel(i)+ "\t\t";
	   				}
	   				else if(id==5)
					{
						if(i==4)
						Text= Text+ rsmd.getColumnLabel(i)+ "\t\t";
						else
						Text= Text+ rsmd.getColumnLabel(i)+ "\t";
	   				} 				
				Text= Text+"\n";
				int RowCont = 0;
				while(rcSet.next()) RowCont++;
				rcSet.close();
				rcSet= cSr.executeQuery(RecordQuery);
		String st;
		if(rcSet.next())
		for ( int a = 1; a <= RowCont; a++ ) 
		{	for(int col=1;col<=ColCnt; col++)
			{	if(id==0)
				{	Text = Text+ rcSet.getString(col) +"\t\t";
					if(col==3)
						Text = Text+"\t\t";
					if(col==4)
					Text=Text+"\t\t";
					if(col==5)
					Text=Text+"\t\t";
				}
				else if(id==1)
				{
					int ln=rcSet.getString(col).length();
					if(col==2)
						if(ln==5)
					 		Text = Text+ rcSet.getString(col)+"\t\t\t\t";
					 	else
					 		Text = Text+ rcSet.getString(col)+"\t\t";
					 else if(col==3)
					Text = Text+ rcSet.getString(col)+"\t\t\t\t";
					else if(col==4) 
				    Text = Text+ rcSet.getString(col)+"\t\t\t\t";
					else if(col==5)
					Text = Text+ rcSet.getString(col)+"\t\t\t\t\t";
					else if(col==6)
					Text = Text+ rcSet.getString(col)+"\t\t\t\t\t";
					else
					Text = Text+ rcSet.getString(col) +"\t\t";
					
				}
				else if(id==2)
				{
					
					if(col==2 )
					{
						int ln=rcSet.getString(col).length();	
					    if(ln==5)
					 		Text = Text+ rcSet.getString(col)+"\t\t\t";
					 	else
					 		Text = Text+ rcSet.getString(col)+"\t\t";

					  
					}
					else if(col==4)
				    {
				    	int lnt=rcSet.getString(col).length();
				    	if(lnt>=1 && lnt<16)
					      Text = Text+ rcSet.getString(col)+"\t\t\t\t";
					      else if(lnt==16)
					      Text = Text+ rcSet.getString(col)+"\t\t\t";
					    else if(lnt>16 && lnt<=25)
					     Text = Text+ rcSet.getString(col)+"\t\t";
					     else
					     Text = Text+ rcSet.getString(col)+"\t\t";
			         } 
			         else if(col==5)
			         {
			         	Text = Text+ rcSet.getString(col) +"\t\t\t\t";
			         	} 
					else Text = Text+ rcSet.getString(col) +"\t\t";
				}
				else if(id==3)
				{
					Text = Text+ rcSet.getString(col) +"\t";
					if(col==2) 
					Text = Text+"";
					/*else if(col==3)
					{
					   int ln2=rcSet.getString(col).length();
					   if(ln2>=1 && ln2<=15)
					   Text = Text+ rcSet.getString(col) +"\t\t\t\t";
					   else
					   Text = Text+ rcSet.getString(col) +"\t\t";
					   
					 }*/
					else
					Text = Text+"\t";
				}
				else if(id==5)
				{
					Text = Text+ rcSet.getString(col) +"\t\t";
					if(col==2) Text = Text+"\t";
				}
			}		
			Text=Text+"\n";
			rcSet.next();
		}
	}
	catch(SQLException e)
	{
		JOptionPane.showMessageDialog(null," Invalid Query Set...\n"+e);
	}
	PrintPreview.setText( Text );
	//PrintPreview.setEditable( false );
	DEObjects.DEButton 	OKButton = Objects.new DEButton( "&OK", null );
	DEObjects.DEButton	CancelButton = Objects.new DEButton( "&Cancel", null );

	OKButton.addActionListener ( new ActionListener() 
	{
		public void actionPerformed( ActionEvent event ) {
			DEPrint.printComponent( PrintPreview );
			PrintFrame.dispose();
		}
	} );
	
	CancelButton.addActionListener( new ActionListener() 
	{
		public void actionPerformed( ActionEvent event ) {
			PrintFrame.dispose();
		}
	} );

	PrintFrame.getContentPane().add( OKButton );
	PrintFrame.getContentPane().add( CancelButton );
	PrintFrame.setSize( PrintFrame.getPreferredSize() );
	PrintFrame.validate();
}
public void itemStateChanged(ItemEvent event)
	{
   	 if(event.getSource()==cmbReport && event.getStateChange()==event.SELECTED)
     {
     	int id= cmbReport.getSelectedIndex();
     	cmbReport.setSelectedIndex(-1);
     	if( id== 0 )
     		PrintReport("Select * from PaperEntry",id);
     	else if( id== 1 )
     		PrintReport("select * from RegistrationTest",id);
     	else if( id== 2 )
     		PrintReport("select * from QuestionEntry",id);
     	else if( id== 3 )
     		PrintReport("select * from OptionChoiceDetail",id);
     	else if( id== 4 )
     		PrintReport("select * from AppearTestdetail",id);
     	else if( id== 5 )
     		PrintReport("select * from AppearTest",id);
     	
     }
    }
 public void actionPerformed(ActionEvent evt)
{
            if(evt.getSource()==BtnClose)
			{
                dispose();
			}
}   
public static void main(String str[])
    { 
       ReportList obj=new ReportList();
       obj.setSize(500,300);
       
       
    }
}