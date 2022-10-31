package AufgabeH;

public class Author { 

	private String firstName,lastName,residence,email;
	private Date birthday;
	//setter-Methoden
	public void setFirstname(String firstName)
	{
		this.firstName=firstName;
	}
	public void setLastname(String lastName)
	{
		this.lastName=lastName;
	}
	public void setResidence(String residence)
	{
		this.residence=residence;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public void setBirthday(Date birthday)
	{
		this.birthday=birthday;
	}
	//Konstruktor
	public Author(String firstName,String lastName,Date birthday,String residence,String email)
	{
		this.firstName=firstName;
		this.lastName=lastName;
		this.birthday=birthday;
		this.residence=residence;
		this.email=email;
	}
	
	//toString-Methoden
	public String toString()
	{
		return"Der Autor("+this.firstName+" "+this.lastName+")wurde am "+this.birthday+" geboren; Seine Emal ist "+this.email+".";
	}
	//getContactInformation-Methode
	public String getContactInformation()
	{
		return "Der Name des Autors: "+this.firstName+" "+this.lastName+Terminal.NEWLINE+"E-mail: "+this.email+Terminal.NEWLINE+"Der Wohnort des Autors: "+this.residence;
	}
	//Datumsfunktion
	public int getAgeAt(Date today)
	{
		return this.birthday.getAgeInYearsAt(today);
	}
	
	//ein Teil vom Test...
	 Author()
	  {
	  
	  }
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
