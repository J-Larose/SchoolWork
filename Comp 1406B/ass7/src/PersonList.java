/**
 * COMP1406 - W16 - Assignment 7.
 * 
 * This class implements a list of people (Person objects)
 * using a linked list. 
 * 
 * @author Jacob Larose
 * @since <add date of final revision>
 * @custom.citations "I did not use any reference material in developing this assignment."
 */



public class PersonList{
  /* ----------------------------------------------- */
  /* Attributes                                      */
  /* ----------------------------------------------- */
  
  /* head is the first node in the linked list */
  private Node head;
  
  
  /* ----------------------------------------------- */
  /* constructors                                    */
  /* ----------------------------------------------- */
  
  /** Creates an empty list. */
  public PersonList(){ 
      head = null;
  }
  
  /** Creates a list with a single person.
    * 
    * @param p is a Person that will be the only person in the new list
    */ 
  public PersonList(Person p){
      head = new Node(p);
  }
  
  
  /* ----------------------------------------------- */
  /* Methods                                         */
  /* ----------------------------------------------- */
  
  /**
   * The size of the list. 
   * 
   * This is the number of people in the list. If a person
   * is in the list more than once they are counted each time they appear. 
   * For example, the list [sam(12), sam(12), sam(12)] has size 3, even though
   * it is the same person listed three times.
   * 
   * @return the number of people in the list.
   */
  public int size(){
      Node node = head;
      int count = 1;
      while(true){
          if (node.getNext()==null){
              break;
          }
          node = node.getNext();
          count ++;
          
      }
    return count;
  }
  
  /**
   * Add a person to the front of the list. 
   * 
   * After the method is called, this.head should reference this 
   * newly added person. 
   * 
   * @param p is a person to be added to the front of the list. 
   * @return  this for chaining
   */
  public PersonList add(Person p){
      if (head!=null){
        Node newHead = new Node(p);
        newHead.setNext(head);
        head = newHead;
      }else{
          head = new Node(p);
      }
      
      return this;
  }

  /**
   * Add a person to a given position in the list.
   * 
   * The indexing is the same as if the list were an array. The first element
   * is at position 0, the second element is at position 1, ..., the last 
   * element is at position this.size()-1.
   * 
   * When adding a person at position M, all people in the original list at positions
   * M, M+1, ..., size()-1, will be shifted over one place (to the right) in the list.
   * If the list was originally [sam(12), joe(17)] and add is called with person 
   * ellen(13) at position 1, then this list becomes [sam(12), ellen(13), joe(17)] 
   *  
   * @param p is a person to add to the list.
   * @param position is the position in the list to add (insert) this person.
   * Positon 0 is the front of the list, position 1 is the 2nd element, etc.
   */
  public PersonList add(Person p, int position){ 
      if (position==0){
          Node newHead = new Node(p);
          
          newHead.setNext(head);
          head = newHead;
      }else{
        Node lst = head;
        Node newNode = new Node(p);
        for(int i=1; i<position; i++){
            lst = lst.getNext();
        }

        newNode.setNext(lst.getNext());

        lst.setNext(newNode);
      }
            
      return this; 
  }
  
  /**
   * Adds several people to the list starting at a given position.
   * 
   * For example, if this is the list [cat, dog, eel] and people is
   * the list [one, two , three], then add(people, 0) would change 
   * this be [one, two, three, cat, dog, eel], while add(people,1)
   * would change this list to be [cat, one, two, three, dog, eel].
   * 
   * @param people is a list of people to add to the current list.
   * @param startPosition is the position in the current list that the new 
   * list is added (inserted). The order of the elements in the new list remain
   * the same. 
   */
  public PersonList add(PersonList people, int startPosition){ 
      if(startPosition == 0){
          Node nxt = this.head;
          this.head = people.nodeAt(0);
          for(int i=0; true; i++){
            if(people.nodeAt(i).getNext()==null){
                people.nodeAt(i).setNext(nxt);
                break;
            }
          }
      }else{
        Node lst = this.head;
        for(int i=1; i<startPosition; i++){
            lst = lst.getNext();
        }
        Node nxt = lst.getNext();

        lst.setNext(people.nodeAt(0));

        for(int i=0; true; i++){
            if(people.nodeAt(i).getNext()==null){
                people.nodeAt(i).setNext(nxt);
                break;
            }
        }
      }
      
      return this;
  }
  private Node nodeAt(int pos){
      Node node = head;
      for(int i=0; i<pos; i++){
          node = node.getNext();
      }
      return node;
  }

  /**
   * Finds the position in the list where a given person is.
   * 
   * @param p is a person that may or may not be in the list.
   * @return the index position (starting with 0) in the list where the 
   * first instance of of person p is located. (A person may be in the list 
   * more than once.)
   * If the person is not in the list returns -1.
   */
  public int findPosition(Person p){ 
      Node node = head;
      for(int i=0; i<this.size(); i++){
          if (node.getPerson()==p){
              return i;
          }
          node = node.getNext();
      }
      return -1;
  }
  
