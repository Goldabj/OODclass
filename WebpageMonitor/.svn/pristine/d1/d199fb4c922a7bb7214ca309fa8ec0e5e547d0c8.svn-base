import java.util.Scanner;



public class WebpageMonitorMain {
	
//  For use with threads, use a queue to store Pair objects
//	private static class Pair {
//		public String update;
//		public WebpageMonitor monitor;
//	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		UpdaterGUI updater = new UpdaterGUI();
		updater.makeWindow();
		
		
		WebpageMonitor monitors[] = new WebpageMonitor[5];
		monitors[0] = new WebpageMonitor(updater, "http://google.com");
		monitors[1] = new WebpageMonitor(updater, "http://cnn.com");
		monitors[2] = new WebpageMonitor(updater, "http://reddit.com");
		monitors[3] = new WebpageMonitor(updater, "http://foxnews.com");
		monitors[4] = new WebpageMonitor(updater, "http://msnbc.com");
		
		while(true) {
			System.out.println("--------------------------------------------------");
			System.out.println("            Webpage Monitor");
			System.out.println("--------------------------------------------------");
			String updatedWebpage = monitors[0].waitForUpdate();
			if(userRequestsDownload(updatedWebpage, scanner)) {
				monitors[0].doDownload();
			}
			
			//updatedWebpage = monitors[1].waitForUpdate();
			//if(userRequestsDownload(updatedWebpage, scanner)) {
			//	monitors[1].doDownload();
			//}
			System.out.println("All local current content:");
			System.out.println(updater.getCollectedPageContent());
		}
		
		//scanner.close();
	}
	
	public static boolean userRequestsDownload(String update, Scanner scanner) {
		System.out.println(">>>>> Do you wish to keep the update:\n" + update);
		
		boolean allNum = false;
		
		while(!allNum) {
			System.out.println("1 for yes, 0 for no:\n<<<<< ");
			int input = scanner.nextInt();
			System.out.println("Thanks you");
			if (input == 0) {
				return false;
			} else if (input == 1) {
				return true;
			} else {
				System.out.println("Incorrect value entered!");
				allNum = false;
			}
		}
		return false;
	}
}

