#include <iostream>
#include <string>

#include "A4Types.h"


using namespace std;




int main()
{
    // test your code here
    Money m(17,3,5,6,10);
    std::cout << m.getDollars() << " m dollars \n"
              << m.getCents() << " total cents \n"
              << m.getQuarters() <<" quareters \n"
              << m.getDimes() << " dimes \n"
              << m.getNickels() <<" nickels \n"
              << m.getPennies() <<" pennies \n"<< std::endl;
    m.leastCoins();
    std::cout << m.getDollars() << " m2 dollars \n "
              << m.getCents() << " total cents \n"
              << m.getQuarters() <<" quareters \n"
              << m.getDimes() << " dimes \n"
              << m.getNickels() <<" nickels \n"
              << m.getPennies() <<" pennies \n"<< std::endl;
    Money p(16,2,6,8,7);
    p.leastCoins();
    std::cout << p.getDollars() << " p dollars \n "
              << p.getCents() << " total cents \n"
              << p.getQuarters() <<" quareters \n"
              << p.getDimes() << " dimes \n"
              << p.getNickels() <<" nickels \n"
              << p.getPennies() <<" pennies \n"<< std::endl;

    Money* x = makeChange(p, m);
    if (x==NULL){
        std::cout<<"null"<<std::endl;
    }else{
    std::cout << x->getDollars() << " x dollars \n "
              << x->getCents() << " total cents \n"
              << x->getQuarters() <<" quareters \n"
              << x->getDimes() << " dimes \n"
              << x->getNickels() <<" nickels \n"
              << x->getPennies() <<" pennies \n"<< std::endl;
    }

    return 0;
}
