
public abstract class Expression<T>{
	protected T value;
	protected abstract T evaluate();
	public abstract String toString();
	protected Expression()
	{
		
	}
}
