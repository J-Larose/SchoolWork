#include <iostream>
#include <string>
#include <sstream>

#include "T3Types.h"
#include "StudentFunctions.h"

using namespace std;


int main()
{
    StudentType  student1;
    setName(student1, "dog");
    setID(&student1, 2);
    StudentType* student2 = newStudent("cat", 3);
    addGrade(student1, 100.0);
    addGrade(student1, 50.0);
    for (int j=0;j<student1.numGrades;j++){
        std::cout<<student1.grades[j]<<std::endl;
    }
    std::cout << printStudent(student1) << std::endl;
    std::cout << printStudent(*student2) << std::endl;

}
