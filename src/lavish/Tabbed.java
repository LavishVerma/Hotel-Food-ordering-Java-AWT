package lavish;

import javax.swing.*;
import java.awt.*;



class Tabbed
{
    //linkitems l[]=new linkitems[5];
    JTabbedPane JTP;
    JPanel panels[]=new JPanel[5];
    JScrollPane scroll[]=new JScrollPane[5];
    private int curr_x[]=new int[]{50,50,50,50,50};
    private int curr_y[]=new int[]{50,50,50,50,50};  
    int height[]=new int[]{513,513,513,513,513};
    int rowcount[]=new int[]{0,0,0,0,0};
    int objectcount[]=new int[]{0,0,0,0,0};
    //String path[]=new Strin
    Tabbed()
    {
        String[] s=new String[]{"BREAKFAST","LUNCH","SNACKS","DINNER","BEVERAGES"};
        //JPanel mains[]=new JPanel[5];
        String[] path=new String[]{"C:\\Users\\photos\\bicon.png",
                                   "C:\\Users\\photos\\licon.png",
                                   "C:\\Users\\photos\\sicon.png",
                                   "C:\\Users\\photos\\dicon.png",
                                   "C:\\Users\\photos\\beicon.png"};
        JTP=new JTabbedPane();
        for(int i=0;i<scroll.length;i++)
        {
        panels[i]=new JPanel();
        panels[i].setLayout(null);
        panels[i].setPreferredSize(new Dimension(1095,height[i]));
        panels[i].setBorder(BorderFactory.createLineBorder(Color.red));
        panels[i].setBackground(new Color(245,222,179));
        scroll[i]=new JScrollPane(panels[i]);
        JTP.addTab(s[i],new ImageIcon(path[i]),scroll[i]);
        scroll[i].setBounds(0,0,966,320);
        scroll[i].setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll[i].setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        }
        
         JTP.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI()
        {
            @Override
            protected int calculateTabHeight(int tabPlacement, int tabIndex,int fontHeight)
            {
                return 35;
            }
        });
         
         JTP.setBackground(new Color(245,222,179));
         setupitems();
         
    }
    
   /* void init_items()
    {
        for(int i=0;i<5;i++)
        {
            l[i]=new linkitems();
            for(int j=0;j<10;j++)
             l[i].add(new items());
        }
    }*/
    
    void setBounds(int x,int y,int w,int h)
    {
        JTP.setBounds(x,y,w,h);
    }
    
    
    private void add(int no,items i)
    {
        if(objectcount[no]%3==0 && objectcount[no]!=0)    
        {
            curr_x[no]=50;
            curr_y[no]=curr_y[no]+150;
            if(height[no]-curr_y[no]<=50)
              {
                height[no]=height[no]+150;
                panels[no].setPreferredSize(new Dimension(1125,height[no]));
              } 
        }
        objectcount[no]++;
        panels[no].add(i.get());
        i.setBounds(curr_x[no],curr_y[no],300,150);
        curr_x[no]=curr_x[no]+350;
    }   
    
    
   /* void addlinklist(int no,linkitems l)
    {
        for(nodeitems n=l.start;n!=null;n=n.next)
            add(no,n.i);
    }*/
    
    
    public Container get()
    {
        return JTP; 
    }
    
    void setupitems()
    {
        String path[][]={
                             {"alooparantha","bhature","breadtoast","burger","eggcurry","eggroll","halffry","puri","sandwich","toast","vegroll"},
                             {"biryani","butterchicken","chane","chickenrice","chillipaneer","friedrice","kadhi","manchurian","mixveg","roasted","thali"},
                             {"aloo tikki","hotdog","kachori","macroni","mushroom","noodles","packore","pasta","patties","pizza","potatoroll","samosa"},
                             {"chicken curry","chillipaneer","dal","fried fish","masalachicken","noodles","palakpaneer","paneertikka","pavbhaji","pork","shahipaneer"},
                             {"banana","blueberry","chocolate shake","coffee","coldcoffee","limesoda","mangoshake","orange","strawberry","tea","vanilla"},
                            };
        
        String price[][]={
                          {"20","30","20","40","50","40","50","30","30","10","50"},
                          {"90","250","100","150","130","50","50","70","90","150","190"},
                          {"50","40","15","50","65","45","35","120","15","150","25","15"},
                          {"160","130","130","200","220","80","165","145","45","195","210"},
                          {"35","25","45","25","40","20","35","30","50","20","40"}
                          };
        
        String name[][]={
                        {"ALOO PRANTHA","BHATURE","BREAD TOAST","BURGER","EGG CURRY","EGGROLL","HALFFRY","PURI","SANDWICH","TOAST","VEG ROLL"},
                        {"BIRYANI","BUTTER CHICKEN","CHANE","CHICKEN RICE","CHILLI PANEER","FRIED RICE","KADHI","MANCHURIAN","MIX VEG","ROASTED","THALI"},
                        {"ALOO TIKKI","HOT DOG","KACHORI","MACRONI","MUSHROOM","NOODLES","PACKORE","PASTA","PATTIES","PIZZA","POTATO ROLL","SAMOSA"},
                        {"CHICKEN CURRY","CHILLI PANEER","DAL","FRIED FISH","MASALA CHICKEN","NOODLES","PALAK PANEER","PANEER TIKKA","PAV BHAJI","PORK","SHAHI PANEER"},
                        {"BANANA","BLUE BERRY","CHOCOLATE SHAKE","COFFEE","COLD COFFEE","LIME SODA","MANGO SHAKE","ORANGE","STRAW BERRY","TEA","VANILLA"}
                        };
        String Folder[]={"Breakfast","lunch","snacks","dinner","Beverges"};
        items it[][]=new items[5][10];
        for(int i=0;i<5;i++)
        {
            it[i]=new items[path[i].length];
            for(int j=0;j<it[i].length;j++)
            {
                it[i][j]=new items(new ItemsContents("C:\\Users\\photos\\newfood\\"+Folder[i]+"\\"+path[i][j]+".jpg",price[i][j],name[i][j]));
                add(i,it[i][j]);
            }
        }
        
    }
}