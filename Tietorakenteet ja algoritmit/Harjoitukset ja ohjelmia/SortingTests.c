#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/*
	Needed because RAND_MAX may be < 35000
*/
unsigned int bigRandom(){
	unsigned int random = 
  		(((unsigned int) rand() <<  0) & 0x0000FFFF) | 
  		(((unsigned int) rand() << 16) & 0xFFFF0000);
  	
  	return random;
}

void exchange(int *a, int *b){
	int tmp = *a;
	*a = *b;
	*b = tmp;
}

// Insertion sort for int array
void insertsort(int *A, int n){
	int j;
	for(j=1; j < n; j++){
		int k = A[j];
		int i = j-1;
		while( (i >= 0) && (A[i] > k)){
			A[i+1] = A[i];
			i--;
		}
		A[i+1] = k;
	}
}

// Partition algorithm for quicksort
int partition(int *A, int p, int r) {

	int x = A[r];
    int i = p - 1;
    int j;
    for (j = p; j < r ; j++){ 
    	if ( A[j] <= x) {   
        	i = i + 1;
         	exchange(&A[i],&A[j]);
		}
	}
	exchange(&A[i + 1],&A[r]); 

	return (i + 1);
}

// Regular quicksort
void quicksort(int *A, int p,int r){

	if (p < r) { 
    	int q = partition(A, p, r);
		quicksort(A, p, q-1);
		quicksort(A, q+1, r);
	}
	
}

void cutoff_quicksort(int *A, int p,int r, int threshold){

	if ( (r-p) > threshold) { 
    	int q = partition(A, p, r);
		cutoff_quicksort(A, p, q-1, threshold);
		cutoff_quicksort(A, q+1, r, threshold);
	}
}

void initialize(int *A, int len){
	int i;
	for(i=0; i < len; i++){
		A[i] = bigRandom();
	}
}

void print(int *A, int len){
	int i;
	printf("\n");
	for(i=0; i < len; i++){
		printf("%d ",A[i]);
	}
	printf("\n");
}

int main(){
	clock_t start,end;
	
	// Reserve a large array
	int *array = (int *)malloc(100000000*sizeof(int));
	
	double totaltime;
	int size, threshold;
	
	printf("Input array size > ");
	scanf("%d",&size);
	
	// Inserion sort. Comment out when testing Quicksort
	printf("Performing insert sort: ");
	initialize(array,size);
	start = clock();
	insertsort(array,size);
	end = clock();
	// print(array,size);
	totaltime = (double)(end-start)/CLOCKS_PER_SEC;
	printf("Consumed time: %f seconds \n",totaltime);
	
	printf("Performing quicksort: ");
	initialize(array,size);
	start = clock();
	quicksort(array,0,size-1);
	end = clock();
	//print(array,size);
	totaltime = (double)(end-start)/CLOCKS_PER_SEC;
	printf("Consumed time: %f seconds \n",totaltime);
	
	
	printf("Input threshold size > ");
	scanf("%d",&threshold);
	
	printf("Performing cutoff quicksort + insertsort: ");
	initialize(array,size);
	start = clock();
	cutoff_quicksort(array,0,size-1,threshold);
	insertsort(array,size);
	end = clock();
	//print(array,size);
	totaltime = (double)(end-start)/CLOCKS_PER_SEC;
	printf("Consumed time: %f seconds \n",totaltime);
	
	
	return 0;
}

