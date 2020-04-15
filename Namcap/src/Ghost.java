import java.awt.Color;

public class Ghost{
	Color color;
	Square location;
	
	Ghost(Color c, Square l)
	{
		this.color = c;
		this.location = l;
		this.location.hasGhost = true;
	}
	
	// TODO: Movement functions
}
