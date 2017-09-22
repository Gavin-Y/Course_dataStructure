package util.SeqList;

/**
 * Created by yejiaquan on 2016/10/15.
 */
public class SeqList<T> extends Object {
    protected Object[] element;
    protected int n;
    public SeqList(int length){
        this.element=new Object[length];
        this.n=0;
    }
    public SeqList(){
        this(64);
    }
    public SeqList(T[]values){
        this(values.length);
        System.arraycopy(values, 0, this.element, 0, values.length);
        this.n=element.length;
    }
    public boolean isEmpty(){
        return this.n==0;
    }
    public int size(){
        return this.n;
    }
    public T get(int i){
        if(i>=0&&i<this.n){
            return (T)this.element[i];
        }
        return null;
    }
    public void set(int i,T x){
        if (x==null)
            throw new NullPointerException("x==null");
        if (i>=0&&i<this.n)
            this.element[i]=x;
        else throw new java.lang.IndexOutOfBoundsException(i+"");
    }
    public String toString(){
//        String str=this.getClass().getName()+"(";
        String str=this.getClass().getName()+"\n";
        if (this.n>0)
            str+=this.element[0].toString();
        for (int i = 1; i <this.n ; i++) {
//            str+=","+this.element[i].toString();
            str+="\n"+this.element[i].toString();
        }
//        return str+")";
        return str;
    }
//    public String toPreviousString(){
//        return "";
//    }
    public int insert(T x){
        return insert(Integer.MAX_VALUE,x);
    }
    public int insert(int i,T x){
        if(x==null)
            throw new NullPointerException("x==null");
        if(i<0)
            i=0;
        if(i>this.n)
            i=this.n;
        Object[]sourse=this.element;
        if(this.n==element.length){
            this.element=new Object[sourse.length*2];
            System.arraycopy(sourse, 0, this.element, 0, i);
        }
        for (int j=this.n-1;j>=i;i--)
            this.element[j+1]=sourse[j];
        this.element[i]=x;
        this.n++;
        return i;
    }
    public T remove(int i){
        if(this.n>0&&i>=0&&i<this.n){
            T old=(T)this.element[i];
            System.arraycopy(this.element, i + 1, this.element, i, this.n - 1 - i);
            this.element[this.n-1]=null;
            this.n--;
            return old;
        }
        return null;
    }
    public Object[] getData(){
        Object[]sourse=new Object[n];
        System.arraycopy(this.element, 0, sourse, 0, n);
        return sourse;
    }
    public void clear(){
        this.n=0;
    }
}
