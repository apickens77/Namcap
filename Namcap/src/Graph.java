import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class Graph {
	LinkedList<Integer> adjListArray[];
	
	
    
	/*public Graph(int a) {
		//adjListArray = new LinkedList[a];
		
	}*/
	public Graph() {
		JFileChooser chooser=new JFileChooser();
    	chooser.showOpenDialog(chooser);
		
		Scanner scanner = null;
		try {
			scanner = new Scanner(chooser.getSelectedFile());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
        scanner.useDelimiter("[,\\s]+");
        int numNodes = scanner.nextInt();
        Point2D.Double[] points = new Point2D.Double[numNodes];
        
        adjListArray = new LinkedList[numNodes];
        for(int i=0; i<numNodes; i++)
        {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            adjListArray[i]=new LinkedList<>();
            points[i] = new Point2D.Double(x,y);
        }
        int numedges=scanner.nextInt();
        for(int i=0;i<numedges;i++) {
        	int from=scanner.nextInt();
        	int to=scanner.nextInt();
        	adjListArray[from].add(to);
        	adjListArray[to].add(from);
        	
        }
	}
	
	public void addEdge(int from,int to) {
		adjListArray[from].add(to);
		adjListArray[to].add(from);
	}
	/*public void removeEdge(int from, int to ) {
		adjListArray[from].remove(to);
		adjListArray[to].rem(from);
	}*/
	public void print() {
		for(int i=0;i<adjListArray.length;i++) {
			for(int j=0;j<adjListArray[i].size();j++) {
				System.out.println("The node "+i+" is connected to node "+adjListArray[i].get(j));
			}
		}
	}
}
