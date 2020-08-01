package hazi;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class blockClicked implements MouseListener {
	Grid g;

	blockClicked(Grid gr) {
		g = gr;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Point p = e.getPoint();
		for (int i = 0; i < g.sqrSide; i++)
			for (int j = 0; j < g.sqrSide; j++)
				if (g.blocks[i][j].rect.contains(p))
					g.blocks[i][j].switchState();
		g.repaint();

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
