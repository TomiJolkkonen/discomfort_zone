#include <stdio.h>
#include "codegen.h"

void generate_code(ASTNode *ast) {
    if (!ast) {
        printf("Error: AST is NULL\n");
        return;
    }

    printf("section .text\n");
    printf("global _start\n");
    printf("_start:\n");

    if (ast->type == TOKEN_NUMBER) {  // ✅ Ensure we handle numbers correctly
        printf("    mov rax, %d\n", ast->value);
        printf("    ret\n");
    } else {
        printf("Error: Unsupported AST node type\n");
    }
}
