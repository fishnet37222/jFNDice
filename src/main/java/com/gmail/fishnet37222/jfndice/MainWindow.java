/*
 * Copyright (c) 2024 David A. Frischknecht
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 */

package com.gmail.fishnet37222.jfndice;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class MainWindow extends JFrame
{
	private final ArrayList<JDie> m_dice = new ArrayList<>();
	
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
		
		var pnlCenterOuter = new JPanel(new BorderLayout());
		pnlCenterOuter.add(Box.createRigidArea(new Dimension(5,5)), BorderLayout.PAGE_START);
		
		var pnlCenterInner = new JPanel(new GridBagLayout());
		
		var pnlDice = new JPanel(new GridBagLayout());
		
		var die = new JDie();
		m_dice.add(die);
		var gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		pnlDice.add(die, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		pnlDice.add(Box.createRigidArea(new Dimension(5,5)), gbc);
		
		die = new JDie();
		m_dice.add(die);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 0;
		pnlDice.add(die, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 0;
		pnlDice.add(Box.createRigidArea(new Dimension(5,5)), gbc);
		
		die = new JDie();
		m_dice.add(die);
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 0;
		pnlDice.add(die, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 5;
		gbc.gridy = 0;
		pnlDice.add(Box.createRigidArea(new Dimension(5,5)), gbc);
		
		die = new JDie();
		m_dice.add(die);
		gbc = new GridBagConstraints();
		gbc.gridx = 6;
		gbc.gridy = 0;
		pnlDice.add(die, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 7;
		gbc.gridy = 0;
		pnlDice.add(Box.createRigidArea(new Dimension(5,5)), gbc);
		
		die = new JDie();
		m_dice.add(die);
		gbc = new GridBagConstraints();
		gbc.gridx = 8;
		gbc.gridy = 0;
		pnlDice.add(die, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		pnlDice.add(Box.createRigidArea(new Dimension(5,5)), gbc);
		
		var btnRollDice = new JButton("Roll Dice");
		btnRollDice.addActionListener(_ -> MainWindow.this.btnRollDice_OnClick());
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 9;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		pnlDice.add(btnRollDice, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		pnlCenterInner.add(pnlDice, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		pnlCenterInner.add(Box.createRigidArea(new Dimension(5,5)), gbc);
		
		var pnlScores = new JPanel(new GridLayout(1, 2, 5, 5));
		var bgScores = new ButtonGroup();
		
		var pnlScoresUpper = new JPanel(new GridBagLayout());
		
		var rbAces = new JRadioButton();
		bgScores.add(rbAces);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		pnlScoresUpper.add(rbAces, gbc);
		
		var lblAces = new JLabel("Aces");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		pnlScoresUpper.add(lblAces, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 0;
		pnlScoresUpper.add(Box.createRigidArea(new Dimension(5,5)), gbc);
		
		var txtAces = new JTextField();
		txtAces.setEditable(false);
		txtAces.setHorizontalAlignment(SwingConstants.TRAILING);
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		pnlScoresUpper.add(txtAces, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		pnlScoresUpper.add(Box.createRigidArea(new Dimension(5,5)), gbc);
		
		var rbTwos = new JRadioButton();
		bgScores.add(rbTwos);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		pnlScoresUpper.add(rbTwos, gbc);
		
		var lblTwos = new JLabel("Twos");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		pnlScoresUpper.add(lblTwos, gbc);
		
		var txtTwos = new JTextField();
		txtTwos.setEditable(false);
		txtTwos.setHorizontalAlignment(SwingConstants.TRAILING);
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		pnlScoresUpper.add(txtTwos, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		pnlScoresUpper.add(Box.createRigidArea(new Dimension(5,5)), gbc);
		
		var rbThrees = new JRadioButton();
		bgScores.add(rbThrees);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.CENTER;
		pnlScoresUpper.add(rbThrees, gbc);
		
		var lblThrees = new JLabel("Threes");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_START;
		pnlScoresUpper.add(lblThrees, gbc);
		
		var txtThrees = new JTextField();
		txtThrees.setEditable(false);
		txtThrees.setHorizontalAlignment(SwingConstants.TRAILING);
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 4;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		pnlScoresUpper.add(txtThrees, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 5;
		pnlScoresUpper.add(Box.createRigidArea(new Dimension(5,5)), gbc);
		
		var rbFours = new JRadioButton();
		bgScores.add(rbFours);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.CENTER;
		pnlScoresUpper.add(rbFours, gbc);
		
		var lblFours = new JLabel("Fours");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.LINE_START;
		pnlScoresUpper.add(lblFours, gbc);
		
		var txtFours = new JTextField();
		txtFours.setEditable(false);
		txtFours.setHorizontalAlignment(SwingConstants.TRAILING);
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 6;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		pnlScoresUpper.add(txtFours, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 7;
		pnlScoresUpper.add(Box.createRigidArea(new Dimension(5,5)), gbc);
		
		var rbFives = new JRadioButton();
		bgScores.add(rbFives);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.anchor = GridBagConstraints.CENTER;
		pnlScoresUpper.add(rbFives, gbc);
		
		var lblFives = new JLabel("Fives");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 8;
		gbc.anchor = GridBagConstraints.LINE_START;
		pnlScoresUpper.add(lblFives, gbc);
		
		var txtFives = new JTextField();
		txtFives.setEditable(false);
		txtFives.setHorizontalAlignment(SwingConstants.TRAILING);
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 8;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		pnlScoresUpper.add(txtFives, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 9;
		pnlScoresUpper.add(Box.createRigidArea(new Dimension(5,5)), gbc);
		
		var rbSixes = new JRadioButton();
		bgScores.add(rbSixes);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 10;
		gbc.anchor = GridBagConstraints.CENTER;
		pnlScoresUpper.add(rbSixes, gbc);
		
		var lblSixes = new JLabel("Sixes");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 10;
		gbc.anchor = GridBagConstraints.LINE_START;
		pnlScoresUpper.add(lblSixes, gbc);
		
		var txtSixes = new JTextField();
		txtSixes.setEditable(false);
		txtSixes.setHorizontalAlignment(SwingConstants.TRAILING);
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 10;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		pnlScoresUpper.add(txtSixes, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 11;
		pnlScoresUpper.add(Box.createRigidArea(new Dimension(5,5)), gbc);
		
		var rbBonus = new JRadioButton();
		rbBonus.setVisible(false);
		rbBonus.setSelected(true);
		bgScores.add(rbBonus);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 12;
		gbc.anchor = GridBagConstraints.CENTER;
		pnlScoresUpper.add(rbBonus, gbc);
		
		var lblBonus = new JLabel("Bonus");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 12;
		gbc.anchor = GridBagConstraints.LINE_START;
		pnlScoresUpper.add(lblBonus, gbc);
		
		var txtBonus = new JTextField();
		txtBonus.setEditable(false);
		txtBonus.setHorizontalAlignment(SwingConstants.TRAILING);
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 12;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		pnlScoresUpper.add(txtBonus, gbc);
		
		pnlScores.add(pnlScoresUpper);
		
		var pnlScoresLower = new JPanel(new GridBagLayout());
		
		var rbThreeKind = new JRadioButton();
		bgScores.add(rbThreeKind);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		pnlScoresLower.add(rbThreeKind, gbc);
		
		var lblThreeKind = new JLabel("3 of a Kind");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		pnlScoresLower.add(lblThreeKind, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 0;
		pnlScoresLower.add(Box.createRigidArea(new Dimension(5,5)), gbc);
		
		var txtThreeKind = new JTextField();
		txtThreeKind.setEditable(false);
		txtThreeKind.setHorizontalAlignment(SwingConstants.TRAILING);
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		pnlScoresLower.add(txtThreeKind, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		pnlScoresLower.add(Box.createRigidArea(new Dimension(5,5)), gbc);
		
		var rbFourKind = new JRadioButton();
		bgScores.add(rbFourKind);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		pnlScoresLower.add(rbFourKind, gbc);
		
		var lblFourKind = new JLabel("4 of a Kind");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		pnlScoresLower.add(lblFourKind, gbc);
		
		var txtFourKind = new JTextField();
		txtFourKind.setEditable(false);
		txtFourKind.setHorizontalAlignment(SwingConstants.TRAILING);
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		pnlScoresLower.add(txtFourKind, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		pnlScoresLower.add(Box.createRigidArea(new Dimension(5,5)), gbc);
		
		var rbFullHouse = new JRadioButton();
		bgScores.add(rbFullHouse);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.CENTER;
		pnlScoresLower.add(rbFullHouse, gbc);
		
		var lblFullHouse = new JLabel("Full House");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_START;
		pnlScoresLower.add(lblFullHouse, gbc);
		
		var txtFullHouse = new JTextField();
		txtFullHouse.setEditable(false);
		txtFullHouse.setHorizontalAlignment(SwingConstants.TRAILING);
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 4;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		pnlScoresLower.add(txtFullHouse, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 5;
		pnlScoresLower.add(Box.createRigidArea(new Dimension(5,5)), gbc);
		
		var rbSmallStraight = new JRadioButton();
		bgScores.add(rbSmallStraight);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.CENTER;
		pnlScoresLower.add(rbSmallStraight, gbc);
		
		var lblSmallStraight = new JLabel("Small Straight");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.LINE_START;
		pnlScoresLower.add(lblSmallStraight, gbc);
		
		var txtSmallStraight = new JTextField();
		txtSmallStraight.setEditable(false);
		txtSmallStraight.setHorizontalAlignment(SwingConstants.TRAILING);
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 6;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		pnlScoresLower.add(txtSmallStraight, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 7;
		pnlScoresLower.add(Box.createRigidArea(new Dimension(5,5)), gbc);
		
		var rbLargeStraight = new JRadioButton();
		bgScores.add(rbLargeStraight);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.anchor = GridBagConstraints.CENTER;
		pnlScoresLower.add(rbLargeStraight, gbc);
		
		var lblLargeStraight = new JLabel("Large Straight");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 8;
		gbc.anchor = GridBagConstraints.LINE_START;
		pnlScoresLower.add(lblLargeStraight, gbc);
		
		var txtLargeStraight = new JTextField();
		txtLargeStraight.setEditable(false);
		txtLargeStraight.setHorizontalAlignment(SwingConstants.TRAILING);
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 8;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		pnlScoresLower.add(txtLargeStraight, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 9;
		pnlScoresLower.add(Box.createRigidArea(new Dimension(5,5)), gbc);
		
		var rbFNDice = new JRadioButton();
		bgScores.add(rbFNDice);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 10;
		gbc.anchor = GridBagConstraints.CENTER;
		pnlScoresLower.add(rbFNDice, gbc);
		
		var lblFNDice = new JLabel("FNDice");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 10;
		gbc.anchor = GridBagConstraints.LINE_START;
		pnlScoresLower.add(lblFNDice, gbc);
		
		var txtFNDice = new JTextField();
		txtFNDice.setEditable(false);
		txtFNDice.setHorizontalAlignment(SwingConstants.TRAILING);
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 10;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		pnlScoresLower.add(txtFNDice, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 11;
		pnlScoresLower.add(Box.createRigidArea(new Dimension(5,5)), gbc);
		
		var rbChance = new JRadioButton();
		bgScores.add(rbChance);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 12;
		gbc.anchor = GridBagConstraints.CENTER;
		pnlScoresLower.add(rbChance, gbc);
		
		var lblChance = new JLabel("Chance");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 12;
		gbc.anchor = GridBagConstraints.LINE_START;
		pnlScoresLower.add(lblChance, gbc);
		
		var txtChance = new JTextField();
		txtChance.setEditable(false);
		txtChance.setHorizontalAlignment(SwingConstants.TRAILING);
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 12;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		pnlScoresLower.add(txtChance, gbc);
		
		pnlScores.add(pnlScoresLower);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		pnlCenterInner.add(pnlScores, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		pnlCenterInner.add(Box.createRigidArea(new Dimension(5,5)), gbc);
		
		var btnEndTurn = new JButton("End Turn");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		pnlCenterInner.add(btnEndTurn, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		pnlCenterInner.add(Box.createRigidArea(new Dimension(5,5)), gbc);
		
		var pnlTotals = new JPanel(new GridBagLayout());
		
		var lblUpperTotal = new JLabel("Upper Total");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		pnlTotals.add(lblUpperTotal, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		pnlTotals.add(Box.createRigidArea(new Dimension(5,5)), gbc);
		
		var lblLowerTotal = new JLabel("Lower Total");
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		pnlTotals.add(lblLowerTotal, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 0;
		pnlTotals.add(Box.createRigidArea(new Dimension(5,5)), gbc);
		
		var lblGrandTotal = new JLabel("Grand Total");
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		pnlTotals.add(lblGrandTotal, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		pnlTotals.add(Box.createRigidArea(new Dimension(5,5)), gbc);
		
		var txtUpperTotal = new JTextField();
		txtUpperTotal.setEditable(false);
		txtUpperTotal.setHorizontalAlignment(SwingConstants.TRAILING);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		pnlTotals.add(txtUpperTotal, gbc);
		
		var txtLowerTotal = new JTextField();
		txtLowerTotal.setEditable(false);
		txtLowerTotal.setHorizontalAlignment(SwingConstants.TRAILING);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		pnlTotals.add(txtLowerTotal, gbc);
		
		var txtGrandTotal = new JTextField();
		txtGrandTotal.setEditable(false);
		txtGrandTotal.setHorizontalAlignment(SwingConstants.TRAILING);
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 2;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		pnlTotals.add(txtGrandTotal, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		pnlCenterInner.add(pnlTotals, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 6;
		pnlTotals.add(Box.createRigidArea(new Dimension(5,5)), gbc);
		
		pnlCenterOuter.add(pnlCenterInner, BorderLayout.CENTER);
		
		pnlCenterOuter.add(Box.createRigidArea(new Dimension(5,5)), BorderLayout.PAGE_END);
		add(pnlCenterOuter, BorderLayout.CENTER);
		
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
	
	private void btnRollDice_OnClick()
	{
		for (var die : m_dice)
		{
			if (!die.isSelected())
			{
				die.roll();
			}
		}
	}
	
	private void windowClosing()
	{
		dispose();
	}
}
