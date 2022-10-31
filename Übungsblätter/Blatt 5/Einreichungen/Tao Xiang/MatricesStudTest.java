
public class MatricesStudTest {
	private static boolean vergleichen(int[] a ,int[]b)
	{
		boolean same=true;
		if(a.length!=b.length) same=false;
		else {
			for(int i =0;i<a.length;i++)
			{
				if(a[i]!=b[i])
				{
					same=false;
					break;
				}
		     }
		}
		return same;
	}
	public static void testOfpermutations()
	{
		int test1=1;
		int test2=2;
		int fac1=1;
		for(int i=2;i<=test1;i++)
		{
			fac1*=i;
		}
		int fac2=1;
		for(int i=2;i<=test2;i++)
		{
			fac2*=i;
		}
		
		for(int i=0;i<fac1;i++)
		{
		
			if(MatricesStudTest.vergleichen(MatrixVectorOperations.permutations(test1)[i],new int[] {0}))
			{
				System.out.println("test1 of permutation passed");
			}
			else System.out.println("test1 of permutation failed");
		}
		boolean test2passt = false;
		for(int i=0;i<fac2;i++)
		{
			
			if(MatricesStudTest.vergleichen(MatrixVectorOperations.permutations(test2)[i],new int[] {0,1})||MatricesStudTest.vergleichen(MatrixVectorOperations.permutations(test2)[i],new int[] {1,0}))
			{
				test2passt=true;
			}
			else test2passt=false;
			
		}
		for(int i=0;i<fac2;i++)
		{
			for(int j=i+1;j<fac2;j++)
			{
				if(MatricesStudTest.vergleichen(MatrixVectorOperations.permutations(test2)[i],MatrixVectorOperations.permutations(test2)[j]))
				{
					test2passt=false;
				}
			}
				
		}
		if(test2passt)
		{
			System.out.println("test2 of permutation passed");
		}
		else System.out.println("test2 of permutation failed");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[][] a= {{1,2,3},{4,5,6},{7,8,9}};
		double[] b= {3,3,4};
		double[] c= {1,2,3};
		if(MatrixVectorOperations.multiply(a, b)[0]==21.0&&MatrixVectorOperations.multiply(a, b)[1]==51.0&&MatrixVectorOperations.multiply(a, b)[2]==81.0)
        {
	     System.out.println("Test of Multipy passed");
        }
		else System.out.println("Test of Multiply failed");
		
		if(MatrixVectorOperations.cosineSimilarity(b,c)==0.9625334218796219)
		{
			System.out.println("Test of cosineSimilarity passed");
		}
		else System.out.println("Test of cosineSimilarity failed");
		
		if(MatrixVectorOperations.transpose(a)[0][0]==1.0&&MatrixVectorOperations.transpose(a)[0][1]==4.0&&MatrixVectorOperations.transpose(a)[0][2]==7.0&&MatrixVectorOperations.transpose(a)[1][0]==2.0&&MatrixVectorOperations.transpose(a)[1][1]==5.0&&MatrixVectorOperations.transpose(a)[1][2]==8.0&&MatrixVectorOperations.transpose(a)[2][0]==3.0&&MatrixVectorOperations.transpose(a)[2][1]==6.0&&MatrixVectorOperations.transpose(a)[2][2]==9.0)
				{
			       System.out.println("Test of transpose passed");
				}
		else System.out.println("Test of transpose failed");
		
		if(MatrixVectorOperations.euclideanDistance(b, c)==2.449489742783178)
		{
			System.out.println("Test of euclideanDistance passt");
		}
		
		int[]g = new int[] {0,2,1};
		MatricesStudTest.testOfpermutations();
		
		if(MatrixVectorOperations.sgn(g)==-1)
		{
			System.out.println("test of sgn passed");
		}
		else System.out.println("test of sgn failed");
		
		if(MatrixVectorOperations.determinant(new int[][] {{0,1},{1,0}})==-1)
		{
			System.out.println("test of determinant passed");
		}
		else System.out.println("test of determinant failed");
		
		
	}

}
