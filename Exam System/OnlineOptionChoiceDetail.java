import java.awt.*;       //All AWT Controls and classes
import javax.swing.*; 
import javax.swing.border.*;   // All controls
import java.awt.event.*; //All events
import java.sql.*;
class OnlineOptionChoiceDetail implements ActionListener,ItemListener
{
	int isSearch=0,isLoad=0;
	ResultSet rs;
	Connection cn;
	Statement st; 
	JPanel p; 
	JFrame fr;
	JLabel lblOptionChoiceDetail;	
	JLabel lblPaperId,lblQNo,lblQDescription,lblOptionId,lblOptionDescription;
	JComboBox cmbPaperId,cmbQNo,cmbOptionId;
	JTextField txtQDescription,txtOptionDescription;
	JButton bSave,bSearch,bUpdate,bDelete,bClear,bPrint;
    public OnlineOptionChoiceDetail() // Constructor
	{
		fr = new JFrame("Online Option Choice Detail...");
		lblOptionChoiceDetail=new JLabel("Option Choice Detail");
		lblPaperId=new JLabel("Paper Id");
		lblQNo=new JLabel("QNo.");
		lblQDescription=new JLabel("QDescription");
		lblOptionId=new JLabel("Option Id");
		lblOptionDescription=new JLabel("Option Description");
		cmbPaperId=new JComboBox();
		cmbQNo=new JComboBox();
		cmbOptionId=new JComboBox();
		txtQDescription=new JTextField(10);
		txtOptionDescription=new JTextField(10);
		p=new JPanel();
		bSave=new JButton("Save");
		bSearch=new JButton("Search");
		bUpdate=new JButton("Update");
		bDelete=new JButton("Delete");
		bClear=new JButton("Clear");
		bPrint=new JButton("Print");
		bSave.setToolTipText("SAVE");
		bSearch.setToolTipText("SEARCH");
		bUpdate.setToolTipText("UPDATE");
		bDelete.setToolTipText("DELETE");
		bClear.setToolTipText("CLEAR");
		bPrint.setToolTipText("PRINT");
		bSave.setBackground(new Color(1,110,234));
		bSave.setForeground(Color.white);
		bSearch.setBackground(new Color(1,110,234));
		bSearch.setForeground(Color.white);
		bUpdate.setBackground(new Color(1,110,234));
		bUpdate.setForeground(Color.white);
		bDelete.setBackground(new Color(1,110,234));
		bDelete.setForeground(Color.white);
		bClear.setBackground(new Color(1,110,234));
		bClear.setForeground(Color.white);
		bPrint.setBackground(new Color(1,110,234));
		bPrint.setForeground(Color.white);
	    


		fr.setSize(610,350);
		fr.setResizable(false);
		fr.setLocation(400,210);
		p.setBackground(new Color(200,200,200));
		lblOptionChoiceDetail.setBounds(120,20,400,25);
		lblOptionChoiceDetail.setForeground(new Color(1,110,234));
		lblOptionChoiceDetail.setFont(new Font("Wide Latin",Font.BOLD,20));
		lblQNo.setBounds(50,70,30,25);
		lblPaperId.setBounds(340,70,70,25);
		lblQDescription.setBounds(50,115,70,25);
		lblOptionId.setBounds(50,180,70,25);
		lblOptionDescription.setBounds(340,180,90,25);
		cmbPaperId.setBounds(430,70,120,25);
		cmbPaperId.setEditable(true);
		cmbQNo.setBounds(120,70,120,25);
		cmbQNo.setEditable(true);
		cmbOptionId.setBounds(120,180,120,25);
		cmbOptionId.setEditable(true);
		txtQDescription.setBounds(120,105,430,50);
		txtOptionDescription.setBounds(430,180,120,25);
		bSave.setBounds(30,250,90,24);
		bSearch.setBounds(120,250,90,24);
		bUpdate.setBounds(210,250,90,24);
		bDelete.setBounds(300,250,90,24);
		bClear.setBounds(390,250,90,24);
        bPrint.setBounds(480,250,90,24);
        p.add(lblOptionChoiceDetail);
		p.add(lblPaperId);
		p.setLayout(null);
		p.add(lblQNo);
		p.add(lblOptionId);
		p.add(lblQDescription);
		p.add(lblOptionDescription);
		p.add(cmbPaperId);
		p.add(cmbQNo);
		p.add(cmbOptionId);
		p.add(txtQDescription);
		p.add(txtOptionDescription);
		p.add(bSave);
		p.add(bSearch);
		p.add(bUpdate);
		p.add(bDelete);
		p.add(bClear);
		p.add(bPrint);
		fr.getContentPane().add(p);
		fr.setVisible(true);
		bSave.addActionListener(this);
		bSearch.addActionListener(this);
		bUpdate.addActionListener(this);
		bDelete.addActionListener(this);
		bClear.addActionListener(this);
		bPrint.addActionListener(this);
	    cmbPaperId.addActionListener(this);
	    cmbQNo.addActionListener(this);
	    cmbOptionId.addActionListener(this);
	    cmbPaperId.addItemListener(this);
	    cmbQNo.addItemListener(this);
	    cmbOptionId.addItemListener(this);
		//fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try{	
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		    //cn=DriverManager.getConnection("Jdbc:Odbc:OESPDSN");
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                       cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ns","ns");
			st=cn.createStatement();
			isSearch=0;
			cmbQNo.setSelectedIndex(-1);
			rs=st.executeQuery("Select  QNo from QuestionEntry order by QNo");
			   while(rs.next())
			   {
				   cmbQNo.addItem(rs.getInt("QNo"));
		       } 
			    cmbQNo.setSelectedIndex(-1);
			   isLoad=1;
					
		}
		catch(SQLException e)
		{
			 JOptionPane.showMessageDialog(null,"Invalid query..."+e, " Online Option Choice ",JOptionPane.ERROR_MESSAGE );

		}
		catch(ClassNotFoundException e)
		{
			JOptionPane.showMessageDialog(null,"Invalid Driver..."+e, " Online Option Choice ",JOptionPane.ERROR_MESSAGE );

		}
		
	}
	public void clrscr()
		{
			cmbQNo.setSelectedItem("");
			txtQDescription.setText("");
			cmbPaperId.setSelectedItem("");
			cmbOptionId.setSelectedItem("");
			txtOptionDescription.setText("");
		}
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource()==bSave)
		{
			isSearch=0;
			try{
				 int r;
		         r=st.executeUpdate("insert into OptionChoiceDetail values("+Integer.parseInt(cmbPaperId.getSelectedItem().toString())+","+Integer.parseInt(cmbQNo.getSelectedItem().toString())+",'"+txtQDescription.getText()+"','"+cmbOptionId.getSelectedItem().toString()+"','"+txtOptionDescription.getText()+"')");
		         if(r>0)
		         JOptionPane.showMessageDialog(null,"Record Saved...", " Online Paper Entry ",JOptionPane.INFORMATION_MESSAGE );
			     clrscr();
			}
			
			catch(SQLException e)
			{
                JOptionPane.showMessageDialog(null,"Invalid Query"+e, " Online Option Choice ",JOptionPane.ERROR_MESSAGE );
			}
			
		}
		if(evt.getSource()==bSearch)
		{
			
			try{
				isSearch=0;
				isLoad=0;
				cmbPaperId.removeAllItems();
				cmbQNo.removeAllItems();
				txtQDescription.setText("");
				rs=st.executeQuery("Select  distinct QNo from OptionChoiceDetail order by QNo");
			   while(rs.next())
			   {
				   cmbQNo.addItem(rs.getInt("QNo"));
		       } 
			    cmbQNo.setSelectedIndex(-1);
			    clrscr();
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
	  	if(evt.getSource()==cmbQNo && isSearch==1  && cmbQNo.getSelectedIndex()>=0)
		{
			try{
				cmbOptionId.removeAllItems();
				cmbPaperId.removeAllItems();
				txtQDescription.setText("");
				txtOptionDescription.setText("");
				isSearch=0;
				String s;
				s=cmbQNo.getSelectedItem().toString();
				int n=Integer.parseInt(s);
				rs=st.executeQuery("Select  PaperId,QDescription from OptionChoiceDetail where QNo="+n);
			if(rs.next())
			{
				cmbPaperId.setSelectedItem(rs.getInt("PaperId"));
				txtQDescription.setText(rs.getString("QDescription"));
				//cmbOptionId.setSelectedItem(rs.getString("OptionId"));
				//txtOptionDescription.setText(rs.getString("OptionDescription"));
			}
			//rs.close();
			 //String Q=txtQDescription.getText();	
			 
			 
			rs=st.executeQuery("Select  distinct OptionId from OptionChoiceDetail where QNo="+Integer.parseInt(cmbQNo.getSelectedItem().toString())+" order by 1");		
			while(rs.next())
			{
				cmbOptionId.addItem(rs.getString("OptionId"));
				//txtOptionDescription.setText(rs.getString("OptionDescription"));
			}
			  
			  cmbOptionId.setSelectedIndex(-1);
			  isSearch=1;
			}
			catch(SQLException e)
			{
                JOptionPane.showMessageDialog(null,"Invalid Query"+e, " Online Option Choice ",JOptionPane.ERROR_MESSAGE );
			}
		}
		if(evt.getSource()==cmbOptionId && isSearch==1  && cmbOptionId.getSelectedIndex()>=0)
		{
			try{
				txtOptionDescription.setText("");
				//rs.close();
				String s=cmbOptionId.getSelectedItem().toString();
				String qd=txtQDescription.getText();
				rs=st.executeQuery("select OptionDescription from OptionChoiceDetail where QDescription='"+qd+"' and OptionId='"+s+"'");
				if(rs.next())
				{
					txtOptionDescription.setText(rs.getString("OptionDescription"));
				} 
			}
			catch(SQLException e)
			{
                JOptionPane.showMessageDialog(null,"Invalid Query"+e, " Online Option Choice ",JOptionPane.ERROR_MESSAGE );
			}
		}
		if(evt.getSource()==cmbQNo && isLoad==1 && cmbQNo.getSelectedIndex()>=0)
		{
			
			try{
				
				String s=cmbQNo.getSelectedItem().toString();
				int n=Integer.parseInt(s);
				cmbPaperId.removeAllItems();
				txtQDescription.setText("");
				rs=st.executeQuery("select PaperId,QDescription from QuestionEntry where QNo="+n);
				if(rs.next())
				{
					cmbPaperId.addItem(rs.getInt("PaperId"));
					txtQDescription.setText(rs.getString("QDescription"));
				}
				//cmbPaperId.setSelectedIndex(-1);
				
			}
			catch(SQLException e)
			{
                JOptionPane.showMessageDialog(null,"Invalid Query"+e, " Online Option Choice ",JOptionPane.ERROR_MESSAGE );
			}
			
		}
	}
	public static void main(String s[])
	{
		OnlineOptionChoiceDetail obj= new OnlineOptionChoiceDetail();
	}
}