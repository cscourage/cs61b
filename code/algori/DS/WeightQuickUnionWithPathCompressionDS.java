package DS;

public class WeightQuickUnionWithPathCompressionDS implements DisjointSets {
    private int[] parent;

    public WeightQuickUnionWithPathCompressionDS(int N) {
        parent = new int[N];
        for (int i = 0; i < N; i += 1) {
            parent[i] = -1;
        }
    }

    private int find(int p) {
        int root = p;
        while (parent[root] >= 0) {
            root = parent[root];
        }
        while (p != root && parent[p] != root) {
            int tmp = parent[p];
            parent[p] = root;
            p = tmp;
        }
        return root;
    }

    @Override
    public void connect(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        } else {
            if (parent[pRoot] <= parent[qRoot]) {
                parent[pRoot] += parent[qRoot];
                parent[qRoot] = pRoot;
            } else {
                parent[qRoot] += parent[pRoot];
                parent[pRoot] = qRoot;
            }
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
