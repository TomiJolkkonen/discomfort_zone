#include <stdlib.h>
#include "parser.h"

ASTNode *parse(Token *tokens, int token_count) {
    if (token_count < 3) { // Ensure we have "return <number>;"
        printf("Error: Not enough tokens to parse. Expected at least 3 tokens.\n");
        return NULL;
    }

    // Check if the sequence is "return <number>;"
    if (tokens[0].type == TOKEN_RETURN && tokens[1].type == TOKEN_NUMBER && tokens[2].type == TOKEN_SEMICOLON) {
        ASTNode *node = malloc(sizeof(ASTNode));
        if (!node) {
            printf("Error: Memory allocation failed for ASTNode.\n");
            return NULL;
        }

        node->type = TOKEN_NUMBER;  // Store the number type
        node->value = tokens[1].value;  // Store the number value
        node->left = node->right = NULL;  // Single node with no children
        return node;
    }

    // Error handling for invalid token sequence
    printf("Error: Invalid token sequence. Expected 'return <number>;' but got:\n");
    for (int i = 0; i < token_count; i++) {
        printf("Token %d: Type %d, Value %d\n", i, tokens[i].type, tokens[i].value);
    }
    return NULL; // Invalid syntax
}
