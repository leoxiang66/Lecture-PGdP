
public class MatrixVectorOperations {

	public static double[] multiply(double[][] matrix,double[] vector)
	{
		double[] a = new double[matrix.length];
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[0].length;j++)
			{
				a[i]+=matrix[i][j]*vector[j];
			}
		}
		return a;
	}
	public static double skalarProdukt(double[] v1,double[] v2)
	{
		double summe = 0;
		for(int i=0;i<v1.length;i++)
		{
			summe+=v1[i]*v2[i];
		}
		return summe;
	}
	public static double cosineSimilarity(double[] v1,double[] v2)
	{
		return MatrixVectorOperations.skalarProdukt(v1, v2)/Math.sqrt(MatrixVectorOperations.skalarProdukt(v1, v1)*MatrixVectorOperations.skalarProdukt(v2, v2));
    }
	public static double[][] transpose(double[][] matrix)
	{
		int a=matrix[0].length;
		int b = matrix.length;
		double[][]c= new double[a][b];
		for(int j=0;j<b;j++)
		{
			for(int i=0;i<a;i++)
			{
				c[i][j]=matrix[j][i];
			}
		}
		return c;
	} 
	public static double euclideanDistance(double[] v1,double[] v2)
	{
		double[] c =new double[v1.length];
		for(int i=0;i<c.length;i++)
		{
			c[i]=v1[i]-v2[i];
		}
		return Math.sqrt(MatrixVectorOperations.skalarProdukt(c, c));
	}
	private static int[] fillingArray(int[] a)
	{
		int[] b;
		int indexofFirstzero = 0;
		for(int i=0;i<a.length;i++)
		{
			
			if(a[i]==0)
			{
				if(i==a.length-1) b=a;
				else {
				indexofFirstzero=i;
				break;}
			}
		}
		for(int j=indexofFirstzero+1;j<a.length;j++)
		{
			if(a[j]==0)
			{
				for(int k=0;k<a.length;k++)
				{
					boolean add=true;
					for(int index=0;index<j;index++)
					{
						if(a[index]==k) 
							{
							add=false;
							break;
							}
						
					}
					if(add)
					{
						a[j]=k;
						break;
					}
				}
			}
		}
		b=a;
		return b;	
	}
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
	private static boolean lastelmementnotsame(int[] a)
	{
		boolean same =true;
		
			for(int i=0;i<a.length;i++)
			{
				if(a[i]!=0){
			
				             for(int j=0;j!=i&&j<a.length;j++)
				                {if(a[j]!=0) {
					                           if(a[i]==a[j])
					                               {
						                            same=false;
						                             break;
					                               }
				
			                                 }
				                }
				
				          } 
			}
			return same;
	}
		
	
	private static boolean valueOverLengthminus1(int[]a)
	{
		boolean over=false;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]>a.length-1)
			{
				over=true;
				break;
			}
		}
		return over;
	}
	private static int returntheIndex(int[]a)
	{int index = 0;
		if(MatrixVectorOperations.valueOverLengthminus1(a))
		{
			for(int i=0;i<a.length;i++)
			{
				if(a[i]>a.length-1)
				{
					index=i;
					break;
				}
			}

		}
		return index;
	}
	private static int[] makeAnewpermutation(int[] muster,int[] newpermutation)
	{
		int[] a ;
		int n= newpermutation.length-1;
		if(!MatrixVectorOperations.vergleichen(muster, newpermutation))
		{
			a=newpermutation;
		}
		else 
		{
			newpermutation[n]++;
			for(;true;)
			{
				if(!MatrixVectorOperations.valueOverLengthminus1(newpermutation)&&MatrixVectorOperations.lastelmementnotsame(newpermutation))
				{
					
					a=MatrixVectorOperations.fillingArray(newpermutation);
							break;
				}
				if(!MatrixVectorOperations.lastelmementnotsame(newpermutation))
				{
					newpermutation[n]++;
				}
				if(MatrixVectorOperations.valueOverLengthminus1(newpermutation))
				{
					int k=MatrixVectorOperations.returntheIndex(newpermutation);
					newpermutation[k]=0;
					newpermutation[k-1]++;
				}
			}
		}
		return a;
	}
	
	public static int[][] permutations(int n)
	{
		int fac=1;
		for(int i=2;i<=n;i++)
		{
			fac*=i;
		}
		int[][] a = new int[fac][n];
		for(int i=0;i<fac;i++)
		{
			int[] b=new int[n];
			b=MatrixVectorOperations.fillingArray(b);
			for(int j=0;j<i;j++)
			{
				b=MatrixVectorOperations.makeAnewpermutation(a[j], b);
			}
			a[i]=b;
			//System.out.println(java.util.Arrays.toString(a[i]));
		}
		return a;	
	}
	public static int sgn(int[] permutation)
	{
		int zähler=1;
		int nenner=1;
		for(int i=0;i<permutation.length;i++)
		{
			for(int j=1;j<permutation.length;j++)
			{
				if(j>i)
				{
				zähler*=permutation[j]-permutation[i];
				nenner*=j-i;
				}
			}
		}
		return zähler/nenner;
	}
	public static int determinant(int[][] A)
	{
		int summe=0;
		for(int i=0;i<A.length;i++)
		{
			int a=1;
			for(int j=0;j<A[0].length;j++)
			{
				a*=A[j][A[i][j]];
			}
			a*=MatrixVectorOperations.sgn(A[i]);
			summe+=a;
		}
		return summe;
	}
}
