package Acm;

import java.util.*;

/**
 * Created by yejiaquan on 2016/12/9.
 */
public class acm2091 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String m = sc.next();
        while(true){
            if (m.equals("@")){//字符串比较用equals
                break;
            }
            int n = sc.nextInt();
            int tmp = n;
            //除最后一行
            for (int i = 0; i < n - 1 ; i++) {
                //前面的空格
                for (int j = 0; j < tmp - 1; j++) {
                    System.out.printf(" ");
                }
                tmp--;
                //前面的字符
                System.out.printf(m);
                if (i>0) {//第一行除外
                    //中间的空格
                    for (int j = 0; j < 2 * (i - 1) + 1; j++) {
                        System.out.printf(" ");
                    }
                    //后面的字符并换行
                    System.out.println(m);
                }else {
                    System.out.println();
                }
            }
            //最后一行
            for (int i = 0; i < 2 * n - 1; i++) {
                System.out.printf(m);
            }
            System.out.println();
            //两个三角形之间要换行
            if (sc.hasNext()){
                m = sc.next();
                if (m.equals("@")){
                    break;
                }
                System.out.println();
            }
        }
    }
}