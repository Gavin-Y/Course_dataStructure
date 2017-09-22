import java.util.*;
import java.io.*;

public class test {

    public static String fun(String s){
        boolean b=true;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='0'&&s.charAt(i)!='.'&&s.charAt(i)!='+'&&s.charAt(i)!='-'){
                b=false;
                break;
            }
        }
        if(b) return "0";
        StringBuffer bu=new StringBuffer(s);
        if(s.charAt(0)!='+'&&s.charAt(0)!='-'){
            for(int i=0;i<bu.length();i++){
                if(bu.charAt(i)=='0'){
                    bu.replace(i, i+1, "");
                    i--;
                }
                else break;
            }
        }
        else{
            for(int i=1;i<bu.length();i++){
                if(bu.charAt(i)=='0'){
                    bu.replace(i, i+1, "");
                    i--;
                }
                else break;
            }
        }
        if(s.contains(".")){
            bu.reverse();
            for(int i=0;i<bu.length();i++){
                if(bu.charAt(i)=='0'){
                    bu.replace(i, i+1, "");
                    i--;
                }
                else break;
            }
            int m=bu.indexOf(".");
            bu.replace(m, m+1, "");
            bu.reverse();
        }
        return bu.toString();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(new BufferedInputStream(System.in));
        while(sc.hasNext()){
            String s1=sc.next();
            String s2=sc.next();
            s1=fun(s1);
            s2=fun(s2);
            if(s1.equals(s2))
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
}