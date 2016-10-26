import java.text.DecimalFormat;
import java.util.Scanner;

public class aout {
    public static void main(String[] args){
	//input is 12 lines ; line is closing balance for month;
	// number is positive and displayed to the penny (2 digits)
	// no dollar sign
	Scanner in = new Scanner(System.in);
	double average = 0;
	for(int i = 0; i < 12; i++) {
	    average += in.nextDouble(); // sum of 12 months
	}
	average /= 12; // divided by 12 months
	

	DecimalFormat df = new DecimalFormat("$##.00"); //00 ensures two digits after decimal will be printed
	System.out.println(df.format(average));
	

	//output is the average of balances rounded to nearest penny
	// with dollar sign 
    }
}

