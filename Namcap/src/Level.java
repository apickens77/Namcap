import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Level extends JPanel implements KeyListener, ActionListener
{
	Timer t = new Timer(5, this);
	private JFrame window = new JFrame();
	private ImageIcon bg = new ImageIcon("C:\\Users\\Adam Pickens\\git\\Namcap\\Namcap\\src\\images\\background.jpg");
	private Player player = new Player(3, 10, 10, "C:\\Users\\Adam Pickens\\git\\Namcap\\Namcap\\src\\images\\ghost.jpg", true);
	private PacMove pacman = new PacMove(3, 10, 10, "C:\\Users\\Adam Pickens\\git\\Namcap\\Namcap\\src\\images\\ghost.jpg", true);
	private int speed = 10;
	private int xSpeed = speed;
	private int ySpeed = speed;
	
	public Level()
	{
		this.setFocusable(true);
		this.addKeyListener(this);
		window.add(this);
		
		window.setSize(512,512);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		t.start();
	}
	
	public void paint(Graphics g)
	{
		g.drawImage(bg.getImage(), 0, 0, null);
		//player.drawPlayer(g);
		pacman.drawPacman(g);
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			player.setxAxis(player.getxAxis()+speed);
			this.repaint();
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			player.setxAxis(player.getxAxis()-speed);
			this.repaint();
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			player.setyAxis(player.getyAxis()-speed);
			this.repaint();
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			player.setyAxis(player.getyAxis()+speed);
			this.repaint();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (pacman.getxAxis() == pacman.getxDest())
			xSpeed = 0;
		else if(pacman.getxAxis() < pacman.getxDest())
			xSpeed = speed;
		else if(pacman.getxAxis() > pacman.getxDest())
			xSpeed = -speed;
		
		if (pacman.getyAxis() == pacman.getyDest())
			ySpeed = 0;
		else if(pacman.getyAxis() < pacman.getyDest())
			ySpeed = speed;
		else if(pacman.getyAxis() > pacman.getyDest())
			ySpeed = -speed;
		
		
			
		pacman.setxAxis(pacman.getxAxis()+xSpeed);
		pacman.setyAxis(pacman.getyAxis()-ySpeed);
		this.repaint();
		
	}
}
