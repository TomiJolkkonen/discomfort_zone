// Variables and Data Types
int a = 10;
float b = 3.14;
double c = 2.718;
char d = 'A';
bool e = true;
std::string str = "Hello";

// Control Structures
if (a > 5) { /* do something */ }
for (int i = 0; i < 10; i++) { /* loop */ }
while (a > 0) { a--; }

// Functions
int add(int x, int y) { return x + y; }
void printMessage() { std::cout << "Hello World\n"; }

// Pointers
int* ptr = &a; // Pointer to a

// Classes and Objects
class Car {
public:
    std::string brand;
    Car(std::string b) : brand(b) {}
    void honk() { std::cout << "Beep!\n"; }
};

// STL (Standard Template Library)
#include <vector>
std::vector<int> nums = {1, 2, 3};
nums.push_back(4);

