package util.Queue;

/**
 * Created by yejiaquan on 2016/10/20.
 */
public interface Queue<T> {
    public abstract boolean isEmpty();
    public abstract boolean add(T x);
    public abstract T peek();
    public abstract T poll();
}
