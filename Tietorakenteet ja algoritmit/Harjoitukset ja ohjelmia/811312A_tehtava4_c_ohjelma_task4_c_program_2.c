#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>

#define HASH_TABLE_SIZE 49999

unsigned int bigRandom(){
	unsigned int random =
  		(((unsigned int) rand() <<  0) & 0x0000FFFF) |
  		(((unsigned int) rand() << 16) & 0xFFFF0000);

  	return random;
}

int hash(int number){
    return number%HASH_TABLE_SIZE;
}

int insert_number(int number,int *table){
    int place = hash(number);
    int firstplace = place;
    int stored = 0;

    while(stored==0){
        if(table[place]==0){
            table[place]=number;
            stored = 1;
        }
        else {
            if(table[place]==number){
                stored = 1;
            }
            else{
                place = (place+1)%HASH_TABLE_SIZE;
            }
        }
        if(stored == 0 && firstplace == place){
            // Table was full
            stored = -1;
        }
    }

    return stored;
}

int search_number(int number,int *table){
    int place = hash(number);
    int firstplace = place;
    int found = 0;

    while(found==0){
        if(table[place]==0){
            return -1;
        }
        else {
            if(table[place]==number){
                found = 1;
            }
            else{
                place = (place+1)%HASH_TABLE_SIZE;
                //printf("Collision!\n");
            }
        }
        if(found == 0 && firstplace == place){
            // Table was full
            return -1;
        }
    }

    return place;

}

int main(){
    int hashtable[HASH_TABLE_SIZE];
    char numbuf[10];
    FILE *numfile;

    // Seed random number generator
    int seed = time(NULL);
    srand(seed);

    for(int i=0; i < HASH_TABLE_SIZE; i++){
        hashtable[i] = 0;
    }

    numfile = fopen("task5_4_nums.txt","r");

    if (numfile == NULL){
		printf("ERROR READING THE FILE!\n");
		return 0;
	}

    while(fgets(numbuf,10,numfile)!=NULL){
        if(insert_number(atoi(numbuf),hashtable) < 0){
            printf("HASH TABLE FULL. CANCELING\n");
            fclose(numfile);
            return 0;
        }
    }

    fclose(numfile);

    int foundtab[] = {613695, 906429, 180551, 151841, 951585, 569127};
    for(int i = 0; i < 6; i++){
        // int rnum = 1 + bigRandom()%1000000;
        int rnum = foundtab[i];
        printf("Searching %u ... ",rnum);
        if(search_number(rnum,hashtable)<0){
            printf("... NOT found\n");
        }
        else {
            printf("%d ... WAS found\n",rnum);
        }
    }

    clock_t start,end;
	double totaltime;
	int numNumbers = 100000;

	printf("Starting to search %d numbers \n",numNumbers);
	start = clock();

    for(int i = 0; i < numNumbers; i++){
        int rnum = 1 + bigRandom()%1000000;
        search_number(rnum,hashtable);
    }

    end = clock();
    totaltime = (double)(end-start)/CLOCKS_PER_SEC;
    printf("Done. Consumed time: %f seconds \n",totaltime);

    return 0;
}
