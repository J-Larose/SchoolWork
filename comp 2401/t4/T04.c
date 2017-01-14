#include <stdio.h>

void encryptCaesar(char*, unsigned char);
void decryptCaesar(char*, unsigned char);
void toUpper(char*);

int main() {
  char plain[] = "Friends, Romans, countrymen, lend me your ears";
  char cipher[] = "Mvez, mzuz, mztz (Z trdv, Z jrn, Z tfehlvivu)";

  printf("%s\n", plain);
  toUpper(plain);
  printf("%s\n", plain);
  encryptCaesar(plain, 5);
  printf("%s\n", plain);
  decryptCaesar(plain, 5);
  printf("%s\n", plain);

  for(int x =0;x<27;x++){
    decryptCaesar(cipher, x);
    printf("%s   %d\n", cipher, x);
    encryptCaesar(cipher, x);
  }

  return 0;
}

void toUpper(char *text) {
  int i = 0;
  while (text[i] != '\0') {
    if (text[i] >= 'a' && text[i] <= 'z') {
      text[i] -= 32;
    }
    i++;
  }
}

void encryptCaesar(char *plaintext, unsigned char key) {
  toUpper(plaintext);
  while(*plaintext){
    if(*plaintext<=90 && *plaintext>=65){
      *plaintext += key;
      if(*plaintext>90){
        *plaintext -= 26;
      }
    }
    plaintext++;
  }


}

void decryptCaesar(char *ciphertext, unsigned char key) {
  toUpper(ciphertext);
  while(*ciphertext){
      if(*ciphertext<=90 && *ciphertext>=65){
        *ciphertext -= key;
        if(*ciphertext<65){
          *ciphertext += 26;
        }
      }
      ciphertext++;
    }
}
