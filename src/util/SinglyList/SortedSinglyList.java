package util.SinglyList;

/**
 * Created by yejiaquan on 2016/10/12.
 */
public class SortedSinglyList<T extends Comparable<? super T>> extends SinglyList{
    public SortedSinglyList(){
        super();
    }
    public SortedSinglyList(T[]values){
        super();
        for (T value : values) {
            this.insert(value);
        }
    }
    public SortedSinglyList(SortedSinglyList<T>list){
        super(list);
    }
    public SortedSinglyList(SinglyList<T>list){
        super();
        for (Node<T> p=list.head.next;p!=null;p=p.next){
            this.insert(p.data);
        }
    }
    public void set(int i,T x){
        throw new java.lang.UnsupportedOperationException("set(int i,T x)");
    }
    public Node<T>insert(int i,T x){
        throw new UnsupportedOperationException("insert(int i,T x)");
    }
    public Node<T>insert(T x){
        if (x==null)
            return null;
        Node<T>front=this.head,p=front.next;
        while (p!=null&& x.compareTo(p.data) > 0){
            front=p;
            p=p.next;
        }
        front.next=new Node<T>(x,p);
        return front.next;
    }
    public Node<T>search(T key){
        Node<T>p=this.head.next;
        while(p!=null){
            if(p.data.compareTo(key)==0)
                return p;
        }
        return null;
    }

    public  Node<T>insertDifferent(T x){
        if(search(x)!=null){
            return insert(x);
        }
        return null;
    }

    public T remove(T key){
        Node<T>p=this.head;
        while(p.next!=null) {
            if (p.next.data.compareTo(key) == 0){
                T old = p.next.data;
                p.next = p.next.next;
                return old;
            }
            p = p.next;
        }
        return null;
    }

    public void addAll(SinglyList<T> list){
        for (int i = 0; i < list.size(); i++) {
            this.insert(list.get(i));
        }
    }
}
