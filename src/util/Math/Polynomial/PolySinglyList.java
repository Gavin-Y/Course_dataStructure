package util.Math.Polynomial;

import util.SinglyList.Node;
import util.SinglyList.SortedSinglyList;

/**
 * Created by yejiaquan on 2016/10/12.
 */
public class PolySinglyList<T extends Comparable<? extends T>&Addible<T>> extends SortedSinglyList{
    public PolySinglyList(){
        super();
    }
    public PolySinglyList(T terms[]){
        super(terms);
    }
    public PolySinglyList(PolySinglyList<T> list){
        Node<T> rear=this.head;
        for(Node<T>p=list.head.next;p!=null;p=p.next){
            rear.next=new Node<T>(p.data,null);
            rear=rear.next;
        }
    }
    public void addAll(PolySinglyList<T>list){
        Node<TermX>front=this.head;
        Node<TermX>p=this.head.next;
        Node<TermX>q=list.head.next;
        while(q!=null&&p!=null) {
            if (p.data.compareTo(q.data) == 0) {
                p.data.coef += q.data.coef;
                if (p.data.coef == 0) {
                    front.next = p.next;
                }else{
                    front=front.next;
                }
                p=p.next;
                q=q.next;
            } else if (p.data.compareTo(q.data) > 0) {
                front = front.next;
                p = p.next;
            } else if (p.data.compareTo(q.data) < 0) {
                this.insert(q.data);
                front=front.next;
                q = q.next;
            }
        }
    }
}
