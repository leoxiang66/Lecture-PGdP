
public class ZATest {
	
	public static void main(String[] args)
	{
		ZAConst<Integer> a1=new ZAConst<Integer>(5);
		ZAConst<Integer> a2=new ZAConst<Integer>(6);
		ZAConst<Integer> a3=new ZAConst<Integer>(7);
		ZAConst<Integer> a4=new ZAConst<Integer>(8);
		ZAConst<Integer> a5=new ZAConst<Integer>(9);
		
		//e1:(((5-6) + (5*6))>(7-((-(8*7))*(8-6))))
		ZAGTOp<Integer,Boolean> e1= new ZAGTOp<Integer,Boolean>(new ZAAddOp<Integer,Integer>(new ZASubOp<Integer,Integer>(a1,a2),new ZAMulOp<Integer,Integer>(a1,a2)),new ZASubOp<Integer,Integer>(a3,new ZAMulOp<Integer,Integer>(new ZANegOp<Integer>(new ZAMulOp<Integer,Integer>(a4,a3)),new ZASubOp<Integer,Integer>(a4,a2))));
		
		//e2:(((8-7) + (6*8))<(8-((-(5*6))*(6-7))))
		ZALTOp<Integer,Boolean> e2= new ZALTOp<Integer,Boolean>(new ZAAddOp<Integer,Integer>(new ZASubOp<Integer,Integer>(a4,a3),new ZAMulOp<Integer,Integer>(a2,a4)),new ZASubOp<Integer,Integer>(a4,new ZAMulOp<Integer,Integer>(new ZANegOp<Integer>(new ZAMulOp<Integer,Integer>(a1,a2)),new ZASubOp<Integer,Integer>(a2,a3))));
		
		//e3:(((9-5) + (7*9))==(9-((-(7*7))*(9-5))))
		ZAEQOp<Integer,Boolean> e3= new ZAEQOp<Integer,Boolean>(new ZAAddOp<Integer,Integer>(new ZASubOp<Integer,Integer>(a5,a1),new ZAMulOp<Integer,Integer>(a3,a5)),new ZASubOp<Integer,Integer>(a5,new ZAMulOp<Integer,Integer>(new ZANegOp<Integer>(new ZAMulOp<Integer,Integer>(a3,a3)),new ZASubOp<Integer,Integer>(a5,a1))));
		
		
		if(e1.toString().equals("(((5-6) + (5*6))>(7-((-(8*7))*(8-6))))")&&e1.evaluate()==false)
		{
			System.out.println("Test of e1 passed");
		}
		else System.out.println("Test of e1 failed");
		
		if(e2.toString().equals("(((8-7) + (6*8))<(8-((-(5*6))*(6-7))))")&&e2.evaluate()==false)
		{
			System.out.println("test of e2 passed");
		}
		else 
			System.out.println("test of e2 failed");
		
		if(e3.toString().equals("(((9-5) + (7*9))==(9-((-(7*7))*(9-5))))")&&e3.evaluate()==false)
		{
			System.out.println("test of e3 passed");
		}
		else System.out.println("test of e3 failed");
	}

}
