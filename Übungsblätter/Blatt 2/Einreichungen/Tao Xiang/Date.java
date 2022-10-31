package AufgabeH;

public class Date { 

	private int day,month,year;
	
	// Setter-Methoden
	public void setDay(int day)
	{
		this.day=day;
	}
	public void setMonth(int month)
	{
		this.month=month;
	}
	public void setYear(int year)
	{
		this.year=year;
	}
	//Konstruktor
	public Date(int day,int month,int year)
	{
		this.day=day;
		this.month=month;
		this.year=year;
	}
	
	public Date()
	{
			this.day=Terminal.TODAYS_DAY;
			this.month=Terminal.TODAYS_MONTH;
			this.year=Terminal.TODAYS_YEAR;
		
	}
	//toString-Methoden
	public String toString()
	{
		return "Datum :"+this.day+"."+this.month+"."+this.year;
	}
	//Datumsfunktion
	private int daysSince1970()
	{
		int y,m,d,totalDays;/* y ist der Abstand von Jahren;
		                       m ist der Abstand von Monaten;
		                       d ist der Abstand von Tagen; */
		y = this.year - 1970;
		m = this.month - 1;
		d = this.day- 1 ;
		totalDays = y*365 + m*30 + d;
		return totalDays;      
	}
	public int getAgeInDaysAt(Date today)
	{
		int y,m,d,totalDays;/* y ist der Abstand von Jahren;
                                m ist der Abstand von Monaten;
                                d ist der Abstand von Tagen; */
		y = today.year - this.year;
		m = today.month - this.month;
		d = today.day - this.day;
		totalDays = y*365 + m*30 + d;
		return totalDays;	
	}
	public int getAgeInYearsAt(Date today)
	{
		if(today.month>this.month) /* wegen ,,bereits vollendeten Jahre`` muss man die exakte Tage vergleichen,
		                             also zuerst kann man Monten vergleichen*/  
		{
			return today.year-this.year; /* Wenn die Monate heute größer als die Geburtsmonate des Autors ist,
			                               bedeutet daß das Jahr schoch vollendete.*/
		}
		else if (today.month==this.month)/* Wenn die Monate heute=die Geburtsmonate,dann muss man die Tage vergleichen*/
		{
			if(today.day>=this.day)/*In diesem Fall ist das Jahr vollendet*/
			{
				return today.year-this.year;
			}
			else return today.year-this.year-1;/* In diesem Fall ist das letzte Jahr noch nicht vollendet,also muss man es subtrahieren*/
		}
		else return today.year-this.year-1;// gleichfalls wie oben
	}
	
	
	
	
	/*Meine Gedanken über Dokumentation:
	 *   
	 * Zum ersten hilft die Dokumentation dabei,  nach einigen Tagen beim Wiederschauen der Codes schnell zu erfassen, was
	 * die Codes bedeuten.
	 * 
	 * Und in Zukunft werden wir viel längere und kompliziertere Codes programmieren,und dabei hilft die Dokumentation, 
	 * innerhalb dieser langen Code ein bestimmten Teil zu wiederchecken.
	 * 
	 * Und natürlich,die Dokumentation hilft den anderen Leute beim Verstehen der Codes,vor allem unserer Tutorin :)	 
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 */
	
	//das Untere ist nur ein Test..
	 
	 
	 public static void main(String[] args)
	 
	{
		Date b=new Date();
		b.day=5;
		b.month=12;
		b.year=1989;
		Date c =new Date();
		Author a = new Author();
		a.setBirthday(b);
		System.out.println(a.getAgeAt(c));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


