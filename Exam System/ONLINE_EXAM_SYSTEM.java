/*
 * @(#)ONLINE_EXAM_SYSTEM.java 1.0 14/05/11
 *
 * You can modify the template of this file in the
 * directory ..\JCreator\Templates\Template_1\Project_Name.java
 *
 * You can also create your own project template by making a new
 * folder in the directory ..\JCreator\Template\. Use the other
 * templates as examples.
 *
 */
package myprojects.online_exam_system;

import java.awt.*;
import java.awt.event.*;

class ONLINE_EXAM_SYSTEM extends Frame {
	
	public ONLINE_EXAM_SYSTEM() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}

	public static void main(String args[]) {
		System.out.println("Starting ONLINE_EXAM_SYSTEM...");
		ONLINE_EXAM_SYSTEM mainFrame = new ONLINE_EXAM_SYSTEM();
		mainFrame.setSize(400, 400);
		mainFrame.setTitle("ONLINE_EXAM_SYSTEM");
		mainFrame.setVisible(true);
	}
}
