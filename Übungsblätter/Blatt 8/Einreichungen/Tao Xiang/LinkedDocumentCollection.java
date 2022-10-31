import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A Collection of {@link LinkedDocument}s.
 * 
 * This class ensures, that only {@link LinkedDocument}s are added to this
 * collection.
 * 
 * @author
 *
 */
public class LinkedDocumentCollection extends DocumentCollection {

  /**
   * Empty constructor that just utilizes constructor of super class.
   */
  public LinkedDocumentCollection() {
    super();
  }

  /**
   * The specified {@link Document} is added to this collection only if it is of
   * type {@link LinkedDocument} and if it is not already contained.
   * 
   * @param doc the document to add
   */
  public void prependDocument(LinkedDocument doc) {
    if (!(this.contains(doc))) {
      super.prependDocument(doc);
    }
  }

  /**
   * The specified {@link Document} is added to this collection only if it is of
   * type {@link LinkedDocument} and if it is not already contained.
   * 
   * @param doc the document to add
   */
  @Override
  public void appendDocument(Document doc) {
    if ((doc instanceof LinkedDocument) && !(this.contains(doc))) {
      super.appendDocument(doc);
    }
  }

  /**
   * Private helper method that crawls this collection.
   * 
   * This method adds all LinkedDocuments of this collection to the specified
   * {@link LinkedDocumentCollection}, if they are not already contained.
   * Additionally, this method recursively crawls all outgoing links of all
   * {@link LinkedDocument}s of this collection.
   * 
   * @param resultCollection in and out parameter. All LinkedDocuments are
   *                         (recursively) added to this
   *                         {@link LinkedDocumentCollection}.
   */
  private void crawl(LinkedDocumentCollection resultCollection) {
    if (this.numDocuments() == 0) {
      return;
    }

    /*
     * loop over all documents of this collection and add them to the in/out
     * parameter, if not already contained.
     */
    for (int i = 0; i < this.numDocuments(); i++) {
      LinkedDocument doc = (LinkedDocument) this.get(i);

      if (!resultCollection.contains(doc)) {
        resultCollection.appendDocument(doc);

        /* do the same recursively */
        doc.getOutgoingLinks(resultCollection).crawl(resultCollection);
      }
    }
  }

  /**
   * This method crawls this {@link LinkedDocumentCollection} and returns a new
   * {@link LinkedDocumentCollection}.
   * 
   * The returned LinkedDocumentCollection contains all LinkedDocuments of this
   * LinkedDocumentCollection plus any LinkedDocuments that the LinkedDocuments of
   * this collection link to. If these additional LinkedDocuments again link to
   * other LinkedDocuments they will be included as well, and so on.
   * 
   * @return a {@link LinkedDocumentCollection} that contains all
   *         {@link LinkedDocument}s of this collection plus any
   *         {@link LinkedDocument}s that are linked either directly or
   *         indirectly.
   */
  public LinkedDocumentCollection crawl() {
    /* prepare the resulting collection and begin crawling ... */
    LinkedDocumentCollection resultCollection = new LinkedDocumentCollection();
    this.crawl(resultCollection);
    return resultCollection;
  }

  /**
   * This method calculates all incoming links for every {@link LinkedDocument} in
   * this collection. The incoming links are assigned to every LinkedDocument via
   * the {@link LinkedDocument#addIncomingLink(LinkedDocument)} method.
   */
  public void calculateIncomingLinks() {
    /* loop over all documents in this collection */
    for (int i = 0; i < this.numDocuments(); i++) {
      LinkedDocument doc = (LinkedDocument) this.get(i);

      /* again, loop over all documents of this collection */
      for (int j = 0; j < this.numDocuments(); j++) {
        LinkedDocument incomingDoc = (LinkedDocument) this.get(j);

        /*
         * Check if doc is contained in the outgoing links of incomingDoc. If so, add to
         * incoming links of doc.
         */
        if (incomingDoc.getOutgoingLinks().contains(doc)) {
          doc.addIncomingLink(incomingDoc);
        }
      }
    }
  }

