class Solution {
        private int sum(int n) {
        int result = 0;
        while (n != 0) {
            int digit = n % 10;
            result += digit * digit;
            n /= 10;
        }
        return result;
    }
    public boolean isHappy(int n) {
     int slow = n;
     int fast = n;
      while(fast !=1){
        slow = sum(slow);
        fast = sum(sum(fast));
        if(slow==fast && slow!=1){
            return false;
        }
      }
      return true;
    }
}