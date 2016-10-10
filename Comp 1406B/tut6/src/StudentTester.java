  import java.util.Arrays;
  import java.util.ArrayList;

  public class StudentTester{
    
   
    
    // use this class (program) to test your 
    // Student class
    public static void main(String[] args){
      Student s = new Student();
      printStudent(s);


      StudentLinkedList list = new StudentLinkedList(s);
      System.out.println( list.toString() );


  
      // need to complete the Student constructors before un-commenting these
		
      StudentLinkedList biggerList = makeList(13);
      System.out.println( biggerList.toString() );
      
      
      System.out.println(findStudent(biggerList, 3));
      System.out.println(findStudent(biggerList, 4));
      
      Student best = topStudent(biggerList, 0);
      
      String b = best.getName();
      
      System.out.println(b);
      
      addStudent(list, s);
      System.out.println( list.toString() );

      
      
    }

public static String findStudent(StudentLinkedList classList, int id){
       Node current = classList.head;
       while (true){
           if (current.s.getID() == id){
               return current.s.getName();
           }else{
               if (current.next == null){
                   return "none";
               }else{
                   current = current.next;
               }
           }
       }
   }
   
   public static void addGrade(StudentLinkedList classList, String name, float grade){
       Node current = classList.head;
       while (true){
           if (current.s.getName().equals(name)){
               current.s.addGrade(grade);
           }else{
               if (current.next == null){
                   return;
               }else{
                   current = current.next;
               }
           }
       }
   }
   
   public static void addStudent(StudentLinkedList classList, Student student){
        Node current = classList.head;
        while (true){
            if (current.next == null){
                current.next = new Node(student);
                return;
            }else{
                current = current.next;
            }
        }
   }
   public static Student topStudent(StudentLinkedList classList, int cutoff){
       Node current = classList.head;
       Student best = current.s;
       while (true){
           if (current.s.avgGrade()>cutoff){
               if(best.avgGrade()<current.s.avgGrade()){
                   best = current.s;
               }
               if (current.next == null){
                   return best;
               }else{
                   current = current.next;
               }           
           }else{
               if (current.next == null){
                   return best;
               }else{
                   current = current.next;
               }
           }
       }
   }















    
    // helper function
    public static void printStudent(Student s){
      // prints a student's info to the screen
      String out = s.getName() + ", {id=" + s.getID() + "}";
      ArrayList<Float> g = s.getGrades();
      int len = 0;
      if( g != null){
        len = g.size();
      }
      out += "  grades=[";
      if( len > 0 ){
        for(int i=0; i<len-1; i+=1){
          out += g.get(i) + ",";
        }
        out += g.get(len-1);
      }
      out += "]";
      System.out.println(out); 
    }
    

   public static String[] names = {"Zeppo", "Harpo", "Groucho", "Chico", "Jean", "Maud", "Laverne", 
                                  "Maxine", "Patty", "Stan", "Laurel", "Pearl", "Josephine", "Lou", 
                                  "Bud", "Moe", "Shemp", "Larry", "Curly", "Joe", "Curly Joe"};

   public static StudentLinkedList makeList(int num){
     // generates a random linked list of length num to test your code
    num = (int) Math.min(21, num);
    num = (int) Math.max(1, num);

    StudentLinkedList list = new StudentLinkedList(new Student("Gummo", 1, randomGrades() ) );
    for(int i=0; i<num; i+=1){
      Node node = new Node(new Student(names[i], i+3, randomGrades()));
      node.next = list.head;
      list.head = node;
    }
    return list;

   }

   public static ArrayList<Float> randomGrades(){
    int n = (int)(Math.random()*4) + 1;
    ArrayList<Float> grades = new ArrayList<Float>();
    for(int i=0; i<n; i+=1){
      grades.add( (float) Math.random()*90 + 10.0f);
    }
    return grades;
   }

  }