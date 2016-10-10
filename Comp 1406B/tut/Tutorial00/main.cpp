#include <iostream>
#include "basicIO.h"
#include "repetition.h"

int main()
{

    doSomeBasicIO();
    doSomethingRepetitive(117,14,21);

    std::cout << "GCD(123452, 6548776) = " << gcd(123452, 6548776) << std::endl;


    // The main function returns an integer.
    // If the program terminates successfully, you will return the
    // value 0.  Other numbers are used to indicate an error code
    // if something went wrong.
    return 0;
}
