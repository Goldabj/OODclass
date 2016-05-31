import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class HighScores {

	// public static class add{

	@SuppressWarnings({ "resource", "null" })
	public static void addScore(int score) {
		File scores = new File("highScore.txt");
		PrintWriter writer = null;
		if (!scores.exists()) {
			try {
				writer = new PrintWriter("highScore.txt", "UTF-8");
				writer.println(score);
			} catch (FileNotFoundException exception) {
				// none
				exception.printStackTrace();
			} catch (UnsupportedEncodingException exception) {
				// none
				exception.printStackTrace();
			}
			finally{
				writer.close();
			}
		} else {
			try {
				writer = new PrintWriter(scores, "UTF-8");
				writer.println(score);
			} catch (FileNotFoundException exception) {
				// TODO Auto-generated catch-block stub.
				exception.printStackTrace();
			} catch (UnsupportedEncodingException exception) {
				// TODO Auto-generated catch-block stub.
				exception.printStackTrace();
			}finally{
				writer.close();
			}
		}
		try {
			Scanner in = new Scanner(scores);
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
	}

	@SuppressWarnings({ "resource", "boxing" })
	public static int topScore() {
		Scanner scan = null;
		try {
			scan = new Scanner(new File("highScore.txt"));
		} catch (FileNotFoundException exception) {
			// TODO Auto-generated catch-block stub.
			exception.printStackTrace();
		}
		ArrayList<Integer> scores = new ArrayList<>();
		if (scan != null) {
			while (scan.hasNextInt()) {
				scores.add(scan.nextInt());
			}
		}
		int top = 0;
		for (Integer sc : scores) {
			if (sc > top) {
				top = sc;
			}
		}
		return top;
	}
}
