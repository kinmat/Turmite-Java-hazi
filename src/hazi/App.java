package hazi;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class App extends JFrame {
	Container cont;
	public Grid jatek;
	Timer timer;
	int time = 300;
	int timeDif = 100;
	int initSqr=3000;
	Ant ant;
	JTextArea program;
	JLabel valasz;

	public App(String s) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle(s);
		cont = this.getContentPane();
		cont.setLayout(new GridBagLayout());
		this.setPreferredSize(new Dimension(800, 605));

		GridBagConstraints c = new GridBagConstraints();

		program = new JTextArea(4, 9);
		c.fill = GridBagConstraints.NONE;
		program.setPreferredSize(new Dimension(4, 9));
		program.setMaximumSize(new Dimension(4, 9));
		program.setLineWrap(true);
		program.setWrapStyleWord(true);
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 3;
		c.weighty = 0;
		c.weightx = 0;
		c.gridwidth = 2;
		c.insets = new Insets(10, 10, 10, 10);
		cont.add(program, c);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		program.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));

		valasz = new JLabel("Input a code for the ant!");
		valasz.setForeground(Color.RED);
		c.fill = GridBagConstraints.VERTICAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 3;
		c.gridheight = 1;
		c.weighty = 0.5;
		c.weightx = 0;
		c.gridwidth = 2;
		c.anchor = GridBagConstraints.CENTER;

		cont.add(valasz, c);

		JButton beolvas = new JButton("Read");
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 4;
		c.weightx = 0;
		c.gridheight = 1;
		c.gridwidth = 2;
		c.weighty = 0.5;
		c.anchor = GridBagConstraints.CENTER;
		cont.add(beolvas, c);

		JButton load = new JButton("Load");
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.EAST;
		cont.add(load, c);

		JButton save = new JButton("Save");
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0;
		c.gridx = 1;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.EAST;
		cont.add(save, c);

		JButton slow = new JButton("<<");
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.EAST;
		cont.add(slow, c);

		JButton fast = new JButton(">>");
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0;
		c.gridx = 1;
		c.gridy = 6;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.EAST;
		cont.add(fast, c);

		JButton start = new JButton("Start");
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 7;
		c.gridheight = 1;
		c.gridwidth = 2;
		c.weighty = 0;
		c.anchor = GridBagConstraints.CENTER;
		cont.add(start, c);

		JButton stop = new JButton("Stop");
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 8;
		c.gridwidth = 2;
		c.gridheight = 1;
		cont.add(stop, c);

		JButton rest = new JButton("Restart");
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 9;
		c.gridwidth = 2;
		c.gridheight = 1;
		cont.add(rest, c);

		setUpGrid(initSqr);

		start.addMouseListener(new startClicked(this));
		stop.addMouseListener(new stopClicked(this));
		fast.addMouseListener(new decTime(this));
		slow.addMouseListener(new incTime(this));
		beolvas.addMouseListener(new readClicked(this));
		rest.addMouseListener(new restartClicked(this));
		load.addMouseListener(new loadClicked(this));
		save.addMouseListener(new saveClicked(this));
		jatek.addMouseListener(new blockClicked(jatek));

		this.setVisible(true);
		this.pack();

	}

	public void startTimer(int t) {
		time = t;
		timer = new Timer();
		TimerTask task = new Idozito(ant, this);
		timer.schedule(task, time, time);
	}

	public void stopTimer() {
		timer.cancel();
	}

	public void setUpGrid(int num) {
		GridBagConstraints c = new GridBagConstraints();
		jatek = new Grid(num);
		ant = jatek.ant;
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(10, 10, 10, 10);
		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth = 3;
		c.gridheight = 10;
		c.weightx = 1.0;
		cont.add(jatek, c);
	}

}
