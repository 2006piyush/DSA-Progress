// import java.util.ArrayList;
// import java.util.List;
// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> result = new ArrayList<>();
//         backtrack(result, "", 0, 0, n);
//         return result;
//     }
//     private void backtrack(List<String> result, String current, int openCount, int closeCount, int n) {
//         if (openCount == n && closeCount == n) {
//             result.add(current);
//             return;
//         }
//         if (openCount < n) {
//             backtrack(result, current + "(", openCount + 1, closeCount, n);
//         }
//         if (closeCount < openCount) {
//             backtrack(result, current + ")", openCount, closeCount + 1, n);
//         }
//     }
// }

// ********another code*******


class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder temp = new StringBuilder();

        backtrack(result, temp, 0, 0, n);

        return result;
    }

    private void backtrack(List<String> result, StringBuilder temp,
                           int open, int close, int n) {

        if (open == n && close == n) {
            result.add(temp.toString());
            return;
        }

        if (open < n) {
            temp.append('(');
            backtrack(result, temp, open + 1, close, n);
            temp.deleteCharAt(temp.length() - 1);
        }

        if (close < open) {
            temp.append(')');
            backtrack(result, temp, open, close + 1, n);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}