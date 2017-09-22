package util.Math.Complex;

/**
 * Created by yejiaquan on 2016/9/24.
 */
public class test {
    public static void main(String[] args) {
        Complex comD=new Complex(1,2);
        Complex comS=new Complex("2+5i");

        System.out.println(comD.toString());
        System.out.println(comS.toString());

        Complex tmp;

        comD.add(comS);
        System.out.println(comD.toString());

        tmp=comS.sub(comD);
        System.out.println(tmp);

        System.out.println(comD.equals(comS));
    }
}
