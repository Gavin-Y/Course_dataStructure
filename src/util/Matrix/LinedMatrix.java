package util.Matrix;

import util.Graph.Triple;
import util.Math.Polynomial.PolySinglyList;
import util.SeqList.SeqList;
import util.SinglyList.Node;
import util.SinglyList.SortedSinglyList;

/**
 * Created by yejiaquan on 2016/11/2.
 */
public class LinedMatrix {
    private int rows,columns;
    public SeqList<PolySinglyList<Triple>>rowlist;
    public LinedMatrix(int m,int n){
        if (m>0&&n>0){
            this.rows=m;
            this.columns=n;
            this.rowlist=new SeqList<PolySinglyList<Triple>>();
            for (int i = 0; i < m; i++) {
                this.rowlist.insert(new PolySinglyList<Triple>());
            }
        }
        else throw new IllegalArgumentException("矩阵行列数不能小于0，m="+m+",n="+n);
    }
    public LinedMatrix(int m){
        this(m,m);
    }
    public LinedMatrix(int m,int n,Triple[]tris){
        this(m,n);
        for (int i = 0; i < tris.length; i++) {
            this.set(tris[i]);
        }
    }
    public int getRows(){
        return this.rows;
    }
    public int getColumns(){
        return this.columns;
    }
    public void set(int i,int j,int x){
        this.set(new Triple(i,j,x));
    }
    public void set(Triple tri){
        int i=tri.row,j=tri.column;
        if (i>=0&&i<this.rows&&j>=0&&j<this.columns){
            SortedSinglyList<Triple>link=this.rowlist.get(i);
            if (tri.value==0)
                link.remove(tri);
            else {
                Node<Triple>find=link.search(tri);
                if (find!=null)
                    find.data.value=tri.value;
                else link.insert(tri);
            }
        }
        else throw new IndexOutOfBoundsException("i="+i+",j="+j);
    }
    public int get(int i,int j){
        if (i>=0&&i<this.rows&&j>=0&&j<this.columns){
            Node<Triple>find=this.rowlist.get(i).search(new Triple(i,j,0));
            return (find!=null)?find.data.value:0;
        }
        throw new IndexOutOfBoundsException("i="+i+",j="+j);
    }
    public String toString(){
        String str="";
        for (int i = 0; i < this.rowlist.size(); i++) {
            str+=i+"->"+this.rowlist.get(i).toString()+"\n";
        }
        return str;
    }
    public void printMatrix(){
        System.out.println("矩阵"+this.getClass().getName()+"("+rows+"x"+columns+")");
        for (int i = 0; i < this.rowlist.size(); i++) {
            Node<Triple>p=this.rowlist.get(i).head.next;
            for (int j = 0; j < this.columns; j++) {
                if (p!=null&&j==p.data.column){
                    System.out.println(String.format("%4d",p.data.value));
                    p=p.next;
                }
                else System.out.println(String.format("%4d",0));
            }
            System.out.println();
        }
    }
    public void setRowsColumns(int m,int n){
        if (m>0&&n>0){
            if (m>this.rows)
                for (int i = this.rows; i < m; i++) {
                    this.rowlist.insert(new PolySinglyList<Triple>());
                }
            this.rows=m;
            this.columns=n;
        }
        else throw new IllegalArgumentException("矩阵行列数不能小于0，m="+m+",n="+n);
    }
    public void addAll(LinedMatrix mat){
        if (this.rows==mat.rows&&this.columns==mat.columns)
            for (int i = 0; i < this.rows; i++) {
                this.rowlist.get(i).addAll(mat.rowlist.get(i));
            }
        else throw new IllegalArgumentException("两个矩阵阶数不同，不能相加");
    }
    public boolean equals(Object obj){
        if (this==obj)
            return true;
        if (!(obj instanceof LinedMatrix))
            return false;
        LinedMatrix mat=(LinedMatrix)obj;
        return this.rows==mat.rows&&this.columns==mat.columns&&this.rowlist.equals(mat.rowlist);
    }
}
