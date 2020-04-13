
public class Graphv2 {
int c[][];
	
	public Graphv2(int x) {
		c=new int[x][x];
		for(int i=0;i<x;i++) {
			for(int j=0;j<x;j++) {
				c[i][j]=5000;
			}
		}
	}
	
	public void addEdge(int from,int to,int weight) {
		c[from][to]=weight;
		c[to][from]=weight;
	}
	
	public boolean hasEdge(int from, int to) {
		if(c[from][to]==5000) {
			return false;
		}
		else
			return true;
	}
	
}
