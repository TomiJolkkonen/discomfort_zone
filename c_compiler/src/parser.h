#ifndef PARSER_H
#define PARSER_H

#include "lexer.h"

typedef struct ASTNode {
    TokenType type;
    int value;
    struct ASTNode *left, *right;
} ASTNode;

ASTNode *parse(Token *tokens, int token_count);

#endif
