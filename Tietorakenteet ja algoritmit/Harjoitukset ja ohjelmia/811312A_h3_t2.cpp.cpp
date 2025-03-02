/**
Data structures and algorithms Exercise 3 Task 2
 */

#include <iostream>
#include <cmath>
#include <ctime>

void constTimeFun(){
	for(int i=0; i < 100000; i++){
		std::sqrt(987.654);
	}
}

class Algoritmi {
public:
	virtual void operator()(int size) const = 0;
};

class Algorithm_A : public Algoritmi {
	virtual void operator()(int size) const;
};

void Algorithm_A::operator()(int size) const {
	for(int i = 0; i < size; i++){
		constTimeFun();
	}
}

class Algorithm_B : public Algoritmi {
	virtual void operator()(int size) const;
};

void Algorithm_B::operator()(int size) const {
	constTimeFun();
	if(size < 2){
        return;
	}
	for(int i = 0; i < 4; i++){
		this->operator()(size/2);
	}
}

class Algorithm_C : public Algoritmi {
	virtual void operator()(int size) const;
};

void Algorithm_C::operator()(int size) const {
	constTimeFun();
	if(size < 2){
        return;
	}
	for(int i = 0; i < 2; i++){
		this->operator()(size/4+i);
	}
}

class AlgoTimer {
	private:
		Algoritmi &alg;
	public:
		AlgoTimer(Algoritmi &a):alg(a){};
		double countTime(int size);
};

double AlgoTimer::countTime(int size) {
	clock_t startTime,endTime;
	double execTime;
	startTime = clock();
    endTime = startTime;

	alg(size);
	endTime = clock();
    execTime = double(endTime - startTime);
	return execTime;
}

void printMenu(){
    std::cout << "Choose algorithm " << std::endl;
    std::cout << "1: Algorithm A" << std::endl;
    std::cout << "2: Algorithm B"  << std::endl;
    std::cout << "3: Algorithm C"  << std::endl;
    std::cout << "0: Quit"  << std::endl;
    std::cout << "> ";
}

/*! The main program */
int main(int argc, char **argv)
{
	//using namespace std;

	Algorithm_A aa;
	Algorithm_B ba;
    Algorithm_C ca;

	AlgoTimer algTimer1(aa);
	AlgoTimer algTimer2(ba);
	AlgoTimer algTimer3(ca);

    int choice = 100;
    int inp_size = 0;

    while(choice != 0){
        printMenu();
        std::cin >> choice;

        if(choice != 0){
            std::cout << "Enter input size > ";
            std::cin >> inp_size;
        }

        switch(choice){
        case 1:
            std::cout << "INPUT SIZE = " << inp_size << std::endl <<
                "ALGORITHM A EXEC. TIME = " << algTimer1.countTime(inp_size) << " MS" << std::endl << std::endl;
            break;

        case 2:
            std::cout << "INPUT SIZE = " << inp_size << std::endl <<
                "ALGORITHM B EXEC. TIME = " << algTimer2.countTime(inp_size) << " MS" << std::endl << std::endl;
            break;

         case 3:
            std::cout << "INPUT SIZE = " << inp_size << std::endl <<
                "ALGORITHM C EXEC. TIME = " << algTimer3.countTime(inp_size) << " MS" << std::endl << std::endl;
            break;

        default:
            if(choice != 0){
                std::cout << "No such algorithm " << std::endl;
            }
        }

    }
	return 0;
}
