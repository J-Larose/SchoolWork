import java.util.ArrayList;

public abstract class AbstractBinaryTree{
  protected Node  root;
  protected int   sizeOfTree;
  
  public AbstractBinaryTree(){ 
    root = null; 
    sizeOfTree = 0;
  }
  
  public int size(){ return sizeOfTree; }
  
  /** compute the depth of a node */
  public abstract int depth(Node node);
  
  /** Check if a number is in the tree or not */
  public abstract boolean find(Integer i);
  
  /** Create a list of all the numbers in the tree. */
  /*  If a number appears N times in the tree then this */
  /*  number should appear N times in the returned list */ 
  public abstract ArrayList<Integer> getNumbers();
  
  
  /** Adds a leaf to the tree with number specifed by input.  */
  public abstract void addLeaf(Integer i);
  
  /** Removes "some" leaf from the tree.       */
  /*  If the tree is empty should return null  */
  public abstract Node removeLeaf();
  
  
  
  // these methods are only needed if you wish 
  // use the TreeGUI visualization program
  public int getheight(Node n){
    if( n == null) return 0;
    return 1 +  Math.max(
       getheight(n.getLeft()) ,  getheight(n.getRight())
                           );
  }
  
  public int height(){ return getheight(root); }
    

  
}