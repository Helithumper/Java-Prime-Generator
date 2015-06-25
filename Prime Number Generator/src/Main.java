import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Scanner;


public class Main {

	private static Scanner scan = new Scanner(System.in);
	private static PrintWriter writer;
	private static FileWriter fileWriter;
	private static File file = new File("exported-primes.txt");
	private static TimeClass tc = new TimeClass();
	private static Thread thread = new Thread(new TimeClass());
	
	public static void main(String[] args) {
		
		System.out.println("Enter start number: ");
		int start = scan.nextInt();
		
		System.out.println("Enter end number: ");
		int end = scan.nextInt();
		
		int var = start;
		
		try {
			fileWriter = new FileWriter(file); //Appends File
			writer = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
		} catch (Exception e) {
			System.err.println("Error Code 01: An Error Has Occured in the Opening of the File");
			e.printStackTrace();
		}
		
		tc.setValues(end-start, start);
		thread.start();
		
		//Start of Main Loop
		while(var<=end){ //main thread
			if(isPrime(var)){
				//System.out.println(var);
				writer.println(var);
			}
			var++;
			tc.setCurrentValue(var);
		}
		//End of Main Loop
		
		System.out.println("Finished after " + tc.getTime() + " seconds");
		System.exit(0);
	}
	
	private static boolean isPrime(int testNum){
		for(int x = 2; x < testNum ; x++){
			if(testNum % x == 0){
				return false;
			}
		}
		return true;
	}

}
