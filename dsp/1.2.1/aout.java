import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class aout {
    public static void main(String[] args) {
	// one or more sets of unique  positive numbers
	// (2 to 15 numbers) range 1 to 99 inclusive
	// line is terminated with '0'
	// output is terminated wiht '-1'
	// some lists will not contain any doubles (0 doubles)

	Scanner in = new Scanner(System.in);
	Set<Integer> inputSet = new TreeSet();
	Set<Integer> doubledSet = new TreeSet();
	Set<Integer> unionSet = new TreeSet();
	List<Integer> outputList = new ArrayList();

	while ( in.hasNext() ) {  // start reading std in
	    int inputNum = in.nextInt();
	    if (inputNum == -1 ) //check for end of input
		break;
	    while (  inputNum != 0) { // read input array line until 0
		inputSet.add( inputNum );
		doubledSet.add( inputNum*2 );
	    }//end innerwhile 	    
	    // length of union of the two arrays is count of doubles
            unionSet = Collections.union(inputSet, doubledSet) ;
	    outputList.add( unionSet.size() ) ;
	}//end while scanner has next

	for( Integer n : outputList )
	    System.out.println(n);
    
	
    }//end main
    /*
    TreeSet union(Set<Integer> set2) {
	if 
	}
*/
}//end aout 
