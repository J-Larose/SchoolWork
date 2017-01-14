#include <stdio.h>
#include <string.h>

#define MAX_ARR  64
#define MAX_STR  32

typedef enum { COMEDY, DRAMA, HORROR, SCIFI 
} GenreType;

typedef struct {
  char title[MAX_STR];
  char director[MAX_STR];
  int  year;
  GenreType genre;
} MovieType;

void initMovie(char*, char*, int, GenreType, MovieType*);
void printMovies(MovieType*, int);
void readString(char*);
void readInt(int*);
void buildObject(MovieType* movie);



/**
This program creates an array of movies and then prints them
BY: Jacob Larose, 101013798
*/
int main()
{
  MovieType arr[MAX_ARR];
  int arrLength = 0;
  int cont;
  for(int x=0;x<MAX_ARR;x++){
    printf("would you like to add another movie?(1 for yes/0 for no)\n");
    readInt(&cont);
    if(cont == 1){
      buildObject(arr+x);
      arrLength++;
    }else{
      break;
    }
  }
  printMovies(arr, arrLength);
  return 0;
}
/**
print all properties of all movies in array arr
input variable:
  arr: array of movies
  length: number of movies in array
*/
void printMovies(MovieType* arr, int length){
  for (int i = 0; i < length; i++)
  {
    printf("Movie # %d\n", i+1);
    printf("%s\n",(arr+i)->title);
    printf("%s\n",(arr+i)->director);
    printf("%d\n",(arr+i)->year);
    switch((arr+i)->genre){
      case COMEDY:
        printf("Comedy\n");
        break;
      case DRAMA:
        printf("Drama\n");
        break;
      case HORROR:
        printf("Horor\n");
        break;
      case SCIFI:
        printf("Sci-fi\n");
        break;
    }
  }
}
/**
initializes and populates movie structs
output variables:
  movie: pointer to the movie that is being populated
*/
void buildObject(MovieType* movie){
  char title[MAX_STR];
  char director[MAX_STR];
  int year;
  int genre;
  printf("enter the title\n");
  readString(title);
  printf("enter the director\n");
  readString(director);
  printf("enter the year\n");
  while(1){
    readInt(&year);
    if(year>1895){
      break;
    }else{
      printf("that movie is older than movies, enter a more recent date:\n");
    }
  }
  
  printf("please chose a genre, 0 for COMEDY, 1 for drama, 2 for HORROR, or 3 for SCIFI.\n");
  while(1){
    readInt(&genre);
    if(genre>3||genre<0){
      printf("please try again.\n");
    }else{
      break;
    }
  }
  

  GenreType genreReal = genre;
  initMovie(title, director, year, genreReal, movie);
}
/**
sub-function of buildObject; populates movie object
input variables: 
  title: title of the movie
  director: director of the movie
  year: year of the movie
  genre: genre of the movie
output variable:
  movie: pointer to the movie being populated
*/
void initMovie(char* title, char* director, int year, GenreType genre, MovieType* movie){
  strcpy(movie->title, title);
  strcpy(movie->director, director);
  movie->year = year;
  movie->genre = genre;
}

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