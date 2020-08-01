package hazi;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class restartClicked implements MouseListener{
	App f;

	restartClicked(App fr) {
	f=fr;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		f.jatek.setUp();
		f.jatek.repaint();
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
