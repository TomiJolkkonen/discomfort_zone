#ifndef DIJKSTRA_H_INCLUDED
#define DIJKSTRA_H_INCLUDED

#include <limits.h>

// Maximum number of vertices
// define according to your needs
#define MAXVERTS 1000

// Nodes are numbered as integers from 1

// Maximum value in the distance table
#define INF INT_MAX

// Defines edge in the adjacency list
typedef struct weightedgnd {
	int nodenum;
	int weight;
	struct weightedgnd* next;
} weightededgenode, *pweightededgenode;

// Defines the graph
typedef struct weightedg {
	pweightededgenode adj_list[MAXVERTS+1];
	int pred[MAXVERTS+1];
	int dist[MAXVERTS+1];
	int nVertices;
} weightedgraph;

// Initializes graph for breadth-first search
void init_graph(weightedgraph* g, int vertices);

// Adds new edge (x,y)
void add_edge(weightedgraph* g, int x, int y, int wght);

// Actual breadth-first search from node s
void dijkstra(weightedgraph* g, int s);

// Frees allocated memory
void delete_graph(weightedgraph* g, int vertices);

// Print a path after search
void print_path(weightedgraph* g, int dest);

#endif
