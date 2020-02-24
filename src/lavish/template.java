/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lavish;
import javax.swing.*;
import java.awt.*;
public class template
{
    JPanel jp;
    TodaySpecial ts;
    RestTime rt;
    LatestMenu lm;
    
    template()
    {
        jp=new JPanel();
        jp.setLayout(null);
        jp.setBorder(BorderFactory.createLineBorder(Color.black));
        ts=new TodaySpecial();
        ts.setBounds(0,0,350,310);
        jp.add(ts.get());
        lm=new LatestMenu();
        lm.setBounds(408,0,350,310);
        jp.add(lm.get());
        rt=new RestTime();
        rt.setBounds(816,0,350,310);
        jp.add(rt.get());
        jp.setBackground(new Color(255,222,179));
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
