/**
 * The class {@code Date} represents a date.
 * 
 * This class ensures, that the represented date is always a valid date. For
 * example, the method {@link Date#toString()} will never return 31/2/2010.
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
    this.day = 1;
    // We choose a month with 31 days so that setter for days won't fail
    this.month = 1;
    // We choose a leapyear so that the day setter won't fail
    this.year = 2020;
    this.setDay(day);
    this.setMonth(month);
    this.setYear(year);
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
  private static boolean istSchaltjahr(int n)
  {
	  boolean ist =true;
	  if(n%4!=0)
	  {
		  ist =false;
	  }
	  else if(n%100==0)
	  {
		  if(n%400!=0) ist=false;
	  }
	  return ist;
  }
  private int daysSince1970() 
  {
   int daysinthisyear=0;
   for(int i=1;i<this.month;i++)
   {
	   if(Date.istSchaltjahr(this.year))
	   {  switch(i)
	      {
	        case 1 : daysinthisyear+=31;break;
	        case 2 : daysinthisyear+=29;break;
	        case 3 : daysinthisyear+=31;break;
	        case 5 : daysinthisyear+=31;break;
	        case 7 : daysinthisyear+=31;break;
	        case 8 : daysinthisyear+=31;break;
	        case 10 :daysinthisyear+=31;break;
	        case 12 :daysinthisyear+=31;break;
	        default: daysinthisyear+=30;break;
	   }
	   }
	   if(!Date.istSchaltjahr(this.year))
	   {
		   switch(i)
		      {
		        case 1 : daysinthisyear+=31;break;
		        case 2 : daysinthisyear+=28;break;
		        case 3 : daysinthisyear+=31;break;
		        case 5 : daysinthisyear+=31;break;
		        case 7 : daysinthisyear+=31;break;
		        case 8 : daysinthisyear+=31;break;
		        case 10 :daysinthisyear+=31;break;
		        case 12 :daysinthisyear+=31;break;
		        default: daysinthisyear+=30;break;
	   }
   }
	   }
   daysinthisyear+=this.day-1;
   int daysinpastyears=0;
   for(int a=this.year-1;a>=1970;a--)
   {
	   if(Date.istSchaltjahr(a))
	   {
		   daysinpastyears+=366;
	   }
	   if(!Date.istSchaltjahr(a))
	   {
		   daysinpastyears+=365;
	   }
   }
   return daysinpastyears+daysinthisyear;
	   
  }
 
  private static int theNumberofLeapyearsince1970(int year)
  {
	  int number=0;
	  for(int i=1970;i<year;i++)
	  {
		  if(Date.istSchaltjahr(i))
		  {
			  number++;
		  }
	  }
	  System.out.println("year: "+year+" number of leap years: "+number);
	  return number;
  }
  private static int deleteExtraDaysOfleapyear(Date date)
  {
	  int dayssince1970=date.daysSince1970();
	  int without29=dayssince1970-Date.theNumberofLeapyearsince1970(date.year);
	  if(Date.istSchaltjahr(date.year))
	  {
		  if(date.month>2)
		  {
			  without29--;
		  }
		  else if(date.month==2)
		  {
			  if(date.day==29)
			  {
				  without29--;
			  }
		  }
	  }
		System.out.println("withou29: "+without29);  
	  return without29;
  }
  /**
   * Returns the full years between the specified date and the date represented by
   * this instance.
   * 
   * @param today the specified date
   * @return the full years
   */
  public int getAgeInYearsAt(Date today) {
    
    return (Date.deleteExtraDaysOfleapyear(today)-Date.deleteExtraDaysOfleapyear(this))/365;
  }

  /**
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
   * Returns the number of the days in the specified month in the specified year.
   * For a <code>month</code> value of either 1, 3, 5, 7, 8, 10 or 12 this method
   * returns 31. For a <code>month</code> value of either 4, 6, 9 or 11 this
   * method returns 30. For a <code>month</code> value of 2 (February) the
   * returned value is either 28 or 29, depending on the specified year.
   * 
   * @param month the month
   * @param year  the year
   * @return the number of the days in the specified month in the specified year.
   */
  private int daysInMonth(int month, int year) {
    switch (month) {
    case 1:
    case 3:
    case 5:
    case 7:
    case 8:
    case 10:
    case 12:
      return 31;
    case 4:
    case 6:
    case 9:
    case 11:
      return 30;
    case 2:
      return daysinFebruary(year);
    }

    return -1;
  }

  /**
   * Returns the number of days in the February of the specified year. This method
   * considers leap years.
   * 
   * @param year the year
   * @return the number of days in the February of the specified year.
   */
  private int daysinFebruary(int year) {
    if (year % 4 != 0) {
      return 28;
    }

    if ((year % 100 == 0) && (year % 400 != 0)) {
      return 28;
    }

    return 29;
  }

  /**
   * Returns a string representation of this date: day/month/year.
   * 
   * @return a string representation of this date: day/month/year
   */
  public String toString() {
    return this.day + "/" + this.month + "/" + this.year;
  }

  /**
   * Sets the day of this date.
   * 
   * If the specified day is < 1, then the day is set to 1. If the specified day
   * is greater than the number of days in the month of this date, then it is set
   * to the maximum value of days in the month of this date.
   * 
   * @see Date#daysInMonth(int, int)
   * @param day the new day
   */
  public void setDay(int day) {
    if (day < 1) {
      this.day = 1;
    } else if (day > daysInMonth(this.month, this.year)) {
      this.day = daysInMonth(this.month, this.year);
    } else {
      this.day = day;
    }
  }

  /**
   * Sets the month of this date.
   * 
   * If the specified month is < 1, the month is set to 1. If the specified month
   * is > 12, the month is set to 12. If the new month has less days than the
   * current month, it may happen that the day of this date gets invalid. In this
   * case, the day of this date is set to the maximum value of the specified
   * month.
   * 
   * @param month the new month
   */
  public void setMonth(int month) {
    if (month < 1) {
      this.month = 1;
    } else if (month > 12) {
      this.month = 12;
    } else {
      this.month = month;
    }

    /*
     * To avoid that the day of this date gets invalid, execute the setDay() method
     * with the current day
     */
    this.setDay(this.day);
  }

  /**
   * Sets the year of this date.
   * 
   * If the specified year is < 1900, then the year is set to 1900. If the
   * specified year is > 2100, then the year is set to 2100. In case the current
   * month of this date is February it may happen that the day of this date gets
   * invalid (a value of 29 in a leap year). In this case the day is set to 28.
   * 
   * @param year the new year
   */
  public void setYear(int year) {
    if (year < 1900) {
      this.year = 1900;
    } else if (year > 2100) {
      this.year = 2100;
    } else {
      this.year = year;
    }

    /*
     * To avoid that the day of this date gets invalid, execute the setDay() method
     * with the current day
     */
    this.setDay(this.day);
  }
  public boolean equals(Date date)
  {
	  if(date==null) return false;
	  else if (this.day==date.day&&this.month==date.month&&this.year==date.year) return true;
	  else return false;	  
  }
  /*public static void main(String[] args)
  {
	  System.out.println(Date.istSchaltjahr(2016));
	  Date a =new Date(25,12,2000);
	  System.out.println(a.getAgeInYearsAt(new Date()));
	  
	  System.out.println(a.daysSince1970());
  }*/
  

}
