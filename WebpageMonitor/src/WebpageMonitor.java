
public class WebpageMonitor{
	private DataTracker data;
	private UpdaterGUI updater;
	private String url;
	
	public WebpageMonitor(UpdaterGUI updater, String url) {
		this.data = new DataTracker();
		this.updater = updater;
		this.updater.registerMonitor(this);
		this.url = url;
	}
	
	public DataTracker getTracker() {
		return data;
	}

	public String waitForUpdate() {
		while(data.isEmpty()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
		return data.take();
	}
	
	public void doDownload() {
		this.updater.add(data.doDownload());
	}
	
	public String getUrl() {
		return url;
	}
	
}
