
public class ZAGTOp<T,E> extends ZABinOp<Integer,Boolean>{

	ZAGTOp(ZAExpression<Integer> left, ZAExpression<Integer> right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}



	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+this.left.toString()+">"+this.right.toString()+")";
	}

	@Override
	protected Boolean evaluate() {
		// TODO Auto-generated method stub
		return this.left.evaluate()>this.right.evaluate();
	}
}
