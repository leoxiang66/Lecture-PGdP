
public class LinkedDocumentCollection extends DocumentCollection{
	
	
	public void prependDocument(Document doc)
	{
		if(doc instanceof LinkedDocument&&this.indexOf(doc)==-1)
		{
			super.prependDocument(doc);
		}
	}
	public void appendDocument(Document doc)
	{
		if(doc instanceof LinkedDocument&&this.indexOf(doc)==-1)
		{
			super.appendDocument(doc);
		}
	}
	public void calculateIncomingLinks()
	{
		for(int i=0;i<this.numDocuments();i++)
		{
			LinkedDocumentCollection tmp=((LinkedDocument)this.get(i)).getOutgoingLinks();
			for(int j=0;j<tmp.numDocuments();j++)
			{
				for(int k=0;k<this.numDocuments();k++)
				{
					if(tmp.get(j).equals(this.get(k)))
					{
						((LinkedDocument)this.get(k)).addIncomingLink((LinkedDocument) this.get(i));
					}
				}
			}
		}
	}
	private void crawl(LinkedDocumentCollection resultCollection)
	{
		for(int i=0;i<resultCollection.numDocuments();i++)
		{
			if(!this.contains(resultCollection.get(i)))
			{
				this.appendDocument(resultCollection.get(i));
				if(((LinkedDocument)resultCollection.get(i)).getOutgoingLinks()!=null)
				{
					this.crawl(((LinkedDocument)resultCollection.get(i)).getOutgoingLinks());
				}
			}
		}
	}
	public LinkedDocumentCollection crawl()
	{
		LinkedDocumentCollection resultCollection=new LinkedDocumentCollection();
		resultCollection.crawl(this);
		return resultCollection;
	} 
	
	public void match(String searchQuery) {//System.out.println("1");
	    if (this.isEmpty()) {//System.out.println("1");
	        return;
	      }

	      if (searchQuery == null || searchQuery.equals("")) {//System.out.println("1");
	        return;
	      }
	      
	      //for(WordCount ss : tmp4.get(0).getWordCounts().wordCounts) System.out.println(ss.getWord());

	      /* add query to collection as document */
	      
	      
	      
	      
	      
	      
	      
	      LinkedDocument queryDocument = new LinkedDocument("query", "", "", null, null, searchQuery,"");
	      this.prependDocument(queryDocument);
	      
	     /* System.out.println(this.get(0).getTitle());
	      for(int i=0;i<this.get(0).getWordCounts().size();i++)
	      {
	    	  System.out.println(this.get(0).getWordCounts().getWord(i));
	      }
	      
	      
	      System.out.println(this.get(2).getTitle());
	      for(int i=0;i<this.get(2).getWordCounts().size();i++)
	      {
	    	  System.out.println(this.get(2).getWordCounts().getWord(i));
	      }
	      

	      /* add every word to every document with count 0 */
	      this.addZeroWordsToDocuments();
	      

	      /* sort all WordCountsArrays of all documents */
	      /*DocumentCollectionCell tmp = this.first;
	      while (tmp != null) {
	        tmp.getDocument().getWordCounts().sort();
	        tmp = tmp.getNext();
	      }*/
	      
	      DocumentCollectionCell tmp6 = this.first;
	      while (tmp6 != null) {
	        tmp6.getDocument().getWordCounts().doSelectionSort();
	        tmp6 = tmp6.getNext();
	      }

	      
	     /* System.out.println(this.get(0).getTitle());
	      for(int i=0;i<this.get(0).getWordCounts().size();i++)
	      {
	    	  System.out.println(this.get(0).getWordCounts().getWord(i));
	      }
	      
	      
	      
	      
	      
	      System.out.println(this.get(2).getTitle());
	      for(int i=0;i<this.get(2).getWordCounts().size();i++)
	      {
	    	  System.out.println(this.get(2).getWordCounts().getWord(i));
	      }
	      
	      
	      
	      
	      
	      
	      
	      
	      

	      /* calculate similarities with query document */
	      tmp6 = this.first.getNext();
	      while (tmp6 != null) {//for(WordCount tmp3 :tmp.getDocument().getWordCounts().wordCounts) System.out.println(tmp3.getWord()+" "+tmp3.getCount());
	      //for(WordCount tmp3 :queryDocument.getWordCounts().wordCounts) System.out.println(tmp3.getWord()+" "+tmp3.getCount());  
	      //System.out.println(tmp.getDocument().getWordCounts().computeSimilarity(queryDocument.getWordCounts(), this));
	      
	      //for(WordCount tmp3 :queryDocument.getWordCounts().wordCounts) System.out.println(tmp3.getWord()+" "+tmp3.getCount());
	      
	      tmp6.setQuerySimilarity(tmp6.getDocument().getWordCounts().computeSimilarity(queryDocument.getWordCounts(), this));//System.out.println("sad");
	        tmp6 = tmp6.getNext();
	      }

	      /* remove the query we added in the beginning */
	      this.removeFirstDocument();

	      this.sortBySimilarityDesc();
	    }
	/*public LinkedDocumentCollection copy()
	  {
		  LinkedDocumentCollection ret =new LinkedDocumentCollection();
		  for(int i=0;i<this.size;i++)
		  {
			  LinkedDocument tmp=((LinkedDocument) this.get(i)).copy();
			  ret.appendDocument(tmp);
		  }
		  
		  return ret;
		  }*/
		  
	

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*LinkedDocumentCollection a= new LinkedDocumentCollection();
		LinkedDocument b= new LinkedDocument(null,null,null,null,null,"es ist einmal eine alte geiss link:dateiziege gewesen link:sdasd link:asas die hatte sieben link:dateisieben junge zicklein","12");

		a.appendDocument(b);System.out.println(a.numDocuments());
	

		a.appendDocument(b);System.out.println(a.numDocuments());
		DocumentCollection tmp =new LinkedDocumentCollection();
		  LinkedDocument tmp2=new LinkedDocument(null,null,null,null,null,"es war einmal eine alte geiss die hatte sieben junge geisslein und hatte sie lieb wie eine mutter ihre kinder lieb hat ",null);
		  tmp.appendDocument(tmp2);
		  //System.out.println("1");
		String a="hatte";
		//System.out.println("1");
		tmp.match(a);
		System.out.println(tmp.getQuerySimilarity(0));
		
	}*/

}
