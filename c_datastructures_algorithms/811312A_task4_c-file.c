// Exercise 1 task 4
#include <stdio.h>

// The size of the queue in this task
#define QUEUE_SIZE 10

// A queue data structure and its operations
// Queue contains (positive) integers
typedef struct que {
    int slots[QUEUE_SIZE];
    int head;
    int tail;
    int num_taken;
} queue;

// The operations. Note that we have to take the queue
// as a pointer parameter to avoid copying it

// Initializes queue
void init(queue *pq){
    pq->head = pq->tail = pq->num_taken = 0;
}

// Returns true if queue empty
int empty(queue *pq){
    return (pq->num_taken == 0);
}

// Returns true if queue full
int full(queue *pq){
    return (pq->num_taken == QUEUE_SIZE);
}

// Puts an integer to queue
// Returns 1 if success, 0 if no success
int enqueue(queue *pq,int x){
    if (full(pq))
        return 0;

    pq->slots[pq->tail]=x;
    pq->tail = (pq->tail+1)%QUEUE_SIZE;
    pq->num_taken++;
    return 1;
}

// Takes an integer from the queue and returns it
// Returns -1 if no success
int dequeue(queue *pq){
    if (empty(pq))
        return -1;


    int retval = pq->slots[pq->head];
    pq->head = (pq->head+1)%QUEUE_SIZE;
    pq->num_taken--;

    return retval;
}

void menu(){
    printf("Choice:\n");
    printf("1. Add customer\n");
    printf("2. Remove customer\n");
    printf("3. Exit\n\n");
}

// Logic for handling the queue
int main(int argc, char **argv){
    int custAddNum = 0;
    int custRemoveNum = 0;
    int choice = 0;
    queue customers;
    init(&customers);

    while(choice != 3){
        menu();
        scanf("%d",&choice);
        switch(choice){
            // Adding a customer
            case 1:
                custAddNum++;
                // Enqueue and check if queue already full
                if( enqueue(&customers,custAddNum) == 0){
                    // fail
                    custAddNum--;
                    printf("Queue is full!\n");
                }
                break;
            // Removing a customer
            case 2:
                custRemoveNum = dequeue(&customers);
                // Check if queue was empty
                if(custRemoveNum < 0)
                {
                    // fail
                    printf("Queue is empty!\n");
                }
                else {
                    printf("Customer number %d served!\n",custRemoveNum);
                }
                break;
            default: break;
        }
    }
    return 0;
}
