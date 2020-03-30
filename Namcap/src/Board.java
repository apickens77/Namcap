
public class Board {
Square s[];
Graphv2 G;	


//Every Square starts with a dot. Thus they have a weight of -5 for every edge connecting to it.
// A square with a ghost in it should have a weight of 30 for every edge connecting to it.
//an empty square should have a weight of 1 for every edge connecting to it.
//This way, we can have the A.I. move based on the shortest path.
//I built a pretty simple board that connects all the way across and then down every 5 line.
	public Board(int x) {
		s=new Square[x];
		G=new Graphv2(x);
		for(int i=0;i<x-1;i++) {
			s[i]=new Square();
			if(i!=23%24)
				G.addEdge(i, i+1, -5);
			if(i%4==0||i<23)
				for(int j=2;j<x/5;j++)
					G.addEdge(i, i*j, -5);
		}
		
		
		
	}


}