  /**
   * Returns a string representation of this {@link LinkedDocumentCollection}
   * using the IDs of the {@link LinkedDocument}s.
   * 
   * @return a string representation of this collection
   */
  public String toString() {
    if (this.numDocuments() == 0) {
      return "[]";
    }

    if (this.numDocuments() == 1) {
      return "[" + ((LinkedDocument) this.get(0)).getID() + "]";
    }

    String res = "[";
    for (int i = 0; i < this.numDocuments() - 1; i++) {
      res += ((LinkedDocument) this.get(i)).getID() + ", ";
    }
    res += ((LinkedDocument) this.get(this.numDocuments() - 1)).getID() + "]";
    return res;
  }

  /**
   * Finds a {@link LinkedDocument} with the given id 
   * if contained in this {@link LinkedDocumentCollection}
   * 
   * @param id           the id to be looked up
   * @return the found {@link LinkedDocument} or null
   */
  public LinkedDocument findByID(String id) {
    for (int i = 0; i < this.numDocuments(); i++)
      if (((LinkedDocument) this.get(i)).getID().equals(id))
        return ((LinkedDocument) this.get(i));
    return null;
  }
  private int[][] übergangsmatrix()
  {
	  int[][] ret=new int[this.numDocuments()][this.numDocuments()];
	  for(int j=0;j<this.numDocuments();j++)
	  {
		  for(int i=0;i<this.numDocuments();i++)
		  {
			  if(((LinkedDocument)(this.get(j))).getOutgoingLinks()==null)
			  {
				  while(i<this.numDocuments())
				  {
					  if(i!=j)
					  ret[i][j]=1;
					  i++;
				  }
				  break;
			  }
			  if(((LinkedDocument)(this.get(j))).getOutgoingLinks().contains(this.get(i)))
			  {
				  ret[i][j]=1;
			  }
		  }
	  }
	  return ret;
  }
  /*private void addIncomminglinks()
  {
	 
	  for(int i=0;i<this.numDocuments();i++)
	  {
		  LinkedDocumentCollection out=((LinkedDocument)this.get(i)).getOutgoingLinks();
		  if( out!=null)
		  {
			  for(int j=0;j< out.numDocuments();j++)
			  {
				  ((LinkedDocument)out.get(j)).addIncomingLink(((LinkedDocument)this.get(i)));
			  }
		  }
	  }
  }*/
 
   private double[] PR;
   private int[][]C;
   

