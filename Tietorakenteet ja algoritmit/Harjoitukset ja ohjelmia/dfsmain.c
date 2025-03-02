#include <stdio.h>
#include "dfsgraph.h"

int main(){
	dfsgraph g;
	init_graph(&g,8);

	add_edge(&g,1,2);
	add_edge(&g,1,4);
	add_edge(&g,1,5);

	add_edge(&g,2,3);
	add_edge(&g,3,4);
	add_edge(&g,5,6);

	add_edge(&g,6,7);
	add_edge(&g,6,8);

	df_search(&g);

	print_info(&g, 8);

	delete_graph(&g,8);

	return 0;
}
