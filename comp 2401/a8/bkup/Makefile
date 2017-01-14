CFLAGS = -g -std=c99
CC = gcc
OBJ = a8.o a8Util.o a8Setup.o

a8:	$(OBJ)
	$(CC) $(CFLAGS) $(OBJ) -o a8x
a8.o: a8Defs.h
	$(CC) $(CFLAGS) a8.c a8Util.c a8Setup.c -c $<
clean:
	rm -f *.o *.d a8x