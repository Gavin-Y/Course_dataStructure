package util.Tree.FamilyTree;

import util.Tree.BinaryTree.BinaryNode;
import util.Tree.BinaryTree.BinaryTree;

/**
 * Created by yejiaquan on 2016/10/21.
 */

public class FamilyTree {
    private BinaryTree<Man>tree;
    public FamilyTree(BinaryNode little){
        tree=new BinaryTree<Man>(little);
    }
    public BinaryNode<Man> addMother(BinaryNode<Man> man, Man mather){
        return tree.insert(man,mather,true);
    }
    public BinaryNode<Man> addFather(BinaryNode<Man> man, Man father){
        return tree.insert(man,father,false);
    }
    public String searchParents(String name){
        BinaryNode man=tree.search(new Man(name));
        if(man.right==null||man.left==null){
            return "δ��ѯ���丸ĸ";
        }
        return "ĸ�ף�"+man.left.data+"|���ף�"+man.right.data;
    }
    public String searchPosterity(String name){
//        BinaryNode man=tree.search(new Man(name,true));
//        if(man.right==null||man.left==null){
//            return "δ��ѯ���丸ĸ";
//        }
//        return "ĸ�ף�"+man.left.data+"|���ף�"+man.right.data;
        return null;
    }
    public String toString(){
        return tree.toString();
    }
}
