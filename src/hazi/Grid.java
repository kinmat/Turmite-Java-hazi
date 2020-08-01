package hazi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.Serializable;

import javax.swing.JPanel;

public class Grid extends JPanel implements Serializable {
	private static final long serialVersionUID = 2L;
	public int numSqr;
	public Block[][] blocks;
	int sqrSide;
	transient int sqrWidth;
	transient int sqrHeight;
	Ant ant;

	public Grid(int num) {
		numSqr = num;
		ant = new Ant();
		ant.setGrid(this);
		sqrSide = (int) Math.sqrt(numSqr);
		blocks = new Block[sqrSide][sqrSide];
		for (int i = 0; i < sqrSide; i++)
			for (int j = 0; j < sqrSide; j++) {
				blocks[i][j] = new Block();
			}
		setUp();
	}

	public void setUp() {
		ant.x = ant.y = sqrSide / 2;
		ant.direction = 0;
		ant.state = 0;
		for (int i = 0; i < sqrSide; i++)
			for (int j = 0; j < sqrSide; j++) {
				blocks[i][j].state = 0;
			}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		sqrWidth = (this.getWidth()) / sqrSide;
		sqrHeight = (this.getHeight()) / sqrSide;
		for (int j = 0, ynum = 0; j < (this.getHeight()) && ynum < sqrSide; j += sqrHeight, ynum++)
			for (int i = 0, xnum = 0; i < (this.getWidth()) && xnum < sqrSide; i += sqrWidth, xnum++)
				blocks[xnum][ynum].rect = new Rectangle(i, j, sqrWidth, sqrHeight);

		ant.setBlock(blocks[ant.x][ant.y]);

		for (int i = 0; i < sqrSide; i++)
			for (int j = 0; j < sqrSide; j++) {
				if (blocks[i][j].state == 1) {
					g.setColor(Color.BLACK);
					g.fillRect(blocks[i][j].rect.x, blocks[i][j].rect.y, blocks[i][j].rect.width,
							blocks[i][j].rect.height);
				}

				if (ant.rect.equals(blocks[i][j].rect)) {
					g.setColor(Color.red);
					g.fillRect(ant.rect.x, ant.rect.y, ant.rect.width, ant.rect.height);
				}

				g.setColor(Color.BLACK);
				g.drawRect(blocks[i][j].rect.x, blocks[i][j].rect.y, blocks[i][j].rect.width, blocks[i][j].rect.height);
			}
	}
	
	public Ant getAnt() {
		return ant;
	}

}
