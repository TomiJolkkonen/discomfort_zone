// Exercise 4 task 3, finding mode

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

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

// For library quicksort
int compare(const void *a,const void *b){
    int x = *(int *)(a);
    int y = *(int *)(b);
    return x-y;
}

// Finds mode. First sorts array
// with Heapsort if libsort == 0
// with library quicksort if libsort != 0
int find_mode(int *A, int len, int libsort){
    if(libsort == 0)
        heap_sort(A,len);
    else
        qsort(A,len,sizeof(int),compare);

    int mode = A[0];
    int freq = 1;
    int temp = 1;
    int i=1;

    while(i < len){
        if(A[i] != A[i-1]){
            temp = 1;
        }
        else{
            temp++;
            if(temp > freq){
                freq = temp;
                mode = A[i];
            }
        }
        i++;
    }
    printf("Mode = %d, frequence = %d\n",mode,freq);
    return mode;
}


void initialize(int *A, int len){
	int i;
	for(i=0; i <= len; i++){
		A[i] = rand();
	}
}

int main(){
	clock_t start,end;
    int mode = 0;
    int choice = 0;

	// Reserve a large array
	int *array = (int *)malloc(100000000*sizeof(int));

	double totaltime;
	int size, threshold;

	printf("Input array size > ");
	scanf("%d",&size);

	printf("Input sort algorithm: 0 = heapsort, 1 = library quicksort  > ");
	scanf("%d",&choice);

	printf("Searching for mode: \n");
	initialize(array,size);
	start = clock();
	mode = find_mode(array,size,choice);
	end = clock();
	//print(array,size);
	totaltime = (double)(end-start)/CLOCKS_PER_SEC;
	printf("Mode:%d, Consumed time: %f seconds \n",mode,totaltime);

    // Free array
    free(array);

	return 0;
}