   private  double summe(int index)
   {
	   C=this.übergangsmatrix();
	   double summe=0;
	   for(int k=0;k<this.numDocuments();k++)
	   {
		   summe+=C[k][index];
	   }
	   //System.out.println("summe:"+summe);
	  // System.out.println("prj/summe:"+PR[index]/summe);
	   return PR[index]/summe;
   }
   
  
  private double[] doPageRank(double d)
  {
	  C=this.übergangsmatrix();
	  //this.addIncomminglinks();
	  double n=this.numDocuments();
	  if(PR==null)
	  {
		  PR=new double[(int) n];
		  for(int i=0;i<this.numDocuments();i++)
		  {
			  PR[i]=1/n;
		  }
		  return PR;
	  }
	  for(int i=0;i<n;i++)//pri
	  {
		  double tmp=0;
		  //System.out.println("pr"+i);
		  for(int j=0;j<n;j++)
		  {
			  
			  if(C[i][j]==1)
			  {
				  tmp+=this.summe(j);
			  }
		  }
		  //System.out.println("d*tmp:"+d*tmp);
		  PR[i]=((1-d)/n)+(d*tmp);
		  //System.out.println("(1-d)/n"+(1-d)/n);
		  //System.out.println("pri:"+PR[i]);
	  }
	  return PR;
	  
  }
  public double PageRankRec(int[][] C,int i,double d,int recDepth)
  {
	  this.C=C;
	  recDepth=recDepth+1;
	  if(recDepth>0) 
	  {
		  this.doPageRank(d);
		  recDepth--;
		  this.PageRankRec(C, i, d, recDepth-1);
	  }
	  return PR[i];
	  
  }   
  private boolean pageranked=false;
  public double[] pageRankRec(double d)
  {
	  if(pageranked) return PR;
	  
	  
	  int depth=0;
	  double tmp1=0;
	  double tmp2=0;
	  for(int i=0;i<this.numDocuments();i++)
	  {
		  do
	    {
			  depth++;
		  double[] tmp3= new double[this.numDocuments()]; 
		  for(int i1=0;i1<this.numDocuments();i1++)
		  {
			  tmp3[i1]=1/(double)this.numDocuments();
		  }
		  PR=tmp3;
		  tmp1=this.PageRankRec(this.übergangsmatrix(), i, d, depth);
		  double[] tmp4= new double[this.numDocuments()]; 
		  for(int i1=0;i1<this.numDocuments();i1++)
		  {
			  tmp4[i1]=1/(double)this.numDocuments();
		  }
		  PR=tmp4;
		  tmp2=this.PageRankRec(this.übergangsmatrix(), i, d, depth+1);
	    }
		  while(Math.abs(tmp1-tmp2)>0.000001);
		  
		  if(i!=this.numDocuments()-1)
		  depth--;
	  }
	  pageranked=true;
	  return PR;
	  
  }
  private static double dotProduct(double[] vector1, double[] vector2) {
	    double sum = 0;
	    int n = vector1.length;
	    for (int i = 0; i < n; i++)
	      sum += vector1[i] * vector2[i];
	    return sum;
	  }
  private static double[] multiply(double[][] matrix, double[] vector) {
	    int n = matrix.length;
	    double[] resultVector = new double[n];
	    for (int i = 0; i < n; i++)
	      resultVector[i] = dotProduct(matrix[i], vector);
	    return resultVector;
	  }
  private double[][] übergangsmatrix2 ()
  {
	  double[][] ret= new double[this.numDocuments()][this.numDocuments()];
	  for(int j=0;j<this.numDocuments();j++)
	  {
		  for(int i=0;i<this.numDocuments();i++)
		  {
			  if(((LinkedDocument)(this.get(j))).getOutgoingLinks()==null)
			  {
				  while(i<this.numDocuments())
				  {
					  if(i!=j)
					  ret[i][j]=1.0/(double)(this.numDocuments())-1.0;
					  i++;
				  }
				  break;
			  }
			  if(((LinkedDocument)(this.get(j))).getOutgoingLinks().contains(this.get(i)))
			  {
				  ret[i][j]=1.0/(double)((LinkedDocument)(this.get(j))).getOutgoingLinks().numDocuments();
			  }
		  }
	  }
	  return ret;
  }
  private static double[][] multiply(double[][] matrix1,double[][] matrix2)
  {
	  int n1=matrix1[0].length;
	  double[][] ret=new double[n1][n1];
	  for(int i=0;i<n1;i++)
	  {
		  for(int j=0;j<n1;j++)
		  {
			  for(int k=0;k<n1;k++)
			  ret[i][j]+=matrix1[i][k]*matrix2[k][j];
		  }
	  }
	  return ret;
  }
  private static double[][] potenzMatrix(double[][] matrix,int potenz)
  {
	  double[][] ret=matrix;
	  for(int i=1;i<potenz;i++)
	  {
		  ret=multiply(ret, matrix);
	  }
	  return ret;
  }
 /* private  double kardinalität(double[] vector1) {
	    int n = vector1.length;
	    double sum = 0.0;
	    for (int i = 0; i < n; i++)
	      sum += Math.pow(vector1[i], 2);
	    return Math.sqrt(sum);
	  }
  private double[] sub(double[] vector1,double[] vector2)
  {
	  double[] ret=new double[vector1.length];
	  for(int i=0;i<vector1.length;i++)
	  {
		  ret[i]=vector1[i]-vector2[i];
	  }
	  return ret;
  }*/
   public double[] pageRank(double dampingFactor)
   {
	   double[][] A=this.übergangsmatrix2();
	   double d=dampingFactor;
	   double n=this.numDocuments();
	   double[][] M=new double[(int) n][(int) n];
	   double[] v= new double[(int)n];
	   for(int i=0;i<n;i++)
	   {
		   v[i]=1/n;
	   }
	   for(int i=0;i<n;i++)
	   {
		   for(int j=0;j<n;j++)
		   {
			   M[i][j]=d*A[i][j]+(1-d)/n;
		   }
	   }
	   int k=1;
	   for(int i=0;i<n;i++)
	   {
	       while(Math.abs(multiply(potenzMatrix(M, k+1), v)[i]-multiply(potenzMatrix(M, k), v)[i])>0.000001)
	       {
	    	   k++;
	       }
	    	   
	   }
	   v=multiply( potenzMatrix(M, k+1),v);
	   return v;
   }
  
