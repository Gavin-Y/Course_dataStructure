package util.Math.Polynomial;

/**
 * Created by yejiaquan on 2016/10/12.
 */
public class TermX implements Comparable<TermX>,Addible<TermX> {
    protected int coef,xexp;
    public TermX(int coef,int xexp){
        this.coef=coef;
        this.xexp=xexp;
    }

    public TermX(TermX term){
        this.coef=term.coef;
        this.xexp=term.xexp;
    }

    public TermX(String termstr){

    }

    public String toString(){
        if(coef==1&&xexp>1){
            return "x^"+xexp;
        }else if(coef==1&&xexp==1){
            return "x";
        }else if(coef==-1&&xexp==1){
            return "-x";
        }else if(coef==-1&&xexp>1){
            return "-x^"+xexp;
        } else if (xexp==0){
            return coef+"";
        }else if(xexp==1){
            return coef+"x";
        }
        return coef+"x^"+xexp;
    }

    public boolean equals(Object obj) {
        return obj != null && this.toString().equals(obj.toString());
    }

    @Override
    public void add(TermX termX) {
        if(termX.xexp==this.xexp){
            this.coef+=termX.coef;
        }
    }

    @Override
    public boolean removeable() {
        return coef == 0;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     * <p>
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     * <p>
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     * <p>
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     * <p>
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> Interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     * <p>
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(TermX o) {
        if(this.xexp==o.xexp){
            return 0;
        }else if(this.xexp<o.xexp){
            return -1;
        }else{
            return 1;
        }
    }

    public double result(double x){
        return coef*Math.pow(xexp,(double) x);
    }
}
