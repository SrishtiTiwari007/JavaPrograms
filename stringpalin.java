package p1;
import java.util.*;
public class stringpalin {
	public static boolean palin(String s)
	{
		int i=0,j=s.length()-1;
		while(i<j)
		{
			if(s.charAt(i)!=s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
	public static void main(String[] args) {
		String s;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter word");
		s=sc.next();
		if(s.matches("[a-zA-Z]+")==true) {
			if(palin(s)==true)
				System.out.println(s+" is a palindrome");
			else
				System.out.println(s+" is not a palindrome");
		}
		else
		{
			System.out.println("Invalid Input");
		}
	}

}
