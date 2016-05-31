import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Absolutely no need to understand this code.
 * 
 * @author wilkin
 *
 */
public class DataTracker {
	private ArrayList<String> updates;
	private ArrayList<String> webpages;
	private String pending;
	private Lock dataLock;
	
	public DataTracker() {
		this.updates = new ArrayList<String>();
		this.webpages = new ArrayList<String>();
		this.dataLock = new ReentrantLock();
		
	}
	
	public boolean isEmpty() {
		boolean retVal = true;
		boolean gotVal = false;
		while(!gotVal) {
			try {
				this.dataLock.lock();
				retVal = this.updates.size() == 0;
				gotVal = true;
			} finally {
				this.dataLock.unlock();
			}
		}
		return retVal;
	}
	
	public void add(String toBeAdded) {
		boolean added = false;
		while (!added) {
			try {
				this.dataLock.lock();
				this.updates.add(toBeAdded);
				added = true;
			} finally {
				this.dataLock.unlock();
			}
		}
	}
	
	public String take() {
		String result = "";
		while (result.equals("")) {
			try {
				this.dataLock.lock();
				result = this.updates.remove(0);
			} finally {
				this.dataLock.unlock();
			}
		}
		this.pending = result;
		return result;
	}
	
	public String doDownload() {
		this.webpages.add(this.pending);	
		return this.pending;
	}

}
