
/**
 * The class {@code Author} represents an author of a {@link Document} or a
 * {@link Review}.
 * 
 * @see Document
 * @see Review
 * @see Date
 * 
 *
 */
public class Author {
  /**
   * the first name of the author
   */
  private String firstName;

  /**
   * the last name of the author
   */
  private String lastName;

  /**
   * the birthday of the author
   * 
   * @see Date
   */
  private Date birthday;

  /**
   * the residence of the author
   */
  private String residence;

  /**
   * the email address of the author
   */
  private String email;

  /**
   * Constructs an author with the given values.
   * 
   * @param firstName the author's first name
   * @param lastName  the author's last name
   * @param birthday  the author's birthday
   * @param residence the author's residence
   * @param email     the author's email address
   */
  public Author(String firstName, String lastName, Date birthday, String residence, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthday = birthday;
    this.residence = residence;
    if(email.contains("@"))                                         //Eine email muss "@" beinhalten;
	     this.email=email;
	  else 
		  System.out.println("sinnlose Eingaben von email");
  }
  public Author ()
  {
	  
  }

  /**
   * Returns the first name of the author.
   * 
   * @return the first name of the author
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Returns the last name of the author.
   * 
   * @return the last name of the author
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Returns the birthday of the author.
   * 
   * @return the birthday of the author
   * @see Date
   */
  public Date getBirthday() {
    return birthday;
  }

  /**
   * Returns the residence of the author.
   * 
   * @return the residence of the author
   */
  public String getResidence() {
    return residence;
  }

  /**
   * Returns the email address of the author.
   * 
   * @return the email address of the author
   */
  public String getEmail() {
    return email;
  }

  /**
   * Returns a string representation of this author.
   * 
   * @return a string representation of this author
   */
  public String toString() {
    return this.firstName + " " + this.lastName;
  }

  /**
   * Returns the contact information of the author.
   * 
   * The information has three lines as follows:<br/>
   * <ol>
   * <li>name of the author</li>
   * <li>email address of the author</li>
   * <li>residence of the author</li>
   * </ol>
   * 
   * @return the contact information of the author
   */
  public String getContactInformation() {
    return this.firstName + " " + this.lastName + Terminal.NEWLINE + "<" + this.email + ">" + Terminal.NEWLINE
        + this.residence;

//		return "<" + this.email + ">"+ Terminal.NEWLINE
//				+ this.firstName + " " + this.lastName  + Terminal.NEWLINE
//				+ this.residence;

  }

  /**
   * Returns the age of this author at the specified date in years.
   * 
   * @param today the specified date
   * @return the age of this author at the specified date
   * @see Date
   */
  public int getAgeAt(Date today) {
    return this.birthday.getAgeInYearsAt(today);
  }
  // Aufgabe 3.6;
  public void setFirstname(String firstname)
  {
	  firstName=firstname;
  }
  public void setLastname(String lastname)
  {
	  lastName=lastname;
  }
  public void setBirthday(Date birthday)
  {
	  this.birthday=birthday;
  }
  public void setResidence(String residence)
  {
	  this.residence=residence;
  }
  public void setEmail(String email)
  {
	  if(email.contains("@"))//Eine email muss @ beinhalten .
	     this.email=email;
	  else 
		  System.out.println("sinnlose Eingaben von email");
	  
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
