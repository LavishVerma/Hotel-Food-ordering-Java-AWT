
package lavish;
import java.awt.*;
import javax.swing.*;

public class Cart 
{
    JPanel jp,lowest;
    JLabel heading,payment;
    JButton jb;
    int curr_y=75,total=0;         
    int curr_h=555;
    Integer totalamount=0;
    Cart()
    {
        jp=new JPanel();
        jp.setBorder(BorderFactory.createLineBorder(Color.red));
        
        setup();
    }
    
    final public void setup()
    {
        jp.setLayout(null);
        jp.setBackground(new Color(245,222,179));
        jp.setPreferredSize(new Dimension(1166,555));
        heading=new JLabel("SrNo.          ITEM                                       NAME                                      QUANTITY                                   PRICE                        REMOVE");
        heading.setBounds(100,10,950,50);
        heading.setFont(new Font("Century Gothic",Font.ITALIC,15));
        heading.setBorder(BorderFactory.createLineBorder(Color.black));
        jp.add(heading);
        
        lowest=new JPanel();
        lowest.setLayout(null);
        lowest.setOpaque(false);
        lowest.setBounds(100,75,950,50);
       // lowest.setBorder(BorderFactory.createLineBorder(Color.black));
        jp.add(lowest);
        
        payment=new JLabel("TOTAL PAYABLE AMOUNT : Rs.0");
        payment.setFont(new Font("Century Gothic",Font.BOLD,20));
        payment.setForeground(Color.BLUE);
        payment.setBounds(20,5,320,40);
       payment.setBorder(BorderFactory.createLineBorder(Color.black));
        lowest.add(payment);
        
        jb=new JButton("CONFIRM ORDER");
        jb.setFont(new Font("Century Gothic",Font.BOLD,15));
        jb.setForeground(new Color(0,0,0));
        jb.setBackground(new Color(72,209,204));
        jb.setBounds(700,5,200,40);
        lowest.add(jb);
    }
    public JPanel get()
    {
        return jp;
    }
    
    public void appendToCart(items i)
    {
        total++;
        if(curr_h-curr_y<=60)
        {
            curr_h=curr_h+105;
            jp.setPreferredSize(new Dimension(1166,curr_h));
        }
        
        lowest.setLocation(100,curr_y+105);
        CartItems temp=new CartItems(i,total);
        temp.setLocation(100,curr_y);
        jp.add(temp.get());
        temp.c=this;      // C IS CART OBJECT IN CARTITEMS.    AND THIS IS THE CART OBJECT OF HOMEPAGE.
        i.ci=temp;
        curr_y+=105;
        temp.jp.addComponentListener(temp);//????
        totalamount=totalamount+temp.newprice;
        setPayment(totalamount);
    }
    
    
    public void setPayment(int totalamount)
    {
        payment.setText("TOTAL PAYABLE AMOUNT : Rs."+totalamount);
    }
    
    
    public void removeFromCart(int index)
    {
        int tempy=75+(index-1)*105;
        jp.remove(jp.getComponentAt(100,tempy));
        tempy=tempy+105;
        for(int i=index;i<total;i++)
        {
            jp.getComponentAt(100,tempy).setLocation(100,tempy-105);
            tempy=tempy+105;
        }
        curr_y=tempy-105;
        total--;
        
        if(curr_h!=555&&curr_h-curr_y>60 )
        {
            curr_h=curr_y+60;
            jp.setPreferredSize(new Dimension(1166,curr_h));
         //   jp.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        }
        lowest.setLocation(100,curr_y);
        
    }  
}