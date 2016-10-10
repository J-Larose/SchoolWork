public class Node{
  protected Integer data;
  
  protected Node left;
  protected Node right;
  
  public Node(Integer data){
    this.data = data;
    this.left = this.right = null;
  }
  
  public Node(Integer data, Node left, Node right){
    this.data = data;
    this.left = left;
    this.right = right;
  }
  
  public Integer getData(){ return this.data; }
  public Node    getLeft(){ return this.left; }
  public Node    getRight(){ return this.right; }
  
  public void setLeft(Node left){ this.left = left; }
  public void setRight(Node right){ this.right = right; }
  
  
  
  
}