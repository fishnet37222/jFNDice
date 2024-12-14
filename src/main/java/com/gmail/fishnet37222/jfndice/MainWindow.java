/*
 * Copyright (c) 2024 David A. Frischknecht
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 */

package com.gmail.fishnet37222.jfndice;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;

public class MainWindow extends JFrame
{
	public MainWindow()
	{
		super("FNDice");
		var icons = new ArrayList<Image>();
		icons.add(new ImageIcon(Objects.requireNonNull(getClass().getResource("die16.png"))).getImage());
		icons.add(new ImageIcon(Objects.requireNonNull(getClass().getResource("die32.png"))).getImage());
		icons.add(new ImageIcon(Objects.requireNonNull(getClass().getResource("die64.png"))).getImage());
		icons.add(new ImageIcon(Objects.requireNonNull(getClass().getResource("die128.png"))).getImage());
		icons.add(new ImageIcon(Objects.requireNonNull(getClass().getResource("die256.png"))).getImage());
		setIconImages(icons);
		
		var toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setRollover(true);
		
		var btnNewGame = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("New24.gif"))));
		btnNewGame.setToolTipText("Start a new game.");
		toolBar.add(btnNewGame);
		
		var btnLoadGame = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("Open24.gif"))));
		btnLoadGame.setToolTipText("Load a saved game.");
		toolBar.add(btnLoadGame);
		
		var btnSaveGame = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("Save24.gif"))));
		btnSaveGame.setToolTipText("Save the current game.");
		btnSaveGame.setEnabled(false);
		toolBar.add(btnSaveGame);
		
		toolBar.addSeparator();
		
		var btnHighScores = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("History24.gif"))));
		btnHighScores.setToolTipText("View the high scores.");
		toolBar.add(btnHighScores);
		
		var btnPreferences = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("Preferences24.gif"))));
		btnPreferences.setToolTipText("View and change preferences.");
		toolBar.add(btnPreferences);
		
		toolBar.addSeparator();
		
		var btnHowToPlay = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("Help24.gif"))));
		btnHowToPlay.setToolTipText("How to play the game.");
		toolBar.add(btnHowToPlay);
		
		var btnAbout = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("About24.gif"))));
		btnAbout.setToolTipText("View the license and copyright information.");
		toolBar.add(btnAbout);
		
		add(toolBar, BorderLayout.PAGE_START);
		
		add(Box.createRigidArea(new Dimension(12,12)), BorderLayout.LINE_START);
		add(Box.createRigidArea(new Dimension(12,12)), BorderLayout.LINE_END);
		
		var statusBar = new JPanel();
		statusBar.setLayout(new GridLayout(1, 3, 5, 5));
		
		var sbpPlayer = new JLabel(" ");
		statusBar.add(sbpPlayer);
		
		var sbpCurrentRound = new JLabel(" ");
		statusBar.add(sbpCurrentRound);
		
		var sbpCurrentRoll = new JLabel(" ");
		statusBar.add(sbpCurrentRoll);
		
		add(statusBar, BorderLayout.PAGE_END);
		
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				MainWindow.this.windowClosing();
			}
		});
	}
	
	private void windowClosing()
	{
		dispose();
	}
}
