#ifndef STUDENTFUNCTIONS_H_INCLUDED
#define STUDENTFUNCTIONS_H_INCLUDED

#include <string>
#include "T4Types.h"

// Function provided for you
std::string printStudent(const StudentType &s);
std::string printClassList(const ClassList &cl);

void clearStudent(StudentType* s);


// Exercise 1
void setName(StudentType &student, std::string name);
void setID(StudentType* student, int id);
StudentType* newStudent(std::string name, int id);
void addGrade(StudentType &student, float newGrade);
void removeGrades(StudentType* s);


// Exercise 2
float averageGrade(StudentType* student);
void addGrades(StudentType* student, float* grades, int numGrades);

// Exercise 3
std::string findStudent(ClassList* cl, int id);
StudentType* topStudent(ClassList& cl, int cutoff);
void addGrade(ClassList* cl, std::string name, float grade);

// Challenge
float findGrade(StudentType s, std::string course);
std::string* findCourses(StudentType* s, float g);
StudentType* studentsInRange(ClassList& cl, float lo, float hi);



#endif // STUDENTFUNCTIONS_H_INCLUDED
