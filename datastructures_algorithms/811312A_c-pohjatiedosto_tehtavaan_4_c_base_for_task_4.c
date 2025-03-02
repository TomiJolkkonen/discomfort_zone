#include <stdio.h>

#define QUEUE_SIZE 10

void menu(){
    printf("Choice:\n");
    printf("1. Add customer\n");
    printf("2. Remove customer\n");
    printf("3. Exit\n\n");
}

int main(int argc, char **argv){
    int choice = 0;
    // Define needed variables

    while(choice != 3){
        menu();
        scanf("%d",&choice);
        switch(choice){
            case 1:
                // Add a customer if possible
                break;
            case 2:
                // Remove a customer from queue if possible
                // and print customer's number
                break;
            default: break;
        }
    }
    return 0;
}
