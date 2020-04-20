
public class Square {
	// Linked Squares
	Square[] neighbors; // [north, east, south, west]
	
	// Coordinates
	int xPos;
	int yPos; // y coordinate system starts at top of board and goes down, like that of a matrix
	
	// What the Square contains
	boolean hasDot;
	boolean hasPacman;
	boolean hasGhost;
	boolean ghostDanger; // true iff this square or an adjacent square contains a ghost
	
	Square(int x, int y)
	{
		this.neighbors = new Square[4];
		
		this.xPos = x;
		this.yPos = y;
		
		this.hasDot = false;
		this.hasPacman = false;
		this.hasGhost = false;
		this.ghostDanger = false;
	}
	
	public String toString()
	{
		String result = "Square's coordinates: (" + this.xPos + ", " + this.yPos + ")\n";
		if(this.neighbors[0] != null)
			result += "North neighbor: (" + this.neighbors[0].xPos + ", " + this.neighbors[0].yPos + ")\n";
		if(this.neighbors[1] != null)
			result += "East neighbor: (" + this.neighbors[1].xPos + ", " + this.neighbors[1].yPos + ")\n";
		if(this.neighbors[2] != null)
			result += "South neighbor: (" + this.neighbors[2].xPos + ", " + this.neighbors[2].yPos + ")\n";
		if(this.neighbors[3] != null)
			result += "West neighbor: (" + this.neighbors[3].xPos + ", " + this.neighbors[3].yPos + ")\n";
		
		
		if(this.hasDot)
			result += "Contains dot\n";
		if(this.hasPacman)
			result += "Contains Pacman\n";
		if(this.hasGhost)
			result += "Contains Ghost\n";
		if(this.ghostDanger)
			result += "Ghost danger!\n";
		
		
		return result;
	}
}