package api.linear.question;

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
        return -1;
    }


    public static void main(String[] args) {
        String[] data1 = {"1", "2", "+", "4", "3", "-", "*"};
        String[] data2 = {"3", "7", "5", "-", "*", "6", "3", "/", "+"};
    }
}
