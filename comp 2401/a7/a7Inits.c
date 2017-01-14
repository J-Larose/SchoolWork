#include "a7Defs.h"

/*
create the cat list and build all the cats
output:
	listPointer: pointer to the pointer to the list
*/
void initAllCats(CatListType** listPointer){
  (*listPointer) = malloc(sizeof(CatListType));
  (*listPointer)->head = NULL;
  (*listPointer)->tail = NULL;
  CatType *newCat;

  while(1){
    printf("would you like to add another cat? (1forYes/0forNo)\n");
    int cont;
    readInt(&cont);
    if(cont!=1){
      break;
    }else{
      buildCat(&newCat, (*listPointer));
      insertCat((*listPointer), newCat);
    }
  }
}
/*
allocate and initialise a catType given by buildCat()
input:
	id: id of the cat
	name: name of the cat
	gender; gender of the cat
output:
	newCatPointer: pointer to the pointer to the new cat
*/
void initCat(int id, char* name, GenderType gender, CatType** newCatPointer){
  (*newCatPointer) = malloc(sizeof(CatType));
  (*newCatPointer)->id = id;
  strcpy((*newCatPointer)->name, name);
  (*newCatPointer)->gender = gender;
}
/*
create a new node pointing to the given cat
input:
	cat: the cat to pointed to
output:
	catNd: pointer to the pointer for the new node to be created
*/
void initNode(NodeType **catNd, CatType *cat){
  *catNd = malloc(sizeof(NodeType));
  (*catNd)->data = cat;
  (*catNd)->next = NULL; 
  (*catNd)->prev = NULL;
}