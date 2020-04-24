//https://stackoverflow.com/questions/11367324/how-do-i-scale-a-bufferedimage

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class PlayerMove extends JPanel implements ActionListener, KeyListener
{
	Timer t = new Timer(5, this);
	int x = 0, y = 0, velx = 0, vely;
	BufferedImage image;
	
	int upLim, downLim, leftLim, rightLim;
	
	public PlayerMove()
	{
		//t.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
		
		try {
			image = ImageIO.read(new File("C:\\Users\\Adam Pickens\\git\\Namcap\\Namcap\\src\\images\\ghost.jpg"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		image = getScaledImage(image, 40, 40);
		
		/*Timer t = new Timer(5, new ActionListener() 
		{
			@Overide
			public void actionPerformed(ActionEvent e)
			{
				x += velx;
				y += vely;
				repaint();
			}
		});*/
		t.start();
		
	}
	
	private BufferedImage getScaledImage(Image srcImg, int w, int h)
	{
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
	    Graphics2D g2 = resizedImg.createGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();
	    return resizedImg;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g.create();
		
		g2.drawImage(image, x, y, this);
		
		//upLim = y+20;
		
		//g2.fill(new Ellipse2D.Double(x, y, 40, 40));
	}
	
	public void actionPerformed(ActionEvent e)
	{
		repaint();
		x += velx;
		y += vely;
	}
	
	public void up()
	{
		if (y >= 0)
		{
			vely = -1;
			velx = 0;
		}
		else
			stop();
		
	}
	
	public void down()
	{
		vely = 1;
		velx = 0;
	}
	
	public void left()
	{
		velx = -1;
		vely = 0;
	}
	
	public void right()
	{
		velx = 1;
		vely = 0;
	}
	
	public void stop()
	{
		velx = 0;
		vely = 0;
	}
	
	public void keyPressed(KeyEvent e) 
	{
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_UP)
		{
			up();
			
		}
		if (code == KeyEvent.VK_DOWN)
		{
			down();
		}
		if (code == KeyEvent.VK_LEFT)
		{
			left();
		}
		if (code == KeyEvent.VK_RIGHT)
		{
			right(); 
		}
	}
	
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) 
	{
		stop();
	}
}
