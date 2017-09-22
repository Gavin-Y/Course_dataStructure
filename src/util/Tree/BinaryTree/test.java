package util.Tree.BinaryTree;

/**
 * Created by yejiaquan on 2016/10/19.
 */
public class test {
    public static void main(String[] args) {
        String[]prelist={"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"};
        BinaryTree<String>bitree=new BinaryTree<String>(prelist);
        System.out.println("先根"+bitree.toString());
        System.out.print("中根");bitree.inorder();
        System.out.print("后跟");bitree.postorder();
        bitree.insert(bitree.root.left,"X",true);
        bitree.insert(bitree.root.right,"Y",false);
        bitree.insert("Z");
        System.out.println("先根"+bitree.toString());
        System.out.print("中根");bitree.inorder();
        System.out.print("后跟");bitree.postorder();
        bitree.levelorder();
        System.out.println(bitree.levelNum());
        System.out.println(bitree.size());
//        System.out.println(bitree.height());
    }
}
