#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

#define MY_PORT 60002
#define MAX_STR 32

void setupServer();
void setupClient();
char receiveMessage();
char sendMessage();
void init();

void readString(char *str);
void readInt(int *x);




int clientSocket;
int myListenSocket;