package util.Tree.ThreadBinaryTree;

/**
 * Created by yejiaquan on 2016/10/21.
 */
public class ThreadBinaryTree<T> {
    public ThreadNode<T> root;
    public ThreadBinaryTree(){

    }
    public ThreadBinaryTree(T[]prelist){
        this.root=create(prelist);
        inorderThread(this.root);
    }
    private int i=0;
    private ThreadNode<T>create(T[]prelist){
        ThreadNode<T>p=null;
        if (i<prelist.length){
            T elem=prelist[i];
            i++;
            if (elem!=null){
                p=new ThreadNode<T>(elem);
                p.left=create(prelist);
                p.right=create(prelist);
            }
        }
        return p;
    }
    private ThreadNode<T>front=null;
    private void inorderThread(ThreadNode<T>p) {
        if(p!=null){
            inorderThread(p.left);
            if (p.left==null){
                p.ltag=true;
                p.left=front;
            }
            if (p.right==null)
                p.rtag=true;
            if (front!=null&&front.rtag)
                front.right=p;
            inorderThread(p.right);
        }
    }
    public ThreadNode<T>inNext(ThreadNode<T>p){
        if (p.rtag)
            return p.right;
        p=p.right;
        while (!p.ltag)
            p=p.left;
        return p;
    }
    public void inorder(){

    }
    public ThreadNode<T>inPrev(ThreadNode<T>p){
        return null;
    }
    public ThreadNode<T>preNext(ThreadNode<T>p){
        if (!p.ltag)
            return p.left;
        while (p.rtag&&p.right!=null)
            p=p.right;
        return p.right;
    }
    public void preoeder(){

    }
    public ThreadNode<T>postPrev(ThreadNode<T>p){
        return null;
    }
    public void postorderPrevious(){

    }
    public boolean isEmpty(){
        return this.root==null;
    }
}
