package hazi;

import java.io.Serializable;


public class Command implements Serializable {
	private static final long serialVersionUID = 4568092206427666364L;
	int antState = 0;
	int blState = 0;
	int dir = 0;
	int blNext = 0;
	int antNext = 0;
	Integer[] inArray;

	Command() {

	}

	public Command(int aS, int bS, int d, int bN, int aN) {
		antState = aS;
		blState = bS;
		dir = d;
		blNext = bN;
		antNext = aN;
		inArray = new Integer[] { aS, bS, d, bN, aN };
	}

	public void setArray() {
		inArray = new Integer[] { antState, blState, dir, blNext, antNext };
	}

	public Integer[] getArray() {
		return inArray;
	}

}
