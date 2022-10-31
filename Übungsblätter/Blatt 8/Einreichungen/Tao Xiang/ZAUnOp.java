
public abstract class ZAUnOp<E> extends ZAExpression<E> {
	protected ZAExpression<E> operand;
	ZAUnOp(ZAExpression<E> operand)
	{
		this.operand=operand;
	}
}
