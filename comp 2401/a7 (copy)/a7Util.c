#include "a7Defs.h"

/*
    Function:  readString
    Purpose:   reads a string from standard input
        out:   string read in from the user
               (must be allocated in calling function)
*/
void readString(char *str)
{
  char tmpStr[MAX_STR];

  fgets(tmpStr, sizeof(tmpStr), stdin);
  tmpStr[strlen(tmpStr)-1] = '\0';
  strcpy(str, tmpStr);
}

/*
    Function:  readInt
    Purpose:   reads an integer from standard input
        out:   integer read in from the user
               (must be allocated in calling function)
*/
void readInt(int *x)
{
  char str[MAX_STR];

  readString(str);
  sscanf(str, "%d", x);
}
/*
prints the list by calling printCat for each cat
input:
  catList: list of cats to be printed
*/
void printList(const CatListType *catList) {
  NodeType *currNode = catList->head;


  while (currNode != NULL) {
    printCat(currNode->data);
    currNode = currNode->next;
  }
}
/*
prints all the members of a cat
input:
  cat: the cat to be printed
*/
void printCat(const CatType *cat)
{
  //convert gender enum to string to be printed
  char* genderStr;
  printf("cat\n");
  switch(cat->gender){
    case 0: genderStr = "Male"; break;
    case 1: genderStr = "Female"; break;
  }
  printf("Here's cat %d! It's name is %s and it's %s\n",
         cat->id, 
         cat->name,
         genderStr);
}