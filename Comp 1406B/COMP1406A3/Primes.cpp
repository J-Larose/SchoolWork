//Math is Fun.(02/07/16). Retrived from http://www.mathsisfun.com/prime-factorization.html
//Jacob Larose, 101013798, COMP 1406B, assignment 3

#include "Primes.h"

bool isPrime(int x){
    for(int i=2; i<x; i++){
        if (x%i==0){
            return false;
        }
    }
    return true;
}


int* primeFactors(int n){
    int* factors;

    int x = n;
    int f = 0;
    bool done = false;
    int j=0;
    do{
        if(x==2){
            int* hold = new int[j+2];
            for (int k=0;k<j;k++){
                hold[k] = factors[k];
            }

            hold[j] = x;
            hold[j+1] = 1;

            delete[] factors;
            factors = hold;
            return factors;
        }


        for (int i=2; i<=x;i++){
            if(isPrime(i)){
                if(x%i==0){
                    x /= i;
                    f = i;
                    break;
                }
                if (isPrime(x)){
                    done = true;
                    f = x;
                    break;
                }
            }
        }

        switch(done){
            case true:
                {
                int* hold = new int[j+2];

                for (int k=0;k<j;k++){
                    hold[k] = factors[k];
                }

                hold[j] = x;
                hold[j+1] = 1;

                delete[] factors;
                factors = hold;
                }

                break;
            case false:
                {
                int* last = new int[j+1];

                for (int k=0;k<j;k++){
                    last[k] = factors[k];
                }

                last[j] = f;

                delete[] factors;
                factors = last;
                }
                break;

        }

        j++;
    }while(done == false);


    //sort using bubble sort
    bool flip = true;
    while(flip==true){
        flip = false;
        int hold;
        for(int i=0; i<j; i++){
            if(factors[i]<factors[i+1]){
                flip = true;
                hold = factors[i];
                factors[i] = factors[i+1];
                factors[i+1] = hold;
            }
        }
    }
    return factors;
}


int**  allPrimeFactors(int n){
    int** primes;
    primes = new int*[n-1];
    int* f;
    int j;
    for(int i=2; i<=n; i++){
        f = primeFactors(i);
        for (j=0;true;j++){
            if (f[j] == 1){
                j++;
                break;
            }
        }
        primes[i-2] = new int[j];
        for(int k=0;k<j;k++){
            primes[i-2][k] = f[k];
        }
    }

    return primes;
}



std::string displayPrimeFactors(int** factorization, int length){
    std::stringstream stream1;
    int num = length+1;
    int x;
    for (x=0; num>0; x++){
        num /= 10;
    }

    for(int i=0;i<length;i++){
        stream1 << std::setfill('0') << std::setw(x) << i+2 << " = ";
        for (int j=0;true;j++){
            if (*(*(factorization+i)+j) == 1){
                break;
            }
            if (j==0){
                stream1 << *(*(factorization+i)+j);
            }
            else{
                stream1 << 'x'<<*(*(factorization+i)+j);
            }
        }
        stream1 << "\n";
    }

    std::string str = stream1.str();

    return str;
}
