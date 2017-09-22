package Acm;

import java.util.Scanner;

/**
 * Created by yejiaquan on 2016/12/14.
 */
public class acm1045 {

    int n,x[],count,k=2,max;

    //图
    static int tmp[];

    //构造
    public acm1045(int n){
        this.n=n;
        this.x=new int[n*n];
        this.count=0;
    }

    //回溯法
    protected void backtrack(int i){
        if (i<x.length){
            for (int j = 0; j < this.k; j++) {
                //如果是墙，认为不可走，向下走
                if (tmp[i]==1){
                    this.x[i]=0;
                    //递归并i+1；
                    this.backtrack(i+1);
                    break;
                }
                this.x[i]=j;
                if (j==0||restrict(i)){
                    //递归并i+1；
                    this.backtrack(i+1);
                }
            }
        }else {
            //走到最后
            this.count++;
            this.max();
        }
    }

    //剪枝条件
    protected boolean restrict(int i){
        int x=i/n;//i所处的x坐标
        int y=i%n;//i所处的y坐标
        int count=0;
        //如果在边上
        if (y-1<0)count++;
        if (x-1<0)count++;
        //在本行向前查找
        for (int j = y-1; j >= 0 ; j--) {
            //如果遇到1
            if (this.x[x*n+j]==1)break;
            //如果遇到墙或走到终点
            if (tmp[x*n+j]==1||j==0){
                count++;break;
            }
        }
        //在本列向前查找
        for (int j = x-1; j >= 0 ; j--) {
            //如果遇到1
            if (this.x[n*j+y]==1)break;
            //如果遇到墙或走到终点
            if (tmp[n*j+y]==1||j==0){
                count++;break;
            }
        }
        //如果条件都满足
        return count==2;
    }

    //计算最大存在数
    protected void max(){
        int max=0;
        for (int i = 0; i < this.x.length; i++) {
            if (x[i]!=0) max++;
        }
        if (max>this.max) this.max=max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            if (num==0)break;
            tmp=new int[num*num];
            sc.nextLine();
            //循环输入读取图
            for (int i = 0; i < num ; i++) {
                String str = sc.nextLine();
                for (int j = 0; j < num; j++) {
                    if (".".equals(str.substring(j,j+1)))tmp[i*num+j]=0;
                    else if ("X".equals(str.substring(j,j+1)))tmp[i*num+j]=1;
                }
            }
            acm1045 a = new acm1045(num);
            a.backtrack(0);
            System.out.println(a.max);
        }
    }
}
