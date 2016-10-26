import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Problem2HolidayFinder {

    public static void main( String[] args)
    {
	SimpleDateFormat formatter=new SimpleDateFormat("EEEE, d MMM yyyy"); 
	int year = Integer.parseInt( args[0] );	 
	System.out.println("Labor Day: "+ formatter.format( getLaborDay(year).getTime() ) );
	System.out.println("Memorial Day: " + formatter.format( getMemorialDay(year).getTime() ) );
	System.out.println("Thanksgiving Day: "+  formatter.format(getThanksgivingDay(year).getTime() ) );
	System.out.println("Election Day: "+ formatter.format( getElectionDay(year).getTime() ) );
    }

   static Calendar getLaborDay(int n)
    {
	
	Calendar offset = new GregorianCalendar(n, Calendar.SEPTEMBER, 1);
	int dayFirstOfMonth = offset.get(Calendar.DAY_OF_WEEK);
	int firstMonday = 1;
	switch (dayFirstOfMonth) {
	case 1: firstMonday += 1; break;
	case 2: firstMonday += 0; break;
	case 3: firstMonday += 6; break;
	case 4: firstMonday += 5; break;
	case 5: firstMonday += 4; break;
	case 6: firstMonday += 3; break;
	case 7: firstMonday += 2; break;       	    
	}
	System.out.println("date in september forlaborday"  + firstMonday);
	return new GregorianCalendar(n, Calendar.SEPTEMBER, firstMonday);
    }
    
    static Calendar getMemorialDay(int n)
    {

	Calendar offset = new GregorianCalendar(n, Calendar.MAY, 31 );
	int dayLastOfMonth = offset.get(Calendar.DAY_OF_WEEK);
	int lastMonday = 31;
	switch (dayLastOfMonth) {
	case 1: lastMonday += 1; break;
	case 2: lastMonday += 0; break;
	case 3: lastMonday += -1; break;
	case 4: lastMonday += -2; break;
	case 5: lastMonday += -3; break;
	case 6: lastMonday += -4; break;
	case 7: lastMonday += -5; break;       	    
	}
	return  new GregorianCalendar(n, Calendar.MAY, lastMonday);	
	
    }

    static Calendar getThanksgivingDay(int n)
    {
	//4th thurs in nov
	//get first thursday
	Calendar offset = new GregorianCalendar(n, Calendar.NOVEMBER, 1);
	int dayFirstOfMonth = offset.get(Calendar.DAY_OF_WEEK);
	int fourthThursday = 1;

	switch (dayFirstOfMonth) {
	case 1: fourthThursday += 4; break;
	case 2: fourthThursday += 3; break;
	case 3: fourthThursday += 2; break;
	case 4: fourthThursday += 1; break;
	case 5: fourthThursday += 0; break;
	case 6: fourthThursday += 6; break;
	case 7: fourthThursday += 5; break;       	    
	}
	fourthThursday += 21; // 1st thurs. + 3rd thurs. will be the fourth thurs.
	return  new GregorianCalendar(n, Calendar.NOVEMBER, fourthThursday );	

    }
    
    static Calendar getElectionDay(int n)
    {
	//first tues. after 1st mon. in nov.
	int firstTuesAfterMonday = 0;
	//get 1st mon.in NOV
	Calendar date = new GregorianCalendar(n, Calendar.NOVEMBER, 1);
	int dayFirstOfMonth = date.get(Calendar.DAY_OF_WEEK);
	int firstMonday = 1;
	switch (dayFirstOfMonth) {
	case 1: firstMonday += 1; break;
	case 2: firstMonday += 0; break;
	case 3: firstMonday += 6; break;
	case 4: firstMonday += 5; break;
	case 5: firstMonday += 4; break;
	case 6: firstMonday += 3; break;
	case 7: firstMonday += 2; break;       	    
	}
   	//get first tuesday after first monday
	/*
	switch ( firstMonday) {
	case 1: firstTuesAfterMonday += 2; break;
	case 2: firstTuesAfterMonday += 1; break;
	case 3: firstTuesAfterMonday += 0; break;
	case 4: firstTuesAfterMonday += 6; break;
	case 5: firstTuesAfterMonday += 5; break;
	case 6: firstTuesAfterMonday += 4; break;
	case 7: firstTuesAfterMonday += 3; break;       	    
	} */
	firstTuesAfterMonday = firstMonday + 1;
	date = new GregorianCalendar(n, Calendar.NOVEMBER, firstTuesAfterMonday) ;
	return date;
       
    }
}
