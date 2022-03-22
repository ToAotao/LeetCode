class Solution {
    boolean[] color, visited;
    boolean ok = true;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        color = new boolean[n + 1];
        visited = new boolean[n + 1];
        List<Integer>[] graph = buildGraph(n, dislikes);
        for (int v = 1; v<=n; v++){
            if (!visited[v]) {
                travel(graph, v);
            }
        }
        return ok;
    }
    public List<Integer>[] buildGraph(int n, int[][] dislikes) {
        List<Integer>[] res = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++){
            res[i] = new LinkedList<>();
        }
        for (int[] a : dislikes) {
            int u = a[0];
            int v = a[1];
            res[u].add(v);
            res[v].add(u);
        }
        return res;
    }
    public void travel (List<Integer>[] graph, int v) {
        if (!ok) return;
        visited[v] = true;
        for (int neighbor : graph[v]) {
            if (!visited[neighbor]){
                color[neighbor] = !color[v];
                travel(graph, neighbor);
            } else {
                if (color[v] == color[neighbor]){
                    ok = false;
                }
            }
        }
    }
}