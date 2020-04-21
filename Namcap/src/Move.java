import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class Move extends JPanel implements ActionListener, KeyListener
{
	Timer t = new Timer(5, this);
	int x = 0, y = 0, velx = 0, vely;
	BufferedImage image;
	
	public Move()
	{
		t.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
		BufferedImage img = null;
		JFileChooser fc = new JFileChooser();
		//fc.setCurrentDirectory(new);
		int result = fc.showOpenDialog(this);
		File file = fc.getSelectedFile();
		
		try {
			img = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("FUCK");
		}	
		System.out.println("Selected file: " + file.getAbsolutePath());
		image = img;
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g.create();
		
		g2.drawImage(image, x, y, this);
		
		
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
		vely = -1;
		velx = 0;
		//t.wait(250);
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
			double start = y;
			while (start+50 != y)
				down();
			stop();
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
		//stop();
		//System.out.println("x: " + x + " y: " + y);
	}
}
