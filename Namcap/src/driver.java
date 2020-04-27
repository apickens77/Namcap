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

		Level l = new Level(board);
		
	}
}
