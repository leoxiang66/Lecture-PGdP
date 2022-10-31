
public class ZAMulOp<T,E> extends ZABinOp<Integer,Integer> {

	ZAMulOp(ZAExpression<Integer> left, ZAExpression<Integer> right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Integer evaluate() {
		// TODO Auto-generated method stub
		return this.left.evaluate()*this.right.evaluate();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+ this.left.toString()+"*"+this.right.toString()+")";
	}


}
