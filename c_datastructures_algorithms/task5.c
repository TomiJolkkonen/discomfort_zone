// Exercise 2 task 5
#include <stdio.h>
#include <assert.h>

/*
Flawed implementation of binary search:

HAKU(A,x)
 1. low=0
 2. up=n-1
 3. while low <= up
 4.    r = (p + q)/2
 5.    if A[r] < x
 6. 	low = r
 7.    else if A[r] > x
 8.    	up = r
 9.    else
10.    	return r
11. return -1
*/

// Flawed binary search
int bsearch(int* A, int x, int size){
	int low=0;
	int up=size-1;
	int r;

	while (low <= up){

		r = (low + up)/2;
		if (A[r] < x)
			low = r;
		else if (A[r] > x)
    		up = r;
		else
    		return r;
	}
	return -1;
}

// Fixed binary search
int bsearch_corr(int* A, int x, int size){
	int low=0;
	int up=size-1;
	int r;

	while (low <= up){

		r = (low + up)/2;
		if (A[r] < x)
			low = r+1;
		else if (A[r] > x)
    		up = r-1;
		else
    		return r;
	}
	return -1;
}

int main(){
	int array[6] = {0,10,20,30,40,50};
	int x = 25;

	// Calling given algorithm. Comment out to call fixed algorithm
	printf("\nNumber's %d index in array: %d\n", x,bsearch(array,x,6));

	// Calling fixed algorithm
	printf("\nNumber's %d index in array: %d\n", x,bsearch_corr(array,x,6));

	return 0;
}
