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
		
		Board board = new Board(10, 11);
		System.out.println(board);
		System.out.println();
		
		// Comment these in or out for testing
		board.shortestPathGtP(board.aiGhost0);
		System.out.println();
		System.out.println();
		System.out.println();
		//board.pacman.locateNearestDot();

		
		Level l = new Level(board);
		
	}
}
