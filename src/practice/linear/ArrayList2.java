package practice.linear;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * 在 ArrayList1 的基礎上，增加擴容和縮容的功能，影響的方法有兩個 add 方法和 remove 方法
 * 然後會增加擴容的方法 resize
 */
public class ArrayList2 implements Iterable<String> {
    private String[] elements;

    private int size;

    public ArrayList2(int capacity) {
        if (capacity <= 0) {
            throw new EmptyStackException();
        }
        elements = new String[capacity];
    }

    public void clear() {
        IntStream.range(0, size).forEach(i -> elements[i] = null);
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String get(int index) {
        return elements[index];
    }

    public void append(String item) {
        ensureElementsSpace();

        // item 可以塞 null，所以不能用 null 判斷，用 size 判斷
        elements[size++] = item;
    }

    public void insert(int index, String item) {
        checkIndex(index);
        ensureElementsSpace();

        // 移動
        /*  假設 i 是 3，elements.length = 5
         *  elements[5] = elements[4];
         *  elements[4] = elements[3];
         *  elements[3] = item;
         */
        for (int i = size; i > index; i--) { // 如果將 size 改成 elements.length - 1 雖然也可以，但是有可能陣列沒有滿，會變成 null 複製給 null 而產生浪費
            elements[i] = elements[i - 1];
        }

        // 賦值
        elements[index] = item;
        size++;
    }

    public String remove(int index) {
        checkIndex(index);

        final String result = elements[index];
        elements[index] = null;

        // 移動
        /*  假設 i 是 3，elements.length = 5
         *  elements[3] = elements[4];
         *  elements[4] = elements[5];
         */
        for (int i = index; i < size - 1; i++) { // 如果將 size - 1 改成 elements.length - 1 雖然也可以，但是有可能陣列沒有滿，會變成 null 複製給 null 而產生浪費
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null; // 可寫可不寫，因為跑迴圈時，判斷到 size 的長度而已

        size--;

        // 縮容
        if (size > 0 && size < elements.length / 4) { // 如果元素數量小於陣列的 1/4 就縮容，必免空間浪費
            resize(elements.length / 2); // 縮容一半
        }

        return result;
    }

    public int indexOf(String item) {
        for (int i = 0; i < elements.length; i++) {
//            if (item == null) {
//                if (elements[i] == null) {
//                    return i;
//                }
//            } else {
//                if (item.equals(elements[i])) {
//                    return i;
//                }
//            }

            // 以上的 if-else 可簡化成以下的寫法
            if (Objects.equals(item, elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public int length() {
        return size;
    }

    public void resize(int newSize) {
        String[] newElements = new String[newSize];

        for (int i = 0; i < size; i++) { // 如果 size 改成 elements.length，縮容時會 ArrayIndexOutOfBoundsException
            newElements[i] = elements[i];
        }

        elements = newElements;
    }

    public void reverseArray() {
        if (size <= 1) {
            return;
        }

        // 如果值是 null 也要倒轉
//        for (int i = 0, j = elements.length - 1; i < elements.length / 2; i++, j--) {
//            String temp = elements[i];
//            elements[i] = elements[j];
//            elements[j] = temp;
//        }

        for (int i = 0, j = size - 1; i < size / 2; i++, j--) {
            String temp = elements[i];
            elements[i] = elements[j];
            elements[j] = temp;
        }
    }

    private void checkIndex(int index) {
        if (index > elements.length - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException("超出索引值，無法刪除");
        }
    }

    /**
     * 確保有空間可以塞值
     */
    private void ensureElementsSpace() {
        if (size == elements.length) {
            resize(2 * elements.length);
        }
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
        ArrayList2 list = new ArrayList2(5);
        list.append("a");
        list.append("b");
        list.append("c");
        list.append("d");
        list.append("e");
        list.append("f");

        list.remove(0);
        list.remove(1);

        for (int i = 0; i < list.length(); i++) {
            System.out.print(list.elements[i] + " "); // b d e f
        }
        System.out.println();

        list.reverseArray();
        System.out.println(Arrays.toString(list.elements));
        System.out.println("==============================");
        list.forEach(System.out::println);
    }
}
