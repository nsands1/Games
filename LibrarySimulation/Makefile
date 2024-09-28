CC = gcc
CFLAGS = -Wall -g
TARGET = librarian_simulator

all: $(TARGET)

$(TARGET): game.o patron.o library.o book.o utils.o
	$(CC) $(CFLAGS) -o $(TARGET) game.o patron.o library.o book.o utils.o

game.o: game.c game.h library.h patron.h
	$(CC) $(CFLAGS) -c game.c

patron.o: patron.c patron.h book.h
	$(CC) $(CFLAGS) -c patron.c

library.o: library.c library.h book.h
	$(CC) $(CFLAGS) -c library.c

book.o: book.c book.h
	$(CC) $(CFLAGS) -c book.c

utils.o: utils.c utils.h
	$(CC) $(CFLAGS) -c utils.c

clean:
	rm -f *.o $(TARGET)
