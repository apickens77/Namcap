import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Pacman {
	Square location;
	
	Pacman(Square l)
	{
		this.location = l;
		this.location.hasPacman = true;
	}
	
	public List<Square> locateNearestDot()
	{
		// Modified version of the discussion found at 
		// https://stackoverflow.com/questions/41789767/finding-the-shortest-path-nodes-with-breadth-first-search
		// Almost identical to Board.shortestPathGtP(), but has no target, had to add a break, and this has a check for ghostDanger
		Square start = this.location;
		
		Queue<Square> queue = new LinkedList<>();
		Set<Square> visitedNodes = new HashSet<>();
		Map<Square, Square> previousNodes = new HashMap<Square, Square>();
		List<Square> shortestPath = new ArrayList<>();
		queue.add(start);
		
		while(!queue.isEmpty())
		{
			Square nextNode = queue.peek();
			if(nextNode.hasDot)
			{
				
				Square node = nextNode;
				while(node != null)
				{
					shortestPath.add(node);
					node = previousNodes.get(node);
				}
				break; // This break is important. Without this, if a bunch of adjacent Squares have dots, the algorithm keeps going and going and going.
			}
			visitedNodes.add(nextNode);
			for(int i=0; i<4; i++)
			{
				// Execute if there's a connection, the potential Square hasn't already been visited, and it isn't adjacent to a Ghost
				if((nextNode.neighbors[i] != null) && (visitedNodes.contains(nextNode.neighbors[i])==false) && !nextNode.neighbors[i].ghostDanger)
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
	
	// TODO: Movement functions (move Pacman on the board: change location if reference to target Square isn't equal to null
	
	public String toString()
	{
		return "Location of Pacman: (" + this.location.xPos + ", " + this.location.yPos + ")";
	}
}
