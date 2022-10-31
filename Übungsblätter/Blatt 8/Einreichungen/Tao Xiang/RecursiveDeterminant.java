import java.util.Arrays;

public class RecursiveDeterminant {
	public static int det2x2(int[][] matrix)
	{
		return matrix[0][0]*matrix[1][1]-matrix[0][1]*matrix[1][0];
	}
	public static int[][] removeRow(int[][] matrix,int rowIndex)
	{
		int[][] ret=new int[matrix.length-1][matrix[0].length];
		for(int i=0,k=0;i<ret.length;i++,k++)
		{
			
			if(k==rowIndex) k++;
			if(k==matrix.length) break;
			for(int j=0;j<ret[0].length;j++)
			{
				
					ret[i][j]=matrix[k][j];
			}
		}
		return ret;
	}
	public static int[][] removeColumn(int[][] matrix,int colIndex)
	{
		int[][] ret=new int[matrix.length][matrix[0].length-1];
		for(int j=0,k=0;j<ret.length;j++,k++)
		{
			if(k==colIndex) k++;
			if(k==matrix[0].length) break;
			for(int i=0;i<ret.length;i++)
			{
					ret[i][j]=matrix[i][k];
			}
		}
		return ret;
	}
	public static int det3x3(int[][] matrix)
	{
		int[][]tmp=RecursiveDeterminant.removeRow(matrix, 0);
		int ret=0;
		for(int j=0;j<matrix.length;j++)
		{
			ret+=(int)Math.pow(-1, j)*matrix[0][j]*RecursiveDeterminant.det2x2(RecursiveDeterminant.removeColumn(tmp, j));
		}
		return ret;
	}
	public static int detNxN(int[][] matrix)
	{
		if(matrix.length!=matrix[0].length)
		{
			System.out.println("wrong matrix,the length of row is: "+matrix[0].length+", the length of column is "+matrix.length);
			return -1;
		}
		if(matrix.length==3) return det3x3(matrix);
		int ret=0;
		for(int j=0;j<matrix.length;j++)
		{
			ret+=matrix[0][j]*(int)Math.pow(-1, j)*detNxN(removeColumn(removeRow(matrix,0),j));
		}
		return ret;
	}
	

	public static void main(String[] args) {
		int[][]m1= {{1,6},{5,88}};
		
		int[][]m2= {{2,5,7},{5,0,1},{4,5,2}};
		
		int[][] m3={{1,66,3,4},{1,2,3,3},{1,2,3,6},{4,3,2,1}};
		
		if(det2x2(m1)==58) System.out.println("test of det2x2 passed");
		else System.out.println("test of det2x2 failed");
		
		if(det3x3(m2)==135) System.out.println("test of det3x3 passed");
		else System.out.println("test of det3x3 failed");
		
		if(detNxN(m3)==-1920) System.out.println("test of detNxN passed");
		else System.out.println("test of detNxN failed");
		
		if(Arrays.equals(removeRow(m2,1)[0],new int[][] {{2,5,7},{4,5,2}}[0])&&Arrays.equals(removeRow(m2,1)[1],new int[][] {{2,5,7},{4,5,2}}[1]))
			System.out.println("test of removeRow passed");
		else System.out.println("test of removeRow failed");
		
		if(Arrays.equals(removeColumn(m2,2)[0],new int[][] {{2,5},{5,0},{4,5}}[0])&&Arrays.equals(removeColumn(m2,2)[1],new int[][] {{2,5},{5,0},{4,5}}[1])&&Arrays.equals(removeColumn(m2,2)[2],new int[][] {{2,5},{5,0},{4,5}}[2])) 
			System.out.println("test of removeColumn passed");
		else System.out.println("test of removeColumn failed");
		
		// TODO Auto-generated method stub

	}

}
