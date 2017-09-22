package util.Huffman;

import java.io.Serializable;

/**
 * Created by yejiaquan on 2016/10/27.
 */
public class HuffmanTree implements Serializable {
    private String charset;
    private TriElement[]huftree;
    private int[] weights;
    public HuffmanTree(int[] weights){
        this.charset="";
        this.weights=weights;
        for (int i = 0; i < weights.length; i++) {
            this.charset+=(char)i;
        }
        int n=weights.length;
        this.huftree=new TriElement[2*n-1];
        for (int i = 0; i < n; i++) {
            this.huftree[i]=new TriElement(weights[i]);
        }
        for (int i = n; i < 2 * n - 1; i++) {
            int min1=Integer.MAX_VALUE,min2=min1;
            int x1=-1,x2=-1;
            for (int j = 0; j < i; j++) {
                if (this.huftree[j].parent==-1) {
                    if (this.huftree[j].data < min1) {
                        min2 = min1;
                        x2 = x1;
                        min1 = this.huftree[j].data;
                        x1 = j;
                    } else if (this.huftree[j].data < min2) {
                        min2 = huftree[j].data;
                        x2 = j;
                    }
                }
            }
            this.huftree[x1].parent=i;
            this.huftree[x2].parent=i;
            this.huftree[i]=new TriElement(min1+min2,-1,x1,x2);
        }
    }

    public String getCode(int i){
        int n=16;
        char hufcode[]=new char[n];
        int child=i,parent=this.huftree[child].parent;
        for (i=n-1;parent!=-1;i--){
            hufcode[i]=(huftree[parent].left==child)?'0':'1';
            child=parent;
            parent=huftree[child].parent;
        }
        return new String (hufcode,i+1,n-1-i);
    }
    public String toString (){
//        String str="Huffmans树的节点数组：";
        String str="";
//        for (TriElement aHuftree : this.huftree) {
//            str += aHuftree.toString() + ",";
//        }
//        str+="\nHuffman 编码：";
        for (int i = 0; i < this.charset.length(); i++) {
//            if (weights[i]!=0) {
                str += this.charset.charAt(i) + ":" + weights[i] + ",";
//            }
        }
        return str;
    }
    //凹入表打印
    public void printInvaginat(){
        TriElement tri=null;
        for (TriElement aHuftree : huftree) {
            if (aHuftree.parent == -1) {
                tri = aHuftree;
            }
        }
        printInvaginat(tri,0);
    }
    public void printInvaginat(TriElement tri,int i){
        for (int j = 0; j < i; j++) {
            System.out.print("    ");
        }
        System.out.println(tri.data);
        if (!huftree[tri.left].isLeaf())
            printInvaginat(huftree[tri.left],i+1);
        if (!huftree[tri.right].isLeaf())
            printInvaginat(huftree[tri.right],i+1);
    }
    //数据压缩
    public String encode(String text){
        String compressed="";
        for (int i=0;i<text.length();i++){
            compressed+=getCode(text.charAt(i));
        }
        return compressed;
    }
    //数据解压
    public String decode(String compressed){
        String text="";
        int node=this.huftree.length-1;
        for (int i=0;i<compressed.length();i++){
            if (compressed.charAt(i)=='0'){
                node=huftree[node].left;
            } else{
                node=huftree[node].right;
            }
            if (huftree[node].isLeaf()){
                text+=this.charset.charAt(node);
                node=this.huftree.length-1;
            }
        }
        return text;
    }
}
