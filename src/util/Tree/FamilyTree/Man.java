package util.Tree.FamilyTree;

/**
 * Created by yejiaquan on 2016/10/21.
 */
public class Man implements Comparable<Man>{
    public String name;
    public String mate;
    public Man(){
        this("������");
    }
    public Man(String name){
        this(name,null);
    }
    public Man(String name,String mate){
        this.name=name;
        this.mate=mate;
    }
    public String toString(){
        return this.name;
    }
    public void setMate(String mate){
        this.mate=mate;
    }
    @Override
    public int compareTo(Man o) {
        if(this.name==o.name){
            return 0;
        }
        return 1;
    }
}
