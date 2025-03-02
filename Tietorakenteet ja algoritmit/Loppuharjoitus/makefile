CC = gcc
CFLAGS = -Wall

kaynnista : main.o harjoitustyo.o
	$(CC) $(CFLAGS) -o kaynnista main.o harjoitustyo.o

main.o : main.c

harjoitustyo.o : harjoitustyo.c

clean :
	rm -fv harjoitustyo.o main.o
