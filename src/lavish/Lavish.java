package lavish;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class Lavish implements ActionListener  
{
JDialog jf;
JPanel main;
Boolean uflag=false,pflag=false,tflag=false;
JLabel user,password,head,choose,Ualert,Palert,Talert,img;
JRadioButton jr1,jr2,jr3,jr4,jr5,jr6;
JButton login,reset;
JTextField jt1;
JPasswordField jp1;
ButtonGroup bg;
public static int count=0;
public Lavish()
{
jf=new JDialog(HomePage.JF,true);
jf.setBackground(Color.WHITE);
jf.setLayout(null);
jf.setSize(550,500);
jf.setLocationRelativeTo(null);
jf.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);





main=new JPanel();
//main.setBorder(BorderFactory.createLineBorder(Color.BLACK));
main.setBackground(Color.red);
main.setLayout(null);
main.setOpaque(false);
main.setBounds(50,50,350,350);
jf.add(main);

img=new JLabel(new ImageIcon("C:\\Users\\photos\\log.png"));
img.setBounds(180,0,100,100);
main.add(img);

head=new JLabel("CUSTOMER LOGIN");
//head.setBounds(50,120,150,20);
user=new JLabel("Username:");
user.setBounds(50,120,200,25);
main.add(user);

jt1=new JTextField("Your registered mobile number");
jt1.setForeground(Color.gray);//                      USER
jt1.setBorder(BorderFactory.createLineBorder(new Color(178, 12, 12)));
jt1.setBounds(140,120,200,30);
main.add(jt1);
jt1.addKeyListener(new KeyAdapter()
{
    public void keyTyped(KeyEvent k)
    {
        if (count==0)
            jt1.setText("");
            char c=k.getKeyChar();
            if(!(c>='0'&&c<='9')|| c==k.VK_BACK_SPACE|| c==k.VK_DELETE)
            k.consume();
            jt1.setForeground(Color.black);
            count++;
    }
});
Ualert=new JLabel();
Ualert.setBounds(140,150,200,20);
main.add(Ualert);
jt1.addFocusListener(new FocusAdapter()
{
public void focusLost(FocusEvent e)
{
   uflag=false;
   if(jt1.getText().equals("Your registered mobile number") || jt1.getText().equals(""))
   {
   Ualert.setText(" ! Please enter USERNAME ");
   Ualert.setForeground(Color.RED);
   }
   else if(jt1.getText().length()!=10)
   {
    Ualert.setText("! Enter 10 numbers");
    Ualert.setForeground(Color.RED);
   }
   else
   {
    Ualert.setText("");
    uflag=true;
   } 
}
}); 
	
password=new JLabel("Password:");
password.setBounds(50,170,200,25);
main.add(password);

jp1=new JPasswordField();//              PASSWORD
jp1.setBounds(140,170,200,30);
jp1.setBorder(BorderFactory.createLineBorder(new Color(178, 12, 12)));
main.add(jp1);

Palert=new JLabel();
Palert.setBounds(140,200,250,20);
Palert.setForeground(Color.red);
main.add(Palert);
jp1.addFocusListener(new FocusAdapter()
{
public void focusLost(FocusEvent e)
{
    pflag=false;
    if(jp1.getText().equals(""))
    {
        Palert.setText(" ! Please enter PASSWORD ");
    }
    else if((jp1.getText().length())<8)
    {
        Palert.setText(" ! PASSWORD should contain 8 Characters");
    }
    else
    {
        Palert.setText("");
        pflag=true;
    }
}
});

choose=new JLabel("Select Table:");
choose.setBounds(50,220,200,20);
main.add(choose);
jr1=new JRadioButton("1");
jr1.setBounds(140,220,50,20);
main.add(jr1);

jr2=new JRadioButton("2");
jr2.setBounds(190,220,50,20);
main.add(jr2);

jr3=new JRadioButton("3");
jr3.setBounds(240,220,50,20);
main.add(jr3);

jr4=new JRadioButton("4");
jr4.setBounds(290,220,50,20);
main.add(jr4);

jr5=new JRadioButton("5");
jr5.setBounds(140,250,50,20);
main.add(jr5);

jr6=new JRadioButton("6");
jr6.setBounds(190,250,50,20);
main.add(jr6);

bg=new ButtonGroup();
bg.add(jr1);bg.add(jr2);bg.add(jr3);bg.add(jr4);bg.add(jr5);bg.add(jr6);

Talert=new JLabel();
Talert.setBounds(140,270,250,20);
Talert.setForeground(Color.red);
main.add(Talert);

login=new JButton("Login");
login.setFont(new Font("Century Gothic",Font.BOLD,15));
login.setBackground(new Color(178, 12, 12));
login.setForeground(Color.WHITE);
login.setBounds(140,300,90,30);
login.addActionListener(this);
main.add(login);

reset=new JButton("Reset");
reset.setFont(new Font("Century Gothic",Font.BOLD,15));
reset.setBackground(new Color(178, 12, 12));
reset.setForeground(Color.WHITE);
reset.setBounds(250,300,90,30);
reset.addActionListener(this);
main.add(reset);

jf.setVisible(true);
}
//////////////////////////////////////////////////////
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==login)
{
   if((jr1.isSelected()==false)&&(jr2.isSelected()==false)&&(jr3.isSelected()==false)&&(jr4.isSelected()==false)&&(jr5.isSelected()==false)&&(jr6.isSelected()==false))
   Talert.setText("! Select Table Number");
   else
   {
       Talert.setText("");
       tflag=true;
   }
   if(jp1.getText().equals(""))
   Palert.setText(" ! Please enter PASSWORD ");
   /*System.out.println(uflag);
   System.out.println(pflag);
   System.out.println(tflag);*/
   
   if(uflag==true&&pflag==true&&tflag==true)
   {
     DataBase();
   }
   else
   {
       JOptionPane.showMessageDialog(null, "Something is wrong!!\nPlease enter data correctly.");
   }    
}
if(ae.getSource()==reset)
{
    uflag=false;pflag=false;tflag=false;
    jp1.setText("");
    jt1.setForeground(Color.gray);
    jt1.setText("Your registered mobile number");
  //  bg.setSelected(bg.getSelection(), false);
  Ualert.setText("");
  Palert.setText("");
  Talert.setText("");
  bg.clearSelection();
  count=0;
    
}
}

void DataBase()
{
    try
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "password");
        Statement ps=con.createStatement();
        ResultSet rs=ps.executeQuery("Select * from lavish.Register where Mobile='"+jt1.getText()+"' and Password='"+jp1.getText()+"'");
        if(rs.next())
        {
            
            jf.dispose();
            JOptionPane.showMessageDialog(null, "SUCCESS");
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "GALAT DATA");
        }
        
    }catch(Exception e)
    {
        System.out.println(e);
    }
    
}



public static void main(String a[])
{
new Lavish();
}
}

