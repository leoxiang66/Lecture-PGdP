
/**
 * The class {@code Date} represents a date.
 * 
 * A {@code Date} consists of a day, a month and a year.
 * 
 *
 */
public class Date {
  /**
   * the day of the date
   */
  private int day;

  /**
   * the month of the date
   */
  private int month;

  /**
   * the year of the date
   */
  private int year;

  /**
   * Constructs a date that represents the current date.
   */
  public Date() {
    this.day = Terminal.TODAYS_DAY;
    this.month = Terminal.TODAYS_MONTH;
    this.year = Terminal.TODAYS_YEAR;
  }

  /**
   * Constructs a date with the given values.
   * 
   * @param day   the day
   * @param month the month
   * @param year  the year
   */
  public Date(int day, int month, int year) {
	if(day<1||day>31||month<1||month>12||year<0) 
		System.out.println("sinnlose Eingaben");
	else
		{
		this.month = month;
	    this.day = day;	
        this.year = year;
		}
    
  }

  /**
   * Returns the day of the date.
   * 
   * @return the day of the date
   */
  public int getDay() {
    return day;
  }

  /**
   * Returns the month of the date.
   * 
   * @return the month of the date
   */
  public int getMonth() {
    return month;
  }

  /**
   * Returns the year of the date.
   * 
   * @return the year of the date
   */
  public int getYear() {
    return year;
  }

  /**
   * Returns the days of this date since 01/01/1970. We have to admit that this is
   * a very simple implementation that assumes that every month has exactly 30
   * days and that there are no leap years.
   * 
   * @return the days since 01/01/1970
   */
  private int daysSince1970() {
    // 30 days for every month
    return (this.year - 1970) * 30 * 12 + (this.month - 1) * 30 + (this.day - 1);
  }

  /**
   * Returns the full years between the specified date and the date represented by
   * this instance.
   * 
   * @param today the specified date
   * @return the full years
   */
  public int getAgeInYearsAt(Date today) {
    int ageInDays = this.getAgeInDaysAt(today);
    int ageInMonths = ageInDays / 30;
    int ageInYears = ageInMonths / 12;
    return ageInYears;
  }

  /**
   * 
   * Returns the days between the specified date and the date represented by this
   * instance.
   * 
   * @param today the specified date
   * @return the days
   */
  public int getAgeInDaysAt(Date today) {
    return today.daysSince1970() - this.daysSince1970();
  }

  /**
   * Returns a string representation of this date.
   */
  public String toString() {
    return this.day + "/" + this.month + "/" + this.year;
  }
  // Aufgabe 3.6
  public void setDay(int day)
  {
	 if(1<=day&&day<=31)  this.day=day;                                              //day in a month belongs to [1,31]
	 if(day<1||day>31) System.out.println("sinnlose Eingaben von day"); 
  }
  public void setMonth(int month)
  {
    if(1<=month&&month<=12)  this.month=month;                                       //month in a year belongs to[1,12]
    if(month<1||month>12) System.out.println("sinnlose Eingabe von month");
  }
  public void setYear(int year)
  {
	  if(year>=0) this.year=year;                                                   //years must not be negative;
	  if (year<0) System.out.println("sinnlose Eingaben von year");          
	  
  }
  
  
  
  
  
  
  
  
  
  public static void main(String[] args)
  {
	  /*
	  Date a = new Date();
	  a.setDay(55);
	  Date b = new Date (444,4444,434);
	  System.out.println(b.getDay());
	  
	  Author as = new Author();
	  as.setEmail("34234234");
	  Test.testOfConstructor();
	  Test.testOfgetHäufigkeit();
	  Test.testOfgetWort();
	  Test.testOfincrementCount();
	  Test.testOfincrementCountWithParameterN();
	  Test.testOfsetHäufigkeit();
	  
	  System.out.println(Primverquerung.isPrim(19));
	  int[] ggg=Primverquerung.primsLessThanN(100);
	  System.out.println(ggg[4]);
	  System.out.println(Primverquerung.QuersummeIstgerade(99));
	  */
	  System.out.println(Primverquerung.querPrim(100));
	  
	  /*
	  System.out.println(Stringulina.substringPos("00000", "1"));
	  System.out.println(Stringulina.countSubstring("abababababababababab", "aba"));
	  System.out.println(Stringulina.correctlyBracketed(")45345345"));
	  */
	  StringulinaTest.Testofmatches("pijnguin","p.{2}ngui{1}.");
	  StringulinaTest.TestofcorrectlyBracketed("()(ffhd))");
	  StringulinaTest.TestofcountSubstring("waaaaa", "aa");
	  StringulinaTest.Testofsubstringpos("erwrewsfasadwe", "erws");
	  
	  
	  
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
