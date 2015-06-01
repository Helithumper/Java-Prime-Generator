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

	static Scanner scan = new Scanner(System.in);
	static PrintWriter writer;
	static File file = new File("exported-primes.txt");
	static TimeClass tc = new TimeClass();
	static Thread thread = new Thread(new TimeClass());
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter start number: ");
		int start = scan.nextInt();
		System.out.println("Enter end number: ");
		int end = scan.nextInt();
		int var = start;
		
		try {
			FileWriter fileWriter = new FileWriter(file); //Appends File
		      writer = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
		} catch (UnsupportedEncodingException | FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tc.setValues(end-start, start);
		thread.start();
		while(var<=end){ //main thread
			if(isPrime(var)){
				//System.out.println(var);
				writer.println(var);
			}
			var++;
			tc.setCurrentValue(var);
		}
		System.out.println("Finished after " + tc.getTime() + " seconds");
		System.exit(0);
	}
	
	private static boolean isPrime(int variable){
		for(int x = 2; x<variable; x++){
			if(variable%x==0){
				return false;
			}
		}
		return true;
	}

}
