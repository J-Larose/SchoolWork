#ifndef T4TYPES_H_INCLUDED
#define T4TYPES_H_INCLUDED


struct StudentType{
    std::string name;
    int         id;
    int         numGrades;
    float*      grades;
};

struct ClassList{
    std::string   name;
    int           numStudents;
    StudentType*  students;
};

#endif // T4TYPES_H_INCLUDED
