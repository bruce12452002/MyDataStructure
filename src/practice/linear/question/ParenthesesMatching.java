package practice.linear.question;

import practice.linear.StackWithLinkedList;

public class ParenthesesMatching {
    public static boolean isMatch(String data) {
        StackWithLinkedList stack = new StackWithLinkedList();

        for (int i = 0; i < data.length(); i++) {
            String ch = String.valueOf(data.charAt(i));

            if ("(".equals(ch)) {
                stack.push(ch);
            } else if (")".equals(ch)) {
                if (null == stack.pop()) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }


    public static void main(String[] args) {
        final String data = "(蘋果)(香蕉(";
        System.out.println(isMatch(data));
    }
}
