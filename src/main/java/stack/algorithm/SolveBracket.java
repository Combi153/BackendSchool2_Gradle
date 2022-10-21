package stack.algorithm;

import java.util.Stack;

public class SolveBracket {
    boolean solution(String s) {
        Stack st = new Stack();

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (letter == '(') {
                st.push(letter);
            } else if (letter == ')') {
                if (st.isEmpty()){
                    return false;
                } else{
                    st.pop();
                }
            }
        }
        return st.isEmpty();
    }
}
