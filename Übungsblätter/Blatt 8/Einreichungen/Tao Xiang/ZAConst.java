
public class ZAConst<T> extends ZAExpression<T> {

	private T konstante;
	ZAConst(T konstante)
	{
		this.konstante=konstante;
	}
	
	@Override
	public T evaluate() {
		// TODO Auto-generated method stub
		return this.konstante;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.konstante.toString();
	}
}
