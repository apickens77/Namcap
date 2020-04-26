import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Board {
	Square[][] tiles;
	int width;
	int height;
	Pacman pacman;
	Ghost userGhost;
	Ghost aiGhost0;
	
	public Board(int width, int height)
	{
		// Set some properties that may come in handy later
		this.width = width;
		this.height = height;
		
		// Create a board of specified height and width
		this.tiles = new Square[width][height];
		for(int i=0; i<width; i++) // Have to initialize each square, o.w. each element of tiles[][] is null
		{
			for(int j=0; j<height; j++)
			{
				tiles[i][j] = new Square(i, j);
				tiles[i][j].hasDot = true;
				tiles[i][j].xPos = i*40+40;
				tiles[i][j].yPos = i*40+40;
			}
		}
		
		tiles[0][0].hasDot = false;
		
		
		tiles[1][1].hasDot = false;
		tiles[1][3].hasDot = false;
		tiles[1][6].hasDot = false;
		tiles[1][8].hasDot = false;
		
		tiles[5][0].hasDot = false;
		tiles[5][1].hasDot = false;
		tiles[5][4].hasDot = false;
		tiles[5][5].hasDot = false;
		tiles[5][8].hasDot = false;
		tiles[5][9].hasDot = false;
		
		// Link some tiles for the demo board
		demoLinks();
		
		// Test pacman's dot-finding algorithm
		tiles[6][2].hasDot = true;
		
		// Initialize pacman and aiGhost0's locations
		this.pacman = new Pacman(this.tiles[0][0]);
		this.aiGhost0 = new Ghost(Color.RED, this.tiles[5][5]);
	}
	
	// Breadth-first search to find Square with pacman
	public List<Square> shortestPathGtP(Ghost g)
	{
		// Modified version of the discussion found at 
		// https://stackoverflow.com/questions/41789767/finding-the-shortest-path-nodes-with-breadth-first-search
		Square start = g.location;
		Square target = pacman.location;
		
		Queue<Square> queue = new LinkedList<>();
		Set<Square> visitedNodes = new HashSet<>();
		Map<Square, Square> previousNodes = new HashMap<Square, Square>();
		List<Square> shortestPath = new ArrayList<>();
		queue.add(start);
		
		while(!queue.isEmpty())
		{
			Square nextNode = queue.peek();
			if(nextNode==target)
			{
				
				Square node = target;
				while(node != null)
				{
					shortestPath.add(node);
					node = previousNodes.get(node);
				}
			}
			visitedNodes.add(nextNode);
			for(int i=0; i<4; i++)
			{
				if((nextNode.neighbors[i] != null) && (visitedNodes.contains(nextNode.neighbors[i])==false))
				{
					queue.add(nextNode.neighbors[i]);
					visitedNodes.add(nextNode.neighbors[i]);
					previousNodes.put(nextNode.neighbors[i], nextNode);
				}
			}
			queue.poll();
		}
		
		Collections.reverse(shortestPath);
		System.out.println(shortestPath.toString());
		System.out.println("Distance: " + (shortestPath.size()-1));
		
		return shortestPath;	
	}
	
	private void linkSquares(int xPos, int yPos, char direction)
	{
		switch(direction)
		{
			case 'n':
				this.tiles[xPos][yPos].neighbors[0] = this.tiles[xPos][yPos-1];
				this.tiles[xPos][yPos-1].neighbors[2] = this.tiles[xPos][yPos];
				break;
			case 'e':
				this.tiles[xPos][yPos].neighbors[1] = this.tiles[xPos+1][yPos];
				this.tiles[xPos+1][yPos].neighbors[3] = this.tiles[xPos][yPos];
				break;
			case 's':
				this.tiles[xPos][yPos].neighbors[2] = this.tiles[xPos][yPos+1];
				this.tiles[xPos][yPos+1].neighbors[0] = this.tiles[xPos][yPos];
				break;
			case 'w':
				this.tiles[xPos][yPos].neighbors[3] = this.tiles[xPos-1][yPos];
				this.tiles[xPos-1][yPos].neighbors[1] = this.tiles[xPos][yPos];
				break;
		}
	}
	
	// OG links that were too boring
	private void demoLinksV0()
	{
		// Link a line across the top and bottom
		for(int i=0; i<this.width-1; i++)
		{	
			linkSquares(i, 0, 'e');
			linkSquares(i, height-1, 'e');
		}
		
		// Link a full column every 5 columns
		for(int i=0; i<this.width; i+=5)
		{
			for(int j=0; j<this.height-1; j++)
				linkSquares(i, j, 's');
		}	
	}
	
	// New and improved Chad links
	private void demoLinks()
	{
		linkSquares(0, 0, 'e');
		linkSquares(1, 1, 'e');
		linkSquares(2, 2, 'e');
		linkSquares(3, 3, 'e');
		linkSquares(5, 5, 'e');
		linkSquares(6, 6, 'e');
		linkSquares(7, 7, 'e');
		linkSquares(8, 8, 'e');
		
		for (int i = 0; i < 9; i++)
		{
			linkSquares(i, 2, 'e');
		}
		
		for (int i = 0; i < 2; i++)
		{
			linkSquares(i, 4, 'e');
			linkSquares(i+7, 3, 'e');
		}
		
		linkSquares(3, 3, 'e');
		linkSquares(5, 3, 'e');
		
		linkSquares(3, 4, 'e');
		linkSquares(4, 4, 'e');
		linkSquares(5, 4, 'e');
	
		linkSquares(0, 5, 'e');
		linkSquares(1, 5, 'e');
		linkSquares(2, 5, 'e');
		linkSquares(6, 5, 'e');
		linkSquares(7, 5, 'e');
		linkSquares(8, 5, 'e');
		
		linkSquares(3, 6, 'e');
		linkSquares(4, 6, 'e');
		linkSquares(5, 6, 'e');
		
		linkSquares(0, 7, 'e');
		linkSquares(1, 7, 'e');
		linkSquares(2, 7, 'e');
		linkSquares(3, 7, 'e');
		linkSquares(5, 7, 'e');
		linkSquares(6, 7, 'e');
		linkSquares(7, 7, 'e');
		linkSquares(8, 7, 'e');
		
		linkSquares(0, 8, 'e');
		linkSquares(2, 8, 'e');
		linkSquares(3, 8, 'e');
		linkSquares(4, 8, 'e');
		linkSquares(5, 8, 'e');
		linkSquares(6, 8, 'e');
		linkSquares(8, 8, 'e');
		
		linkSquares(0, 9, 'e');
		linkSquares(1, 9, 'e');
		linkSquares(3, 9, 'e');
		linkSquares(5, 9, 'e');
		linkSquares(7, 9, 'e');
		linkSquares(8, 9, 'e');
		
		for (int i = 0; i < 9; i++)
		{
			linkSquares(i, 10, 'e');
		}
		
		linkSquares(0, 0, 's');
		linkSquares(0, 1, 's');
		linkSquares(0, 2, 's');
		linkSquares(0, 7, 's');
		linkSquares(0, 9, 's');
		
		linkSquares(1, 8, 's');
		
		for (int i = 0; i < 9; i++)
		{
			linkSquares(2, i, 's');	
		}
		
		linkSquares(3, 2, 's');
		linkSquares(3, 4, 's');
		linkSquares(3, 5, 's');
		linkSquares(3, 6, 's');
		linkSquares(3, 8, 's');
		
		linkSquares(4, 0, 's');
		linkSquares(4, 1, 's');
		linkSquares(4, 3, 's');
		linkSquares(4, 7, 's');
		linkSquares(4, 9, 's');
		
		linkSquares(5, 0, 's');
		linkSquares(5, 1, 's');
		linkSquares(5, 3, 's');
		linkSquares(5, 7, 's');
		linkSquares(5, 9, 's');
		
		linkSquares(6, 2, 's');
		linkSquares(6, 4, 's');
		linkSquares(6, 5, 's');
		linkSquares(6, 6, 's');
		linkSquares(6, 8, 's');
		
		for (int i = 0; i < 9; i++)
		{
			linkSquares(7, i, 's');	
		}
		
		linkSquares(8, 8, 's');
		
		linkSquares(9, 0, 's');
		linkSquares(9, 1, 's');
		linkSquares(9, 2, 's');
		linkSquares(9, 7, 's');
		linkSquares(9, 9, 's');
	
	}
	
	public String toString()
	{
		String result = "Width of board: " + tiles.length + "\nHeight of board: " + tiles[0].length;
		result += "\n" + this.pacman.toString();
		result += "\n" + this.aiGhost0.toString() + "\n";
		return result;
	}
}
