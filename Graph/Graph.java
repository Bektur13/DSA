class Graph {
    public static void main(String[] args) {
        // FIND CENTER OF STAR GRAPH
        public int findCenter(int[][] edges) {
            int u1 = edges[0][0];
            int v1 = edges[0][1];

            int u2 = edges[1][0];
            int v2 = edges[1][1];

            if(u1 == u2 || u1 == v2) {
                return u1;
            }else {
                return v1;
            }
        }
    }
}