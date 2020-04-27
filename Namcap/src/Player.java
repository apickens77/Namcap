import java.awt.*;
import javax.swing.*;

public class Player
{
	private int xAxis;
	private int yAxis;
	
	private int xDest;
	private int yDest;
	
	private String imagePath;
	
	
	
	public Player( int xAxis, int yAxis, String imagePath) 
	{
		super();
		//this.lives = lives;
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.imagePath = imagePath;
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

	public void drawPlayer(Graphics g)
	{
		ImageIcon img = new ImageIcon(imagePath);
		g.drawImage(img.getImage(), xAxis, yAxis, null);
	}


	public int getxDest() {
		return xDest;
	}


	public int getyDest() {
		return yDest;
	}


	public void setxDest(int xDest) {
		this.xDest = xDest;
	}


	public void setyDest(int yDest) {
		this.yDest = yDest;
	}
	
	
}