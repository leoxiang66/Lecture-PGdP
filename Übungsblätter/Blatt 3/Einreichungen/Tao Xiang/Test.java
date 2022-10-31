

public class Test {
	public static WordCount Also = new WordCount("Also",6666666);              
	public static WordCount nihao = new WordCount("nihao",6666666);
	static public void testOfConstructor()
	{
	    System.out.print("WordCount a = new WordCount(good,-453453): ");          //Häufigkeit muss postiv sein,also dies ist ein Sonderfall.
		WordCount a = new WordCount("good",-453453);
	}
	static public void testOfgetWort()
	{
		System.out.print("WordCount a = new WordCount(good,3): ");              //ein normaler Fall;
		WordCount a = new WordCount("good",3);
		System.out.println(a.getWort());
	}
	static public void testOfgetHäufigkeit()
	{
		
		System.out.println("nihao.getHäufigkeit(): "+ nihao.getHäufigkeit());    //ein normale Fall;
	}
	static public void testOfsetHäufigkeit()
	{
		System.out.print("Also.setHäufigkeit(-7777777): ");                   //Sonderfall: negative Häufigkeit ist nicht erlaubt;
		Also.setHäufigkeit(-7777777);
		System.out.print("nihao.setHäufigkeit(88888): ");
		nihao.setHäufigkeit(88888);                                   // normaler Fall;
		System.out.println(nihao.getHäufigkeit());
	}
	static public void testOfincrementCount()
	{
		System.out.println("frequency of Also before incrementCount = "+Also.getHäufigkeit());
		Also.incrementCount();
		System.out.println("frequency of Also after incrementCount = "+Also.getHäufigkeit());
	}
	static public void testOfincrementCountWithParameterN()
	{
		int n =3333333;
		System.out.println("frequency of Also before incrementCount(int n=3333333) = "+Also.getHäufigkeit());  //normaler Fall,
		Also.incrementCount(n);
		System.out.println("frequency of Also after incrementCount(int n=3333333) = "+Also.getHäufigkeit());
		int m=-44444;                              
		System.out.println("frequency of Also before incrementCount(int m=-44444)= "+ Also.getHäufigkeit());   //Sonderfall;
		Also.incrementCount(m);
		System.out.println("frequency of Also after incrementCount(int m=-44444)= "+ Also.getHäufigkeit());
		
	}
	

}
