/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studenttester;

public class StudentTester{
  
   
  
  // use this class (program) to test your 
  // Student class
  public static void main(String[] args){
    float[] grds = {1,2,3};
    float[] grds2 = {2,3,4};
    Student s = new Student("anme", 2, grds);
    Student s2 = new Student();
    
    Student[] classList = {s,s2};
    
    System.out.println(findStudent(classList, 1));
    s.setGrades(grds2);
    s.addGrade(5);
    s.addGrades(grds);
    
    printStudent(s);
    System.out.println(s.avgGrade());    
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
  
  
  
  public static String findStudent(Student[] classList, int id){
      for(Student s : classList){
          if (s.getID() == id){
              return s.getName();
          }
      }
      return "none";
  }
}

