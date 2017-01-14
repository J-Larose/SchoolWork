#include "a8Defs.h"

void setupClient(){
  struct sockaddr_in  addr;
  int i;

  /* create socket */
  clientSocket = socket(PF_INET, SOCK_STREAM, IPPROTO_TCP);
  if (clientSocket < 0) {
    printf("eek! couldn't open socket\n");
    exit(-1);
  }

  printf("enter server ip\n");
  char ip[MAX_STR];
  readString(ip);
  printf("enter server port\n");
  int port;
  readInt(&port);

/* setup address */
  memset(&addr, 0, sizeof(addr));
  addr.sin_family = AF_INET;
  addr.sin_addr.s_addr = inet_addr(ip);
  addr.sin_port = htons((unsigned short) port);

/* connect to server */

  i = connect(clientSocket, 
              (struct sockaddr *) &addr,
              sizeof(addr));
  if (i<0) {
    printf("client could not connect!\n");
    exit(-1);
  }

}

void setupServer(){
  struct sockaddr_in  myAddr, clientAddr;
  int i, addrSize;

  /* create socket */
  myListenSocket = socket(PF_INET, SOCK_STREAM, IPPROTO_TCP);
  if (myListenSocket < 0) {
    printf("eek! couldn't open socket\n");
    exit(-1);
  }


/* setup my server address */
  memset(&myAddr, 0, sizeof(myAddr));
  myAddr.sin_family = AF_INET;
  myAddr.sin_addr.s_addr = htonl(INADDR_ANY);
  myAddr.sin_port = htons((unsigned short) MY_PORT);

/* bind my listen socket */
  i = bind(myListenSocket, 
           (struct sockaddr *) &myAddr,
           sizeof(myAddr));
  if (i < 0) {
    printf("eek! couldn't bind socket\n");
    exit(-1);
  }


/* listen */
  i = listen(myListenSocket, 5);
  if (i < 0) {
    printf("eek! couldn't listen\n");
    exit(-1);
  }


/* wait for connection request */
  addrSize = sizeof(clientAddr);

  clientSocket = accept(myListenSocket,
                        (struct sockaddr *) &clientAddr,
                        &addrSize);
  if (clientSocket < 0) {
    printf("eek! couldn't accept the connection\n");
    exit(-1);
  }
}