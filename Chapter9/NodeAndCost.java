package Chapter9;

class NodeAndCost<K, V> implements Comparable<NodeAndCost> {
    K node; V cost;

    public NodeAndCost(K node, V cost) {
        this.node = node;
        this.cost = cost;
    }

    public int compareTo(NodeAndCost that) {
        return Integer.compare((int)cost, (int)that.cost);
    }
}