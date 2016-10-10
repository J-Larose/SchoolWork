public class Tutorial7{
  
  public static void main(String[] args){
    
    DoublyLinkedList list = new DoublyLinkedList();
    list.addBack(new Student("cat", 12)).addBack(new Student("eel", 17));
    list.printForward();
    list.printBackward();
    
    System.out.println(list.size());
    
    list.addFront(new Student("fish", 3));
    list.printForward();
    
    list.removeBack();
    list.printForward();
    
    list.addBack(new Student("eel", 17));
    list.printForward();
    
    list.removeFront();
    list.printForward();
    
    list.add(new Student("dog", 15), 2);
    list.printForward();
    
    list.addFront(new Student("cat", 12));
    list.printForward();
    
    list.remove(2);
    list.printForward();
    
    System.out.println(list.contains("dog"));
  }
}