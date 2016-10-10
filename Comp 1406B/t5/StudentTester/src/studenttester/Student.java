package studenttester;

public class Student{
  
  private final String   name;   // the name cannot change once set
  private       int      id;
  private       float[]  grades;
  
  // constrcutors
  public Student(){
    name = "Cat";
    id = 1;
    grades = new float[]{74.3f};
  }

  public Student(String name, int id){
      this.name = name;
      this.id = id;
  }
  
  public Student(String name, int id, float[] grades){
      this.name = name;
      this.id = id;
      this.grades = grades;
  }
  
  
  
  // getters
  public String  getName(){ return name; }
  public int     getID(){ return id; }
  public float[] getGrades(){ return grades; }
  
  // setters

  public void setID(int id){
      this.id = id;
  }
  public void setGrades(float[] grade){
      this.grades = grade;
  }

  public void addGrade(float newGrade){
      float[] newGrades = new float[this.grades.length+1];
      
      System.arraycopy(this.grades, 0, newGrades, 0, this.grades.length);
      
      newGrades[newGrades.length-1] = newGrade;
      
      this.grades = newGrades;
  }
  
  public float avgGrade(){
      if (this.grades.length<1){
          return -1;
      }
      else{
          float avg = 0;
          for(float i : this.grades){
              avg += i;
          }
          return avg/this.grades.length;
      }
  }
  
 public void addGrades(float[] newGrade){
      float[] newGrades = new float[this.grades.length+newGrade.length];
      
      System.arraycopy(this.grades, 0, newGrades, 0, this.grades.length);
      System.arraycopy(newGrade, 0, newGrades, this.grades.length, newGrade.length);
      
      this.grades = newGrades;
  }



}