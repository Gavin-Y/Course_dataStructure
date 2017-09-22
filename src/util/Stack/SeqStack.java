package util.Stack;

import util.SeqList.SeqList;

/**
 * Created by yejiaquan on 2016/10/15.
 */
public class SeqStack<T> implements Stack<T> {
    private SeqList<T>list;
    public SeqStack(int length){
        this.list=new SeqList<T>(length);
    }
    public SeqStack(){
        this(64);
    }
    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public void push(T x) {
        this.list.insert(x);
    }

    @Override
    public T peek() {
        return this.list.get(list.size()-1);
    }

    @Override
    public T pop() {
        return this.list.remove(list.size()-1);
    }
}
