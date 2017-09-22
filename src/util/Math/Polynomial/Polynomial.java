package util.Math.Polynomial;

import util.SinglyList.Node;
import util.Stack.LinkedStack;

/**
 * Created by yejiaquan on 2016/10/13.
 */
public class Polynomial {
    private PolySinglyList<TermX>list;
    public Polynomial(){
        list=new PolySinglyList<TermX>();
    }
    public Polynomial(TermX terms[]){
        list=new PolySinglyList<TermX>(terms);
    }
    public Polynomial(String polystr){
        this();
        polystr+="+";
        char[]str=polystr.toCharArray();
        LinkedStack<Character> stack=new LinkedStack<Character>();
        LinkedStack<Character> st=new LinkedStack<Character>();
        for (char aStr : str) {
            if (aStr == '-' || aStr == '+') {
                if (stack.isEmpty()) {
                    stack.push(aStr);
                } else {
                    while (!stack.isEmpty()) {
                        char s = stack.pop();
                        st.push(s);
                    }
                    String strs = "";
                    while (!st.isEmpty()) {
                        strs += st.pop();
                    }
                    int x = strs.indexOf("x");
                    int q = strs.indexOf("^");
                    int coef;
                    int xexp;
                    if (q == -1) {
                        if (x == -1) {
                            coef=Integer.parseInt(strs);
                            xexp = 0;
                        } else {
                            xexp = 1;
                            strs=strs.substring(0, x);
                            switch (strs) {
                                case "+":
                                    coef = 1;
                                    break;
                                case "-":
                                    coef = -1;
                                    break;
                                default:
                                    coef = Integer.parseInt(strs);
                                    break;
                            }
                        }
                    } else {
                        String[] strings = strs.split("\\^");
                        x = strings[0].indexOf("x");
                        strings[0]=strings[0].substring(0, x);
                        switch (strings[0]) {
                            case "+":
                                coef = 1;
                                break;
                            case "-":
                                coef = -1;
                                break;
                            default:
                                coef = Integer.parseInt(strings[0]);
                                break;
                        }
                        xexp = Integer.parseInt(strings[1]);
                    }
                    TermX termX=new TermX(coef,xexp);
                    list.insert(termX);
                    stack.push(aStr);
                }
            }else{
                stack.push(aStr);
            }
        }

    }
    public String toString (){
        String str = "";
        for (Node<TermX>p=this.list.head.next;p!=null;p=p.next){
            str+=p.data.toString();
            if(p.next!=null)
                str+="+";
        }
        str = str.replaceAll("\\+\\-","-");
        return str;
    }
    public Polynomial(Polynomial poly){
        this();
        Node<TermX>rear=this.list.head;
        for(Node<TermX>p=poly.list.head.next;p!=null;p=p.next){
            rear.next=new Node<TermX>(new TermX(p.data),null);
            rear=rear.next;
        }
    }
    public void addAll(Polynomial poly){
        list.addAll(poly.list);
    }
    public Polynomial union(Polynomial poly){
        Polynomial cpoly =new Polynomial(this);
        cpoly.addAll(poly);
        return cpoly;
    }
    public boolean equals(Object obj){
        return this.toString().equals(obj.toString());
    }
    public double result(double x){
        double result=0;
        PolySinglyList<TermX>tmp=new PolySinglyList<TermX>(this.list);
        while (!tmp.isEmpty()){
            TermX termX=(TermX) tmp.remove(0);
            result+=termX.result(x);
        }
        return result;
    }
}
