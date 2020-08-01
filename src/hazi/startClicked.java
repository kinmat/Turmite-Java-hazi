package hazi;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class startClicked implements MouseListener {
	App f;
	
	startClicked(App fr) {
		f=fr;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		f.startTimer(f.time);
		
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
