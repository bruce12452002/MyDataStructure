package practice.linear;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.IntStream;

public class ArrayList1 implements Iterable<String> {
    private String[] elements;

    private int size;

    public ArrayList1(int capacity) {
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
        if (size == elements.length) {
            throw new ArrayIndexOutOfBoundsException("超出索引值，無法新增");
        }

        // item 可以塞 null，所以不能用 null 判斷，用 size 判斷
        elements[size++] = item;
    }

    public void insert(int index, String item) {
        if (size == elements.length || index > elements.length - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException("超出索引值，無法新增");
        }

        // 移動
        /*  假設 i 是 3，elements.length = 5
         *  elements[5] = elements[4];
         *  elements[4] = elements[3];
         *  elements[3] = item;
         */
        for (int i = size; i > index; i--) { // 如果將 size 改成 elements.length - 1 雖然也可以，但是有可能陣列沒有滿，會變成 null 複製給 null 而產生浪費
            elements[i] = elements[i - 1]; // 右移
        }

        // 賦值
        elements[index] = item;
        size++;
    }

    public String remove(int index) {
        if (index > elements.length - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException("超出索引值，無法刪除");
        }

        final String result = elements[index];
        elements[index] = null;

        // 移動
        /*  假設 i 是 3，elements.length = 5
         *  elements[3] = elements[4];
         *  elements[4] = elements[5];
         */
        for (int i = index; i < size - 1; i++) { // 如果將 size - 1 改成 elements.length - 1 雖然也可以，但是有可能陣列沒有滿，會變成 null 複製給 null 而浪費
            elements[i] = elements[i + 1]; // 左移
        }
        elements[size - 1] = null; // 可寫可不寫，因為跑迴圈時，判斷到 size 的長度而已

        size--;
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

    private int length() {
        return size;
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
        ArrayList1 list = new ArrayList1(5);
        list.append("a");
        list.append("b");

        System.out.println(list.length()); // 2
        list.clear();
        System.out.println(list.length()); // 0
        list.append("b");
        System.out.println(list.length()); // 1
        list.insert(0, "a");
        System.out.println(list.length()); // 2

        System.out.println(list.indexOf("b")); // 1
        list.append("c");
        list.append(null);
        list.append("e");
        System.out.println(list.remove(1)); // b

        System.out.println(list.length()); // 4
        System.out.println(list.indexOf(null)); // 2

        for (int i = 0; i < list.length(); i++) {
            System.out.print(list.elements[i] + " "); // a c null e
        }
        System.out.println("==============================");
        for (String str : list) {
            System.out.println(str);
        }
    }
}
