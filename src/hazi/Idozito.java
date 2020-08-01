package hazi;
import java.util.TimerTask;

public class Idozito extends TimerTask {
	Ant ant;
	App fr;
	
	
	public Idozito(Ant a, App f) {
		ant=a;
		fr=f;
	}
	public void run()
	{
		try {
		ant.step();
		} catch(ArrayIndexOutOfBoundsException e) {
			fr.stopTimer();
		}
	}

}
