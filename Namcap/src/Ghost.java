import java.awt.Color;

public class Ghost{
	Color color;
	Square location;
	
	Ghost(Color c, Square l)
	{
		this.color = c;
		this.location = l;
		this.location.hasGhost = true;
		
		this.location.ghostDanger = true;
		for(int i=0; i<4; i++)
		{
			Square neighborI = location.neighbors[i];
			if(neighborI != null)
				neighborI.ghostDanger = true;
		}
	}
	
	// TODO: Movement functions
	
	public String toString()
	{
		return "Location of Ghost: (" + this.location.xPos + ", " + this.location.yPos + ")";
	}
}
