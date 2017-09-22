package util.SinglyList;

/**
 * Created by yejiaquan on 2016/10/12.
 */
public class SinglyList<T> extends Object {
    public Node<T>head;
    public SinglyList(){
        this.head=new Node<T>();
    }
    public SinglyList(T[] values){
        this();
        Node<T>rear=this.head;
        for (T value : values) {
            rear.next = new Node<T>(value, null);
            rear = rear.next;
        }
    }
    public SinglyList(SinglyList<T>list){
        this.head=list.head;
    }
    public boolean isEmpty(){
        return this.head.next==null;
    }
    public T get(int i){
        Node<T>p=this.head.next;
        for (int j=0;p!=null&&j<i;j++){
            p=p.next;
        }
        return (i>=0&&p!=null)?p.data:null;
    }
    public void set(int i,T x){
        Node<T>p=this.head.next;
        for (int j=0;p!=null&&j<i;j++){
            p=p.next;
        }
        p.data=x;
    }
    public int size(){
        Node<T>p=this.head.next;
        int j=0;
        for (;p!=null;j++){
            p=p.next;
        }
        return j;
    }
    public String toString(){
        String str = this.getClass().getName()+"(";
        for (Node<T>p=this.head.next;p!=null;p=p.next){
            str+=p.data.toString();
            if(p.next!=null)
                str+=",";
        }
        return str+")";
    }
    public Node<T> insert(int i,T x){
        if(x==null){
            throw new NullPointerException("x==null");
        }
        Node<T>front=this.head;
        for (int j=0;front.next!=null&&j<i;j++){
            front=front.next;
        }
        front.next=new Node<T>(x,front.next);
        return front.next;
    }
    public Node insert(T x){
        return insert(Integer.MAX_VALUE,x);
    }
    public T remove(int i){
        Node<T>front=this.head;
        for (int j=0;front.next!=null&&j<i;j++){
            front=front.next;
        }
        if(i>=0&&front.next!=null){
            T old=front.next.data;
            front.next=front.next.next;
            return old;
        }
        return null;
    }
    public void clear(){
        this.head.next=null;
    }
    public Node<T>search(T key){
        Node<T>p=this.head.next;
        while(p!=null){
            if(p.data.equals(key))
                return p;
            p=p.next;
        }
        return null;
    }
    public boolean contains(T key){
        return search(key) != null;
    }
    public Node<T>insertDifferent(T x){
        if (!contains(x))
            return insert(x);
        return null;
    }
    public T remove(T key){
        if(contains(key)){
            Node<T>front=this.head;
            while(front.next!=null){
                front=front.next;
                if(front.next.data==key){
                    T old=front.next.data;
                    front.next=front.next.next;
                    return old;
                }
            }
        }
        return null;
    }

    public void reverse(){
        Node<T> front=null;
        Node<T> p=this.head.next;
        Node<T> succ=p.next;
        for (int j=0;p.next!=null;j++){
            p.next=front;
            front=p;
            p=succ;
            succ=succ.next;
        }
        p.next=front;
        this.head.next=p;
    }
}
