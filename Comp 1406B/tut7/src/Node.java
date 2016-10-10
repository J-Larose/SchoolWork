public class Node{
   private Student student;   // data

   private Node next;   // reference to the next node
   private Node prev;   // reference to the previous node

   /* constructors */
   public Node(){ /* do nothing */  }
   
   public Node(Student s){
      this.student = s; 
      this.next = null;
      this.prev = null;
   }
   
   
   /* getters */
   public Student getStudent(){ return this.student; }
   public Node    getNext(){ return this.next; }
   public Node    getPrevious(){ return this.prev; }
   
   /* setters */
   public void setStudent(Student s){ this.student = s; }
   public void setNext(Node next){ this.next = next; }
   public void setPrevious(Node prev){ this.prev = prev; }
   
   
}
