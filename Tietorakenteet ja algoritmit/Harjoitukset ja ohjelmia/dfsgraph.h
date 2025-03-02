#ifndef DFSGRAPH_H_INCLUDED
#define DFSGRAPH_H_INCLUDED

// Maximum number of vertices
// define according to your needs
#define MAXVERTS 1000

// Nodes are numbered as integers from 1

// Colors for color table
#define WHITE 0
#define GREY 1
#define BLACK 2

// Defines edge in the adjacency list
typedef struct dfsedgnd {
	int nodenum;
	struct dfsedgnd* next;
} dfsedgenode, *pdfsedgenode;

// Defines the graph
typedef struct dfsg {
	pdfsedgenode adj_list[MAXVERTS+1];
	int pred[MAXVERTS+1];
	int detected[MAXVERTS+1];
	int finished[MAXVERTS+1];
	int color[MAXVERTS+1];
	int nVertices;
} dfsgraph;

// Initializes graph for depth-first search
void init_graph(dfsgraph* g, int vertices);

// Adds new edge (x,y)
void add_edge(dfsgraph* g, int x, int y);

// Actual depdth-first search from node s
void df_search(dfsgraph* g);

// Frees allocated memory
void delete_graph(dfsgraph* g, int vertices);

// Prints detecting and finishing times
void print_info(dfsgraph* g, int vertices);

#endif
