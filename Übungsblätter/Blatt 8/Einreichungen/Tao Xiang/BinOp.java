
public abstract class BinOp<T> extends Expression<T> {

	protected Expression<T> left;
	protected Expression<T> right;
	BinOp(Expression<T> left,Expression<T> right)
	{
		this.left=left;
		this.right=right;
	}
	
	

	
	

}
