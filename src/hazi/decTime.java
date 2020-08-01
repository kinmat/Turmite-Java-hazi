package hazi;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class decTime implements MouseListener {
	App f;
	
	decTime(App fr) {
		f=fr;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		if(f.time>f.timeDif)	{
		f.stopTimer();
		f.startTimer(f.time-f.timeDif);
			
		}
			
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
