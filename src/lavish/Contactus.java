/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lavish;

import java.awt.*;
import javax.swing.*;


class Contactus{ 
private class template
    {
        JLabel lab,main;
        JTextArea ta;
        String text;
        String path;
        template(String path,String text)
        {
            main=new JLabel();
            main.setLayout(null);
            lab=new JLabel(new ImageIcon(path));
            ta=new JTextArea(text);
            ta.setOpaque(false);
            ta.setForeground(Color.white);
            ta.setEditable(false);
            ta.setFont(new Font("Century Gothic",Font.BOLD,15));
           //lab.setBorder(BorderFactory.createLineBorder(Color.black));
            //main.setBorder(BorderFactory.createLineBorder(Color.black));
           // ta.setBorder(BorderFactory.createLineBorder(Color.black));
            lab.setBounds(33,5,70,70);
            ta.setBounds(5,75,130,100);
            main.add(lab);
            main.add(ta);
            
        }
        
        public void setBounds(int x,int y, int w,int h)
        { 
            main.setBounds(x,y,w,h);
        }        
        
        public Container get()
        {
            return main;
        }   
    }
    template t[];
    JLabel backimage;
    String text[]=new String[]{"Follow us on insta:\n\n#restaurantweek\n#bestrestaurant",
                               "Whatsapp no:\n\n(+91)-97801-96097\n(+91)-78379-59062\n",
                               "Like us on fb:\n\nRestaurentWeek\n",
                               "Follow us on:\n\n@restaurantweek",
                               "Email us at Gmail:\n\n restaurantweek@",
                                "Email us at Yahoo:\n\n restaurantweek@",
                                "Subscribe us at:\n\nRestaurantWeek"};
    String path[]={"insta.png","wht.png","fb.png","tweet.png","gmail.png","yahoo.png","you.png"};
    
    Contactus()
    {    
        backimage=new JLabel(new ImageIcon(getClass().getClassLoader().getResource("resources/images/photos/backimage1.jpg")));
        backimage.setBounds(0,0,1166,250);
        template t[]=new template[7];
        int x=5;
        for(int i=0;i<7;i++)
        {
            t[i]=new template("C:\\Users\\photos\\"+path[i],text[i]);
            t[i].setBounds(x,5,140,185);
            backimage.add(t[i].get());
            x+=160;
        }
    }
    
    
    public Container get()
    {
        return backimage;
    }   
}