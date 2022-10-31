/**
 * TestIt-Klasse.
 */
public class TestIt {
  /**
   * Main-Methode
   * 
   * @param args Kommandozeilen-Argumente
   */
  public static void main(String[] args) {

    LinkedDocumentCollection ldc = new LinkedDocumentCollection();
    String command;

    boolean exit = false;

    while (!exit) {
      command = Terminal.askString("> ");

      if (command == null || command.equals("exit")) {
        /* Exit program */
        exit = true;
      } else if (command.startsWith("add ")) {
        /* add a new document */
        String titleAndText = command.substring(4);

        /* title and text separated by : */
        int separator = titleAndText.indexOf(':');
        String title = titleAndText.substring(0, separator);
        String text = titleAndText.substring(separator + 1);

        ldc.appendDocument(new LinkedDocument(title, "", "", null, null, text, title));
      } else if (command.startsWith("list")) {
        /* list all document in collection */
        for (int i = 0; i < ldc.numDocuments(); i++) {
          System.out.println(ldc.get(i).getTitle());
        }
      } else if (command.startsWith("query ")) {
        /* query on the documents in the collection */
        String query = command.substring(6);

        ldc.match(query);

        for (int i = 0; i < ldc.numDocuments(); i++) {
          System.out.println((i + 1) + ". " + ldc.get(i).getTitle() + "; Relevenz: " + ldc.doSortByRelevance(0.85, 0.6)[i]);
        }

        System.out.println();
      } else if (command.startsWith("count ")) {
        /* print the count of a word in each document */
        String word = command.substring(6);

        for (int i = 0; i < ldc.numDocuments(); i++) {
          Document doc = ldc.get(i);
          WordCountsArray docWordCounts = doc.getWordCounts();

          int count = docWordCounts.getCount(docWordCounts.getIndexOfWord(word));

          /* -1 and 0 makes a difference! */
          if (count == -1) {
            System.out.println(doc.getTitle() + ": gar nicht.");
          } else {
            System.out.println(doc.getTitle() + ": " + count + "x ");
          }
        }
      }
      else if(command.startsWith("pageRank"))
      {//add b.txt:link:a.txt link:e.txt
    	  for(int i=0;i<ldc.numDocuments();i++)
    	  {
    		  System.out.println(ldc.get(i).getTitle()+"; PageRank: "+ldc.pageRank(0.85)[i]);
    	  }
      }
      
      else if (command.startsWith("crawl")) {
        ldc = ldc.crawl();
      }
    }
  }
}
/*
 * erste Dateienstruktur
 * a.txt
 * link:b.txt
 * 
 * b.txt
 * link:c.txt
 * 
 * c.txt
 * link:d.txt
 * 
 * d.txt
 * link:e.txt
 * 
 * e.txt
 * link:a.txt
 * 
> add a.txt:link:b.txt
> crawl
> pageRank
a.txt; PageRank: 0.20000000000000004
b.txt; PageRank: 0.20000000000000004
c.txt; PageRank: 0.2
d.txt; PageRank: 0.2
e.txt; PageRank: 0.2
> query txt
1. a.txt; Relevenz: 0.08000000000000002
2. b.txt; Relevenz: 0.08000000000000002
3. c.txt; Relevenz: 0.08000000000000002
4. d.txt; Relevenz: 0.08000000000000002
5. e.txt; Relevenz: 0.08000000000000002

> exit



zweite Dateienstruktur
a.txt
link:b.txt

b.txt
link:c.txt

c.txt
link:d.txt

d.txt
link:e.txt link:c.txt

e.txt
link:a.txt link:c.txt


> add a.txt:link:b.txt
> crawl
> pageRank
a.txt; PageRank: 0.09789212504169931
b.txt; PageRank: 0.11320871945808034
c.txt; PageRank: 0.32386610856412085
d.txt; PageRank: 0.30528610535459444
e.txt; PageRank: 0.1597469415815063
> query :
1. a.txt; Relevenz: 0.12954644342564833
2. d.txt; Relevenz: 0.12211853739400594
3. e.txt; Relevenz: 0.0638967360340427
4. b.txt; Relevenz: 0.04528376603189416
5. a.txt; Relevenz: 0.03915744589665271

> exit


















 * 
 * 
 * 
 * 
 * 
 * 
 */

