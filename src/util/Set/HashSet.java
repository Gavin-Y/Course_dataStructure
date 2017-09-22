package util.Set;

/**
 * Created by yejiaquan on 16/9/15.
 */
public class HashSet<T> implements Set<T>{
    private int size;
    private Object[] arr;

    public HashSet(int length){
        arr=new Object[length];
        this.size=0;
    }

    public HashSet(){
        this(10);
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T search(T key) {
        if(key==null||this.isEmpty())
            return null;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=null&&(arr[i]==key||arr[i].equals(key))) {
                return (T) arr[i];
            }
        }
        return null;
    }

    @Override
    public boolean contains(T key) {
        if (key==null||this.isEmpty())
            return false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=null&&(arr[i]==key||arr[i].equals(key))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(T x) {
        if (x==null)
            return false;
        if(this.contains(x))
            return false;
        if(this.size()==arr.length){
            Object[] newArr=new Object[2*arr.length];
            System.arraycopy(arr,0,newArr,0,arr.length);
            arr=newArr;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==null){
                arr[i]=x;
                size++;
                return true;
            }
        }
        return false;
    }

    @Override
    public T remove(T key) {
        if (key==null)
            return null;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=null&&(arr[i]==key||arr[i].equals(key))){
                T tmp;
                tmp=(T)arr[i];
                arr[i]=null;
                size--;
                return tmp;
            }
        }
        return null;
    }

    @Override
    public void clear() {
        for (int i = 0; i < arr.length; i++) {
            arr[i]=null;
        }
        this.size=0;
    }

    @Override
    public String toString() {
        String str="ALL";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=null){
                str+=":"+arr[i];
            }
        }
        return str;
    }

    @Override
    public Object[] toArray() {
        Object[] copyArr=new Object[size];
        int j=0;
        for (Object anArr : arr) {
            if(anArr!=null){
                copyArr[j]=anArr;
                j++;
            }
        }
        return copyArr;
    }

    @Override
    public boolean containsAll(Set<?> set) {
        int num=set.size();
        Object[] newSet=set.toArray();
        for (Object aNewSet : newSet) {
            if (this.contains((T) aNewSet)) {
                num--;
            }
        }
        return num == 0;
    }

    @Override
    public boolean addAll(Set<? extends T> set) {
        Object[] newSet=set.toArray();
        for (Object aNewSet : newSet) {
            this.add((T)aNewSet);
        }
        return true;
    }

    @Override
    public boolean removeAll(Set<T> set) {
        Object[] newSet=set.toArray();
        for (Object aNewSet : newSet) {
            this.remove((T) aNewSet);
        }
        return true;
    }

    @Override
    public boolean retainAll(Set<T> set) {
        for (Object anArr : arr) {
            if (!set.contains((T) anArr)) {
                this.remove((T) anArr);
            }
        }
        return true;
    }

    public boolean union(int row,int col){

        return true;
    }
}
