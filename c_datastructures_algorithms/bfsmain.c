#include <stdio.h>
#include "bfsgraph.h"

int main(){
	bfsgraph g;
	int colors[8];

	init_graph(&g,8);

	add_edge(&g,1,2);
	add_edge(&g,1,4);
	add_edge(&g,1,5);

	add_edge(&g,2,3);
	add_edge(&g,3,4);
	add_edge(&g,5,6);

	add_edge(&g,6,7);
	add_edge(&g,6,8);

    add_edge(&g,2,4);

	bfsearch(&g,1);
	print_path(&g,8);

	delete_graph(&g,8);

	return 0;
}
