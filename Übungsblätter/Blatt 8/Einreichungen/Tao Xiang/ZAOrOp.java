
public class ZAOrOp<T,E> extends ZABinOp<Boolean,Boolean> {

	ZAOrOp(ZAExpression<Boolean> left, ZAExpression<Boolean> right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Boolean evaluate() {
		// TODO Auto-generated method stub
		return this.left.evaluate()||this.right.evaluate();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+this.left.toString()+"∨"+this.right.toString()+")";
	}

	

}
