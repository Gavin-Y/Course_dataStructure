package util.SinglyList;

/**
 * Created by yejiaquan on 2016/10/12.
 */
public class SinglyList_reverse {
    public static <T>SinglyList<T>createReverse(T[] values){
        return new SinglyList<T>(values);
    }
    public static <T>void reverse(SinglyList<T> list){
        Node<T> front=null;
        Node<T> p=list.head.next;
        Node<T> succ=p.next;
        for (int j=0;p.next!=null;j++){
            p.next=front;
            front=p;
            p=succ;
            succ=succ.next;
        }
        p.next=front;
        list.head.next=p;
    }

    public static void main(String[] args) {
        String[] values ={"A","B","C","D","E","F"};
        SinglyList<String>list=createReverse(values);
        System.out.println("list = "+list.toString());
        reverse(list);
        System.out.println("��ת��\nlist = "+list.toString());
    }
}
