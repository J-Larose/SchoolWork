#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#include "t06defs.h"

/* Implement StudentNode type */

typedef struct {
  StudentNode *head;
} StudentList;


/* Implement the following functions */
void addStudent(StudentList *, StudentNode *);
void printList(const StudentList *);



int main(void) {
  int i;
  
  StudentType matilda, joe, timmy;
  StudentNode matildaNode, joeNode, timmyNode;

  initStudent("Matilda", "Mallister", 22, "123444555",
              9.0, &matilda);
  initStudent("Joe", "The Plumber", 24, "567888999",
              8.7, &joe);
  initStudent("Timmy", "Tortoise", 99, "345667788",
              11.5, &timmy); 
 
  matildaNode.data = &matilda;
  joeNode.data = &joe;
  timmyNode.data = &timmy;

  StudentList comp2401;

  comp2401.head = NULL;

/*  Uncomment the following lines once addStudent is implemented  */

  addStudent(&comp2401, &matildaNode);
  addStudent(&comp2401, &joeNode);
  addStudent(&comp2401, &timmyNode);

/*  Uncomment the following line once printList is implemented  */

  printList(&comp2401);

  return 0;
}

/*   Function:  addStudent                                  */
/*         in:  Location of StudentList to be modified      */
/*         in:  Location of StudentType to be added         */
/*        out:  StudentList with added StudentType          */
/*    Purpose:  adds stu to stuList at the head of the list */
void addStudent(StudentList *stuList, StudentNode *stuNode) {
  stuNode->next = stuList->head;
  stuList->head = stuNode;
}

void printList(const StudentList *stuList) {
  if (stuList->head == NULL){
    return;
  }
  StudentNode* curr = stuList->head;
  while(1){
    printf("%s, %s\n", curr->data->basicInfo.last, curr->data->basicInfo.first);
    printf("%d years old\n", curr->data->basicInfo.age);
    printf("%s\n",  curr->data->stuNumber);
    printf("%f\n", curr->data->gpa);
    if (curr->next == NULL){
      break;
    }
    curr = curr->next;
  }
}
