

public class Stringulina {

	public static int substringPos(String haystack,String needle)
	{
		int startpoint;
		char[] h = new char[haystack.length()];
		char[] n = new char[needle.length()];
		for(int i=0;i<haystack.length();i++) // creat 2 char[] with for statement;
		{
			h[i]=haystack.charAt(i);
		}
		for(int i=0;i<needle.length();i++)
		{
			n[i]=needle.charAt(i);
		}
		int indexpointer=0;
		int times=0;                         //times: the times of n[i]==h[k],once n[i+j]!=h[k+j] before the last char of needle,times will 
		for(int i=0;i<needle.length();i++)          // be set to 0;
		{
			
			for(int k=indexpointer;k<haystack.length();k++)
			{
				if(n[i]==h[k]) 
					{
					  times++;
					  indexpointer=k+1;
					  break;
					}
				if(n[i]!=h[k] && i!=0)
				{
					times=0;
					i=0;
					k--;
				}
			}
		}
		if(times==needle.length()) 
		{
			startpoint=indexpointer-times;
			return startpoint;
		}
		else return -1;	
	}
	public  static int countSubstring(String haystack,String needle)
	{
		char[] h = new char[haystack.length()];
		char[] n = new char[needle.length()];
		for(int i=0;i<haystack.length();i++) // creat 2 char[] with for statement;
		{
			h[i]=haystack.charAt(i);
		}
		for(int i=0;i<needle.length();i++)
		{
			n[i]=needle.charAt(i);
		}
		int indexpointer=0;
		int times=0;       
		int Häufigkeit=0;
		for(int i=0;i<needle.length();i++)          
		{
			
			for(int k=indexpointer;k<haystack.length();k++)
			{
				if(n[i]==h[k]) 
					{
					  times++;
					  if(times==needle.length())//times == n.length bedeutet "needlle" vorkommt einmal;
					     {
						  Häufigkeit++;        //somit Häufigkeit++;
						  i=-1;                // damit nach break und i++ i wieder =0;
						  indexpointer=k+2-needle.length();//dies ist nur mathematische Ergebnisse;  
						  times=0;            // zum Wiederrechnen für die Häufigkeit;
						  break;
					     }
					  indexpointer=k+1;
					  break;
					}
				if(n[i]!=h[k] && i!=0)          //z.B haystack: abc
				{                               //    needle  : abd
					times=0;
					i=0;
					k--;
				}
			}
		}
		return Häufigkeit;
	}
	public static boolean correctlyBracketed(String str)
	{
		boolean correct=true;
		char[] string = new char[str.length()];
		for(int i=0;i<str.length();i++)
		{
			string[i]=str.charAt(i);
		}
		
		int counter1=0,counter2=0;
		int[] indexofopenbracket= new int[str.length()];
		int[] indexofclosebracket=new int[str.length()];
		int j=0,k=0;
		for(int i =0;i<str.length();i++)
		{
			
			switch(string[i])
			{
			case '(' : counter1++; indexofopenbracket[j++]= i;break;   // z.B. indexofopenbracket[2]=4 bedeutet :bei Index 4  
			case ')' : counter2++; indexofclosebracket[k++]=i;break;   // von str ist ein "(".
			}
		}
		
		
		if(counter1!=counter2) correct= false;
		if(counter1==counter2) 
		{
			if(counter1==0) correct= true;
			else if (indexofopenbracket[counter1-1]>indexofclosebracket[0]) correct=false;// z.B. "(()())"
			else correct=true;
		}
		return correct;
	}
	        
	
	public static boolean matches(String str,String pattern)
	{
		/*
		 * firstly convert string to char[]
		 * 
		 * */
		char[] s = new char[str.length()];
		char[] p = new char[pattern.length()];
		for(int i=0;i<str.length();i++)
		{
			s[i]=str.charAt(i);
		}
		for(int i=0;i<pattern.length();i++)
		{
			p[i]=pattern.charAt(i);
		}
		
/*
 * 
 * 
 * 
 * then creat 3 int[] for index of left bracket in pattern, index of right bracket in pattern, the multiplicity in integer;
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */
		char[] vielfachheit=new char[pattern.length()];
		int[] indexofleftbracket=new int[pattern.length()];
		int[] indexofrightbracket=new int[pattern.length()];
		int[] INTvielfachheit = new int[pattern.length()];
		int j=0;
		int k = 0,l=0;
		int n=0;
		for(int i=0;i<pattern.length();i++)
		{
			
			if(p[i]=='{') 
				{
				   indexofleftbracket[k++]=i;
				  
				}
			if(p[i]=='0'||p[i]=='1'||p[i]=='2'||p[i]=='3'||p[i]=='4'||p[i]=='5'||p[i]=='6'||p[i]=='7'||p[i]=='8'||p[i]=='9')
			{
				vielfachheit[j++]=p[i];
				
				
			}
			if(p[i]=='}')
			{
				indexofrightbracket[n++]=i;
				
				int length=0;
				for(int b=0;b<pattern.length();b++)
				{
					if(vielfachheit[b]!=0)
						length++;
				}
				char[] truevielfachheit =new char[length];
				for(int b=0;b<length;b++)
				{
					truevielfachheit[b]=vielfachheit[b];
				}
				String x = new String(truevielfachheit);
				INTvielfachheit[l++]=Integer.parseInt(x);
				vielfachheit= new char[pattern.length()];	
				j=0;
			}
			
		}
		/*
		 * cut off the array elements whose value is 0 in INTvielfachheit[]
		 * 
		 * 
		 * 
		 * 
		 * */
		int length2 = 0;
		for(int b=0;b<pattern.length();b++)
		{
			if(INTvielfachheit[b]!=0)
				length2++;
		}
		int[] truevielfachheit=new int[length2];
		for(int b=0;b<length2;b++)
		{
			truevielfachheit[b]=INTvielfachheit[b];
		}
		/*
		 * determine how long a right string for a certain pattern should be;
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
		
		
		int rightlengthofStr=0;
		for(int i=0;i<pattern.length();i++)
		{
			if(p[i]!='{'&&p[i]!='}'&&p[i]!='0'&&p[i]!='1'&&p[i]!='2'&&p[i]!='3'&&p[i]!='4'&&p[i]!='5'&&p[i]!='6'&&p[i]!='7'&&p[i]!='8'&&p[i]!='9')
			{
				rightlengthofStr++;
			}
		}
		for(int i=0;i<pattern.length();i++)
		{
			if(INTvielfachheit[i]!=0)
			 rightlengthofStr += INTvielfachheit[i]-1;
		}
		
		
		/*
		 * 
		 * creat a char array :
		 * for example
		 * if pattern is p.{2}s{3}
		 * then the char[] I made is p00sss;
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
		char[] c =new char[rightlengthofStr];
		int index=-1;
		for(int i =0,h=0;i<pattern.length();i++)
		{
			if(('a'<=p[i]&&p[i]<='z')||('A'<=p[i]&&p[i]<='Z'))
			{
				c[h++]=p[i];
			}
			if(p[i]=='.')
			{
				c[h++]='0';
			}
			if(p[i]=='{')
			{
				index++;
				for(int j1=1;j1<truevielfachheit[index];j1++)
				{
					
					c[h]=c[h-1];
					h++;
				}
			}
		 
			
		}
	
		
		
		//jetzt beginn zu  vergleichen...
		
		
		
		boolean passt = true;
		
		
		if(str.length()!=rightlengthofStr) 
			{passt=false;}
		
		if(str.length()==rightlengthofStr)
		{
			for(int g=0;g<rightlengthofStr;g++)
			{
			
				if(c[g]!='0')                        // skip the '0'
				{
					if(c[g]!=s[g])
						{System.out.println("s"+g+"= "+s[g]);
						passt=false;
						}
						
				}
			}	
		}
								
		return passt;	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
