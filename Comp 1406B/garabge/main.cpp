#include <iostream>
#include <sstream>
// using namespace std; // this is a bad habit

class A
{
    private:
        std::stringstream ss;

    public:
        std::stringstream& getSs()
        {
            return ss;
        }
};

int main()
{
    A a;
    std::stringstream &ss = a.getSs();

    ss << "Hello, World!";
    std::cout << ss.str() << std::endl;
}
