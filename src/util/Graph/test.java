package util.Graph;

/**
 * Created by yejiaquan on 2016/11/3.
 */
public class test {
    public static void main(String[] args) {
        String[] vertices={"A","B","C","D","E"};
        Triple[]edges={new Triple(0,1,45),new Triple(0,2,28),new Triple(0,3,10),
            new Triple(1,0,45),new Triple(1,2,12),new Triple(1,4,21),
            new Triple(2,0,28),new Triple(2,1,12),new Triple(2,3,17),new Triple(2,4,26),
            new Triple(3,0,10),new Triple(3,2,17),new Triple(3,4,15),
            new Triple(4,1,21),new Triple(4,2,26),new Triple(4,3,15)};
        MatrixGraph<String>graph=new MatrixGraph<String>(vertices,edges);
        System.out.println("带权无向图G3（出顶点F），"+graph.toString());
        graph.BFSTraverse(0);
        graph.DFSTraverse(0);
        graph.minSpanTree();
        graph.shortestPath();
    }
//    public static void main(String[] args) {
//
//    }
}
