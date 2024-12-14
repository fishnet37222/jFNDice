/*
 * Copyright (c) 2024 David A. Frischknecht
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 */

package com.gmail.fishnet37222.jfndice;

import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
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
