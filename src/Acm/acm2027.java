package Acm;

import java.util.Scanner;
public class acm2027 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        kb.nextLine();
        for(int j = 0;j < n;j++){
            String s = kb.nextLine();
            char[] x = s.toCharArray();
            int a    = 0;
            int i    = 0;
            int o    = 0;
            int u    = 0;
            int e    = 0;
            for(int k = 0;k < x.length;k++){
                if(x[k]=='a'){
                    a++;
                }else if(x[k]=='i'){
                    i++;
                }else if(x[k]=='o'){
                    o++;
                }else if(x[k]=='u'){
                    u++;
                }else if(x[k]=='e'){
                    e++;
                }
            }
            System.out.println("a:"+a);
            System.out.println("e:"+e);
            System.out.println("i:"+i);
            System.out.println("o:"+o);
            System.out.println("u:"+u);
            if(j!=n-1){
                System.out.println();
            }
        }
    }
}
