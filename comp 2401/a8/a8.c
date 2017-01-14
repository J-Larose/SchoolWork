
#include "a8Defs.h"


int main(){
  init();
  
  /* close sockets */
  close(myListenSocket);
  close(clientSocket);
  return(0);
}

void init(){
  char quit;
  char prompt[5];
  while(1){
    printf("wait or talk\n");
    while(1){
      readString(prompt);
      if(strcmp(prompt, "wait")==0){
        setupServer();
        while(1){
          quit = receiveMessage();
          if (quit == 1){
            break;
          }
          quit = sendMessage();
          if (quit == 1){
            break;
          }
        }
        break;
      }else if(strcmp(prompt, "talk")==0){
        printf("talk\n");
        setupClient();
        while(1){
          quit = sendMessage();
          if (quit == 1){
            break;
          }
          quit = receiveMessage();
          if (quit == 1){
            break;
          }
        }
        break;
      }else if(strcmp(prompt, "exit")==0){
        return;
      }else{
        printf("please enter wait or talk or exit\n");
      }
    }
  }
}

char sendMessage(){
  char inStr[80];
  char buffer[80];
  while (1) {
    printf("what is your message?  ");
//    scanf("%s", inStr);
    fgets(inStr, sizeof(inStr), stdin);
    inStr[strlen(inStr)-1] = 0;
    strcpy(buffer, inStr);
    send(clientSocket, buffer, strlen(buffer), 0);

    if(strcmp(inStr, "close") == 0)
      return 1;
    else{
      return 0;
    }
  } 
}

char receiveMessage(){
  int bytesRcv;
  char buffer[80];
  /* read message from client and do something with it */
  while (1) {
    bytesRcv = recv(clientSocket, buffer, sizeof(buffer), 0);
    buffer[bytesRcv] = 0;
    printf("Message: %s\n", buffer);
    if(strcmp(buffer,"close") == 0)
      return 1;
    else{
      return 0;
    }
  }
}


