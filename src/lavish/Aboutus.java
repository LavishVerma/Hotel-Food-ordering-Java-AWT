/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lavish;
import java.awt.*;
import javax.swing.*;

public class Aboutus{
   
    JLabel lab,blab,big;
    JTextArea small;
    
    Aboutus()
    {                                     
        blab=new JLabel(new ImageIcon(getClass().getClassLoader().getResource("resources/images/photos/aboutback.jpg")));
        blab.setBounds(0,0,1166,250);
        blab.setBorder(BorderFactory.createLineBorder(Color.black));
        blab.setLayout(null);
        lab=new JLabel(new ImageIcon(getClass().getClassLoader().getResource("resources/images/photos/chef.jpg")));
        lab.setBounds(0,0,573,230);
       // lab.setBorder(BorderFactory.createLineBorder(Color.black));
        big=new JLabel("  About Us...");
        big.setFont(new Font("Century Gothic",Font.BOLD | Font.ITALIC,30));
        big.setForeground(Color.white);
        big.setBounds(583,10,200,50);
      //  big.setBorder(BorderFactory.createLineBorder(Color.black));
        
        small=new JTextArea("Welcome to Restaurant week. Here we try to share our best about food quality,\nour mission about customer satisfaction and introducing services that we \nprovide for you,your friends and family. We love restaurant Week as much as\n you do. That's why we have been helping them fill tables since 1997.\n\n                                                     ! Thanks for visiting !");
      //  small.setLineWrap(true);
        small.setForeground(Color.white);
        small.setFont(new Font("Century Gothic",Font.BOLD|Font.ITALIC,15));
        small.setBounds(575,70,585,120);
        small.setOpaque(false);
        small.setEditable(false);
      //  small.setBorder(BorderFactory.createLineBorder(Color.black));
        
        blab.add(big);
        blab.add(small);
        blab.add(lab);
    }
    
    public Container get()
    {
        return blab;
    }
}