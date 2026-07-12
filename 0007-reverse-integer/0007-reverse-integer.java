class Solution {
    public int reverse(int x) {
        int num = Math.abs(x);
        int count=0;
        while(num>0){
           int rem = num%10;
            if (count > (Integer.MAX_VALUE - rem) / 10) {
                return 0;  
            }
            num= num/10;
            count = count*10 + rem;
        }
        return (x<0) ? (-count) : count;
    }
}