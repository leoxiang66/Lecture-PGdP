
public class Test_ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordCountsArray test1 = new WordCountsArray(1);  // public WordCountArray(int initSize)
		
		test1.add("s", 5);                 // public void add(String word,int count)
		if(test1.size()==1&&test1.array[0].getWord()=="s"&&test1.array[0].getCount()==5)
			System.out.println("test1.1 passed,wordcount(s,5) is correctly added.");
		else System.out.println("test1.1 failed");
		
		test1.add("sda", 6);                     // public void add(String word, int count)
		
		System.out.println("1 "+test1.size());   // public int size()
		if(test1.size()==2&&test1.array[1].getWord()=="sda"&&test1.array[1].getCount()==6)
			System.out.println("test1.2 passed,wordcount(sda,6) is correctly added");
		else System.out.println("test1.2 failed");
		
		System.out.println("2 "+test1.getWord(1));  // public String getWord(int index)
		
		test1.setCount(0, 4);                    // public void setCount(int index,int count)
		if(test1.array[0].getCount()==4) System.out.println("Test1.3 passed, count is correctly set");
		else System.out.println("Test1.3 failed");
		
		System.out.println("3 "+test1.array[0].getCount());  // public int getCOunt(int index)
		 
	
		String test1_4=Document.cutSuffix("zeitung", "ung");
		if(test1_4.equals("zeit")) System.out.println("Test1.4 passed,suffix is correctly cut");
		else System.out.println("Test1.4 failed,the result should be: "+test1_4);
		
		
		 
		  
		 
		  Document test2 = new Document("kicker","deutsch","fußballzeitung",new Date(10,11,2018),new Author("marco","reus",new Date(31,5,1989),"dortmund","ge25pof@mytum.de"),"Der Signal Iduna Park stand förmlich kopf",new WordCountsArray(5));
		  if(test2.getReleaseDate().getDay()<0||test2.getReleaseDate().getDay()>31||test2.getReleaseDate().getMonth()<0||test2.getReleaseDate().getMonth()>12||test2.getReleaseDate().getYear()<0)
		  {
			  System.out.println("sinnlose Eingabe von releaseDate");
		  }
		  if(test2.getAuthor().getBirthday().getDay()<0||test2.getAuthor().getBirthday().getDay()>31||test2.getAuthor().getBirthday().getMonth()<0||test2.getAuthor().getBirthday().getMonth()>12||test2.getAuthor().getBirthday().getYear()<0)
		  {
			  System.out.println("sinnlose Eingabe von Geburtstag des Autors");
		  }
		  if(test2.getWordCounts().array[0].getWord()==""&&test2.getWordCounts().array[0].getCount()==1&&test2.getWordCounts().array[1]==null)
		  {

			  System.out.println("kein Text");
		  }
		  
		  
		  
		  WordCountsArray k=test2.getWordCounts();
		  
		  for(int i=0;i<k.size();i++)
		  {
			  System.out.println("wordcount["+ i + "]:      "     +k.array[i].getWord()+" " +k.array[i].getCount());
		  }
		  if(k.array[0].getWord().equals("D")&&k.array[0].getCount()==1&&k.array[1].getWord().equals("Sign")&&k.array[1].getCount()==1&&k.array[2].getWord().equals("Iduna")&&k.array[2].getCount()==1&&k.array[3].getWord().equals("Park")&&k.array[3].getCount()==1&&k.array[4].getWord().equals("stand")&&k.array[4].getCount()==1&&k.array[5].getWord().equals("förm")&&k.array[5].getCount()==1&&k.array[6].getWord().equals("kopf")&&k.array[6].getCount()==1)
			  System.out.println("Test2 passed,constructor is correctly set");
		  else System.out.println("Test2 failed");
	}

}
