import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ghost{
	Color c;
	int location;
	
	Square sN;
	Square sS;
	Square sE;
	Square sW;
	
	public Ghost (Color c, int l) {
		this.c=c;
		location=l;
	}
	
	/*public void changeN(Graphv2 g, int x, int y)
	{
		g.addEdge(x, y, val);
	}
	
	public void changeS(Graphv2 g, int x, int y)
	{
		g.addEdge(x, y, val);
	}
	
	public void changeE(Graphv2 g, int x, int y, int val)
	{
		g.addEdge(x, y, val);
	}
	
	public void changeW(Graphv2 g, int x, int y, int val)
	{
		g.addEdge(x, y, val);
	}*/

}
