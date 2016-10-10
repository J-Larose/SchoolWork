//"I did not use any reference material in developing this assignment."
//Jacob Larose, 101013798, COMP 1406B, assignment 3

#include "StopLight.h"


bool changeLight(bool& red, bool& yellow, bool& green){
    if(red==true^yellow==true^green==true){
        if (red==true){
            green = true;
            red = false;
            return true;
        }
        else if(yellow==true){
            red = true;
            yellow = false;
            return true;
        }
        else if(green==true){
            yellow = true;
            green = false;
            return true;
        }
    }
    else{
        return false;
    }
}
