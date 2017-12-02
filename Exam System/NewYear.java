import javax.swing.event.*; 
import javax.swing.border.*;   // All controls
import java.awt.event.*; //All events
import java.sql.*;
import javax.swing.*;
import java.awt.*;
public class NewYear extends JFrame implements ActionListener
{
    JLabel img1,img4,img5,img6,img7,img8,img2,img3,img9,im;
    JLabel lbl,lbl1,l1,l2,l3;
    static  int cnt=0,cnt1=0,k;
    JPanel p;
    JButton b1,b2;
    public NewYear()
    {
          super("Welcome TO ABES Engineering College");
          setSize(1400,800);
          setLayout(null);
	  setLocation(0,0);
          setBackground(Color.red);
	  setResizable(false);
          p=new JPanel();
          p.setBounds(300,150,800,400);
          p.setBackground(Color.white);
          b1=new JButton("NEXT");
          b1.setToolTipText("NEXT");
          b1.setBackground(new Color(1,110,234));
          b1.setForeground(Color.white);
          b1.setBounds(1000,700,100,25);
          b2=new JButton("CANCEL");
          b2.setBounds(1150,700,100,25);
          b2.setToolTipText("CANCEL");
          b2.setBackground(new Color(1,110,234));
          b2.setForeground(Color.white);

           
          lbl=new JLabel("Welcome to Abes Exam System");
          lbl.setBounds(70,1,700,100);
          lbl.setFont(new Font("Lucida Console",5,5));
          lbl1=new JLabel("Made By->Nitesh Sharma");
          lbl1.setBounds(570,370,400,20);
          lbl1.setFont(new Font("Lucida Console",15,15));
          lbl1.setForeground(Color.green);
          lbl.setVisible(false);
          l1=new JLabel("Loding....");
          l1.setFont(new Font("Lucida Console",15,15));
          l1.setBounds(130,300,100,24);
          l1.setForeground(Color.red);
          l2=new JLabel();
          l2.setBounds(130,326,100,20);
          l2.setBackground(new Color(1,110,234));

	  ImageIcon im1=new ImageIcon("img4.jpg");
          img4=new JLabel("",im1,JLabel.CENTER);
          img4.setBounds(140,140,110,150);
          ImageIcon im2=new ImageIcon("img5.jpg");
          img5=new JLabel("",im2,JLabel.CENTER);
          img5.setBounds(240,140,80,150);
          ImageIcon im3=new ImageIcon("img6.jpg");
          img6=new JLabel("",im3,JLabel.CENTER);
          img6.setBounds(320,140,70,150);
          ImageIcon im4=new ImageIcon("img7.jpg");
          img7=new JLabel("",im4,JLabel.CENTER);
          img7.setBounds(390,155,50,150);
          //ImageIcon im5=new ImageIcon("img1.jpg");
          //img1=new JLabel("",im5,JLabel.CENTER);
          //img1.setBounds(450,110,70,150);

          ImageIcon im7=new ImageIcon("img2.jpg");
          img2=new JLabel("",im7,JLabel.CENTER);
          img2.setBounds(448,141,70,50);
          ImageIcon im8=new ImageIcon("img3.jpg");
          img3=new JLabel("",im8,JLabel.CENTER);
          img3.setBounds(450,170,70,100);
          ImageIcon im10=new ImageIcon("im.jpg");
          im=new JLabel("",im10,JLabel.CENTER);
          im.setBounds(450,140,70,100);


          ImageIcon im6=new ImageIcon("img8.jpg");
          img8=new JLabel("",im6,JLabel.CENTER);
          img8.setBounds(520,150,120,150);
          
          ImageIcon im9=new ImageIcon("img9.jpg");
          img9=new JLabel("",im9,JLabel.CENTER);
          img9.setBounds(520,140,100,100);

          p.setLayout(null);
          //p.add(img1);
          p.add(img4);
          p.add(img2);
          p.add(img3);
          p.add(im);
          p.add(img5);
          p.add(img6);
          p.add(img7);
          p.add(img9);
          p.add(img8);
          p.add(lbl);
          p.add(lbl1);
          p.add(l1);
          p.add(l2);
          add(b1);
          add(b2);
          getContentPane().add(p);
          setVisible(true);
          b1.addActionListener(this);
          b2.addActionListener(this);
          setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);
	  setDefaultLookAndFeelDecorated(true);
     }
     class Th5 extends Thread
     {
           int i4=140,j4=140,a=2,m=141,n=170;
           int i5=240,j5=140,i6=320,j6=140,i7=390,j7=155,i1=450,j1=110;
           public void run()
           {
               try{
                   while(true)
                   { 
                     cnt++;
                     if(a%2==0)
                     {

                       img4.setBounds(i4,j4,110,150);
                       img5.setBounds(i5,j5,80,150);
                       img6.setBounds(i6,j6,70,150);
                       img7.setBounds(i7,j7,50,150);
                       //img1.setBounds(450,j1,70,150);
                       img2.setBounds(448,m,70,50);
                       img3.setBounds(450,n,70,100);
                       //img8.setBounds(i8,j8,120,150);
                       //img9.setBounds(520,j8,100,100);
                       i4++;
                       j4--;
                       i5+=2;
                       j5-=2;
                       i6+=2;
                       j6-=2;
                       i7+=1;
                       j7-=1;
                       //i1++;
                       m-=1;
                       n-=1;
                       

                       if(i4==150)
                       {
                       //j8-=5;
                       a=3;
                       }
                       Thread.sleep(100);
                     }
                     else
                     {
                       img4.setBounds(i4,j4,110,150);
                       img5.setBounds(i5,j5,80,150);
                       img6.setBounds(i6,j6,70,150);
                       img7.setBounds(i7,j7,50,150);
                       //img1.setBounds(450,j1,70,150);
                        img2.setBounds(448,m,70,50);
                       img3.setBounds(450,n,70,100);
                       //img8.setBounds(i8,j8,120,150);
                       //img9.setBounds(520,j8,120,150);
                       i4--;
                       j4++;
                       i5-=2;
                       j5+=2;
                       i6-=2;
                       j6+=2;
                       i7-=1;
                       j7+=1;
                       //i1--;
                       m+=1;
                       n+=1;
                       
                       if(i4==140)
                       {
                          a=2;
                          //j8+=5;
                       }
                       Thread.sleep(100);
                     }
                     if(cnt==50)
                     {
                        k=m;
                       cnt+=10;
                       Th3 t3=new Th3();
                       t3.start();
                       sleep(10000);
                       
                      }
                   }
                    
              
               }
               catch(Exception e){}  
           }
     } 
    class Th2 extends Thread
    {
               int j8=135,b=2;
           public void run()  
           {
                 try
                 {
                        while(true) 
                        {
                           cnt1++;
                           if(b%2==0)
                           {
                                img9.setBounds(520,j8,100,100);
                                j8-=5;
                                Thread.sleep(200);
                                if(j8==130)
                                {
                                   b=3;
                                }
 
                            }
                           else
                           {
                                img9.setBounds(520,j8,100,100);
                                j8+=5;
                                Thread.sleep(200);
                                if(j8==135)
                                {
                                   b=2;
                                }
 
                            }
                           if(cnt1==25)
                           {
                           cnt1+=10;
                           sleep(10000);
                           }
                         }
                  }
                 catch(Exception e){}
            }
     }
    class Th3 extends Thread
    {
                int t=140,p=10;
            public void run()
            {
               try{
                    while(true)
                    {
                     img2.setBounds(448,k,70,50);
                     k--;
                     Thread.sleep(p);
                     if(k<-50)
                      {
                      img2.setVisible(false);
                       p=100;
                       im.setBounds(450,t,70,100);
                       t--;
                        if(t==100)
                       {
                         Th4 t4=new Th4();
                         t4.start();
                         suspend();
                       
                        }
                       }
                    } 
               }catch(Exception e){}
             }
           
     }
     class Th4 extends Thread
     {
              
         public void run()
          {
              try{
                   lbl.setVisible(true);
                    while(true)
                    {
                    	  int i=5,j=5,a=2,f=10,g=10,h=10;
                          if(a%2==0)
                           {
                            lbl.setFont(new Font("Lucida Console",i,j));
                            lbl.setForeground(new Color(f,g,h));
                            i++;f+=10;g+=5;h+=3;
                            j++;
                            Thread.sleep(100);
                            if(j==30)
                             a=3;
                           }
                           else
                           {
                            lbl.setFont(new Font("Lucida Console",i,j));
                            lbl.setForeground(new Color(f,g,h));
                            i--;f-=3;g-=10;h-=5;
                            j--;
                            Thread.sleep(100);
                            if(j==5)
                             a=2;
                           }
                     }
              }catch(Exception e){}
          }
      }
   class Th6 extends Thread{
   	  public void run()
   	  {
   	  	try{
   	  		
   	  	}
   	  	catch(Exception e)
   	  	{
   	  	}
   	  }
   }
   public void actionPerformed(ActionEvent e)
   {
              if(e.getSource()==b1)
              {
                    Login l=new Login();
	                l.show();
	                //l.Th1 t=new l.Th1();
	                //t1.start();
                    dispose();
               }
              if(e.getSource()==b2)
              {
                   System.exit(1);
              }
 }
    
   public static void main(String v[])
   {
         NewYear n=new NewYear();
         Th5 t1=n.new Th5();   
          t1.start();
         Th2 t2=n.new Th2();   
          t2.start();
         
          
    }
}