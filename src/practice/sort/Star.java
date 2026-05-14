package practice.sort;

public class Star {
    public static void main(String[] args) {
//        nineMultiplyNine(9);
        digit1(4);
    }

    private static void nineMultiplyNine(int number) {
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number; j++) {
                System.out.print(i + "x" + j + "=" + i * j + "  ");
            }
            System.out.println();
        }
    }

    /**
     * *
     * **
     * ***
     * ****
     */
    private static void start1(int startCount) {
        System.out.println();
        for (int i = 1; i <= startCount; i++) { // 行數
            for (int j = 1; j <= i; j++) { // 星數
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * ****
     * ***
     * **
     * *
     */
    private static void start2(int startCount) {
        System.out.println();
        for (int i = 1; i <= startCount; i++) {// 行數
            for (int j = 1; j <= startCount + 1 - i; j++) { // 星數
                System.out.print(j-1);
            }
            System.out.println();
        }
    }

    /**
     * 0123
     * 012
     * 01
     * 0
     */
    private static void digit1(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size + 1 - i; j++) {
                System.out.print(j - 1);
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    /**
     * 0,1  0,2  0,3  0,4
     * 1,2  1,3  1,4
     * 2,3  2,4
     * 3,4
     */
    private static void digit2(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j <= size; j++) {
                System.out.print(i + "," + j + "  ");
            }
            System.out.println();
        }
    }

    /**
     * 1
     * 21
     * 321
     * 4321
     */
    private static void digit3(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = i; j > 0; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
