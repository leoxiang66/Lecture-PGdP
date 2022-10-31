

public class WordCount {

	private String wort;
	private int häufigkeit;
	public WordCount(String wort, int häufigkeit)
	{
		
		if(häufigkeit>=0)    //Häufigkeit muss nicht negativ sein,somit benutzt man if-statement,diesen
		 {                   // Fall zu behandeln;
			this.wort=wort;
			this.häufigkeit=häufigkeit;
		 }
		else System.out.println("sinnlose Eingaben von Häufigkeit");
	}
	public String getWort()
	{
		return wort;
	}
	public int getHäufigkeit()
	{
		return häufigkeit;
	}
	public void setHäufigkeit(int häufigkeit)
	{
		if(häufigkeit>=0)    //Häufigkeit muss nicht negativ sein,somit benutzt man if-statement,diesen
		 {                   // Fall zu behandeln;
			this.häufigkeit=häufigkeit;
		 }
		else System.out.println("sinnlose Eingaben von Häufigkeit");
	}
	public int incrementCount()
	{
		this.häufigkeit=this.häufigkeit+1;
		return this.häufigkeit;
	}
	public int incrementCount(int n)
	{
		if(n>=0)      //n muss postitiv sein;
		{            
		   this.häufigkeit=this.häufigkeit+n;
		   return this.häufigkeit;
		}
		else 
		{
		  return this.häufigkeit; // Wenn n als Negative übergeben wird,sollten sich die Häufigkeit nicht   
		}                         // verändern, deshalb return ich einfach die originale Häufigkeit.
	}
	/*
	 * 
	 * Testmethoden werden in Klasse Test implentiert;
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
