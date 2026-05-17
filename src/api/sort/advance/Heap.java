package api.sort.advance;

import api.tree.HeapTree;


public class Heap extends HeapTree {
    public void sort() {
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.add("c");
        heap.add("d");
        heap.add("a");
        heap.add("f");
        heap.add("e");
        heap.add("b");

        heap.add("i");
        heap.add("f");
        heap.add("h");
        heap.add("b");
        heap.add("g");
        heap.add("f");

    }

}
