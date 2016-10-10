#ifndef CARDS_H_INCLUDED
#define CARDS_H_INCLUDED

#include <string>

const int MAX_HAND_SIZE = 5;

struct cardType{
    int  rank;
    char suit;
};

struct handType{
    cardType cards[MAX_HAND_SIZE];
    int      numCards;
};


int compare(cardType firstCard, cardType seconCard);
int compare(handType firstHand, handType secondHand);


std::string displayHand(handType hand);



#endif // CARDS_H_INCLUDED
