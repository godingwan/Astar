import java.util.PriorityQueue;

public class Driver {
	private static final int GRIDSIZE = 15;
	private static Node[][] map = new Node[GRIDSIZE][GRIDSIZE];

	public static void main(String args[]) {
		setMap();
		printMap();
		Node currentNode;
		FComparator comparator = new FComparator();
		int g, h, r, c;

		// Get user input for start and end node
		int sX, sY, eX, eY;
		sX = 8;
		sY = 8;
		eX = 8;
		eY = 8;

		// Set starting node's heuristic values
		finalizeNode(map[sX][sY], sX, sY, eX, eY);
		// Add starting node into min heap
		PriorityQueue minHeap = new PriorityQueue<Node>(20, comparator);
		minHeap.add(map[sX][sY]);

		// pop off node with lowest F and set as current Node
		currentNode = (Node) minHeap.poll();
		// check if current is the goal
		if (currentNode.getRow() == eX && currentNode.getCol() == eY) {
			// if yes generate path
			printPath(currentNode);
		}
		// generate neighbors, row is y, col is x
		r = currentNode.getRow();
		c = currentNode.getCol();
		for (int row = r-1; row < r+2; row++) {
			for (int col = c -1; col < c+2; col++) {
				// Check if it's in the closed list
				if (map[col][row].checkClosedList()) continue;
				// Check if it's outside the bounds of the GRIDSIZE
				else if (row < 0 || col < 0 || row > GRIDSIZE - 1 || col > GRIDSIZE - 1) continue;
				// Check if it is traversable
				else if (!map[col][row].getTraversable()) continue;
				else {
					// set parent
					map[col][row].setParent(map[c][r]);
					finalizeNode(map[col][row], sX, sY, eX, eY);

					minHeap.add(map[col][row])
				}
			}
		}
		// add to/update open list
		// add current node to the closed list

	}

	private static void finalizeNode(Node n, int sX, int sY, int eX, int eY) {
		if (n.getParent() == null) {
			n.setG(0);
			n.setH(this.getH(sX, sY, eX, eY));
			n.setF();
		}
		else {

		}
	}

	private static boolean isDiagonal(Node parent, Node current) {

	}

	private static void setMap() {
		for (int i=0; i<GRIDSIZE; i++) {
			for (int j=0; j<GRIDSIZE; j++)
				map[i][j] = new Node(i, j);
		}
	}

	private static void printMap() {
		for (int i=0; i<GRIDSIZE; i++) {
			for (int j=0; j<GRIDSIZE; j++) {
				if (map[i][j].getTraversable() == true)
					System.out.print("1 ");
				else
					System.out.print("0 ");
			}
			System.out.println();
		}
	}

	private static int getH(int sX, int sY, int eX, int eY) {
		return (Math.abs(eX - sX) + Math.abs(eY - sY));
	}

	private static void printPath(Node endNode) {
		if (endNode.getParent() == null) {
			System.out.print("[" + endNode.getCol() +"," + endNode.getRow() + "]");
		}
		while (endNode.getParent() != null) {
			printPath(endNode.getParent());
			System.out.print("[" + endNode.getCol() +"," + endNode.getRow() + "]");
		}
	}
}
