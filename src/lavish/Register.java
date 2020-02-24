package lavish;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class Register implements ActionListener
{
JDialog jf;
JPanel main;
JLabel user,password,cpassword,head,choose,email,mobile,gender,Ualert,Palert,Malert,Ealert,Calert,Galert;
Boolean uflag=false,pflag=false,mflag=false,eflag=false,cflag=false,gflag=false;
JTextField jt1,jt2,jt3;
JPasswordField jp1,jp2;
JButton reg,res;
ButtonGroup bg;
JRadioButton jr1,jr2;
Register()
{
   jf=new JDialog(HomePage.JF,true);
   jf.setLayout(null);
   jf.setSize(650,700);
   jf.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
   jf.setLocationRelativeTo(null);
   

   main=new JPanel();
   main.setLayout(null);
   main.setBounds(100,100,400,450);
  // main.setBorder(BorderFactory.createLineBorder(Color.black));
   jf.add(main);
   
   head=new JLabel(new ImageIcon("C:\\Users\\photos\\reg.png"));
   head.setBounds(200,0,100,100);
   main.add(head);
   
   user=new JLabel("Username:");
   user.setBounds(50,120,200,25);
   main.add(user);
  
   jt1=new JTextField();//            USERNAME
   jt1.setBounds(170,120,200,30);
   main.add(jt1);
   
   Ualert=new JLabel();
   Ualert.setBounds(170,145,200,20);
   Ualert.setForeground(Color.RED);
   main.add(Ualert);
   
   jt1.addFocusListener(new FocusAdapter()
    {
      public void focusLost(FocusEvent fe)
       {
           uflag=false;
        if(jt1.getText().equals(""))
        {
            
            Ualert.setText("! Please enter Username");
        }    
        else 
        {
            uflag=true;
            Ualert.setText("");
        }
       }
});
        
   password=new JLabel("Password:"); 
   password.setBounds(50,175,200,25);
   main.add(password);
   
   Palert=new JLabel();
   Palert.setBounds(170,200,300,20);
   Palert.setForeground(Color.RED);
   main.add(Palert);
   
   jp1=new JPasswordField();//              PASSWORD
   jp1.setBounds(170,175,200,30);
   main.add(jp1);
   jp1.addFocusListener(new FocusAdapter() 
   {
    public void focusLost(FocusEvent fe)
    {
        pflag=false;
        if(jp1.getText().equals(""))
        {
           Palert.setText("! Please enter Password");
        } 
        else if((jp1.getText().length())<8)
        {
         Palert.setText(" ! PASSWORD must contain atleast 8 Characters");
        }
        else
        {
            pflag=true;
            Palert.setText("");
        }
           
    }
});


   cpassword=new JLabel("Confirm Password:");
   cpassword.setBounds(50,225,200,25);
   main.add(cpassword);
   
   Calert=new JLabel();
   Calert.setBounds(170,250,200,20);
   Calert.setForeground(Color.RED);
   main.add(Calert);
   
   jp2=new JPasswordField();
   jp2.setBounds(170,225,200,30);
   main.add(jp2);
   jp2.addFocusListener(new FocusAdapter()
   {
    public void focusLost(FocusEvent f)
    {
        cflag=false;
        if(jp2.getText().equals("")||jp2.getText().length()<8)
        {
            Calert.setText("! Please Re-enter your password");
        }
        else if(!jp1.getText().equals(jp2.getText()) )
        {
            Calert.setText("! Password does not Match");
        }
        else 
        { 
            Calert.setText("");
            cflag=true;
        }
    }
    });
    email=new JLabel("E-Mail ID:");
    email.setBounds(50,275,200,25);
    main.add(email);
    
    Ealert=new JLabel();
    Ealert.setBounds(170,300,200,20);
    main.add(Ealert);
    
    jt2=new JTextField();///          EMAIL ID
    jt2.setBounds(170,275,200,30);
    main.add(jt2);
    jt2.addFocusListener(new FocusAdapter()
    {
       
     public void focusLost(FocusEvent fe)
      {
        eflag=false;
        String s=jt2.getText();
        if(s.equals(""))
        {
            Ealert.setForeground(Color.RED);
            Ealert.setText("! Please enter E-mail ID");
        } 
        else if(!(s.contains("@")&&s.contains(".")))
        {    
          Ealert.setText("! Invalid E-mail");
        }
        else
        {
            eflag=true;
         Ealert.setText("");
        }
           
      }
      });

    mobile=new JLabel("Mobile No:");
    mobile.setBounds(50,325,200,20);
    main.add(mobile);
    
    Malert=new JLabel();
    Malert.setBounds(170,355,250,20);
    Malert.setForeground(Color.RED);
    main.add(Malert);
    
    jt3=new JTextField();//                  MOBILE NO
    jt3.setBounds(170,325,200,30);
    main.add(jt3);
    jt3.addFocusListener(new FocusAdapter()
    {
    public void focusLost(FocusEvent e)
    {   mflag=false;
        if(jt3.getText().equals(""))
        {
          Malert.setText("! Please enter Mobile number(only numeric)");
        }    
        else if(jt3.getText().length()!=10)
        {
                Malert.setText("! Mobile must contain 10 numbers");
        }
        else
        {
            mflag=true;
            Malert.setText("");
        }       
    }
    });
    jt3.addKeyListener(new KeyAdapter()
    {
      public void keyTyped(KeyEvent k)
       {
         char c=k.getKeyChar();
            if(!(c>='0'&&c<='9')|| c==k.VK_BACK_SPACE|| c==k.VK_DELETE)
            {
                k.consume();}   
           
            else
            {
                Malert.setText("");
            }
        }
        });

    gender=new JLabel("Gender:");
    gender.setBounds(50,375,200,20);
    main.add(gender);
    
    Galert=new JLabel();
    Galert.setBounds(170,395,200,20);
    Galert.setForeground(Color.RED);
    main.add(Galert);
    
    jr1=new JRadioButton("Male");//       GENDER
    jr1.setActionCommand(jr1.getText());
    jr1.setBounds(170,375,70,20);
    main.add(jr1);
    
    jr2=new JRadioButton("Female");
    jr2.setActionCommand(jr2.getText());
    jr2.setBounds(240,375,80,20);
    main.add(jr2);
    
    bg=new ButtonGroup(); 
    bg.add(jr1);bg.add(jr2);
    
    reg=new JButton("Register");
    reg.setBounds(170,425,90,20);
    reg.addActionListener(this);
    main.add(reg);
    
    res=new JButton("Reset");
    res.setBounds(280,425,90,20);
    res.addActionListener(this);
    main.add(res);
    
    jf.setVisible(true);

   
}
public void actionPerformed(ActionEvent a)
{
    if(a.getSource()==reg)
    {
        gflag=false;
      if(jr1.isSelected()==false&&jr2.isSelected()==false)
       { 
        Galert.setText("! Choose Gender");
       }
       else
       {
           gflag=true;
           Galert.setText("");
       }
        System.err.println(uflag);
         System.err.println(pflag);
          System.err.println(cflag);
           System.err.println(eflag);
            System.err.println(mflag);
             System.err.println(gflag);    
       if(uflag==true&&pflag==true&&cflag==true&&eflag==true&&mflag==true&&gflag==true)
       {
           DataBase();
       }  
       else
       {
           JOptionPane.showMessageDialog(null, "Something is wrong!!\nPlease enter data correctly.");
       }
            
      
    }

    if(a.getSource()==res) 
    {
     jt1.setText("");
     jt2.setText("");
     jt3.setText("");
     jp1.setText("");
     jp2.setText("");
     bg.clearSelection();
     Galert.setText("");
     Ealert.setText("");
     Calert.setText("");
     Palert.setText("");
     Ualert.setText("");
     Malert.setText("");

 }
}

void DataBase()
{
    try
    {
       
      Class.forName("oracle.jdbc.driver.OracleDriver");
       Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "password");
       PreparedStatement ps=con.prepareStatement("insert into lavish.Register values(?,?,?,?,?) ");
       ps.setString(1,jt1.getText());
       ps.setString(2,jp1.getText());
       ps.setString(3,jt2.getText());
       ps.setString(4,jt3.getText());
       ps.setString(5,bg.getSelection().getActionCommand());
       
       int i=ps.executeUpdate();
       if(i==1)
       {
           System.out.println("SUCCESS");
       }
       else
       { 
       System.out.println("FAILURE.");
       }
       
    }catch(Exception e)
    {
        System.out.println(e);
    }
}
public static void main(String a[])
{
new Register();
}
}



























