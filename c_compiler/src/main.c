#include <stdio.h>
#include <stdlib.h>
#include "lexer.h"
#include "parser.h"
#include "codegen.h"

int main(int argc, char *argv[]) {
    if (argc < 2) {
        printf("Usage: %s <source.c>\n", argv[0]);
        return 1;
    }

    // Read input file
    FILE *file = fopen(argv[1], "r");
    if (!file) {
        perror("Error opening file");
        return 1;
    }

    // Lexing: Tokenize the input
    Token tokens[1000];
    int token_count = lex(file, tokens, 1000);
    fclose(file);

    // Parsing: Build AST
    ASTNode *ast = parse(tokens, token_count);
    
    // Code generation: Emit assembly
    generate_code(ast);

    return 0;
}
