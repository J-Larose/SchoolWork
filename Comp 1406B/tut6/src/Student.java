import java.util.ArrayList;

public class Student{
  
  private final String          name;   // the name cannot change once set
  private       int              id;
  private       ArrayList<Float> grades; 
  
  // constructors
  public Student(){
    name = "Cat";
    id = 1;
    grades = new ArrayList<Float>();
    grades.add(78.2f);
  }



  public Student(String name, int id){
    this.name = name;
    this.id = id;
    grades = new ArrayList<Float>();
  }
  
  public Student(String name, int id, ArrayList<Float> grades){
    this.name = name;
    this.id = id;
    this.grades = grades;
  }


  
  
  // getters
  public String           getName(){ return name; }
  public int              getID(){ return id; }
  public ArrayList<Float> getGrades(){ return grades; }
  
  // setters
  public void setID(int id){
      this.id = id;
  }
  public void setID(ArrayList<Float> newGrades){
      this.grades = newGrades;
  }
  
  
  public void addGrade(float newGrade){
      grades.add(newGrade);
  }
  public float avgGrade(){
      float avg = 0;
      for(int i = 0; i<grades.size(); i++){
          avg += grades.get(i);
      }
      return avg/grades.size();
  }
  public void addGrades(float[] newGrades){
    for(int i = 0; i<grades.size(); i++){
        grades.add(newGrades[i]);
    }
  }



}