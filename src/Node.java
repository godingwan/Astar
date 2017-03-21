import java.util.Random;

public class Node {
	private boolean closedList, traversable;
	private int row, col, f, g, h;
	private Node parent;
	
	public Node(int r, int c) {
		row = r;
		col = c;
		traversable = new Random().nextInt(10) == 0; // 10% chance of a node being traversable
		traversable = !traversable; // 10% chance of a node being not traversable
		parent = null;
		closedList = false;
	}
	
	public void setF() {
		f = g + h;
	}
	
	public void setG(int v) {
		g = v;
	}
	
	public void setH(int v) {
		h = v;
	}
	
	public void setParent(Node n) {
		parent = n;
	}
	
	public void addToClosedList() {
		closedList = true;
	}
	
	public int getF() {
		return f;
	}
	
	public int getG() {
		return g;
	}
	
	public int getH() {
		return h;
	}
	
	public boolean getTraversable() {
		return traversable;
	}
	
	public boolean checkClosedList() {
		return closedList;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public boolean equals(Object other) {
		Node n = (Node) other;
		
		return row == n.getRow() && col == n.getCol();
	}
	
	public String toString() {
		return "Node: " + row + "_" + col;
	}
}
