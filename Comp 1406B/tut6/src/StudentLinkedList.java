public class StudentLinkedList{

   public Node head;

   public StudentLinkedList(){ 
      // create an empty linked list
      head = null;
   }

   public StudentLinkedList(Student s){ 
      // create a linked list with one student
      head = new Node(s);
   }

   
   /* public helper method */
   public String toString(){
   	  String s = "[";

      Node currentNode = head;

      while( currentNode != null){
      	s+= currentNode.s.getName();      
      	if( currentNode.next != null){
      		s+= ", ";
      	}
      	currentNode = currentNode.next;

      }
      s += "]";
      return s;
   	}


}
