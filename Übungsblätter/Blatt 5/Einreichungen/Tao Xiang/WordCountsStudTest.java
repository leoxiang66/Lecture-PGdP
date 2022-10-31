
public class WordCountsStudTest {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WordCountsArray wca= new WordCountsArray(4);
		wca.add("nihao", 3);
		wca.add("hello", 4);
		wca.add("hallo", 5);
		
		if(wca.getWord(-2)==null) System.out.println("test1 of getword passed");
		else System.out.println("test1 of getword failed");
		if(wca.getWord(7)==null) System.out.println("test2 of getword passed");
		else System.out.println("test2 of getword failed");
		
		if(wca.getIndexOfWord("nihao")==0) System.out.println("test1 of getIndexofWord passed");
		else System.out.println("test1 of getIndexofWord failed");
		if(wca.getIndexOfWord("hallo")==2) System.out.println("test2 of getIndexofWord passed");
		else System.out.println("test2 of getIndexofWord failed");
		if(wca.getIndexOfWord("dsadsadasdasd")==-1) System.out.println("test3 of getIndexofWord passed");
		else System.out.println("test3 of getIndexofWord failed");
		
		wca.add("nihao", 66);
		if(wca.getCount(0)==69) System.out.println("test1 of add passed");
		else System.out.println("test1 of add failed");
		wca.add("dddda", 4);
		if(wca.size()==4&&wca.getWord(3).equals("dddda")&&wca.getCount(3)==4)
		{
			System.out.println("test2 of add passed");
		}
		else System.out.println("test2 of add failed");
		
		{//test os sort
	    WordCountsArray sort = new WordCountsArray(3);
		sort.add("z", 3);
		sort.add("a", 2);
		sort.add("h", 5);
		sort.add("c", 6);
		sort.add("x", 5);
		sort.sort();
		
		WordCountsArray muster = new WordCountsArray(5);
		muster.add("a", 2);
		muster.add("c", 6);
		muster.add("h", 5);
		muster.add("x", 5);
		muster.add("z", 3);
		
		if(sort.equals(muster)) System.out.println("test of sort passed");
		else System.out.println("test of sort failed");
		 
		
		}
		/*WordCountsArray b= new WordCountsArray(5);
		b.add("nihao", 3);
		b.add("hello", 3);
		b.add("hallo", 333);
		b.add("dddda", 44);
		//System.out.println(wca.wordsEqual(b));
		System.out.println(wca.scalarProduct(b));
		*/
		
		
		{
			//test of computeSimilarity
			WordCountsArray muster = new WordCountsArray(5);
			muster.add("a", 2);
			muster.add("c", 6);
			muster.add("h", 5);
			muster.add("x", 5);
			muster.add("z", 3);
			
			WordCountsArray a = new WordCountsArray(5);
			a.add("a", 2);
			a.add("c", 6);
			a.add("h", 5);
			a.add("x", 5);
			a.add("z", 3);
			if(muster.computeSimilarity(a)==1.0){
			System.out.println("test of computeSimilarity passed");
			}
			else System.out.println("test of computeSimilarity failed");
		}
		
	}

}
