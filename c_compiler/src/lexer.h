#ifndef LEXER_H
#define LEXER_H

#include <stdio.h>  // ✅ FIX: Include stdio.h for FILE type

typedef enum {
    TOKEN_INT, TOKEN_RETURN, TOKEN_NUMBER, TOKEN_SEMICOLON, TOKEN_EOF
} TokenType;

typedef struct {
    TokenType type;
    int value;  // For numbers
} Token;

int lex(FILE *file, Token *tokens, int max_tokens);

#endif
