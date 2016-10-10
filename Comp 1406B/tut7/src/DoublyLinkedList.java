public class DoublyLinkedList{
  public Node head;  // first node in the list
  public Node tail;  // last node in the list
  
  public DoublyLinkedList(){            // create an empty list
    head = tail = null;
  }
  public DoublyLinkedList(Student s){   // create a list with one Data object in it         
    head = tail = new Node(s);
  }
  
  public DoublyLinkedList addBack(Student s){   // code provided for you
    // Adds the student s to the back of the list.
    // Returns the current list (this)
    
    if(this.head == null){
      this.head = new Node(s);
      this.tail = this.head;
      return this;
    }
    this.tail.setNext(new Node(s));
    this.tail.getNext().setPrevious(this.tail);
    this.tail = this.tail.getNext();
    
    return this;
  }
  
  public void printForward(){
    // Prints the names of all the students in the list
    // from the front to the end back (in that order).
    // Prints to standard out (System.out)
    Node current = head;
    while(current != null){
      System.out.print(current.getStudent().getName());
      if(current.getNext() != null){ 
        System.out.print(", ");
      }
      current = current.getNext();
    }
    System.out.println();
    
  }
  
  
  
  /* ------------------------------------------------------------------- */
  /* methods that you need to implement                                  */
  /* ------------------------------------------------------------------- */
  
  
  public int size(){
      Node node = head;
      int count = 1;
      while(node!=tail){
          node = node.getNext();
          count ++;
      }
    return count;
  }
  
  public void printBackward(){
      Node node = tail;
      while(node!=head){
          System.out.println(node.getStudent().getName());
          node = node.getPrevious();
      }
      System.out.println(head.getStudent().getName());
    // Prints the names of all the students in the list
    // from the back to the front (in that order).
    // Prints to standard out (System.out)
    
  }
  
  
  public DoublyLinkedList addFront(Student s){
      Node newHead = new Node(s);
      newHead.setNext(head);
      head.setPrevious(newHead);
      head = newHead;
    
    return this;   // leave this return value as is
  }
  
  
  public Student removeBack(){
      Node newTail = tail.getPrevious();
      tail.getPrevious().setNext(newTail);
      Student s = tail.getStudent();
      tail = newTail;
      tail.setNext(null);
    // Removes the last student in the list.
    // Returns the removed student, or null if the list was initially empty
    
    return s; 
  }
  
  
  public Student removeFront(){
      Node newHead = head.getNext();
      head.getNext().setPrevious(newHead);
      Student s = head.getStudent();
      head = newHead;
      
      head.setPrevious(null);
    // Removes the first student in the list.    
    // Returns the removed student, or null if the list was initially empty  
    
    return s;
  }
  
  public DoublyLinkedList add(Student s, int pos){
      Node nxt = head;
      Node newNode = new Node(s);
      for(int i=1; i<pos; i++){
          nxt = nxt.getNext();
      }
      Node lst = nxt.getPrevious();
      
      lst.setNext(newNode);
      nxt.setPrevious(newNode);
      
      newNode.setNext(nxt);
      newNode.setPrevious(lst);
      
    // Adds the student s to position pos in the list.  
    // The ordering of the original list should be maintained with s inserted at    
    // position pos.  
    // Returns the current list (this)  
    
    
    return this;   // do not change this return value
  }
  
  public Student remove(int pos){ 
      Node rmv = head;
      for(int i=1; i<pos; i++){
          rmv = rmv.getNext();
      }
      Student s = rmv.getStudent();
      
      rmv.getPrevious().setNext(rmv.getNext());
      rmv.getNext().setPrevious(rmv.getPrevious());
      
      
    // Removes the student in positon pos in the list.   
    // Returns the removed student, or null if the list was initially empty 
    
    return s;
  }
  
  
  public boolean contains(String name){
      Node front = head;
      Node back = tail; 
      while(true){
          if(front==back){
              if(front.getStudent().getName().equals(name)){
                  return true;
              }
              break;
          }
          if(front.getStudent().getName().equals(name)){
              return true;
          }else{
              front = front.getNext();
          }
          if(back.getStudent().getName().equals(name)){
              return true;
          }else{
              back = back.getPrevious();
          }
          
      }
    // Returns true if the list contains a student with the given input name.
    // Returns false otherwise.
    //
    // Your method should look for the student moving inwards from both the front
    // of the list and the back of the list. This way, if the strudent is near either
    // end (front or back) the algorithm will be fast.
    // For each node in the list you should only check if it has a student with the 
    // given name once.
    
    return false;
  }
  
  public boolean containsUnique(String name){
      Node front = head;
      Node back = tail; 
      boolean found = false;
      while(front!=back){
          if(front.getStudent().getName().equals(name)){
              if (found==false){
                  found = true;
              }else if(found==true){
                  return false;
              }
          }else{
              front = front.getNext();
          }
          if(back.getStudent().getName().equals(name)){
              if (found==false){
                  found = true;
              }else if(found==true){
                  return false;
              }          
          }else{
              back = back.getPrevious();
          }
      }
    // Returns true of the list contains exactly one student with the given input name.
    // Returns false otherwie.
    //
    // Like the contains method, you should be starting from both ends of the list and 
    // looking inwards to solve this problem. Consider when you should return false.
    // Again, for each node in the list you should only check if it has a student
    // with the given name once.
    
    
    return true;
  }
  
  
  public boolean hasCycle(){
    // Returns true of the list has a cycle and false otherwise.
    
    return true;
  }
  
  
  
}
