#include <iostream>
#include <math.h>

void triples (int max)
{
    for(int x = 1;x<max;x++){
        for (int y=1;y<max;y++){
            int c2 = (x*x)+(y*y);
            int c = sqrt(c2);
            if(c<=max){
                std::cout<<x<<","<<y<<","<<c<<std::endl;
            }
        }
    }
}


int main()
{
    triples(25);
    return 0;
}


