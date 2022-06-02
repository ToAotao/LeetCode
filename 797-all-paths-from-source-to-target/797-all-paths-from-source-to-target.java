class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length - 1;
        LinkedList<Integer> path = new LinkedList<>();
        findPath(n, path, 0, graph);
        return res;
        
    }
    public void findPath(int n, LinkedList<Integer> path, int j, int[][] graph) {
        path.addLast(j);
        if (n == j) res.add(new LinkedList<Integer>(path));
        for (int i = 0; i < graph[j].length; i++) {
            findPath(n, path, graph[j][i], graph);
        }
        path.removeLast();
    }
}