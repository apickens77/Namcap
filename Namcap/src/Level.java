import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Level extends JPanel implements KeyListener, ActionListener
{
	Timer t = new Timer(10, this);
	private JFrame window = new JFrame();
	private ImageIcon bg = new ImageIcon("C:\\Users\\Adam Pickens\\git\\Namcap\\Namcap\\src\\images\\map grid.png");
	private ImageIcon dot = new ImageIcon("C:\\Users\\Adam Pickens\\git\\Namcap\\Namcap\\src\\images\\dot.gif");
	private Player player = new Player(3, 400, 40, "C:\\Users\\Adam Pickens\\git\\Namcap\\Namcap\\src\\images\\ghost.jpg");
	private PacMove pacman = new PacMove(3, 40, 40, "C:\\Users\\Adam Pickens\\git\\Namcap\\Namcap\\src\\images\\pacman.gif", true);
	private int speed = 2;
	private int playerSpeed = 1;
	private int xSpeed = speed;
	private int ySpeed = speed;
	private int playerXSpeed = playerSpeed;
	private int playerYSpeed = playerSpeed;
	private Square tempPlayer;
	
	private Board boardPac; 
	
	public Level(Board b)
	{
		pacman.setxDest(pacman.getxAxis());
		pacman.setyDest(pacman.getyAxis());
		
		player.setxDest(player.getxAxis());
		player.setyDest(player.getyAxis());
		
		
		this.setFocusable(true);
		this.addKeyListener(this);
		window.setTitle("Nam-cap/Reverse Pac-man");
		window.add(this);
		
		boardPac = b;
		tempPlayer = boardPac.aiGhost0.location;
		
		window.setSize(new Dimension(498, 567));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		t.start();
	}
	
	public void paint(Graphics g)
	{
		g.drawImage(bg.getImage(), 0, 0, null);
		player.drawPlayer(g);
		pacman.drawPacman(g);
		
		
		
		for (int i = 0; i < boardPac.tiles.length; i++)
		{
			for (int j = 0; j < boardPac.tiles[i].length; j++)
			{
				if (boardPac.tiles[i][j].hasDot)
				{
					g.drawImage(dot.getImage(), boardPac.tiles[i][j].xPos+10, boardPac.tiles[i][j].yPos+10, null);
				}
			}
		}
		

	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			if (player.getxAxis() == player.getxDest() & player.getyAxis() == player.getyDest())
			{		
				tempPlayer = boardPac.aiGhost0.location.neighbors[1];
							
				if (tempPlayer != null)
				{
					player.setxDest(tempPlayer.xPos);
				
					for (int i = 0; i < 4; i++)
					{
						if (boardPac.aiGhost0.location.neighbors[i] != null)
							boardPac.aiGhost0.location.neighbors[i].ghostDanger = false;
					}
				}
			}
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			if (player.getxAxis() == player.getxDest() & player.getyAxis() == player.getyDest())
			{
				tempPlayer = boardPac.aiGhost0.location.neighbors[3];
				
				if (tempPlayer != null)
				{
					player.setxDest(tempPlayer.xPos);
				
					for (int i = 0; i < 4; i++)
					{
						if (boardPac.aiGhost0.location.neighbors[i] != null)
							boardPac.aiGhost0.location.neighbors[i].ghostDanger = false;
						
					}
				}
			}
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			if (player.getxAxis() == player.getxDest() & player.getyAxis() == player.getyDest())
			{
				tempPlayer = boardPac.aiGhost0.location.neighbors[0];
				
				if (tempPlayer != null)
				{
					player.setyDest(tempPlayer.yPos);
				
					for (int i = 0; i < 4; i++)
					{
						if (boardPac.aiGhost0.location.neighbors[i] != null)
							boardPac.aiGhost0.location.neighbors[i].ghostDanger = false;
						
					}
				}
			}
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			if (player.getxAxis() == player.getxDest() & player.getyAxis() == player.getyDest())
			{
				tempPlayer = boardPac.aiGhost0.location.neighbors[2];
				
				if (tempPlayer != null)
				{
					player.setyDest(tempPlayer.yPos);
				
					for (int i = 0; i < 4; i++)
					{
						if (boardPac.aiGhost0.location.neighbors[i] != null)
							boardPac.aiGhost0.location.neighbors[i].ghostDanger = false;
						
					}
				}
			}
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
		
		if (player.getxAxis() == player.getxDest())
			playerXSpeed = 0;
		else if(player.getxAxis() < player.getxDest())
			playerXSpeed = speed;
		else if(player.getxAxis() > player.getxDest())
			playerXSpeed = -speed;
		
		if (player.getyAxis() == player.getyDest())
			playerYSpeed = 0;
		else if(player.getyAxis() < player.getyDest())
			playerYSpeed = speed;
		else if(player.getyAxis() > player.getyDest())
			playerYSpeed = -speed;

		this.repaint();
		if (pacman.getxAxis() == pacman.getxDest() & pacman.getyAxis() == pacman.getyDest())
		{
			try {
				Square temp = boardPac.pacman.locateNearestDot().get(1);			
				pacman.setxDest(temp.xPos);
				pacman.setyDest(temp.yPos);
				boardPac.pacman.location = temp;
				boardPac.pacman.location.hasDot = false;
			} catch (Exception e1) {
				
			}
		}
		
		if (boardPac.aiGhost0.location != tempPlayer)
		{
			if (player.getxAxis() == player.getxDest() & player.getyAxis() == player.getyDest())
			{
				if (tempPlayer != null)
					boardPac.aiGhost0.setLocation(tempPlayer);
			}
		}
		
		if (boardPac.aiGhost0.location == boardPac.pacman.location)
		{
			int result = JOptionPane.showConfirmDialog(window, "You Win!");
			if (result == JOptionPane.OK_OPTION) 
				System.exit(0);
			
		}
		
		if (!boardPac.dotsRemain())
		{
			int result = JOptionPane.showConfirmDialog(window, "Pac-man Wins!");
			if (result == JOptionPane.OK_OPTION) 
				System.exit(0);
		}
		
		
		pacman.setxAxis(pacman.getxAxis()+xSpeed);
		pacman.setyAxis(pacman.getyAxis()+ySpeed);
		player.setxAxis(player.getxAxis()+playerXSpeed);
		player.setyAxis(player.getyAxis()+playerYSpeed);
		
	}
}
