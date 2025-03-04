/*
    Exercise 4, task 2. Comparing sorting algorithms
*/

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

// Heap sort
int left(int i){
	return 2*i+1;
}

int right(int i){
	return 2*i+2;
}

void max_heapify(int *A, int i, int heap_size) {

	int l = left(i);
	int r = right(i);
	int largest = i;

	if( l < heap_size && A[l] > A[i] )
		largest = l;

	if( r < heap_size && A[r] > A[largest] )
		largest = r;

	if(largest != i){
		exchange(&A[i],&A[largest]);
		max_heapify(A,largest,heap_size);
	}
}

void build_max_heap(int *A, int length){
    int i;
	int heap_size = length;

	for(i = length/2; i>=0; i--){
		max_heapify(A,i,heap_size);
	}
}

void heap_sort(int *A, int length){
    int i;
	int heap_size = length;
	build_max_heap(A,length);

	for(i = length-1; i>=1; i--){

		exchange(&A[0],&A[i]);
		heap_size--;

		max_heapify(A,0,heap_size);
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

// Quicksort
void quicksort(int *A, int p,int r){

	if (p < r) {
    	int q = partition(A, p, r);
		quicksort(A, p, q-1);
		quicksort(A, q+1, r);
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

void menu(){
    printf("Choice:\n");
    printf("1. Heapsort\n");
    printf("2. Quicksort\n");
    printf("3. Exit\n\n");
}

int main(){
	// Define needed variables
	clock_t start,end;
	double totaltime;
    int size = 10;
    int choice = 0;

	// Reserve a large array
	int *array = (int *)malloc(100000000*sizeof(int));

    while(choice != 3){
        menu();
        scanf("%d",&choice);
        if(choice != 3){
            printf("Input array size > ");
            scanf("%d",&size);
        }

        switch(choice){
            case 1:
                // Heapsort
                printf("Performing heap sort: ");
                initialize(array,size);
                //print(array,size);
                start = clock();
                heap_sort(array,size);
                end = clock();
                totaltime = (double)(end-start)/CLOCKS_PER_SEC;
                printf("Consumed time: %f seconds \n",totaltime);
                //print(array,size);
                break;

            case 2:
                // Quicksort
                printf("Performing quicksort: ");
                initialize(array,size);
                //print(array,size);
                start = clock();
                quicksort(array,0,size-1);
                end = clock();
                totaltime = (double)(end-start)/CLOCKS_PER_SEC;
                printf("Consumed time: %f seconds \n",totaltime);
                //print(array,size);
                break;

            default: break;
        }
    }

	return 0;
}

