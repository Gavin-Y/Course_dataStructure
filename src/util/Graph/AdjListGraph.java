package util.Graph;

import util.Matrix.LinedMatrix;
import util.SinglyList.Node;
import util.SinglyList.SortedSinglyList;

/**
 * Created by yejiaquan on 2016/11/3.
 */
public class AdjListGraph<T> extends AbstractGraph<T>{
    protected LinedMatrix adjlist;

    public AdjListGraph(int length){
        super(length);
        this.adjlist=new LinedMatrix(length,length);
    }
    public AdjListGraph(){
        this(10);
    }
    public AdjListGraph(T[]vertices){
        this(vertices.length);
        for (T vertice : vertices) {
            this.insertVertex(vertice);
        }
    }
    public AdjListGraph(T[]vertices,Triple[]edges){
        this(vertices);
        for (Triple edge : edges) {
            this.insertEdge(edge);
        }
    }
    public String toString(){
        return super.toString()+"出边表：\n"+this.adjlist.toString();
    }
    /**
     * 插入元素值为x的顶点，返回顶点序号
     *
     * @param x
     */
    @Override
    public int insertVertex(T x) {
        int i=this.vertexlist.insert(x);
        if (i>=this.adjlist.getRows())
            this.adjlist.setRowsColumns(i+1,i+1);
        return i;
    }

    /**
     * 删除顶点Vi及其关联的变
     *
     * @param i
     */
    @Override
    public void removeVertex(int i) {
        int n=vertexCount();
        if (i>=0&&i<n){
            SortedSinglyList<Triple>link=this.adjlist.rowlist.get(i);
            for(Node<Triple>p=link.head.next;p!=null;p=p.next)
                this.removeEdge(p.data.toSymmetry());
            n--;
            this.adjlist.rowlist.remove(i);
            this.adjlist.setRowsColumns(n,n);
            for (int j = 0; j < n; j++) {
                link=this.adjlist.rowlist.get(i);
                for (Node<Triple> p = link.head.next; p != null ; p=p.next) {
                    if (p.data.row>i)
                        p.data.row--;
                    if (p.data.column>i)
                        p.data.column--;
                }
            }
            this.vertexlist.remove(i);
        }
        else throw new IndexOutOfBoundsException("i+"+i);
    }

    /**
     * 返回Vi在Vj后的后继邻接顶点序号
     *
     * @param i
     * @param j
     */
    @Override
    public int next(int i, int j) {
        int n=this.vertexCount();
        if (i>=0&&i<n&&j>=-1&&i!=j){
            SortedSinglyList<Triple>link=this.adjlist.rowlist.get(i);
            Node<Triple>find=link.head.next;
            if (j==-1)
                return find!=null?find.data.column:-1;
            find=link.search(new Triple(i,j,0));
            if (find!=null){
                find=find.next;
                if (find!=null)
                    return find.data.column;
            }
        }
        return -1;
    }

    /**
     * 插入边<Vi，Vj>，权值为weight
     *
     * @param i
     * @param j
     * @param weight
     */
    @Override
    public void insertEdge(int i, int j, int weight) {
        if (i!=j){
            if (weight<0||weight>=MAX_WEIGHT)
                weight=0;
            this.adjlist.set(i,j,weight);
        }
        else throw new IllegalArgumentException("不能插入自身环，i="+i+",j="+j);
    }

    public void insertEdge(Triple edge){
        this.insertEdge(edge.row,edge.column,edge.value);
    }

    /**
     * 删除边<Vi，Vj>
     *
     * @param i
     * @param j
     */
    @Override
    public void removeEdge(int i, int j) {
        if (i!=j)
            this.adjlist.set(new Triple(i,j,0));
    }
    public void removeEdge(Triple edge){
        this.removeEdge(edge.row,edge.column);
    }

    /**
     * 返回<Vi，Vj>边的权值
     *
     * @param i
     * @param j
     */
    @Override
    public int weight(int i, int j) {
        if (i==j)
            return 0;
        int weight=this.adjlist.get(i, j);
        return weight!=0?weight:MAX_WEIGHT;
    }

    /**
     * 求带权图顶点Vi的单源最短路径，Dijkstra算法
     *
     * @param i
     */
    @Override
    public void shortestPath(int i) {

    }

    /**
     * 求带权图每对顶点间的最短路径及长度，Floyd算法
     */
    @Override
    public void shortestPath() {

    }
}
