class Solution {
    public boolean isValid(String s) {
        Stack<Character> res=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='{' || s.charAt(i)=='(' || s.charAt(i)=='['){
                res.push(s.charAt(i));
            }
            else if(!res.isEmpty()){
                if(s.charAt(i)=='}' && res.peek()=='{'){
                    res.pop();
                }
                else if(s.charAt(i)==')' && res.peek()=='('){
                    res.pop();
                }
                else if(s.charAt(i)==']' && res.peek()=='['){
                    res.pop();
                }
                else{
                    return false;
                }

            }
            else{
                return false;
            }
        }
        if(res.isEmpty()){
            return true;
        }
        return false;
    }
}