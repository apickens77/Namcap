//https://stackoverflow.com/questions/11367324/how-do-i-scale-a-bufferedimage

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class PacMove extends JPanel implements ActionListener
{
	Timer t = new Timer(5, this);
	int x = 0, y = 0, velx = 0, vely;
	BufferedImage image;

	public PacMove()
	{
		t.start();
		//addKeyListener(this);
		setFocusable(true);
		
		try {
			image = ImageIO.read(new File("C:\\Users\\Adam Pickens\\git\\Namcap\\Namcap\\src\\images\\pacman.gif"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		image = getScaledImage(image, 40, 40);
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
	}
	
	public void moveHoriz(int x)
	{
		while (this.x != x)
		{
			if (this.x < x)
				x += 1;
			else
				x -=1;
		}
		//repaint();
			
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		System.out.println(x + " " + y);
		this.moveHoriz(40);
		repaint();
		
	}
}