  /** 
   * Finds the person at a given index in the list
   * 
   * You can assume that 0 <= position < this.sise()
   * 
   * @param position is a position in the list. It must satisfy
   * 0 <= position < this.size().
   * @return the person located at the specified position in the list.
   * The method does NOT remove the person from the list.
   */
  public Person personAt(int position){
      Node node = head;
      for(int i=0; i<position; i++){
          node = node.getNext();
      }
      return node.getPerson(); 
  }
  
  /**
   * Removes a person from a given position in the list.
   * 
   * @param position is the index in the list that we wish to remove a person.
   * @return the person that is removed from the list.
   */ 
  public Person remove(int position){ 
      if(position == 0){
          Node oldHead = head;
          head = head.getNext();
          return oldHead.getPerson();
      }
      
      Node lst = head;
      for(int i=0; i<position-1; i++){
          lst = lst.getNext();
      }
      Node rmv = lst.getNext();
      lst.setNext(rmv.getNext());
      
      return rmv.getPerson();
  }   
  
  /** 
   * remove several people from the list and returns them as a list of people. 
   * 
   * @param startPosition is starting position (index in the list) 
   * of the first person to remove (inclusive).
   * @param endPosition is the ending position (index in the list or one beyond) of the
   * last person EXCLUSIVE. 
   * @return a list of people from index position startPosition to endPosition - 1, 
   * in the same order, as this list before the method is called. 
   * The people returned are also removed from the current list.
   */
  public PersonList remove(int startPosition, int endPosition){ 
      PersonList rmvList = new PersonList();
      
      if(startPosition == 0){
          Node node = head;
          rmvList.addBack(node.getPerson());
          for(int i=0; i<endPosition-1; i++){
            node = node.getNext();
            rmvList.addBack(node.getPerson());
          }
          head = (node.getNext());
      }else{
        Node lst = head;
        for(int i=0; i<startPosition-1; i++){
            lst = lst.getNext();
        }
        Node node = lst;
        
        for(int i=0; i<endPosition-1; i++){
            node = node.getNext();
            rmvList.addBack(node.getPerson());
        }
        lst.setNext(node.getNext());
     }
      
      return rmvList;
  }
  
  /** 
   * Checks if this list is the "same" and another list.
   * 
   * Two lists are the same if they have the same people in the same order.
   * Two people are the same if they have the same name (ignoring case) and 
   * the same age. An empty list is not the same as null.
   * 
   * @param otherList is a list of people.
   * @return true if this list contains the same people (none less or more) as the people 
   * in otherList and in the exact same order. 
   * 
   * Returns false otherwise.
   */
  public boolean sameAs(PersonList otherList){
      Node node = this.head;
      if(this.size()!=otherList.size()){
          return false;
      }
      for(int i=0; i<this.size(); i++){
          if (!this.nodeAt(i).getPerson().getName().equals(otherList.nodeAt(i).getPerson().getName()) &&
                  this.nodeAt(i).getPerson().getAge()!=otherList.nodeAt(i).getPerson().getAge()){
              return false;
          }
      }
      return true;
  }
  
  /**
   * A list of all people in this list that have age strictly greater than some cutoff age.
   * 
   * @param age the cutoff age for the output list.
   * @return a list of all people in this list that have age strictly greater than the input cutoff age.
   * The order of the people in the returned list is the same as in this list. 
   * This method does NOT remove any people from this list.
   */
  public PersonList olderThan(int age){
      PersonList older = new PersonList();
      
      Node node = head;
      while(true){
          if (node.getPerson().getAge()>age){
              older.addBack(node.getPerson());
          }
          if (node.getNext()==null){
              break;
          }
          node = node.getNext();
      }
      
      return older; 
  }

  private PersonList addBack(Person newPerson){
      
      if (head!=null){
        Node node = this.head;
        while(node.getNext() != null){
          node = node.getNext();
        }
        node.setNext(new Node(newPerson));
      }else{
          this.head = new Node(newPerson);
      }
      
      return this;
  }
  
  /**
   * A String representation of this list. 
   * 
   * If this list consists of the people
   * [cat age 12, dog age 17, eel age 3], the output string should look identical 
   * (without the double quotes) to "[cat(12), dog(17), eel(3)]". An empty list will
   * return "[]". Be sure not to have a trailing comma after the last person 
   * in the list.
   * 
   * @return a string representation of this list.
   */
  @Override
  public String toString(){ 
      StringBuilder str = new StringBuilder();
      
      Node node = head;
      str.append(node.getPerson().getName()).append(" age ").append(node.getPerson().getAge()).append(", ");

      while (node.getNext() != null){
          node = node.getNext();
          str.append(node.getPerson().getName()).append(" age ").append(node.getPerson().getAge()).append(", ");
      }
      
      return str.toString(); 
  }
  
}  

