CFLAGS = -g -std=c99
CC = gcc
OBJ = a7Util.o a7Main.o a7Inits.o

a7: $(OBJ)
	$(CC) $(CFLAGS) $(OBJ) -o a7x

a7.o: a7Defs.h
	$(CC) $(CFLAGS) a7Main.c a7Util.c a7Inits.c -c $<

clean:
	rm -f *.o *.d a7x