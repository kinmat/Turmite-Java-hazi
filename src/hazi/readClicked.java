package hazi;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class readClicked implements MouseListener  {
App f;

	readClicked(App fr) {
	f=fr;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		String s=f.program.getText();
		try {
		if(f.ant.programmeAnt(s)==1) f.valasz.setText("Syntax is correct.");
		else if(f.ant.programmeAnt(s)==2) f.valasz.setText("Syntax is wrong.");
		else if(f.ant.programmeAnt(s)==0) f.valasz.setText("Input is wrong.");
		}
		catch (NumberFormatException e) 
		{
			//e.printStackTrace();
			 f.valasz.setText("Input is wrong.");
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
