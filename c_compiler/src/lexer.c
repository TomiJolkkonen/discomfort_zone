#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include "lexer.h"

int lex(FILE *file, Token *tokens, int max_tokens) {
    int i = 0, c;
    while ((c = fgetc(file)) != EOF && i < max_tokens) {
        printf("Read character: '%c' (ASCII: %d)\n", c, c);  // Debugging: print each character

        if (isdigit(c)) {  // Handle numbers
            tokens[i].type = TOKEN_NUMBER;
            tokens[i].value = c - '0';  // Assuming single-digit numbers for simplicity
            printf("Token %d: Type %d, Value %d\n", i, tokens[i].type, tokens[i].value);  // Debugging: print token
            i++;  // Move to next token
        } else if (c == 'r') {  // Check if 'r' is the first character in "return"
            char buffer[7] = { c, 0 };  // Temporary buffer to store the "return" string

            // Read the next 5 characters to complete "return"
            if (fread(&buffer[1], 1, 5, file) == 5) {
                buffer[6] = '\0';  // Null-terminate the string
                if (strncmp(buffer, "return", 6) == 0) {
                    tokens[i].type = TOKEN_RETURN;  // Assign TOKEN_RETURN
                    printf("Token %d: Type %d, Value %d (return)\n", i, tokens[i].type, 0);  // Debugging
                    i++;  // Move to next token after "return"
                }
            }
        } else if (c == ';') {  // Handle semicolon
            tokens[i].type = TOKEN_SEMICOLON;
            tokens[i].value = 0;  // Semicolons don't need a value
            printf("Token %d: Type %d, Value %d (;)\n", i, tokens[i].type, tokens[i].value);  // Debugging
            i++;  // Move to next token after semicolon
        } else if (isspace(c)) {
            continue;  // Skip whitespaces
        } else {
            // Invalid character or unknown token (do nothing)
            continue;
        }
    }
    tokens[i].type = TOKEN_EOF;  // End of tokens
    printf("Tokens: ");
    for (int j = 0; j < i; j++) {
        printf("[%d] ", tokens[j].type);  // Debugging: print the token types
    }
    printf("\n");

    return i;
}
