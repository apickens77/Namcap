import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board implements KeyListener{
Square s[];
Graphv2 G;	
Ghost ghosts[];
int width;

//Every Square starts with a dot. Thus they have a weight of -5 for every edge connecting to it.
// A square with a ghost in it should have a weight of 30 for every edge connecting to it.
//an empty square should have a weight of 1 for every edge connecting to it.
//This way, we can have the A.I. move based on the shortest path.
//I built a pretty simple board that connects all the way across and then down every 5 line.
	public Board(int x, int width) {
		this.width=width;
		s=new Square[x];
		G=new Graphv2(x);
		for(int i=0;i<x-1;i++) {
			s[i]=new Square();
			if(i!=23%width-1)
				G.addEdge(i, i+1, -5);
			if(i%4==0&&i<width)
				for(int j=2;j<=(x/width);j++)
					G.addEdge(i, i*j, -5);
		}
		addGhosts();
	}
	public void addGhosts() {
		Ghost[] gosts= {new Ghost(Color.RED,s.length/2),new Ghost(Color.BLUE,s.length/2),
				new Ghost(Color.ORANGE,s.length/2),new Ghost(Color.PINK,s.length/2)};
		ghosts=gosts;
		s[s.length/2].containsGhost=true;
		G.addEdge(s.length/2,s.length/2+1,30);
		G.addEdge(s.length/2,s.length/2-1,30);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if(G.hasEdge(ghosts[0].location, ghosts[0].location-width)) {
				s[ghosts[0].location].containsGhost=false;
				ghosts[0].location=ghosts[0].location-width;
				s[ghosts[0].location].containsGhost=true;
			}
				
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(G.hasEdge(ghosts[0].location, ghosts[0].location+width)) {
				s[ghosts[0].location].containsGhost=false;
				ghosts[0].location=ghosts[0].location+width;
				s[ghosts[0].location].containsGhost=true;
			}
				
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(G.hasEdge(ghosts[0].location, ghosts[0].location-1)) {
				s[ghosts[0].location].containsGhost=false;
				ghosts[0].location=ghosts[0].location-1;
				s[ghosts[0].location].containsGhost=true;
			}
				
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(G.hasEdge(ghosts[0].location, ghosts[0].location+1)) {
				s[ghosts[0].location].containsGhost=false;
				ghosts[0].location=ghosts[0].location+1;
				s[ghosts[0].location].containsGhost=true;
			}
				
		}
		
		
		System.out.println("My location is"+ghosts[0].location);
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	


}
