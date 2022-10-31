
public class DocumentCollection {
	DocumentCollectionCell anfang;
	int anzahl; // number of documents in this collection
	public DocumentCollection()
	{
		anfang=null;
		anzahl=0;
	}
	public void prependDocument(Document doc)
	{
		if(doc!=null) {
			anzahl++;
			if(anfang!=null) {
				DocumentCollectionCell tmp=this.anfang;
				for(int i=0;i<anzahl-1;i++)
				{
					tmp.setIndex(i+1);
					tmp=tmp.getNextDcCCell();
				}
		DocumentCollectionCell newbeginn=new DocumentCollectionCell(doc);
		newbeginn.setNextDcCCell(anfang);
		this.anfang.setLastDcCCEll(newbeginn);
		this.anfang=newbeginn;
		this.anfang.setIndex(0);
		
		
			}
			if(anfang==null)
			{
				anfang= new DocumentCollectionCell(doc);
				anfang.setIndex(0);
			}
		
		}
	}
	public void appendDocument(Document doc)
	{
		if(doc!=null)
		{
			anzahl++;
			if(anfang!=null) {
			DocumentCollectionCell newend=new DocumentCollectionCell(doc);
			DocumentCollectionCell temp=this.anfang;
			while(temp.getNextDcCCell()!=null)
			{
				temp=temp.getNextDcCCell();
			}
			temp.setNextDcCCell(newend);
			newend.setLastDcCCEll(temp);
			newend.setIndex(anzahl);
			}
			if(anfang==null) {
				anfang=new DocumentCollectionCell(doc);
				anfang.setIndex(0);
			}
		}
	}
	private DocumentCollectionCell getDocCC(int index)
	{
		return this.findTheDocCCAtIndex(index);
	}
	public boolean isEmpty()
	{
		return(anzahl==0);
	}
	public int numDocuments()
	{
		return anzahl;
	}
	public Document getFirstDocument()
	{
		if(this.anfang==null) return null;
		else {
			return this.anfang.getDoc();
		}
	}
	private DocumentCollectionCell findTheLastDocCC()
	{
		if(this.anfang!=null) {
		DocumentCollectionCell temp=this.anfang;
		while(temp.getNextDcCCell()!=null)
		{
			temp=temp.getNextDcCCell();
		}
		return temp;}
		else return null;
	}
	private DocumentCollectionCell findTheDocCCAtIndex(int index)
	{
		if(index>=0&&index<this.anzahl) {
			DocumentCollectionCell temp=this.anfang;
			for(int i=1;i<=index;i++)
			{
				temp=temp.getNextDcCCell();
			}
			return temp;}
			else return null;
	}
	public Document getLastDocument()
	{
		if(this.anfang!=null)
		return this.findTheLastDocCC().getDoc();
		else return null;
	}
	public void removeFirstDocument()
	{
		if(this.anzahl!=0)
		{
			anzahl--;
			DocumentCollectionCell tmp =this.anfang;
			this.anfang=this.anfang.getNextDcCCell();
			anfang.setLastDcCCEll(null);
			tmp.setNextDcCCell(null);
		}
		DocumentCollectionCell tmp2=this.anfang;
		for(int i=0;i<anzahl;i++)
		{
			tmp2.setIndex(i);
			tmp2=tmp2.getNextDcCCell();
		}
	}
	public void removeLastDocument()
	{
		if(this.anzahl!=0)
		{
			anzahl--;
 
			DocumentCollectionCell tmp;
			tmp=this.findTheLastDocCC().getLastDcCCell();
			this.findTheLastDocCC().setLastDcCCEll(null);
			tmp.setNextDcCCell(null);
			
			
		}
	}
	public boolean remove(int index)
	{
		if(index<0||index>=this.anzahl) return false;
		else {
			anzahl--;
			DocumentCollectionCell temp= this.findTheDocCCAtIndex(index);
			DocumentCollectionCell tmp2=this.findTheDocCCAtIndex(index+1);
			temp.getLastDcCCell().setNextDcCCell(temp.getNextDcCCell());
			temp.getNextDcCCell().setLastDcCCEll(temp.getLastDcCCell());
			temp.setLastDcCCEll(null);
			temp.setNextDcCCell(null);
			for(int i=0;i+index<anzahl;i++)
			{
				tmp2.setIndex(i+index);
				tmp2=tmp2.getNextDcCCell();
			}
			
			
			return true;
		}
	}
	public Document get(int index)
	{
		if(index<0||index>=this.anzahl) return null;
		else {
			return this.findTheDocCCAtIndex(index).getDoc();
		}
	}
	public int indexof(Document doc)
	{
		int ret=-1;
		if(this.anzahl!=0)
		{
			DocumentCollectionCell tmp=this.anfang;
			for(int i=0;i<anzahl;i++,tmp=tmp.getNextDcCCell())
			{
				if(tmp.getDoc().equals(doc))
				{
					ret=i;
					break;
				}
			}
		}
		return ret;
	}
	public boolean contains(Document doc)
	{
		boolean contains=false;
		if(this.anzahl!=0)
		{
			for(int index=0;index<anzahl;index++)
			{
				if(this.findTheDocCCAtIndex(index).getDoc().equals(doc))
				{
					contains=true;
					break;
				}
			}
		}
		return contains;
	}
	private  static WordCountsArray merge(WordCountsArray wc1,WordCountsArray wc2)
	{
		WordCountsArray ret =new WordCountsArray(wc1.size()+wc2.size());
		for(int i=0;i<wc1.size();i++)
		{
			ret.add(wc1.getWord(i),wc1.getCount(i) );
		}
		for(int i=0;i<wc2.size();i++)
		{
			ret.add(wc2.getWord(i),wc2.getCount(i) );
		}
		
		return ret; 
				
	}
	private WordCountsArray allWords()
	{
		if(this.anzahl==0) return null;
		else {
			WordCountsArray ret = new WordCountsArray(10);
			DocumentCollectionCell tmp =this.anfang;
			for(int i=0;i<this.anzahl;i++) {
			ret=merge(ret,tmp.getDoc().getWordCounts());
			tmp=tmp.getNextDcCCell();}
			return ret;
		}
	}
	private void addZeroWordsToDocuments()
	{
		WordCountsArray allwords=this.allWords();
		DocumentCollectionCell tmp= this.anfang;
		for(int j=0;j<this.anzahl;j++) {
			
		for(int i=0;i<allwords.size();i++)
		{
			int index=tmp.getDoc().getWordCounts().getIndexOfWord(allwords.getWord(i));
			if(index==-1)
			{
				tmp.getDoc().getWordCounts().add(allwords.getWord(i), 0);
			}
		}
		tmp=tmp.getNextDcCCell();
		}
	}
	public void match(String searchQuery)
	{
		this.addZeroWordsToDocuments();
		Document temp=new Document(searchQuery);
		this.prependDocument(temp);
		this.addZeroWordsToDocuments();
		DocumentCollectionCell tmp=this.anfang;
		for(int i=0;i<this.anzahl;i++)
		{
			tmp.getDoc().getWordCounts().sort();
			tmp=tmp.getNextDcCCell();
		}
		DocumentCollectionCell tmp2=this.anfang.getNextDcCCell();
		for(int i=1;i<this.anzahl;i++)
		{
			tmp2.setSimilarity(this.anfang.getDoc().getWordCounts().computeSimilarity(tmp2.getDoc().getWordCounts()));
			tmp2=tmp2.getNextDcCCell();
		}
		this.removeFirstDocument();
		this.sortBySimilarityDesc();
	}
	public double getQuerySimilarity(int index)
	{
		return this.findTheDocCCAtIndex(index).getSimilarity();
	}
	private static void merge(DocumentCollection docC,int l1,int r1,int l2, int r2)
	{
		DocumentCollectionCell temp1 = null,temp2=null;
		if(docC.findTheDocCCAtIndex(l1).getLastDcCCell()!=null)
		{
			temp1=docC.findTheDocCCAtIndex(l1).getLastDcCCell();
		}
		if(docC.findTheDocCCAtIndex(r2).getNextDcCCell()!=null)
		{
			temp2=docC.findTheDocCCAtIndex(r2).getNextDcCCell();
		}
		int p1=l1,p2=l2;
		DocumentCollectionCell[] tmp =new DocumentCollectionCell[docC.anzahl];
		int index=l1;
		int index2=l1-1;
		while(p1<=r1&&p2<=r2)
		{
		if(docC.findTheDocCCAtIndex(p1).getSimilarity()>=docC.findTheDocCCAtIndex(p2).getSimilarity())
			{
				tmp[index]=docC.findTheDocCCAtIndex(p1);
				tmp[index].setIndex(++index2);
				index++;
				p1++;
			}
			else {
				tmp[index]=docC.findTheDocCCAtIndex(p2);
				tmp[index].setIndex(++index2);
				index++;
				p2++;
			}
		}
		while(p1<=r1) {
			tmp[index]=docC.findTheDocCCAtIndex(p1++);
			tmp[index].setIndex(++index2);
			index++;
		}
		while(p2<=r2)
		{ 
		
			tmp[index]=docC.findTheDocCCAtIndex(p2++);
		    tmp[index].setIndex(++index2);
			index++;
		}
		
		for(int i=l1;i+1<=r2;i++)
		{
	
			tmp[i].setNextDcCCell(tmp[i+1]);
			tmp[i+1].setLastDcCCEll(tmp[i]);
		}
		
		if(temp1!=null) { temp1.setNextDcCCell(tmp[l1]);tmp[l1].setLastDcCCEll(temp1);}
	    if(temp2!=null) {tmp[r2].setNextDcCCell(temp2);temp2.setLastDcCCEll(tmp[r2]);}
		
	    for(int i=l1;i<=r2;i++)
		{
			if(tmp[i].getIndex()==0)
			{
				docC.anfang=tmp[i];
				docC.anfang.setLastDcCCEll(null);
				break;
			}
		}	
	}
	private static void mergeSort(DocumentCollection docC,int left,int right)
	{
		if(left<right)
		{
			int mid=(left+right)/2;
			mergeSort(docC,left,mid);
			mergeSort(docC,mid+1,right);
			merge(docC,left,mid,mid+1,right);
			
		}
	}
	private void sortBySimilarityDesc()
	{
		DocumentCollection tmp=this;
		mergeSort(tmp,0,tmp.anzahl-1);
	}
	
	
	public static void main(String[] args)
	{
		String anfrage="hallo ich bin Tao";
		Document a=new Document("hallo");
		Document b=new Document("hallo ich");
		Document c= new Document("hallo ich bin Tao");
		Document d=new Document("sdsadsadsadsadasddasd");
		Document h= new Document("ich liebe dich");
		Document g =new Document("ich dich");
		Document l=new Document("servus ich b");

		DocumentCollection i=new DocumentCollection();
		i.appendDocument(a);
		i.appendDocument(b);
		i.appendDocument(c);
		i.appendDocument(d);
		i.appendDocument(h);
		i.appendDocument(g);
		i.appendDocument(l);
		i.match(anfrage);
		for(int j=0;j<i.anzahl;j++)
		{
			System.out.println(i.getDocCC(j).getSimilarity());
		}
		//i.sortBySimilarityDesc();
		
		/*i.match(anfrage);
		/*for(int j=0;j<i.anzahl;j++)
		{
			System.out.println(i.getQuerySimilarity(j));
		}}*/
}}
