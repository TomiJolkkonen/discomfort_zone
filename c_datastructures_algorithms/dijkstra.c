#include <stdio.h>
#include <stdlib.h>
#include "dijkstra.h"

// Initializes graph for breadth-first search
void init_graph(weightedgraph* g, int vertices){
	g->nVertices = vertices;
	int i;
	for(i=1; i <= vertices; i++) {
		g->adj_list[i] = 0;
		g->pred[i] = 0;
		g->dist[i] = INF;
	}
}

// Adds new edge (x,y)
void add_edge(weightedgraph* g, int x, int y, int wght){
	if( x <= g->nVertices && y <= g->nVertices){
		pweightededgenode pxy = malloc(sizeof(weightededgenode));
		pweightededgenode pyx = malloc(sizeof(weightededgenode));

		pxy->nodenum = y;
		pxy->next = g->adj_list[x];
		pxy->weight = wght;
		g->adj_list[x] = pxy;

		pyx->nodenum = x;
		pyx->next = g->adj_list[y];
		pyx->weight = wght;
		g->adj_list[y] = pyx;
	}
}


/*
   Dijkstra's algorithm:
   DIJKSTRA(G,w,s)
   for each vertex v in V
      d[v] = INF
      p[v] = NIL
   d[s] = 0
   S = EMPTY
   Q = V[G]
   while Q != EMPTY
         u =  EXTRACT-MIN(Q)
         S = S UNION {u}
         for each vertex v in Adj[u] do
            if d[v] > d[u] + w(u,v) then
               d[v] = d[u] + w(u,v)
               p[v] = u
*/

// Dijkstra search from node s
void dijkstra(weightedgraph* g, int s){
	int queue[MAXVERTS];
	int i=0;

	// Initializa graph
	for(i=1; i <= g->nVertices; i++) {
		g->pred[i] = 0;
		g->dist[i] = INF;
		// All vertoces in queue
		queue[i] = i;
	}

	g->dist[s] = 0;

	for(i=g->nVertices; i >= 1; i--) {
		// Search for minimum from the queue
		int minval = g->dist[queue[1]];
		int minnode = queue[1];
		int minj=1;
		for(int j = 1; j <= i; j++) {
            if( g->dist[queue[j]] < minval ){
                minval = g->dist[queue[j]];
                minnode = queue[j];
                minj = j;
            }
		}

		// Switch the minimum to end (out of the queue)
		int temp = queue[i];
		queue[i] = queue[minj];
		queue[minj] = temp;

		pweightededgenode pedge = g->adj_list[minnode];

		// Relax the neighbors
		while(pedge != 0){
			int v = pedge->nodenum;
			if(g->dist[v] > (g->dist[minnode]+pedge->weight))  {
				g->dist[v] = g->dist[minnode]+pedge->weight;
				g->pred[v] = minnode;
			}
			pedge = pedge->next;
		}

		// DEBUG INFO:
		// printf("%d processed: d[%d] = %d\n",minnode,minnode,g->dist[minnode]);
	}
}

// Free allocated memory
void delete_graph(weightedgraph* g, int vertices){
	int i;
	for(i=1; i <= vertices; i++) {
		pweightededgenode pedge = g->adj_list[i];
		pweightededgenode pnext = 0;

		while(pedge != 0) {
			pnext = pedge->next;
			free(pedge);
			pedge = pnext;
		}
	}
}

// Print a path after search
void print_path(weightedgraph* g, int dest){
    if( g->pred[dest] != 0){
        print_path(g, g->pred[dest]);
        printf("%d:%d\n",dest,g->dist[dest]);
    }
    else if(g->dist[dest]==0){
        printf("%d:%d\n",dest,g->dist[dest]);
    }
}


