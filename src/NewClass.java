import java.util.*;
public class NewClass {
    
    public static void main(String a[])
    {
        Scanner sc = new Scanner(System.in);
        String s;
	s=sc.nextLine();
	
	int x=0;
	for(int i=0; i<s.length(); i++)
	{
		char ch=s.charAt(i);
		if(ch=='*')
                {x=i;
		break;}
	}
	System.out.println(x);
	int n1=0;
	for(int i=0; i<x-1; i++)
	{
		
		n1 = (n1*10)+ s.charAt(i)-48;
                
	}
	
	System.out.println(n1);
	
    }
    
}
