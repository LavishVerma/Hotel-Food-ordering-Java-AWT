
package lavish;
import java.util.*;

public class random 
{
    Integer num;
    Integer array[]=new Integer[5];
    random()
    {
         Random rd=new Random();
     for(int i=0;i<5;)
     {
         num=rd.nextInt(25);
         if(i==0||exists(num,array))
         {
         // System.out.println(num);
          array[i]=num;
          i++; 
         }
     }
     
    }
    boolean exists(Integer num,Integer array[])
    {
        for(int i=0;i<array.length;i++)
        {
            if(num==array[i])
                return false;
        }
        return true;
    }
    
    Integer[] getRandomArray()
    {
        return array;
    }
 public static void main(String az[])
 {
     new random();
    
 }   
}
