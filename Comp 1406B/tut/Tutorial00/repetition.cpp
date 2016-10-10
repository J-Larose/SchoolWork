#include "repetition.h"
#include <math.h>
long doSomethingRepetitive(int a, int b, int c){
    int count = 1;

    for(int i=0; i<a; ++i){
        count += b;
    }

    while(count > 3*a){
        count -= c;
    }

    do{
        count += (a+b/2*c/3);
    }while(count > a*b*c);

    std::cout << "count is " << count << std::endl;

    return count;
}

long gcd(long a, long b){
    double d=0.0;
    while (a%2==0 and b%2==0){
        a /= 2;
        b /= 2;
        d += 1;
    }
    while (a!=b){
        if (a%2==0){
            a /= 2;
        }
        else if(b%2==0){
            b /= 2;
        }
        else if (a>b){
            a = (a-b)/2;
        }
        else{
            b = (b-a)/2;
        }
    }

    long g = a*(pow(2.0,d));
    return g;
}

//
// TODO!
//
// implement the gcd function here using the binary method of computing the GCD
// found at https://en.wikipedia.org/wiki/Greatest_common_divisor#Binary_method
//
//


