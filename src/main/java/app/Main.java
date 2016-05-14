package app;

import degree.NodeDegree;
import utils.Graph;
import utils.In;

/**
 * Main entry point of the application. Can run this or execute test cases. This driver can
 * handle console or file input.
 * Pass in the path to the file for file input on command line or no arguments
 * for console input
 * 
 * @author Yogesh
 */
public class Main {

	public static void main(String[] args) {
		In in = new In();
		Graph graph = null;
		if (args.length == 1) {
			in = new In(args[0]);
			graph = new Graph(in);
		} else {
			System.out.println("Enter number of vertices following edge list (Ctrl & Z to exit");
			int numVertices = in.readInt();
			graph = new Graph(numVertices);
			do {
				int v = in.readInt();
				int w = in.readInt();
				graph.addEdge(v, w);

			} while (!in.isEmpty());

		}
		NodeDegree.printDegreeOfEachNode(graph);

	}

}
