#ifndef STUDENTFUNCTIONS_H_INCLUDED
#define STUDENTFUNCTIONS_H_INCLUDED

#include "T3Types.h"

// Function provided for you
std::string printStudent(const StudentType &s);

// Everyone is expected to complete these three functions
void setName(StudentType &student, std::string name);
void setID(StudentType* student, int id);
StudentType* newStudent(std::string name, int id);

// Everyone is expected to complete this function
void addGrade(StudentType &student, float newGrade);

// and hopefully get to this one
void removeGrades(StudentType* s);


// Exercise 2
float averageGrade(const StudentType* &student);
void addGrades(StudentType* student, float* grades, int numGrades);


// Exercise 3 (after modifying the StudentType struct)
float findGrade(StudentType s, std::string course);
std::string* findCourses(StudentType* s, float g);




#endif // STUDENTFUNCTIONS_H_INCLUDED
