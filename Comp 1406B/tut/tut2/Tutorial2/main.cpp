#include <iostream>

#include "Functions.h"

using namespace std;



int main()
{
    // Exercise 1
    int matrix[] = {1,3,7,2,4,1,-3,8,9};
    std::cout << maxInMatrix(matrix, 3) << std::endl;



    int a,b,c = 13;
    bool isThereTripleWithC13 = triples(a,b,c);
    if(isThereTripleWithC13){
        cout << "(" << a << "," << b << "," << c << ")" << endl;
    }


    // Exercise 3
    int x[] = {3,1,8,2};
    int minN, maxN, product;
    product = maxAndMin( x, 4, maxN, minN );
    cout << minN << " x " << maxN << " = " << product;

    std::string blue = letterCount();

    return 0;
}
