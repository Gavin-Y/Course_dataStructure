package util.List;

/**
 * Created by yejiaquan on 2016/9/26.
 */
public interface List<T> {
    boolean isEmpty();
    int size();
    T get(int i);
    void set(int i,T x);
    String toString();
    int insert(int i,T x);
    int insert(T x);
    T remove(int i);
    void clear();
    int search(T key);
    boolean contains(T key);
    int insertDifferent(T x);
    T remove(T key);
    boolean equals(Object obj);
    void addAll(List<T>list);
}
