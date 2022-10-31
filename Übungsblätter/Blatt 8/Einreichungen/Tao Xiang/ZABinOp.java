
public abstract class ZABinOp<E,T> extends ZAExpression<T> {

	protected ZAExpression<E> left;
	protected ZAExpression<E> right;
	ZABinOp(ZAExpression<E> left,ZAExpression<E> right)
	{
		this.left= left;
		this.right= right;
	}
}
