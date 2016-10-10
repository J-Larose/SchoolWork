#include <iostream>
#include <string>
#include <sstream>

#include "T4Types.h"
#include "StudentFunctions.h"

using namespace std;


int main()
{
    StudentType  student1;
    clearStudent(&student1);
    setName(student1, "dog");
    setID(&student1, 2);
    addGrade(student1, 76);
    addGrade(student1, 86);
    addGrade(student1, 46);

    StudentType* student2 = newStudent("cat", 3);
    addGrade(*student2, 92);
    addGrade(*student2, 100);
    addGrade(*student2, 85);

    float grades[3] ={2.0, 3.0, 4.0};
    addGrades(student2, grades, 3);

    std::cout << printStudent(student1) << std::endl;
    std::cout << printStudent(*student2) << std::endl;
    std::cout << "avg: " << averageGrade(student2) << std::endl;

}
