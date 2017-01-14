#include <stdio.h>
#include <string.h>

#define MAX_ARR  64
#define MAX_STR  32

typedef struct {
  char  code[MAX_STR];
  int   grade;
} CourseType;

typedef struct {
  CourseType elements[MAX_ARR];
  int size;
} CourseArrType;

typedef struct {
  char name[MAX_STR];
  char id[MAX_STR];
  CourseArrType courses;
  float gpa;
} StudentType;

void readString(char*);
void readInt(int*);
void buildStudent(StudentType *student);
void printStuArray(StudentType* arr, int arrLength);
/**
This program creates an array of students and then prints them
BY: Jacob Larose, 101013798
*/
int main()
{
  StudentType arr[MAX_ARR];
  int arrLength = 0;
  int cont;
  while(arrLength<MAX_ARR){
    printf("add another student?(1 for yes/0 for no)\n");
    readInt(&cont);
    if (cont==0){
      break;
    }
    buildStudent(arr+arrLength);
    arrLength++;
  }

  printStuArray(arr, arrLength);
  return 0;
}
/*
    Function:  buildStudent
    Purpose:   builds a student object based on user input
     in/out:   student: pointer to the student object to be built
*/
void buildStudent(StudentType *student){
  printf("enter name:\n");
  readString(student->name);
  printf("enter id: \n");
  readString(student->id);

  int cont;
  student->courses.size=0;

  while(student->courses.size < MAX_ARR){
    printf("add another course?(1 for yes/0 for no)\n");
    readInt(&cont);
    if (cont==0){
      break;
    }
    printf("enter code\n");
    readString(student->courses.elements[student->courses.size].code);
    printf("enter grade\n");
    readInt(&student->courses.elements[student->courses.size].grade);
    student->courses.size++;
  }


  float avg=0;

  for (int i = 0; i < student->courses.size; ++i){
    avg+= student->courses.elements[i].grade;
  }

  if (student->courses.size!=0){
    avg = avg/student->courses.size;
  }
  
  student->gpa = avg;
}
/*
    Function:  printStuArray
    Purpose:   prints all properties of array of students
         in:   arr: array of students
               arrLength: lenght of the array
*/
void printStuArray(StudentType* arr, int arrLength){
  StudentType* curStu;
  for (int i = 0; i < arrLength; i++)
  {
    curStu = arr+i;
    printf("student %d\n", i+1);
    printf("name: %s\n", curStu->name);
    printf("id: %s\n", curStu->id);
    for (int x = 0; x < curStu->courses.size; x++)
    {
      printf("Code: %s\n", curStu->courses.elements[x].code);
      printf("Grade: %d\n", curStu->courses.elements[x].grade);
    }
    printf("GPA: %f\n", curStu->gpa);
  }
}

/*
    Function:  readString
    Purpose:   reads a string from standard input
        out:   string read in from the user
               (must be allocated in calling function)
*/
void readString(char *str)
{
  char tmpStr[MAX_STR];

  fgets(tmpStr, sizeof(tmpStr), stdin);
  tmpStr[strlen(tmpStr)-1] = '\0';
  strcpy(str, tmpStr);
}

/*
    Function:  readInt
    Purpose:   reads an integer from standard input
        out:   integer read in from the user
               (must be allocated in calling function)
*/
void readInt(int *x)
{
  char str[MAX_STR];

  readString(str);
  sscanf(str, "%d", x);
}
