package hazi;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class saveClicked implements MouseListener  {
App f;

	saveClicked(App fr) {
	f=fr;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		SavedStuff ss= new SavedStuff(f.jatek.blocks, f.jatek.getAnt(), f.jatek.numSqr, f.program.getText());
		Calendar calendar = Calendar.getInstance(); 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String nev=formatter.format(calendar.getTime())+".ser";
		File uj=new File(nev);
		try {
		FileOutputStream f = new FileOutputStream(uj);
		ObjectOutputStream out =
		new ObjectOutputStream(f);
		out.writeObject(ss);
		out.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		f.valasz.setText("<html><body>Saved file as: <br>" + nev + "</body></html>");
		

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

