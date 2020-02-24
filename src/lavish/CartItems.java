package lavish;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.event.*;


class CartItems extends ComponentAdapter implements ActionListener,ChangeListener
{
    JPanel jp;
    JLabel img,name,price,count;
    SpinnerModel value;
    JSpinner spin;
    JButton close;
    Integer index,newprice,prevP;
    items it;
    Cart c;
    boolean cartflag=false;
    CartItems(items i,Integer index)
    {
        it=i;
        
        jp=new JPanel();
        jp.setLayout(null);
        jp.setSize(950,95);
        jp.setOpaque(false);
        jp.setBorder(BorderFactory.createLineBorder(Color.black));
        this.index=index;
        
        count=new JLabel(index.toString());
        count.setBounds(10,37,20,20);
        count.setBorder(BorderFactory.createLineBorder(Color.black));
        jp.add(count);

        img=new JLabel(new ImageIcon(i.ic.path));
        img.setBounds(45,5,110,85);
        img.setBorder(BorderFactory.createLineBorder(Color.black));
        jp.add(img);
        
        name=new JLabel(i.ic.name);
        name.setBorder(BorderFactory.createLineBorder(Color.black));
        name.setBounds(240,32,120,31);
        jp.add(name);
        
        int num=i.ic.Quantity;
        value=new SpinnerNumberModel(num,1,10,1);
        spin=new JSpinner(value);
        ((JSpinner.DefaultEditor)spin.getEditor()).getTextField().setEditable(false);
        spin.setBounds(460,32,80,31);
        spin.addChangeListener(this);
        jp.add(spin);
        
        newprice=Integer.parseInt(i.ic.price)*i.ic.Quantity;
        prevP=newprice;
        price=new JLabel("Rs."+i.ic.price);
        price.setBounds(650, 32, 100, 31);
        price.setBorder(BorderFactory.createLineBorder(Color.black));
        jp.add(price);
        
        close=new JButton(new ImageIcon(getClass().getClassLoader().getResource("resources/images/photos/cancel.png")));
        close.setOpaque(false);
        close.setBorderPainted(false);
        close.setBackground(new Color(245,222,179));
        close.setBounds(838,35,25,25);
        close.addActionListener(this);
        jp.add(close);   
        
    }
    
    @Override
    public void stateChanged(ChangeEvent ce)
    {
        cartflag=true;
        it.ic.Quantity=(Integer)spin.getValue();
        newprice=Integer.parseInt(it.ic.price)*it.ic.Quantity;
        c.totalamount=c.totalamount+newprice-prevP;
        c.setPayment(c.totalamount);
        prevP=newprice;
        if(cartflag && !it.itemflag)
            it.spin.setValue(it.ic.Quantity);
        cartflag=false;
    }
    
   /* public void setValue(Integer i)
    {
        value.setValue(value);
    }*/
    
    
    @Override
    public void componentMoved(ComponentEvent e)
    {
        decIndex();
    }
    public void setLocation(int x,int y)
    {
        jp.setLocation(x,y);
    }
     
    public Component get()
    {
        return jp;
    }
    
    public void decIndex()
    {
        index--;
        count.setText(index.toString());
    }
    
    @Override
    public void actionPerformed(ActionEvent ie)
    {
       it.cb.setSelected(false); 
       c.totalamount=c.totalamount-newprice;
       c.setPayment(c.totalamount);
    }
    
    
}
