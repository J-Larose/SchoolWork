// system libraries
#include <iostream>
#include <string>


// assignment header files
#include "Stats.h"
#include "Cards.h"
#include "Chess.h"

using namespace std;


int main()
{
    // Problem 1


    int numbers[5] = {3,80,70,100,75};
    std::cout << trimmedMean(numbers, 5, 2) << std::endl;

    // Problem 2
    cardType c1, c2;
    c1.rank = 3;
    c1.suit = 's';        //   <-- fixed the typo here

    c2.rank = 13;
    c2.suit = 'd';

    handType h;
    h.cards[0] = c1;
    h.cards[1] = c2;
    h.numCards = 2;

    std::cout << displayHand(h) << std::endl;

    std::cout << "compare(c1,c2) = " << compare(c1,c2) << std::endl;


    // Problem 3
    //
    // Note: the chessDriver is provided to help you test your code.  We will be calling
    //        your validMoves function on different boards when grading and not using this
    //        function as provided.
    chessDriver();


    return 0;

}
