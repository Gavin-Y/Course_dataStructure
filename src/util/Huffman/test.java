package util.Huffman;

/**
 * Created by yejiaquan on 2016/10/30.
 */
public class test {
    public static void main(String[] args) {
        String toBeTran=util.readFileByChars("src/util.Huffman/ToBeTran");
        HuffmanTree huffmanTree =new HuffmanTree(util.getWeight(toBeTran));
        util.writeObject(huffmanTree,"src/util.Huffman/htmTree");
        HuffmanTree tree=(HuffmanTree)util.readObject("src/util.Huffman/htmTree");
        util.writeString(tree.encode(util.readFileByChars("src/util.Huffman/ToBeTran")),"src/util.Huffman/CodeFile");
        util.writeString(tree.decode(util.readFileByChars("src/util.Huffman/CodeFile")),"src/util.Huffman/TextFile");

        util.writeString(tree.toString(),"src/util.Huffman/TreePrint");

        huffmanTree.printInvaginat();
    }
}
