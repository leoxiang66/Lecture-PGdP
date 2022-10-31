package AufgabeH;

public class Review {

	private String language,content;
	private Author author;
	private Document reviewedDocument;
	private Date releaseDate;
	private int rating;// eine Rezension bewertet das Dokument auf einer Skala von 0 bis 10

	//setter-Methoden
	public void setLanguage(String language)
	{ 
		this.language=language;
	}
	public void setAuthor(Author author)
	{
		this.author=author;
		
	}
	public void setReviewedDocument(Document reviewedDocument)
	{
		this.reviewedDocument=reviewedDocument;
	}
	public void setReleasedate(Date releaseDate)
	{
		this.releaseDate=releaseDate;
	}
	public void setRating(int rating)
	{
		this.rating=rating;
	}
	public void setContent(String content)
	{
		this.content=content;
	}
	//Konstruktor
	public Review(Author author,Document reviewedDocument,String language,Date releaseDate,int rating,String content)
	{
		this.author=author;
		this.reviewedDocument=reviewedDocument;
		this.language=language;
		this.releaseDate=releaseDate;
		this.rating=rating;
		this.content=content;
	}
	//toString-Methoden
	public String toString()
	{
		return "Die bezügliche Dokument:"+this.reviewedDocument+".Der Autor von der Rezension:"+this.author+".Text:"+this.content+".Die bewertung:"+this.rating+".Die veröffentlichungsdatum:"+this.releaseDate+"."; 
	}
	//Datumsfunktion
	public int getAgeAt(Date today)
	{
		return this.releaseDate.getAgeInDaysAt(today);// get the age of the review(camparing the release date and today)
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
