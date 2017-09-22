package util.Tree.FamilyTree;

import util.Tree.BinaryTree.BinaryNode;

/**
 * Created by yejiaquan on 2016/10/21.
 */
public class test {
    public static void main(String[] args) {
        BinaryNode<Man> root=new BinaryNode<Man>(new Man("���İְ�","��������"));
        FamilyTree tree=new FamilyTree(root);
        tree.addFather(root,new Man("���İְ�"));
        tree.addMother(root,new Man("��������"));
        System.out.print(tree.searchParents("����"));
    }
}