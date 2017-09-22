package util.Set;

/**
 * Created by yejiaquan on 2016/11/8.
 */
public class UnionFindSet {
    //起始树的个数
    private int count;
    //储存下一个节点下标
    private int[] id;
    //储存树的长度
    private int[] size;

    public UnionFindSet(int n) {
        this.count = n;
        this.id = new int[n];
        this.size = new int[n];

        for (int i = 0; i < this.count; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    //查找到这棵树的最后
    private int find(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    //检查是否回路，若无则合并
    public boolean union(int p, int q) {
        int pCom = this.find(p);
        int qCom = this.find(q);

        if (pCom == qCom) {
            return false;
        }
        // 按秩进行合并
        if (size[pCom] > size[qCom]) {
            id[qCom] = pCom;
            size[pCom] += size[qCom];
        } else {
            id[pCom] = qCom;
            size[qCom] += size[pCom];
        }
        // 每次合并之后，树的数量减1
        count--;
        return true;
    }

    public int count() {
        return this.count;
    }
}
