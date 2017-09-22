package util.Math.NormalDbt;

import java.util.Random;

/**
 * Created by yejiaquan on 2016/11/9.
 */

//正太分布
public class NormalDbt {
    private int a;//均值
    private int b;//方差
    private Random random;

    public NormalDbt(int a, int b){
        this.a=a;
        this.b=b;
        random=new Random();
    }

    public double Next(){
        return Math.sqrt(b)*random.nextGaussian()+a;
    }
}
