import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ghost implements KeyListener{
	Color c;
	Board b;
	int location;
	public Ghost (Color c, Board b, int l) {
		this.c=c;
		this.b=b;
		location=l;
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	//I set the width to be 25 on the board, if that changes, change this.
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if(b.G.hasEdge(location, location-25))
					location=location-25;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(b.G.hasEdge(location, location+25))
					location=location+25;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(b.G.hasEdge(location, location-1))
					location=location-1;
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(b.G.hasEdge(location, location+1))
					location=location+1;
		}
		
		
		System.out.println("My location is"+location);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
