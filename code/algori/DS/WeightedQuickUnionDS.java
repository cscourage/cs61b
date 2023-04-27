package DS;

public class WeightedQuickUnionDS implements DisjointSets {
    private int[] weightParent;

    public WeightedQuickUnionDS(int N) {
        weightParent = new int[N];
        for (int i = 0; i < N; i += 1) {
            weightParent[i] = -1;
        }
    }

    private int find(int p) {
        while (weightParent[p] >= 0) {
            p = weightParent[p];
        }
        return p;
    }

    @Override
    public void connect(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        if (weightParent[pRoot] <= weightParent[qRoot]) {
            weightParent[pRoot] += weightParent[qRoot];
            weightParent[qRoot] = pRoot;
        } else {
            weightParent[qRoot] += weightParent[pRoot];
            weightParent[pRoot] = qRoot;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
