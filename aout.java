import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author max
 */

 class RankOrder extends ArrayList {
       List<Integer> judge1;
   List<Integer> judge2;
       
   public RankOrder(List<Integer> j1, List<Integer> j2) {
           judge1 = j1;
           judge2 = j2;         
       }
       
       int analyzeJudgeScores() {
           List<Integer> j1c, j2c;
           j1c = judge1;
           j2c = judge2;
           int count = 0;
           int maxIndex1 = -1, maxIndex2 = -1;

               //find list 1 max index
               for (int j =1; j<j1c.size(); j++) {
                   
                   maxIndex1 = ( j1c.get(j) < j1c.get(j-1) ) 
                        ? j-1
                        : j;                
               }
               
               //find list 2 max index
               for (int j =1; j<j1c.size(); j++) {
                   
                   maxIndex2 = ( j2c.get(j) < j2c.get(j-1) ) 
                        ? j-1
                        : j;                
               }
               
         if (maxIndex1 == maxIndex2) {
                j1c.remove(maxIndex1);
                j2c.remove(maxIndex2);                   
              }
           else //disagree return i 
               return Math.max(++maxIndex1, ++maxIndex2);                 
               
                   /*
           OptionalInt maxIndex1 = IntStream.range(0, j1c.size())
                   .reduce( (a,b)-> j1c.get(a) < j1c.get(b)? b:a ) ;
           
           OptionalInt maxIndex2 = IntStream.range(0, j2c.size())
                   .reduce( (a,b)-> j2c.get(a) < j2c.get(b)? b:a ) ;
           */
           //agree
       
           return -1;
       }
      
       public void sort(){
           Collections.sort(judge1);
           Collections.sort(judge2);
       }
       
       
 } //endRank Order

public class aout {
    // 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

    // Process input stream
    Scanner in = new Scanner(System.in);
    String inString = in.useDelimiter("\\A").next(); //read everything until EOF
    in = new Scanner(inString);
    //process  input string
    List<Integer> judge1 = new ArrayList<Integer>();
    List<Integer> judge2 = new ArrayList<Integer>();
    ArrayDeque<RankOrder> queue = new ArrayDeque();
    while (in.hasNext()) {
      int contestants = in.nextInt();
      for (int i = 0; i < contestants * 2; i++) {
        if (i < contestants) {
          judge1.add(in.nextInt());
        } else {
          judge2.add(in.nextInt());
        }
      }
      //Rank lists into a ScorePair object
      RankOrder ranks = new RankOrder(judge1, judge2);
      //store  in  queue of scorepairs
      queue.add(ranks);
    }//end while in.hasNext()
    //Process queue: store agreements as another queue (of ints)
    ArrayDeque<Integer> outputQueue = new ArrayDeque();
    for (RankOrder ranks : queue) {
      outputQueue.add(ranks.analyzeJudgeScores());
    }

    //Output queue
    for (Integer n : outputQueue) {
      if (n < 0)
        System.out.println("agree");
      else
        System.out.println(n);


    }

  }//endmain

    
}
