/**
 * The class {@code Document} represents a document.
 * 
 * This class ensures that neither the title nor the language nor the
 * summary of the document is <code>null</code>.
 * 
 * @see Date
 * @see Author *
 */
public class Document {
	Document()
	{
		
	}
	
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
  public Document(String title, String language, String summary, Date releaseDate, Author author, String content,WordCountsArray array) {
    this.setTitle(title);
    this.setLanguage(language);
    this.setSummary(summary);
    this.setReleaseDate(releaseDate);
    this.setAuthor(author);
    this.wordcountsArray=array;
    this.addContent(content);
    
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
   * Returns the age of this document at the specified date in days.
   * 
   * @param today the specified date
   * @return the age of this document at the specified date:
   */
  public int getAgeAt(Date today) {
    return this.releaseDate.getAgeInDaysAt(today);
  }
  
  /**
   * Returns a brief string representation of this document.
   * 
   * @return a brief string representation of this document
   */
  public String toString() {
    return this.title + " by " + this.author.toString();
  }

  /**
   * Sets the title of the document.
   * 
   * If the new title is <code>null</code>, then the title is set to an empty
   * {@link String}.
   * 
   * @param title the new title
   */
  public void setTitle(String title) {
    if (title == null) {
      this.title = "";
    } else {
      this.title = title;
    }
  }

  /**
   * Sets the language of the document.
   * 
   * If the new language is <code>null</code>, then the language is set to an
   * empty {@link String}.
   * 
   * @param language the new language
   */
  public void setLanguage(String language) {
    if (language == null) {
      this.language = "";
    } else {
      this.language = language;
    }
  }

  /**
   * Sets the summary of the document.
   * 
   * If the new summary is <code>null</code>, then the summary is set to
   * an empty {@link String}.
   * 
   * @param summary the new summary
   */
  public void setSummary(String summary) {
    if (summary == null) {
      this.summary = "";
    } else {
      this.summary = summary;
    }
  }

  /**
   * Sets the content of the document.
   * 
   * If the new content is <code>null</code>, then the content is set to
   * an empty {@link String}.
   * 
   * @param content the new content
   */
 

  /**
   * Sets the release date of the document.
   * 
   * @param releaseDate the release date
   */
  public void setReleaseDate(Date releaseDate) {
    this.releaseDate = releaseDate;
  }

  /**
   * Sets the author of the document.
   * 
   * @param author the new author
   */
  public void setAuthor(Author author) {
    this.author = author;
  }
  public static final String[] SUFFICES=
	  {
		"ab","al","ant","artig","bar","chen","ei","eln","en","end","er","fach","fikation","fizieren","fähig","gemäß",
		"gerecht","haft","haltig","heit","ie","ieren","ig","in","ion","iren","isch","isieren","iserung","ismus","ist",
		"ität","iv","keit","kunde","legen","lein","lich","ling","logie","los","mal","meter","mut","nis","or","sam","schaft",
		"tum","ung","voll","wert","würdig"
	  };
  private  WordCountsArray wordcountsArray;
  public WordCountsArray getWordCounts()
  {
	  return this.wordcountsArray;
  }
  private static String[] tokenize(String content)
  {
	  int spacenumber = 0;
	  for(int i=0;i<content.length();i++)
	  {
		  if(content.charAt(i)==' ')
			  spacenumber ++;
	  }
	  int wordsnumber = spacenumber +1;
	  String[] a = new String[wordsnumber];
	  for(int i =0;i<a.length;i++)
	  {
		  a[i]="";
	  }
	  
	  int pointer1=-2,pointer2=0,index=-1;
	  for(int i =0;i<content.length();i++)
	  {
		  if(content.charAt(i)==' '||i==content.length()-1)
		  {
			  pointer2=pointer1+2;
			  if(i!=content.length()-1)
			      {
				  pointer1=i-1;
				  index++;
				  
				  for(int j =pointer2;j<=pointer1;j++)
				  {
					 
					  a[index]+=content.charAt(j);
				  }
				  

			      }
			  else 
			  { 
				  index++;
				  pointer1=i;
			      
			  for(int j =pointer2;j<=pointer1;j++)
			  {
				  a[index]+=content.charAt(j);
			  }
		
			  }
		  }
	  }
	  return a;
	  
  }
  private static boolean sufficesEqual(String w1,String w2,int n)
  {
	  boolean equal=true;
	  if(n>w1.length()||n>w2.length())
	  {
		  equal=false;
		  
	  }
	  else
	  {
		  for(int i=w1.length()-1,j=w2.length()-1,t=1;t<=n;i--,j--,t++)
		  {
			  if(w1.charAt(i)!=w2.charAt(j))
			  {
				  equal=false;
				  break;
			  }
		  }
	  }
	  return equal;
  }
  private static String findSuffix(String word)
  {
	  String suffix="";
	  for(int i=0;i<SUFFICES.length;i++)
	  {
		  if(Document.sufficesEqual(word,SUFFICES[i],SUFFICES[i].length()))
		  {
			  suffix=SUFFICES[i];
			  break;
		  }
	  }
	  return suffix;
  }
  public static String cutSuffix(String word,String suffix)
  {
	  if(Document.findSuffix(word)!=suffix) return word;
	  else
	  {
		  String a = "";
		  for(int i=0;i<word.length()-suffix.length();i++)
		  {
			  a+=word.charAt(i);
		  }
		  return a;
	  }
  }
  private  void addContent(String content)
	{
	
	  String[] a =Document.tokenize(content);
	  String[] a_without_suffix= new String[a.length];
      for(int i=0;i<a.length;i++)
      {
    	  a_without_suffix[i]=Document.cutSuffix(a[i], Document.findSuffix(a[i]));
      } 
      int index2=0;
      
      for(int i=0;i<a.length;i++)
      {
    	  int sameFlag = 0;
    	  for(int j=0;j<i;j++)
    	  {
    		  
    		  
    		  if(a_without_suffix[j].equals(a_without_suffix[i]))
    		  {
    			  sameFlag=1;
    			  for(int l=0;l<this.wordcountsArray.size();l++)
    			  {
    				  if(this.wordcountsArray.array[l].getWord().equals(a_without_suffix[i]))
    				  {
    					  index2=l;
    					  break;
    				  }
    			  }
    			  
    		  }
    	  }
    	  if(sameFlag==0)
    	  {
    		  this.wordcountsArray.add(a_without_suffix[i],1);
    		 
    	  }
    	  if(sameFlag==1)
    	  {
    		  
    		  this.wordcountsArray.array[index2].incrementCount();
    	  }
      }
	}  
  }  