package junittest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import org.junit.Assert;
import org.junit.Test;
import hazi.Grid;
import hazi.SavedStuff;

public class LoadTest {

	@Test
	public void sqrTest() {
		Grid g=new Grid(3000);
		SavedStuff ss;
		try {
			FileInputStream fileIn = new FileInputStream("testfile2000.ser");
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
		
		if (ss.getSqr() != g.numSqr) {
			g=new Grid(ss.getSqr());
		}
		
		Assert.assertTrue("Nem sikerült a blokkszám változtatása.", g.numSqr==2000);
	}
}
