import javax.swing.JFrame;

public class driver {

	public static void main(String[] args) {
		Graphv2 g = new Graphv2(25);
		g.addEdge(1, 3, 5);
		g.addEdge(5, 22, 100);
		
		Board b = new Board(100, 25);
		
		
		/*JFrame f = new JFrame();
		Move m = new Move();
		f.add(m);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800, 600); */
		
		 Algorithm a = new Algorithm();
		 
		 a.dijkstra(b.G.c, 0);
	}

}
