// ---------------------------------------------------------------------------
// In this .cpp file you will provide the source code for all
// functions, constructors and method specified in A4Tyope,h that are not yet defined.
// You are allowed to write helper functions but are not allowed to change the
// class definitions.
//
// Student Name:     Jacob Larose
// Student Number:   101013798
//
// References:       "I did not use any reference material in developing this assignment."//
// ---------------------------------------------------------------------------



#include "A4Types.h"
#include <iostream>


// Note: When defining method behaviour in C++ class
//       in a different location than the actual class
//       definition (.h file) we need to specify not only the
//       name of the function but also which class it belongs to.
//       We use Return_Type Class_Name::Method_Name to do this->


Money::Money(){
    this->numDimes = 0;
    this->numDollars = 0;
    this->numQuarters = 0;
    this->numNickels = 0;
    this->numPennies = 0;
}

Money::Money(unsigned int dollars, unsigned int cents){
    this->numDimes = 0;
    this->numDollars = dollars;
    this->numQuarters = 0;
    this->numNickels = 0;
    this->numPennies = cents;
}

Money::Money(unsigned int dd, unsigned int q, unsigned int d, unsigned int n, unsigned int p){
    this->numDimes = d;
    this->numDollars = dd;
    this->numQuarters = q;
    this->numNickels = n;
    this->numPennies = p;
}

// getters provided for you
// Note that we still need to specify which class the
// methods belong to.
unsigned int Money::getDollars(){  return numDollars;}
unsigned int Money::getQuarters(){ return numQuarters;}
unsigned int Money::getDimes(){    return numDimes;}
unsigned int Money::getNickels(){  return numNickels;}
unsigned int Money::getPennies(){  return numPennies;}

unsigned int Money::getCents(){
    unsigned int q = 25*(this->numQuarters);
    unsigned int d = 10*(this->numDimes);
    unsigned int n = 5*(this->numNickels);
    unsigned int p = this->numPennies;
    unsigned int t = (q+d+n+p);
    return t;
}

// setter functions
void Money::addMoney(Money m){
    this->numDimes += m.numDimes;
    this->numDollars += m.numDollars;
    this->numQuarters += m.numQuarters;
    this->numNickels += m.numNickels;
    this->numPennies += m.numPennies;
}
void Money::addDollars(unsigned int d){
    this->numDollars += d;
}
void Money::addQuarters(unsigned int q){
    this->numQuarters += q;
}
void Money::addDimes(unsigned int d){
    this->numDimes += d;
}
void Money::addNickels(unsigned int n){
    this->numNickels += n;
}
void Money::addPennies(unsigned int p){
    this->numPennies += p;
}
void Money::addCents(unsigned int c){
    this->numPennies += c;
}

// other methods
void Money::leastCoins(){
    unsigned int pToN = this->numPennies/5;//penies to nickels
    this->numNickels += pToN;
    this->numPennies -= (5*pToN);

    unsigned int nd = (10*this->numDimes) + (5*this->numNickels);  //nickels and dimes total value
    unsigned int ndToQR = nd%25;//nickels and dimes to quarters remainder
    unsigned int ndToQ = nd/25; //nickels and dimes to quarters
    this->numQuarters += ndToQ;

    unsigned int ndToQRtoDR = ndToQR%10; //nickels and dimes to quarters remainder back to dimes remainder
    unsigned int ndToQRtoD = ndToQR/10; //nickels and dimes to quarters remainder back to dimes
    this->numDimes = ndToQRtoD;

    unsigned int ndToQRtoDRtoN = ndToQRtoDR/5; //nickels and dimes to quarters remainder back to dimes remainder to nickels
    this->numNickels = ndToQRtoDRtoN;

    unsigned int qToD = this->numQuarters/4;
    this->numDollars += qToD;
    this->numQuarters -= (4*qToD);
}
unsigned int Money::numberOfCoins(){
    unsigned int q = (this->numQuarters);
    unsigned int d = (this->numDimes);
    unsigned int n = (this->numNickels);
    unsigned int p = this->numPennies;
    unsigned int t = (q+d+n+p);
    return t;
}


//
// Functions using Money objects for Exercise 4
//

Money* makeChange(Money& cost,  Money& paid){
    Money* change = new Money;
    unsigned int dd = 100*cost.getDollars();
    unsigned int q = 25*cost.getQuarters();
    unsigned int d = 10*cost.getDimes();
    unsigned int n = 5*cost.getNickels();
    unsigned int p = cost.getPennies();
    unsigned int tc = (dd+q+d+n+p);//total cost in cents

    dd = 100*paid.getDollars();
    q = 25*paid.getQuarters();
    d = 10*paid.getDimes();
    n = 5*paid.getNickels();
    p = paid.getPennies();
    unsigned int tp = (dd+q+d+n+p);//total paid in cents

    if (tc>tp){
        return NULL;
    }
    else{
        unsigned int remainder = tp-tc;

        change->addCents(remainder);
        change->leastCoins();

        return change;
    }

}
Money* makeChangeNpPennies(Money& cost, Money& paid);



