package util.Tree.BinaryTree.Expression;

/**
 * Created by yejiaquan on 2016/10/20.
 */
public class ExpData implements Comparable<ExpData>{
    public int value;
    public char oper;
    public ExpData(int value,char oper){
        this.value=value;
        this.oper=oper;
    }
    public String toString (){
        return this.oper == ' ' ? this.value + "" : this.oper + "";
    }

    @Override
    public int compareTo(ExpData o) {
        return 0;
    }
}
