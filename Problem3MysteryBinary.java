import java.util.ArrayList;

public class Problem3MysteryBinary {

    static ArrayList<Integer> list1 = new ArrayList<>();
    static ArrayList<Integer> list2 = new ArrayList<>();    
    static int count = 0;
    
    public static void main(String[] args) {
	
        String[] elements = args[0].split("(?!^)");
	for(String input : elements)
	    list1.add( Integer.parseInt( input  ));    
	
	for( int i = 0; i < 5 ; i++) {
	    for(int j = 0; j < list1.size() ; j++) {
		if ( j+1 == list1.size() ){ 
		    workWith( j, true ); //last number true
		    break;
		}
		else if ( list1.get(j).intValue() == list1.get(j+1).intValue() )
		    count++;  
	        else 
		    workWith ( j, false ); //last num false
		
	    }//end inner for	    
	     System.out.println();
	}//end outer for  
    }//end main

    static void workWith( int numberAtIndex, boolean lastNumber  ) {
	count++;
	//System.out.println("\ndbg:\n*count++= " + count);
	list2.add(count);
	list2.add( list1.get(numberAtIndex) );

	//output to the row
        System.out.print(count);
	System.out.print(  list1.get(numberAtIndex) );
	//reset count
	count = 0;
	
	if (lastNumber){
	//reset count and  lists
	    list1 = new ArrayList<>( list2 );
	    list2.clear();
	    System.out.println();
	    count = 0;
	}
	
	
    }

    static void printList(int n){
	System.out.println("**list" + n+ "**");
	for(Integer k: (n==1?list1:list2)) System.out.print(k);
	System.out.println();
    }
}
