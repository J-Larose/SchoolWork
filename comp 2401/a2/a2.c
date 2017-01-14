#include <stdio.h>
#define GR_NUM 10


int takeInput(float* arr);
float avg(float* worth, float*grades, int size);
/* 
this program calculates a students final grade based on sub-grades and their value
one integer per line, avoid empty lines and non-integer charecters, enter a negative after the last number for any array
by: Jacob Larose, 101013798
*/
int main(){
	//declare variables
	float worth[GR_NUM];
	float grades[GR_NUM];
	int worthSize;
	int gradesSize;
	//loop for error checking retries
	while(1){
		//input arrays and return size
		printf("what are the grades worth?\n");
		worthSize = takeInput(worth);
		printf("what are the grades\n");
		gradesSize = takeInput(grades);
		//calculate the total of first array to ensure that it is worth 100%
		float total = 0;

		for(int x = 0;x<worthSize; x++){
			total += worth[x];
			

		}

		if(worthSize>gradesSize){
			printf("you have not entered enough grades\n");
		}else if(worthSize<gradesSize){
			printf("you have entered too many grades\n");
		}else if(total != 100){
			printf("your grades are not worth 100%% total. \n");
		}else{
			break;
		}
	}
	//calculate and return final avg
	float final = avg(worth, grades, gradesSize);

	printf("your final grade is %.2f\n", final);

	return 0 ;

}
/*
insert numbers into given array 
input/output parameters:
  arr: the array into which numbers inserted
returns: int of the size of the array
*/
int takeInput(float* arr){
	int size = 0;
	float holdCell;
	while(1){
		scanf("%f", &holdCell);
		if(holdCell <= 0){
			break;
		}else{
			arr[size] = holdCell;
		}
		size++;
	}
	return size;
}
/*
calculat avg for the course
input parameters:
  worth: the array holding the value of each grade
  grades: the array holding the grades
  size: the size of both arrays
returns: float of the avg of the grades based on their worth
*/
float avg(float* worth, float* grades,int size){
	float sum = 0.0;
	for(int x =0; x<size; x++){
		printf("%f\n", worth[x]);
		printf("%f\n", grades[x]);
		printf("test\n");
		sum += (grades[x]*(worth[x]/100));
	}
	return sum;
}