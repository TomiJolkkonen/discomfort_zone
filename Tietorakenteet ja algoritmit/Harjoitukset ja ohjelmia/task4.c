// Exercise 2 task 4
#include <stdio.h>

// Wrong reverse algorithm
void reverse(int nums[],int len){
    int i = 0;
    while(i <= len/2){
        int temp = nums[i];
        nums[i] = nums[len-i-1];
        nums[len-i-1] = temp;
        i++;
    }
}

// Fixed algorithm
void reverse_fix(int nums[],int len){
    int i = 0;
    while(i < len/2){
        int temp = nums[i];
        nums[i] = nums[len-i-1];
        nums[len-i-1] = temp;
        i++;
    }
}

void print(int nums[],int len){
    int i=0;
    for(i=0; i < len; i++){
        printf("%d ",nums[i]);
    }
    printf("\n");
}

int main(){
    int taulu1[] = {1,2,3,4};
    int taulu2[] = {1,2,3,4};

    // Calling flawed algorithm
    printf("Calling given reverse:\n");
    print(taulu1,4);
    reverse(taulu1,4);
    print(taulu1,4);

    printf("\nCalling fixed reverse:\n");
    // Calling correct algorithm
    print(taulu2,4);
    reverse_fix(taulu2,4);
    print(taulu2,4);
    return 0;
}
