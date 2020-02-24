package lavish;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class RestTime
{
    class MyLabel
    {
        JLabel main1;
        JLabel head,time;
        
        MyLabel(){}
        
        MyLabel(String heading,String timing)
        {
            main1=new JLabel();
            main1.setLayout(null);
            head=new JLabel(heading);
            head.setFont(new Font("Century Gothic",Font.BOLD,18));
            head.setForeground(Color.red);
            head.setBorder(BorderFactory.createLineBorder(Color.black));
            time=new JLabel("Mon-Fri                       |               "+timing);
            time.setFont(new Font("Century Gothic",Font.BOLD|Font.ITALIC,15));
            head.setBounds(0,0,320,30);
            time.setBounds(0,30,320,30);
            main1.add(head);
            main1.add(time);
        }
        
        public void setBounds(int x,int y,int w,int h)
        {
            main1.setBounds(x,y,w,h);
        }
        
        public Container get(){return main1;}
    }
    
    
    JPanel jp;
    MyLabel label[];
    JLabel hours;
    String head[]=new String[]{"BREAKFAST","LUNCH","SNACKS","DINNER"};
    String time[]=new String[]{"8:00-9:00 am","12:00-3:00 pm","4:00-6:00 pm","9:00-11:00 pm"};
    RestTime()
    {
        jp=new JPanel();
        jp.setLayout(null);
        jp.setOpaque(false);
        
        hours=new JLabel("RESTAURANT HOURS");
        hours.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        hours.setBounds(0,0,300,30);
        jp.add(hours);
        int y=38;
        label=new MyLabel[4];
        for(int i=0;i<4;i++)
        {
            label[i]=new MyLabel(head[i],time[i]);
            label[i].setBounds(0,y,330,65);
            jp.add(label[i].get());
            y+=65;
        }
    }
    public Container get()
    {
        return jp;
    }
    
    public void setBounds(int x,int y,int w,int h)
    {
        jp.setBounds(x, y, w, h);
    }
    
}

class TodaySpecial
{
    JPanel jp;
    JLabel jl,limg;
    JTextArea ta;
    TodaySpecial()
    {
        jp=new JPanel();
        jp.setLayout(null);
        //jp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //jp.setBounds(100,400,350,310);        
        jp.setOpaque(false);

        
        jl=new JLabel("TODAY'S SPECIAL");
        jl.setFont(new Font("Comic Sans MS",Font.BOLD,20));        
        //jl.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jl.setBounds(0,0,200,30);
        jl.setLayout(null);
        jp.add(jl);
        
        //limg=new JLabel(new ImageIcon("C:\\Users\\photos\\pizza.jpg"));
        limg=new JLabel(new ImageIcon(getClass().getClassLoader().getResource("resources/images/photos/pizza.jpg")));
        limg.setBounds(0,40,300,150);
        //limg.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jp.add(limg);
        
        ta=new JTextArea("The perfect meal. An open-faced pie\nusing tomato sauce, cheese, and many manners of toppings. Tastes like heaven and is sometimes stated to be better\nthan relationship.");
        ta.setOpaque(false);
        ta.setEditable(false);
        ta.setLineWrap(true);
        ta.setFont(new Font("Century Gothic",Font.BOLD |Font.ITALIC,15));
        ta.setBounds(0,200,300,100);
        //ta.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //ta.setBackground(new Color(245,222,179));
        jp.add(ta);
    }
    
    public Container get()
    {
       return jp;
    }
    public void setBounds(int x,int y,int w,int h)
    {
        jp.setBounds(x, y, w, h);
    }
}


class LatestMenu
{
  private class  Menu
    {
       JLabel main,jl1,jl2;
       JTextArea jl3;
       Menu(String path,String name,String des)
       {
       main=new JLabel();
       main.setLayout(null);
       jl1=new JLabel(new ImageIcon(path));
       jl2=new JLabel(name);
       jl3=new JTextArea(des);
       jl3.setEditable(false);
       jl3.setOpaque(false);
       
       jl1.setBounds(0,0,93,88);
       jl2.setBounds(98,0,250,30);
       jl3.setBounds(98,30,252,58);
       jl2.setFont(new Font("Comic Sans MS",Font.BOLD,15));
       jl3.setFont(new Font("Century Gothic",Font.BOLD,12));
      /* jl1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
       jl2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
       jl3.setBorder(BorderFactory.createLineBorder(Color.BLACK));*/
       main.add(jl1);
       main.add(jl2);
       main.add(jl3);
       }
       void setBounds(int x,int y,int w,int h)
       {
           main.setBounds(x,y,w,h);
       }
       public Container get()
       {
           return main;
       }
       
    }
  
   JPanel jp;
   Menu menu[];
   JLabel title;
   String path[]=new String[]{"C:\\Users\\photos\\food1.jpg",
                              "C:\\Users\\photos\\food2.jpg",
                              "C:\\Users\\photos\\food3.jpg"};
   
