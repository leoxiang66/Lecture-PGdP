
public class ZANegOp<T> extends ZAUnOp<T> {

	ZANegOp(ZAExpression<T> operand) {
		super(operand);
		// TODO Auto-generated constructor stub
	}

	
	private Integer firstevalute() {
		// TODO Auto-generated method stub
		 return -(Integer)(this.operand.evaluate());
	
		
	}
	private Boolean secondevalue()
	{
		 if((Boolean)(this.operand.evaluate())==true) return false;
		return true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(this.operand.evaluate()instanceof Integer)
		return "(-"+this.operand.toString()+")";
		return "(¬"+this.operand.toString()+")";
	}


	@Override
	protected T evaluate() {
		// TODO Auto-generated method stub
		if(this.operand.evaluate() instanceof Integer) return (T) this.firstevalute();
		return (T) this.secondevalue();
	}
	/*public static void main(String[] args)
	{
		NegOp<Boolean> a=new NegOp<Boolean>(new Const<Boolean>(true));
		System.out.println(a.evalute());
	}
*/
}
