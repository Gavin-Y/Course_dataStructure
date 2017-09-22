package util.Heap;
import java.util.Arrays;
import java.util.Comparator;

public class Heap<E extends Comparable<E>> {

    private Comparator<E>cmpr;
    private boolean isMin;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private int size;
    private Object[] elementData;

    public Heap() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public Heap(boolean isMin, E[]elementData, Comparator<E>cmpr){
        this();
        this.cmpr=cmpr;
        this.isMin=isMin;
        for (E anElementData : elementData) {
            add(anElementData);
        }
    }

    public boolean add(E element) {
        if(null == element)
            return false;
        gg(size + 1);
        elementData[size++] = element;
        if (isMin) {
            minHeapify();
        }else {
            maxHeapify();
        }
        return true;
    }

    private void minHeapify() {
        int i = size - 1;
        while(i > 0 && compare(elementData[i], elementData[(i-1)/2]) < 0) {
            swap(elementData, i, (i-1)/2);
            i = (i - 1) / 2;
        }
    }

    private void maxHeapify() {
        int i = size - 1;
        while(i > 0 && compare(elementData[i], elementData[(i-1)/2]) > 0) {
            swap(elementData, i, (i-1)/2);
            i = (i - 1) / 2;
        }
    }

    public E remove(int index) {
        if(index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E oldVal = elementData(index);
        removeInternal(index);
        return oldVal;
    }

    private void removeInternal(int index) {
        elementData[index] = elementData[--size];
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        while(left < size && (compare(elementData[index], elementData[left]) > 0
                || compare(elementData[index], elementData[right]) > 0)) {
            if(compare(elementData[left], elementData[right]) < 0) {
                swap(elementData, index, left);
                index = left;
            } else {
                swap(elementData, index, right);
                index = right;
            }
            left = 2 * index + 1;
            right = 2 * index + 2;
        }
    }


    E elementData(int index) {
        return (E) elementData[index];
    }

    private int compare(Object a, Object b) {
        if (cmpr!=null){
            return cmpr.compare((E)a,(E)b);
        }else {
            return ((E) a).compareTo((E) b);
        }
    }

    public void swap(Object[] o, int a, int b) {
        Object t = o[a];
        o[a] = o[b];
        o[b] = t;
    }

    private void gg(int len) {
        if(elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            len = Math.max(len, 10);
        }
        if(len - elementData.length > 0) {
            int old = elementData.length;
            int New = old*10+old;
            if(New < len) {
                New = len;
            }
            elementData = Arrays.copyOf(elementData, New);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString(){
        String str="";
        for (int i = 0; i < size(); i++) {
            str+=elementData[i].toString()+",";
        }
        return str;
    }
}