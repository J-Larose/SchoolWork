#include <iostream>
#include <fstream>
#include <string>
#include <sstream>

#include "StudentFunctions.h"

// provided function
std::string printStudent(const StudentType &s){
    std::stringstream out;
    out.str("");
    out << s.name << " (" << s.id << ") [";
    for(int i=0; i<s.numGrades; ++i){
        out << s.grades[i] << ",";
    } out << "]";
    return out.str();
}

std::string printClassList(const ClassList& cl){
    std::stringstream out;
    out.str("");
    bool first = true;
    for(int i=0; i<cl.numStudents; i++){
        if(!first){
            out << "\n";
        }
        out << printStudent(cl.students[i]);
    }
    return out.str();
}

void clearStudent(StudentType* s){
    s->name = "none";
    s->id = 0;
    s->grades = NULL;
    s->numGrades = 0;
}




void setName(StudentType &student, std::string name){
    student.name = name;
}

void setID(StudentType* student, int id){
    student->id = id;
}

StudentType* newStudent(std::string name, int id){
    StudentType* student = new StudentType;
    student->name = name;
    student->grades = NULL;
    student->id = id;
    student->numGrades = 0;
    return student;
}

void addGrade(StudentType &student, float newGrade){
    student.numGrades += 1;
    int g = student.numGrades;
    float* hold = new float[g];

    for (int k=0;k<student.numGrades-1;k++){
        hold[k] = student.grades[k];
    }

    hold[student.numGrades-1] = newGrade;

    delete[] student.grades;
    student.grades = hold;

}

void removeGrades(StudentType* s){
    delete[] s->grades;
    s->grades = NULL;
    s->numGrades = 0;
}

float averageGrade(StudentType* student){
    if (student->grades==NULL){
        return -1.0;
    }
    else{
        float avg = 0.0;
        for (int k=0;k<student->numGrades;k++){
            avg += student->grades[k];
        }
        avg /= student->numGrades;
        return avg;
    }
}


void addGrades(StudentType* student, float* grades, int numGrades){
    int g = student->numGrades + numGrades;
    float* hold = new float[g];

    for (int k=0;k<student->numGrades;k++){
        hold[k] = student->grades[k];
    }

    for (int k=0;k<=numGrades;k++){
        hold[k+student->numGrades] = grades[k];
    }

    student->numGrades = g;
    delete[] student->grades;
    student->grades = hold;
}


//std:string findStudent(ClassList* clas, int id){
//    for (int k=0; k< clas->numStudents;k++){
//        if (clas->students[k]->id== id){
//            return clas->students[k]->id;
//        }
//    }
//}




