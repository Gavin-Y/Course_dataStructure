package util.Graph;

import util.Matrix.Matrix;
import util.Queue.LinkedQueue;
import util.SeqList.SeqList;
import util.SinglyList.SinglyList;

/**
 * Created by yejiaquan on 2016/11/2.
 */
public abstract class AbstractGraph<T> implements Graph<T>{

    protected static final int MAX_WEIGHT=0x0000ffff;
    protected SeqList<T>vertexlist;

    public AbstractGraph(int length){
        this.vertexlist=new SeqList<T>(length);
    }

    public AbstractGraph(){
        this(10);
    }

    /**
     * 返回顶点数
     */
    @Override
    public int vertexCount() {
        return this.vertexlist.size();
    }

    public String toString(){
        return "顶点集合："+this.vertexlist.toString()+"\n";
    }

    /**
     * 返回顶点Vi元素
     *
     * @param i
     */
    @Override
    public T getVertex(int i) {
        return this.vertexlist.get(i);
    }

    /**
     * 设置顶点Vi元素为x
     *
     * @param i
     * @param x
     */
    @Override
    public void setVertex(int i, T x) {
        this.vertexlist.set(i,x);
    }

    /**
     * 插入元素值为x的顶点，返回顶点序号
     *
     * @param x
     */
    @Override
    public abstract int insertVertex(T x);

    /**
     * 删除顶点Vi及其关联的变
     *
     * @param i
     */
    @Override
    public abstract void removeVertex(int i);

    /**
     * 返回Vi在Vj后的后继邻接顶点序号
     *
     * @param i
     * @param j
     */
    @Override
    public abstract int next(int i, int j);

    /**
     * 插入边<Vi，Vj>，权值为weight
     *
     * @param i
     * @param j
     * @param weight
     */
    @Override
    public abstract void insertEdge(int i, int j, int weight);

    /**
     * 删除边<Vi，Vj>
     *
     * @param i
     * @param j
     */
    @Override
    public abstract void removeEdge(int i, int j);

    /**
     * 返回<Vi，Vj>边的权值
     *
     * @param i
     * @param j
     */
    @Override
    public abstract int weight(int i, int j);

    /**
     * 非连通图的一次深度优先搜索遍历，从顶点Vi出发
     *
     * @param i
     */
    @Override
    public void DFSTraverse(int i){
        boolean[]visited=new boolean[this.vertexCount()];
        int j=i;
        do{
            if (!visited[j]){
                System.out.print("{");
                this.depthfs(j,visited);
                System.out.print("}");
            }
            j=(j+1)%this.vertexCount();
        }while (j!=i);
        System.out.println();
    }
    private void depthfs(int i,boolean[]visited){
        System.out.print(this.getVertex(i)+" ");
        visited[i]=true;
        int j=this.next(i,-1);
        while (j!=-1){
            if (!visited[j])
                depthfs(j,visited);
            j=this.next(i,j);
        }
    }

    /**
     * 非连通图的一次广度优先搜索遍历，从顶点Vi出发
     *
     * @param i
     */
    @Override
    public void BFSTraverse(int i){
        boolean[]visited=new boolean[this.vertexCount()];
        int j=i;
        do{
            if (!visited[j]){
                System.out.print("{");
                breadthfs(j,visited);
                System.out.print("}");
            }
            j=(j+1)%this.vertexCount();
        }while (j!=i);
        System.out.println();
    }
    private void breadthfs(int i,boolean[]visited){
        System.out.print(this.getVertex(i)+" ");
        visited[i]=true;
        LinkedQueue<Integer>que=new LinkedQueue<Integer>();
        que.add(i);
        while (!que.isEmpty()){
            i=que.poll();
            for (int j=next(i,-1);j!=-1;j=next(i,j))
                if (!visited[j]){
                    System.out.print(this.getVertex(j)+" ");
                    visited[j]=true;
                    que.add(j);
                }
        }
    }

