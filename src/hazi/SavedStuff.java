package hazi;

import java.io.Serializable;

public class SavedStuff implements Serializable {
	private static final long serialVersionUID = 1L;

	Block[][] bl;
	Ant ant;
 private int sqr;
	String code;
	
	SavedStuff(Block[][] b,  Ant a, int s, String c) {
		bl=b;
		ant=a;	
		setSqr(s);
		code=c;
	}

	public int getSqr() {
		return sqr;
	}

	public void setSqr(int sqr) {
		this.sqr = sqr;
	}
}
