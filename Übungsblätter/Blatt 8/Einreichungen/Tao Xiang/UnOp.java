
public abstract class UnOp<T> extends Expression<T> {
	protected Expression<T> operand;
	UnOp(Expression<T> operand)
	{
		this.operand=operand;
	}
	
	

}
