package util.Math.Test;

/**
 * Created by yejiaquan on 2016/11/28.
 */
public class test1 {
    public static void main(String[] args) {
        System.out.println(f(4));
    }
    public static int f(int n){
        if (n>2) {
            return (n - 1) * (f(n - 2) + f(n - 1));
        }else{
            return n;
        }
    }
}
