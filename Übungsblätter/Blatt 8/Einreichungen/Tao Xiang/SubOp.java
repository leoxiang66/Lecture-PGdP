
public class SubOp<T> extends BinOp<Integer>{

	SubOp(Expression<Integer> left, Expression<Integer> right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	protected Integer evaluate() {
		// TODO Auto-generated method stub
		return this.left.evaluate()-this.right.evaluate();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+ this.left.toString()+"-"+this.right.toString()+")";
	}

}
