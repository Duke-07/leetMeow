class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations){
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : invocations){
            graph[edge[0]].add(edge[1]);
        }
        boolean[] vis = new boolean[n];
        dfs(k, graph, vis);
        boolean canRemove = true;
        for (int[] edge : invocations){
            int from = edge[0];
            int to = edge[1];
            if (!vis[from] && vis[to]){
                canRemove = false;
                break;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if (!canRemove){
            for (int i = 0; i < n; i++){
                ans.add(i);
            }
            return ans;
        }
        for (int i = 0; i < n; i++){
            if (!vis[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
    private void dfs(int node, List<Integer>[] graph, boolean[] vis) {
        if (vis[node]){
            return;
        }
        vis[node] = true;
        for (int next : graph[node]){
            dfs(next, graph, vis);
        }
    }
}