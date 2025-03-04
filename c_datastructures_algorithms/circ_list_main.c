#include <stdio.h>
#include "circ_list.h"

int main(){
	circ_list coll;
	coll.head=0;
	coll.tail=0;
	
	int i;
	
	// Insert keys 0,1,...,9 into the list
	for(i=0; i<10; i++){
		list_insert(&coll,i);
	}
	
	printf("Original list: head: %d tail: %d\n",coll.head->data,coll.tail->data);
	print_list(coll);
	printf("\n\n");
	
	// Remove even keys from the list
	for(i=0; i<10; i+=2){
		list_remove(&coll,i);
		printf("New list: removed %d head: %d tail: %d\n",i,coll.head->data,coll.tail->data);
		print_list(coll);
		printf("\n\n");
	}
	
	// Remove odd keys from the list
	for(i=9; i>0; i-=2){
		list_remove(&coll,i);
		if(coll.head != 0)
			printf("New list: removed %d head: %d tail: %d\n",i,coll.head->data,coll.tail->data);
		else
			printf("Empty list: removed %d \n",i);
			
		print_list(coll);
		printf("\n\n");
	}
	
	return 0;
}