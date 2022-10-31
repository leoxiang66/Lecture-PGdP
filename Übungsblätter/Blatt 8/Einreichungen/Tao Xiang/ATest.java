
public class ATest {
	public static void main(String[] args) {
		//e0:15
		Const<Integer> a= new Const<Integer>(15);
		//e1:88
		Const<Integer> b =new Const<Integer>(88);
		//e2:(15 + 88)
		AddOp<Integer> c= new AddOp<Integer>(a,b);
		//e3:((15 + 88) + 88)
		AddOp<Integer> d= new AddOp<Integer>(c,b);
		//e4:(((15 + 88) + 88)-(15 + 88))
		SubOp<Integer> e= new SubOp<Integer>(d,c);
		//e5:((((15 + 88) + 88)-(15 + 88))*((15 + 88) + 88))
		MulOp<Integer> f=new MulOp<Integer>(e,d);
		//e6:(((((15 + 88) + 88)-(15 + 88))*((15 + 88) + 88))/(((15 + 88) + 88)-(15 + 88))
		DivOp<Integer> g=new DivOp<Integer>(f,e);
		//e7:-((((((15 + 88) + 88)-(15 + 88))*((15 + 88) + 88))/(((15 + 88) + 88)-(15 + 88)))
		NegOp<Integer>h=new NegOp<Integer>(g);
		//e8:false
		Const<Boolean> a1=new Const<Boolean>(1>2);
		//e9:true
		Const<Boolean> a2=new Const<Boolean>(1==1);
		//e10:(false∧true)
		AndOp<Boolean> a3=new AndOp<Boolean>(a1,a2);
		//e11:(true∧(false∧true))
		AndOp<Boolean> a4=new AndOp<Boolean>(a2,a3);
		//e12:((true∧(false∧true))∧(false∧true))
		AndOp<Boolean> a5=new AndOp<Boolean>(a4,a3);
		//e13:(((true∧(false∧true))∧(false∧true))∨(true∧(false∧true)))
		OrOp<Boolean>b1=new OrOp<Boolean>(a5,a4);
		//e14:((((true∧(false∧true))∧(false∧true))∨(true∧(false∧true)))∨((true∧(false∧true))∧(false∧true)))
		OrOp<Boolean>b2=new OrOp<Boolean>(b1,a5);
		//e15:(((((true∧(false∧true))∧(false∧true))∨(true∧(false∧true)))∨((true∧(false∧true))∧(false∧true)))∨(((true∧(false∧true))∧(false∧true))∨(true∧(false∧true))))
		OrOp<Boolean>b3=new OrOp<Boolean>(b2,b1);
		//e16:¬((((((true∧(false∧true))∧(false∧true))∨(true∧(false∧true)))∨((true∧(false∧true))∧(false∧true)))∨(((true∧(false∧true))∧(false∧true))∨(true∧(false∧true)))))
		NegOp<Boolean>b4=new NegOp<Boolean>(b3);
		
		
		//Testing the most 3 complicatedest expressions:e7,e15,e16
		
		
		if(h.toString().equals("(-(((((15 + 88) + 88)-(15 + 88))*((15 + 88) + 88))/(((15 + 88) + 88)-(15 + 88)))")&&h.evaluate()==-191)
		{
			System.out.println("test of e7 passed");
		}
		else 
			System.out.println("test of e7 failed");
		
		
		if(b3.toString().equals("(((((true∧(false∧true))∧(false∧true))∨(true∧(false∧true)))∨((true∧(false∧true))∧(false∧true)))∨(((true∧(false∧true))∧(false∧true))∨(true∧(false∧true))))")&&b3.evaluate()==false)
		{
			System.out.println("test of e15 passed");
		}
		else System.out.println("test of e15 failed");
		
		if(b4.toString().equals("(¬(((((true∧(false∧true))∧(false∧true))∨(true∧(false∧true)))∨((true∧(false∧true))∧(false∧true)))∨(((true∧(false∧true))∧(false∧true))∨(true∧(false∧true)))))")&&b4.evaluate()==true)
		{
			System.out.println("test of e16 passed");
		}
		else System.out.println("test of e16 failed");
		
		
		
	}

}
