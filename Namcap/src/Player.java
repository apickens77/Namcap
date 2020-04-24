import java.awt.*;
import javax.swing.*;

public class Player
{
	private int lives;
	private int xAxis;
	private int yAxis;
	private String imagePath;
	private boolean isAlive;
	
	
	
	public Player(int lives, int xAxis, int yAxis, String imagePath, boolean isAlive) 
	{
		super();
		this.lives = lives;
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.imagePath = imagePath;
		this.isAlive = isAlive;
	}
	
	
	public int getLives() {
		return lives;
	}
	public int getxAxis() {
		return xAxis;
	}
	public int getyAxis() {
		return yAxis;
	}
	public String getImagePath() {
		return imagePath;
	}
	public boolean isAlive() {
		return isAlive;
	}
	public void setLives(int lives) {
		this.lives = lives;
	}
	public void setxAxis(int xAxis) {
		this.xAxis = xAxis;
	}
	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}
	public void setImagePath(String imagePath) 
	{
		if (imagePath == null)
			JOptionPane.showMessageDialog(null, "Invalid String");
		else if (imagePath.length() == 0)
			JOptionPane.showMessageDialog(null, "String Empty");
		else
			this.imagePath = imagePath;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	public void drawPlayer(Graphics g)
	{
		ImageIcon img = new ImageIcon(imagePath);
		g.drawImage(img.getImage(), xAxis, yAxis, null);
	}
}