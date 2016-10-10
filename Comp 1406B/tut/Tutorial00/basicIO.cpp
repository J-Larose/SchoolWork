#include <string>
#include "basicIO.h"


void doSomeBasicIO(){
    // some basic output to the terminal
    // using cout and the insertion operator <<
    // for more information see
    // http://www.cplusplus.com/reference/ostream/ostream/operator<</

    std::cout << "basic output" << std::endl;
    std::cout << "------------\n" << std::endl;

    // printing basic text to the terminal window

    std::cout << "you can print out a long line with one << " << std::endl;
    std::cout << "you" << " can" << " also" <<  " chain" << " many" << " outputs (<<)" << " together" << std::endl;
    std::cout << "you can use endl to insert a new-line character and flush the buffer" << std::endl;
    std::cout << "you can insert a new-line character yourself which is the char \'\\n\'. \n";
    std::cout << "(note, \'\\n\' does not flush the buffer, so you might not see the output until later" << std::endl;


    // printing the contents of variables

    int    a = 10;                  // an integer
    float  f = 3.145;               // a floating point number
    char   c = 'Q';                 // a single character
    bool   b = true;                // a boolean
    std::string s = "hi there!";    // a string
    long numbers[3] = {1,10,100};   // an array of long numbers

    std::cout << std::endl;
    std::cout << "an integer " << a << std::endl;
    std::cout << "a float    " << f << std::endl;
    std::cout << "a char     " << c << std::endl;
    std::cout << "a string   " << s << std::endl;
    std::cout << "a bool     " << b << std::endl;
    std::cout << "an array   " << numbers << std::endl;

    // some basic input from the console
    // using cin and the extraction operator >>
    // for more information see
    // http://www.cplusplus.com/reference/istream/istream/operator>>/

    std::cout << std::endl;
    std::cout << "basic console input\n-------------------" << std::endl;

    int secret = 12, guess=0;

    std::cout << "guess a number between 0 and 99999 : ";
    std::cin >> guess;

    if( guess == secret){
        std::cout << "you are right!" << std::endl;
    }else{
        std::cout << "sorry, you are wrong." << std::endl;
    }

    int age=0;
    char answer;
    std::string name = "";

    std::cout << "what is your name? ";
    std::cin >> name;
    std::cout << "Ok, " << name << ", how old are you? ";
    std::cin >> age;
    std::cout << "Are you really " << age << " years old? [y/n] ";
    std::cin >> answer;
    std::cout << "you answered " << answer << std::endl;

    if( answer == 'y' || answer == 'Y'){
        std::cout << "great" << std::endl;
    }else{
        std::cout << "why?" << std::endl;
    }

    std::string colour = "";
    std::cout<<"pick a colour"<<std::endl;
    std::cin>>colour;
    std::cout<<"why did you pick "<<colour<<std::endl;
}
