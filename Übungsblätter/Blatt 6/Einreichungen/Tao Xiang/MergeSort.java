
public class MergeSort {
	private static void merge(int[] a,int left,int right)
	{
		if((right-left)>=1)
		{
			int mid =(left+right)/2;
			int[] neu=new int[a.length];
			int p1=left,p2=mid+1;
			
			for(int index=left;index<a.length;index++)
			{
				if(p1>mid)
				{
					while(p2<=right)
					{
						neu[index++]=a[p2++];
					}
					break;
				}
			    if(p2>right)
				{
					while(p1<=mid)
					{
						neu[index++]=a[p1++];
					}break;
				}
				if(p1<=mid&&p2<=right)
				{
					if(a[p1]>=a[p2])
					{
						neu[index]=a[p2++];
					}
					else
					{
						neu[index]=a[p1++];
					}
				}
				 
				
			}
			for(int i=left;i<=right;i++)
			{
				a[i]=neu[i];
			}
		}
	}
	public static int[] mergeSortIt(int[] a)
	{
		for(int length=2;true;length*=2)
		{
			if(length<a.length)
			{
				int i=0;
				while(i+length-1<a.length)
				{
					merge(a,i,i+length-1);
					i+=length;
				}
				merge(a,i,a.length-1);
				
			}
			else {
				int mid=-1;
				for(int i=0;i<a.length;i++)
				{
					if(a[i]>a[i+1])
					{
						mid=i;
						break;
					}
				}
				int[] neu=new int[a.length];
				int p1=0,p2=mid+1,right=a.length-1;
				for(int index=0;index<a.length;index++)
				{
					if(p1<=mid&&p2<=right)
					{
						if(a[p1]>=a[p2])
						{
							neu[index]=a[p2++];
						}
						else
						{
							neu[index]=a[p1++];
						}
					}
					else if(p1>mid)
					{
						neu[index]=a[p2++];
					}
					else if(p2>right)
					{
						neu[index]=a[p1++];
					}
				}
				for(int i=0;i<a.length;i++)
				{
					a[i]=neu[i];
				}break;
				
			}
		}
		return a;
	}
	
	public static void main(String[] args) {
	 int a[]=new int[] {5,3,8,4,3,6,2};
	 MergeSort.mergeSortIt(a);
	 boolean testpassed =true;
	 int muster[]=new int[] {2,3,3,4,5,6,8};
	 for(int i=0;i<a.length;i++)
	 {
		 if(a[i]!=muster[i])
		 {
			 testpassed =false;
			 break;
		 }
	 }
	 if(testpassed) System.out.println("test passed");
	 else System.out.println("test failed");
	 }
}