public class StudentTester{
  
   
  
  // use this class (program) to test your 
  // Student class
  public static void main(String[] args){
    Student s = new Student();
    printStudent(s);
    
  }
  
  // helper function
  public static void printStudent(Student s){
    // prints a student's info to the screen
    String out = s.getName() + ", {" + s.getID() + "}";
    float[] g = s.getGrades();
    int len = 0;
    if( g != null){
      len = g.length;
    }
    out += "  grades [";
    if( len > 0 ){
      for(int i=0; i<len-1; i+=1){
        out += g[i] + ",";
      }
      out += g[len-1];
    }
    out += "]";
    System.out.println(out); 
  }
  
}