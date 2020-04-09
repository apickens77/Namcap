import javax.swing.JFrame;

public class driver {

	public static void main(String[] args) {
		/*Graph b=new Graph();
		b.print();
		b.addEdge(3, 1);
		b.print();
		//b.removeEdge(3, 1);
		b.print();*/
		
		JFrame f = new JFrame();
		Move m = new Move();
		f.add(m);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800, 600);
	}

}
