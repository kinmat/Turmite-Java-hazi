package hazi;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class loadClicked implements MouseListener {
	App f;

	loadClicked(App fr) {
		f = fr;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JFileChooser fileChooser = new JFileChooser();
		int result = fileChooser.showOpenDialog(f);
		File selectedFile = null;
		if (result == JFileChooser.APPROVE_OPTION) {
			selectedFile = fileChooser.getSelectedFile();
		}

		SavedStuff ss;
		try {
			FileInputStream fileIn = new FileInputStream(selectedFile);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			ss = (SavedStuff) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
			return;
		}

		if (ss.getSqr() != f.jatek.numSqr) {
			f.cont.remove(f.jatek);
			f.setUpGrid(ss.getSqr());
		}
		ss.ant.grid = f.jatek;
		f.jatek.blocks = ss.bl;
		f.jatek.ant=ss.ant;
		f.ant = ss.ant;
		f.program.setText(ss.code);
		f.jatek.getAnt().programmeAnt(ss.code);
		f.jatek.repaint();

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
