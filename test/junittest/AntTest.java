package junittest;

import java.awt.Rectangle;

import org.junit.Assert;
import org.junit.Test;
import hazi.Ant;
import hazi.App;
import hazi.Grid;

public class AntTest {

	@Test
	public void commandLengthTest() {
		Ant ant = new Ant();
		ant.programmeAnt("1-1-L-0-1\n1-0-R-1-1");
		int l = ant.getCmnd().length;
		Assert.assertTrue("Nem jól olvassa be az input hosszát.", l == 2);
	}

	@Test
	public void commandTest() {
		Ant ant = new Ant();
		ant.programmeAnt("1-1-L-0-1\n1-0-R-1-1");
		Integer[] c1 = new Integer[] { 1, 1, 270, 0, 1 };
		Integer[] c2 = new Integer[] { 1, 0, 90, 1, 1 };
		boolean correct = true;
		for (int i = 0; i < 4; i++) {
			int curr1 = ant.getCmnd()[0].getArray()[i];
			int curr2 = ant.getCmnd()[1].getArray()[i];
			if (c1[i] != curr1 || c2[i] != curr2) {
				correct = false;
				break;
			}
		}
		Assert.assertTrue("Nem jól olvassa be az inputot", correct);
	}
	
	@Test
	public void stepTest() {
		App a=new App("Test");
		a.jatek=new Grid(2000);
		a.jatek.getAnt().setXY(15, 15);
		a.jatek.getAnt().programmeAnt("0-1-L-0-0\n0-0-R-1-0");
		int sqrSide = (int) Math.sqrt(2000);
		int sqrWidth = 800 / sqrSide;
		int sqrHeight = 600 / sqrSide;
		for (int j = 0, ynum = 0; j < 600 && ynum < sqrSide; j += sqrHeight, ynum++)
			for (int i = 0, xnum = 0; i < 800 && xnum < sqrSide; i += sqrWidth, xnum++)
				a.jatek.blocks[xnum][ynum].rect = new Rectangle(i, j, sqrWidth, sqrHeight);
		a.jatek.getAnt().setBlock(a.jatek.blocks[15][15]);	
		a.jatek.getAnt().step();
		Assert.assertTrue("Nem jól lép a hangya", a.jatek.getAnt().getX()==16&&a.jatek.getAnt().getY()==15);
		
	}

}
