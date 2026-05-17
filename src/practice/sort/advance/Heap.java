package practice.sort.advance;

import practice.tree.HeapTree;


public class Heap extends HeapTree {
    public void sort() {
        int originalSize = size; // 暫存 size
        while (size > 1) {
            exchange(0, size - 1); // root 的值放最後，升序或降序要看 compare 方法
            size--;
            siftDown(0);
        }
        size = originalSize; // 還原 size
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

        heap.sort();
        for (var i = 0; i < heap.size; i++) {
            System.out.print(heap.elements[i] + " ");
        }
    }

}
