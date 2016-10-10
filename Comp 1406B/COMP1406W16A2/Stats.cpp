//"I did not use any reference material in developing this assignment."
//Jacob Larose, 101013798, COMP 1406B, assignment 2

#ifndef STATS_CPP_INCLUDED
#define STATS_CPP_INCLUDED

#include "Stats.h"

double trimmedMean(int data[], int dataSize, int outliers)
{
    //sort data using bubble sort
    bool flip = true;
    while(flip==true){
        flip = false;
        int hold;
        for(int i=0; i<dataSize-1; i++){
            if(data[i]>data[i+1]){
                flip = true;
                hold = data[i];
                data[i] = data[i+1];
                data[i+1] = hold;
            }
        }
    }

    for(int i=0; i<outliers; i++){
        data[i] = 0;
    }
    for(int i=dataSize-1; i>(dataSize-1-outliers); i--){
        data[i] = 0;
    }
    int sum = 0;
    for(int i=0; i<dataSize; i++){
        sum += data[i];
    }
    int denom = (dataSize-(2*outliers));
    double avg = (sum/denom);
    return avg;
}


#endif // STATS_CPP_INCLUDED
