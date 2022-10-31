import java.util.ArrayList;

public class LinkedDocument extends Document {
	public LinkedDocument(String title, String language, String description, Date releaseDate, Author author,
			String content,String id) {
		super(title, language, description, releaseDate, author, content);
		this.ID=id;
		this.outgoingID=this.findOutgoingIDs(content);
		this.setLinkCountZero();
		// TODO Auto-generated constructor stub
	}
	public  String getID()
	{
		return this.ID;
	}

	private LinkedDocumentCollection incomingLinks;
	private LinkedDocumentCollection outgoingLinks;
	public LinkedDocumentCollection getIncomingLinks()
	{
		return this.incomingLinks;
	}
	public LinkedDocumentCollection getOutgoingLinks()
	{
		if(this.outgoingLinks!=null)
		return this.outgoingLinks;
		this.createOutgoingDocumentCollection();
		return this.outgoingLinks;
	}
	private String ID;
	private String[] outgoingID;
	public String[] getOutgoingID()
	{
		return this.outgoingID;
	}
	public boolean equals(Document doc)
	{
		if(doc instanceof LinkedDocument&&((LinkedDocument) doc).getID().equals(this.getID()))
		{
				return true;
		}
		return super.equals(doc);
	}
	private  String[] findOutgoingIDs(String text)
	{
		String[] tmp=text.split(" ");
		ArrayList<String> a=new ArrayList<String>();
		for(int i=0;i<tmp.length;i++)
		{
			if(tmp[i].contains("link:"))
			{
				a.add(tmp[i].substring(tmp[i].indexOf(":")+1));
			}
		}
		String[] ret=new String[a.size()];
		a.toArray(ret);
		for(int i=0;i<ret.length;i++)
		{
			int min=i;
			for(int j=i+1;j<ret.length;j++ )
			{
				if(ret[min].compareTo(ret[j])>0)
				{
					min=j;
				}
			}
			String temp=ret[i];
			ret[i]=ret[min];
			ret[min]=temp;
		}
		return ret;
	}
	private void setLinkCountZero()
	{
		for(int i=0;i<this.getWordCounts().size();i++)
		{
			if(this.getWordCounts().getWord(i).contains("link:"))
			{
				this.getWordCounts().setCount(i, 0);
			}
		}
	}
	public void addIncomingLink(LinkedDocument incomingLink)
	{
		if(!this.equals(incomingLink))
		this.incomingLinks.appendDocument(incomingLink);
	}
	public static LinkedDocument creatLinkedDocumentFromFile(String fileName)
	{
		String[] tmp2=Terminal.readFile(fileName);
		if(tmp2!=null) {
		if(tmp2.length==2)
		{//System.out.println("1");
			LinkedDocument ret = new LinkedDocument(tmp2[0],"","",null,null,tmp2[1],fileName);
			return ret;
		}//System.out.println("1");
		}
		return null;
	}
	private void createOutgoingDocumentCollection()
	
	    {
		   ArrayList<LinkedDocument> list= new ArrayList<LinkedDocument>();
		   for(String tmp:this.outgoingID)
		   {//System.out.println(tmp);xiu gai999999999
			   list.add(LinkedDocument.creatLinkedDocumentFromFile(tmp));
			   //System.out.println(tmp);
		   }
		   
		   if(list.size()!=0) {
			   //System.out.println(list.size());
		   LinkedDocument[] tmp2=new LinkedDocument[list.size()];
		   list.toArray(tmp2);
		  // System.out.println(tmp2[0].getID());
		   this.outgoingLinks=new LinkedDocumentCollection();
		   for(int i=0;i<tmp2.length;i++)
		   {
			   if(!this.equals(tmp2[i])&&tmp2[i]!=null)
			   {//System.out.println(i);
				   this.outgoingLinks.appendDocument(tmp2[i]);
			   }
		   }
		
		}
		   }
	/*public LinkedDocument copy()
	  {
		  LinkedDocument a = new LinkedDocument("","","",null,null,this.getContent(),"");
		  return a;
	  }
	/*public static void main(String[] args)
	{
		String test="es ist einmal eine alte geiss link:dateiziege gewesen link:sdasd link:asas die hatte sieben link:dateisieben junge zicklein";
		
		LinkedDocument a= new LinkedDocument("","","",null,null,"es ist einmal eine alte geiss link:dateiziege gewesen link:sdasd link:asas die hatte sieben link:dateisieben junge zicklein","");
		for(String b:a.outgoingID) System.out.println(b);
		/*for(int i=0;i<a.getWordCounts().size();i++)
		{
			System.out.println(a.getWordCounts().getWord(i)+" "+a.getWordCounts().getCount(i));
		}
	}*/

	

}
