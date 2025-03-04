#ifndef BFSGRAPH_H_INCLUDED
#define BFSGRAPH_H_INCLUDED

#include <limits.h>

// Maximum number of vertices
// define according to your needs
#define MAXVERTS 1000

// Nodes are numbered as integers from 1

// Colors for color table
#define WHITE 0
#define GREY 1
#define BLACK 2

// Maximum value in the distance table
#define INF INT_MAX

// Colors for bicoloring
#define RED 0
#define BLUE 1

// Defines edge in the adjacency list
typedef struct bfsedgnd {
	int nodenum;
	struct bfsedgnd* next;
} bfsedgenode, *pbfsedgenode;

// Defines the graph
typedef struct bfsg {
	pbfsedgenode adj_list[MAXVERTS+1];
	int pred[MAXVERTS+1];
	int dist[MAXVERTS+1];
	int color[MAXVERTS+1];
	int nVertices;
} bfsgraph;

// Initializes graph for breadth-first search
void init_graph(bfsgraph* g, int vertices);

// Adds new edge (x,y)
void add_edge(bfsgraph* g, int x, int y);

// Actual breadth-first search from node s
void bfsearch(bfsgraph* g, int s);

// Frees allocated memory
void delete_graph(bfsgraph* g, int vertices);

void print_path(bfsgraph* g, int dest);
// Implement this function:
// int bipartite(bfsgraph* g, int *colortable);
#endif
