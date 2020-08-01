package hazi;

import java.awt.Rectangle;
import java.io.Serializable;
import java.util.StringTokenizer;


public class Ant extends Block implements Serializable {
	private static final long serialVersionUID = -7182758649842304484L;
	int direction;
	Grid grid;
	Block current;
	int x;
	int y;
	Command cmnd[];

	public Ant() {
		direction = 0;
		state = 0;
	}
	
	public void setXY( int x, int y)
	{
		this.x=x;
		this.y=y;
	}

	public Command[] getCmnd() {
		return cmnd;
	}

	public void setCmnd(Command[] c) {
		cmnd = c;
	}

	public void setRect(Rectangle rec) {
		rect = new Rectangle(rec);
	}

	public void setGrid(Grid g) {
		grid = g;
	}

	public void setBlock(Block b) {
		current = b;
		setRect(current.rect);
	}

	public int programmeAnt(String cmd) {
		int db = 0;
		String[] lines = new String[4];
		StringTokenizer text = new StringTokenizer(cmd, "\n");
		while (text.hasMoreTokens()) {
			lines[db] = new String(text.nextToken());
			System.out.println(lines[db]);
			db++;
		}

		if (db == 0)
			return 0;
		cmnd = new Command[db];

		for (int j = 0; j < db; j++) {
			StringTokenizer one = new StringTokenizer(lines[j], "-");
			cmnd[j] = new Command();
			if (one.hasMoreTokens())
				cmnd[j].antState = Integer.parseInt(one.nextToken());
			if (one.hasMoreTokens())
				cmnd[j].blState = Integer.parseInt(one.nextToken());
			if (one.hasMoreTokens()) {
				String ch = one.nextToken();
				if (ch.equals("R") || ch.equals("r"))
					cmnd[j].dir = 90;
				else if (ch.equals("L") || ch.equals("l"))
					cmnd[j].dir = 270;
				else if (ch.equals("N") || ch.equals("n"))
					cmnd[j].dir = 0;
				else if (ch.equals("U") || ch.equals("u"))
					cmnd[j].dir = 180;
				else
					return 0;
			}
			if (one.hasMoreTokens())
				cmnd[j].blNext = Integer.parseInt(one.nextToken());
			if (one.hasMoreTokens())
				cmnd[j].antNext = Integer.parseInt(one.nextToken());

		}

		for (int j = 0; j < db; j++)
			cmnd[j].setArray();

		if (checkProg() == true)
			return 1;
		return 2;
	}

	public void step() {
		for (int i = 0; i < cmnd.length; i++) {
			if (state == cmnd[i].antState && current.state == cmnd[i].blState) {
				state = cmnd[i].antNext;
				direction += cmnd[i].dir;
				current.state = cmnd[i].blNext;
				break;
			}
		}
		direction = direction % 360;
		if (direction == 0) {
			setBlock(grid.blocks[x][y - 1]);
			y -= 1;
		} else if (direction == 180) {
			setBlock(grid.blocks[x][y + 1]);
			y += 1;
		} else if (direction == 90) {
			setBlock(grid.blocks[1 + x][y]);
			x=x+1;
		} else if (direction == 270) {
			setBlock(grid.blocks[x - 1][y]);
			x=x-1;
		}
		grid.repaint();
	}

	public boolean checkProg() {
		for (int i = 0; i < cmnd.length; i++) {
			int j = 0;
			while (cmnd[i].antNext != cmnd[j].antState && cmnd[j].blState != cmnd[i].blNext && j != i
					&& j < cmnd.length)
				j++;
			if (j == cmnd.length)
				return false;
		}
		return true;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
