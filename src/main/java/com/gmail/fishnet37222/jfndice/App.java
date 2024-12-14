/*
 * Copyright (c) 2024 David A. Frischknecht
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 */

package com.gmail.fishnet37222.jfndice;

import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class App
{
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
		       UnsupportedLookAndFeelException e)
		{
			Logger.getLogger(App.class.getName()).warning(e.getMessage());
		}
		
		SwingUtilities.invokeLater(() -> new MainWindow().setVisible(true));
	}
}
