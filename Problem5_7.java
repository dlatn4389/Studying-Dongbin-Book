import java.util.ArrayList;

class Node {
    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public void show() {
        System.out.print("(" + index + ", " + distance + ")");
    }
}

public class Problem5_7 {
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) {
        for (int i=0; i<3; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Node(1, 7));
        graph.get(0).add(new Node(2, 5));
        graph.get(1).add(new Node(0, 7));
        graph.get(2).add(new Node(0, 5));

        for (int i=0; i<graph.size(); i++) {
            for (int j=0; j<graph.get(i).size(); j++) {
                graph.get(i).get(j).show();
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
