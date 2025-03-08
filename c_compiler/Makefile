CC=gcc
CFLAGS=-Wall -Wextra

all: compiler

compiler: src/main.c src/lexer.c src/parser.c src/codegen.c
	$(CC) $(CFLAGS) src/main.c src/lexer.c src/parser.c src/codegen.c -o compiler

clean:
	rm -f compiler
