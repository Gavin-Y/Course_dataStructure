package util.Graph;

/**
 * Created by yejiaquan on 2016/11/2.
 */
public interface Graph<T> {
    /**返回顶点数*/
    int vertexCount();

    /**返回顶点Vi元素*/
    T getVertex(int i);

    /**设置顶点Vi元素为x*/
    void setVertex(int i,T x);

    /**插入元素值为x的顶点，返回顶点序号*/
    int insertVertex(T x);

    /**删除顶点Vi及其关联的边*/
    void removeVertex(int i);

    /**返回Vi在Vj后的后继邻接顶点序号*/
    int next(int i,int j);

    /**插入边<Vi，Vj>，权值为weight*/
    void insertEdge(int i,int j,int weight);

    /**删除边<Vi，Vj>*/
    void removeEdge(int i,int j);

    /**返回<Vi，Vj>边的权值*/
    int weight(int i,int j);

    /**非连通图的一次深度优先搜索遍历，从顶点Vi出发*/
    void DFSTraverse(int i);

    /**非连通图的一次广度优先搜索遍历，从顶点Vi出发*/
    void BFSTraverse(int i);

    /**构造带权无向图的最小生成树，Prim算法*/
    void minSpanTree();

    /**求带权图顶点Vi的单源最短路径，Dijkstra算法*/
    void shortestPath(int i);

    /**求带权图每对顶点间的最短路径及长度，Floyd算法*/
    void shortestPath();
}
