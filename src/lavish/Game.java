package lavish;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game implements ActionListener
 {
    JFrame jf;
    JPanel jp;
    JButton jb[]=new JButton[25];
    //int i;
    Integer array[]=new Integer[5];
   Game()
   {
       jf=new JFrame();
       jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       jf.setSize(500,500);
      
       jf.setLocationRelativeTo(null);
       jf.setLayout(null);
       
       jp=new JPanel();
       jp.setBounds(100,100,210,210);
       jp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
       jp.setLayout(null);
       jf.add(jp);
       
      
   }
   
   void addButton()
   {
        Integer no=1;
       int x=10,y=10,counter=0;
       for( int i=0;i<25;i++)
       {
         
              
               jb[i]=new JButton();
              // no++;
               jb[i].setMargin(new Insets(0, 0, 0, 0));         // TO SET THE MARGIN OF THE BUTTON.
               jb[i].setBorder(null);
               jb[i].setFont(new Font("Century Gothic",Font.BOLD,15));
               
               jb[i].setBounds(x,y,30,30);
               jb[i].setBackground(Color.pink);
               jb[i].setForeground(Color.black);
               jb[i].addActionListener(this);
               jp.add(jb[i]);
               x+=40;
               counter++;
               if(counter%5==0)
               {
                   x=10;
                   y+=40;
               }
                       
               
           }
            jf.setVisible(true);
       }
   
   
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   void RandomFlags()
   {
      array=new random().getRandomArray(); 
     for( int i=0;i<array.length;i++)
     {
         jb[array[i]].setIcon(new ImageIcon("C:\\Users\\sai\\Desktop\\bomb.png"));
     }
   }
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
   void checkBomb(Point p)
   {
       Integer counter=0;
       for(int i=p.x-40;i<=p.x+40;i=i+40)
       {
           for(int j=p.y-40;j<=p.y+40;j=j+40)
           {
              /* if(p.x==10)
               {
                   i=p.x+40;
               }
               else if(p.y+40==jp.getWidth())
               {
                   i
               }*/
                 if(((JButton)jp.getComponentAt(i, j)).getIcon()!=null)
                 {
                   counter++;
                 }
           
               
           }   
       }
       ((JButton)jp.getComponentAt(p)).setText(counter.toString());
       /*if(p.x-40<40)
       {
           
       }
       if(p.x+50>jp.getWidth())
       {
           
       }
       if(p.y-40<40)
       {
           
       }
       if(p.y+50>jp.getHeight())
       {
           
       }*/
       
   }
   
   @Override
   public void actionPerformed(ActionEvent e)
   {
       JButton temp= (JButton)e.getSource();//          THE CLICKED BUTTON SOURCE GET ASSOCIATED WITH NEW TEMPORARY BUTTON.
    
     checkBomb(temp.getLocation());//                   RETURNS POINT OBJECT.
     
 
   }
   
  public static void main(String q[])
  {
      Game g=new Game();
      g.addButton();
      g.RandomFlags();
  }
 }
