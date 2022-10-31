
public class Const<T> extends Expression<T> {

	private T konstante;
	Const(T konstante)
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
	
	/*public static void main(String[] args)
	{
		Const<Boolean> a= new Const<Boolean>(true);
		System.out.println(a.evalute());
	}*/
	

}
