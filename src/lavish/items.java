package lavish;


import javax.swing.*; 
import javax.swing.JSpinner.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

class ItemsContents
{
    String path,price,name;
    Integer Quantity=1;
    ItemsContents(String path,String price,String name)
    {
        this.path=path;
        this.name=name;
        this.price=price;
    }
}


public  class items {
    JPanel jp;
    JCheckBox cb;
    ImageIcon img;
    JSpinner spin;
    SpinnerModel value;
    JLabel price,name,image;
    ItemsContents ic;
    CartItems ci;
    boolean itemflag=false;
    public items(){}
    public items(ItemsContents i)
    {
        ic=i;
        
        jp=new JPanel();
        jp.setLayout(null);
        jp.setOpaque(false);
        
        cb=new JCheckBox();
        cb.setBounds(15,80,20,20);
        jp.add(cb);
    
        image= new JLabel(new ImageIcon(i.path));
        image.setBounds(45,32,110,85);
        image.setBorder(BorderFactory.createLineBorder(Color.black));
        jp.add(image);
        
        price=new JLabel("Price : Rs."+i.price);
         price.setBounds(60,123,81,20);
        price.setBorder(BorderFactory.createLineBorder(Color.black));
        jp.add(price);
       
        value=new SpinnerNumberModel(1,1,10,1);
        spin=new JSpinner(value);
        spin.setBounds(191,52,40,25);
        ((DefaultEditor)spin.getEditor()).getTextField().setEditable(false);
        spin.addChangeListener(new ItemAdapter(this));
        jp.add(spin);
        
        name=new JLabel(i.name);
        name.setBounds(171,92,100,20);
        name.setBorder(BorderFactory.createLineBorder(Color.black));
        jp.add(name);
        cb.addItemListener(new ItemAdapter(this));
        jp.addMouseListener(new ItemAdapter(this));
    }
    public void setBounds(int x,int y,int w,int h)
    {
        jp.setBounds(x,y,w,h);
    }
    
    
    
    public Container get()
    {
        return jp;
    }
    
    public String getName()
    {
        return ic.name;
    }
    
    public String getPrice()
    {
        return ic.price;
    }
    
    public String getImagePath()
    {
        return ic.path;
    }
}

class ItemAdapter extends MouseAdapter implements ItemListener,ChangeListener
{
    items i;
    ItemAdapter(items i)
    {this.i=i;}
    
    @Override
    public void mouseEntered(MouseEvent e)
    {
        if(!i.cb.isSelected())
        i.jp.setBorder(BorderFactory.createLineBorder(Color.blue));
    }
    
    @Override
    
    public void mouseExited(MouseEvent e)
    {
        if(!i.cb.isSelected())
        i.jp.setBorder(null);
    }
    
    @Override
    
    public void mouseClicked(MouseEvent e)
    {
        if(i.cb.isSelected())
            i.cb.setSelected(false);
        else
            i.cb.setSelected(true);
    }
    
    @Override
    public void itemStateChanged(ItemEvent ie)
    {
        if(ie.getStateChange()==ItemEvent.SELECTED)
        {
            i.jp.setBorder(BorderFactory.createLineBorder(Color.red));
            HomePage.cart.appendToCart(i);
        }
        else
        {
            i.jp.setBorder(null);
            HomePage.cart.removeFromCart(i.ci.index);
        }
    }
    
    @Override
    public void stateChanged(ChangeEvent c)
    {
        i.itemflag=true;
        i.ic.Quantity=(Integer)i.spin.getValue();
        
        if(i.cb.isSelected() && i.itemflag && !i.ci.cartflag)
        {
            i.ci.spin.setValue(i.ic.Quantity);
        }
        i.itemflag=false;
    }
}