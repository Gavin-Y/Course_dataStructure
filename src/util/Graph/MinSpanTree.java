package util.Graph;

import util.Heap.Heap;
import util.Set.UnionFindSet;

import java.util.Comparator;

/**
 * Created by yejiaquan on 2016/11/7.
 */
public class MinSpanTree {
    private Triple[]mst;
    private int cost=0;
    public MinSpanTree(int n,Triple[]edges, Comparator<Triple>cmpr){
        this.mst=new Triple[n-1];
        Heap<Triple> minheap=new Heap<Triple>(true,edges,cmpr);
        UnionFindSet ufset=new UnionFindSet(n);
        int i=0;
        for (int j = 0; j < n; j++) {
            Triple minedge=minheap.remove(0);
            if (ufset.union(minedge.row,minedge.column)){
                this.mst[i++]=minedge;
                this.cost+=minedge.value;
            }
        }
    }
    public String toString(){
        String str="最小生成树的边的集合：";
        for (int i = 0; i < mst.length; i++) {
            str+=mst[i].toString();
        }
        str+=",最小代价为"+cost;
        return str;
    }
    public static void main(String[] args) {
        Triple[]edges={new Triple(0,1,16),new Triple(0,2,18),new Triple(0,3,9),
                new Triple(1,2,7),new Triple(1,4,3),
                new Triple(2,3,16),new Triple(2,4,5),
                new Triple(3,4,15)};
        MinSpanTree mstree=new MinSpanTree(5,edges,new TripleComparator());
        System.out.println(mstree.toString());
    }
}