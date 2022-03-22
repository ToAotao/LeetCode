class Solution {
    boolean ok = true;
    boolean[] visited, color;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length  ;
        visited = new boolean[n];
        color = new boolean[n];
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                travel(graph, v);
            }
        }
        return ok;
    }
    public void travel(int[][] graph, int s) {
        if (!ok) return;
        visited[s] = true;
        for (int neighbor : graph[s]) {
            if (!visited[neighbor]) {
                color[neighbor] = !color[s];
                travel(graph, neighbor);
            }
            else{
                if(color[neighbor] == color[s]){
                    ok = false;
                }
            }
        }
        
    }
}