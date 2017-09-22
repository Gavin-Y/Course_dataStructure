package util.Graph;

import util.Math.Polynomial.Addible;

/**
 * Created by yejiaquan on 2016/11/2.
 */
public class Triple implements Comparable<Triple>, Addible<Triple> {
    public int row,column,value;
    public Triple(int row,int column,int value){
        if (row>=0&&column>=0){
            this.row=row;
            this.column=column;
            this.value=value;
        }
        else throw new IllegalArgumentException("行，列不能为负数：row="+row+"column="+column);
    }
    public Triple(Triple tri){
        this(tri.row,tri.column,tri.value);
    }
    public String toString(){
        return "("+row+","+column+","+value+")";
    }
    @Override
    public int compareTo(Triple tri) {
        if (this.row==tri.row&&this.column==column)
            return 0;
        return (this.row<tri.row||this.row==tri.row&&this.column<tri.column)?-1:1;
    }
//    public boolean equals(Object obj)
    public void add(Triple term){
        if (this.compareTo(term)==0){
            this.value+=term.value;
        }
        else throw new IllegalArgumentException("两项指数不相同，不能相加");
    }

    public boolean removeable(){
        return this.value==0;
    }
    public Triple toSymmetry(){
        return new Triple(this.row,this.column,this.value);
    }
}
