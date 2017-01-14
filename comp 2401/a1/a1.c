#include <stdio.h>

#define ARR_MAX 16

int addToArray(int* arr, int size, int numToAdd);
int remFromArray(int* arr, int size, int numToGo);
void printArray(int* arr, int size);

/* 
this program inserts and removes positive intergers into/from an array in acending order
one integer per line, avoid empty lines and non-integer charecters
by: Jacob Larose, 101013798
*/
int main(){
  int num;
  int size = 0;
  int arr[ARR_MAX];

  //start loop for adding numbers
  printf("please enter your positive integers\n one per line, enter a negative to stop\n");
  while(size <= ARR_MAX){
    scanf("%d",&num);
    if (num<0){
      break;
    }
    size = addToArray(arr, size, num);
  }
  printArray(arr, size);

  // start loop for removing numbers
  num = 0;
  printf("please enter numbers to remove\n");
  while(1){
    int plcHold = size;
    if (num<0 || size<=0){
      break;
    }
    scanf("%d", &num);

    plcHold = remFromArray(arr, size, num);
    if(plcHold!=size){
      size = plcHold;
    }
  }
  printArray(arr, size);

  return 0;
}

/*
insert numbers into the array in acending order
input parameters:
  size: size of the array to have a number inserted to
  numToAdd: number to insert into the array
input/output parameters:
  arr: the array into which numbers inserted
returns: int of the new size of the array
*/
int addToArray(int* arr, int size, int numToAdd){
  //find pos of first number bigger than numToAdd
  int pos=0;
  for (int x = 0;x<size;x++){
    if (arr[pos]>numToAdd){
      break;
    }
    pos++;
  }
  //insert into pos
  for (int x = size-1; x>=pos; x--){
    arr[x+1] = arr[x];
  }
  arr[pos] = numToAdd;

  return size+1;
}

/*
remove the first instance of given number from the array 
input parameters:
  size: size of the array to have a number removed from
  numToGo: number to remove from the array
input/output parameters:
  arr: the array into which numbers removed
returns: int of the new size of the array
*/
int remFromArray(int* arr, int size, int numToGo){
  //find pos of numToGo
  int pos=0;
  char found = 0;
  for (int x = 0;x<size;x++){
    if (arr[pos]==numToGo){
      found = 1;
      break;
    }
    pos++;
  }
  //remove
  for (int x = pos; x<=size; x++){
    arr[x] = arr[x+1];
  }

  //check if found/removed and return size
  if (found!=0){
    return size-1;
  }else{
    printf("that number was not found in the array\n");
    return size;
  }
}


/*
print array to console
input parameters:
  size: size of the array to be printed
  arr: the array to be printed
*/
void printArray(int* arr, int size){
  for(int x = 0; x<size; x++){
    printf("%d ,", arr[x]);
  }
  printf("\n");
}
