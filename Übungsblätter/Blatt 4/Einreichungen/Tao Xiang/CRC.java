
public class CRC {
	int Bitzahl;
	int poly;

	public CRC (int poly)  //Konstruktor
	{
		Bitzahl=Integer.toString(poly).length()-1;
		this.poly=poly;
	}
	public int getDegree()
	{
		
		return this.Bitzahl;
	}
	private static String string2Date(String s)//z.B. "a" zu "1100001"
	{
		String a="";
		for(int i=0;i<s.length();i++)
		{
			int j= s.charAt(i);
			a+= Integer.toBinaryString(j);
			
		}
		return a;
	}
	private static char XOR(char a, char b)
	{
		char nachxor;
		if(a==b) nachxor ='0';
		else nachxor='1';
		return nachxor;
	}
	private static String nachXOR(String a,int poly,int Bitzahl)
	{
		int n=Bitzahl;
		String str_poly=Integer.toString(poly);
		char[] a1=a.toCharArray();
		char[] poly1=str_poly.toCharArray();
		for(int i=0;i<a1.length-n;i++)
		{
			if(a1[i]!='0')
			{
				for(int j=0,k=0;j<n+1;j++,k++)
				{
					a1[i+k]=CRC.XOR(a1[i+k], poly1[j]);
				}
			}
		}
		return new String(a1);
	}
	
	
	public int crcASCIIString(String s)
	{
		int n = this.Bitzahl;
		String a=CRC.string2Date(s);
		for(int i=0;i<n;i++)
		{
			a+="0";
		}
		String c=CRC.nachXOR(a, this.poly, n);
		System.out.println("CRC von dieser String ist :  "+Integer.parseInt(c,2));
		return Integer.parseInt(c,2);
	}
}
