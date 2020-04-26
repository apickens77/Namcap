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
	private ImageIcon bg = new ImageIcon("C:\\Users\\Adam Pickens\\git\\Namcap\\Namcap\\src\\images\\map grid.png");
	private ImageIcon dot = new ImageIcon("C:\\Users\\Adam Pickens\\git\\Namcap\\Namcap\\src\\images\\dot.gif");
	private Player player = new Player(3, 400, 40, "C:\\Users\\Adam Pickens\\git\\Namcap\\Namcap\\src\\images\\ghost.jpg");
	private PacMove pacman = new PacMove(3, 40, 40, "C:\\Users\\Adam Pickens\\git\\Namcap\\Namcap\\src\\images\\pacman.gif", true);
	private int speed = 20;
	private int xSpeed = speed;
	private int ySpeed = speed;
	private int playerXSpeed = speed;
	private int playerYSpeed = speed;
	private Square tempPlayer;
	
	private Board boardPac; 
	
	public Level(Board b)
	{
		//pacman = new PacMove(3, b.pacman.location.xPos, b.pacman.location.yPos, "C:\\Users\\Adam Pickens\\git\\Namcap\\Namcap\\src\\images\\pacman.gif", true);
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
		
		//System.out.println(bg.getIconWidth() + " " + bg.getIconHeight());
		
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
		System.out.println("Current Square: " + boardPac.aiGhost0.location);
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			//System.out.println("ASDFAFDASDFADFA");
			if (player.getxAxis() == player.getxDest() & player.getyAxis() == player.getyDest())
			{
				
				
				tempPlayer = boardPac.aiGhost0.location.neighbors[1];
				
				
				if (tempPlayer != null)
				{
					System.out.println("ASDFAFDASDFADFA");
					player.setxDest(tempPlayer.xPos);
				
					for (int i = 0; i < 4; i++)
						boardPac.aiGhost0.location.neighbors[i].ghostDanger = false;
					
					
					//boardPac.aiGhost0.setLocation(boardPac.aiGhost0.location.neighbors[1]);
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
						boardPac.aiGhost0.location.neighbors[i].ghostDanger = false;
					
					System.out.println("ASDFAFDASDFADFA");
					//boardPac.aiGhost0.setLocation(temp);
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
						boardPac.aiGhost0.location.neighbors[i].ghostDanger = false;
					
					//boardPac.aiGhost0.setLocation(boardPac.aiGhost0.location.neighbors[0]);
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
						boardPac.aiGhost0.location.neighbors[i].ghostDanger = false;
					
					//boardPac.aiGhost0.setLocation(boardPac.aiGhost0.location.neighbors[2]);
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
				boardPac.aiGhost0.setLocation(tempPlayer);
			}
		}
		
		if (boardPac.aiGhost0.location == boardPac.pacman.location)
		{
			JFrame endFrame = new JFrame();
			endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			System.exit(0);
			JOptionPane.showMessageDialog(endFrame, "You Win!");
			
		}
		
		pacman.setxAxis(pacman.getxAxis()+xSpeed);
		pacman.setyAxis(pacman.getyAxis()+ySpeed);
		player.setxAxis(player.getxAxis()+playerXSpeed);
		player.setyAxis(player.getyAxis()+playerYSpeed);
		
	}
}
