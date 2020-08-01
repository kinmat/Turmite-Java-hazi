package hazi;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Main {

	public static void main(String[] args) {
		App app = new App("Turmeszek");

		app.setMinimumSize(new Dimension(400, 300));
		app.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent evt) {
				Dimension size = app.getSize();
				Dimension min = app.getMinimumSize();
				if (size.getWidth() < min.getWidth()) {
					app.setSize((int) min.getWidth(), (int) size.getHeight());
				}
				if (size.getHeight() < min.getHeight()) {
					app.setSize((int) size.getWidth(), (int) min.getHeight());
				}
			}
		});

	}
}
