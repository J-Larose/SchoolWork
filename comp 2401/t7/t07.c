#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#include "t07defs.h"

/* Implement the following functions */
int insertStudentAlpha(StudentList *, StudentType *);
int deleteStudent(StudentList *, char *, char *);
int cleanupList(StudentList *);
void initNode(StudentNode **stuNd, StudentType *stu);

int main(void) {
  int i, rc;
  
  StudentType *matilda, *joe, *timmy;

  initStudent("Matilda", "Mallister", 22, "123444555",
              9.0, &matilda);
  initStudent("Joe", "The Plumber", 24, "567888999",
              8.7, &joe);
  initStudent("Timmy", "Tortoise", 99, "345667788",
              11.5, &timmy); 
 
  StudentList *comp2401 = malloc(sizeof(StudentList));

  comp2401->head = NULL;

  insertStudentAlpha(comp2401, matilda);
  insertStudentAlpha(comp2401, joe);
  insertStudentAlpha(comp2401, timmy);
  printList(comp2401);

  //rc = deleteStudent(comp2401, "Tommy", "Tortoise");
  //printf("%d\n", rc);
  //rc = deleteStudent(comp2401, "Joe", "The Plumber");
  //printf("%d\n", rc);
  printList(comp2401);
  //deleteStudent(comp2401, "Matilda", "Mallister");
  printList(comp2401);

  cleanupList(comp2401);

  return 0;
}

int insertStudentAlpha(StudentList *stuList, StudentType *stu) {
  StudentNode *curr = stuList->head;
  if(curr == NULL){
    StudentNode *newStuNd;
    initNode(&newStuNd, stu);
    stuList->head = newStuNd;
    newStuNd->next = NULL;
    return C_OK;
  }else if(strcmp(stuList->head->data->basicInfo.last, stu->basicInfo.last)>0){
    StudentNode *next = stuList->head;
    StudentNode *newStuNd;
    initNode(&newStuNd, stu);
    stuList->head = newStuNd;
    newStuNd->next = next;
  }
  while(curr!=NULL){
    if(strcmp(stu->basicInfo.last, curr->data->basicInfo.last)>0){
      if(curr->next == NULL || strcmp(stu->basicInfo.last, curr->next->data->basicInfo.last)>0){
        curr = curr->next;
      }else{
        StudentNode *next = curr->next;
        StudentNode *newStuNd;
        initNode(&newStuNd, stu);
        curr->next = newStuNd;
        newStuNd->next = next;
        return C_OK;
      }
    }else{
      curr = curr->next;
    }
  }
  return C_NOK;
}

void initNode(StudentNode **stuNd, StudentType *stu){
  *stuNd = malloc(sizeof(StudentNode));
  (*stuNd)->data = stu;
  (*stuNd)->next = NULL; 
}

int deleteStudent(StudentList *stuList, char *fname, char *lname) {
  StudentNode *curr = stuList->head;
  if(curr == NULL){
    return C_OK;
  }else if(strcmp(stuList->head->data->basicInfo.last, lname)=0 && strcmp(stuList->head->data->basicInfo.first, fname)=0){
    StudentNode *newHead = stuList->;
    free(stulist)
    stuList->head = newStuNd;
  }
  while(curr!=NULL){
    if(strcmp(stu->basicInfo.last, curr->data->basicInfo.last)>0){
      if(curr->next == NULL || strcmp(stu->basicInfo.last, curr->next->data->basicInfo.last)>0){
        curr = curr->next;
      }else{
        StudentNode *next = curr->next;
        StudentNode *newStuNd;
        initNode(&newStuNd, stu);
        curr->next = newStuNd;
        newStuNd->next = next;
        return C_OK;
      }
    }else{
      curr = curr->next;
    }
  }
  return C_NOK;
}

int cleanupList(StudentList *stuList) {

  return C_OK;
}
