/* Simple GUI to visualize your binary tree
 * 
 * Based on code by Eslam Hamouda <EslaMx7>
 * https://github.com/EslaMx7/AI-Tasks-JADE-Tests/blob/master/src/trees/tasks/treeGUI.java
 * 
 * Modified for COMP1406 - W16 - mjh
 * 
 * Modify the main method in the TreeGUI class 
 * (note there is another class below this one in this file)
 * 
 * Left children are coloured by LEFT_COLOUR
 * Right children are coloured by RIGHT_COLOUR
 * 
 * They are currently set to blue and red (respectively). 
 * Please change these as needed.
 * 
 * You may want to make the output window larger after it is made 
 * to see the tree structure better (the farther down the tree
 * you go the closer the left/right children are displayed)
 */

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TreeGUI extends JFrame {
  
  public static Color LEFT_COLOUR = Color.blue;
  public static Color RIGHT_COLOUR = Color.red; 
  
  
  private JPanel contentPane;
  public BinaryTree tree;
  public DrawTree drawer;
  
  /**
   * Create the frame.
   */
  public TreeGUI(BinaryTree tree) {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 500, 500);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(new BorderLayout(0, 0));
    drawer = new DrawTree(tree);
    
    contentPane.add(drawer);
    setContentPane(contentPane);
    this.tree = tree;
    setVisible(true);
  }
  
  public static void main(String[] args) {
   
    
    BinaryTree tree = new BinaryTree();
    
    // build the tree
    tree = BinaryTree.create();
    
    tree.addLeaf(-2);
     
    // tree.removeLeaf();
    
    System.out.println(tree.find(75));
    
    System.out.println(tree.depth(new Node(-2, null, null)));
    
    System.out.println(tree.getNumbers());
    // view the tree
    TreeGUI gui = new TreeGUI(tree);
    
  } 


}














class DrawTree extends JPanel{
  
  public BinaryTree tree;
  
  public DrawTree(BinaryTree tree){
    this.tree = tree;
  }
  
  @Override
  protected void paintComponent(Graphics g) {
    // TODO Auto-generated method stub
    g.setFont(new Font("Tahoma", Font.BOLD, 24));
    //g.drawString(String.valueOf(tree.root.data), this.getWidth()/2, 30);
    //DrawNode(g, tree.root,100, 50,2);
    DrawTree(g, 0, getWidth(), 0, getHeight() / tree.getheight(tree.root), 
             tree.root, Color.black);
  }
  
  public void DrawNode(Graphics g,Node n,int w,int h,int q){
    g.setFont(new Font("Tahoma", Font.BOLD, 20));
    
    if(n!=null){
      
      //g.drawString(String.valueOf(n.data), (this.getWidth()/q)+w, h);
      g.drawOval((this.getWidth()/q)+w, h, this.getWidth()/q+w, h);
      //g.drawOval(0, 0, getWidth(), getHeight());

      if(n.getLeft() !=null)
        DrawNode(g, n.getLeft(), -w, h*2, q);
      //g.drawString(String.valueOf(n.getLeft().data), (this.getWidth()/q)-w, h+50);
      if(n.getRight() !=null)
        DrawNode(g, n.getRight(), w*2, h*2, q);
      //g.drawString(String.valueOf(n.getRight().data), (this.getWidth()/q)+w, h+50);
    }
       
  }
  
  
  public void DrawTree(Graphics g, int StartWidth, 
                       int EndWidth, int StartHeight, 
                       int Level, Node node, Color c) {
    String data = String.valueOf(node.getData());
    g.setFont(new Font("Tahoma", Font.BOLD, 8));
    g.setColor(c);
    FontMetrics fm = g.getFontMetrics();
    int dataWidth = fm.stringWidth(data);
    g.drawString(data, 
                 (StartWidth + EndWidth) / 2 - dataWidth / 2 + 3, 
                 StartHeight + Level / 2 + 10);
    g.drawOval(
              // (this.getWidth())+StartWidth, StartHeight, 
              //    this.getWidth()+StartWidth, StartHeight
               (StartWidth + EndWidth) / 2 - dataWidth / 2, 
                 StartHeight + Level / 2, 15, 15
              );
    int xx = 0;
    int yy = StartHeight - Level / 2 + 12;
    if( c.equals(Color.red)){
      xx = StartWidth   - dataWidth / 2 + 10;
    }else if( c.equals(Color.blue)){
      xx = EndWidth   - dataWidth / 2 + 10;
    }else{
      xx = (StartWidth + EndWidth) / 2 - dataWidth / 2 + 10;
      yy = StartHeight + Level / 2;
    }
    
    g.drawLine((StartWidth + EndWidth) / 2 - dataWidth / 2 + 10, 
                 StartHeight + Level / 2,
               xx,yy);
    //drawCenteredText(g,   (StartWidth + EndWidth) / 2 - dataWidth / 2, 
    //             StartHeight + Level / 2,
    //                 node.getData().toString());
    
    if (node.getLeft() != null)            
      DrawTree(g, StartWidth, 
               (int) ((StartWidth + EndWidth) / 2.), 
               StartHeight + 1*Level, Level, 
               node.getLeft(), TreeGUI.LEFT_COLOUR);
    
    if (node.getRight() != null)
      DrawTree(g, (int) ((StartWidth + EndWidth) / 2.), 
               EndWidth, StartHeight + 1*Level, Level, 
               node.getRight(), TreeGUI.RIGHT_COLOUR);
  }
  
  
}
