
public class WordCountsArray {

	public WordCount[] array;
	public WordCountsArray(int initSize)
	{
		this.array = new WordCount[initSize];
	}
	public void add(String word,int count)
	{
		if(array[array.length-1]==null)
		{for(int i=0;true;i++)
		   {
			   if(array[i]==null)
			  {
				array[i]= new WordCount(word,count);
				break;
			  }
			
		   }
		
		}
			else
			{
				WordCount[] oldArray=array;
				array = new WordCount[2*array.length];
				for(int j =0;j<oldArray.length;j++)
				{
					array[j]=oldArray[j];
				}
				array[oldArray.length]= new WordCount(word,count);
				
			}
		
	}
	public int size()
	{
		int anzahl = 0;
		for(int i=0;i<array.length;i++)
		{
			if(this.array[i]!=null)
			{
				anzahl++;
			}
		}
		return anzahl;
	}
	public String getWord(int index)
	{
		if(index<=array.length-1)
		return this.array[index].getWord();
		else
		{
			System.out.println("an dieser Stelle gibt's momentan keine WordCount");
			return null ;
		}
	}
	public void setCount(int index,int count)
	{
		if(count<0) System.out.println("sinnlose Eingabe von COUNT,die muss positiv	 sein");
		else
		{
			this.array[index].setCount(count);
		}
	}
}
