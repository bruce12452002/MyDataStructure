package practice.linear;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * 陣列用頭插或頭取比較麻煩，因為後面的值要往前或往後搬
 */
public class StackWithArray implements Iterable<String> {
    private String[] elements;
    private int size;

    public StackWithArray(int capacity) {
        if (capacity <= 0) {
            throw new EmptyStackException();
        }
        elements = new String[capacity];
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
    public void push(String item) {
        if (size == elements.length) {
            resize(elements.length * 2);
        }
        elements[size++] = item;
    }

    /**
     * 尾取
     */
    public String pop() {
        if (size == 0) {
            return null;
        }
        String result = elements[--size];
        elements[size] = null;

        if (size > 0 && size == elements.length / 4) {
            resize(elements.length / 2);
        }
        return result;
    }

    public String peek() {
        if (size == 0) {
            return null;
        }
        return elements[size - 1];
    }

    private void resize(int capacity) {
        String[] newStackArray = new String[capacity];
        for (int i = 0; i < size; i++) {
            newStackArray[i] = elements[i];
        }
//        System.arraycopy(elements, 0, newStackArray, 0, size);
        elements = newStackArray;
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
            return elements[cursor++];
        }
    }

    public static void main(String[] args) {
        StackWithArray stack = new StackWithArray(3);
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.push("d");
        stack.push("e");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
