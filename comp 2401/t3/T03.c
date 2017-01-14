#include <stdio.h>

unsigned char getBit(unsigned char, int);
unsigned char setBit(unsigned char, int);
unsigned char clearBit(unsigned char, int);
void printIntBits(int);
void printBits(unsigned char);

int main() {

  unsigned char a = 'A';

  unsigned char arr[2][3][4] = {
                                  {
                                    {62,138,241,129},
                                    {8,221,163,159},
                                    {91,158,169,150}
                                 },
                                  {
                                    {15,138,251,198},
                                    {14,211,161,158},
                                    {77,204,188,217}
                                  }
                                };

  int i, j, k;

  printBits(a);
  a = setBit(a, 2);
  a = setBit(a, 3);
  printBits(a);
  a = clearBit(a, 2);
  printBits(a);
  printf("\n");


  int x1 =sizeOf(arr)/sizeOf(arr[i]);
  int y1 =sizeOf(arr[i])/sizeOf(arr[i][i]);
  int z1 =sizeOf(arr[i][i]);
  /* implement question 4 here */
  for(int x = 0; x<x1; x++){
    for(int y = 0; y<y1; y++){
      for(int z = 0; z<z1; z++){
        printBits(arr[x][y][z]);
        arr[x][y][z] = clearBit(arr[x][y][z], 6);
        printBits(arr[x][y][z]);
        printf("\n");
      }
    }
  }
  printf("\n");
  for(int x = 0; x<x1; x++){
    for(int y = 0; y<y1; y++){
      for(int z = 0; z<z1; z++){
        printBits(arr[x][y][z]);
        arr[x][y][z] = setBit(arr[x][y][z], 3);
        printBits(arr[x][y][z]);
        printf("\n");
      }
    }
  }
  printf("\n");
  for(int x = 0; x<x1; x++){
    for(int y = 0; y<y1; y++){
      for(int z = 0; z<z1; z++){
        printf("%d", arr[x][y][z]);
        printf("\n");
      }
    }
  }
  int x = 10;
  printIntBits(x);

  return 0;
}


unsigned char getBit(unsigned char c, int n) {
  return (c & (1 << n)) >> n;
}

unsigned char setBit(unsigned char c, int n) {
  c = c | (1 << n);
  return c;
}

unsigned char clearBit(unsigned char c, int n) {
  c = c & (~(1 << n));
  return c;
}

void printBits(unsigned char c) {
  for(int x = 7; x>=0; x--){
    printf("%d ",getBit(c, x));
  }
  printf("\n");
}

void printIntBits(int c){
  for(int x = 32; x>=0; x--){
    printf("%d ",getBit(c, x));
  }
  printf("\n");
}