    /**
     * 构造带权无向图的最小生成树，Prim算法
     */
    @Override
    public void minSpanTree(){
        Triple[]mst=new Triple[vertexCount()-1];
        for (int i = 0; i < mst.length; i++) {
            mst[i]=new Triple(0,i+1,this.weight(0,i+1));
        }
        for (int i = 0; i < mst.length; i++) {
            int minweight=mst[i].value,min=i;
            for (int j = i+1; j < mst.length; j++) {
                if (mst[j].value<minweight){
                    minweight=mst[j].value;
                    min=j;
                }
            }
            Triple edge = mst[min];
            mst[min]=mst[i];
            mst[i]=edge;

            int tv=edge.column;
            for (int j=i+1;j<mst.length;j++){
                int v=mst[j].column;
                int weight=this.weight(tv,v);
                if (weight<mst[j].value)
                    mst[j]=new Triple(tv,v,weight);
            }
        }
        System.out.println("\n最小生成树的边的集合：");
        int mincost=0;
        for (Triple aMst : mst) {
            System.out.println(aMst + " ");
            mincost += aMst.value;
        }
        System.out.println("，最小代价为"+mincost);
    }


    /**
     * 求带权图顶点Vi的单源最短路径，Dijkstra算法
     *
     * @param i
     */
    @Override
    public void shortestPath(int i){
        int n=this.vertexCount();
        boolean[]vset=new boolean[n];
        vset[i]=true;
        int[]dist=new int[n];
        int[]path=new int[n];
        for (int j = 0; j < n; j++) {
            dist[j]=this.weight(i,j);
            path[j]=(j!=i&&dist[j]<MAX_WEIGHT)?i:-1;
        }
        for (int j = (i+1)%n; j!=i ; j=(j+1)%n) {
            int mindist=MAX_WEIGHT,min=0;
            for (int k = 0; k < n; k++) {
                if (!vset[k]&&dist[k]<mindist){
                    mindist=dist[k];
                    min=k;
                }
            }
            if (mindist==MAX_WEIGHT)
                break;;
            vset[min]=true;
            for (int k = 0; k < n; k++) {
                if (!vset[k]&&this.weight(min,k)<MAX_WEIGHT&&dist[min]+this.weight(min,k)<dist[k]){
                    dist[k]=dist[min]+this.weight(min,k);
                    path[k]=min;
                }
            }
        }
        System.out.println(this.getVertex(i)+"顶点的单源最短路径：");
        for (int j = 0; j < n; j++) {
            if (j!=i){
                SinglyList<T>pathlink=new SinglyList<T>();
                pathlink.insert(0,this.getVertex(j));
                for (int k = path[j]; k !=i&&k!=j&&k!=-1 ; k=path[k]) {
                    pathlink.insert(0,this.getVertex(k));
                }
                pathlink.insert(0,this.getVertex(i));
                System.out.println(pathlink.toString()+"长度"+(dist[j]==MAX_WEIGHT?"∞":dist[j]+","));
            }
        }
        System.out.println();
    }

    /**
     * 求带权图每对顶点间的最短路径及长度，Floyd算法
     */
    @Override
    public void shortestPath(){
        int n=this.vertexCount();
        Matrix path=new Matrix(n),dist=new Matrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int w=this.weight(i,j);
                dist.set(i,j,w);
                path.set(i,j,(i!=j&&w<MAX_WEIGHT?i:-1));
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (i!=k)
                    for (int j = 0; j < n; j++) {
                        if (j!=k&&j!=i&&dist.get(i,j)>dist.get(i,k)+dist.get(k,j)){
                            dist.set(i,j,dist.get(i,k)+dist.get(k,j));
                            path.set(i,j,path.get(k,j));
                        }
                    }
            }
        }
        System.out.println("每对顶点之间的最短路径如下：");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i!=j){
                    System.out.println(toPath(path,i,j)+"长度"+(dist.get(i,j)==MAX_WEIGHT?"∞":dist.get(i,j)+","));
                }
            }
            System.out.println();
        }
    }
    private String toPath(Matrix path,int i,int j){
        SinglyList<T>pathlink=new SinglyList<T>();
        pathlink.insert(0,this.getVertex(j));
        for (int k=path.get(i,j);k!=i&&k!=j&&k!=-1;k=path.get(i,k))
            pathlink.insert(0,this.getVertex(k));
        pathlink.insert(0,this.getVertex(i));
        return pathlink.toString();
    }
}
