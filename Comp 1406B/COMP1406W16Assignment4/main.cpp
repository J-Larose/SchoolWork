#include <iostream>
#include <string>

#include "A4Types.h"


using namespace std;




int main()
{
    // test your code here
    Money m(17,3);
    std::cout << m.getDollars() << " dollars and "
              << m.getCents() << " cents" << std::endl;



    return 0;
}
