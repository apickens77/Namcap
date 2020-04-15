
public class Pacman {
	Square location;
	
	Pacman(Square l)
	{
		this.location = l;
		this.location.hasPacman = true;
	}
	
	/* TODO: Movement functions (move Pacman on the board, possibly change location if reference to
	 * target Square isn't equal to null
	 */
	
	public String toString()
	{
		return "Location of Pacman: (" + this.location.xPos + ", " + this.location.yPos + ")";
	}
}
