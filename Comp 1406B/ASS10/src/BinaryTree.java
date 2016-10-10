
import java.util.ArrayList;
import java.util.Objects;

/* 
 * @author Jacob Larose
 * @since <add date of final revision>
 * @custom.citations "I did not use any reference material in developing this assignment."
 */



public class BinaryTree extends AbstractBinaryTree{
    
    public BinaryTree(){
        super();
    }

    public static BinaryTree create(){
        BinaryTree tree = new BinaryTree();
        
        //bottom node row
        Node n5 = new Node(5, null, null);
        
        //seccond last row\
        Node n74a = new Node(74, n5, null);
        Node n73a = new Node(73, null, null);
        Node n66a = new Node(66, null, null);
        Node n72a = new Node(72, null, null);
        Node n61a = new Node(61, null, null);
        
        //third last row
        Node n3b = new Node(3, null, n74a);
        Node n61b = new Node(61, n66a, n73a);
        Node n51b = new Node(51, n61a, n72a);
        
        //forth last row
        Node n2c = new Node(2, n3b, null);
        Node n34c = new Node(34, n61b, null);
        Node n42c = new Node(42, null, null);
        Node n29c = new Node(29, null, n51b);
        
        //fifth last row
        Node n32d = new Node(32, null, n2c);
        Node n31d = new Node(31, n42c, n34c);
        Node n30d = new Node(30, null, n29c);
        
        
        //2nd to the top
        Node n40e = new Node(40, n31d, n32d);
        Node n10e = new Node(10, n30d, null);
        
        //root
        tree.root = new Node(12, n10e , n40e);
        tree.sizeOfTree = 19;
        
        return tree;
    }
    
    @Override
    public int depth(Node node){
        //bredth first search
        int depth = 0;
        ArrayList<Node> currentChildren = new ArrayList();
        ArrayList<Node> nextChildren = new ArrayList();
        
        if(this.root.getData().equals(node.getData())){
            return depth;
        }else{
            currentChildren.add(this.root.getLeft());
            currentChildren.add(this.root.getRight());
        }
        
        while(true){
            depth++;
            for(Node x : currentChildren){
                if(x.getData().equals(node.getData())){
                    return depth;
                }else{
                    if(x.getLeft()!=null){
                        nextChildren.add(x.getLeft());
                    }
                    if(x.getRight()!=null){
                        nextChildren.add(x.getRight());
                    }
                }
            }
            if (nextChildren.isEmpty()){
                break;
            }else{
                currentChildren = nextChildren;
                nextChildren = new ArrayList();
            }
        }
        return -1;
    }
    
    @Override
    public boolean find(Integer i){
        ArrayList<Node> currentChildren = new ArrayList();
        ArrayList<Node> nextChildren = new ArrayList();
        
        if(Objects.equals(this.root.getData(), i)){
            return true;
        }else{
            currentChildren.add(this.root.getLeft());
            currentChildren.add(this.root.getRight());
        }
        
        while(true){
            for(Node x : currentChildren){
                if(Objects.equals(x.getData(), i)){
                    return true;
                }else{
                    if(x.getLeft()!=null){
                        nextChildren.add(x.getLeft());
                    }
                    if(x.getRight()!=null){
                        nextChildren.add(x.getRight());
                    }
                }
            }
            if (nextChildren.isEmpty()){
                break;
            }else{
                currentChildren = nextChildren;
                nextChildren = new ArrayList();
            }
        }
        return false;
    }
    
    @Override
    public ArrayList<Integer> getNumbers(){
        ArrayList<Node> currentChildren = new ArrayList();
        ArrayList<Node> nextChildren = new ArrayList();
        ArrayList<Integer> numbers = new ArrayList();
        
        numbers.add(this.root.getData());
        
        currentChildren.add(this.root.getLeft());
        currentChildren.add(this.root.getRight());
        
        while(true){
            for(Node x : currentChildren){
                numbers.add(x.getData());
                
                if(x.getLeft()!=null){
                    nextChildren.add(x.getLeft());
                }
                if(x.getRight()!=null){
                    nextChildren.add(x.getRight());
                }
            }
            if (nextChildren.isEmpty()){
                break;
            }else{
                currentChildren = nextChildren;
                nextChildren = new ArrayList();
            }
        }
        return numbers;
    }
    
    @Override
    public void addLeaf(Integer i){
        Node current = this.root;
        if(current == null){
            this.root = new Node(i, null, null);
        }
        while (true){
            if(current.getLeft()==null){
                current.setLeft(new Node(i, null, null));
                break;
            }else{
                current = current.getLeft();
            }
        }
        this.sizeOfTree ++;
    }
    
    @Override
    public Node removeLeaf(){
        Node last;
        Node current = this.root;
        if(this.root == null){
            System.out.println("no root");
            return null;
        }else if(this.root.getLeft()==null && this.root.getRight()==null ){
            this.root = null;
            return current;
        }else if(this.root.getLeft()!=null){
            current = this.root.getLeft();
            last = this.root;
        }else{
            current = this.root.getRight();
            last = this.root;
        }
        
        while (true){
            if(current.getLeft()==null && current.getRight()==null ){
                if(last.getLeft().equals(current)){
                    last.setLeft(null);
                    this.sizeOfTree --;

                    return current;
                }else{
                    last.setRight(null);
                    this.sizeOfTree --;

                    return current;
                }
            }else if(current.getLeft()!=null){
                last = current;
                current = current.getLeft();
            }else{
                last = current;
                current = current.getRight();
            }
        }
    }
}