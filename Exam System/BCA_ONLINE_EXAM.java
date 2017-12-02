/*
 * @(#)BCA_ONLINE_EXAM.java 1.0 15/06/17
 *
 * You can modify the template of this file in the
 * directory ..\JCreator\Templates\Template_1\Project_Name.java
 *
 * You can also create your own project template by making a new
 * folder in the directory ..\JCreator\Template\. Use the other
 * templates as examples.
 *
 */
package myprojects.bca_online_exam;

import java.awt.*;
import java.awt.event.*;

class BCA_ONLINE_EXAM extends Frame {
	
	public BCA_ONLINE_EXAM() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}

	public static void main(String args[]) {
		System.out.println("Starting BCA_ONLINE_EXAM...");
		BCA_ONLINE_EXAM mainFrame = new BCA_ONLINE_EXAM();
		mainFrame.setSize(400, 400);
		mainFrame.setTitle("BCA_ONLINE_EXAM");
		mainFrame.setVisible(true);
	}
}
