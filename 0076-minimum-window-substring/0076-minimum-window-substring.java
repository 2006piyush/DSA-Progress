class Solution {
    public String minWindow(String s, String t) {
        
        int strfreq[]=new int [256];
        int tfrq[]=new int [256];
        int low=0;
        int ans=Integer.MAX_VALUE;
        int len=0;
        int start=0;

        for(int i=0; i<t.length(); i++){
            tfrq[t.charAt(i)]++;
        }
        for(int high=0; high<s.length(); high++){
            strfreq[s.charAt(high)]++;
            len=high-low+1;
            while(check(strfreq,tfrq) ){
                 len=high-low+1;
                 if(len<ans){
                     ans=len;
                      start=low;
                 }
               
                strfreq[s.charAt(low)]--;
                low++;
               
                ans=Math.min(ans,len);

            }
        }
           if(ans==Integer.MAX_VALUE){
            return "";
           }

          return s.substring(start,start+ans);
    }

    public boolean check(int[] strfreq, int[]tfrq){
        for(int j=0; j<256; j++){
            if(tfrq[j]>strfreq[j]){
                return false;
            }
        }
        return true;
    }
}