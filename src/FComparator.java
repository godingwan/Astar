import java.util.Comparator;

public class FComparator implements Comparator<Node> {
  @Override
   public int compare(Node x, Node y) {
       return x.getF() - y.getF();
   }
}
