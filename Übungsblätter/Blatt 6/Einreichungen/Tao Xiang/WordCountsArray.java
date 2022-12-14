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
   * If the specified word is already administered by this instance, then the
   * count of the specified word is increased by the given count.
   * 
   * If the specified word is not already administered by this instance, this
   * method creates a new {@link WordCount} instance and administers this newly
   * created with count <code>count</code>. If the specified word is
   * <code>null</code> or an empty {@link String}, nothing will happen. If the
   * specified count is lower than <code>0</code>, nothing will happen.
   * 
   * 
   * @param word  the word to be added
   * @param count the count of the word to be added
   */
  public void add(String word, int count) {
    if (word == null || word.equals("")) {
      return;
    }

    if (count < 0) {
      return;
    }

    /* get the index, if the word is already administered */
    int index = getIndexOfWord(word.toLowerCase());

    /* word found? */
    if (index == -1) {
      /*
       * the word has not been found, so create a new WordCount instance and add it
       */

      /*
       * if we have reached the end of the array, increase the array size
       */
      if (actualSize == maxSize) {
        this.doubleSize();
      }

      this.wordCounts[actualSize] = new WordCount(word.toLowerCase(), count);
      this.actualSize++;
    } else {
      /*
       * the word has been found and therefore it is already administered, so add the
       * count
       */
      this.wordCounts[index].incrementCount(count);
    }
  }

  /**
   * Determines, whether the words administered by this instance and the words in
   * the specified {@link WordCountsArray} are equal.
   * 
   * This method returns <code>true</code>, if
   * <ul>
   * <li>the words administered by this instance and the words administered by the
   * specified {@link WordCountsArray} instance are the same <b>and</b></li>
   * <li>the words are in the same order</li>
   * </ul>
   * Otherwise, this method will return <code>false</code>.
   * 
   * @param wca the {@link WordCountsArray} that will be compared
   * @return <code>true</code>, if the administered words equal as described in
   *         detail above; <code>false</code> otherwise.
   */
  private boolean wordsEqual(WordCountsArray wca) {
    /* make it short: the same */
    if (this == wca) {
      return true;
    }

    /* cannot be the same */
    if ((wca == null) || (this.size() != wca.size())) {
      return false;
    }

    /* compare every single word at every position */
    for (int i = 0; i < this.size(); i++) {
      if (!this.getWord(i).equals(wca.getWord(i))) {
        return false;
      }
    }

    return true;
  }

  /**
   * Calculate the scalar product of the word counts of this instance and the word
   * counts of the specified {@link WordCountsArray}.
   * 
   * If the two {@link WordCountsArray} have a different size, <code>0</code> is
   * returned. Also, if the words contained in the two {@link WordCountsArray}s are
   * not exactly the same (cf. {@link WordCountsArray#wordsEqual(WordCountsArray)}),
   * the result is <code>0</code>. If <code>wca</code> is <code>null</code>,
   * <code>0</code> is returned.
   * 
   * @param wca the 2nd {@link WordCountsArray}
   * @return the scalar product of this instance and the specified
   *         {@link WordCountsArray}
   */
  private double scalarProduct(WordCountsArray wca) {
    if (wca == null) {
      return 0;
    }

    /* scalar product is 0 by definition, if size is different */
    if (this.size() != wca.size()) {
      return 0;
    }

    /*
     * also, the scalar product is 0 by definition, if the contained words are not
     * exactly the same. Though, if this == wca we do not have to do the
     * wordsEqual()-check.
     */
    if ((this != wca) && !this.wordsEqual(wca)) {
      return 0;
    }

    double scalarProduct = 0;

    for (int i = 0; i < this.size(); i++) {
      scalarProduct += this.getCount(i) * wca.getCount(i);
    }

    return scalarProduct;
  }

  /**
   * Sorts the <code>WordCount</code> objects administered by this instance.
   * 
   * After calling this method the administered <code>WordCount</code> objects are
   * ordered lexicographically according to the words represented by the
   * <code>WordCount</code> objects.
   */
  public void sort() {
    this.doBucketSort();
  }

  /**
   * Sorts the <code>WordCount</code> objects administered by this instance with
   * the selection-sort algorithm.
   */
  private void doSelectionSort() {
    for(int i = 0; i < actualSize; i++) {
      // Find maximal element
      int maxIndex = i;
      for(int j = i + 1; j < actualSize; j++)
        if(getWord(maxIndex).compareTo(getWord(j)) > 0)
          maxIndex = j;
      // Swap maximal element to the right place
      WordCount tmp = this.wordCounts[i];
      this.wordCounts[i] = this.wordCounts[maxIndex];
      this.wordCounts[maxIndex] = tmp;
    }
  }

  /**
   * Calculate the similarity of this instance and the specified
   * {@link WordCountsArray}.
   * 
   * This method will return a value between <code>0</code> and <code>1</code>. If
   * <code>wca</code> is <code>null</code>, <code>0</code> is returned.
   * 
   * @param wca the 2nd {@link WordCountsArray}
   * @return the similarity between this instance and the specified
   *         {@link WordCountsArray}
   */
  public double computeSimilarity(WordCountsArray wca) {
    if (wca == null) {
      return 0;
    }

    double scalarProductThis = this.scalarProduct(this);
    double scalarProductWca = wca.scalarProduct(wca);

    double scalarProduct = 0;

    if (scalarProductThis != 0 && scalarProductWca != 0) {
      scalarProduct = this.scalarProduct(wca) / (Math.sqrt(scalarProductThis * scalarProductWca));
    }

    return scalarProduct;
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
  public String getWord(int index) {
    if (index < 0 || index >= this.actualSize) {
      return null;
    }

    return this.wordCounts[index].getWord();
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
   * Returns the index of the internal {@link WordCount}-Array where the specified
   * word is administered.
   * 
   * @param word the word for which we want to know the index
   * @return the index of the specified word in the internal array, or
   *         <code>-1</code> if this word is not administered
   */
  public int getIndexOfWord(String word) {
    /* make it short */
    if (word == null || word.equals("")) {
      return -1;
    }

    /* search for the word in the array of WordCounts */
    for (int i = 0; i < this.actualSize; i++) {
      if (this.wordCounts[i].getWord().equals(word)) {
        return i;
      }
    }

    return -1;
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

  /**
   * Returns true, if this instance and the specified {@link WordCountArray}
   * equal.
   * 
   * @param wca the other WordCountArray
   * @return true, if this instance and the specified {@link WordCountArray} equal
   */
  public boolean equals(WordCountsArray wca) {
    /* make it short: the same */
    if (this == wca) {
      return true;
    }

    /* cannot be the same */
    if ((wca == null) || (this.size() != wca.size())) {
      return false;
    }

    /* compare every single word and their counts at every position */
    for (int i = 0; i < this.size(); i++) {
      if (!this.getWord(i).equals(wca.getWord(i)) || this.getCount(i) != wca.getCount(i)) {
        return false;
      }
    }

    return true;
  }
  private void doBucketSort()
  {

	  //first determine the max. length
	  int maxlength=0;
	  for(int i=0;i<this.actualSize;i++)
	  {
		  if(maxlength<this.wordCounts[i].getWord().length())
		  {
			  maxlength=this.wordCounts[i].getWord().length();
		  }
	  }
	  for(int i=0;i<this.actualSize;i++)
	  {
		  if(maxlength>this.wordCounts[i].getWord().length()) {int sub=maxlength-this.wordCounts[i].getWord().length();
		  String neu=this.wordCounts[i].getWord();
		  for(int j=0;j<sub;j++)
		  {
			  neu+="@";
		  }
		  WordCount tmp=new WordCount(neu,this.wordCounts[i].getCount());
		  this.wordCounts[i]=tmp;
	  }
		  }
	  
	  
	  
	  //now is the length of each word the same long;
	  /*
	   * The Start of Iteration of BucketSort
	   * 
	   * 
	   */
	  for(int k=maxlength-1;k>=0;k--) {     //starting from the rightest char of each word.
	  
		    String bucket[][]=new String[27][this.actualSize];
	 
		    for(int i=0;i<this.actualSize;i++)
	  { 
		  String tmp = null;
		  if(k==maxlength-1)
		  {
			  tmp=this.getWord(i).substring(k);
		  }
		  if(k!=maxlength-1)
		  {  
			  tmp=this.getWord(i).substring(k, k+1);
		  }
		  switch(tmp)
		  {
		  case"@":bucket[0][i]=this.getWord(i);break;
		  case"a":bucket[1][i]=this.getWord(i);break;
		  case"b":bucket[2][i]=this.getWord(i);break;
		  case"c":bucket[3][i]=this.getWord(i);break;
		  case"d":bucket[4][i]=this.getWord(i);break;
		  case"e":bucket[5][i]=this.getWord(i);break;
		  case"f":bucket[6][i]=this.getWord(i);break;
		  case"g":bucket[7][i]=this.getWord(i);break;
		  case"h":bucket[8][i]=this.getWord(i);break;
		  case"i":bucket[9][i]=this.getWord(i);break;
		  case"j":bucket[10][i]=this.getWord(i);break;
		  case"k":bucket[11][i]=this.getWord(i);break;
		  case"l":bucket[12][i]=this.getWord(i);break;
		  case"m":bucket[13][i]=this.getWord(i);break;
		  case"n":bucket[14][i]=this.getWord(i);break;
		  case"o":bucket[15][i]=this.getWord(i);break;
		  case"p":bucket[16][i]=this.getWord(i);break;
		  case"q":bucket[17][i]=this.getWord(i);break;
		  case"r":bucket[18][i]=this.getWord(i);break;
		  case"s":bucket[19][i]=this.getWord(i);break;
		  case"t":bucket[20][i]=this.getWord(i);break;
		  case"u":bucket[21][i]=this.getWord(i);break;
		  case"v":bucket[22][i]=this.getWord(i);break;
		  case"w":bucket[23][i]=this.getWord(i);break;
		  case"x":bucket[24][i]=this.getWord(i);break;
		  case"y":bucket[25][i]=this.getWord(i);break;
		  case"z":bucket[26][i]=this.getWord(i);break;
		  }
	  }
	  for(int i=0;i<27;i++)
	  {
		for(int j=0;j<bucket[0].length;j++)
		{
			if(bucket[i][j]==null)
			{
				bucket[i][j]="";
			}
		}
	  }
	  WordCountsArray neu= new WordCountsArray(this.maxSize);
	  for(int i=0;i<27;i++)
	  {
		  for(int j=0;j<bucket[0].length;j++)
		  {
			  if(bucket[i][j]!="")
			  {
				  neu.add(bucket[i][j], this.getCount(this.getIndexOfWord(bucket[i][j])));
			  }
		  }
	  }
	  
		  this.wordCounts=neu.wordCounts; 
  }
	  /*
	   * 
	   * 
	   * 
	   * The end of iteration.
	   */
	  
	  
	  
	  
	  
	  
	  //now the WCArray is sorted,but still need to delete the "@".
	  
	  for(int i=0;i<this.actualSize;i++)
	  {
		  int index=this.getWord(i).indexOf("@");
		  if(index!=-1)
		  {
			  String tmp=this.getWord(i).substring(0, index);
			  WordCount neu =new WordCount(tmp,this.getCount(this.getIndexOfWord(this.getWord(i))));
			  this.wordCounts[i]=neu;
			  
		  }
	  }
	  }
  /*public static void main(String[] args) {
	 
	 
	 WordCountsArray a=new WordCountsArray(5);
	  a.add("china", 3);
	  a.add("germany", 44);
	  a.add("canada", 54);
	
	  a.add("england", 33);
	  a.add("greece", 2);
	  System.out.println("a.atcual size:"+a.actualSize+"  a.max.size: "+a.maxSize);
	  a.sort();
	  for(int i=0;i<a.actualSize;i++)
	  {
		  System.out.println(a.getWord(i)+a.getCount(i));
	  }
	  System.out.println("a.atcual size:"+a.actualSize+"  a.max.size: "+a.maxSize);

  
	  Document a= new Document("vor zeiten war ein schneider der drei soehne hatte und nur eine einzige ziege");
	  for(int i=0;i<a.getWordCounts().actualSize;i++)
	  {
		  System.out.println(a.getWordCounts().getWord(i)+a.getWordCounts().getCount(i));
	  }

	  System.out.print("\n\n");
	  a.getWordCounts().sort();
	  for(int i=0;i<a.getWordCounts().actualSize;i++)
	  {
		  System.out.println(a.getWordCounts().getWord(i)+a.getWordCounts().getCount(i));
	  }*/
	  
  
  
  
  
  
  }

