package util.Set;

/**
 * Created by yejiaquan on 2016/9/23.
 */
public class test {
    public static void main(String[] args) {
        Set<Integer> set=new HashSet<Integer>(2);
        set.add(2);
        set.add(1);
        set.add(5);
        System.out.println(set.isEmpty());
        System.out.println(set.size());
        System.out.println(set.search(3));
        System.out.println(set.contains(3));
        System.out.println(set.remove(2));
        System.out.println(set.size());
        System.out.println(set.toString());

        Set<Integer> newSet=new HashSet<Integer>(2);
        newSet.add(7);
        newSet.add(6);
        newSet.add(9);
        newSet.add(0);
        newSet.add(5);

        System.out.println(set.containsAll(newSet));
        System.out.println(set.toString());
        System.out.println(set.addAll(newSet));
        System.out.println(set.toString());
        set.clear();
        System.out.println(set.toString());

        System.out.println(set.removeAll(newSet));
        System.out.println(set.toString());
        System.out.println(set.retainAll(newSet));
        System.out.println(set.toString());

    }
}
