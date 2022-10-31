package AufgabeH;

public class Document {

	private String title,language,summary,content;
	private Date releaseDate;
	private Author author;
	//setter-Methoden
	public void setTitle(String titel)
	{
		this.title=titel;
	}
	public void setLanguage(String language)
	{
		this.language=language;
	}
	public void setReleasedate(Date releaseDate)
	{
		this.releaseDate=releaseDate;
	}
	public void setAthor(Author author)
	{
		this.author=author;
	}
	public void setSummary(String summary)
	{
		this.summary=summary;
	}
	public void setContent(String content)
	{
		this.content=content;
	}
	//Konstruktor
	
	public Document(String title,String language,String summary,Date releaseDate,Author author,String content)
	{
		this.title=title;
		this.language=language;
		this.summary=summary;
		this.releaseDate=releaseDate;
		this.author=author;
		this.content=content;
	}
	//toString-Methoden
	public String toString()
	{
		return"Der Titel: "+this.title+",die Sprache: "+this.language+",die Zusammenfassung: "+this.summary+",der Autor: "+this.author;
	}
	//Datumsfunktion
	public int getAgeAt(Date today)
	{
		return this.releaseDate.getAgeInDaysAt(today);  //get the age of the document (comparing release date and today)
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
