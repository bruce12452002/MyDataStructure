package practice.linear.question;

import practice.linear.StackWithLinkedList;

/**
 *               *
 *            /    \
 *           +      -
 *          / \    / \
 *         1  2   4  3
 *
 *        中序： (1+2)*(4-3)
 *        後序： 12+43-*
 *
 *
 *
 *                   +
 *              /        \
 *             *          /
 *            / \        / \
 *           3  -       6   3
 *             / \
 *            7  5
 *
 *
 *
 *       中序： 3*(7-5)+(6/3)
 *       後序： 375-*63/+
 */
public class ReversePolishNotation {
    /**
     * 遇到四則運算符號就取前兩個數字做運算，然後再放入堆疊
     */
    public static int calc(String[] data) {
        StackWithLinkedList stack = new StackWithLinkedList();
        for (int i = 0; i < data.length; i++) {
            switch (data[i]) {
                case "+" -> {
                    int plusResult = Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(plusResult));
                }
                case "-" -> {
                    int sub2 = Integer.parseInt(stack.pop());
                    int sub1 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(sub1 - sub2));
                }
                case "*" -> {
                    int multiplyResult = Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(multiplyResult));
                }
                case "/" -> {
                    int div2 = Integer.parseInt(stack.pop());
                    int div1 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(div1 / div2));
                }
                default -> stack.push(data[i]);
            }
        }
        return Integer.parseInt(stack.pop());
    }


    public static void main(String[] args) {
        String[] data1 = {"1", "2", "+", "4", "3", "-", "*"};
        String[] data2 = {"3", "7", "5", "-", "*", "6", "3", "/", "+"};
        int result = calc(data1);
        System.out.println(result);
    }
}
