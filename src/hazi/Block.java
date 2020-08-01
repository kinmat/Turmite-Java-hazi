package hazi;

import java.awt.Rectangle;
import java.io.Serializable;

public class Block implements Serializable {
	private static final long serialVersionUID = 1234567;
	int state;
	public Rectangle rect;

	public void switchState() {
		if (state == 0)
			state = 1;
		else
			state = 0;
	}

}
