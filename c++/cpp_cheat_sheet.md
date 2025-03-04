
# C++ Cheat Sheet

## Basics

```cpp
#include <iostream>
using namespace std;

int main() {
    cout << "Hello, World!" << endl;
    return 0;
}
```

## Data Types

| Type         | Example         |
|--------------|-----------------|
| int         | 10              |
| float       | 10.5f           |
| double      | 10.5            |
| char        | 'A'             |
| bool        | true / false    |
| string      | "Hello"         |

## Variables

```cpp
int age = 25;
float weight = 65.5;
string name = "Alice";
```

## Constants

```cpp
const double PI = 3.14159;
```

## Input/Output

```cpp
int x;
cin >> x;
cout << "Value: " << x << endl;
```

## Control Structures

### If-Else

```cpp
if (x > 10) {
    cout << "Greater";
} else {
    cout << "Smaller or equal";
}
```

### Switch

```cpp
switch (x) {
    case 1: cout << "One"; break;
    default: cout << "Other";
}
```

### Loops

```cpp
for (int i = 0; i < 5; i++) {
    cout << i;
}

while (x > 0) {
    x--;
}
```

## Functions

```cpp
int add(int a, int b) {
    return a + b;
}
```

## Arrays

```cpp
int arr[5] = {1, 2, 3, 4, 5};
```

## Vectors (from `<vector>`)

```cpp
#include <vector>
vector<int> v = {1, 2, 3};
v.push_back(4);
```

## Classes

```cpp
class Person {
public:
    string name;
    int age;
    
    void greet() {
        cout << "Hello, " << name;
    }
};
```

## Inheritance

```cpp
class Student : public Person {
public:
    int grade;
};
```

## File Handling

```cpp
#include <fstream>

ofstream outFile("output.txt");
outFile << "Hello";
outFile.close();

ifstream inFile("output.txt");
string line;
getline(inFile, line);
inFile.close();
```

## Namespaces

```cpp
namespace first {
    int x = 1;
}
namespace second {
    int x = 2;
}
```

## Exception Handling

```cpp
try {
    throw 20;
} catch (int e) {
    cout << "Error: " << e;
}
```

## Useful Headers

| Header       | Usage           |
|--------------|-----------------|
| `<iostream>`| Input/Output    |
| `<vector>`  | Dynamic arrays  |
| `<string>`  | String handling |
| `<fstream>` | File handling   |
| `<cmath>`   | Math functions  |

## Tips
- Use `std::` prefix or `using namespace std;`
- Remember to compile using `g++ file.cpp -o file`
- Run with `./file`
