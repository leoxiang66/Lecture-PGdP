
/**
 * This class represents a set words and its counts.
 * 
 * This class ensures, that no empty words are added and that the word count is
 * always greater than or equal to <code>0</code>.
 *
 */
public class WordCountsArray {
  /**
   * the administered WordCount-objects
   */
  private WordCount[] wordCounts;

  /**
   * the actual number of administered WordCount-objects
   */
  private int actualSize;

  /**
   * the maximum number of administrable WordCount-objects; not final because of
   * Uebung 3 g)
   */
  private int maxSize;

  /**
   * Creates a new instance of this class.
   * 
   * The created instance is able to administer at most <code>maxSize</code>
   * words.
   * 
   * @param maxSize the maximum number of words that can be administered by this
   *                instance
   */
  public WordCountsArray(int maxSize) {
    if (maxSize < 0) {
      this.maxSize = 0;
    } else {
      this.maxSize = maxSize;
    }

    this.actualSize = 0;
    this.wordCounts = new WordCount[this.maxSize];
  }

  /**
   * Adds the specified word with the specified count to this instance.
   * 
   * This method creates a new {@link WordCount} instance and administers this
   * newly created instance. If the specified word is <code>null</code>, nothing
   * will be added. If the specified count is lower than <code>0</code>, the count
   * will be set to <code>0</code>, according to
   * {@link WordCount#WordCount(String, int)}.
   * 
   * @param word  the word to be added
   * @param count the count of the word to be added
   */
  //hausaufgabe : add
  public void add(String word, int count) {
    if (word == null || word.equals("")||count<0) {
      return;
    }
    String kleinWort=word.toLowerCase();

    /*
     * if we have reached the end of the array, increase the array size
     */
    if (actualSize == maxSize) {
      this.doubleSize();
    }

    boolean contained=false;
    int theindex = 0;
    for(int i=0;i<this.actualSize;i++)
    {
    	if(this.wordCounts[i].getWord().equals(kleinWort))
    	{
    		contained=true;
    		theindex=i;
    		break;
    	}
    }
    if(!contained) {
    this.wordCounts[actualSize] = new WordCount(word, count);
    this.actualSize++;
    }
    if(contained)
    {// need the index
     // the count of the wc at this index ++
    	this.wordCounts[theindex].incrementCount(count);
    }
  }

  /**
   * Returns the number of words currently administered by this instance.
   * 
   * @return the number of words currently administered by this instance
   */
  public int size() {
    return this.actualSize;
  }

  /**
   * Returns the word at the position <code>index</code> of the
   * {@link WordCount}-Array.
   * 
   * @param index the index
   * @return the word at the specified <code>index</code> or <code>null</code>, if
   *         the specified <code>index</code> is illegal.
   */
  // ha getword
  public String getWord(int index) {
    if(index>=0&&index<this.maxSize) {
	  if (this.wordCounts[index] != null)
      return this.wordCounts[index].getWord();
    return "";
    }
    else return null;
  }
  //hausaufgabe getIndexofWord
  public int getIndexOfWord(String word)
  {
	  int index = -1;
	  for(int i=0;i<this.actualSize;i++)
	  {
		  if(this.wordCounts[i].getWord().equals(word))
		  {
			  index=i;
			  break;
		  }
	  }
	  return index;
  }
  //ha wordsEqual
  private boolean wordsEqual(WordCountsArray wca)
  {
	  boolean wordsequal=true;
	  if(this.actualSize!=wca.actualSize)
	  {
		  wordsequal=false;
	  }
	  else
	  {
		  for(int i=0;i<this.actualSize;i++)
		  {
			if(!this.getWord(i).equals(wca.getWord(i)))
			{
				wordsequal=false;
				break;
			}
		  }
	  }
	  return wordsequal;
  }
  //ha scalarProduct
  private double scalarProduct(WordCountsArray wca)
  {
	  if(!this.wordsEqual(wca))
	  {
		  return 0;
	  }
	  else
	  {
		  int summe=0;
		  for(int i=0;i<this.actualSize;i++)
		  {
			  summe+=this.getCount(i)*wca.getCount(i);
		  }
		  return summe;
	  }
  }
  //ha sort
  private  WordCount findthesmallestElement(int startindex)
  {
	  WordCount min = this.wordCounts[startindex];
	  for(int i=startindex,j=i+1;j<this.actualSize;)
	  {
		  if(this.getWord(i).compareTo(this.getWord(j))>0)
		  {
			  min = this.wordCounts[j];
			  i=j;
			  j++;
		  }
		  if(this.getWord(i).compareTo(this.getWord(j))<0) j++;
	  }
	  return min;
  }
  public void sort()
  {
	  for(int i=0;i<this.actualSize-1;i++) {
	  int indexofthesmallestElement =this.getIndexOfWord(this.findthesmallestElement(i).getWord());
	  int b=indexofthesmallestElement;
	  WordCount temp=this.wordCounts[b];
	  this.wordCounts[b]=this.wordCounts[i];
	  this.wordCounts[i]=temp;
	  }
  }
  
  // ha computeSimilarity
  public double computeSimilarity(WordCountsArray wca)
  {
	  double zähler=this.scalarProduct(wca);
	  double nenner=Math.sqrt(this.scalarProduct(this)*wca.scalarProduct(wca));
	  return zähler/nenner;
  }

  /**
   * Returns the count of the word at position <code>index</code> of the
   * {@link WordCount}-Array.
   * 
   * @param index the index
   * @return the count of the word at the specified <code>index</code> or
   *         <code>-1</code>, if the specified <code>index</code> is illegal
   */
  public int getCount(int index) {
    if (index < 0 || index >= this.actualSize) {
      return -1;
    }

    return this.wordCounts[index].getCount();
  }

  /**
   * Sets the count of the word at position <code>index</code> of the
   * {@link WordCount}-Array to the specified <code>count</code>.
   * 
   * If the specified <code>index</code> is illegal, nothing will happen. If the
   * specified <code>count</code> is lower than <code>0</code>, the count is set
   * to <code>0</code>.
   * 
   * @param index the index of the word whose frequency will be changed
   * @param count the new frequency of the word at position <code>index</code>
   */
  public void setCount(int index, int count) {
    if (index < 0 || index >= this.actualSize) {
      return;
    }

    if (count < 0) {
      this.wordCounts[index].setCount(0);
    } else {
      this.wordCounts[index].setCount(count);
    }
  }

  /**
   * Doubles the number of administerable WordCount-objects,
   */
  private void doubleSize() {
    this.maxSize = this.maxSize * 2;

    /* would be stupid, if former size was 0, so take action... */
    if (this.maxSize <= 0) {
      this.maxSize = 1;
    }

    WordCount[] newWordCounts = new WordCount[this.maxSize];

    /* copy old array */
    for (int i = 0; i < this.wordCounts.length; i++) {
      newWordCounts[i] = this.wordCounts[i];
    }

    this.wordCounts = newWordCounts;
  }
  public boolean equals(WordCountsArray wca)
  {
	  boolean equals=true;
	  if(wca==null)
	  {
		  equals=false;
	  }
	  else if (this.actualSize!=wca.actualSize)
	  {
		  equals=false;
	  }
	  else
	  {
		for(int i=0;i<this.actualSize;i++)
		{
			if(!this.wordCounts[i].equals(wca.wordCounts[i]))
			{
				equals=false;
			    break;
			}
		}
	  }
	  return equals;
  }
}
