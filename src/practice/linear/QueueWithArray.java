package practice.linear;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 尾插頭取和頭插尾取都能做到，但尾插頭取比較直覺
 * 使用 head tail 兩個指針可以解決移動值的問題
 */
public class QueueWithArray implements Iterable<String> {
    private String[] elements;
    private int size;
    private int head;
    private int tail;

    public QueueWithArray() {
        elements = new String[10];
    }

    public int length() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 尾插
     */
    public void enqueue(String item) {
        if (size == elements.length) {
            resize(elements.length * 2);
        }
        elements[tail] = item;
        tail = (tail + 1) % elements.length; // 環形移動
        size++;
    }

    /**
     * 頭取
     */
    public String dequeue() {
        if (size == 0) {
            return null;
        }

        String result = elements[head];
        elements[head] = null; // 幫助 GC
        head = (head + 1) % elements.length; // 環形移動
        size--;

        if (elements.length > 10 && size <= elements.length / 4) {
            resize(elements.length / 2);
        }
        return result;
    }

    public String peek() {
        if (size == 0) {
            return null;
        }
        return elements[head];
    }

    private void resize(int capacity) {
        String[] newArray = new String[capacity];

        // 重新排列成從 0 開始
        for (int i = 0; i < size; i++) {
            newArray[i] = elements[(head + i) % elements.length];
        }
        elements = newArray;
        head = 0;
        tail = size;
    }

    @Override
    public Iterator<String> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<String> {
        private int cursor;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public String next() {
            String result = elements[(head + cursor) % elements.length];
            cursor++;
            return result;
        }
    }

    public static void main(String[] args) {
        QueueWithArray queue = new QueueWithArray();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        queue.enqueue("d");
        queue.enqueue("e");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(Arrays.toString(queue.elements));
        System.out.println("================================");
        for (String str : queue) {
            System.out.println(str);
        }
    }
}
