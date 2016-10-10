#include "COMP1406W16A1.h"

int main()
{

    std::cout<<"The printed result here should equal 100   -> " << calculateYourFinalGrade(100, 100, 0, 100, 100, 100) << std::endl;

    std::cout<<"The printed result here should equal true  -> " << didYouPassTheCourse(50, 50, 50, 50) << std::endl;

    std::cout<<"The printed result here should equal A+    -> ";

    printLetterGrade(99);

    float testClass [] = {100, 50};

    std::cout<<"The printed result here should equal 75%   -> " << calculateClassStats(testClass, 2) << std::endl;

    return 0;
}
