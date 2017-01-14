#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <unistd.h>

volatile int running;

void callBack(int i){
	printf("recieved signal %d\n",i);
	if(i == SIGINT){
		exit(0);
	}
}

int main(int argc, char* argv[])
{
  int pid = fork();

  if(pid==0){
  	running = 1;

  	signal(SIGUSR1, callBack);
  	signal(SIGUSR2, callBack);
  	signal(SIGINT, callBack);
  	while (running == 1){
    	sleep(1);
    }
  }else{
  	printf("pick a signal\n");
  	int choice;
  	scanf("%d", &choice);
  	switch(choice){
  		case 0: kill(pid, SIGINT); break;
  		case 1: kill(pid, SIGUSR1); break;
  		case 2: kill(pid, SIGUSR2); break;
  	}
  }
}
