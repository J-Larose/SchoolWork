//"I did not use any reference material in developing this assignment."
//Jacob Larose, 101013798, COMP 1406B, assignment 2

#include "Cards.h"

int compare(cardType firstCard, cardType seconCard){
    if (firstCard.rank>seconCard.rank){
        return 1;
    }
    else if (seconCard.rank>firstCard.rank){
        return -1;
    }
    else{
        switch (firstCard.suit){
            case 'h' :
                switch (seconCard.suit){
                    case 'h' : return 0;
                    break;
                    case 'c' : return -1;
                    break;
                    case 'd' : return -1;
                    break;
                    case 's' : return -1;
                    break;
                }
            break;
            case 'c' :
                switch (seconCard.suit){
                    case 'h' : return 1;
                    break;
                    case 'c' : return 0;
                    break;
                    case 'd' : return -1;
                    break;
                    case 's' : return -1;
                    break;
                }
            case 'd' :
                switch (seconCard.suit){
                    case 'h' : return 1;
                    break;
                    case 'c' : return 1;
                    break;
                    case 'd' : return 0;
                    break;
                    case 's' : return -1;
                    break;
                }
            case 's' :
                switch (seconCard.suit){
                    case 'h' : return 1;
                    break;
                    case 'c' : return 1;
                    break;
                    case 'd' : return 1;
                    break;
                    case 's' : return 0;
                    break;
                }
        }
    }
}

int compare(handType firstHand, handType secondHand){
    //sort hand using bubble sort
    bool flip = true;
    while(flip==true){
        flip = false;
        cardType hold;
        for(int i=0; i<firstHand.numCards-1; i++){
            if(firstHand.cards[i].rank<firstHand.cards[i+1].rank){
                flip = true;
                hold = firstHand.cards[i];
                firstHand.cards[i] = firstHand.cards[i+1];
                firstHand.cards[i+1] = hold;
            }
        }
    }

    //sort hand2 using bubble sort
    flip = true;
    while(flip==true){
        flip = false;
        cardType hold;
        for(int i=0; i<secondHand.numCards-1; i++){
            if(secondHand.cards[i].rank<secondHand.cards[i+1].rank){
                flip = true;
                hold = secondHand.cards[i];
                secondHand.cards[i] = secondHand.cards[i+1];
                secondHand.cards[i+1] = hold;
            }
        }
    }

    for(int i=0; i>firstHand.numCards or i>secondHand.numCards; i++){
        if (firstHand.cards[i].rank>secondHand.cards[i].rank){
            return 1;
        }
        else if (secondHand.cards[i].rank>secondHand.cards[i].rank){
            return -1;
        }
    }

    return 0;

}

std::string displayHand(handType hand){
    std::string str = "";
    char allSuits [4] = {'h','c','d','s'};
    for(int x=0; x<4; x++){
        for(int i=0; i<hand.numCards; i++){
            if (hand.cards[i].suit==allSuits[x]){
                if (hand.cards[i].rank<11){
                    switch (hand.cards[i].rank){
                        case 2 : str += "2 of ";
                        break;
                        case 3 : str += "3 of ";
                        break;
                        case 4 : str += "4 of ";
                        break;
                        case 5 : str += "5 of ";
                        break;
                        case 6 : str += "6 of ";
                        break;
                        case 7 : str += "7 of ";
                        break;
                        case 8 : str += "8 of ";
                        break;
                        case 9 : str += "9 of ";
                        break;
                        case 10 : str += "10 of ";
                        break;
                    }
                }
                else{
                    switch (hand.cards[i].rank){
                        case 11 : str += "Jack of ";
                        break;
                        case 12 : str += "Queen of ";
                        break;
                        case 13 : str += "King of ";
                        break;
                        case 14 : str += "Ace of ";
                        break;

                    }
                }
                switch (x){
                    case 1 : str += "Clubs";
                    break;
                    case 0 : str += "Hearts";
                    break;
                    case 3 : str += "Spades";
                    break;
                    case 2 : str += "Diamonds";
                    break;
                }
            str += "\n";
            }
        }
    }
    return str;
}
