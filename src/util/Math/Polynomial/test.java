package util.Math.Polynomial;

/**
 * Created by yejiaquan on 2016/10/13.
 */
public class test {
    public static void main(String[] args) {
        TermX aterms[]={new TermX(-7,9),new TermX(2,7),new TermX(-9,4),new TermX(1,2),
                new TermX(-1,1),new TermX(2,0)};
//        TermX aterms[]={new TermX(-1,0),new TermX(1,1),new TermX(-1,2),new TermX(10,4),
//                new TermX(-3,8),new TermX(5,10),new TermX(9,11)};
        Polynomial apoly=new Polynomial(aterms);
        Polynomial bpoly=new Polynomial("-1+x-x^2+10x^4-3x^8+5x^10+9x^11");
        System.out.println("A="+apoly.toString()+"\nB="+bpoly.toString());
        Polynomial cpoly=apoly.union(bpoly);
        System.out.println("A+B=C,C="+cpoly.toString());

        System.out.println("A="+apoly.result(3));
        System.out.println("B="+bpoly.result(3));
        System.out.println("C="+cpoly.result(3));
        System.out.println(aterms.toString());
        System.out.println(apoly.toString());
        System.out.println(apoly.equals(aterms));
    }
}
