
public class DocumentCollectionCell {

	private DocumentCollectionCell next;
	private Document dc;
	private DocumentCollectionCell prev;
	private double similarity;
	private int index;
	public DocumentCollectionCell(Document dc)
	{
		this.dc=dc;
		next=null;
		prev=null;
	}
	public int getIndex()
	{
		return this.index;
	}
	public void setIndex(int index)
	{
		this.index=index;
	}
	public double getSimilarity()
	{
		return this.similarity;
	}
	public void setSimilarity(double similarity)
	{
		this.similarity=similarity;
	}
	
	public DocumentCollectionCell(DocumentCollectionCell next,DocumentCollectionCell prev,Document dc)
	{
		this.prev=prev;
		this.next=next;
		this.dc=dc;
	}
	public DocumentCollectionCell getNextDcCCell()
	{
		return this.next;
	}
	public DocumentCollectionCell getLastDcCCell()
	{
		return this.prev;
	}
	public Document getDoc()
	{
		return this.dc;
	}
	public void setLastDcCCEll(DocumentCollectionCell prev)
	{
		this.prev=prev;
	}
	public void setNextDcCCell(DocumentCollectionCell next)
	{
		this.next=next;
	}
	public void setDoc(Document dc)
	{
		this.dc=dc;
	}
	
}
