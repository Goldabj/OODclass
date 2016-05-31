import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MyFileIO {

	public static void main(String[] args) {
		Scanner scan = null;
		try {
			// Incorrect flie name -- need to learn paths for files;
			scan = new Scanner(new File("/FlileIOExample/src/textexample.txt"));
		} catch (FileNotFoundException exception) {
			// TODO Auto-generated catch-block stub.
			exception.printStackTrace();
		} 
		
		while(scan.hasNext()) {
			System.out.println(scan.next());
		}
		
		scan.close();
		

	}

}
