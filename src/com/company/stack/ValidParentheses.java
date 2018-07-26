package com.company.stack;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // 如果栈为空 存在任意右括号 一定没有匹配上
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();

                if (c == '}' && topChar != '{')
                    return false;

                if (c == ')' && topChar != '(')
                    return false;

                if (c == ']' && topChar != '[')
                    return false;
            }
        }

        // 如果栈不为空 存在任意左括号 一定没有匹配上
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("{}"));
    }
}
