import java.util.ArrayList;

//author: Alex Gagnon

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
  this.grades = new ArrayList<Float>();  
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
 public void setID(int id) { this.id = id; }
 public void setGrades(ArrayList<Float> grades) { this.grades = grades; }
 
 public void addGrade(float newGrade) {
  //if for some reason it's null, assign it a new float arraylist.
  if (this.grades == null) {
   this.grades = new ArrayList<Float>();
  }
  
  //use arraylist's 'add' method to add a single float
  this.grades.add(newGrade);
 }
 
 
 public float averageGrade() {
  //if there are no elements, return -1. Check for null first, so this.grades.size()
  //doesn't throw a null pointer exception
  if (this.grades == null || this.grades.size() == 0) return -1.0f;
  
  //add the grades
  float sum = 0.0f;
  for (float f : this.grades) {
   sum += f;
  }
  
  //return the average, casting the size() int to a float to make sure it's
  //a decimal value
  return sum / (float) this.grades.size();
 }
 
 
 public void addGrades(float[] newGrades) {
  //if newGrades is empty, we don't need to add anything
  if (newGrades == null || newGrades.length == 0) return;
  
  //if this.grades was null, assign it a new float arraylist
  if (this.grades == null) {
   this.grades = new ArrayList<Float>();
  }
  
  //copy over the grades, using arrayList's 'add' method
  for (float f : newGrades) {
   this.grades.add(f);
  }
 }
 
 
 //this method is the same, but takes an arrayList as an argument, rather
 //than a float array. We can use a handy arrayList method to add them in one
 //line
 public void addGrades(ArrayList<Float> newGrades) {
  //same as above
  if (newGrades == null || newGrades.size() == 0) return;
  
  if (this.grades == null) {
   this.grades = new ArrayList<Float>();
  }
  
  //we can add two using arrayList's 'addAll', which takes a Collection (
  //an ArrayList is a Collection, so we can sub it in).
  this.grades.addAll(newGrades);
 }
}
