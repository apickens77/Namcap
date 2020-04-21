import java.awt.*;

import javax.imageio.ImageIO;
//import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.border.TitledBorder;

public class driver extends JPanel {
	public static void main(String[] args)
	{
		/*
		Board board = new Board(7, 5);
		System.out.println(board);
		System.out.println();
		
		// Comment these in or out for testing
		board.shortestPathGtP(board.aiGhost0);
		System.out.println();
		System.out.println();
		System.out.println();
		board.pacman.locateNearestDot();*/

		/*BufferedImage image = null;
		//Image img = getToolkit().getImage("node.jpg");

		
		try {
			image = ImageIO.read(new File("ghost.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		JFrame f = new JFrame();
		Move m = new Move();
		f.add(m);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800, 600);
		
		//m.x = 10;
		//m.moveVert(-20);
		
	}
}
