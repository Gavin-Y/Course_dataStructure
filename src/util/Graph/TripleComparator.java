package util.Graph;

/**
 * Created by yejiaquan on 2016/11/3.
 */
public class TripleComparator implements java.util.Comparator<Triple> {
    @Override
    public int compare(Triple t1, Triple t2) {
        return t1.value-t2.value;
    }
}
