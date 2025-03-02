/*
	Exercise 3, task 4: Random permutation algorithm
	and application
*/


#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/*
	32-bit random number
	Needed because RAND_MAX may be < 35000
*/
unsigned int bigRandom(){
	unsigned int random =
  		(((unsigned int) rand() <<  0) & 0x0000FFFF) |
  		(((unsigned int) rand() << 16) & 0x00000000FFFF0000);

  	return random;
}

// Random permutation of numbers 1..n
int randperm(int n,int* A){
	int i,x,randnumber;
	for(i=0; i < n; i++){
		A[i] = i+1;
	}

	for(i=0; i < n; i++){
		randnumber = bigRandom()%(i+1);
		x = A[i];
		A[i] = A[randnumber];
		A[randnumber] = x;
	}
}

/*  Computing the probability of flush by simulation
    Model cards 1-52:
    Hearts numbers 1-13
    Diamonds numbers 14-26
    Clubs numbers 27-39
    Spades numbers 40-52
*/
void simulate_flush(){
	clock_t start,end;

	// Array for deck of cards
	int array[52];

	double totaltime;
	int size = 52;
    int numperm=0;
    int count = 0;

	printf("How many deals? > ");
	scanf("%d",&numperm);

	start = clock();
	for(int i = 0; i < numperm; i++){
        randperm(size,array);
        // Check if the suits all equal
        int suit = (array[0]-1)/13;
        if((array[1]-1)/13==suit && (array[2]-1)/13==suit
           && (array[3]-1)/13==suit && (array[4]-1)/13==suit){
            count = count+1;
        }
	}

	end = clock();
	totaltime = (double)(end-start)/CLOCKS_PER_SEC;// Timing of random permutation


	double prob = (double)count/numperm;

	printf("Estimated probability for flush is %f\n",prob);
	printf("Time is %f seconds\n", totaltime);
}

void compute_permutation(){
	clock_t start,end;

	// Reserve one large array
	int *array = (int *)malloc(80000000*sizeof(int));

	double totaltime;
	int size;

	printf("Input array size > ");
	scanf("%d",&size);

	start = clock();
	randperm(size,array);
	end = clock();
	totaltime = (double)(end-start)/CLOCKS_PER_SEC;

	printf("Time is %f seconds\n", totaltime);
    free(array);
}

void menu(){
    printf("Choice:\n");
    printf("1. Compute random permutation\n");
    printf("2. Simulate probability for flush\n");
    printf("3. Exit\n\n");
}

int main(int argc, char **argv){

    // Seed random number generator
    int seed = time(NULL);
    srand(seed);

    int choice = 0;
    while(choice != 3){
        menu();
        scanf("%d",&choice);
        switch(choice){
            case 1:
                compute_permutation();
                break;
            case 2:
                simulate_flush();
                break;
            default: break;
        }
    }
    return 0;
}
