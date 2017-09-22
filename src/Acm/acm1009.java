package Acm;

import java.util.Scanner;

/**
 * Created by yejiaquan on 2016/11/9.
 */
public class acm1009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();//M磅猫粮
            int n = sc.nextInt();//N个房间
            double temp = 0;
            if (m == -1 && n == -1) break;
            double[] mm = new double[n];
            double[] nn = new double[n];
            double[] bi = new double[n];
            for (int i = 0; i < n; i++) {
                mm[i] = sc.nextDouble();
                nn[i] = sc.nextDouble();
            }
            for (int i = 0; i < n; i++) {
                bi[i] = mm[i] / nn[i];
            }
            for (int i = 0; i < n; i++) {
                for (int k = i ; k < n; k++) {
                    if (bi[i] < bi[k]) {
                        temp = bi[i];
                        bi[i] = bi[k];
                        bi[k] = temp;
                        temp = mm[i];
                        mm[i] = mm[k];
                        mm[k] = temp;
                        temp = nn[i];
                        nn[i] = nn[k];
                        nn[k] = temp;
                    }
                }
            }
            int num = 0;
            double answer = 0;
            while (m >= nn[num]) {
                answer += mm[num];
                m = m - (int) nn[num];
                num++;
                if(num>=n){
                    num--;
                    break;
                }
            }
            answer+=mm[num]*m/nn[num];
            System.out.printf("%.3f\n", answer);
        }
    }
}
