#include <sstream>
#include "StudentFunctions.h"

// provided function

void setName(StudentType &student, std::string name){
    student.name = name;
}

void setID(StudentType* student, int id){
    student->id = id;
}

StudentType* newStudent(std::string name, int id){
    StudentType* student = new StudentType;
    student->name = name;
    student->id = id;
    return student;
}

void addGrade(StudentType &student, float newGrade){
    student.numGrades += 1;

    float* hold = new float[student.numGrades];

    for (int k=0;k<student.numGrades-1;k++){
        hold[k] = student.grades[k];
    }

    hold[student.numGrades-1] = newGrade;

    delete[] student.grades;
    student.grades = hold;

}

void removeGrades(StudentType* s){
    delete[] s->grades;
    s->numGrades = 0;
}

float averageGrade(const StudentType* &student);{

    if ()
}


std::string printStudent(const StudentType &s){
    std::stringstream out;
    out.str("");
    out << s.name << " (" << s.id << ")";
    return out.str();
}

