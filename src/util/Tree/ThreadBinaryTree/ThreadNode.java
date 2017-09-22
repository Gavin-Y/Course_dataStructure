package util.Tree.ThreadBinaryTree;

/**
 * Created by yejiaquan on 2016/10/21.
 */
public class ThreadNode<T> {
    public T data;
    public ThreadNode<T>left,right;
    public boolean ltag,rtag;

    public ThreadNode(T data,ThreadNode<T>left,boolean ltag,ThreadNode<T>right,boolean rtag){
        this.data=data;
        this.left=left;
        this.ltag=ltag;
        this.right=right;
        this.rtag=rtag;
    }
    public ThreadNode(T data){
        this(data,null,false,null,false);
    }
    public String toString(){
        return this.data.toString();
    }
    public boolean isLeaf(){
        return false;
    }
}
