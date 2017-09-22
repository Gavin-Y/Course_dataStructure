package util.Tree.BinaryTree.Expression;

import util.Tree.BinaryTree.BinaryNode;
import util.Tree.BinaryTree.BinaryTree;

/**
 * Created by yejiaquan on 2016/10/20.
 */
public class ExpressionBinaryTree extends BinaryTree<ExpData>{
    public ExpressionBinaryTree(){
        super();
    }
    public ExpressionBinaryTree(String prefix){
        this.root=createPrefix(prefix);
    }
    private int i=0;
    private BinaryNode<ExpData>createPrefix(String prefix){
        BinaryNode<ExpData>p=null;
        if (i<prefix.length()){
            char ch = prefix.charAt(i);
            if (ch>='0'&&ch<='9'){
                int value=0;
                while (i<prefix.length()&&ch!=' '){
                    value=value*10+ch-'0';
                    i++;
                    if (i<prefix.length())
                        ch=prefix.charAt(i);
                }
                p=new BinaryNode<ExpData>(new ExpData(value,' '));
                i++;
            }else {
                p=new BinaryNode<ExpData>(new ExpData(0,prefix.charAt(i)));
                i++;
                p.left=createPrefix(prefix);
                p.right=createPrefix(prefix);
            }
        }
        return p;
    }
    public int toValue(){
        return this.toValue(this.root);
    }

    private int toValue(BinaryNode<ExpData>p){
        if (p==null)
            return 0;
        if (!p.isLeaf())
            switch (p.data.oper){
                case '+':p.data.value=toValue(p.left)+toValue(p.right);break;
                case '-':p.data.value=toValue(p.left)-toValue(p.right);break;
                case '*':p.data.value=toValue(p.left)*toValue(p.right);break;
                case '/':p.data.value=toValue(p.left)/toValue(p.right);break;
            }
        return p.data.value;
    }

    public static void main(String[] args) {
        String prefix="-+45 *-10 15 /+25 35 -60 40 11";
        ExpressionBinaryTree expressionBinaryTree = new ExpressionBinaryTree(prefix);
        System.out.print("先序：");expressionBinaryTree.preorder();
        System.out.print("中序：");expressionBinaryTree.inorder();
        System.out.print("后序：");expressionBinaryTree.postorder();
        System.out.print("value="+expressionBinaryTree.toValue());
    }
}
