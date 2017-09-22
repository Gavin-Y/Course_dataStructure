package util.SeqList;

/**
 * Created by yejiaquan on 2016/10/18.
 */
public class SeqList_reverse {
    public static <T> SeqList<T> createReverse(T[] values){
        return new SeqList<T>(values);
    }
    public static <T>void reverse(SeqList<T> list){
        Object tmp;
        for (int i = 0; i < list.size()/2; i++) {
            tmp=list.get(i);
            list.set(i,list.get(list.size()-i-1));
            list.set(list.size()-i-1,(T)tmp);
        }
    }
    public static void main(String[] args) {
        String[] values ={"A","B","C","D","E","F"};
        SeqList<String>list=createReverse(values);
        System.out.println("list = "+list.toString());
        reverse(list);
        System.out.println("��ת��\nlist = "+list.toString());
    }
}