   String name[]=new String[]{"Italian Pasta","Spaghetti Pasta","Burger with Fries"};
   String des[]=new String[]{"Italian Pasta filled with meats/cheeses\ntopped with rich white orred sauce.",
                             "Spaghetti Pasta with twist of red or\nwhite sauce served with mayonnaise.",
                             "Our Homemade veggie burger,hand-\ncrafted out of local, organic vegetables\ntopped with mix greens."};
   LatestMenu()
   {
    jp=new JPanel();  
    menu=new Menu[3];
    jp.setLayout(null);
    title=new JLabel("LATEST MENU ");
    title.setFont(new Font("Comic Sans MS",Font.BOLD,20));
    title.setBounds(0,0,200,30);
    //jp.setBounds(508,400,350,310);
    jp.setBounds(508,400,350,310);
    jp.setOpaque(false);
    int y=30;
    jp.add(title);
   
    for(int i=0;i<3;i++)
    {
        menu[i]=new Menu(path[i],name[i],des[i]);
        jp.add(menu[i].get());
        menu[i].setBounds(0,y,310,88);
        y+=93;
        
   }
   }
   public Container get()
   {
       return jp;
   }
   public void setBounds(int x,int y,int w,int h)
   {
        jp.setBounds(x, y, w, h);
   }
   
}





public class HomePage implements ActionListener
{
   static JFrame JF;
    ImageIcon ic1,ic2,fback,jpback;
    JLabel img1,img2,back,pi,j;
    JPanel jp1,jp2,jp3;
    static JPanel tab[]=new JPanel[5];
    static JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
    JButton login,register;
    template t[]=new template[5];
    Tabbed JTP= new Tabbed();
    static Cart cart;
    static JScrollPane jsp;
    HomePage()
    {
        JF=new JFrame();
        JF.setSize(1366,768);
        
        JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        JF.setLayout(null);
        
        fback=new ImageIcon(getClass().getClassLoader().getResource("resources/images/photos/b.jpg"));
       // new JLabel(new ImageIcon());
        back=new JLabel(fback);
        back.setSize(1366,768);
        JF.add(back);
        
        jp1=new JPanel();
        
        jp1.setBackground(new Color(233,208,163));
        jpback=new ImageIcon(getClass().getClassLoader().getResource("resources/images/photos/3.png"));
        pi=new JLabel(jpback);
        pi.setBounds(508,140,1166,40);
        back.add(jp1);
        
        ic1=new ImageIcon(getClass().getClassLoader().getResource("resources/images/photos/rest.png"));
        img1=new JLabel(ic1);
        img1.setBounds(100,25,300,100);
        //img1.setBorder(BorderFactory.createLineBorder(Color.black));
        back.add(img1);
        
        ic2=new ImageIcon(getClass().getClassLoader().getResource("resources/images/photos/no.png"));
        img2=new JLabel(ic2);
        img2.setBounds(966,30,300,100);
        //img2.setBorder(BorderFactory.createLineBorder(Color.black));
        back.add(img2);
        
        login=new JButton(new ImageIcon(getClass().getClassLoader().getResource("resources/images/photos/login.png")));
        register=new JButton(new ImageIcon(getClass().getClassLoader().getResource("resources/images/photos/register.png")));
        login.addActionListener(this);
        register.addActionListener(this);
        login.setBorder(BorderFactory.createLineBorder(new Color(255,222,179)));
        register.setBorder(BorderFactory.createLineBorder(new Color(255,222,179)));
        jp3=new JPanel();
        jp3.setBounds(620,143,650,50);
        jp3.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jp3.add(login);
        
        jp3.add(register);
        jp3.setBackground(new Color(245,222,179));
        
        back.add(jp3);
        
        tabbedPane.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI()
        {
            @Override
            protected int calculateTabHeight(int tabPlacement, int tabIndex,int fontHeight)
            {
                return 50;
            }
        });
        
        
        String name[]=new String[]{"HOME","   MENU ","CONTACT US","ABOUT US","CART"};
        String path[]=new String[]{"home1","menu","contact1","about","cart"};
        
        tabbedPane.setBounds(100, 140, 1166,570);
        tabbedPane.setBackground(new Color(245,222,179));
        for(int i=0;i<4;i++)
        {
           tab[i]=new JPanel();
           tab[i].setLayout(null);
           if(i!=1)
           {
               t[i]=new template();
               t[i].setBounds(0,210,1166,310);
               tab[i].add(t[i].get());
           }   
           tabbedPane.addTab(name[i],new ImageIcon("C:\\Users\\photos\\"+path[i]+".png"),tab[i]);
        }
        tab[0].add(new Home().get());
        tab[2].add(new Contactus().get());
        tab[3].add(new Aboutus().get());
        tab[1].add(JTP.get());
        back.add(tabbedPane);
        
        //tabbedPane.setEnabledAt(1, false);
        
        cart=new Cart();
        tab[4]=cart.get();
        jsp=new JScrollPane(tab[4]);
        tab[4].setBackground(new Color(245,222,179));
        tabbedPane.addTab(name[4],new ImageIcon("C:\\Users\\photos\\"+path[4]+".png"),jsp);
        JTP.setBounds(0,0,1166,520);
        
      JF.setVisible(true);   
    }
    
    
   public void actionPerformed(ActionEvent e)
   { if(e.getSource()==login)
         new Lavish();
      if(e.getSource()==register)
          new Register();
   }
   
   

    public static void main(String a[])
    {
       HomePage hp= new HomePage();
    }
   
}
            