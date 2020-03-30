
public class Square {

boolean containsPacman;	
boolean containsDot;
boolean containsGhost;

	public Square() {
		containsDot=true; 
		containsPacman=false;
	}
	
	public void Moveto() {
		containsPacman=true;
		containsDot=false;
	}
	
	
}
