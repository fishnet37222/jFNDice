/*
 * Copyright (c) 2024 David A. Frischknecht
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 */

package com.gmail.fishnet37222.jfndice;

import java.awt.AWTEvent;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JComponent;

public class JDie extends JComponent
{
	private static final Random m_random = new Random();
	private int m_value;
	private Color m_selectedForeground = Color.WHITE;
	private Color m_selectedBackground = Color.BLACK;
	private Color m_disabledForeground = Color.DARK_GRAY;
	private Color m_disabledBackground = Color.LIGHT_GRAY;
	private boolean m_selected;
	private int m_pipDiameter = 25;
	private int m_pipSpacing = 5;
	private int m_borderThickness = 3;
	private int m_borderCornerRadius = 10;
	private Color m_borderColor = Color.BLACK;
	
	public JDie()
	{
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		enableEvents(AWTEvent.MOUSE_EVENT_MASK);
	}
	
	public void roll()
	{
		m_value = m_random.nextInt(6) + 1;
		repaint();
	}
	
	public void clear()
	{
		m_value = 0;
		m_selected = false;
		repaint();
	}
	
	public int getPipDiameter()
	{
		return m_pipDiameter;
	}
	
	public void setPipDiameter(int pipDiameter)
	{
		if (m_pipDiameter == pipDiameter)
		{
			return;
		}
		
		m_pipDiameter = pipDiameter;
		getParent().invalidate();
		repaint();
	}
	
	public int getPipSpacing()
	{
		return m_pipSpacing;
	}
	
	public void setPipSpacing(int pipSpacing)
	{
		if (m_pipSpacing == pipSpacing)
		{
			return;
		}
		
		m_pipSpacing = pipSpacing;
		getParent().invalidate();
		repaint();
	}
	
	public int getBorderThickness()
	{
		return m_borderThickness;
	}
	
	public void setBorderThickness(int borderThickness)
	{
		if (m_borderThickness == borderThickness)
		{
			return;
		}
		
		m_borderThickness = borderThickness;
		getParent().invalidate();
		repaint();
	}
	
	public int getBorderCornerRadius()
	{
		return m_borderCornerRadius;
	}
	
	public void setBorderCornerRadius(int borderCornerRadius)
	{
		if (m_borderCornerRadius == borderCornerRadius)
		{
			return;
		}
		
		m_borderCornerRadius = borderCornerRadius;
		repaint();
	}
	
	public Color getBorderColor()
	{
		return m_borderColor;
	}
	
	public void setBorderColor(Color borderColor)
	{
		if (m_borderColor == borderColor) return;
		
		m_borderColor = borderColor;
		repaint();
	}
	
	public int getValue()
	{
		return m_value;
	}
	
	public boolean isSelected()
	{
		return m_selected;
	}
	
	public Color getSelectedForeground()
	{
		return m_selectedForeground;
	}
	
	public void setSelectedForeground(Color selectedForeground)
	{
		if (m_selectedForeground == selectedForeground)
		{
			return;
		}
		
		m_selectedForeground = selectedForeground;
		repaint();
	}
	
	public Color getSelectedBackground()
	{
		return m_selectedBackground;
	}
	
	public void setSelectedBackground(Color selectedBackground)
	{
		if (m_selectedBackground == selectedBackground)
		{
			return;
		}
		
		m_selectedBackground = selectedBackground;
		repaint();
	}
	
	public Color getDisabledForeground()
	{
		return m_disabledForeground;
	}
	
	public void setDisabledForeground(Color disabledForeground)
	{
		if (m_disabledForeground == disabledForeground)
		{
			return;
		}
		
		m_disabledForeground = disabledForeground;
		repaint();
	}
	
	public Color getDisabledBackground()
	{
		return m_disabledBackground;
	}
	
	public void setDisabledBackground(Color disabledBackground)
	{
		if (m_disabledBackground == disabledBackground)
		{
			return;
		}
		
		m_disabledBackground = disabledBackground;
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		var g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2d.setColor(getParent().getBackground());
		g2d.fillRect(0, 0, getWidth(), getHeight());
		
		var bgColor = getBackground();
		var fgColor = getForeground();
		
		if (!isEnabled())
		{
			bgColor = m_disabledBackground;
			fgColor = m_disabledForeground;
		}
		else if (m_selected)
		{
			bgColor = m_selectedBackground;
			fgColor = m_selectedForeground;
		}
		
		g2d.setColor(bgColor);
		g2d.fillRoundRect(0, 0, getWidth(), getHeight(), m_borderCornerRadius * 2, m_borderCornerRadius * 2);
		
		g2d.setColor(m_borderColor);
		g2d.setStroke(new BasicStroke(m_borderThickness));
		g2d.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, m_borderCornerRadius * 2, m_borderCornerRadius * 2);
		
		g2d.setColor(fgColor);
		g2d.setStroke(new BasicStroke(1));
		
		if (m_value == 1 || m_value == 3 || m_value == 5)
		{
			g2d.fillOval(m_borderThickness + m_pipSpacing + m_pipDiameter + m_pipSpacing, m_borderThickness + m_pipSpacing + m_pipDiameter + m_pipSpacing, m_pipDiameter, m_pipDiameter);
		}
		
		if (m_value == 2 || m_value == 3 || m_value == 4 || m_value == 5 || m_value == 6)
		{
			g2d.fillOval(m_borderThickness + m_pipSpacing, m_borderThickness + m_pipSpacing, m_pipDiameter, m_pipDiameter);
			g2d.fillOval(m_borderThickness + m_pipSpacing + 2 * (m_pipDiameter + m_pipSpacing), m_borderThickness + m_pipSpacing + 2 * (m_pipDiameter + m_pipSpacing), m_pipDiameter, m_pipDiameter);
		}
		
		if (m_value == 4 || m_value == 5 || m_value == 6)
		{
			g2d.fillOval(m_borderThickness + m_pipSpacing + 2 * (m_pipDiameter + m_pipSpacing), m_borderThickness + m_pipSpacing, m_pipDiameter, m_pipDiameter);
			g2d.fillOval(m_borderThickness + m_pipSpacing, m_borderThickness + m_pipSpacing + 2 * (m_pipDiameter + m_pipSpacing), m_pipDiameter, m_pipDiameter);
		}
		
		if (m_value == 6)
		{
			g2d.fillOval(m_borderThickness + m_pipSpacing, m_borderThickness + m_pipSpacing + m_pipDiameter + m_pipSpacing, m_pipDiameter, m_pipDiameter);
			g2d.fillOval(m_borderThickness + m_pipSpacing + 2 * (m_pipDiameter + m_pipSpacing), m_borderThickness + m_pipSpacing + m_pipDiameter + m_pipSpacing, m_pipDiameter, m_pipDiameter);
		}
	}
	
	@Override
	public void processMouseEvent(MouseEvent e)
	{
		if (e.getID() == MouseEvent.MOUSE_CLICKED && isEnabled())
		{
			m_selected = !m_selected;
			repaint();
		}
	}
	
	@Override
	public Dimension getPreferredSize()
	{
		var dimension = m_borderThickness * 2 + m_pipSpacing * 4 + m_pipDiameter * 3;
		return new Dimension(dimension, dimension);
	}
	
	@Override
	public Dimension getMinimumSize()
	{
		return getPreferredSize();
	}
	
	@Override
	public Dimension getMaximumSize()
	{
		return getPreferredSize();
	}
}
