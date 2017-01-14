#include "a7Defs.h"

int main(void) {
  int i, rc;
   
  CatListType *catList;
  initAllCats(&catList);

  printList(catList);

  cleanupList(catList);

  return 0;
}
/*
inserts given cat into the list
input:
  cat: the catType to be added
output:
  catList: the list to be added to
*/
int insertCat(CatListType *catList, CatType *cat) {
  //create a new node for the cat
  NodeType *curr = catList->head;
  NodeType *newCatNd;
  initNode(&newCatNd, cat);
  //empty list
  if(curr == NULL){
    catList->head = newCatNd;
    catList->tail = newCatNd;
    newCatNd->next = NULL;
    newCatNd->prev = NULL;
    return C_OK;
  //replace head
  }else if(strcmp(catList->head->data->name, cat->name)>0){
    newCatNd->next = catList->head;
    catList->head = newCatNd;
    newCatNd->prev = NULL;
    return C_OK;    
  }
  //search for the right place in the list
  while(curr!=NULL){
    if(strcmp(curr->data->name, cat->name)<0){
      //replace tail
      if(catList->tail==curr){
        catList->tail->next = newCatNd;
        newCatNd->prev = catList->tail;
        catList->tail = newCatNd;
        return C_OK;
      }else{
        newCatNd->next = curr->next;
        curr->next->prev = newCatNd;
        curr->next = newCatNd;
        newCatNd->prev = curr;
        return C_OK;
      }
    }else{
      curr = curr->next;
    }
  }
  return C_NOK;
}
/*
frees all allocated memory
Input/output: 
  catList: list containing all the elemts to be freed
*/
int cleanupList(CatListType *catList) {
  NodeType *curr = catList->head;
  NodeType *next;

  while (curr != NULL) {
    free(curr->data);
    free(curr);
    curr = curr->next;
  }
  free(catList);
  return C_OK;
}
/*
takes user input for each member to build a catType
output: 
  newCatPointer: a pointer to the poiter to the cat to be built
input:
  List: the current list of cats, used to ensure unique ids
*/
void buildCat(CatType** newCatPointer, CatListType* list){
  int id;
  while(1){
    //takes id
    printf("enter the cat ID\n");
    readInt(&id);
    NodeType *curr = list->head;
    char flag = 0;
    while(curr!=NULL){
      if(curr->data->id==id || id<0){
        flag = 1;
        break;
      }else{
        curr = curr->next;
      }
    }
    if(flag==0){
      break;
    }else{
      printf("that id is not unique or less than 0, please try again.\n");
    }
  }
  //take name
  printf("enter the name\n");
  char name[MAX_STR];
  readString(name);
  //take gender as string then convert to enum
  GenderType gender;
  while(1){
    char genderStr[MAX_STR];

    printf("Please enter MALE or FEMALE for the cats gender\n");
    readString(genderStr);
    if(strcmp(genderStr, "MALE")==0){
      gender = MALE;
      break;
    }else if(strcmp(genderStr, "FEMALE")==0){
      gender = FEMALE;
      break;
    }else{
      printf("please enter MALE or FEMALE\n");
    }
  }
  //call init cat
  initCat(id, name, gender, newCatPointer);
}