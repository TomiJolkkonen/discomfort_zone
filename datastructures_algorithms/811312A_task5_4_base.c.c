#include <stdio.h>
#include <math.h>

#define HASH_TABLE_SIZE 49999

// Returns hash value
int hash(int number){
    return number%HASH_TABLE_SIZE;
}

// Inserts a number to hash table
// Returns -1 if table full
int insert_number(int number,int *table){
}

// Searches for a number in a hash table
// Returns the index in the table if found
// Returns -1 if not found
int search_number(int number,int *table){
}

int main(){
    // The hash table that we use
    int hashtable[HASH_TABLE_SIZE];
    char numbuf[10];
    FILE *numfile;

    // Initialize the table
    for(int i=0; i < HASH_TABLE_SIZE; i++){
        hashtable[i] = 0;
    }

    // Open the file containing the numbers
    numfile = fopen("task5_4_nums.txt","r");

    if (numfile == NULL){
		printf("ERROR READING THE FILE!\n");
		return 0;
	}

	// Read the numbers from the file
    while(fgets(numbuf,10,numfile)!=NULL){
        // Insert the number in the hash table
    }

    fclose(numfile);

    // Search for numbers
    // 613695, 906429, 180551, 151841, 951585, 569127

    return 0;
}
