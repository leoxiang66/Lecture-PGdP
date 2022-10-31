

public class Primverquerung {

	 static public boolean isPrim(int m)  //static: so that we can test this methode in main function;
	 {
		 boolean isPrim=true;
		 for(int i=2;i<m;i++)             //testing if m has other factors in 2 to m-1;
		 {
	        switch(m%i)
	        {
	           case   0  : isPrim=false; break; //this means the number m has other factors except 1 and 
	                                            // itself.So its not a prim number.	           
	        }
	         
		 }
		 return isPrim;
	 }
	 static public int[] primsLessThanN (int n)
	 {
		 int[] primslessthanN = new int[n];//firstly I wanna put all the prims less than N into an array
		 primslessthanN[0]=1;
		 int j = 0;                    //j is the index of the new array.
		 for(int i=2;i<n-1;i++)
		 {
			 
			 if(isPrim(i))
			 {
				 primslessthanN[++j]=i;
			 }
		 }
		 return primslessthanN;
	 }
	 static public boolean QuersummeIstgerade(int N)
	 {
		 boolean quersummeistgerade = false;
		 String NtoString = String.valueOf(N);             //convert int N to String N
		 char[] NtoCharArray =NtoString.toCharArray();     // convert String N to CharArray N
		 int[] NtoIntArray = new int[NtoCharArray.length];  //convert CharArray N to int array N
		 for(int i=0;i<NtoCharArray.length;i++)
		 {
			 NtoIntArray[i]=Character.getNumericValue(NtoCharArray[i]);
		 }
		 int[] n= NtoIntArray; //for easier typing...
		 int quersumme = 0;
		 for(int i=0;i<n.length;i++)
		 {
			 quersumme += n[i];
		 }
		 if(quersumme%2==0)     
		 {
			 quersummeistgerade = true;
		 }
		 return quersummeistgerade;
	 }
	  
	 //endlich kommt die Methode querprim...
	 public static int querPrim(int n)
	 {
		 int summe=0;
		 int[] querPrim = primsLessThanN(n);//first all the prims less then n;
		 for(int i=0;i<querPrim.length;i++)
		 {
			 if(QuersummeIstgerade(querPrim[i])==false)//if the prim is not even,set it to 0;
			 {
				 querPrim[i]=0;
			 }
		 }
		 for(int i=0;i<querPrim.length;i++)// add all;
		 {
			 summe += querPrim[i];
		 }
		 return summe;
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
