public class TestIt {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		DocumentCollection docC=new DocumentCollection();
		String str= Terminal.askString("> ");
		
		for(;!str.equals("exit");)
		{
			boolean notcompleted= true;
			if(notcompleted&&str.length()>4&&str.substring(0, 3).equals("add")&&str.indexOf(":")!=-1&&str.indexOf(":")!=4)
			   {{
				int i=str.indexOf(":");
				String titel=str.substring(4, i);
				String fließtest =str.substring(i+1);
				Document doc =new Document(fließtest);
				doc.setTitle(titel);
				docC.appendDocument(doc);
				notcompleted=false;
				//System.out.println(docC.getDoc().getTitle()+":"+docC.getDoc().getWordCounts().getWord(0));
			    }}
			if(notcompleted&&str.equals("list"))
			{
				for(int i=0;i<docC.anzahl;i++)
				{
	               System.out.println(docC.get(i).getTitle());
				}
				notcompleted=false;
			}
			if(notcompleted&&str.length()>6&&str.substring(0, 5).equals("count")&&str.indexOf(" ")==5)
			{
				 {
				String word=str.substring(6);
				for(int i=0;i<docC.anzahl;i++)
				{
					int index=docC.get(i).getWordCounts().getIndexOfWord(word);
					System.out.print(docC.get(i).getTitle()+": ");
					if(index!=-1&&docC.get(i).getWordCounts().getCount(index)!=0) System.out.println(docC.get(i).getWordCounts().getCount(index)+"x");
					else 
						{
						System.out.println("gar nicht.");
						}
				}
				notcompleted=false;
			}	
			}
			if(notcompleted&&str.length()>6&&str.substring(0, 5).equals("query"))
			{
				if(!docC.isEmpty())
				 {
				String suchanfrage =str.substring(6);
				docC.match(suchanfrage);
				for(int i=0;i<docC.anzahl;i++)
				{
					System.out.println(i+1+". "+docC.get(i).getTitle()+"; Aehnlichkeit: "+docC.getQuerySimilarity(i));
				}
				notcompleted=false;}
				else {
					System.out.println("bitte zuerst eine Dokument hinzufügen! ");
					notcompleted=false;
				}
			}
			if(notcompleted) System.out.println("ilegale Eingabe,bitte erneut eingeben");
			str=Terminal.askString("> ");
		}

		
	}

}
