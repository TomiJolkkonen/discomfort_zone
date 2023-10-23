#include <stdio.h>
#include "dijkstra.h"

int main(){
	weightedgraph g;
	init_graph(&g,8);

	add_edge(&g,1,2,1);
	add_edge(&g,1,4,7);
	add_edge(&g,1,5,3);

	add_edge(&g,2,3,1);
	add_edge(&g,3,4,2);
	add_edge(&g,5,6,3);

	add_edge(&g,6,7,3);
	add_edge(&g,6,8,3);

	// The other graph
	add_edge(&g,2,4,2);
	add_edge(&g,4,6,2);

	dijkstra(&g,1);

	printf("The path from 1 to 8 with cumulative weights:\n");
	print_path(&g,8);

	delete_graph(&g,8);

	return 0;
}
