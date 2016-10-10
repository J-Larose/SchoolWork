#include <iostream>



bool validIsbn(char digits[])
{
    int weighted [10];

    for(int x=0; x<9; x++){
        weighted[x] = (int(digits[x]));
    }
    if(digits[9]=='x'){
        weighted[9]=10;
    }
    else{
        weighted[9] = (int(digits[9]));
    }


    int total=0;
    int weight = 10;
    for(int x=0; x<10; x++){
        total = total+(weighted[x] * weight);
        weight -= 1;
    }

    if (total%11 == 0){
        return true;
    }
    else{
        return false;
    }
}

int main()
{
    char num [10] = {0,3,0,6,4,0,6,1,5,3};
    bool x = validIsbn(num);
    std::cout<<x<<std::endl;
    return 0;
}