   private double[] sortByRelevance(double dampingFactor,double weightingFactor)
   {
	   double[] ret=new double[this.numDocuments()];
	   for(int i=0;i<this.numDocuments();i++)
	   {
		   ret[i]=this.getQuerySimilarity(i)*weightingFactor+(1.0-weightingFactor)*this.pageRank(dampingFactor)[i];
	   }
	   
	   for(int i=0;i<this.numDocuments()-1;i++)
	   {
		   int indexofmax=i;
		   for(int j=i+1;j<this.numDocuments();j++)
		   {
			   if(ret[indexofmax]<ret[j]) indexofmax=j;
		   }
		   this.swap(this.getDocumentCollectionCell(i), this.getDocumentCollectionCell(indexofmax));
		   double tmp=ret[i];
		   ret[i]=ret[indexofmax];
		   ret[indexofmax]=tmp;
	   }
	   return ret;
   }
   public double[] doSortByRelevance(double dampingFactor,double weightingFactor)
   {
	   return this.sortByRelevance(dampingFactor, weightingFactor);
   }
  public static void main(String[] args)
  {
	  LinkedDocument a=new LinkedDocument("aa.txt","","",null,null,"link:b.txt link:c.txt","aa.txt");
	  LinkedDocumentCollection b=new LinkedDocumentCollection ();
	  b.appendDocument(a);
	  LinkedDocumentCollection c=b.crawl();
	 
	  
	  //System.out.println(c.numDocuments());
	  //for(int[] tmp:c.übergangsmatrix())
	  //System.out.println(Arrays.toString(tmp));
	  //System.out.println(((LinkedDocument)c.get(1)).getOutgoingLinks().contains(((LinkedDocument)b.get(0))));
	  //System.out.println(((LinkedDocument)c.get(0)).outgoingIDs[0]);
	  //System.out.println(c.get(0).getTitle());
	  //System.out.println(c.PR);
	  //System.out.println(c.getIndexofLinkedDocument((LinkedDocument)((c.get(2)))));
	  //c.addIncomminglinks();
	 // System.out.println(((LinkedDocument)c.get(0)).getOutgoingLinks().get(1).getTitle());
	  //System.out.println(((LinkedDocument)c.get(2)).getIncomingLinks().get(0).getTitle());
	  //System.out.println(c.PageRankRec(c.übergangsmatrix(), 1, 0.85, 1200));
	  //for(double[] tmp:c.übergangsmatrix2())
		  //System.out.println(Arrays.toString(tmp));
	  //System.out.println(Arrays.toString(c.pageRank(0.85)));
	  c.match("link");
	  //System.out.println(Arrays.toString(c.sortByRelevance(0.85, 0.6)));
	  //System.out.println(c.get(1).getTitle());
	  
	  
	  
	  
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

}
