#include "Functions.h"


// Exercise 1
int maxInMatrix( int matrix[], int d ){
    int large = 0;
    int total = 0;
    int largeInt [3] = {0,0,0};

    for (int i=0; i<d;i++){
        total = 0;
        for (int j=0; j<d;j++){
            int x = matrix[(i*d)+j];
            total += x;
            if (matrix[(i*d)+j]>largeInt[0]){
                largeInt[0] = matrix[(i*d)+j];
                largeInt[1] = i+1;
                largeInt[2] = j+1;
            }
        }
        if (total>large){
            large = total;
        }
    }
    std::cout<<"largest: "<<large<<"\n largest int @: row"<<largeInt[1]<<"col: "<<largeInt[2]<<std::endl;
    return -1;
}





// Exercise 2
bool triples(int &A, int &B, const int &C){
    return false;
}






// Exercie 3
int maxAndMin( int numbers[], int length, int &maxNum, int &minNum){
    bool flip = true;
    while(flip==true){
        flip = false;
        int hold;
        for(int i=0; i<length-1; i++){
            if(numbers[i]<numbers[i+1]){
                flip = true;
                hold = numbers[i];
                numbers[i] = numbers[i+1];
                numbers[i+1] = hold;
            }
        }
    }
    maxNum = numbers[0];
    minNum = numbers[length-1];

    int product = numbers[0]*numbers[length-1];

    return product;
}






// Exercise 4
std::string letterCount(){
    std::string line;
    int lCount [26];
    int lInt;
    while (true){
        std::cin>>line;
        if (line=="the end"){
            break;
        }
        for(int i=0; i<line.size()-1; i++){
            lInt = int(line[i]-141);
            lCount[lInt] += 1;
        }
    }
    int hold=0;
    int hold2;
    for(int i=0; i<26; i++){
        if(hold<lCount[i]){
            flip = true;
            hold = lCount[i];
            hold2 = i;
        }
    }
    std::cout<<char(i+141);
    for int i=0; i<26; i++){
        if(hold=lCount[i]){
            flip = true;
            hold = lCount[i];
            std::cout<<char(i+141);
        }
    }
    return "nothing to see here";
}
