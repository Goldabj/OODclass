import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Absolutely no need to understand this code.
 * 
 * @author wilkin
 *
 */
class UpdaterGUI {
	private ArrayList<WebpageMonitor> monitors;
	private ArrayList<String> pages;
	private JTextArea textArea;
	private String forward = "<WEBPAGE CONTENT START>\n";
	private String after = "<WEBPAGE CONTENT END>\n";
	
	public UpdaterGUI() {
		monitors = new ArrayList<WebpageMonitor>();
		textArea = new JTextArea();
		pages = new ArrayList<String>();
	}
	
	public void registerMonitor(WebpageMonitor wm) {
		monitors.add(wm);
	}
	
	private class UpdateListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			String temp = textArea.getText();
			if(!temp.equals("")) {
				//addToRandom(temp);
				addText(temp);
				
				textArea.setText("");
			}
		}
	}
	
	private void addText(String toAdd) {
		for(int i = 0; i < monitors.size(); i++) {
			//System.out.println("Adding to " + i);
			monitors.get(i).getTracker().add(forward + toAdd + "\n<ID" + i + ">\n" + after);
		}
	}
	private void addToRandom(String toAdd) {
		double rand = Math.random();
		int randVal = (int) rand * monitors.size();
		monitors.get(randVal).getTracker().add(forward + toAdd + "\n<ID" + randVal + ">\n" + after);
	}
	
	public void add(String s) {
		this.pages.add(s);
	}
	
	public String getCollectedPageContent() {
		String result = "";
		for(int i = 0; i < pages.size(); i++) {
			result += pages.get(i);
		}
		return result;
	}
	
	public void makeWindow() {
		final JFrame frame = new JFrame("Updater");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("Enter text to update");
		frame.add(label, BorderLayout.NORTH);
		
		
		textArea.setPreferredSize(new Dimension(150,70));
		frame.add(textArea, BorderLayout.SOUTH);
		
		JPanel bigPanel = new JPanel();
		//JPanel nextPanel = new JPanel();
		
		JButton button = new JButton("Update All");
		button.addActionListener(new UpdateListener());
		bigPanel.add(button);
		
		
		//bigPanel.add(nextPanel);
		frame.add(bigPanel);
		
		
		frame.setPreferredSize(new Dimension(500,200));
		frame.pack();
		frame.setVisible(true);
	}
}