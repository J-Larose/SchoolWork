// ---------------------------------------------------------------------------
// In this .cpp file you will provide the source code for function definitions
// specified in COMP1406W16A1.h, along with any "helper" functions you wish to
// implement.
//
// Student Name:     Jacob Larose
// Student Number:   101013798
//
// References:       <consult the plagiarism policy for instruction>
//
// ---------------------------------------------------------------------------

// the following include is the only include permitted for this assignment
#include "COMP1406W16A1.h"

//! \brief eliminates the lowest quiz mark then calculates the avg based on weightage
//!
//! \param avgT float
//! \param avgA float
//! \param markQ1 float
//! \param markQ2 float
//! \param markQ3 float
//! \param markF float
//! \return float
//!
//!
float calculateYourFinalGrade(float avgT, float avgA, float markQ1, float markQ2, float markQ3, float markF){
    float quizAvg;
    float quizes [3] = {markQ1, markQ2, markQ3};
    float small = 101;
    for (int i = 0; i<3; i++){
        if (quizes[i]<small){
            small = quizes[i];
        }
    }
    for (int i = 0; i<3; i++){
        if (quizes[i] != small){
            quizAvg += quizes[i];
        }
    }
    quizAvg /= 2;



    float finalGr = (quizAvg*0.2)+(avgT*0.1)+(avgA*0.3)+(markF*0.4);
    return finalGr;
}

//! \brief based on wightage, determines whether the avg is above 50
//!
//! \param avgT float
//! \param avgQ float
//! \param avgA float
//! \param markF float
//! \return bool
//!
//!
bool  didYouPassTheCourse(float avgT, float avgQ, float avgA, float markF){
    if (((avgQ*0.2)+(avgT*0.1)+(avgA*0.3)+(markF*0.4))>=50){
        return true;
    }else{
        return false;
    }
}

//! \brief converts float to proper letter string then prints to console
//!
//! \param mark float
//! \return void
//!
//!
void  printLetterGrade(float mark){
    std::string letters [13] = {"A+","A","A-","B+","B","B-","C+","C","C-","D+","D","D-","F"};
    int num[13] = {90,85,80,77,73,70,67,63,60,57,53,50,0};
    for (int i = 0; i<13; i++){
        if (num[i]<=mark){
            std::cout<<letters[i]<<std::endl;
            break;
        }
    }
}

//! \brief prints full array marks with letter grades and returns avg perce
//!
//! \param marks[] float
//! \param length int
//! \return float finalAvg
//!
//!
float calculateClassStats(float marks[], int length){
    float finalAvg = 0;
    for(int i=0; i<length; i++){
        finalAvg += marks[i];
        std::cout<<marks[i]<<"%, or ";
        printLetterGrade(marks[i]);
    }
    finalAvg /= length;
    return finalAvg;
}
