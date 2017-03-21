
public class Driver {
	private static final int GRIDSIZE = 15;
	private static Node[][] map = new Node[GRIDSIZE][GRIDSIZE];
	
	public static void main(String args[]) {
		setMap();
		printMap();
		
		
		
		// pop off node with lowest F and set as current Node
		// check if current is the goal
		// if yes generate path
		// if not continue
		// generate neighbors and add to/update open list
		// add current node to the closed list
		
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
}
