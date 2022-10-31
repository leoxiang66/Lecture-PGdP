/**
 * The class {@code Document} represents a document.
 * 
 * @see Date
 * @see Author
 *
 */
public class Document {
  /**
   * the title of the document
   */
  private String title;

  /**
   * the language of the document
   */
  private String language;

  /**
   * summary of the document
   */
  private String summary;

  /**
   * content of the document
   */
  private String content;

  /**
   * the release date of the document
   * 
   * @see Date
   */
  private Date releaseDate;

  /**
   * the {@link Author} of the document
   * 
   * @see Author
   */
  private Author author;

  /**
   * Constructs a document with the given values.
   * 
   * @param title       the document's title
   * @param language    the language the document is written in
   * @param summary     short summary of the document
   * @param releaseDate the release date of the document
   * @param author      the author of the document
   */
  public Document(String title, String language, String summary, Date releasedate, Author author, String content) {
	  if(this.author.getBirthday().getYear()<releasedate.getYear())      //the document must be released after the author was borned.
	  {
		  this.releaseDate=releasedate;
	  }
	  else if (this.author.getBirthday().getYear()==releasedate.getYear())
	  {
		  if(this.author.getBirthday().getMonth()<releasedate.getMonth())
		  {
			  this.releaseDate=releasedate;
		  }
		  
		  else if(this.author.getBirthday().getMonth()==releasedate.getMonth())
		  {
			  if(this.author.getBirthday().getDay()<releasedate.getDay())
			  {
				  this.releaseDate=releasedate;
			  }
			  else System.out.println("sinnlose Eingaben von releasedate");
		  }
	  }
	this.title = title;
    this.language = language;
    this.summary = summary;
    this.author = author;
    this.content = content;
  }

  /**
   * Returns the title of the document.
   * 
   * @return the title of the document
   */
  public String getTitle() {
    return title;
  }

  /**
   * Returns the language the document is written in.
   * 
   * @return the language the document is written in
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Returns the text content of the document.
   * 
   * @return the text content of the document
   */
  public String getContent() {
    return content;
  }

  /**
   * Returns a short summary of the document.
   * 
   * @return a short summary of the document
   */
  public String getSummary() {
    return summary;
  }

  /**
   * Returns the release date of the document.
   * 
   * @return the release date of the document
   */
  public Date getReleaseDate() {
    return releaseDate;
  }

  /**
   * Returns the author of the document.
   * 
   * @return the author of the document
   * @see Author
   */
  public Author getAuthor() {
    return author;
  }

  /**
   * Returns a brief string representation of this document.
   */
  public String toString() {
    return this.title + " by " + this.author.toString();
  }

  /**
   * Returns the age of this document at the specified date in days.
   * 
   * @param today the specified date
   * @return the age of this document at the specified date:
   */
  public int getAgeAt(Date today) {
    return this.releaseDate.getAgeInDaysAt(today);
  }
  //Aufgabe 3.6
  public void setTitle(String titel)
  {
	  title=titel;
  }
  public void setLanguage(String sprache)
  {
	  language=sprache;
  }
  public void setSummary(String summary)
  {
	  this.summary=summary;
  }
  public void setContent(String inhalt)
  {
	  content=inhalt;
  }
  public void setReleasedate(Date releasedate)
  {
	  if(this.author.getBirthday().getYear()<releasedate.getYear())
	  {
		  this.releaseDate=releasedate;
	  }
	  else if (this.author.getBirthday().getYear()==releasedate.getYear())
	  {
		  if(this.author.getBirthday().getMonth()<releasedate.getMonth())
		  {
			  this.releaseDate=releasedate;
		  }
		  
		  else if(this.author.getBirthday().getMonth()==releasedate.getMonth())
		  {
			  if(this.author.getBirthday().getDay()<releasedate.getDay())
			  {
				  this.releaseDate=releasedate;
			  }
			  else System.out.println("sinnlose Eingaben von releasedate");
		  }
	  }
  }
  public void setAuthor(Author autor)
  {
	  author=autor;
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
