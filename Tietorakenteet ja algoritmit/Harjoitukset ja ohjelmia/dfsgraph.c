#include <stdio.h>
#include <stdlib.h>
#include "dfsgraph.h"

// Initializes graph for breadth-first search
void init_graph(dfsgraph* g, int vertices){
	g->nVertices = vertices;
	int i;
	for(i=1; i <= vertices; i++) {
		g->adj_list[i] = 0;
		g->pred[i] = 0;
		g->detected[i] = 0;
		g->finished[i] = 0;
		g->color[i] = WHITE; 
	}
}

// Adds new edge (x,y)
void add_edge(dfsgraph* g, int x, int y){
	if( x <= g->nVertices && y <= g->nVertices){
		pdfsedgenode pxy = malloc(sizeof(pdfsedgenode));
		
		pxy->nodenum = y;
		pxy->next = g->adj_list[x];
		g->adj_list[x] = pxy;
		
	} 
}


/*
DFS(G)
1.for each u in V
2.  color[u] = WHITE
3.  p[u] = NIL
4.  time = 0
5.for each u in V
6.  if color[u]==WHITE
7.	DFS_VISIT(u)
8.return

DFS_VISIT(u)
1. color[u] = GRAY
2. time = time+1
3. d[u] = time
4. for each v in Adj[u] 
5.   if color[v]==WHITE 
6.     p[v] = u
7.	 DFS_VISIT(v)
8. color[u] = BLACK
9. time = time+1
10.f[u] = time
11.return
*/

int get_time(){
	static int time = 0;
	
	time = time+1;
	return time; 
}

void dfs_visit(dfsgraph* g, int u){
	g->color[u] = GREY;
	g->detected[u] = get_time();
	
	pdfsedgenode pedge = g->adj_list[u];
	while(pedge != 0){
		int v = pedge->nodenum;
		if(g->color[v] == WHITE) {
			g->pred[v] = u;
			dfs_visit(g,v);
		}
		pedge = pedge->next;
	}
	g->color[u] = BLACK;
	g->finished[u] = get_time();
}

// Actual depth-first search 
void df_search(dfsgraph* g){
	int u;
	for(u=1; u<=g->nVertices; u++){
		if( g->color[u] == WHITE){
			dfs_visit(g,u);
		}
	}
}

// Free allocated memory
void delete_graph(dfsgraph* g, int vertices){
	int i;
	for(i=1; i <= vertices; i++) {
		pdfsedgenode pedge = g->adj_list[i];
		pdfsedgenode pnext = 0;
		
		while(pedge != 0) {
			pnext = pedge->next;
			free(pedge);
			pedge = pnext;
		} 
	}
}

void print_info(dfsgraph* g, int vertices){
	int i;
	printf("Node\tdetect\tfinish \n ");
	for(i=1; i <= vertices; i++) {
		printf(" %d \t %d \t %d\n",i,g->detected[i],g->finished[i]); 
	}
}